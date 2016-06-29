package org.jfree.chart.axis;

import java.io.*;

public final class CategoryAnchor implements Serializable
{
    private static final long serialVersionUID = -2604142742210173810L;
    public static final CategoryAnchor START;
    public static final CategoryAnchor MIDDLE;
    public static final CategoryAnchor END;
    private String name;
    
    private CategoryAnchor(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof CategoryAnchor && this.name.equals(((CategoryAnchor)o).toString()));
    }
    
    private Object readResolve() {
        if (this.equals(CategoryAnchor.START)) {
            return CategoryAnchor.START;
        }
        if (this.equals(CategoryAnchor.MIDDLE)) {
            return CategoryAnchor.MIDDLE;
        }
        if (this.equals(CategoryAnchor.END)) {
            return CategoryAnchor.END;
        }
        return null;
    }
    
    static {
        START = new CategoryAnchor("CategoryAnchor.START");
        MIDDLE = new CategoryAnchor("CategoryAnchor.MIDDLE");
        END = new CategoryAnchor("CategoryAnchor.END");
    }
}
