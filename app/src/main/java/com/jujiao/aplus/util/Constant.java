package com.jujiao.aplus.util;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/9.
 */
public class Constant {

//    public final static String[] tabName = {"福利", "Android", "前端", "iOS", "拓展资源"};
    public static class TAB_TYPE {
        public static final int SURPRISE = 0X0000;
        public static final int ANDROID = 0X0001 ;
        public static final int HTML= 0X0002;
        public static final int IOS = 0X0003;
        public static final int MORE = 0X0004;
    }

    public static final Map<Integer, String> TABNAME = new HashMap<Integer, String>() {
        {
            put(TAB_TYPE.SURPRISE, "福利");
            put(TAB_TYPE.ANDROID, "Android");
            put(TAB_TYPE.HTML, "前端");
            put(TAB_TYPE.IOS, "iOS");
            put(TAB_TYPE.MORE, "拓展资源");
        }
    };


}
