package org.jfree.util;

public class LogContext
{
    private String contextPrefix;
    
    public LogContext(final String contextPrefix) {
        this.contextPrefix = contextPrefix;
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
    
    public void debug(final Object o) {
        this.log(3, o);
    }
    
    public void debug(final Object o, final Exception ex) {
        this.log(3, o, ex);
    }
    
    public void info(final Object o) {
        this.log(2, o);
    }
    
    public void info(final Object o, final Exception ex) {
        this.log(2, o, ex);
    }
    
    public void warn(final Object o) {
        this.log(1, o);
    }
    
    public void warn(final Object o, final Exception ex) {
        this.log(1, o, ex);
    }
    
    public void error(final Object o) {
        this.log(0, o);
    }
    
    public void error(final Object o, final Exception ex) {
        this.log(0, o, ex);
    }
    
    public void log(final int n, final Object o) {
        if (this.contextPrefix != null) {
            Log.getInstance().doLog(n, new Log$SimpleMessage(this.contextPrefix, ":", o));
        }
        else {
            Log.getInstance().doLog(n, o);
        }
    }
    
    public void log(final int n, final Object o, final Exception ex) {
        if (this.contextPrefix != null) {
            Log.getInstance().doLog(n, new Log$SimpleMessage(this.contextPrefix, ":", o), ex);
        }
        else {
            Log.getInstance().doLog(n, o, ex);
        }
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LogContext)) {
            return false;
        }
        final LogContext logContext = (LogContext)o;
        if (this.contextPrefix != null) {
            if (!this.contextPrefix.equals(logContext.contextPrefix)) {
                return false;
            }
        }
        else if (logContext.contextPrefix != null) {
            return false;
        }
        return true;
    }
    
    public int hashCode() {
        return (this.contextPrefix != null) ? this.contextPrefix.hashCode() : 0;
    }
}
