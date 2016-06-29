package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public abstract class AbstractEditableLineObject implements IZyEditableObject
{
    protected final int start;
    protected final int length;
    
    protected AbstractEditableLineObject(final int start, final int length) {
        this.start = start;
        this.length = length;
    }
    
    @Override
    public int getEnd() {
        return this.start + this.length;
    }
    
    @Override
    public int getLength() {
        return this.length;
    }
    
    @Override
    public int getStart() {
        return this.start;
    }
    
    @Override
    public boolean isCommentDelimiter() {
        return false;
    }
    
    @Override
    public boolean isPlaceholder() {
        return false;
    }
}
