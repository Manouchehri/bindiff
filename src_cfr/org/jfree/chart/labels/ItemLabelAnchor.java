/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;

public final class ItemLabelAnchor
implements Serializable {
    private static final long serialVersionUID = -1233101616128695658L;
    public static final ItemLabelAnchor CENTER = new ItemLabelAnchor("ItemLabelAnchor.CENTER");
    public static final ItemLabelAnchor INSIDE1 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE1");
    public static final ItemLabelAnchor INSIDE2 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE2");
    public static final ItemLabelAnchor INSIDE3 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE3");
    public static final ItemLabelAnchor INSIDE4 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE4");
    public static final ItemLabelAnchor INSIDE5 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE5");
    public static final ItemLabelAnchor INSIDE6 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE6");
    public static final ItemLabelAnchor INSIDE7 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE7");
    public static final ItemLabelAnchor INSIDE8 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE8");
    public static final ItemLabelAnchor INSIDE9 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE9");
    public static final ItemLabelAnchor INSIDE10 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE10");
    public static final ItemLabelAnchor INSIDE11 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE11");
    public static final ItemLabelAnchor INSIDE12 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE12");
    public static final ItemLabelAnchor OUTSIDE1 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE1");
    public static final ItemLabelAnchor OUTSIDE2 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE2");
    public static final ItemLabelAnchor OUTSIDE3 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE3");
    public static final ItemLabelAnchor OUTSIDE4 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE4");
    public static final ItemLabelAnchor OUTSIDE5 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE5");
    public static final ItemLabelAnchor OUTSIDE6 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE6");
    public static final ItemLabelAnchor OUTSIDE7 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE7");
    public static final ItemLabelAnchor OUTSIDE8 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE8");
    public static final ItemLabelAnchor OUTSIDE9 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE9");
    public static final ItemLabelAnchor OUTSIDE10 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE10");
    public static final ItemLabelAnchor OUTSIDE11 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE11");
    public static final ItemLabelAnchor OUTSIDE12 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE12");
    private String name;

    private ItemLabelAnchor(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ItemLabelAnchor)) {
            return false;
        }
        ItemLabelAnchor itemLabelAnchor = (ItemLabelAnchor)object;
        if (this.name.equals(itemLabelAnchor.toString())) return true;
        return false;
    }

    private Object readResolve() {
        ItemLabelAnchor itemLabelAnchor = null;
        if (this.equals(CENTER)) {
            return CENTER;
        }
        if (this.equals(INSIDE1)) {
            return INSIDE1;
        }
        if (this.equals(INSIDE2)) {
            return INSIDE2;
        }
        if (this.equals(INSIDE3)) {
            return INSIDE3;
        }
        if (this.equals(INSIDE4)) {
            return INSIDE4;
        }
        if (this.equals(INSIDE5)) {
            return INSIDE5;
        }
        if (this.equals(INSIDE6)) {
            return INSIDE6;
        }
        if (this.equals(INSIDE7)) {
            return INSIDE7;
        }
        if (this.equals(INSIDE8)) {
            return INSIDE8;
        }
        if (this.equals(INSIDE9)) {
            return INSIDE9;
        }
        if (this.equals(INSIDE10)) {
            return INSIDE10;
        }
        if (this.equals(INSIDE11)) {
            return INSIDE11;
        }
        if (this.equals(INSIDE12)) {
            return INSIDE12;
        }
        if (this.equals(OUTSIDE1)) {
            return OUTSIDE1;
        }
        if (this.equals(OUTSIDE2)) {
            return OUTSIDE2;
        }
        if (this.equals(OUTSIDE3)) {
            return OUTSIDE3;
        }
        if (this.equals(OUTSIDE4)) {
            return OUTSIDE4;
        }
        if (this.equals(OUTSIDE5)) {
            return OUTSIDE5;
        }
        if (this.equals(OUTSIDE6)) {
            return OUTSIDE6;
        }
        if (this.equals(OUTSIDE7)) {
            return OUTSIDE7;
        }
        if (this.equals(OUTSIDE8)) {
            return OUTSIDE8;
        }
        if (this.equals(OUTSIDE9)) {
            return OUTSIDE9;
        }
        if (this.equals(OUTSIDE10)) {
            return OUTSIDE10;
        }
        if (this.equals(OUTSIDE11)) {
            return OUTSIDE11;
        }
        if (!this.equals(OUTSIDE12)) return itemLabelAnchor;
        return OUTSIDE12;
    }
}

