/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import org.jfree.util.Log;
import org.jfree.util.Log$SimpleMessage;

public class LogContext {
    private String contextPrefix;

    public LogContext(String string) {
        this.contextPrefix = string;
    }

    public boolean isDebugEnabled() {
        return Log.isDebugEnabled();
    }

    public boolean isInfoEnabled() {
        return Log.isInfoEnabled();
    }

    public boolean isWarningEnabled() {
        return Log.isWarningEnabled();
    }

    public boolean isErrorEnabled() {
        return Log.isErrorEnabled();
    }

    public void debug(Object object) {
        this.log(3, object);
    }

    public void debug(Object object, Exception exception) {
        this.log(3, object, exception);
    }

    public void info(Object object) {
        this.log(2, object);
    }

    public void info(Object object, Exception exception) {
        this.log(2, object, exception);
    }

    public void warn(Object object) {
        this.log(1, object);
    }

    public void warn(Object object, Exception exception) {
        this.log(1, object, exception);
    }

    public void error(Object object) {
        this.log(0, object);
    }

    public void error(Object object, Exception exception) {
        this.log(0, object, exception);
    }

    public void log(int n2, Object object) {
        if (this.contextPrefix != null) {
            Log.getInstance().doLog(n2, new Log$SimpleMessage(this.contextPrefix, ":", object));
            return;
        }
        Log.getInstance().doLog(n2, object);
    }

    public void log(int n2, Object object, Exception exception) {
        if (this.contextPrefix != null) {
            Log.getInstance().doLog(n2, new Log$SimpleMessage(this.contextPrefix, ":", object), exception);
            return;
        }
        Log.getInstance().doLog(n2, object, exception);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LogContext)) {
            return false;
        }
        LogContext logContext = (LogContext)object;
        if (this.contextPrefix != null) {
            if (this.contextPrefix.equals(logContext.contextPrefix)) return true;
            return false;
        }
        if (logContext.contextPrefix == null) return true;
        return false;
    }

    public int hashCode() {
        if (this.contextPrefix == null) return 0;
        int n2 = this.contextPrefix.hashCode();
        return n2;
    }
}

