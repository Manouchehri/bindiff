/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base.log;

import org.jfree.base.log.LogConfiguration;
import org.jfree.util.Log;
import org.jfree.util.LogTarget;
import org.jfree.util.PrintStreamLogTarget;

public class DefaultLog
extends Log {
    private static final PrintStreamLogTarget DEFAULT_LOG_TARGET = new PrintStreamLogTarget();
    private static final DefaultLog defaultLogInstance = new DefaultLog();

    protected DefaultLog() {
    }

    @Override
    public void init() {
        this.removeTarget(DEFAULT_LOG_TARGET);
        String string = LogConfiguration.getLogLevel();
        if (string.equalsIgnoreCase("error")) {
            this.setDebuglevel(0);
            return;
        }
        if (string.equalsIgnoreCase("warn")) {
            this.setDebuglevel(1);
            return;
        }
        if (string.equalsIgnoreCase("info")) {
            this.setDebuglevel(2);
            return;
        }
        if (!string.equalsIgnoreCase("debug")) return;
        this.setDebuglevel(3);
    }

    @Override
    public synchronized void addTarget(LogTarget logTarget) {
        super.addTarget(logTarget);
        if (logTarget == DEFAULT_LOG_TARGET) return;
        this.removeTarget(DEFAULT_LOG_TARGET);
    }

    public static DefaultLog getDefaultLog() {
        return defaultLogInstance;
    }

    public static void installDefaultLog() {
        Log.defineLog(defaultLogInstance);
    }

    static {
        defaultLogInstance.addTarget(DEFAULT_LOG_TARGET);
        try {
            String string = System.getProperty("org.jfree.DebugDefault", "false");
            if (Boolean.valueOf(string).booleanValue()) {
                defaultLogInstance.setDebuglevel(3);
                return;
            }
            defaultLogInstance.setDebuglevel(1);
            return;
        }
        catch (SecurityException var0_1) {
            defaultLogInstance.setDebuglevel(1);
        }
    }
}

