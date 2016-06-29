package org.jfree.text;

import java.io.*;

public final class TextBlockAnchor implements Serializable
{
    private static final long serialVersionUID = -3045058380983401544L;
    public static final TextBlockAnchor TOP_LEFT;
    public static final TextBlockAnchor TOP_CENTER;
    public static final TextBlockAnchor TOP_RIGHT;
    public static final TextBlockAnchor CENTER_LEFT;
    public static final TextBlockAnchor CENTER;
    public static final TextBlockAnchor CENTER_RIGHT;
    public static final TextBlockAnchor BOTTOM_LEFT;
    public static final TextBlockAnchor BOTTOM_CENTER;
    public static final TextBlockAnchor BOTTOM_RIGHT;
    private String name;
    
    private TextBlockAnchor(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof TextBlockAnchor && this.name.equals(((TextBlockAnchor)o).name));
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
    
    private Object readResolve() {
        if (this.equals(TextBlockAnchor.TOP_CENTER)) {
            return TextBlockAnchor.TOP_CENTER;
        }
        if (this.equals(TextBlockAnchor.TOP_LEFT)) {
            return TextBlockAnchor.TOP_LEFT;
        }
        if (this.equals(TextBlockAnchor.TOP_RIGHT)) {
            return TextBlockAnchor.TOP_RIGHT;
        }
        if (this.equals(TextBlockAnchor.CENTER)) {
            return TextBlockAnchor.CENTER;
        }
        if (this.equals(TextBlockAnchor.CENTER_LEFT)) {
            return TextBlockAnchor.CENTER_LEFT;
        }
        if (this.equals(TextBlockAnchor.CENTER_RIGHT)) {
            return TextBlockAnchor.CENTER_RIGHT;
        }
        if (this.equals(TextBlockAnchor.BOTTOM_CENTER)) {
            return TextBlockAnchor.BOTTOM_CENTER;
        }
        if (this.equals(TextBlockAnchor.BOTTOM_LEFT)) {
            return TextBlockAnchor.BOTTOM_LEFT;
        }
        if (this.equals(TextBlockAnchor.BOTTOM_RIGHT)) {
            return TextBlockAnchor.BOTTOM_RIGHT;
        }
        return null;
    }
    
    static {
        TOP_LEFT = new TextBlockAnchor("TextBlockAnchor.TOP_LEFT");
        TOP_CENTER = new TextBlockAnchor("TextBlockAnchor.TOP_CENTER");
        TOP_RIGHT = new TextBlockAnchor("TextBlockAnchor.TOP_RIGHT");
        CENTER_LEFT = new TextBlockAnchor("TextBlockAnchor.CENTER_LEFT");
        CENTER = new TextBlockAnchor("TextBlockAnchor.CENTER");
        CENTER_RIGHT = new TextBlockAnchor("TextBlockAnchor.CENTER_RIGHT");
        BOTTOM_LEFT = new TextBlockAnchor("TextBlockAnchor.BOTTOM_LEFT");
        BOTTOM_CENTER = new TextBlockAnchor("TextBlockAnchor.BOTTOM_CENTER");
        BOTTOM_RIGHT = new TextBlockAnchor("TextBlockAnchor.BOTTOM_RIGHT");
    }
}
