package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.wrappers.*;

final class ProximityRangeCalculator$1 implements ICollectionFilter
{
    final /* synthetic */ IGroupNode val$parentGroup;
    
    ProximityRangeCalculator$1(final IGroupNode val$parentGroup) {
        this.val$parentGroup = val$parentGroup;
    }
    
    public boolean qualifies(final ViewNodeAdapter viewNodeAdapter) {
        return viewNodeAdapter.getNode() == this.val$parentGroup;
    }
}
