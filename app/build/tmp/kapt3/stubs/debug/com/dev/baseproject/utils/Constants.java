package com.dev.baseproject.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b:\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u0019\n\u0002\b1\n\u0002\u0010\u0007\n\u0002\b1\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0004\u00c3\u0001\u00c4\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0019\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040?\u00a2\u0006\n\n\u0002\u0010B\u001a\u0004\b@\u0010AR\u0019\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00040?\u00a2\u0006\n\n\u0002\u0010B\u001a\u0004\bD\u0010AR\u000e\u0010E\u001a\u00020FX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020HX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020FX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020HX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010a\u001a\u00020b\u00a2\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u000e\u0010e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020FX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0083\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020FX\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020HX\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020FX\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020FX\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u008a\u0001\u001a\u00020FX\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u008b\u0001\u001a\u00020FX\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0092\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0093\u0001\u001a\u00030\u0094\u0001X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0095\u0001\u001a\u00030\u0094\u0001X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0096\u0001\u001a\u00030\u0094\u0001X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0097\u0001\u001a\u00030\u0094\u0001X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0098\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0099\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u009a\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u009b\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u009c\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u009d\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u009e\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u009f\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00a0\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00a1\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00a2\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00a3\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00a4\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00a5\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00a6\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00a7\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00a8\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00a9\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00aa\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00ab\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00ac\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00ad\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00ae\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00af\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00b0\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00b1\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00b2\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00b3\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00b4\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00b5\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u00b6\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040?\u00a2\u0006\u000b\n\u0002\u0010B\u001a\u0005\b\u00b7\u0001\u0010AR\u000f\u0010\u00b8\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00b9\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00ba\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00bb\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00bc\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00bd\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00be\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00bf\u0001\u001a\u00020HX\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00c0\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00c1\u0001\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u00c2\u0001\u001a\u00020HX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00c5\u0001"}, d2 = {"Lcom/dev/baseproject/utils/Constants;", "", "()V", "BANNER_AD_KEY", "", "BANNER_AD_KEY_REAL", "BUNDLE_ANALYTICS_ACCEPT_PRIVACY_AGAIN", "BUNDLE_ANALYTICS_ACCEPT_PRIVACY_FIRST", "BUNDLE_ANALYTICS_ACTIVITY_RATING_CANCEL", "BUNDLE_ANALYTICS_ACTIVITY_RATING_NO", "BUNDLE_ANALYTICS_ACTIVITY_RATING_SHOW", "BUNDLE_ANALYTICS_ACTIVITY_RATING_YES", "BUNDLE_ANALYTICS_CONFIRM_CANCEL_CHECK_INTERNET_DIALOG_AGAIN", "BUNDLE_ANALYTICS_CONFIRM_CANCEL_CHECK_INTERNET_DIALOG_FIRST", "BUNDLE_ANALYTICS_CONFIRM_FEEDBACK_CANCEL", "BUNDLE_ANALYTICS_CONFIRM_FEEDBACK_NO", "BUNDLE_ANALYTICS_CONFIRM_FEEDBACK_SHOW", "BUNDLE_ANALYTICS_CONFIRM_FEEDBACK_YES", "BUNDLE_ANALYTICS_CONFIRM_YES_CHECK_INTERNET_DIALOG_AGAIN", "BUNDLE_ANALYTICS_CONFIRM_YES_CHECK_INTERNET_DIALOG_FIRST", "BUNDLE_ANALYTICS_DIALOG_NOTIFICATION_CANCEL", "BUNDLE_ANALYTICS_DIALOG_NOTIFICATION_DONT_SHOW_AGAIN", "BUNDLE_ANALYTICS_DIALOG_NOTIFICATION_NO_AGAIN", "BUNDLE_ANALYTICS_DIALOG_NOTIFICATION_NO_FIRST", "BUNDLE_ANALYTICS_DIALOG_NOTIFICATION_YES", "BUNDLE_ANALYTICS_DIALOG_RATING_CANCEL", "BUNDLE_ANALYTICS_DIALOG_RATING_NO", "BUNDLE_ANALYTICS_DIALOG_RATING_SHOW", "BUNDLE_ANALYTICS_DIALOG_RATING_YES", "BUNDLE_ANALYTICS_DIALOG_UPDATE_CANCEL", "BUNDLE_ANALYTICS_DIALOG_UPDATE_NO", "BUNDLE_ANALYTICS_DIALOG_UPDATE_YES", "BUNDLE_ANALYTICS_GO_TO_INTRO_2_AGAIN", "BUNDLE_ANALYTICS_GO_TO_INTRO_2_FIRST", "BUNDLE_ANALYTICS_GO_TO_INTRO_3_AGAIN", "BUNDLE_ANALYTICS_GO_TO_INTRO_3_FIRST", "BUNDLE_ANALYTICS_GO_TO_LANGUAGE_AGAIN", "BUNDLE_ANALYTICS_GO_TO_LANGUAGE_FIRST", "BUNDLE_ANALYTICS_GO_TO_SETTING_LANGUAGE_AGAIN", "BUNDLE_ANALYTICS_GO_TO_SETTING_LANGUAGE_FIRST", "BUNDLE_ANALYTICS_GO_TO_SPLASH", "BUNDLE_ANALYTICS_GO_TO_SPLASH_FIRST", "BUNDLE_ANALYTICS_LANGUAGE_ABRIC", "BUNDLE_ANALYTICS_LANGUAGE_CHINA", "BUNDLE_ANALYTICS_LANGUAGE_ENLISH", "BUNDLE_ANALYTICS_LANGUAGE_GERMAN", "BUNDLE_ANALYTICS_LANGUAGE_HINDI", "BUNDLE_ANALYTICS_LANGUAGE_JAPAN", "BUNDLE_ANALYTICS_LANGUAGE_KOREA", "BUNDLE_ANALYTICS_LANGUAGE_PORTUGUESE", "BUNDLE_ANALYTICS_LANGUAGE_RUSSIAN", "BUNDLE_ANALYTICS_LANGUAGE_SPANISH", "BUNDLE_ANALYTICS_LANGUAGE_TURKEY", "BUNDLE_ANALYTICS_LANGUAGE_UKRAIAN", "BUNDLE_ANALYTICS_LANGUAGE_VIETNAM", "BUNDLE_ANALYTICS_RATING_1_HOME", "BUNDLE_ANALYTICS_RATING_2_HOME", "BUNDLE_ANALYTICS_RATING_3_HOME", "BUNDLE_ANALYTICS_RATING_4_HOME", "BUNDLE_ANALYTICS_RATING_5_HOME", "BUNDLE_ANALYTICS_SHOW_CHECK_INTERNET_DIALOG_AGAIN", "BUNDLE_ANALYTICS_SHOW_CHECK_INTERNET_DIALOG_FIRST", "CAMERA", "", "getCAMERA", "()[Ljava/lang/String;", "[Ljava/lang/String;", "CONTACT_PERMISSION", "getCONTACT_PERMISSION", "COUNT_BACK_TO_SHOW_RATING", "", "COUNT_DOWN_TIME", "", "DEFAULT_LOAD_ADS_DISTANCE", "DEFAULT_NATIVE_AD_COUNT", "DEFAULT_WAITING_SHOW_INTER", "EMAIL", "EXPIRED", "GOOGLE_PLAY_URL_APP", "GO_TO_CHOOSE_SOUND_AGAIN", "GO_TO_CHOOSE_SOUND_FIRST", "GO_TO_CREATE_PASSCODE_AGAIN", "GO_TO_CREATE_PASSCODE_FIRST", "GO_TO_HOME_AGAIN", "GO_TO_HOME_FIRST", "GO_TO_HOW_TO_USE_AGAIN", "GO_TO_HOW_TO_USE_FIRST", "GO_TO_PRIVACY_AGAIN", "GO_TO_PRIVACY_FIRST", "GO_TO_RECORD_PASSCODE_AGAIN", "GO_TO_RECORD_PASSCODE_FIRST", "GO_TO_SETTING_AGAIN", "GO_TO_SETTING_FIRST", "GO_TO_SOUND_DETAIL_AGAIN", "GO_TO_SOUND_DETAIL_FIRST", "GO_TO_TEXT_TO_VOICE_AGAIN", "GO_TO_TEXT_TO_VOICE_FIRST", "HEX_LOWERCASE", "", "getHEX_LOWERCASE", "()[C", "HOME_ACTIVE_AGAIN", "HOME_ACTIVE_FIRST", "HOME_CHANGE_VOICE_PASSCODE_AGAIN", "HOME_CHANGE_VOICE_PASSCODE_FIRST", "HOME_CLAP_AGAIN", "HOME_CLAP_FIRST", "HOME_DONT_TOUCH_AGAIN", "HOME_DONT_TOUCH_FIRST", "HOME_POCKET_AGAIN", "HOME_POCKET_FIRST", "HOME_VOICE_AGAIN", "HOME_VOICE_FIRST", "HTS_TAB_COUNT", "INTENT_CLAP_DURATION_COMPLETE", "INTENT_CLAP_STOP_MUSIC", "INTENT_DONT_TOUCH_DURATION_COMPLETE", "INTENT_DONT_TOUCH_STOP_MUSIC", "INTENT_POCKET_DURATION_COMPLETE", "INTENT_POCKET_STOP_MUSIC", "INTENT_SERVICE_EVENT", "INTENT_SHOW_DIALOG_BATTERY", "INTENT_VOICE_DURATION_COMPLETE", "INTENT_VOICE_STOP_MUSIC", "INTRO_NATIVE_DIS", "INTRO_NATIVE_SHOW", "KEY_ANALYTICS_TRACKING", "KEY_COUNT_CLICK_NO_BEFORE", "KEY_LANGUAGE_APP", "LANG_NATIVE_DIS", "LANG_NATIVE_SHOW", "MAIN_REQUEST_INTERNET_CANCEL", "MAIN_REQUEST_INTERNET_NO", "MAIN_REQUEST_INTERNET_YES", "MAX_COUNT_SHOW_RATING", "MIN_DISTANCE_TIME_SHOW_RATING", "MODE_CLAP", "MODE_DONT_TOUCH", "MODE_POCKET", "MODE_VOICE", "NATIVE_AD_KEY", "RECORDPASSCODE_RECORD_VOICE_AGAIN", "RECORDPASSCODE_RECORD_VOICE_FIRST", "RECORDPASSCODE_SAVE_PASSCODE_AGAIN", "RECORDPASSCODE_SAVE_PASSCODE_FIRST", "RECORDPASSCODE_SELECT_LANGUAGE_AGAIN", "RECORDPASSCODE_SELECT_LANGUAGE_FIRST", "SENSITIVITY_DT_FAST", "", "SENSITIVITY_DT_SLOW", "SENSITIVITY_PK_FAST", "SENSITIVITY_PK_SLOW", "SERVICE_CLAP_UPDATE_LOCALE", "SERVICE_DONT_TOUCH_UPDATE_LOCALE", "SERVICE_POCKET_UPDATE_LOCALE", "SERVICE_VOICE_UPDATE_LOCALE", "SETTING_ALERT_SOUND_DETAIL_SHOW", "SETTING_CONFIRM_SAVE_SHOW", "SETTING_FEEDBACK_AGAIN", "SETTING_FEEDBACK_FIRST", "SETTING_LANGUAGE_AGAIN", "SETTING_LANGUAGE_FIRST", "SETTING_PRIVACY_AGAIN", "SETTING_PRIVACY_FIRST", "SETTING_RADIO_CLICK_AGAIN", "SETTING_RADIO_CLICK_FIRST", "SETTING_RATEUS_AGAIN", "SETTING_RATEUS_FIRST", "SOUND_DETAIL_APPLY_AGAIN", "SOUND_DETAIL_APPLY_FIRST", "SOUND_DETAIL_PLAY_AGAIN", "SOUND_DETAIL_PLAY_FIRST", "SOUND_DETAIL_SWITCH_FLASH_AGAIN", "SOUND_DETAIL_SWITCH_FLASH_FIRST", "SOUND_DETAIL_SWITCH_SOUND_AGAIN", "SOUND_DETAIL_SWITCH_SOUND_FIRST", "SOUND_DETAIL_SWITCH_VIBRATE_AGAIN", "SOUND_DETAIL_SWITCH_VIBRATE_FIRST", "SOUND_DETAIL_VOICE_MAX_AGAIN", "SOUND_DETAIL_VOICE_MAX_FIRST", "SOUND_DETAIL_VOICE_MUTE_AGAIN", "SOUND_DETAIL_VOICE_MUTE_FIRST", "STORAGE_PERMISSION", "getSTORAGE_PERMISSION", "SUBJECT_EMAIL", "TEXT_TO_VOICE_LISTEN_AGAIN", "TEXT_TO_VOICE_LISTEN_FIRST", "TEXT_TO_VOICE_SAVE_PASSCODE_AGAIN", "TEXT_TO_VOICE_SAVE_PASSCODE_FIRST", "TEXT_TO_VOICE_SELECT_LANGUAGE_AGAIN", "TEXT_TO_VOICE_SELECT_LANGUAGE_FIRST", "TIME_DELAY_SPLASH_MAX", "URL_POLICY", "VALUE_ANALYTICS_TRACKING", "VALUE_DURATION_LOOP", "Pocket", "PreferencesKey", "app_debug"})
public final class Constants {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] CONTACT_PERMISSION = {"android.permission.WRITE_CONTACTS", "android.permission.READ_CONTACTS"};
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] STORAGE_PERMISSION = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] CAMERA = {"android.permission.CAMERA"};
    public static final long DEFAULT_WAITING_SHOW_INTER = 15L;
    public static final long DEFAULT_LOAD_ADS_DISTANCE = 20L;
    public static final int DEFAULT_NATIVE_AD_COUNT = 10;
    public static final long TIME_DELAY_SPLASH_MAX = 9000L;
    public static final int COUNT_BACK_TO_SHOW_RATING = 0;
    public static final int MAX_COUNT_SHOW_RATING = 5;
    public static final long MIN_DISTANCE_TIME_SHOW_RATING = 86400000L;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_LANGUAGE_APP = "language_app";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BANNER_AD_KEY = "ca-app-pub-3940256099942544/2014213617";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BANNER_AD_KEY_REAL = "ca-app-pub-3940256099942544/2014213617";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_ANALYTICS_TRACKING = "KEY_ANALYTICS_TRACKING";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String VALUE_ANALYTICS_TRACKING = "tracking_flow";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NATIVE_AD_KEY = "ca-app-pub-3940256099942544/2247696110";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String INTRO_NATIVE_DIS = "INTRO_NATIVE_DIS";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String INTRO_NATIVE_SHOW = "INTRO_NATIVE_SHOW";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GOOGLE_PLAY_URL_APP = "https://play.google.com/store/apps/details?id=";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String URL_POLICY = "https://sites.google.com/view/higherstusioclaptofindphone";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EMAIL = "khanhhigher@gmail.com";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SUBJECT_EMAIL = "Feedback Find Phone By Clap, Voice - 1.0.9";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_COUNT_CLICK_NO_BEFORE = "click_no_before";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_GO_TO_SETTING_LANGUAGE_FIRST = "GO_TO_SETTING_LANGUAGE_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_GO_TO_SETTING_LANGUAGE_AGAIN = "GO_TO_SETTING_LANGUAGE_AGAIN";
    public static final int MODE_CLAP = 1;
    public static final int MODE_VOICE = 2;
    public static final int MODE_DONT_TOUCH = 3;
    public static final int MODE_POCKET = 4;
    public static final float SENSITIVITY_PK_FAST = 10.0F;
    public static final float SENSITIVITY_PK_SLOW = 9.7F;
    public static final float SENSITIVITY_DT_FAST = 5.0F;
    public static final float SENSITIVITY_DT_SLOW = 2.0F;
    public static final long VALUE_DURATION_LOOP = -1L;
    public static final int HTS_TAB_COUNT = 4;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String INTENT_CLAP_STOP_MUSIC = "com.dev.baseproject.clap.STOP_MUSIC";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String INTENT_CLAP_DURATION_COMPLETE = "com.dev.baseproject.clap.DURATION_COMPLETE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String INTENT_VOICE_STOP_MUSIC = "com.dev.baseproject.voice.STOP_MUSIC";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String INTENT_VOICE_DURATION_COMPLETE = "com.dev.baseproject.voice.DURATION_COMPLETE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String INTENT_DONT_TOUCH_STOP_MUSIC = "com.dev.baseproject.donttouch.STOP_MUSIC";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String INTENT_DONT_TOUCH_DURATION_COMPLETE = "com.dev.baseproject.donttouch.DURATION_COMPLETE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String INTENT_POCKET_STOP_MUSIC = "com.dev.baseproject.pocket.STOP_MUSIC";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String INTENT_POCKET_DURATION_COMPLETE = "com.dev.baseproject.pocket.DURATION_COMPLETE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SERVICE_CLAP_UPDATE_LOCALE = "com.dev.baseproject.clap.UPDATE_LOCALE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SERVICE_VOICE_UPDATE_LOCALE = "com.dev.baseproject.voice.UPDATE_LOCALE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SERVICE_DONT_TOUCH_UPDATE_LOCALE = "com.dev.baseproject.donttouch.UPDATE_LOCALE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SERVICE_POCKET_UPDATE_LOCALE = "com.dev.baseproject.pocket.UPDATE_LOCALE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String INTENT_SERVICE_EVENT = "com.dev.baseproject.service.SERVICE_EVENT";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String INTENT_SHOW_DIALOG_BATTERY = "com.dev.baseproject.service.SHOW_DIALOG_BATTERY";
    public static final long COUNT_DOWN_TIME = 10000L;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_ACCEPT_PRIVACY_FIRST = "ACCEPT_PRIVACY_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_ACCEPT_PRIVACY_AGAIN = "ACCEPT_PRIVACY_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_SHOW_CHECK_INTERNET_DIALOG_FIRST = "SHOW_CHECK_INTERNET_DIALOG_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_SHOW_CHECK_INTERNET_DIALOG_AGAIN = "SHOW_CHECK_INTERNET_DIALOG";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_CONFIRM_YES_CHECK_INTERNET_DIALOG_FIRST = "CONFIRM_YES_CHECK_INTERNET_DIALOG_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_CONFIRM_YES_CHECK_INTERNET_DIALOG_AGAIN = "CONFIRM_YES_CHECK_INTERNET_DIALOG";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_CONFIRM_CANCEL_CHECK_INTERNET_DIALOG_FIRST = "CONFIRM_CANCEL_CHECK_INTERNET_DIALOG_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_CONFIRM_CANCEL_CHECK_INTERNET_DIALOG_AGAIN = "CONFIRM_CANCEL_CHECK_INTERNET_DIALOG";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_GO_TO_SPLASH_FIRST = "GO_TO_SPLASH_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_GO_TO_INTRO_2_FIRST = "GO_TO_INTRO_2_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_GO_TO_INTRO_2_AGAIN = "GO_TO_INTRO_2_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_GO_TO_INTRO_3_FIRST = "GO_TO_INTRO_3_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_GO_TO_INTRO_3_AGAIN = "GO_TO_INTRO_3_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_GO_TO_LANGUAGE_FIRST = "GO_TO_LANGUAGE_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_GO_TO_LANGUAGE_AGAIN = "GO_TO_LANGUAGE_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_GO_TO_SPLASH = "GO_TO_SPLASH";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_DIALOG_UPDATE_YES = "DIALOG_UPDATE_YES";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_DIALOG_UPDATE_NO = "DIALOG_UPDATE_NO";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_DIALOG_UPDATE_CANCEL = "DIALOG_UPDATE_CANCEL";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_LANGUAGE_ENLISH = "LANGUAGE_ENLISH";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_LANGUAGE_VIETNAM = "LANGUAGE_VIETNAM";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_LANGUAGE_HINDI = "LANGUAGE_HINDI";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_LANGUAGE_JAPAN = "LANGUAGE_JAPAN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_LANGUAGE_KOREA = "LANGUAGE_KOREA";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_LANGUAGE_CHINA = "LANGUAGE_CHINA";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_LANGUAGE_PORTUGUESE = "LANGUAGE_PORTUGUESE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_LANGUAGE_SPANISH = "LANGUAGE_SPANISH";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_LANGUAGE_GERMAN = "LANGUAGE_GERMAN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_LANGUAGE_RUSSIAN = "LANGUAGE_RUSSIAN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_LANGUAGE_UKRAIAN = "LANGUAGE_UKRAIAN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_LANGUAGE_ABRIC = "LANGUAGE_ABRIC";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_LANGUAGE_TURKEY = "LANGUAGE_TURKEY";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_ACTIVITY_RATING_SHOW = "SERVICE_RATING_SHOW";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_ACTIVITY_RATING_YES = "SERVICE_RATING_YES";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_ACTIVITY_RATING_NO = "SERVICE_RATING_NO";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_ACTIVITY_RATING_CANCEL = "SERVICE_RATING_CANCEL";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_RATING_1_HOME = "RATING_1_HOME";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_RATING_2_HOME = "RATING_2_HOME";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_RATING_3_HOME = "RATING_3_HOME";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_RATING_4_HOME = "RATING_4_HOME";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_RATING_5_HOME = "RATING_5_HOME";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_DIALOG_RATING_YES = "HOME_RATING_YES";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_DIALOG_RATING_NO = "HOME_RATING_NO";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_DIALOG_RATING_CANCEL = "HOME_RATING_CANCEL";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_DIALOG_RATING_SHOW = "HOME_RATING_SHOW";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_CONFIRM_FEEDBACK_SHOW = "HOME_CONFIRM_FEEDBACK_SHOW";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SETTING_CONFIRM_SAVE_SHOW = "SETTING_CONFIRM_SAVE_SHOW";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SETTING_ALERT_SOUND_DETAIL_SHOW = "SETTING_ALERT_SOUND_DETAIL_SHOW";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_CONFIRM_FEEDBACK_YES = "HOME_CONFIRM_FEEDBACK_YES";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_CONFIRM_FEEDBACK_NO = "HOME_CONFIRM_FEEDBACK_NO";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_CONFIRM_FEEDBACK_CANCEL = "HOME_CONFIRM_FEEDBACK_CANCEL";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_DIALOG_NOTIFICATION_DONT_SHOW_AGAIN = "DIALOG_NOTIFICATION_DONT_SHOW";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_DIALOG_NOTIFICATION_YES = "DIALOG_NOTIFICATION_YES";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_DIALOG_NOTIFICATION_NO_FIRST = "DIALOG_NOTIFICATION_NO_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_DIALOG_NOTIFICATION_NO_AGAIN = "DIALOG_NOTIFICATION_NO_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BUNDLE_ANALYTICS_DIALOG_NOTIFICATION_CANCEL = "DIALOG_NOTIFICATION_DONT_SHOW";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SOUND_DETAIL_SWITCH_SOUND_FIRST = "SOUND_DETAIL_SWITCH_SOUND_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SOUND_DETAIL_SWITCH_SOUND_AGAIN = "SOUND_DETAIL_SWITCH_SOUND_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SOUND_DETAIL_SWITCH_VIBRATE_FIRST = "SOUND_DETAIL_SWITCH_VIBRATE_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SOUND_DETAIL_SWITCH_VIBRATE_AGAIN = "SOUND_DETAIL_SWITCH_VIBRATE_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SOUND_DETAIL_SWITCH_FLASH_FIRST = "SOUND_DETAIL_SWITCH_FLASH_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SOUND_DETAIL_SWITCH_FLASH_AGAIN = "SOUND_DETAIL_SWITCH_FLASH_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SOUND_DETAIL_VOICE_MAX_FIRST = "SOUND_DETAIL_VOICE_MAX_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SOUND_DETAIL_VOICE_MAX_AGAIN = "SOUND_DETAIL_VOICE_MAX_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SOUND_DETAIL_VOICE_MUTE_FIRST = "SOUND_DETAIL_VOICE_MUTE_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SOUND_DETAIL_VOICE_MUTE_AGAIN = "SOUND_DETAIL_VOICE_MUTE_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SOUND_DETAIL_PLAY_FIRST = "SOUND_DETAIL_PLAY_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SOUND_DETAIL_PLAY_AGAIN = "SOUND_DETAIL_PLAY_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SOUND_DETAIL_APPLY_FIRST = "SOUND_DETAIL_APPLY_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SOUND_DETAIL_APPLY_AGAIN = "SOUND_DETAIL_APPLY_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SETTING_RADIO_CLICK_FIRST = "SETTING_RADIO_CLICK_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SETTING_RADIO_CLICK_AGAIN = "SETTING_RADIO_CLICK_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SETTING_FEEDBACK_FIRST = "SETTING_FEEDBACK_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SETTING_FEEDBACK_AGAIN = "SETTING_FEEDBACK_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SETTING_RATEUS_FIRST = "SETTING_RATEUS_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SETTING_RATEUS_AGAIN = "SETTING_RATEUS_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SETTING_PRIVACY_FIRST = "SETTING_PRIVACY_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SETTING_PRIVACY_AGAIN = "SETTING_PRIVACY_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SETTING_LANGUAGE_AGAIN = "SETTING_LANGUAGE_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SETTING_LANGUAGE_FIRST = "SETTING_LANGUAGE_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_ACTIVE_FIRST = "HOME_ACTIVE_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_ACTIVE_AGAIN = "HOME_ACTIVE_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_CHANGE_VOICE_PASSCODE_FIRST = "HOME_CHANGE_VOICE_PASSCODE_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_CHANGE_VOICE_PASSCODE_AGAIN = "HOME_CHANGE_VOICE_PASSCODE_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_DONT_TOUCH_FIRST = "HOME_DONT_TOUCH_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_DONT_TOUCH_AGAIN = "HOME_DONT_TOUCH_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_POCKET_FIRST = "HOME_POCKET_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_POCKET_AGAIN = "HOME_POCKET_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_CLAP_FIRST = "HOME_CLAP_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_CLAP_AGAIN = "HOME_CLAP_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_VOICE_FIRST = "HOME_VOICE_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HOME_VOICE_AGAIN = "HOME_VOICE_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RECORDPASSCODE_RECORD_VOICE_FIRST = "RECORDPASSCODE_RECORD_VOICE_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RECORDPASSCODE_RECORD_VOICE_AGAIN = "RECORDPASSCODE_RECORD_VOICE_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RECORDPASSCODE_SAVE_PASSCODE_FIRST = "RECORDPASSCODE_SAVE_PASSCODE_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RECORDPASSCODE_SAVE_PASSCODE_AGAIN = "RECORDPASSCODE_SAVE_PASSCODE_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RECORDPASSCODE_SELECT_LANGUAGE_FIRST = "RECORDPASSCODE_SELECT_LANGUAGE_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RECORDPASSCODE_SELECT_LANGUAGE_AGAIN = "RECORDPASSCODE_SELECT_LANGUAGE_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TEXT_TO_VOICE_SAVE_PASSCODE_FIRST = "TEXT_TO_VOICE_SAVE_PASSCODE_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TEXT_TO_VOICE_SAVE_PASSCODE_AGAIN = "TEXT_TO_VOICE_SAVE_PASSCODE_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TEXT_TO_VOICE_LISTEN_FIRST = "TEXT_TO_VOICE_LISTEN_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TEXT_TO_VOICE_LISTEN_AGAIN = "TEXT_TO_VOICE_LISTEN_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TEXT_TO_VOICE_SELECT_LANGUAGE_FIRST = "TEXT_TO_VOICE_SELECT_LANGUAGE_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TEXT_TO_VOICE_SELECT_LANGUAGE_AGAIN = "TEXT_TO_VOICE_SELECT_LANGUAGE_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LANG_NATIVE_DIS = "LANG_NATIVE_DIS";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LANG_NATIVE_SHOW = "LANG_NATIVE_SHOW";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_HOME_FIRST = "GO_TO_HOME_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_HOME_AGAIN = "GO_TO_HOME_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_PRIVACY_FIRST = "GO_TO_PRIVACY_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_PRIVACY_AGAIN = "GO_TO_PRIVACY_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_RECORD_PASSCODE_FIRST = "GO_TO_RECORD_PASSCODE_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_RECORD_PASSCODE_AGAIN = "GO_TO_RECORD_PASSCODE_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_TEXT_TO_VOICE_FIRST = "GO_TO_TEXT_TO_VOICE_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_TEXT_TO_VOICE_AGAIN = "GO_TO_TEXT_TO_VOICE_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_CREATE_PASSCODE_FIRST = "GO_TO_CREATE_PASSCODE_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_CREATE_PASSCODE_AGAIN = "GO_TO_CREATE_PASSCODE_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_SETTING_FIRST = "GO_TO_SETTING_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_SETTING_AGAIN = "GO_TO_SETTING_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_HOW_TO_USE_FIRST = "GO_TO_HOW_TO_USE_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_HOW_TO_USE_AGAIN = "GO_TO_HOW_TO_USE_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_CHOOSE_SOUND_FIRST = "GO_TO_CHOOSE_SOUND_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_CHOOSE_SOUND_AGAIN = "GO_TO_CHOOSE_SOUND_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_SOUND_DETAIL_FIRST = "GO_TO_SOUND_DETAIL_FIRST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GO_TO_SOUND_DETAIL_AGAIN = "GO_TO_SOUND_DETAIL_AGAIN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MAIN_REQUEST_INTERNET_YES = "MAIN_REQUEST_INTERNET_YES";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MAIN_REQUEST_INTERNET_NO = "MAIN_REQUEST_INTERNET_NO";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MAIN_REQUEST_INTERNET_CANCEL = "MAIN_REQUEST_INTERNET_CANCEL";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXPIRED = "res_expired";
    @org.jetbrains.annotations.NotNull()
    private static final char[] HEX_LOWERCASE = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    @org.jetbrains.annotations.NotNull()
    public static final com.dev.baseproject.utils.Constants INSTANCE = null;
    
    private Constants() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getCONTACT_PERMISSION() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getSTORAGE_PERMISSION() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getCAMERA() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final char[] getHEX_LOWERCASE() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/dev/baseproject/utils/Constants$Pocket;", "", "()V", "LIGHT_SENSOR_THRESHOLD", "", "PROXIMITY_SENSOR_THRESHOLD", "PROXIMITY_SENSOR_THRESHOLD_MAX", "app_debug"})
    public static final class Pocket {
        public static final float PROXIMITY_SENSOR_THRESHOLD = 1.0F;
        public static final float PROXIMITY_SENSOR_THRESHOLD_MAX = 5.0F;
        public static final float LIGHT_SENSOR_THRESHOLD = 0.001F;
        @org.jetbrains.annotations.NotNull()
        public static final com.dev.baseproject.utils.Constants.Pocket INSTANCE = null;
        
        private Pocket() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bf\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006j"}, d2 = {"Lcom/dev/baseproject/utils/Constants$PreferencesKey;", "", "()V", "APP_OPEN", "", "COUNT_CLICK_NO_BEFORE_NOTIFICATION", "COUNT_CLICK_NO_BEFORE_RATING_APP", "COUNT_CLICK_NO_BEFORE_UPDATE", "COUNT_SHOW_RATING", "COUNT_TOTAL_EXIST_TO_SHOW_RATING_APP", "DEFAULT_SOUND_VOLUME", "DURATION_ADDED", "DURATION_LIST", "FINISH_TIMER", "FIRST_TIME_OPEN_APP", "FLASH_SPEED", "GO_TO_CHOOSE_SOUND", "GO_TO_CREATE_PASSCODE", "GO_TO_HOME", "GO_TO_HOW_TO_USE", "GO_TO_PRIVACY", "GO_TO_RECORD_PASSCODE", "GO_TO_SETTING", "GO_TO_SOUND_DETAIL", "GO_TO_TEXT_TO_VOICE", "IS_CHANGE_SETTING_SOUND_DETAIL", "IS_CLAP_SERVICE_DETECTED", "IS_DENY_NOTIFICATION_PERMISSION_FIRST", "IS_DONT_SHOW_CONFIRM_NOTIFICATION_PERMISSION", "IS_DONT_TOUCH_SERVICE_DETECTED", "IS_FIRST_ACCEPT_PRIVACY_TERMS", "IS_FIRST_ACTIVE_HOME", "IS_FIRST_APPLY_SOUND", "IS_FIRST_AUDIO_PERMISSION_REQUIRE", "IS_FIRST_CHANGE_VOICE_PASSCODE_HOME", "IS_FIRST_CLAP_HOME", "IS_FIRST_CONFIRM_CANCEL_CHECK_INTERNET_DIALOG", "IS_FIRST_CONFIRM_YES_CHECK_INTERNET_DIALOG", "IS_FIRST_DONT_TOUCH_HOME", "IS_FIRST_FEEDBACK_SETTING", "IS_FIRST_INSTALL", "IS_FIRST_LANGUAGE_SETTING", "IS_FIRST_LISTEN_TEXT_TO_VOICE", "IS_FIRST_NOTIFICATION_PERMISSION_REQUIRE", "IS_FIRST_OPEN", "IS_FIRST_OPEN_CREATE_PASSCODE", "IS_FIRST_OPEN_HOME", "IS_FIRST_OPEN_INTRO_1", "IS_FIRST_OPEN_INTRO_2", "IS_FIRST_OPEN_INTRO_3", "IS_FIRST_OPEN_LANGUAGE", "IS_FIRST_OPEN_SETTING", "IS_FIRST_PLAY_SOUND", "IS_FIRST_POCKET_HOME", "IS_FIRST_PRIVACY_SETTING", "IS_FIRST_RADIO_SETTING", "IS_FIRST_RATEUS_SETTING", "IS_FIRST_RECORD_VOICE_RECORD_PASSCODE", "IS_FIRST_SAVE_RECORD_PASSCODE", "IS_FIRST_SAVE_TEXT_TO_VOICE", "IS_FIRST_SELECT_LANGUAGE_RECORD_PASSCODE", "IS_FIRST_SELECT_LANGUAGE_TEXT_TO_VOICE", "IS_FIRST_SHOW_CHECK_INTERNET_DIALOG", "IS_FIRST_SWITCH_FLASH", "IS_FIRST_SWITCH_SOUND", "IS_FIRST_SWITCH_VIBRATE", "IS_FIRST_VOICE_HOME", "IS_FIRST_VOICE_MAX", "IS_FIRST_VOICE_MUTE", "IS_FLASH_ENABLED", "IS_GRANT_GO_TO_NOTIFICATION", "IS_NOTIFICATION_PERMISSION_DENIED", "IS_PHONE_FOUND_ACTIVE", "IS_PHONE_FOUND_ACTIVE_FROM_NOTI", "IS_POCKET_SERVICE_DETECTED", "IS_SHOW_CLAP_INTRO", "IS_SHOW_DONT_TOUCH_INTRO", "IS_SHOW_POCKET_INTRO", "IS_SHOW_RATING", "IS_SHOW_VOICE_INTRO", "IS_SOUND_ENABLED", "IS_START_SERVICE_300S", "IS_VIBRATION_ENABLED", "IS_VOICE_SERVICE_DETECTED", "LANGUAGE_SCROLL_POSITION", "LANG_CODE", "LAST_MODE", "LAST_START_TIME_CLAP", "LAST_START_TIME_MOTION", "LAST_START_TIME_POCKET", "LAST_START_TIME_VOICE", "LAST_TIME_EXIT_APP", "RECENT_SOUNDS", "RESOURCE_ID", "SENSITIVITY_DT", "SENSITIVITY_PK", "SHOULD_SHOW_BATTERY_DIALOG", "START_TIMER", "TIME_DURATION", "TIME_SHOW_RATING_FIRST", "USER_BALANCE", "USER_ONE_TIME", "VOICE_LOCAL", "VOICE_PASSCODE", "VOICE_REAL_PASSCODE", "WITH_LIGHT_PK", "app_debug"})
    public static final class PreferencesKey {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_OPEN = "IS_FIRST_OPEN";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String LANG_CODE = "LANG_CODE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String USER_BALANCE = "USER_BALANCE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String APP_OPEN = "APP_OPEN";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String USER_ONE_TIME = "USER_ONE_TIME";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String TIME_DURATION = "TIME_DURATION";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String DURATION_LIST = "DURATION_LIST";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String DURATION_ADDED = "DURATION_ADDED";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String RESOURCE_ID = "RESOURCE_ID";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String FLASH_SPEED = "FLASH_SPEED";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String VOICE_LOCAL = "VOICE_LOCAL";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String VOICE_PASSCODE = "VOICE_PASSCODE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_ACCEPT_PRIVACY_TERMS = "IS_FIRST_ACCEPT_PRIVACY_TERMS";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_SHOW_CHECK_INTERNET_DIALOG = "IS_FIRST_SHOW_CHECK_INTERNET_DIALOG";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_CONFIRM_YES_CHECK_INTERNET_DIALOG = "IS_FIRST_CONFIRM_YES_CHECK_INTERNET_DIALOG";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_CONFIRM_CANCEL_CHECK_INTERNET_DIALOG = "IS_FIRST_CONFIRM_CANCEL_CHECK_INTERNET_DIALOG";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_NOTIFICATION_PERMISSION_DENIED = "IS_NOTIFICATION_PERMISSION_DENIED";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_SOUND_ENABLED = "IS_SOUND_ENABLED";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_VIBRATION_ENABLED = "IS_VIBRATION_ENABLED";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FLASH_ENABLED = "IS_FLASH_ENABLED";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_SWITCH_SOUND = "IS_FIRST_SWITCH_SOUND";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_SWITCH_VIBRATE = "IS_FIRST_SWITCH_VIBRATE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_SWITCH_FLASH = "IS_FIRST_SWITCH_FLASH";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_VOICE_MAX = "IS_FIRST_VOICE_MAX";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_VOICE_MUTE = "IS_FIRST_MUTE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_PLAY_SOUND = "IS_FIRST_PLAY_SOUND";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_APPLY_SOUND = "IS_FIRST_APPLY_SOUND";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_RADIO_SETTING = "IS_FIRST_RADIO_SETTING";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_FEEDBACK_SETTING = "IS_FIRST_FEEDBACK_SETTING";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_RATEUS_SETTING = "IS_FIRST_RATEUS_SETTING";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_PRIVACY_SETTING = "IS_FIRST_PRIVACY_SETTING";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_LANGUAGE_SETTING = "IS_FIRST_LANGUAGE_SETTING";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_ACTIVE_HOME = "IS_FIRST_ACTIVE_HOME";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_CHANGE_VOICE_PASSCODE_HOME = "IS_FIRST_CHANGE_VOICE_PASSCODE_HOME";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_DONT_TOUCH_HOME = "IS_FIRST_DONT_TOUCH_HOME";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_POCKET_HOME = "IS_FIRST_POCKET_HOME";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_CLAP_HOME = "IS_FIRST_CLAP_HOME";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_VOICE_HOME = "IS_FIRST_VOICE_HOME";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_RECORD_VOICE_RECORD_PASSCODE = "IS_FIRST_RECORD_VOICE_RECORD_PASSCODE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_SAVE_RECORD_PASSCODE = "IS_FIRST_SAVE_RECORD_PASSCODE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_SELECT_LANGUAGE_RECORD_PASSCODE = "IS_FIRST_SELECT_LANGUAGE_RECORD_PASSCODE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_SAVE_TEXT_TO_VOICE = "IS_FIRST_SAVE_TEXT_TO_VOICE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_LISTEN_TEXT_TO_VOICE = "IS_FIRST_LISTEN_TEXT_TO_VOICE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_SELECT_LANGUAGE_TEXT_TO_VOICE = "IS_FIRST_SELECT_LANGUAGE_TEXT_TO_VOICE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_INSTALL = "is_first_install";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_OPEN_INTRO_1 = "is_first_open_intro_1";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_OPEN_INTRO_2 = "is_first_open_intro_2";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_OPEN_INTRO_3 = "is_first_open_intro_3";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_OPEN_LANGUAGE = "is_first_open_language";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String FIRST_TIME_OPEN_APP = "FIRST_TIME_OPEN_APP";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String COUNT_TOTAL_EXIST_TO_SHOW_RATING_APP = "COUNT_TOTAL_EXIST_TO_SHOW_RATING_APP";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_SHOW_RATING = "IS_SHOW_RATING";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_START_SERVICE_300S = "IS_START_SERVICE_300S";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String COUNT_SHOW_RATING = "COUNT_SHOW_RATING";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String TIME_SHOW_RATING_FIRST = "TIME_SHOW_RATING_FIRST";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String COUNT_CLICK_NO_BEFORE_RATING_APP = "COUNT_CLICK_NO_BEFORE_RATING_APP";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_DONT_SHOW_CONFIRM_NOTIFICATION_PERMISSION = "IS_DONT_SHOW_CONFIRM_NOTIFICATION_PERMISSION";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_GRANT_GO_TO_NOTIFICATION = "IS_GRANT_GO_TO_NOTIFICATION";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String COUNT_CLICK_NO_BEFORE_NOTIFICATION = "COUNT_CLICK_NO_BEFORE_NOTIFICATION";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_DENY_NOTIFICATION_PERMISSION_FIRST = "IS_DENY_NOTIFICATION_PERMISSION_FIRST";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String LAST_START_TIME_MOTION = "LAST_START_TIME_MOTION";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String LAST_START_TIME_CLAP = "LAST_START_TIME_CLAP";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String LAST_START_TIME_VOICE = "LAST_START_TIME_VOICE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String LAST_START_TIME_POCKET = "LAST_START_TIME_POCKET";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String LAST_TIME_EXIT_APP = "LAST_TIME_EXIT_APP";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String GO_TO_HOME = "GO_TO_HOME";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String GO_TO_PRIVACY = "GO_TO_PRIVACY";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String GO_TO_RECORD_PASSCODE = "GO_TO_RECORD_PASSCODE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String GO_TO_TEXT_TO_VOICE = "GO_TO_TEXT_TO_VOICE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String GO_TO_CREATE_PASSCODE = "GO_TO_CREATE_PASSCODE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String GO_TO_SETTING = "GO_TO_SETTING";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String GO_TO_HOW_TO_USE = "GO_TO_HOW_TO_USE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String GO_TO_CHOOSE_SOUND = "GO_TO_CHOOSE_SOUND";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String GO_TO_SOUND_DETAIL = "GO_TO_SOUND_DETAIL";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String COUNT_CLICK_NO_BEFORE_UPDATE = "COUNT_CLICK_NO_BEFORE_UPDATE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_PHONE_FOUND_ACTIVE = "IS_PHONE_FOUND_ACTIVE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_CLAP_SERVICE_DETECTED = "IS_CLAP_SERVICE_DETECTED";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_DONT_TOUCH_SERVICE_DETECTED = "IS_DONT_TOUCH_SERVICE_DETECTED";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_POCKET_SERVICE_DETECTED = "IS_POCKET_SERVICE_DETECTED";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_VOICE_SERVICE_DETECTED = "IS_VOICE_SERVICE_DETECTED";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_AUDIO_PERMISSION_REQUIRE = "IS_FIRST_AUDIO_PERMISSION_REQUIRE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_NOTIFICATION_PERMISSION_REQUIRE = "IS_FIRST_NOTIFICATION_PERMISSION_REQUIRE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_SHOW_CLAP_INTRO = "IS_SHOW_CLAP_INTRO";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_SHOW_VOICE_INTRO = "IS_SHOW_VOICE_INTRO";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_SHOW_DONT_TOUCH_INTRO = "IS_SHOW_DONT_TOUCH_INTRO";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_SHOW_POCKET_INTRO = "IS_SHOW_POCKET_INTRO";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_CHANGE_SETTING_SOUND_DETAIL = "IS_CHANGE_SETTING_SOUND_DETAIL";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String LAST_MODE = "LAST_MODE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String RECENT_SOUNDS = "RECENT_SOUNDS";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_PHONE_FOUND_ACTIVE_FROM_NOTI = "IS_PHONE_FOUND_ACTIVE_FROM_NOTI";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_OPEN_SETTING = "IS_FIRST_OPEN_SETTING";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String DEFAULT_SOUND_VOLUME = "DEFAULT_SOUND_VOLUME";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String SENSITIVITY_PK = "SENSITIVITY_PK";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String SENSITIVITY_DT = "SENSITIVITY_DT";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String WITH_LIGHT_PK = "WITH_LIGHT_PK";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String SHOULD_SHOW_BATTERY_DIALOG = "SHOULD_SHOW_BATTERY_DIALOG";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_OPEN_CREATE_PASSCODE = "IS_FIRST_OPEN_CREATE_PASSCODE";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String LANGUAGE_SCROLL_POSITION = "LANGUAGE_SCROLL_POSITION";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String IS_FIRST_OPEN_HOME = "IS_FIRST_OPEN_HOME";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String START_TIMER = "START_TIMER";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String FINISH_TIMER = "FINISH_TIMER";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String VOICE_REAL_PASSCODE = "VOICE_REAL_PASSCODE";
        @org.jetbrains.annotations.NotNull()
        public static final com.dev.baseproject.utils.Constants.PreferencesKey INSTANCE = null;
        
        private PreferencesKey() {
            super();
        }
    }
}