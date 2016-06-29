/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.statistics;

import java.io.Serializable;

public class HistogramType
implements Serializable {
    private static final long serialVersionUID = 2618927186251997727L;
    public static final HistogramType FREQUENCY = new HistogramType("FREQUENCY");
    public static final HistogramType RELATIVE_FREQUENCY = new HistogramType("RELATIVE_FREQUENCY");
    public static final HistogramType SCALE_AREA_TO_1 = new HistogramType("SCALE_AREA_TO_1");
    private String name;

    private HistogramType(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof HistogramType)) {
            return false;
        }
        HistogramType histogramType = (HistogramType)object;
        if (this.name.equals(histogramType.name)) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    private Object readResolve() {
        if (this.equals(FREQUENCY)) {
            return FREQUENCY;
        }
        if (this.equals(RELATIVE_FREQUENCY)) {
            return RELATIVE_FREQUENCY;
        }
        if (!this.equals(SCALE_AREA_TO_1)) return null;
        return SCALE_AREA_TO_1;
    }
}

