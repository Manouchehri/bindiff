/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.wrappers.ViewNodeAdapter;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;

final class ProximityRangeCalculator$1
implements ICollectionFilter {
    final /* synthetic */ IGroupNode val$parentGroup;

    ProximityRangeCalculator$1(IGroupNode iGroupNode) {
        this.val$parentGroup = iGroupNode;
    }

    public boolean qualifies(ViewNodeAdapter viewNodeAdapter) {
        if (viewNodeAdapter.getNode() != this.val$parentGroup) return false;
        return true;
    }
}

