/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base.log;

import org.jfree.base.BaseBoot;
import org.jfree.util.Configuration;

public class LogConfiguration {
    public static final String DISABLE_LOGGING_DEFAULT = "false";
    public static final String LOGLEVEL = "org.jfree.base.LogLevel";
    public static final String LOGLEVEL_DEFAULT = "Info";
    public static final String LOGTARGET = "org.jfree.base.LogTarget";
    public static final String LOGTARGET_DEFAULT;
    public static final String DISABLE_LOGGING = "org.jfree.base.NoDefaultDebug";
    static Class class$org$jfree$util$PrintStreamLogTarget;

    private LogConfiguration() {
    }

    public static String getLogTarget() {
        return BaseBoot.getInstance().getGlobalConfig().getConfigProperty("org.jfree.base.LogTarget", LOGTARGET_DEFAULT);
    }

    public static void setLogTarget(String string) {
        BaseBoot.getConfiguration().setConfigProperty("org.jfree.base.LogTarget", string);
    }

    public static String getLogLevel() {
        return BaseBoot.getInstance().getGlobalConfig().getConfigProperty("org.jfree.base.LogLevel", "Info");
    }

    public static void setLogLevel(String string) {
        BaseBoot.getConfiguration().setConfigProperty("org.jfree.base.LogLevel", string);
    }

    public static boolean isDisableLogging() {
        return BaseBoot.getInstance().getGlobalConfig().getConfigProperty("org.jfree.base.NoDefaultDebug", "false").equalsIgnoreCase("true");
    }

    public static void setDisableLogging(boolean bl2) {
        BaseBoot.getConfiguration().setConfigProperty("org.jfree.base.NoDefaultDebug", String.valueOf(bl2));
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }

    static {
        Class class_ = class$org$jfree$util$PrintStreamLogTarget == null ? (LogConfiguration.class$org$jfree$util$PrintStreamLogTarget = LogConfiguration.class$("org.jfree.util.PrintStreamLogTarget")) : class$org$jfree$util$PrintStreamLogTarget;
        LOGTARGET_DEFAULT = class_.getName();
    }
}

