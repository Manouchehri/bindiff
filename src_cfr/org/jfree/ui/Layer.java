/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.io.Serializable;

public final class Layer
implements Serializable {
    private static final long serialVersionUID = -1470104570733183430L;
    public static final Layer FOREGROUND = new Layer("Layer.FOREGROUND");
    public static final Layer BACKGROUND = new Layer("Layer.BACKGROUND");
    private String name;

    private Layer(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Layer)) {
            return false;
        }
        Layer layer = (Layer)object;
        if (this.name.equals(layer.name)) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    private Object readResolve() {
        Layer layer = null;
        if (this.equals(FOREGROUND)) {
            return FOREGROUND;
        }
        if (!this.equals(BACKGROUND)) return layer;
        return BACKGROUND;
    }
}

