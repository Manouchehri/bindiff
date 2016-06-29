/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

public class Log$SimpleMessage {
    private String message;
    private Object[] param;

    public Log$SimpleMessage(String string, Object object) {
        this.message = string;
        this.param = new Object[]{object};
    }

    public Log$SimpleMessage(String string, Object object, Object object2) {
        this.message = string;
        this.param = new Object[]{object, object2};
    }

    public Log$SimpleMessage(String string, Object object, Object object2, Object object3) {
        this.message = string;
        this.param = new Object[]{object, object2, object3};
    }

    public Log$SimpleMessage(String string, Object object, Object object2, Object object3, Object object4) {
        this.message = string;
        this.param = new Object[]{object, object2, object3, object4};
    }

    public Log$SimpleMessage(String string, Object[] arrobject) {
        this.message = string;
        this.param = arrobject;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.message);
        if (this.param == null) return stringBuffer.toString();
        int n2 = 0;
        while (n2 < this.param.length) {
            stringBuffer.append(this.param[n2]);
            ++n2;
        }
        return stringBuffer.toString();
    }
}

