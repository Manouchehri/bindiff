/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.AbstractEditableLineObject;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;

public class BasicBlockHeadLineObject
extends AbstractEditableLineObject {
    private final RawBasicBlock rawBasicblock;

    public BasicBlockHeadLineObject(RawBasicBlock rawBasicBlock) {
        super(0, 0);
        Preconditions.checkNotNull(rawBasicBlock);
        this.rawBasicblock = rawBasicBlock;
    }

    @Override
    public final Object getPersistentModel() {
        return this.rawBasicblock;
    }

    @Override
    public boolean update(String string) {
        return false;
    }

    @Override
    public boolean updateComment(String string, ECommentPlacement eCommentPlacement) {
        return false;
    }
}

