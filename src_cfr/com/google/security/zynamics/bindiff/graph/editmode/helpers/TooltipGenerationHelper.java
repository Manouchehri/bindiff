/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.editmode.helpers;

import com.google.common.base.Strings;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.resources.Fonts;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.HtmlGenerator;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.CProximityNode;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class TooltipGenerationHelper {
    private static final int NODE_TOOLTIP_MAX_LINES = 25;
    private static final String MISSING_STRING = "missing";

    private static String createTwoSidedContent(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder(String.format("<html><font face=\"%s\" size=\"3\" color=\"000000\">", string));
        stringBuilder.append("<table cellspacing=\"5\" border=\"0\" cellpadding=\"0\">");
        stringBuilder.append("<tr valign=\"middle\" align=\"left\">");
        stringBuilder.append("<td>");
        stringBuilder.append(string2);
        stringBuilder.append("</td>");
        stringBuilder.append("<td width=\"1\" bgcolor=\"#000000\"><br></td>");
        stringBuilder.append("<td>");
        stringBuilder.append(string3);
        stringBuilder.append("</td>");
        stringBuilder.append("</tr>");
        stringBuilder.append("</table>");
        stringBuilder.append("</font></html>");
        return stringBuilder.toString();
    }

    private static String getHtml(ZyLabelContent zyLabelContent, String string, int n2) {
        StringBuilder stringBuilder = new StringBuilder(String.format("<html><font face=\"%s\" size=\"3\" color=\"000000\">", string));
        int n3 = Math.min(zyLabelContent.getLineCount(), 25);
        for (int i2 = 0; i2 < n3; ++i2) {
            String string2 = zyLabelContent.getLineContent(i2).getText();
            if (i2 == 0 && string2.length() < n2) {
                for (int i3 = string2.length(); i3 < n2; ++i3) {
                    string2 = String.valueOf(string2).concat(" ");
                }
            }
            stringBuilder.append(HtmlGenerator.escapeHtml(string2));
            stringBuilder.append("<br>");
        }
        if (zyLabelContent.getLineCount() > 25) {
            stringBuilder.append("...");
            stringBuilder.append("<br>");
        }
        stringBuilder.append("</font></html>");
        return stringBuilder.toString();
    }

    private static int getMaxLineCharacterCount(SingleDiffNode singleDiffNode) {
        if (singleDiffNode == null) {
            return "missing".length();
        }
        int n2 = 0;
        int n3 = 0;
        Iterator iterator = singleDiffNode.getRealizer().getNodeContent().iterator();
        do {
            if (!iterator.hasNext()) return n3;
            ZyLineContent zyLineContent = (ZyLineContent)iterator.next();
            n3 = Math.max(n3, zyLineContent.getText().length());
        } while (++n2 <= 25);
        return n3;
    }

    public static String generateCombinedEdgeTooltips(String string, CombinedDiffNode combinedDiffNode, CombinedDiffNode combinedDiffNode2) {
        StringBuilder stringBuilder = new StringBuilder();
        SingleDiffNode singleDiffNode = combinedDiffNode.getPrimaryDiffNode();
        SingleDiffNode singleDiffNode2 = combinedDiffNode.getSecondaryDiffNode();
        SingleDiffNode singleDiffNode3 = combinedDiffNode2.getPrimaryDiffNode();
        SingleDiffNode singleDiffNode4 = combinedDiffNode2.getSecondaryDiffNode();
        int n2 = TooltipGenerationHelper.getMaxLineCharacterCount(singleDiffNode);
        n2 = Math.max(n2, TooltipGenerationHelper.getMaxLineCharacterCount(singleDiffNode3));
        int n3 = TooltipGenerationHelper.getMaxLineCharacterCount(singleDiffNode2);
        n3 = Math.max(n3, TooltipGenerationHelper.getMaxLineCharacterCount(singleDiffNode4));
        String string2 = TooltipGenerationHelper.generateCombinedNodeTooltip(string, singleDiffNode, singleDiffNode2, n2, n3);
        string2 = string2.replace("</html>", "");
        String string3 = TooltipGenerationHelper.generateCombinedNodeTooltip(string, singleDiffNode3, singleDiffNode4, n2, n3);
        string3 = string3.replace("<html>", "");
        stringBuilder.append(string2);
        stringBuilder.append("<hr></hr>");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public static String generateCombinedNodeTooltip(String string, SingleDiffNode singleDiffNode, SingleDiffNode singleDiffNode2, int n2, int n3) {
        String string2 = Strings.padEnd("missing", n2 + 1, ' ');
        String string3 = Strings.padEnd("missing", n3 + 1, ' ');
        if (singleDiffNode != null) {
            ZyLabelContent zyLabelContent = singleDiffNode.getRealizer().getNodeContent();
            string2 = TooltipGenerationHelper.getHtml(zyLabelContent, Fonts.NORMAL_FONT.getName(), n2);
            string2 = string2.replace("<html>", "");
            string2 = string2.replace("</html>", "");
        } else {
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add(string2);
            string2 = HtmlGenerator.getHtml(arrayList, Fonts.NORMAL_FONT.getName(), false);
        }
        if (singleDiffNode2 != null) {
            ZyLabelContent zyLabelContent = singleDiffNode2.getRealizer().getNodeContent();
            string3 = TooltipGenerationHelper.getHtml(zyLabelContent, Fonts.NORMAL_FONT.getName(), n3);
            string3 = string3.replace("<html>", "");
            string3 = string3.replace("</html>", "");
            return TooltipGenerationHelper.createTwoSidedContent(string, string2, string3);
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(string3);
        string3 = HtmlGenerator.getHtml(arrayList, Fonts.NORMAL_FONT.getName(), false);
        return TooltipGenerationHelper.createTwoSidedContent(string, string2, string3);
    }

    public static String generateProximityNodeTooltip(ZyProximityNode zyProximityNode) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        List list = zyProximityNode.isIncoming() ? ((IGraphNode)((Object)zyProximityNode.getRawNode().getAttachedNode())).getChildren() : ((IGraphNode)((Object)zyProximityNode.getRawNode().getAttachedNode())).getParents();
        boolean bl2 = false;
        int n2 = 0;
        for (Object e2 : list) {
            SingleViewNode singleViewNode;
            IViewNode iViewNode = (IViewNode)e2;
            if (iViewNode.isVisible()) continue;
            if (bl2) {
                n2 = 0;
                break;
            }
            if (e2 instanceof RawFunction) {
                singleViewNode = (RawFunction)e2;
                linkedHashSet.add(String.format("%s  %s", singleViewNode.getAddress().toHexString(), singleViewNode.getName()));
            } else if (e2 instanceof RawBasicBlock) {
                singleViewNode = (RawBasicBlock)e2;
                linkedHashSet.add(singleViewNode.getAddress().toHexString());
            }
            if (++n2 != 25) continue;
            bl2 = true;
        }
        if (!bl2) return HtmlGenerator.getHtml(linkedHashSet, GuiHelper.getMonospaceFont(), false);
        if (n2 != 0) return HtmlGenerator.getHtml(linkedHashSet, GuiHelper.getMonospaceFont(), false);
        linkedHashSet.add("...");
        return HtmlGenerator.getHtml(linkedHashSet, GuiHelper.getMonospaceFont(), false);
    }

    public static String generateProximityNodeTooltip(String string, ZyProximityNode zyProximityNode) {
        List list = zyProximityNode.isIncoming() ? ((IGraphNode)((Object)zyProximityNode.getRawNode().getAttachedNode())).getChildren() : ((IGraphNode)((Object)zyProximityNode.getRawNode().getAttachedNode())).getParents();
        boolean bl2 = false;
        int n2 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (Object e2 : list) {
            Object object;
            SingleViewNode singleViewNode;
            IViewNode iViewNode = (IViewNode)e2;
            if (iViewNode.isVisible()) continue;
            if (bl2) {
                n2 = 0;
                break;
            }
            if (e2 instanceof RawCombinedFunction) {
                RawCombinedFunction rawCombinedFunction = (RawCombinedFunction)e2;
                singleViewNode = rawCombinedFunction.getRawNode(ESide.PRIMARY);
                object = singleViewNode == null ? "missing" : String.format("%s  %s", singleViewNode.getAddress().toHexString(), HtmlGenerator.escapeHtml(singleViewNode.getName()));
                stringBuffer.append((String)object);
                RawFunction rawFunction = rawCombinedFunction.getRawNode(ESide.SECONDARY);
                String string2 = rawFunction == null ? "missing" : String.format("%s  %s", rawFunction.getAddress().toHexString(), HtmlGenerator.escapeHtml(rawFunction.getName()));
                stringBuffer2.append(string2);
            } else {
                if (!(e2 instanceof RawCombinedBasicBlock)) continue;
                RawCombinedBasicBlock rawCombinedBasicBlock = (RawCombinedBasicBlock)e2;
                singleViewNode = rawCombinedBasicBlock.getRawNode(ESide.PRIMARY);
                stringBuffer.append(singleViewNode == null ? MISSING_STRING : singleViewNode.getAddress().toHexString());
                object = rawCombinedBasicBlock.getRawNode(ESide.SECONDARY);
                stringBuffer2.append(object == null ? MISSING_STRING : object.getAddress().toHexString());
            }
            stringBuffer.append("<br>");
            stringBuffer2.append("<br>");
            if (++n2 != 25) continue;
            bl2 = true;
        }
        if (!bl2) return TooltipGenerationHelper.createTwoSidedContent(string, stringBuffer.toString(), stringBuffer2.toString());
        if (n2 != 0) return TooltipGenerationHelper.createTwoSidedContent(string, stringBuffer.toString(), stringBuffer2.toString());
        stringBuffer.append("...");
        stringBuffer2.append("...");
        return TooltipGenerationHelper.createTwoSidedContent(string, stringBuffer.toString(), stringBuffer2.toString());
    }
}

