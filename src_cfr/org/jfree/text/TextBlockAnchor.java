/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.text;

import java.io.Serializable;

public final class TextBlockAnchor
implements Serializable {
    private static final long serialVersionUID = -3045058380983401544L;
    public static final TextBlockAnchor TOP_LEFT = new TextBlockAnchor("TextBlockAnchor.TOP_LEFT");
    public static final TextBlockAnchor TOP_CENTER = new TextBlockAnchor("TextBlockAnchor.TOP_CENTER");
    public static final TextBlockAnchor TOP_RIGHT = new TextBlockAnchor("TextBlockAnchor.TOP_RIGHT");
    public static final TextBlockAnchor CENTER_LEFT = new TextBlockAnchor("TextBlockAnchor.CENTER_LEFT");
    public static final TextBlockAnchor CENTER = new TextBlockAnchor("TextBlockAnchor.CENTER");
    public static final TextBlockAnchor CENTER_RIGHT = new TextBlockAnchor("TextBlockAnchor.CENTER_RIGHT");
    public static final TextBlockAnchor BOTTOM_LEFT = new TextBlockAnchor("TextBlockAnchor.BOTTOM_LEFT");
    public static final TextBlockAnchor BOTTOM_CENTER = new TextBlockAnchor("TextBlockAnchor.BOTTOM_CENTER");
    public static final TextBlockAnchor BOTTOM_RIGHT = new TextBlockAnchor("TextBlockAnchor.BOTTOM_RIGHT");
    private String name;

    private TextBlockAnchor(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof TextBlockAnchor)) {
            return false;
        }
        TextBlockAnchor textBlockAnchor = (TextBlockAnchor)object;
        if (this.name.equals(textBlockAnchor.name)) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    private Object readResolve() {
        if (this.equals(TOP_CENTER)) {
            return TOP_CENTER;
        }
        if (this.equals(TOP_LEFT)) {
            return TOP_LEFT;
        }
        if (this.equals(TOP_RIGHT)) {
            return TOP_RIGHT;
        }
        if (this.equals(CENTER)) {
            return CENTER;
        }
        if (this.equals(CENTER_LEFT)) {
            return CENTER_LEFT;
        }
        if (this.equals(CENTER_RIGHT)) {
            return CENTER_RIGHT;
        }
        if (this.equals(BOTTOM_CENTER)) {
            return BOTTOM_CENTER;
        }
        if (this.equals(BOTTOM_LEFT)) {
            return BOTTOM_LEFT;
        }
        if (!this.equals(BOTTOM_RIGHT)) return null;
        return BOTTOM_RIGHT;
    }
}

