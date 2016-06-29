/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.io.Serializable;

public final class TextAnchor
implements Serializable {
    private static final long serialVersionUID = 8219158940496719660L;
    public static final TextAnchor TOP_LEFT = new TextAnchor("TextAnchor.TOP_LEFT");
    public static final TextAnchor TOP_CENTER = new TextAnchor("TextAnchor.TOP_CENTER");
    public static final TextAnchor TOP_RIGHT = new TextAnchor("TextAnchor.TOP_RIGHT");
    public static final TextAnchor HALF_ASCENT_LEFT = new TextAnchor("TextAnchor.HALF_ASCENT_LEFT");
    public static final TextAnchor HALF_ASCENT_CENTER = new TextAnchor("TextAnchor.HALF_ASCENT_CENTER");
    public static final TextAnchor HALF_ASCENT_RIGHT = new TextAnchor("TextAnchor.HALF_ASCENT_RIGHT");
    public static final TextAnchor CENTER_LEFT = new TextAnchor("TextAnchor.CENTER_LEFT");
    public static final TextAnchor CENTER = new TextAnchor("TextAnchor.CENTER");
    public static final TextAnchor CENTER_RIGHT = new TextAnchor("TextAnchor.CENTER_RIGHT");
    public static final TextAnchor BASELINE_LEFT = new TextAnchor("TextAnchor.BASELINE_LEFT");
    public static final TextAnchor BASELINE_CENTER = new TextAnchor("TextAnchor.BASELINE_CENTER");
    public static final TextAnchor BASELINE_RIGHT = new TextAnchor("TextAnchor.BASELINE_RIGHT");
    public static final TextAnchor BOTTOM_LEFT = new TextAnchor("TextAnchor.BOTTOM_LEFT");
    public static final TextAnchor BOTTOM_CENTER = new TextAnchor("TextAnchor.BOTTOM_CENTER");
    public static final TextAnchor BOTTOM_RIGHT = new TextAnchor("TextAnchor.BOTTOM_RIGHT");
    private String name;

    private TextAnchor(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof TextAnchor)) {
            return false;
        }
        TextAnchor textAnchor = (TextAnchor)object;
        if (this.name.equals(textAnchor.name)) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    private Object readResolve() {
        TextAnchor textAnchor = null;
        if (this.equals(TOP_LEFT)) {
            return TOP_LEFT;
        }
        if (this.equals(TOP_CENTER)) {
            return TOP_CENTER;
        }
        if (this.equals(TOP_RIGHT)) {
            return TOP_RIGHT;
        }
        if (this.equals(BOTTOM_LEFT)) {
            return BOTTOM_LEFT;
        }
        if (this.equals(BOTTOM_CENTER)) {
            return BOTTOM_CENTER;
        }
        if (this.equals(BOTTOM_RIGHT)) {
            return BOTTOM_RIGHT;
        }
        if (this.equals(BASELINE_LEFT)) {
            return BASELINE_LEFT;
        }
        if (this.equals(BASELINE_CENTER)) {
            return BASELINE_CENTER;
        }
        if (this.equals(BASELINE_RIGHT)) {
            return BASELINE_RIGHT;
        }
        if (this.equals(CENTER_LEFT)) {
            return CENTER_LEFT;
        }
        if (this.equals(CENTER)) {
            return CENTER;
        }
        if (this.equals(CENTER_RIGHT)) {
            return CENTER_RIGHT;
        }
        if (this.equals(HALF_ASCENT_LEFT)) {
            return HALF_ASCENT_LEFT;
        }
        if (this.equals(HALF_ASCENT_CENTER)) {
            return HALF_ASCENT_CENTER;
        }
        if (!this.equals(HALF_ASCENT_RIGHT)) return textAnchor;
        return HALF_ASCENT_RIGHT;
    }
}

