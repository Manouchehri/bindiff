package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public class BasicBlockLineObject extends AbstractEditableLineObject
{
    private final RawBasicBlock rawBasicblock;
    
    public BasicBlockLineObject(final RawBasicBlock rawBasicblock) {
        super(-1, 0);
        Preconditions.checkNotNull(rawBasicblock);
        this.rawBasicblock = rawBasicblock;
    }
    
    @Override
    public int getLength() {
        return -1;
    }
    
    @Override
    public final Object getPersistentModel() {
        return this.rawBasicblock;
    }
    
    public RawBasicBlock getRawBasicblock() {
        return this.rawBasicblock;
    }
    
    @Override
    public boolean update(final String comment) {
        Preconditions.checkNotNull(comment);
        this.rawBasicblock.setComment(comment);
        return true;
    }
    
    @Override
    public boolean updateComment(final String s, final ECommentPlacement eCommentPlacement) {
        return false;
    }
}
