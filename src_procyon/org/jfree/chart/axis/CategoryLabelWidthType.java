package org.jfree.chart.axis;

import java.io.*;

public final class CategoryLabelWidthType implements Serializable
{
    private static final long serialVersionUID = -6976024792582949656L;
    public static final CategoryLabelWidthType CATEGORY;
    public static final CategoryLabelWidthType RANGE;
    private String name;
    
    private CategoryLabelWidthType(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("Null 'name' argument.");
        }
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof CategoryLabelWidthType && this.name.equals(((CategoryLabelWidthType)o).toString()));
    }
    
    private Object readResolve() {
        if (this.equals(CategoryLabelWidthType.CATEGORY)) {
            return CategoryLabelWidthType.CATEGORY;
        }
        if (this.equals(CategoryLabelWidthType.RANGE)) {
            return CategoryLabelWidthType.RANGE;
        }
        return null;
    }
    
    static {
        CATEGORY = new CategoryLabelWidthType("CategoryLabelWidthType.CATEGORY");
        RANGE = new CategoryLabelWidthType("CategoryLabelWidthType.RANGE");
    }
}
