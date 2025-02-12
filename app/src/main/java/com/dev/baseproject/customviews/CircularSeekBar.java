package com.dev.baseproject.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.dev.baseproject.R;

public class CircularSeekBar extends View {
    private AudioManager audioManager;
    private Paint circlePaint;
    private int maxVolume;
    private float progress = 0.5f;
    private Paint progressPaint;
    private Drawable thumbDrawable;
    private int touchTolerance = 50;
    private boolean firstTimeDraw = true;
    private int width =0, height = 0;
    private int min = 0;

    public CircularSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
        AudioManager audioManager2 = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        this.audioManager = audioManager2;
        this.maxVolume = audioManager2.getStreamMaxVolume(3);
        setVolumeFromSeekBar();
    }

    private void setVolumeFromSeekBar() {
        setProgress(((float) this.audioManager.getStreamVolume(3)) / ((float) this.audioManager.getStreamMaxVolume(3)));
    }

    public void setProgress(float f) {
        this.progress = f;
        invalidate();
    }

    private void init() {
        Paint paint = new Paint();
        this.circlePaint = paint;
        paint.setColor(ContextCompat.getColor(getContext(), R.color.circletrackcolor));
        this.circlePaint.setStyle(Paint.Style.STROKE);
        this.circlePaint.setStrokeWidth(10.0f);
        Paint paint2 = new Paint();
        this.progressPaint = paint2;
        paint2.setColor(ContextCompat.getColor(getContext(), R.color.circleprogresscolor));
        this.progressPaint.setStyle(Paint.Style.STROKE);
        this.progressPaint.setStrokeWidth(10.0f);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.thumb_circular_wrap);
        this.thumbDrawable = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.thumbDrawable.getIntrinsicHeight());
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(firstTimeDraw){
            width = getWidth() / 2;
            height = getHeight() / 2;
            min = Math.min(width, height) - 40;
            firstTimeDraw = false;
        }
        RectF rectF = new RectF((float) (width - min), (float) (height - min), (float) (width + min), (float) (height + min));
        canvas.drawArc(rectF, 180.0f, 180.0f, false, this.circlePaint);
        float f = this.progress * 180.0f;
        canvas.drawArc(rectF, 180.0f, f, false, this.progressPaint);
        float f2 = (float) min;
        double d = (double) (f + 180.0f);
        float sin = ((float) height) + (f2 * ((float) Math.sin(Math.toRadians(d))));
        canvas.save();
        canvas.translate((((float) width) + (((float) Math.cos(Math.toRadians(d))) * f2)) - ((float) (this.thumbDrawable.getBounds().width() / 2)), sin - ((float) (this.thumbDrawable.getBounds().height() / 2)));
        this.thumbDrawable.draw(canvas);
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int min = Math.min(width, height) - 40;
        float f = x - ((float) width);
        float f2 = y - ((float) height);
        float sqrt = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        int i = this.touchTolerance;
        if (sqrt > ((float) (min + i)) || sqrt < ((float) (min - i))) {
            return false;
        }
        if (motionEvent.getAction() != 2 && motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        updateProgress(x, y);
        return true;
    }

    private void updateProgress(float f, float f2) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int min = Math.min(width, height) - 40;
        float f3 = f - ((float) width);
        float f4 = f2 - ((float) height);
        float sqrt = (float) Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
        int i = this.touchTolerance;
        if (sqrt <= ((float) (min + i)) && sqrt >= ((float) (min - i))) {
            float degrees = (float) Math.toDegrees(Math.atan2((double) f4, (double) f3));
            float f5 = 0.0f;
            if (degrees < 0.0f) {
                degrees += 360.0f;
            }
            float f6 = (degrees - 180.0f) / 180.0f;
            if (f6 >= 0.0f) {
                f5 = f6;
            }
            if (f5 > 1.0f) {
                f5 = 1.0f;
            }
            if(0f < degrees && degrees < 90.0f){
                f5 = 1.0f;
            }
            this.progress = f5;
            if(onProgressChangedListener != null){
                onProgressChangedListener.onProgressChanged(this.progress);
            }

            new Thread(new Runnable() {
                @Override
                public void run() {
                    updateVolume(progress);
                }
            }).start();
            invalidate();
        }
    }

    public void updateVolume(float f) {
        this.audioManager.setStreamVolume(3, (int) (f * ((float) this.maxVolume)), 0);
    }

    public interface OnProgressChangedListener {
        void onProgressChanged(float progress);
    }

    private OnProgressChangedListener onProgressChangedListener;

    public void setOnProgressChangedListener(OnProgressChangedListener listener) {
        this.onProgressChangedListener = listener;
    }

    public float getProgress() {
        return this.progress;
    }
}
