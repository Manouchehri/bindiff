/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.disassembly.IFunction;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.HtmlGenerator;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ICodeNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IFunctionNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.CProximityNode;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.TooltipGenerator$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeLabel;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyProximityNodeRealizer;
import java.util.LinkedHashSet;
import java.util.List;
import y.c.d;
import y.c.q;
import y.h.aA;
import y.h.aB;
import y.h.bu;
import y.h.fj;

public final class TooltipGenerator {
    private static String generateProximityNodeRealizer(AbstractZyGraph abstractZyGraph, ZyProximityNode zyProximityNode) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        List list = zyProximityNode.isIncoming() ? ((IGraphNode)((Object)zyProximityNode.getRawNode().getAttachedNode())).getChildren() : ((IGraphNode)((Object)zyProximityNode.getRawNode().getAttachedNode())).getParents();
        boolean bl2 = false;
        int n2 = 0;
        int n3 = CollectionHelpers.countIf(list, new TooltipGenerator$1());
        for (Object e2 : list) {
            IViewNode iViewNode = (IViewNode)e2;
            if (iViewNode.isVisible()) continue;
            IZyNodeRealizer iZyNodeRealizer = (IZyNodeRealizer)((Object)abstractZyGraph.getGraph().t(abstractZyGraph.getYNode(e2)));
            ZyLabelContent zyLabelContent = iZyNodeRealizer.getNodeContent();
            if (e2 instanceof IFunctionNode) {
                IFunctionNode iFunctionNode = (IFunctionNode)e2;
                String string = String.valueOf(iFunctionNode.getFunction().getName());
                linkedHashSet.add(string.length() != 0 ? "F: ".concat(string) : new String("F: "));
            } else if (e2 instanceof ICodeNode) {
                ICodeNode iCodeNode = (ICodeNode)e2;
                String string = String.valueOf(iCodeNode.getAddress().toHexString());
                linkedHashSet.add(string.length() != 0 ? "B: ".concat(string) : new String("B: "));
            } else if (zyLabelContent.getLineCount() > 0) {
                linkedHashSet.add(zyLabelContent.getLineContent(0).getText());
            }
            ++n2;
            if (linkedHashSet.size() != 25) continue;
            if (n2 == n3) return HtmlGenerator.getHtml(linkedHashSet, GuiHelper.getMonospaceFont(), false);
            boolean bl3 = true;
            bl2 = bl3;
            break;
        }
        if (!bl2) return HtmlGenerator.getHtml(linkedHashSet, GuiHelper.getMonospaceFont(), false);
        linkedHashSet.add("...");
        return HtmlGenerator.getHtml(linkedHashSet, GuiHelper.getMonospaceFont(), false);
    }

    private static boolean requiresBoldFirstLine(ZyGraphNode zyGraphNode) {
        if (zyGraphNode == null) return false;
        if (zyGraphNode.getRawNode() instanceof ICodeNode) return true;
        if (!(zyGraphNode.getRawNode() instanceof IFunctionNode)) return false;
        return true;
    }

    public static String createTooltip(AbstractZyGraph abstractZyGraph, d d2) {
        Object object;
        Object object2;
        Preconditions.checkNotNull(abstractZyGraph, "Error: Graph argument can not be null");
        Preconditions.checkNotNull(d2, "Error: Edge argument can not be null");
        String string = TooltipGenerator.createTooltip(abstractZyGraph, d2.c()).replace("</html>", "");
        ZyEdgeRealizer zyEdgeRealizer = (ZyEdgeRealizer)abstractZyGraph.getGraph().i(d2);
        if (zyEdgeRealizer.labelCount() > 0) {
            object = (ZyEdgeLabel)zyEdgeRealizer.getLabel();
            object2 = object.getLabelContent();
            String string2 = String.valueOf(string);
            String string3 = String.valueOf(HtmlGenerator.getHtml((ZyLabelContent)object2, GuiHelper.getMonospaceFont(), false).replace("<html>", "").replace("</html>", ""));
            string = new StringBuilder(4 + String.valueOf(string2).length() + String.valueOf(string3).length()).append(string2).append("<hr>").append(string3).toString();
        }
        object = String.valueOf(string);
        object2 = String.valueOf(TooltipGenerator.createTooltip(abstractZyGraph, d2.d()).replace("<html>", ""));
        return new StringBuilder(4 + String.valueOf(object).length() + String.valueOf(object2).length()).append((String)object).append("<hr>").append((String)object2).toString();
    }

    public static String createTooltip(AbstractZyGraph abstractZyGraph, q q2) {
        Preconditions.checkNotNull(abstractZyGraph, "Error: Graph argument can not be null");
        Preconditions.checkNotNull(q2, "Error: Node argument can not be null");
        IZyNodeRealizer iZyNodeRealizer = (IZyNodeRealizer)((Object)abstractZyGraph.getGraph().t(q2));
        if (iZyNodeRealizer instanceof ZyProximityNodeRealizer) {
            return TooltipGenerator.generateProximityNodeRealizer(abstractZyGraph, (ZyProximityNode)iZyNodeRealizer.getUserData().getNode());
        }
        ZyLabelContent zyLabelContent = iZyNodeRealizer.getNodeContent();
        boolean bl2 = TooltipGenerator.requiresBoldFirstLine(abstractZyGraph.getNode(q2));
        return HtmlGenerator.getHtml(zyLabelContent, GuiHelper.getMonospaceFont(), bl2);
    }
}

