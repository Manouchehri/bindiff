package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;

class SingleGraph$1 implements ICollectionFilter
{
    final /* synthetic */ SingleGraph this$0;
    
    SingleGraph$1(final SingleGraph this$0) {
        this.this$0 = this$0;
    }
    
    public boolean qualifies(final SingleDiffNode singleDiffNode) {
        return singleDiffNode.isSelected();
    }
}
