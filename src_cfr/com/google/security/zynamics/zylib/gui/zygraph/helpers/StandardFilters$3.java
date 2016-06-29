/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.ISelectableNode;

final class StandardFilters$3
implements INodeFilter {
    StandardFilters$3() {
    }

    public boolean qualifies(ISelectableNode iSelectableNode) {
        return iSelectableNode.isSelected();
    }
}

