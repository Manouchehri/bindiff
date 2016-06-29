/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.io.Serializable;

public final class CategoryLabelWidthType
implements Serializable {
    private static final long serialVersionUID = -6976024792582949656L;
    public static final CategoryLabelWidthType CATEGORY = new CategoryLabelWidthType("CategoryLabelWidthType.CATEGORY");
    public static final CategoryLabelWidthType RANGE = new CategoryLabelWidthType("CategoryLabelWidthType.RANGE");
    private String name;

    private CategoryLabelWidthType(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'name' argument.");
        }
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CategoryLabelWidthType)) {
            return false;
        }
        CategoryLabelWidthType categoryLabelWidthType = (CategoryLabelWidthType)object;
        if (this.name.equals(categoryLabelWidthType.toString())) return true;
        return false;
    }

    private Object readResolve() {
        if (this.equals(CATEGORY)) {
            return CATEGORY;
        }
        if (!this.equals(RANGE)) return null;
        return RANGE;
    }
}

