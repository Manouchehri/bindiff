package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;

class SuperGraph$1 implements ICollectionFilter
{
    final /* synthetic */ SuperGraph this$0;
    
    SuperGraph$1(final SuperGraph this$0) {
        this.this$0 = this$0;
    }
    
    public boolean qualifies(final SuperDiffNode superDiffNode) {
        return superDiffNode.isSelected();
    }
}
