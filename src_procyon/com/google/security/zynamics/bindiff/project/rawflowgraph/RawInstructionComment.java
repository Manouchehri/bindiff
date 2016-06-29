package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.common.base.*;

public class RawInstructionComment
{
    private final ECommentPlacement commentPlacement;
    private String text;
    private boolean modified;
    
    public RawInstructionComment(final String s, final ECommentPlacement commentPlacement) {
        this.modified = false;
        this.text = (String)Preconditions.checkNotNull(s);
        this.commentPlacement = commentPlacement;
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
    
    public void setText(final String text) {
        this.text = text;
        this.modified = true;
    }
}
