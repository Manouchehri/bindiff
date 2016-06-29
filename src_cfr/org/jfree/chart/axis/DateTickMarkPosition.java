/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.io.Serializable;

public final class DateTickMarkPosition
implements Serializable {
    private static final long serialVersionUID = 2540750672764537240L;
    public static final DateTickMarkPosition START = new DateTickMarkPosition("DateTickMarkPosition.START");
    public static final DateTickMarkPosition MIDDLE = new DateTickMarkPosition("DateTickMarkPosition.MIDDLE");
    public static final DateTickMarkPosition END = new DateTickMarkPosition("DateTickMarkPosition.END");
    private String name;

    private DateTickMarkPosition(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DateTickMarkPosition)) {
            return false;
        }
        DateTickMarkPosition dateTickMarkPosition = (DateTickMarkPosition)object;
        if (this.name.equals(dateTickMarkPosition.toString())) return true;
        return false;
    }

    private Object readResolve() {
        if (this.equals(START)) {
            return START;
        }
        if (this.equals(MIDDLE)) {
            return MIDDLE;
        }
        if (!this.equals(END)) return null;
        return END;
    }
}

