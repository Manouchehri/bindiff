package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public class BasicBlockCommentLineObject extends AbstractEditableLineObject
{
    private final RawBasicBlock rawBasicblock;
    
    public BasicBlockCommentLineObject(final RawBasicBlock rawBasicblock, final int n, final int n2) {
        super(n, n2);
        Preconditions.checkNotNull(rawBasicblock);
        this.rawBasicblock = rawBasicblock;
    }
    
    @Override
    public final Object getPersistentModel() {
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
