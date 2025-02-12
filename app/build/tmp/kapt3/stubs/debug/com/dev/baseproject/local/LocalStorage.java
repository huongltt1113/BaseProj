package com.dev.baseproject.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0003\b\u00d9\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J&\u0010\u0088\u0002\u001a\u0005\u0018\u0001H\u0089\u0002\"\t\b\u0000\u0010\u0089\u0002*\u00020\u00012\u0007\u0010\u008a\u0002\u001a\u00020\u0003H&\u00a2\u0006\u0003\u0010\u008b\u0002J7\u0010\u0088\u0002\u001a\u0005\u0018\u0001H\u0089\u0002\"\t\b\u0000\u0010\u0089\u0002*\u00020\u00012\u0007\u0010\u008a\u0002\u001a\u00020\u00032\u000f\u0010\u008c\u0002\u001a\n\u0012\u0005\u0012\u0003H\u0089\u00020\u008d\u0002H&\u00a2\u0006\u0003\u0010\u008e\u0002J\u0014\u0010\u008f\u0002\u001a\u0004\u0018\u00010\u00032\u0007\u0010\u008a\u0002\u001a\u00020\u0003H&J0\u0010\u0090\u0002\u001a\u00030\u0091\u0002\"\t\b\u0000\u0010\u0089\u0002*\u00020\u00012\u0007\u0010\u008a\u0002\u001a\u00020\u00032\n\u0010\u0092\u0002\u001a\u0005\u0018\u0001H\u0089\u0002H&\u00a2\u0006\u0003\u0010\u0093\u0002J\u001e\u0010\u0094\u0002\u001a\u00030\u0091\u00022\u0007\u0010\u008a\u0002\u001a\u00020\u00032\t\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0013\u0010\u0096\u0002\u001a\u00030\u0091\u00022\u0007\u0010\u008a\u0002\u001a\u00020\u0003H&R\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u00020\fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u00020\fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0014\u001a\u00020\fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u0018\u0010\u0017\u001a\u00020\fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u0018\u0010\u001a\u001a\u00020\fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u0018\u0010\u001d\u001a\u00020\u001eX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010#\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b$\u0010\u0005\"\u0004\b%\u0010\u0007R\u0018\u0010&\u001a\u00020\'X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0018\u0010,\u001a\u00020\'X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u0018\u0010/\u001a\u00020\fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010R\u0018\u00102\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0018\u00108\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\u0018\u0010;\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b<\u00105\"\u0004\b=\u00107R\u0018\u0010>\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b?\u00105\"\u0004\b@\u00107R\u0018\u0010A\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bB\u00105\"\u0004\bC\u00107R\u0018\u0010D\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bE\u00105\"\u0004\bF\u00107R\u0018\u0010G\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bH\u00105\"\u0004\bI\u00107R\u0018\u0010J\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bK\u00105\"\u0004\bL\u00107R\u0018\u0010M\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bN\u00105\"\u0004\bO\u00107R\u0018\u0010P\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bP\u00105\"\u0004\bQ\u00107R\u0018\u0010R\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bR\u00105\"\u0004\bS\u00107R\u0018\u0010T\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bT\u00105\"\u0004\bU\u00107R\u0018\u0010V\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bV\u00105\"\u0004\bW\u00107R\u0018\u0010X\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bX\u00105\"\u0004\bY\u00107R\u0018\u0010Z\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bZ\u00105\"\u0004\b[\u00107R\u0018\u0010\\\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\\\u00105\"\u0004\b]\u00107R\u0018\u0010^\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b^\u00105\"\u0004\b_\u00107R\u0018\u0010`\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b`\u00105\"\u0004\ba\u00107R\u0018\u0010b\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bb\u00105\"\u0004\bc\u00107R\u0018\u0010d\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bd\u00105\"\u0004\be\u00107R\u0018\u0010f\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bf\u00105\"\u0004\bg\u00107R\u0018\u0010h\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bh\u00105\"\u0004\bi\u00107R\u0018\u0010j\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bj\u00105\"\u0004\bk\u00107R\u0018\u0010l\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bl\u00105\"\u0004\bm\u00107R\u0018\u0010n\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bn\u00105\"\u0004\bo\u00107R\u0018\u0010p\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bp\u00105\"\u0004\bq\u00107R\u0018\u0010r\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\br\u00105\"\u0004\bs\u00107R\u0018\u0010t\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bt\u00105\"\u0004\bu\u00107R\u0018\u0010v\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bv\u00105\"\u0004\bw\u00107R\u0018\u0010x\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bx\u00105\"\u0004\by\u00107R\u0018\u0010z\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bz\u00105\"\u0004\b{\u00107R\u0018\u0010|\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b|\u00105\"\u0004\b}\u00107R\u0018\u0010~\u001a\u000203X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b~\u00105\"\u0004\b\u007f\u00107R\u001b\u0010\u0080\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0080\u0001\u00105\"\u0005\b\u0081\u0001\u00107R\u001b\u0010\u0082\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0082\u0001\u00105\"\u0005\b\u0083\u0001\u00107R\u001b\u0010\u0084\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0084\u0001\u00105\"\u0005\b\u0085\u0001\u00107R\u001b\u0010\u0086\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0086\u0001\u00105\"\u0005\b\u0087\u0001\u00107R\u001b\u0010\u0088\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0088\u0001\u00105\"\u0005\b\u0089\u0001\u00107R\u001b\u0010\u008a\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u008a\u0001\u00105\"\u0005\b\u008b\u0001\u00107R\u001b\u0010\u008c\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u008c\u0001\u00105\"\u0005\b\u008d\u0001\u00107R\u001b\u0010\u008e\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u008e\u0001\u00105\"\u0005\b\u008f\u0001\u00107R\u001b\u0010\u0090\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0090\u0001\u00105\"\u0005\b\u0091\u0001\u00107R\u001b\u0010\u0092\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0092\u0001\u00105\"\u0005\b\u0093\u0001\u00107R\u001b\u0010\u0094\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0094\u0001\u00105\"\u0005\b\u0095\u0001\u00107R\u001b\u0010\u0096\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0096\u0001\u00105\"\u0005\b\u0097\u0001\u00107R\u001b\u0010\u0098\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0098\u0001\u00105\"\u0005\b\u0099\u0001\u00107R\u001b\u0010\u009a\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u009a\u0001\u00105\"\u0005\b\u009b\u0001\u00107R\u001b\u0010\u009c\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u009c\u0001\u00105\"\u0005\b\u009d\u0001\u00107R\u001b\u0010\u009e\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u009e\u0001\u00105\"\u0005\b\u009f\u0001\u00107R\u001b\u0010\u00a0\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00a0\u0001\u00105\"\u0005\b\u00a1\u0001\u00107R\u001b\u0010\u00a2\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00a2\u0001\u00105\"\u0005\b\u00a3\u0001\u00107R\u001b\u0010\u00a4\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00a4\u0001\u00105\"\u0005\b\u00a5\u0001\u00107R\u001b\u0010\u00a6\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00a6\u0001\u00105\"\u0005\b\u00a7\u0001\u00107R\u001b\u0010\u00a8\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00a8\u0001\u00105\"\u0005\b\u00a9\u0001\u00107R\u001b\u0010\u00aa\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00aa\u0001\u00105\"\u0005\b\u00ab\u0001\u00107R\u001b\u0010\u00ac\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00ac\u0001\u00105\"\u0005\b\u00ad\u0001\u00107R\u001b\u0010\u00ae\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00ae\u0001\u00105\"\u0005\b\u00af\u0001\u00107R\u001b\u0010\u00b0\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00b0\u0001\u00105\"\u0005\b\u00b1\u0001\u00107R\u001b\u0010\u00b2\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00b2\u0001\u00105\"\u0005\b\u00b3\u0001\u00107R\u001b\u0010\u00b4\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00b4\u0001\u00105\"\u0005\b\u00b5\u0001\u00107R\u001b\u0010\u00b6\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00b6\u0001\u00105\"\u0005\b\u00b7\u0001\u00107R\u001b\u0010\u00b8\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00b8\u0001\u00105\"\u0005\b\u00b9\u0001\u00107R\u001b\u0010\u00ba\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00ba\u0001\u00105\"\u0005\b\u00bb\u0001\u00107R\u001b\u0010\u00bc\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00bc\u0001\u00105\"\u0005\b\u00bd\u0001\u00107R\u001b\u0010\u00be\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00be\u0001\u00105\"\u0005\b\u00bf\u0001\u00107R\u001b\u0010\u00c0\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00c0\u0001\u00105\"\u0005\b\u00c1\u0001\u00107R\u001b\u0010\u00c2\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00c2\u0001\u00105\"\u0005\b\u00c3\u0001\u00107R\u001b\u0010\u00c4\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00c4\u0001\u00105\"\u0005\b\u00c5\u0001\u00107R\u001b\u0010\u00c6\u0001\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00c7\u0001\u0010\u0005\"\u0005\b\u00c8\u0001\u0010\u0007R\u001b\u0010\u00c9\u0001\u001a\u00020\fX\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00ca\u0001\u0010\u000e\"\u0005\b\u00cb\u0001\u0010\u0010R\u001b\u0010\u00cc\u0001\u001a\u00020\fX\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00cd\u0001\u0010\u000e\"\u0005\b\u00ce\u0001\u0010\u0010R\u001b\u0010\u00cf\u0001\u001a\u00020\'X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00d0\u0001\u0010)\"\u0005\b\u00d1\u0001\u0010+R\u001b\u0010\u00d2\u0001\u001a\u00020\'X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00d3\u0001\u0010)\"\u0005\b\u00d4\u0001\u0010+R\u001b\u0010\u00d5\u0001\u001a\u00020\'X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00d6\u0001\u0010)\"\u0005\b\u00d7\u0001\u0010+R\u001b\u0010\u00d8\u0001\u001a\u00020\'X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00d9\u0001\u0010)\"\u0005\b\u00da\u0001\u0010+R\u001b\u0010\u00db\u0001\u001a\u00020\'X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00dc\u0001\u0010)\"\u0005\b\u00dd\u0001\u0010+R\u001b\u0010\u00de\u0001\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00df\u0001\u0010\u0005\"\u0005\b\u00e0\u0001\u0010\u0007R\u001b\u0010\u00e1\u0001\u001a\u00020\fX\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00e2\u0001\u0010\u000e\"\u0005\b\u00e3\u0001\u0010\u0010R\u001b\u0010\u00e4\u0001\u001a\u00020\u001eX\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00e5\u0001\u0010 \"\u0005\b\u00e6\u0001\u0010\"R\u001b\u0010\u00e7\u0001\u001a\u00020\u001eX\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00e8\u0001\u0010 \"\u0005\b\u00e9\u0001\u0010\"R\u001b\u0010\u00ea\u0001\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00eb\u0001\u00105\"\u0005\b\u00ec\u0001\u00107R\u001b\u0010\u00ed\u0001\u001a\u00020\'X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00ee\u0001\u0010)\"\u0005\b\u00ef\u0001\u0010+R\u001b\u0010\u00f0\u0001\u001a\u00020\'X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00f1\u0001\u0010)\"\u0005\b\u00f2\u0001\u0010+R\u001b\u0010\u00f3\u0001\u001a\u00020\'X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00f4\u0001\u0010)\"\u0005\b\u00f5\u0001\u0010+R\u001b\u0010\u00f6\u0001\u001a\u00020\fX\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00f7\u0001\u0010\u000e\"\u0005\b\u00f8\u0001\u0010\u0010R\u001b\u0010\u00f9\u0001\u001a\u00020\fX\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00fa\u0001\u0010\u000e\"\u0005\b\u00fb\u0001\u0010\u0010R\u001b\u0010\u00fc\u0001\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00fd\u0001\u0010\u0005\"\u0005\b\u00fe\u0001\u0010\u0007R\u001b\u0010\u00ff\u0001\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0080\u0002\u0010\u0005\"\u0005\b\u0081\u0002\u0010\u0007R\u001b\u0010\u0082\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0083\u0002\u0010\u0005\"\u0005\b\u0084\u0002\u0010\u0007R\u001b\u0010\u0085\u0002\u001a\u000203X\u00a6\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0086\u0002\u00105\"\u0005\b\u0087\u0002\u00107\u00a8\u0006\u0097\u0002"}, d2 = {"Lcom/dev/baseproject/local/LocalStorage;", "", "appOpen", "", "getAppOpen", "()Ljava/lang/String;", "setAppOpen", "(Ljava/lang/String;)V", "authorization", "getAuthorization", "setAuthorization", "countClickNoBeforeNotification", "", "getCountClickNoBeforeNotification", "()I", "setCountClickNoBeforeNotification", "(I)V", "countClickNoBeforeRating", "getCountClickNoBeforeRating", "setCountClickNoBeforeRating", "countClickNoBeforeUpdate", "getCountClickNoBeforeUpdate", "setCountClickNoBeforeUpdate", "countShowRating", "getCountShowRating", "setCountShowRating", "countTotalExitAppToShowRating", "getCountTotalExitAppToShowRating", "setCountTotalExitAppToShowRating", "defaultSoundVolume", "", "getDefaultSoundVolume", "()F", "setDefaultSoundVolume", "(F)V", "durationAdded", "getDurationAdded", "setDurationAdded", "finishTimer", "", "getFinishTimer", "()J", "setFinishTimer", "(J)V", "firstTimeOpenApp", "getFirstTimeOpenApp", "setFirstTimeOpenApp", "flashSpeed", "getFlashSpeed", "setFlashSpeed", "goToChooseSound", "", "getGoToChooseSound", "()Z", "setGoToChooseSound", "(Z)V", "goToCreatePasscode", "getGoToCreatePasscode", "setGoToCreatePasscode", "goToHome", "getGoToHome", "setGoToHome", "goToHowtoUse", "getGoToHowtoUse", "setGoToHowtoUse", "goToPrivacy", "getGoToPrivacy", "setGoToPrivacy", "goToRecordPasscode", "getGoToRecordPasscode", "setGoToRecordPasscode", "goToSetting", "getGoToSetting", "setGoToSetting", "goToSoundDetail", "getGoToSoundDetail", "setGoToSoundDetail", "goToTextToVoice", "getGoToTextToVoice", "setGoToTextToVoice", "isChangeSettingSoundDetail", "setChangeSettingSoundDetail", "isClapServiceDetected", "setClapServiceDetected", "isDenyNotificationPermissionFirst", "setDenyNotificationPermissionFirst", "isDontShowConfirmNotificationPermission", "setDontShowConfirmNotificationPermission", "isDontTouchServiceDetected", "setDontTouchServiceDetected", "isFirstAccectPrivacyTerms", "setFirstAccectPrivacyTerms", "isFirstActiveHomeClick", "setFirstActiveHomeClick", "isFirstApplySoundDetailClick", "setFirstApplySoundDetailClick", "isFirstAudioPermissionRequire", "setFirstAudioPermissionRequire", "isFirstChangeVoicePasscodeHomeClick", "setFirstChangeVoicePasscodeHomeClick", "isFirstClapClick", "setFirstClapClick", "isFirstConfirmCancelCheckInternetDialog", "setFirstConfirmCancelCheckInternetDialog", "isFirstConfirmYesCheckInternetDialog", "setFirstConfirmYesCheckInternetDialog", "isFirstDontTouchClick", "setFirstDontTouchClick", "isFirstFeedbackSettingClick", "setFirstFeedbackSettingClick", "isFirstInstall", "setFirstInstall", "isFirstLanguageSetting", "setFirstLanguageSetting", "isFirstListenTexttoVoiceClick", "setFirstListenTexttoVoiceClick", "isFirstNotificationPermissionRequire", "setFirstNotificationPermissionRequire", "isFirstOpen", "setFirstOpen", "isFirstOpenCreatePasscode", "setFirstOpenCreatePasscode", "isFirstOpenHome", "setFirstOpenHome", "isFirstOpenIntro1", "setFirstOpenIntro1", "isFirstOpenIntro2", "setFirstOpenIntro2", "isFirstOpenIntro3", "setFirstOpenIntro3", "isFirstOpenLanguage", "setFirstOpenLanguage", "isFirstOpenSetting", "setFirstOpenSetting", "isFirstPlaySoundDetailClick", "setFirstPlaySoundDetailClick", "isFirstPocketClick", "setFirstPocketClick", "isFirstPrivacySettingClick", "setFirstPrivacySettingClick", "isFirstRadioSettingClick", "setFirstRadioSettingClick", "isFirstRateUsSettingClick", "setFirstRateUsSettingClick", "isFirstRecordVoiceClick", "setFirstRecordVoiceClick", "isFirstSavePasscodeClick", "setFirstSavePasscodeClick", "isFirstSavePasscodeTexttoVoiceClick", "setFirstSavePasscodeTexttoVoiceClick", "isFirstSelectLanguageRecordPasscodeClick", "setFirstSelectLanguageRecordPasscodeClick", "isFirstSelectLanguageTexttoVoiceClick", "setFirstSelectLanguageTexttoVoiceClick", "isFirstShowCheckInternetDialog", "setFirstShowCheckInternetDialog", "isFirstSwitchFlashClick", "setFirstSwitchFlashClick", "isFirstSwitchSoundClick", "setFirstSwitchSoundClick", "isFirstSwitchVibrateClick", "setFirstSwitchVibrateClick", "isFirstVoiceClick", "setFirstVoiceClick", "isFirstVoiceMaxClick", "setFirstVoiceMaxClick", "isFirstVoiceMuteClick", "setFirstVoiceMuteClick", "isFlashEnabled", "setFlashEnabled", "isGoToPermissionNotificaton", "setGoToPermissionNotificaton", "isNotificationPermissionDeniedOnce", "setNotificationPermissionDeniedOnce", "isPhoneFoundActivityActive", "setPhoneFoundActivityActive", "isPhoneFoundActivityActiveFromNoti", "setPhoneFoundActivityActiveFromNoti", "isPocketServiceDetected", "setPocketServiceDetected", "isShowClapIntro", "setShowClapIntro", "isShowDontTouchIntro", "setShowDontTouchIntro", "isShowPocketIntro", "setShowPocketIntro", "isShowRating", "setShowRating", "isShowVoiceIntro", "setShowVoiceIntro", "isSoundEnabled", "setSoundEnabled", "isStartService300s", "setStartService300s", "isVibrationEnabled", "setVibrationEnabled", "isVoiceServiceDetected", "setVoiceServiceDetected", "langCode", "getLangCode", "setLangCode", "languageScrollPosition", "getLanguageScrollPosition", "setLanguageScrollPosition", "lastMode", "getLastMode", "setLastMode", "lastStartTimeClap", "getLastStartTimeClap", "setLastStartTimeClap", "lastStartTimeMotion", "getLastStartTimeMotion", "setLastStartTimeMotion", "lastStartTimePocket", "getLastStartTimePocket", "setLastStartTimePocket", "lastStartTimeVoice", "getLastStartTimeVoice", "setLastStartTimeVoice", "lastTimeExitApp", "getLastTimeExitApp", "setLastTimeExitApp", "recentSounds", "getRecentSounds", "setRecentSounds", "resourceId", "getResourceId", "setResourceId", "sensitivityDT", "getSensitivityDT", "setSensitivityDT", "sensitivityPK", "getSensitivityPK", "setSensitivityPK", "shouldShowBatteryDialog", "getShouldShowBatteryDialog", "setShouldShowBatteryDialog", "startTimer", "getStartTimer", "setStartTimer", "timeDuration", "getTimeDuration", "setTimeDuration", "timeShowRatingFirst", "getTimeShowRatingFirst", "setTimeShowRatingFirst", "userBalance", "getUserBalance", "setUserBalance", "userOneTime", "getUserOneTime", "setUserOneTime", "voiceLocal", "getVoiceLocal", "setVoiceLocal", "voicePasscode", "getVoicePasscode", "setVoicePasscode", "voiceRealPasscode", "getVoiceRealPasscode", "setVoiceRealPasscode", "withLightPK", "getWithLightPK", "setWithLightPK", "getData", "T", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "clazz", "Lkotlin/reflect/KClass;", "(Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getString", "putData", "", "t", "(Ljava/lang/String;Ljava/lang/Object;)V", "putString", "value", "remove", "app_debug"})
public abstract interface LocalStorage {
    
    public abstract void putString(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    java.lang.String value);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getString(@org.jetbrains.annotations.NotNull()
    java.lang.String key);
    
    public abstract void remove(@org.jetbrains.annotations.NotNull()
    java.lang.String key);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getAuthorization();
    
    public abstract void setAuthorization(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    public abstract <T extends java.lang.Object>void putData(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    T t);
    
    @org.jetbrains.annotations.Nullable()
    public abstract <T extends java.lang.Object>T getData(@org.jetbrains.annotations.NotNull()
    java.lang.String key);
    
    @org.jetbrains.annotations.Nullable()
    public abstract <T extends java.lang.Object>T getData(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KClass<T> clazz);
    
    public abstract boolean isFirstOpen();
    
    public abstract void setFirstOpen(boolean p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getLangCode();
    
    public abstract void setLangCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    public abstract int getUserBalance();
    
    public abstract void setUserBalance(int p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getAppOpen();
    
    public abstract void setAppOpen(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    public abstract int getUserOneTime();
    
    public abstract void setUserOneTime(int p0);
    
    public abstract boolean isFirstAccectPrivacyTerms();
    
    public abstract void setFirstAccectPrivacyTerms(boolean p0);
    
    public abstract boolean getGoToHome();
    
    public abstract void setGoToHome(boolean p0);
    
    public abstract boolean getGoToPrivacy();
    
    public abstract void setGoToPrivacy(boolean p0);
    
    public abstract boolean getGoToRecordPasscode();
    
    public abstract void setGoToRecordPasscode(boolean p0);
    
    public abstract boolean getGoToTextToVoice();
    
    public abstract void setGoToTextToVoice(boolean p0);
    
    public abstract boolean isFirstShowCheckInternetDialog();
    
    public abstract void setFirstShowCheckInternetDialog(boolean p0);
    
    public abstract boolean isFirstConfirmYesCheckInternetDialog();
    
    public abstract void setFirstConfirmYesCheckInternetDialog(boolean p0);
    
    public abstract boolean isFirstConfirmCancelCheckInternetDialog();
    
    public abstract void setFirstConfirmCancelCheckInternetDialog(boolean p0);
    
    public abstract boolean isNotificationPermissionDeniedOnce();
    
    public abstract void setNotificationPermissionDeniedOnce(boolean p0);
    
    public abstract boolean getGoToCreatePasscode();
    
    public abstract void setGoToCreatePasscode(boolean p0);
    
    public abstract boolean getGoToSetting();
    
    public abstract void setGoToSetting(boolean p0);
    
    public abstract boolean getGoToHowtoUse();
    
    public abstract void setGoToHowtoUse(boolean p0);
    
    public abstract boolean getGoToChooseSound();
    
    public abstract void setGoToChooseSound(boolean p0);
    
    public abstract boolean getGoToSoundDetail();
    
    public abstract void setGoToSoundDetail(boolean p0);
    
    public abstract boolean isSoundEnabled();
    
    public abstract void setSoundEnabled(boolean p0);
    
    public abstract boolean isVibrationEnabled();
    
    public abstract void setVibrationEnabled(boolean p0);
    
    public abstract boolean isFlashEnabled();
    
    public abstract void setFlashEnabled(boolean p0);
    
    public abstract long getTimeDuration();
    
    public abstract void setTimeDuration(long p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getDurationAdded();
    
    public abstract void setDurationAdded(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    public abstract int getResourceId();
    
    public abstract void setResourceId(int p0);
    
    public abstract int getFlashSpeed();
    
    public abstract void setFlashSpeed(int p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getVoiceLocal();
    
    public abstract void setVoiceLocal(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getVoicePasscode();
    
    public abstract void setVoicePasscode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    public abstract boolean isFirstSwitchSoundClick();
    
    public abstract void setFirstSwitchSoundClick(boolean p0);
    
    public abstract boolean isFirstSwitchVibrateClick();
    
    public abstract void setFirstSwitchVibrateClick(boolean p0);
    
    public abstract boolean isFirstSwitchFlashClick();
    
    public abstract void setFirstSwitchFlashClick(boolean p0);
    
    public abstract boolean isFirstVoiceMaxClick();
    
    public abstract void setFirstVoiceMaxClick(boolean p0);
    
    public abstract boolean isFirstVoiceMuteClick();
    
    public abstract void setFirstVoiceMuteClick(boolean p0);
    
    public abstract boolean isFirstPlaySoundDetailClick();
    
    public abstract void setFirstPlaySoundDetailClick(boolean p0);
    
    public abstract boolean isFirstApplySoundDetailClick();
    
    public abstract void setFirstApplySoundDetailClick(boolean p0);
    
    public abstract boolean isFirstRadioSettingClick();
    
    public abstract void setFirstRadioSettingClick(boolean p0);
    
    public abstract boolean isFirstFeedbackSettingClick();
    
    public abstract void setFirstFeedbackSettingClick(boolean p0);
    
    public abstract boolean isFirstRateUsSettingClick();
    
    public abstract void setFirstRateUsSettingClick(boolean p0);
    
    public abstract boolean isFirstPrivacySettingClick();
    
    public abstract void setFirstPrivacySettingClick(boolean p0);
    
    public abstract boolean isFirstLanguageSetting();
    
    public abstract void setFirstLanguageSetting(boolean p0);
    
    public abstract boolean isFirstActiveHomeClick();
    
    public abstract void setFirstActiveHomeClick(boolean p0);
    
    public abstract boolean isFirstChangeVoicePasscodeHomeClick();
    
    public abstract void setFirstChangeVoicePasscodeHomeClick(boolean p0);
    
    public abstract boolean isFirstDontTouchClick();
    
    public abstract void setFirstDontTouchClick(boolean p0);
    
    public abstract boolean isFirstPocketClick();
    
    public abstract void setFirstPocketClick(boolean p0);
    
    public abstract boolean isFirstClapClick();
    
    public abstract void setFirstClapClick(boolean p0);
    
    public abstract boolean isFirstVoiceClick();
    
    public abstract void setFirstVoiceClick(boolean p0);
    
    public abstract boolean isFirstRecordVoiceClick();
    
    public abstract void setFirstRecordVoiceClick(boolean p0);
    
    public abstract boolean isFirstSavePasscodeClick();
    
    public abstract void setFirstSavePasscodeClick(boolean p0);
    
    public abstract boolean isFirstSelectLanguageRecordPasscodeClick();
    
    public abstract void setFirstSelectLanguageRecordPasscodeClick(boolean p0);
    
    public abstract boolean isFirstSavePasscodeTexttoVoiceClick();
    
    public abstract void setFirstSavePasscodeTexttoVoiceClick(boolean p0);
    
    public abstract boolean isFirstListenTexttoVoiceClick();
    
    public abstract void setFirstListenTexttoVoiceClick(boolean p0);
    
    public abstract boolean isFirstSelectLanguageTexttoVoiceClick();
    
    public abstract void setFirstSelectLanguageTexttoVoiceClick(boolean p0);
    
    public abstract boolean isFirstInstall();
    
    public abstract void setFirstInstall(boolean p0);
    
    public abstract long getFirstTimeOpenApp();
    
    public abstract void setFirstTimeOpenApp(long p0);
    
    public abstract boolean isFirstOpenIntro1();
    
    public abstract void setFirstOpenIntro1(boolean p0);
    
    public abstract boolean isFirstOpenIntro2();
    
    public abstract void setFirstOpenIntro2(boolean p0);
    
    public abstract boolean isFirstOpenIntro3();
    
    public abstract void setFirstOpenIntro3(boolean p0);
    
    public abstract long getLastTimeExitApp();
    
    public abstract void setLastTimeExitApp(long p0);
    
    public abstract int getCountClickNoBeforeUpdate();
    
    public abstract void setCountClickNoBeforeUpdate(int p0);
    
    public abstract boolean isFirstOpenLanguage();
    
    public abstract void setFirstOpenLanguage(boolean p0);
    
    public abstract int getCountTotalExitAppToShowRating();
    
    public abstract void setCountTotalExitAppToShowRating(int p0);
    
    public abstract boolean isShowRating();
    
    public abstract void setShowRating(boolean p0);
    
    public abstract boolean isStartService300s();
    
    public abstract void setStartService300s(boolean p0);
    
    public abstract int getCountShowRating();
    
    public abstract void setCountShowRating(int p0);
    
    public abstract long getTimeShowRatingFirst();
    
    public abstract void setTimeShowRatingFirst(long p0);
    
    public abstract int getCountClickNoBeforeRating();
    
    public abstract void setCountClickNoBeforeRating(int p0);
    
    public abstract boolean isDontShowConfirmNotificationPermission();
    
    public abstract void setDontShowConfirmNotificationPermission(boolean p0);
    
    public abstract boolean isGoToPermissionNotificaton();
    
    public abstract void setGoToPermissionNotificaton(boolean p0);
    
    public abstract int getCountClickNoBeforeNotification();
    
    public abstract void setCountClickNoBeforeNotification(int p0);
    
    public abstract boolean isDenyNotificationPermissionFirst();
    
    public abstract void setDenyNotificationPermissionFirst(boolean p0);
    
    public abstract long getLastStartTimeMotion();
    
    public abstract void setLastStartTimeMotion(long p0);
    
    public abstract long getLastStartTimeClap();
    
    public abstract void setLastStartTimeClap(long p0);
    
    public abstract long getLastStartTimeVoice();
    
    public abstract void setLastStartTimeVoice(long p0);
    
    public abstract long getLastStartTimePocket();
    
    public abstract void setLastStartTimePocket(long p0);
    
    public abstract boolean isFirstAudioPermissionRequire();
    
    public abstract void setFirstAudioPermissionRequire(boolean p0);
    
    public abstract boolean isFirstNotificationPermissionRequire();
    
    public abstract void setFirstNotificationPermissionRequire(boolean p0);
    
    public abstract boolean isShowClapIntro();
    
    public abstract void setShowClapIntro(boolean p0);
    
    public abstract boolean isShowVoiceIntro();
    
    public abstract void setShowVoiceIntro(boolean p0);
    
    public abstract boolean isShowDontTouchIntro();
    
    public abstract void setShowDontTouchIntro(boolean p0);
    
    public abstract boolean isShowPocketIntro();
    
    public abstract void setShowPocketIntro(boolean p0);
    
    public abstract int getLastMode();
    
    public abstract void setLastMode(int p0);
    
    public abstract boolean isPhoneFoundActivityActive();
    
    public abstract void setPhoneFoundActivityActive(boolean p0);
    
    public abstract boolean isClapServiceDetected();
    
    public abstract void setClapServiceDetected(boolean p0);
    
    public abstract boolean isDontTouchServiceDetected();
    
    public abstract void setDontTouchServiceDetected(boolean p0);
    
    public abstract boolean isPocketServiceDetected();
    
    public abstract void setPocketServiceDetected(boolean p0);
    
    public abstract boolean isVoiceServiceDetected();
    
    public abstract void setVoiceServiceDetected(boolean p0);
    
    public abstract boolean isPhoneFoundActivityActiveFromNoti();
    
    public abstract void setPhoneFoundActivityActiveFromNoti(boolean p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getRecentSounds();
    
    public abstract void setRecentSounds(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    public abstract boolean isFirstOpenSetting();
    
    public abstract void setFirstOpenSetting(boolean p0);
    
    public abstract boolean isChangeSettingSoundDetail();
    
    public abstract void setChangeSettingSoundDetail(boolean p0);
    
    public abstract float getDefaultSoundVolume();
    
    public abstract void setDefaultSoundVolume(float p0);
    
    public abstract float getSensitivityPK();
    
    public abstract void setSensitivityPK(float p0);
    
    public abstract boolean getWithLightPK();
    
    public abstract void setWithLightPK(boolean p0);
    
    public abstract float getSensitivityDT();
    
    public abstract void setSensitivityDT(float p0);
    
    public abstract boolean getShouldShowBatteryDialog();
    
    public abstract void setShouldShowBatteryDialog(boolean p0);
    
    public abstract boolean isFirstOpenCreatePasscode();
    
    public abstract void setFirstOpenCreatePasscode(boolean p0);
    
    public abstract int getLanguageScrollPosition();
    
    public abstract void setLanguageScrollPosition(int p0);
    
    public abstract boolean isFirstOpenHome();
    
    public abstract void setFirstOpenHome(boolean p0);
    
    public abstract long getStartTimer();
    
    public abstract void setStartTimer(long p0);
    
    public abstract long getFinishTimer();
    
    public abstract void setFinishTimer(long p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getVoiceRealPasscode();
    
    public abstract void setVoiceRealPasscode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
}