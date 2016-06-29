/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.util.Iterator;

final class GraphHelpers$8
implements INodeCallback {
    final /* synthetic */ StringBuilder val$selection;

    GraphHelpers$8(StringBuilder stringBuilder) {
        this.val$selection = stringBuilder;
    }

    public IterationMode next(ZyGraphNode zyGraphNode) {
        IZyNodeRealizer iZyNodeRealizer = zyGraphNode.getRealizer();
        ZyLabelContent zyLabelContent = iZyNodeRealizer.getNodeContent();
        Iterator iterator = zyLabelContent.iterator();
        do {
            if (!iterator.hasNext()) {
                this.val$selection.append("\n");
                return IterationMode.CONTINUE;
            }
            ZyLineContent zyLineContent = (ZyLineContent)iterator.next();
            this.val$selection.append(zyLineContent.getText());
            this.val$selection.append("\n");
        } while (true);
    }
}

