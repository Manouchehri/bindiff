/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.io.Serializable;

public final class AxisLocation
implements Serializable {
    private static final long serialVersionUID = -3276922179323563410L;
    public static final AxisLocation TOP_OR_LEFT = new AxisLocation("AxisLocation.TOP_OR_LEFT");
    public static final AxisLocation TOP_OR_RIGHT = new AxisLocation("AxisLocation.TOP_OR_RIGHT");
    public static final AxisLocation BOTTOM_OR_LEFT = new AxisLocation("AxisLocation.BOTTOM_OR_LEFT");
    public static final AxisLocation BOTTOM_OR_RIGHT = new AxisLocation("AxisLocation.BOTTOM_OR_RIGHT");
    private String name;

    private AxisLocation(String string) {
        this.name = string;
    }

    public AxisLocation getOpposite() {
        return AxisLocation.getOpposite(this);
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AxisLocation)) {
            return false;
        }
        AxisLocation axisLocation = (AxisLocation)object;
        if (this.name.equals(axisLocation.toString())) return true;
        return false;
    }

    public static AxisLocation getOpposite(AxisLocation axisLocation) {
        if (axisLocation == null) {
            throw new IllegalArgumentException("Null 'location' argument.");
        }
        AxisLocation axisLocation2 = null;
        if (axisLocation == TOP_OR_LEFT) {
            return BOTTOM_OR_RIGHT;
        }
        if (axisLocation == TOP_OR_RIGHT) {
            return BOTTOM_OR_LEFT;
        }
        if (axisLocation == BOTTOM_OR_LEFT) {
            return TOP_OR_RIGHT;
        }
        if (axisLocation != BOTTOM_OR_RIGHT) throw new IllegalStateException("AxisLocation not recognised.");
        return TOP_OR_LEFT;
    }

    private Object readResolve() {
        if (this.equals(TOP_OR_RIGHT)) {
            return TOP_OR_RIGHT;
        }
        if (this.equals(BOTTOM_OR_RIGHT)) {
            return BOTTOM_OR_RIGHT;
        }
        if (this.equals(TOP_OR_LEFT)) {
            return TOP_OR_LEFT;
        }
        if (!this.equals(BOTTOM_OR_LEFT)) return null;
        return BOTTOM_OR_LEFT;
    }
}

