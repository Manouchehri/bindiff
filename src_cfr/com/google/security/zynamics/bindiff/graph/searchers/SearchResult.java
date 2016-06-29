/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.searchers;

import java.awt.Color;
import java.util.List;

public class SearchResult {
    private final int line;
    private final int index;
    private final int length;
    private final List originalTextBackgroundStyleRun;
    private final Color originalBorderColor;
    private final Object object;
    private final String text;
    private Color objectMarkerColor = Color.WHITE;

    public SearchResult(Object object, int n2, int n3, int n4, String string, List list, Color color) {
        this.object = object;
        this.line = n2;
        this.index = n3;
        this.length = n4;
        this.text = string;
        this.originalTextBackgroundStyleRun = list;
        this.originalBorderColor = color;
    }

    public int getLength() {
        return this.length;
    }

    public int getLine() {
        return this.line;
    }

    public Object getObject() {
        return this.object;
    }

    public Color getObjectMarkerColor() {
        return this.objectMarkerColor;
    }

    public Color getOriginalBorderColor() {
        return this.originalBorderColor;
    }

    public List getOriginalTextBackgroundStyleRun() {
        return this.originalTextBackgroundStyleRun;
    }

    public int getPosition() {
        return this.index;
    }

    public String getText() {
        return this.text;
    }

    public void setObjectMarkerColor(Color color) {
        this.objectMarkerColor = color;
    }
}

