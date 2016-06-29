/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.AbstractEditableLineObject;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;

public class InstructionObject
extends AbstractEditableLineObject {
    private final RawInstruction rawInstruction;

    public InstructionObject(RawInstruction rawInstruction, int n2, int n3) {
        super(n2, n3);
        Preconditions.checkNotNull(rawInstruction);
        this.rawInstruction = rawInstruction;
    }

    @Override
    public RawInstruction getPersistentModel() {
        return this.rawInstruction;
    }

    @Override
    public boolean update(String string) {
        return false;
    }

    @Override
    public boolean updateComment(String string, ECommentPlacement eCommentPlacement) {
        Preconditions.checkNotNull(string);
        this.rawInstruction.setComment(string, eCommentPlacement);
        return true;
    }
}

