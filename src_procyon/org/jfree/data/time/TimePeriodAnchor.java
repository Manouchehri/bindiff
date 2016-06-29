package org.jfree.data.time;

import java.io.*;

public final class TimePeriodAnchor implements Serializable
{
    private static final long serialVersionUID = 2011955697457548862L;
    public static final TimePeriodAnchor START;
    public static final TimePeriodAnchor MIDDLE;
    public static final TimePeriodAnchor END;
    private String name;
    
    private TimePeriodAnchor(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof TimePeriodAnchor && this.name.equals(((TimePeriodAnchor)o).name));
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
    
    private Object readResolve() {
        if (this.equals(TimePeriodAnchor.START)) {
            return TimePeriodAnchor.START;
        }
        if (this.equals(TimePeriodAnchor.MIDDLE)) {
            return TimePeriodAnchor.MIDDLE;
        }
        if (this.equals(TimePeriodAnchor.END)) {
            return TimePeriodAnchor.END;
        }
        return null;
    }
    
    static {
        START = new TimePeriodAnchor("TimePeriodAnchor.START");
        MIDDLE = new TimePeriodAnchor("TimePeriodAnchor.MIDDLE");
        END = new TimePeriodAnchor("TimePeriodAnchor.END");
    }
}
