package com.dev.baseproject.customviews.autofit;

/**
 * a textView that is able to self-adjust its font size depending on the min and max size of the font, and its own size.<br></br>
 * code is heavily based on this StackOverflow thread:
 * http://stackoverflow.com/questions/16017165/auto-fit-textview-for-android/21851239#21851239 <br></br>
 * It should work fine with most Android versions, but might have some issues on Android 3.1 - 4.04, as setTextSize will only work for the first time. <br></br>
 * More info here: https://code.google.com/p/android/issues/detail?id=22493 and here in case you wish to fix it: http://stackoverflow.com/a/21851239/878126
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u0001:\u0002?@B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\u000e\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!J(\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0014J(\u0010\'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0014J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\fH\u0016J\u0018\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000fH\u0016J\u0010\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u0007H\u0016J\u0010\u00103\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u000e\u00104\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u00105\u001a\u00020\u0019H\u0016J\u0010\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u00020\fH\u0016J\u0010\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u000fH\u0016J\u0018\u00107\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u000fH\u0016J\u0012\u0010:\u001a\u00020\u00192\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006A"}, d2 = {"Lcom/dev/baseproject/customviews/autofit/AutoResizeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "availableSpaceRect", "Landroid/graphics/RectF;", "initialized", "", "maxLines", "maxTextSize", "", "minTextSize", "sizeTester", "Lcom/dev/baseproject/customviews/autofit/AutoResizeTextView$SizeTester;", "spacingAdd", "spacingMult", "textPaint", "Landroid/text/TextPaint;", "widthLimit", "adjustTextSize", "", "binarySearch", "start", "end", "availableSpace", "getMaxLines", "isValidWordWrap", "c", "", "onSizeChanged", "width", "height", "oldwidth", "oldheight", "onTextChanged", "text", "", "before", "after", "setAllCaps", "allCaps", "setLineSpacing", "add", "mult", "setLines", "lines", "setMaxLines", "setMinTextSize", "setSingleLine", "singleLine", "setTextSize", "size", "unit", "setTypeface", "tf", "Landroid/graphics/Typeface;", "superSetTextSize", "startSize", "Companion", "SizeTester", "app_debug"})
public final class AutoResizeTextView extends androidx.appcompat.widget.AppCompatTextView {
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.RectF availableSpaceRect = null;
    @org.jetbrains.annotations.NotNull()
    private final com.dev.baseproject.customviews.autofit.AutoResizeTextView.SizeTester sizeTester = null;
    private float maxTextSize = 0.0F;
    private float spacingMult = 1.0F;
    private float spacingAdd = 0.0F;
    private float minTextSize = 0.0F;
    private int widthLimit = 0;
    private int maxLines = 0;
    private boolean initialized = false;
    @org.jetbrains.annotations.NotNull()
    private android.text.TextPaint textPaint;
    private static final int NO_LINE_LIMIT = -1;
    @org.jetbrains.annotations.NotNull()
    public static final com.dev.baseproject.customviews.autofit.AutoResizeTextView.Companion Companion = null;
    
    @kotlin.jvm.JvmOverloads()
    public AutoResizeTextView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyle) {
        super(null);
    }
    
    public final boolean isValidWordWrap(char c) {
        return false;
    }
    
    @java.lang.Override()
    public void setAllCaps(boolean allCaps) {
    }
    
    @java.lang.Override()
    public void setTypeface(@org.jetbrains.annotations.Nullable()
    android.graphics.Typeface tf) {
    }
    
    @java.lang.Override()
    public void setTextSize(float size) {
    }
    
    @java.lang.Override()
    public void setMaxLines(int maxLines) {
    }
    
    @java.lang.Override()
    public int getMaxLines() {
        return 0;
    }
    
    @java.lang.Override()
    public void setSingleLine() {
    }
    
    @java.lang.Override()
    public void setSingleLine(boolean singleLine) {
    }
    
    @java.lang.Override()
    public void setLines(int lines) {
    }
    
    @java.lang.Override()
    public void setTextSize(int unit, float size) {
    }
    
    @java.lang.Override()
    public void setLineSpacing(float add, float mult) {
    }
    
    /**
     * Set the lower text size limit and invalidate the view
     */
    @kotlin.Suppress(names = {"unused"})
    public final void setMinTextSize(float minTextSize) {
    }
    
    private final void adjustTextSize() {
    }
    
    private final void superSetTextSize(int startSize) {
    }
    
    private final int binarySearch(int start, int end, com.dev.baseproject.customviews.autofit.AutoResizeTextView.SizeTester sizeTester, android.graphics.RectF availableSpace) {
        return 0;
    }
    
    @java.lang.Override()
    protected void onTextChanged(@org.jetbrains.annotations.NotNull()
    java.lang.CharSequence text, int start, int before, int after) {
    }
    
    @java.lang.Override()
    protected void onSizeChanged(int width, int height, int oldwidth, int oldheight) {
    }
    
    @kotlin.jvm.JvmOverloads()
    public AutoResizeTextView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public AutoResizeTextView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/dev/baseproject/customviews/autofit/AutoResizeTextView$Companion;", "", "()V", "NO_LINE_LIMIT", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/dev/baseproject/customviews/autofit/AutoResizeTextView$SizeTester;", "", "onTestSize", "", "suggestedSize", "availableSpace", "Landroid/graphics/RectF;", "app_debug"})
    static abstract interface SizeTester {
        
        /**
         * @param suggestedSize  Size of text to be tested
         * @param availableSpace available space in which text must fit
         * @return an integer < 0 if after applying `suggestedSize` to
         * text, it takes less space than `availableSpace`, > 0
         * otherwise
         */
        public abstract int onTestSize(int suggestedSize, @org.jetbrains.annotations.NotNull()
        android.graphics.RectF availableSpace);
    }
}