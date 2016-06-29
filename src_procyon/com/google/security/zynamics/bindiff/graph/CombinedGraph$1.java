package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;

class CombinedGraph$1 implements ICollectionFilter
{
    final /* synthetic */ CombinedGraph this$0;
    
    CombinedGraph$1(final CombinedGraph this$0) {
        this.this$0 = this$0;
    }
    
    public boolean qualifies(final CombinedDiffNode combinedDiffNode) {
        return combinedDiffNode.isSelected();
    }
}
