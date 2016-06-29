package org.jfree.util;

public class Log$SimpleMessage
{
    private String message;
    private Object[] param;
    
    public Log$SimpleMessage(final String message, final Object o) {
        this.message = message;
        this.param = new Object[] { o };
    }
    
    public Log$SimpleMessage(final String message, final Object o, final Object o2) {
        this.message = message;
        this.param = new Object[] { o, o2 };
    }
    
    public Log$SimpleMessage(final String message, final Object o, final Object o2, final Object o3) {
        this.message = message;
        this.param = new Object[] { o, o2, o3 };
    }
    
    public Log$SimpleMessage(final String message, final Object o, final Object o2, final Object o3, final Object o4) {
        this.message = message;
        this.param = new Object[] { o, o2, o3, o4 };
    }
    
    public Log$SimpleMessage(final String message, final Object[] param) {
        this.message = message;
        this.param = param;
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(this.message);
        if (this.param != null) {
            for (int i = 0; i < this.param.length; ++i) {
                sb.append(this.param[i]);
            }
        }
        return sb.toString();
    }
}
