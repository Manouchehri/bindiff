/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.io.Serializable;

public final class CategoryAnchor
implements Serializable {
    private static final long serialVersionUID = -2604142742210173810L;
    public static final CategoryAnchor START = new CategoryAnchor("CategoryAnchor.START");
    public static final CategoryAnchor MIDDLE = new CategoryAnchor("CategoryAnchor.MIDDLE");
    public static final CategoryAnchor END = new CategoryAnchor("CategoryAnchor.END");
    private String name;

    private CategoryAnchor(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CategoryAnchor)) {
            return false;
        }
        CategoryAnchor categoryAnchor = (CategoryAnchor)object;
        if (this.name.equals(categoryAnchor.toString())) return true;
        return false;
    }

    private Object readResolve() {
        if (this.equals(START)) {
            return START;
        }
        if (this.equals(MIDDLE)) {
            return MIDDLE;
        }
        if (!this.equals(END)) return null;
        return END;
    }
}

