package com.dev.baseproject.remote

import com.dev.baseproject.data.CommonInfo

class RemoteConfig {
    companion object {
        const val EU_SERVER_REGION =
            ",al,ad,at,by,be,ba,bg,hr,cy,cz,dk,ee,fo,fi,fr,de,gi,gr,hu,is,ie,im,in,it,rs,lv,li,lt,lu,mk,mt,md,mc,me,nl,no,pl,pt,ro,ru,sm,rs,sk,si,es,se,ch,ua,gb,va,rs,ml,so,ng,ci,uz,au,ye,mr,bf,ly,sn,za"
        const val ASIA_SERVER_REGION =
            ",af,am,az,bh,bd,bt,bn,kh,cx,cc,io,ge,id,ir,iq,il,jo,kz,kw,kg,la,lb,mo,my,mv,mn,mm,np,kp,om,ps,ph,qa,sa,sg,lk,sy,tj,th,tr,tm,ae,vn,"
        const val EAST_ASIA_REGION = ",tw,jp,kr,hk,cn,"
        const val WEST_ASIAN = ",in,"

        var ANDROID_ID = "08A3885D9463AE365B56C859AF40041A"

        var commonInfo = CommonInfo()
    }
}