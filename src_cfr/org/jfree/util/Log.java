/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import org.jfree.util.LogContext;
import org.jfree.util.LogTarget;

public class Log {
    private int debuglevel = 100;
    private LogTarget[] logTargets = new LogTarget[0];
    private HashMap logContexts = new HashMap();
    private static Log singleton;

    protected Log() {
    }

    public static synchronized Log getInstance() {
        if (singleton != null) return singleton;
        singleton = new Log();
        return singleton;
    }

    protected static synchronized void defineLog(Log log) {
        singleton = log;
    }

    public int getDebuglevel() {
        return this.debuglevel;
    }

    protected void setDebuglevel(int n2) {
        this.debuglevel = n2;
    }

    public synchronized void addTarget(LogTarget logTarget) {
        if (logTarget == null) {
            throw new NullPointerException();
        }
        LogTarget[] arrlogTarget = new LogTarget[this.logTargets.length + 1];
        System.arraycopy(this.logTargets, 0, arrlogTarget, 0, this.logTargets.length);
        arrlogTarget[this.logTargets.length] = logTarget;
        this.logTargets = arrlogTarget;
    }

    public synchronized void removeTarget(LogTarget logTarget) {
        if (logTarget == null) {
            throw new NullPointerException();
        }
        ArrayList<LogTarget> arrayList = new ArrayList<LogTarget>();
        arrayList.addAll(Arrays.asList(this.logTargets));
        arrayList.remove(logTarget);
        LogTarget[] arrlogTarget = new LogTarget[arrayList.size()];
        this.logTargets = arrayList.toArray(arrlogTarget);
    }

    public LogTarget[] getTargets() {
        return (LogTarget[])this.logTargets.clone();
    }

    public synchronized void replaceTargets(LogTarget logTarget) {
        if (logTarget == null) {
            throw new NullPointerException();
        }
        this.logTargets = new LogTarget[]{logTarget};
    }

    public static void debug(Object object) {
        Log.log(3, object);
    }

    public static void debug(Object object, Exception exception) {
        Log.log(3, object, exception);
    }

    public static void info(Object object) {
        Log.log(2, object);
    }

    public static void info(Object object, Exception exception) {
        Log.log(2, object, exception);
    }

    public static void warn(Object object) {
        Log.log(1, object);
    }

    public static void warn(Object object, Exception exception) {
        Log.log(1, object, exception);
    }

    public static void error(Object object) {
        Log.log(0, object);
    }

    public static void error(Object object, Exception exception) {
        Log.log(0, object, exception);
    }

    protected void doLog(int n2, Object object) {
        if (n2 > 3) {
            n2 = 3;
        }
        if (n2 > this.debuglevel) return;
        int n3 = 0;
        while (n3 < this.logTargets.length) {
            LogTarget logTarget = this.logTargets[n3];
            logTarget.log(n2, object);
            ++n3;
        }
    }

    public static void log(int n2, Object object) {
        Log.getInstance().doLog(n2, object);
    }

    public static void log(int n2, Object object, Exception exception) {
        Log.getInstance().doLog(n2, object, exception);
    }

    protected void doLog(int n2, Object object, Exception exception) {
        if (n2 > 3) {
            n2 = 3;
        }
        if (n2 > this.debuglevel) return;
        int n3 = 0;
        while (n3 < this.logTargets.length) {
            LogTarget logTarget = this.logTargets[n3];
            logTarget.log(n2, object, exception);
            ++n3;
        }
    }

    public void init() {
    }

    public static boolean isDebugEnabled() {
        if (Log.getInstance().getDebuglevel() < 3) return false;
        return true;
    }

    public static boolean isInfoEnabled() {
        if (Log.getInstance().getDebuglevel() < 2) return false;
        return true;
    }

    public static boolean isWarningEnabled() {
        if (Log.getInstance().getDebuglevel() < 1) return false;
        return true;
    }

    public static boolean isErrorEnabled() {
        if (Log.getInstance().getDebuglevel() < 0) return false;
        return true;
    }

    public static LogContext createContext(Class class_) {
        return Log.createContext(class_.getName());
    }

    public static LogContext createContext(String string) {
        return Log.getInstance().internalCreateContext(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected LogContext internalCreateContext(String string) {
        Log log = this;
        synchronized (log) {
            LogContext logContext = (LogContext)this.logContexts.get(string);
            if (logContext != null) return logContext;
            logContext = new LogContext(string);
            this.logContexts.put(string, logContext);
            return logContext;
        }
    }
}

