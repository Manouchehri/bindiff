package com.google.security.zynamics.bindiff.graph.editmode.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;
import com.google.security.zynamics.zylib.types.graphs.*;
import com.google.security.zynamics.zylib.gui.*;
import java.util.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;

public class TooltipGenerationHelper
{
    private static final int NODE_TOOLTIP_MAX_LINES = 25;
    private static final String MISSING_STRING = "missing";
    
    private static String createTwoSidedContent(final String s, final String s2, final String s3) {
        final StringBuilder sb = new StringBuilder(String.format("<html><font face=\"%s\" size=\"3\" color=\"000000\">", s));
        sb.append("<table cellspacing=\"5\" border=\"0\" cellpadding=\"0\">");
        sb.append("<tr valign=\"middle\" align=\"left\">");
        sb.append("<td>");
        sb.append(s2);
        sb.append("</td>");
        sb.append("<td width=\"1\" bgcolor=\"#000000\"><br></td>");
        sb.append("<td>");
        sb.append(s3);
        sb.append("</td>");
        sb.append("</tr>");
        sb.append("</table>");
        sb.append("</font></html>");
        return sb.toString();
    }
    
    private static String getHtml(final ZyLabelContent zyLabelContent, final String s, final int n) {
        final StringBuilder sb = new StringBuilder(String.format("<html><font face=\"%s\" size=\"3\" color=\"000000\">", s));
        for (int min = Math.min(zyLabelContent.getLineCount(), 25), i = 0; i < min; ++i) {
            String s2 = zyLabelContent.getLineContent(i).getText();
            if (i == 0 && s2.length() < n) {
                for (int j = s2.length(); j < n; ++j) {
                    s2 = String.valueOf(s2).concat(" ");
                }
            }
            sb.append(HtmlGenerator.escapeHtml(s2));
            sb.append("<br>");
        }
        if (zyLabelContent.getLineCount() > 25) {
            sb.append("...");
            sb.append("<br>");
        }
        sb.append("</font></html>");
        return sb.toString();
    }
    
    private static int getMaxLineCharacterCount(final SingleDiffNode singleDiffNode) {
        if (singleDiffNode == null) {
            return "missing".length();
        }
        int n = 0;
        int max = 0;
        final Iterator iterator = singleDiffNode.getRealizer().getNodeContent().iterator();
        while (iterator.hasNext()) {
            max = Math.max(max, iterator.next().getText().length());
            if (++n > 25) {
                return max;
            }
        }
        return max;
    }
    
    public static String generateCombinedEdgeTooltips(final String s, final CombinedDiffNode combinedDiffNode, final CombinedDiffNode combinedDiffNode2) {
        final StringBuilder sb = new StringBuilder();
        final SingleDiffNode primaryDiffNode = combinedDiffNode.getPrimaryDiffNode();
        final SingleDiffNode secondaryDiffNode = combinedDiffNode.getSecondaryDiffNode();
        final SingleDiffNode primaryDiffNode2 = combinedDiffNode2.getPrimaryDiffNode();
        final SingleDiffNode secondaryDiffNode2 = combinedDiffNode2.getSecondaryDiffNode();
        final int max = Math.max(getMaxLineCharacterCount(primaryDiffNode), getMaxLineCharacterCount(primaryDiffNode2));
        final int max2 = Math.max(getMaxLineCharacterCount(secondaryDiffNode), getMaxLineCharacterCount(secondaryDiffNode2));
        final String replace = generateCombinedNodeTooltip(s, primaryDiffNode, secondaryDiffNode, max, max2).replace("</html>", "");
        final String replace2 = generateCombinedNodeTooltip(s, primaryDiffNode2, secondaryDiffNode2, max, max2).replace("<html>", "");
        sb.append(replace);
        sb.append("<hr></hr>");
        sb.append(replace2);
        return sb.toString();
    }
    
    public static String generateCombinedNodeTooltip(final String s, final SingleDiffNode singleDiffNode, final SingleDiffNode singleDiffNode2, final int n, final int n2) {
        final String padEnd = Strings.padEnd("missing", n + 1, ' ');
        final String padEnd2 = Strings.padEnd("missing", n2 + 1, ' ');
        String s2;
        if (singleDiffNode != null) {
            s2 = getHtml(singleDiffNode.getRealizer().getNodeContent(), Fonts.NORMAL_FONT.getName(), n).replace("<html>", "").replace("</html>", "");
        }
        else {
            final ArrayList<String> list = new ArrayList<String>();
            list.add(padEnd);
            s2 = HtmlGenerator.getHtml(list, Fonts.NORMAL_FONT.getName(), false);
        }
        String s3;
        if (singleDiffNode2 != null) {
            s3 = getHtml(singleDiffNode2.getRealizer().getNodeContent(), Fonts.NORMAL_FONT.getName(), n2).replace("<html>", "").replace("</html>", "");
        }
        else {
            final ArrayList<String> list2 = new ArrayList<String>();
            list2.add(padEnd2);
            s3 = HtmlGenerator.getHtml(list2, Fonts.NORMAL_FONT.getName(), false);
        }
        return createTwoSidedContent(s, s2, s3);
    }
    
    public static String generateProximityNodeTooltip(final ZyProximityNode zyProximityNode) {
        final LinkedHashSet<String> set = new LinkedHashSet<String>();
        final List list = zyProximityNode.isIncoming() ? ((IGraphNode)zyProximityNode.getRawNode().getAttachedNode()).getChildren() : ((IGraphNode)zyProximityNode.getRawNode().getAttachedNode()).getParents();
        int n = 0;
        int n2 = 0;
        for (final RawFunction next : list) {
            if (next.isVisible()) {
                continue;
            }
            if (n != 0) {
                n2 = 0;
                break;
            }
            if (next instanceof RawFunction) {
                final RawFunction rawFunction = next;
                set.add(String.format("%s  %s", rawFunction.getAddress().toHexString(), rawFunction.getName()));
            }
            else if (next instanceof RawBasicBlock) {
                set.add(((RawBasicBlock)next).getAddress().toHexString());
            }
            if (++n2 != 25) {
                continue;
            }
            n = 1;
        }
        if (n != 0 && n2 == 0) {
            set.add("...");
        }
        return HtmlGenerator.getHtml(set, GuiHelper.getMonospaceFont(), false);
    }
    
    public static String generateProximityNodeTooltip(final String s, final ZyProximityNode zyProximityNode) {
        final List list = zyProximityNode.isIncoming() ? ((IGraphNode)zyProximityNode.getRawNode().getAttachedNode()).getChildren() : ((IGraphNode)zyProximityNode.getRawNode().getAttachedNode()).getParents();
        int n = 0;
        int n2 = 0;
        final StringBuffer sb = new StringBuffer();
        final StringBuffer sb2 = new StringBuffer();
        for (final RawCombinedFunction next : list) {
            if (next.isVisible()) {
                continue;
            }
            if (n != 0) {
                n2 = 0;
                break;
            }
            if (next instanceof RawCombinedFunction) {
                final RawCombinedFunction rawCombinedFunction = next;
                final RawFunction rawNode = rawCombinedFunction.getRawNode(ESide.PRIMARY);
                sb.append((rawNode == null) ? "missing" : String.format("%s  %s", rawNode.getAddress().toHexString(), HtmlGenerator.escapeHtml(rawNode.getName())));
                final RawFunction rawNode2 = rawCombinedFunction.getRawNode(ESide.SECONDARY);
                sb2.append((rawNode2 == null) ? "missing" : String.format("%s  %s", rawNode2.getAddress().toHexString(), HtmlGenerator.escapeHtml(rawNode2.getName())));
            }
            else {
                if (!(next instanceof RawCombinedBasicBlock)) {
                    continue;
                }
                final RawCombinedBasicBlock rawCombinedBasicBlock = (RawCombinedBasicBlock)next;
                final RawBasicBlock rawNode3 = rawCombinedBasicBlock.getRawNode(ESide.PRIMARY);
                sb.append((rawNode3 == null) ? TooltipGenerationHelper.MISSING_STRING : rawNode3.getAddress().toHexString());
                final RawBasicBlock rawNode4 = rawCombinedBasicBlock.getRawNode(ESide.SECONDARY);
                sb2.append((rawNode4 == null) ? TooltipGenerationHelper.MISSING_STRING : rawNode4.getAddress().toHexString());
            }
            sb.append("<br>");
            sb2.append("<br>");
            if (++n2 != 25) {
                continue;
            }
            n = 1;
        }
        if (n != 0 && n2 == 0) {
            sb.append("...");
            sb2.append("...");
        }
        return createTwoSidedContent(s, sb.toString(), sb2.toString());
    }
}
