/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;

class SuperGraph$1
implements ICollectionFilter {
    final /* synthetic */ SuperGraph this$0;

    SuperGraph$1(SuperGraph superGraph) {
        this.this$0 = superGraph;
    }

    public boolean qualifies(SuperDiffNode superDiffNode) {
        return superDiffNode.isSelected();
    }
}

