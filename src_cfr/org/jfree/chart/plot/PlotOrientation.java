/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.io.Serializable;

public final class PlotOrientation
implements Serializable {
    private static final long serialVersionUID = -2508771828190337782L;
    public static final PlotOrientation HORIZONTAL = new PlotOrientation("PlotOrientation.HORIZONTAL");
    public static final PlotOrientation VERTICAL = new PlotOrientation("PlotOrientation.VERTICAL");
    private String name;

    private PlotOrientation(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlotOrientation)) {
            return false;
        }
        PlotOrientation plotOrientation = (PlotOrientation)object;
        if (this.name.equals(plotOrientation.toString())) return true;
        return false;
    }

    private Object readResolve() {
        PlotOrientation plotOrientation = null;
        if (this.equals(HORIZONTAL)) {
            return HORIZONTAL;
        }
        if (!this.equals(VERTICAL)) return plotOrientation;
        return VERTICAL;
    }
}

