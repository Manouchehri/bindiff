/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;

class SingleGraph$1
implements ICollectionFilter {
    final /* synthetic */ SingleGraph this$0;

    SingleGraph$1(SingleGraph singleGraph) {
        this.this$0 = singleGraph;
    }

    public boolean qualifies(SingleDiffNode singleDiffNode) {
        return singleDiffNode.isSelected();
    }
}

