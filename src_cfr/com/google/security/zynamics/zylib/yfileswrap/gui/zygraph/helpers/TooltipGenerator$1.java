/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;

final class TooltipGenerator$1
implements ICollectionFilter {
    TooltipGenerator$1() {
    }

    @Override
    public boolean qualifies(Object object) {
        if (((IViewNode)object).isVisible()) return false;
        return true;
    }
}

