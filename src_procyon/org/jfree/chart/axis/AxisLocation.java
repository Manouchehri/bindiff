package org.jfree.chart.axis;

import java.io.*;

public final class AxisLocation implements Serializable
{
    private static final long serialVersionUID = -3276922179323563410L;
    public static final AxisLocation TOP_OR_LEFT;
    public static final AxisLocation TOP_OR_RIGHT;
    public static final AxisLocation BOTTOM_OR_LEFT;
    public static final AxisLocation BOTTOM_OR_RIGHT;
    private String name;
    
    private AxisLocation(final String name) {
        this.name = name;
    }
    
    public AxisLocation getOpposite() {
        return getOpposite(this);
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof AxisLocation && this.name.equals(((AxisLocation)o).toString()));
    }
    
    public static AxisLocation getOpposite(final AxisLocation axisLocation) {
        if (axisLocation == null) {
            throw new IllegalArgumentException("Null 'location' argument.");
        }
        AxisLocation axisLocation2;
        if (axisLocation == AxisLocation.TOP_OR_LEFT) {
            axisLocation2 = AxisLocation.BOTTOM_OR_RIGHT;
        }
        else if (axisLocation == AxisLocation.TOP_OR_RIGHT) {
            axisLocation2 = AxisLocation.BOTTOM_OR_LEFT;
        }
        else if (axisLocation == AxisLocation.BOTTOM_OR_LEFT) {
            axisLocation2 = AxisLocation.TOP_OR_RIGHT;
        }
        else {
            if (axisLocation != AxisLocation.BOTTOM_OR_RIGHT) {
                throw new IllegalStateException("AxisLocation not recognised.");
            }
            axisLocation2 = AxisLocation.TOP_OR_LEFT;
        }
        return axisLocation2;
    }
    
    private Object readResolve() {
        if (this.equals(AxisLocation.TOP_OR_RIGHT)) {
            return AxisLocation.TOP_OR_RIGHT;
        }
        if (this.equals(AxisLocation.BOTTOM_OR_RIGHT)) {
            return AxisLocation.BOTTOM_OR_RIGHT;
        }
        if (this.equals(AxisLocation.TOP_OR_LEFT)) {
            return AxisLocation.TOP_OR_LEFT;
        }
        if (this.equals(AxisLocation.BOTTOM_OR_LEFT)) {
            return AxisLocation.BOTTOM_OR_LEFT;
        }
        return null;
    }
    
    static {
        TOP_OR_LEFT = new AxisLocation("AxisLocation.TOP_OR_LEFT");
        TOP_OR_RIGHT = new AxisLocation("AxisLocation.TOP_OR_RIGHT");
        BOTTOM_OR_LEFT = new AxisLocation("AxisLocation.BOTTOM_OR_LEFT");
        BOTTOM_OR_RIGHT = new AxisLocation("AxisLocation.BOTTOM_OR_RIGHT");
    }
}
