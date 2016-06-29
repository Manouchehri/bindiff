/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.util.Iterator;

public final class ClipboardCopier {
    public static void copyToClipboard(ZyGraphNode zyGraphNode) {
        Preconditions.checkNotNull(zyGraphNode, "Error: Node argument can not be null");
        IZyNodeRealizer iZyNodeRealizer = zyGraphNode.getRealizer();
        ZyLabelContent zyLabelContent = iZyNodeRealizer.getNodeContent();
        if (!zyLabelContent.isSelectable()) return;
        ZyLabelContent zyLabelContent2 = zyLabelContent;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = zyLabelContent2.iterator();
        do {
            if (!iterator.hasNext()) {
                ClipboardHelpers.copyToClipboard(stringBuilder.toString());
                return;
            }
            ZyLineContent zyLineContent = (ZyLineContent)iterator.next();
            stringBuilder.append(zyLineContent.getText());
            stringBuilder.append("\n");
        } while (true);
    }

    public static void copyToClipboard(ZyGraphNode zyGraphNode, int n2) {
        Preconditions.checkNotNull(zyGraphNode, "Error: Node argument can not be null");
        IZyNodeRealizer iZyNodeRealizer = zyGraphNode.getRealizer();
        ZyLabelContent zyLabelContent = iZyNodeRealizer.getNodeContent();
        Preconditions.checkArgument(n2 >= 0 && n2 < zyLabelContent.getLineCount(), "Error: Line argument is out of bounds");
        if (!zyLabelContent.isSelectable()) return;
        ZyLabelContent zyLabelContent2 = zyLabelContent;
        ClipboardHelpers.copyToClipboard(zyLabelContent2.getLineContent(n2).getText());
    }
}

