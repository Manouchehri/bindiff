package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.common.base.*;

public class CInstructionCommentLineObject extends AbstractEditableLineObject
{
    private final RawInstruction rawInstruction;
    private final ECommentPlacement commentPlacement;
    
    public CInstructionCommentLineObject(final RawInstruction rawInstruction, final ECommentPlacement eCommentPlacement, final int n, final int n2) {
        super(n, n2);
        this.rawInstruction = (RawInstruction)Preconditions.checkNotNull(rawInstruction);
        this.commentPlacement = (ECommentPlacement)Preconditions.checkNotNull(eCommentPlacement);
    }
    
    @Override
    public Object getPersistentModel() {
        return this.rawInstruction;
    }
    
    @Override
    public boolean update(final String s) {
        Preconditions.checkNotNull(s);
        this.rawInstruction.setComment(s, this.commentPlacement);
        return true;
    }
    
    @Override
    public boolean updateComment(final String s, final ECommentPlacement eCommentPlacement) {
        return this.update(s);
    }
}
