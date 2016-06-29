package com.google.security.zynamics.bindiff.graph.searchers;

import java.util.*;
import java.awt.*;

public class SearchResult
{
    private final int line;
    private final int index;
    private final int length;
    private final List originalTextBackgroundStyleRun;
    private final Color originalBorderColor;
    private final Object object;
    private final String text;
    private Color objectMarkerColor;
    
    public SearchResult(final Object object, final int line, final int index, final int length, final String text, final List originalTextBackgroundStyleRun, final Color originalBorderColor) {
        this.objectMarkerColor = Color.WHITE;
        this.object = object;
        this.line = line;
        this.index = index;
        this.length = length;
        this.text = text;
        this.originalTextBackgroundStyleRun = originalTextBackgroundStyleRun;
        this.originalBorderColor = originalBorderColor;
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
    
    public void setObjectMarkerColor(final Color objectMarkerColor) {
        this.objectMarkerColor = objectMarkerColor;
    }
}
