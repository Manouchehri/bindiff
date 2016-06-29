package org.jfree.chart.axis;

import java.io.*;

public final class DateTickMarkPosition implements Serializable
{
    private static final long serialVersionUID = 2540750672764537240L;
    public static final DateTickMarkPosition START;
    public static final DateTickMarkPosition MIDDLE;
    public static final DateTickMarkPosition END;
    private String name;
    
    private DateTickMarkPosition(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof DateTickMarkPosition && this.name.equals(((DateTickMarkPosition)o).toString()));
    }
    
    private Object readResolve() {
        if (this.equals(DateTickMarkPosition.START)) {
            return DateTickMarkPosition.START;
        }
        if (this.equals(DateTickMarkPosition.MIDDLE)) {
            return DateTickMarkPosition.MIDDLE;
        }
        if (this.equals(DateTickMarkPosition.END)) {
            return DateTickMarkPosition.END;
        }
        return null;
    }
    
    static {
        START = new DateTickMarkPosition("DateTickMarkPosition.START");
        MIDDLE = new DateTickMarkPosition("DateTickMarkPosition.MIDDLE");
        END = new DateTickMarkPosition("DateTickMarkPosition.END");
    }
}
