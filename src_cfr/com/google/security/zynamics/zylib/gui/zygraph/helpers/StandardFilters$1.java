/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.CProximityNode;

final class StandardFilters$1
implements INodeFilter {
    StandardFilters$1() {
    }

    @Override
    public boolean qualifies(Object object) {
        return object instanceof CProximityNode;
    }
}

