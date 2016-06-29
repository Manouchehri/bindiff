/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.labelcontent.editableline;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.AbstractEditableLineObject;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;

public class CFunctionLineObject
extends AbstractEditableLineObject {
    private final RawFunction rawFunction;

    public CFunctionLineObject(RawFunction rawFunction, int n2, int n3) {
        super(n2, n3);
        Preconditions.checkNotNull(rawFunction);
        this.rawFunction = rawFunction;
    }

    @Override
    public Object getPersistentModel() {
        return this.rawFunction;
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

