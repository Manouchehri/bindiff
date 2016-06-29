/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer;

import java.io.Serializable;

public final class AreaRendererEndType
implements Serializable {
    private static final long serialVersionUID = -1774146392916359839L;
    public static final AreaRendererEndType TAPER = new AreaRendererEndType("AreaRendererEndType.TAPER");
    public static final AreaRendererEndType TRUNCATE = new AreaRendererEndType("AreaRendererEndType.TRUNCATE");
    public static final AreaRendererEndType LEVEL = new AreaRendererEndType("AreaRendererEndType.LEVEL");
    private String name;

    private AreaRendererEndType(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AreaRendererEndType)) {
            return false;
        }
        AreaRendererEndType areaRendererEndType = (AreaRendererEndType)object;
        if (this.name.equals(areaRendererEndType.toString())) return true;
        return false;
    }

    private Object readResolve() {
        AreaRendererEndType areaRendererEndType = null;
        if (this.equals(LEVEL)) {
            return LEVEL;
        }
        if (this.equals(TAPER)) {
            return TAPER;
        }
        if (!this.equals(TRUNCATE)) return areaRendererEndType;
        return TRUNCATE;
    }
}

