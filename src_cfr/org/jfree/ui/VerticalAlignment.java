/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.io.Serializable;

public final class VerticalAlignment
implements Serializable {
    private static final long serialVersionUID = 7272397034325429853L;
    public static final VerticalAlignment TOP = new VerticalAlignment("VerticalAlignment.TOP");
    public static final VerticalAlignment BOTTOM = new VerticalAlignment("VerticalAlignment.BOTTOM");
    public static final VerticalAlignment CENTER = new VerticalAlignment("VerticalAlignment.CENTER");
    private String name;

    private VerticalAlignment(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof VerticalAlignment)) {
            return false;
        }
        VerticalAlignment verticalAlignment = (VerticalAlignment)object;
        if (this.name.equals(verticalAlignment.name)) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    private Object readResolve() {
        if (this.equals(TOP)) {
            return TOP;
        }
        if (this.equals(BOTTOM)) {
            return BOTTOM;
        }
        if (!this.equals(CENTER)) return null;
        return CENTER;
    }
}

