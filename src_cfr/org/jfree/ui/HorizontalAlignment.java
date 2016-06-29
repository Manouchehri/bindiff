/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.io.Serializable;

public final class HorizontalAlignment
implements Serializable {
    private static final long serialVersionUID = -8249740987565309567L;
    public static final HorizontalAlignment LEFT = new HorizontalAlignment("HorizontalAlignment.LEFT");
    public static final HorizontalAlignment RIGHT = new HorizontalAlignment("HorizontalAlignment.RIGHT");
    public static final HorizontalAlignment CENTER = new HorizontalAlignment("HorizontalAlignment.CENTER");
    private String name;

    private HorizontalAlignment(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof HorizontalAlignment)) {
            return false;
        }
        HorizontalAlignment horizontalAlignment = (HorizontalAlignment)object;
        if (this.name.equals(horizontalAlignment.name)) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    private Object readResolve() {
        HorizontalAlignment horizontalAlignment = null;
        if (this.equals(LEFT)) {
            return LEFT;
        }
        if (this.equals(RIGHT)) {
            return RIGHT;
        }
        if (!this.equals(CENTER)) return horizontalAlignment;
        return CENTER;
    }
}

