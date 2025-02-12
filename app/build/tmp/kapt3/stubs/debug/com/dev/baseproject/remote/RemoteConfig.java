package com.dev.baseproject.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/dev/baseproject/remote/RemoteConfig;", "", "()V", "Companion", "RegionCode", "app_debug"})
public final class RemoteConfig {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EU_SERVER_REGION = ",al,ad,at,by,be,ba,bg,hr,cy,cz,dk,ee,fo,fi,fr,de,gi,gr,hu,is,ie,im,in,it,rs,lv,li,lt,lu,mk,mt,md,mc,me,nl,no,pl,pt,ro,ru,sm,rs,sk,si,es,se,ch,ua,gb,va,rs,ml,so,ng,ci,uz,au,ye,mr,bf,ly,sn,za";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ASIA_SERVER_REGION = ",af,am,az,bh,bd,bt,bn,kh,cx,cc,io,ge,id,ir,iq,il,jo,kz,kw,kg,la,lb,mo,my,mv,mn,mm,np,kp,om,ps,ph,qa,sa,sg,lk,sy,tj,th,tr,tm,ae,vn,";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EAST_ASIA_REGION = ",tw,jp,kr,hk,cn,";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WEST_ASIAN = ",in,";
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> langCountryCode = null;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String countryName = "VN";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DEFAULT_LANG = "OT";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String languageCode = "";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String ANDROID_ID = "08A3885D9463AE365B56C859AF40041A";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String DEFAULT_ENDPOINT = "";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String urlServerHosting = "https://funny-videos-2018-8b162.firebaseapp.com/configs-sdk28/baseprojectgz_data.json";
    @org.jetbrains.annotations.NotNull()
    private static com.dev.baseproject.data.CommonInfo commonInfo;
    @org.jetbrains.annotations.NotNull()
    public static final com.dev.baseproject.remote.RemoteConfig.Companion Companion = null;
    
    public RemoteConfig() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\'\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u0006R\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b\u00a8\u0006("}, d2 = {"Lcom/dev/baseproject/remote/RemoteConfig$Companion;", "", "()V", "ANDROID_ID", "", "getANDROID_ID", "()Ljava/lang/String;", "setANDROID_ID", "(Ljava/lang/String;)V", "ASIA_SERVER_REGION", "DEFAULT_ENDPOINT", "getDEFAULT_ENDPOINT", "setDEFAULT_ENDPOINT", "DEFAULT_LANG", "getDEFAULT_LANG", "EAST_ASIA_REGION", "EU_SERVER_REGION", "WEST_ASIAN", "commonInfo", "Lcom/dev/baseproject/data/CommonInfo;", "getCommonInfo", "()Lcom/dev/baseproject/data/CommonInfo;", "setCommonInfo", "(Lcom/dev/baseproject/data/CommonInfo;)V", "countryName", "getCountryName", "setCountryName", "langCountryCode", "", "getLangCountryCode", "()Ljava/util/List;", "language", "getLanguage", "languageCode", "getLanguageCode", "setLanguageCode", "urlServerHosting", "getUrlServerHosting", "setUrlServerHosting", "getRegion", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getLangCountryCode() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCountryName() {
            return null;
        }
        
        public final void setCountryName(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDEFAULT_LANG() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLanguage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLanguageCode() {
            return null;
        }
        
        public final void setLanguageCode(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getANDROID_ID() {
            return null;
        }
        
        public final void setANDROID_ID(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDEFAULT_ENDPOINT() {
            return null;
        }
        
        public final void setDEFAULT_ENDPOINT(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUrlServerHosting() {
            return null;
        }
        
        public final void setUrlServerHosting(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dev.baseproject.data.CommonInfo getCommonInfo() {
            return null;
        }
        
        public final void setCommonInfo(@org.jetbrains.annotations.NotNull()
        com.dev.baseproject.data.CommonInfo p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getRegion() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/dev/baseproject/remote/RemoteConfig$RegionCode;", "", "(Ljava/lang/String;I)V", "US", "EU", "AS", "EA", "WA", "app_debug"})
    public static enum RegionCode {
        /*public static final*/ US /* = new US() */,
        /*public static final*/ EU /* = new EU() */,
        /*public static final*/ AS /* = new AS() */,
        /*public static final*/ EA /* = new EA() */,
        /*public static final*/ WA /* = new WA() */;
        
        RegionCode() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.dev.baseproject.remote.RemoteConfig.RegionCode> getEntries() {
            return null;
        }
    }
}