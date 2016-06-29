package org.jfree.chart.labels;

import java.io.*;

public final class ItemLabelAnchor implements Serializable
{
    private static final long serialVersionUID = -1233101616128695658L;
    public static final ItemLabelAnchor CENTER;
    public static final ItemLabelAnchor INSIDE1;
    public static final ItemLabelAnchor INSIDE2;
    public static final ItemLabelAnchor INSIDE3;
    public static final ItemLabelAnchor INSIDE4;
    public static final ItemLabelAnchor INSIDE5;
    public static final ItemLabelAnchor INSIDE6;
    public static final ItemLabelAnchor INSIDE7;
    public static final ItemLabelAnchor INSIDE8;
    public static final ItemLabelAnchor INSIDE9;
    public static final ItemLabelAnchor INSIDE10;
    public static final ItemLabelAnchor INSIDE11;
    public static final ItemLabelAnchor INSIDE12;
    public static final ItemLabelAnchor OUTSIDE1;
    public static final ItemLabelAnchor OUTSIDE2;
    public static final ItemLabelAnchor OUTSIDE3;
    public static final ItemLabelAnchor OUTSIDE4;
    public static final ItemLabelAnchor OUTSIDE5;
    public static final ItemLabelAnchor OUTSIDE6;
    public static final ItemLabelAnchor OUTSIDE7;
    public static final ItemLabelAnchor OUTSIDE8;
    public static final ItemLabelAnchor OUTSIDE9;
    public static final ItemLabelAnchor OUTSIDE10;
    public static final ItemLabelAnchor OUTSIDE11;
    public static final ItemLabelAnchor OUTSIDE12;
    private String name;
    
    private ItemLabelAnchor(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof ItemLabelAnchor && this.name.equals(((ItemLabelAnchor)o).toString()));
    }
    
    private Object readResolve() {
        Object o = null;
        if (this.equals(ItemLabelAnchor.CENTER)) {
            o = ItemLabelAnchor.CENTER;
        }
        else if (this.equals(ItemLabelAnchor.INSIDE1)) {
            o = ItemLabelAnchor.INSIDE1;
        }
        else if (this.equals(ItemLabelAnchor.INSIDE2)) {
            o = ItemLabelAnchor.INSIDE2;
        }
        else if (this.equals(ItemLabelAnchor.INSIDE3)) {
            o = ItemLabelAnchor.INSIDE3;
        }
        else if (this.equals(ItemLabelAnchor.INSIDE4)) {
            o = ItemLabelAnchor.INSIDE4;
        }
        else if (this.equals(ItemLabelAnchor.INSIDE5)) {
            o = ItemLabelAnchor.INSIDE5;
        }
        else if (this.equals(ItemLabelAnchor.INSIDE6)) {
            o = ItemLabelAnchor.INSIDE6;
        }
        else if (this.equals(ItemLabelAnchor.INSIDE7)) {
            o = ItemLabelAnchor.INSIDE7;
        }
        else if (this.equals(ItemLabelAnchor.INSIDE8)) {
            o = ItemLabelAnchor.INSIDE8;
        }
        else if (this.equals(ItemLabelAnchor.INSIDE9)) {
            o = ItemLabelAnchor.INSIDE9;
        }
        else if (this.equals(ItemLabelAnchor.INSIDE10)) {
            o = ItemLabelAnchor.INSIDE10;
        }
        else if (this.equals(ItemLabelAnchor.INSIDE11)) {
            o = ItemLabelAnchor.INSIDE11;
        }
        else if (this.equals(ItemLabelAnchor.INSIDE12)) {
            o = ItemLabelAnchor.INSIDE12;
        }
        else if (this.equals(ItemLabelAnchor.OUTSIDE1)) {
            o = ItemLabelAnchor.OUTSIDE1;
        }
        else if (this.equals(ItemLabelAnchor.OUTSIDE2)) {
            o = ItemLabelAnchor.OUTSIDE2;
        }
        else if (this.equals(ItemLabelAnchor.OUTSIDE3)) {
            o = ItemLabelAnchor.OUTSIDE3;
        }
        else if (this.equals(ItemLabelAnchor.OUTSIDE4)) {
            o = ItemLabelAnchor.OUTSIDE4;
        }
        else if (this.equals(ItemLabelAnchor.OUTSIDE5)) {
            o = ItemLabelAnchor.OUTSIDE5;
        }
        else if (this.equals(ItemLabelAnchor.OUTSIDE6)) {
            o = ItemLabelAnchor.OUTSIDE6;
        }
        else if (this.equals(ItemLabelAnchor.OUTSIDE7)) {
            o = ItemLabelAnchor.OUTSIDE7;
        }
        else if (this.equals(ItemLabelAnchor.OUTSIDE8)) {
            o = ItemLabelAnchor.OUTSIDE8;
        }
        else if (this.equals(ItemLabelAnchor.OUTSIDE9)) {
            o = ItemLabelAnchor.OUTSIDE9;
        }
        else if (this.equals(ItemLabelAnchor.OUTSIDE10)) {
            o = ItemLabelAnchor.OUTSIDE10;
        }
        else if (this.equals(ItemLabelAnchor.OUTSIDE11)) {
            o = ItemLabelAnchor.OUTSIDE11;
        }
        else if (this.equals(ItemLabelAnchor.OUTSIDE12)) {
            o = ItemLabelAnchor.OUTSIDE12;
        }
        return o;
    }
    
    static {
        CENTER = new ItemLabelAnchor("ItemLabelAnchor.CENTER");
        INSIDE1 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE1");
        INSIDE2 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE2");
        INSIDE3 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE3");
        INSIDE4 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE4");
        INSIDE5 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE5");
        INSIDE6 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE6");
        INSIDE7 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE7");
        INSIDE8 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE8");
        INSIDE9 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE9");
        INSIDE10 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE10");
        INSIDE11 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE11");
        INSIDE12 = new ItemLabelAnchor("ItemLabelAnchor.INSIDE12");
        OUTSIDE1 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE1");
        OUTSIDE2 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE2");
        OUTSIDE3 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE3");
        OUTSIDE4 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE4");
        OUTSIDE5 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE5");
        OUTSIDE6 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE6");
        OUTSIDE7 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE7");
        OUTSIDE8 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE8");
        OUTSIDE9 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE9");
        OUTSIDE10 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE10");
        OUTSIDE11 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE11");
        OUTSIDE12 = new ItemLabelAnchor("ItemLabelAnchor.OUTSIDE12");
    }
}
