package sl.pick.wheel.utils;

import android.util.Log;

/**
 * Created by xuzhijix on 2016/11/25.
 */
public class UtilsLog {
    public static String DebugTag = "xzj";

    public static void logE(Object msg) {
        Log.e(DebugTag, getLineInfo()+msg.toString());
    }

    public static String getLineInfo()
    {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return ste.getFileName() + ": Line " + ste.getLineNumber();
    }

}
