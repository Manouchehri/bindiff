/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;

public abstract class AbstractEditableLineObject
implements IZyEditableObject {
    protected final int start;
    protected final int length;

    protected AbstractEditableLineObject(int n2, int n3) {
        this.start = n2;
        this.length = n3;
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

