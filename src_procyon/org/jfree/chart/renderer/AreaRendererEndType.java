package org.jfree.chart.renderer;

import java.io.*;

public final class AreaRendererEndType implements Serializable
{
    private static final long serialVersionUID = -1774146392916359839L;
    public static final AreaRendererEndType TAPER;
    public static final AreaRendererEndType TRUNCATE;
    public static final AreaRendererEndType LEVEL;
    private String name;
    
    private AreaRendererEndType(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof AreaRendererEndType && this.name.equals(((AreaRendererEndType)o).toString()));
    }
    
    private Object readResolve() {
        Object o = null;
        if (this.equals(AreaRendererEndType.LEVEL)) {
            o = AreaRendererEndType.LEVEL;
        }
        else if (this.equals(AreaRendererEndType.TAPER)) {
            o = AreaRendererEndType.TAPER;
        }
        else if (this.equals(AreaRendererEndType.TRUNCATE)) {
            o = AreaRendererEndType.TRUNCATE;
        }
        return o;
    }
    
    static {
        TAPER = new AreaRendererEndType("AreaRendererEndType.TAPER");
        TRUNCATE = new AreaRendererEndType("AreaRendererEndType.TRUNCATE");
        LEVEL = new AreaRendererEndType("AreaRendererEndType.LEVEL");
    }
}
