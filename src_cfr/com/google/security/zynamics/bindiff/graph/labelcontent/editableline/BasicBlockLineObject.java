/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.AbstractEditableLineObject;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;

public class BasicBlockLineObject
extends AbstractEditableLineObject {
    private final RawBasicBlock rawBasicblock;

    public BasicBlockLineObject(RawBasicBlock rawBasicBlock) {
        super(-1, 0);
        Preconditions.checkNotNull(rawBasicBlock);
        this.rawBasicblock = rawBasicBlock;
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
    public boolean update(String string) {
        Preconditions.checkNotNull(string);
        this.rawBasicblock.setComment(string);
        return true;
    }

    @Override
    public boolean updateComment(String string, ECommentPlacement eCommentPlacement) {
        return false;
    }
}

