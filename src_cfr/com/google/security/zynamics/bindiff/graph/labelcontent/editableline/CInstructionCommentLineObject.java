/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.AbstractEditableLineObject;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;

public class CInstructionCommentLineObject
extends AbstractEditableLineObject {
    private final RawInstruction rawInstruction;
    private final ECommentPlacement commentPlacement;

    public CInstructionCommentLineObject(RawInstruction rawInstruction, ECommentPlacement eCommentPlacement, int n2, int n3) {
        super(n2, n3);
        this.rawInstruction = (RawInstruction)Preconditions.checkNotNull(rawInstruction);
        this.commentPlacement = (ECommentPlacement)((Object)Preconditions.checkNotNull((Object)eCommentPlacement));
    }

    @Override
    public Object getPersistentModel() {
        return this.rawInstruction;
    }

    @Override
    public boolean update(String string) {
        Preconditions.checkNotNull(string);
        this.rawInstruction.setComment(string, this.commentPlacement);
        return true;
    }

    @Override
    public boolean updateComment(String string, ECommentPlacement eCommentPlacement) {
        return this.update(string);
    }
}

