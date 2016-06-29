package org.jfree.base.log;

import org.jfree.base.*;

public class LogConfiguration
{
    public static final String DISABLE_LOGGING_DEFAULT = "false";
    public static final String LOGLEVEL = "org.jfree.base.LogLevel";
    public static final String LOGLEVEL_DEFAULT = "Info";
    public static final String LOGTARGET = "org.jfree.base.LogTarget";
    public static final String LOGTARGET_DEFAULT;
    public static final String DISABLE_LOGGING = "org.jfree.base.NoDefaultDebug";
    static Class class$org$jfree$util$PrintStreamLogTarget;
    
    public static String getLogTarget() {
        return BaseBoot.getInstance().getGlobalConfig().getConfigProperty("org.jfree.base.LogTarget", LogConfiguration.LOGTARGET_DEFAULT);
    }
    
    public static void setLogTarget(final String s) {
        BaseBoot.getConfiguration().setConfigProperty("org.jfree.base.LogTarget", s);
    }
    
    public static String getLogLevel() {
        return BaseBoot.getInstance().getGlobalConfig().getConfigProperty("org.jfree.base.LogLevel", "Info");
    }
    
    public static void setLogLevel(final String s) {
        BaseBoot.getConfiguration().setConfigProperty("org.jfree.base.LogLevel", s);
    }
    
    public static boolean isDisableLogging() {
        return BaseBoot.getInstance().getGlobalConfig().getConfigProperty("org.jfree.base.NoDefaultDebug", "false").equalsIgnoreCase("true");
    }
    
    public static void setDisableLogging(final boolean b) {
        BaseBoot.getConfiguration().setConfigProperty("org.jfree.base.NoDefaultDebug", String.valueOf(b));
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        LOGTARGET_DEFAULT = ((LogConfiguration.class$org$jfree$util$PrintStreamLogTarget == null) ? (LogConfiguration.class$org$jfree$util$PrintStreamLogTarget = class$("org.jfree.util.PrintStreamLogTarget")) : LogConfiguration.class$org$jfree$util$PrintStreamLogTarget).getName();
    }
}
