package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public class BasicBlockHeadLineObject extends AbstractEditableLineObject
{
    private final RawBasicBlock rawBasicblock;
    
    public BasicBlockHeadLineObject(final RawBasicBlock rawBasicblock) {
        super(0, 0);
        Preconditions.checkNotNull(rawBasicblock);
        this.rawBasicblock = rawBasicblock;
    }
    
    @Override
    public final Object getPersistentModel() {
        return this.rawBasicblock;
    }
    
    @Override
    public boolean update(final String s) {
        return false;
    }
    
    @Override
    public boolean updateComment(final String s, final ECommentPlacement eCommentPlacement) {
        return false;
    }
}
