/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;

final class SelectionFunctions$1
implements INodeCallback {
    final /* synthetic */ ArrayList val$toUnselect;
    final /* synthetic */ ArrayList val$toSelect;

    SelectionFunctions$1(ArrayList arrayList, ArrayList arrayList2) {
        this.val$toUnselect = arrayList;
        this.val$toSelect = arrayList2;
    }

    public IterationMode next(ZyGraphNode zyGraphNode) {
        if (zyGraphNode.isSelected()) {
            this.val$toUnselect.add(zyGraphNode);
            return IterationMode.CONTINUE;
        }
        this.val$toSelect.add(zyGraphNode);
        return IterationMode.CONTINUE;
    }
}

