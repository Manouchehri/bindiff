package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public class InstructionObject extends AbstractEditableLineObject
{
    private final RawInstruction rawInstruction;
    
    public InstructionObject(final RawInstruction rawInstruction, final int n, final int n2) {
        super(n, n2);
        Preconditions.checkNotNull(rawInstruction);
        this.rawInstruction = rawInstruction;
    }
    
    @Override
    public RawInstruction getPersistentModel() {
        return this.rawInstruction;
    }
    
    @Override
    public boolean update(final String s) {
        return false;
    }
    
    @Override
    public boolean updateComment(final String s, final ECommentPlacement eCommentPlacement) {
        Preconditions.checkNotNull(s);
        this.rawInstruction.setComment(s, eCommentPlacement);
        return true;
    }
}
