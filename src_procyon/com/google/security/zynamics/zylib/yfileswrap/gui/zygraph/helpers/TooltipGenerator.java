package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;
import com.google.security.zynamics.zylib.types.graphs.*;
import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import java.util.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.common.base.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;

public final class TooltipGenerator
{
    private static String generateProximityNodeRealizer(final AbstractZyGraph abstractZyGraph, final ZyProximityNode zyProximityNode) {
        final LinkedHashSet<String> set = new LinkedHashSet<String>();
        final List list = zyProximityNode.isIncoming() ? ((IGraphNode)zyProximityNode.getRawNode().getAttachedNode()).getChildren() : ((IGraphNode)zyProximityNode.getRawNode().getAttachedNode()).getParents();
        int n = 0;
        int n2 = 0;
        final int countIf = CollectionHelpers.countIf(list, new TooltipGenerator$1());
        for (final IFunctionNode next : list) {
            if (next.isVisible()) {
                continue;
            }
            final ZyLabelContent nodeContent = ((IZyNodeRealizer)abstractZyGraph.getGraph().t(abstractZyGraph.getYNode(next))).getNodeContent();
            if (next instanceof IFunctionNode) {
                final IFunctionNode functionNode = next;
                final LinkedHashSet<String> set2 = set;
                final String s = "F: ";
                final String value = String.valueOf(functionNode.getFunction().getName());
                set2.add((value.length() != 0) ? s.concat(value) : new String(s));
            }
            else if (next instanceof ICodeNode) {
                final ICodeNode codeNode = (ICodeNode)next;
                final LinkedHashSet<String> set3 = set;
                final String s2 = "B: ";
                final String value2 = String.valueOf(codeNode.getAddress().toHexString());
                set3.add((value2.length() != 0) ? s2.concat(value2) : new String(s2));
            }
            else if (nodeContent.getLineCount() > 0) {
                set.add(nodeContent.getLineContent(0).getText());
            }
            ++n2;
            if (set.size() == 25) {
                n = ((n2 != countIf) ? 1 : 0);
                break;
            }
        }
        if (n != 0) {
            set.add("...");
        }
        return HtmlGenerator.getHtml(set, GuiHelper.getMonospaceFont(), false);
    }
    
    private static boolean requiresBoldFirstLine(final ZyGraphNode zyGraphNode) {
        return zyGraphNode != null && (zyGraphNode.getRawNode() instanceof ICodeNode || zyGraphNode.getRawNode() instanceof IFunctionNode);
    }
    
    public static String createTooltip(final AbstractZyGraph abstractZyGraph, final d d) {
        Preconditions.checkNotNull(abstractZyGraph, (Object)"Error: Graph argument can not be null");
        Preconditions.checkNotNull(d, (Object)"Error: Edge argument can not be null");
        String s = createTooltip(abstractZyGraph, d.c()).replace("</html>", "");
        final ZyEdgeRealizer zyEdgeRealizer = (ZyEdgeRealizer)abstractZyGraph.getGraph().i(d);
        if (zyEdgeRealizer.labelCount() > 0) {
            final ZyLabelContent labelContent = ((ZyEdgeLabel)zyEdgeRealizer.getLabel()).getLabelContent();
            final String value = String.valueOf(s);
            final String value2 = String.valueOf(HtmlGenerator.getHtml(labelContent, GuiHelper.getMonospaceFont(), false).replace("<html>", "").replace("</html>", ""));
            s = new StringBuilder(4 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append("<hr>").append(value2).toString();
        }
        final String value3 = String.valueOf(s);
        final String value4 = String.valueOf(createTooltip(abstractZyGraph, d.d()).replace("<html>", ""));
        return new StringBuilder(4 + String.valueOf(value3).length() + String.valueOf(value4).length()).append(value3).append("<hr>").append(value4).toString();
    }
    
    public static String createTooltip(final AbstractZyGraph abstractZyGraph, final q q) {
        Preconditions.checkNotNull(abstractZyGraph, (Object)"Error: Graph argument can not be null");
        Preconditions.checkNotNull(q, (Object)"Error: Node argument can not be null");
        final IZyNodeRealizer zyNodeRealizer = (IZyNodeRealizer)abstractZyGraph.getGraph().t(q);
        if (zyNodeRealizer instanceof ZyProximityNodeRealizer) {
            return generateProximityNodeRealizer(abstractZyGraph, (ZyProximityNode)zyNodeRealizer.getUserData().getNode());
        }
        return HtmlGenerator.getHtml(zyNodeRealizer.getNodeContent(), GuiHelper.getMonospaceFont(), requiresBoldFirstLine(abstractZyGraph.getNode(q)));
    }
}
