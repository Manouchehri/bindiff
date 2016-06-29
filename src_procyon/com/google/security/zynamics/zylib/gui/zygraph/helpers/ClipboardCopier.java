package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import java.util.*;

public final class ClipboardCopier
{
    public static void copyToClipboard(final ZyGraphNode zyGraphNode) {
        Preconditions.checkNotNull(zyGraphNode, (Object)"Error: Node argument can not be null");
        final ZyLabelContent nodeContent = zyGraphNode.getRealizer().getNodeContent();
        if (nodeContent.isSelectable()) {
            final ZyLabelContent zyLabelContent = nodeContent;
            final StringBuilder sb = new StringBuilder();
            final Iterator iterator = zyLabelContent.iterator();
            while (iterator.hasNext()) {
                sb.append(iterator.next().getText());
                sb.append("\n");
            }
            ClipboardHelpers.copyToClipboard(sb.toString());
        }
    }
    
    public static void copyToClipboard(final ZyGraphNode zyGraphNode, final int n) {
        Preconditions.checkNotNull(zyGraphNode, (Object)"Error: Node argument can not be null");
        final ZyLabelContent nodeContent = zyGraphNode.getRealizer().getNodeContent();
        Preconditions.checkArgument(n >= 0 && n < nodeContent.getLineCount(), (Object)"Error: Line argument is out of bounds");
        if (nodeContent.isSelectable()) {
            ClipboardHelpers.copyToClipboard(nodeContent.getLineContent(n).getText());
        }
    }
}
