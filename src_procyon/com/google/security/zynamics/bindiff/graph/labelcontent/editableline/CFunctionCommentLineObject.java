package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public class CFunctionCommentLineObject extends AbstractEditableLineObject
{
    private final RawFunction rawFunction;
    
    public CFunctionCommentLineObject(final RawFunction rawFunction, final int n, final int n2) {
        super(n, n2);
        Preconditions.checkNotNull(rawFunction);
        this.rawFunction = rawFunction;
    }
    
    @Override
    public Object getPersistentModel() {
        return this.rawFunction;
    }
    
    @Override
    public boolean update(final String comment) {
        Preconditions.checkNotNull(comment);
        this.rawFunction.setComment(comment);
        return true;
    }
    
    @Override
    public boolean updateComment(final String s, final ECommentPlacement eCommentPlacement) {
        return false;
    }
}
