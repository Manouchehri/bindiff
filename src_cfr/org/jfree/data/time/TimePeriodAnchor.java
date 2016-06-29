/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.io.Serializable;

public final class TimePeriodAnchor
implements Serializable {
    private static final long serialVersionUID = 2011955697457548862L;
    public static final TimePeriodAnchor START = new TimePeriodAnchor("TimePeriodAnchor.START");
    public static final TimePeriodAnchor MIDDLE = new TimePeriodAnchor("TimePeriodAnchor.MIDDLE");
    public static final TimePeriodAnchor END = new TimePeriodAnchor("TimePeriodAnchor.END");
    private String name;

    private TimePeriodAnchor(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof TimePeriodAnchor)) {
            return false;
        }
        TimePeriodAnchor timePeriodAnchor = (TimePeriodAnchor)object;
        if (this.name.equals(timePeriodAnchor.name)) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
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

