/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;

class CombinedGraph$1
implements ICollectionFilter {
    final /* synthetic */ CombinedGraph this$0;

    CombinedGraph$1(CombinedGraph combinedGraph) {
        this.this$0 = combinedGraph;
    }

    public boolean qualifies(CombinedDiffNode combinedDiffNode) {
        return combinedDiffNode.isSelected();
    }
}

