/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import java.util.ArrayList;

final class GraphHelpers$1
implements INodeCallback {
    final /* synthetic */ INodeFilter val$filter;
    final /* synthetic */ ArrayList val$lameHack;

    GraphHelpers$1(INodeFilter iNodeFilter, ArrayList arrayList) {
        this.val$filter = iNodeFilter;
        this.val$lameHack = arrayList;
    }

    @Override
    public IterationMode next(Object object) {
        if (!this.val$filter.qualifies(object)) return IterationMode.CONTINUE;
        this.val$lameHack.add(object);
        return IterationMode.STOP;
    }
}

