/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;

public class RawInstructionComment {
    private final ECommentPlacement commentPlacement;
    private String text;
    private boolean modified = false;

    public RawInstructionComment(String string, ECommentPlacement eCommentPlacement) {
        this.text = (String)Preconditions.checkNotNull(string);
        this.commentPlacement = eCommentPlacement;
    }

    public String getText() {
        return this.text;
    }

    public boolean isModified() {
        return this.modified;
    }

    public ECommentPlacement getPlacement() {
        return this.commentPlacement;
    }

    public boolean isChangedComment() {
        return this.modified;
    }

    public void setText(String string) {
        this.text = string;
        this.modified = true;
    }
}

