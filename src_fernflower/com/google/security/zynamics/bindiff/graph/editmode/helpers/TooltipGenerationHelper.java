package com.google.security.zynamics.bindiff.graph.editmode.helpers;

import com.google.common.base.Strings;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.resources.Fonts;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.HtmlGenerator;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class TooltipGenerationHelper {
   private static final int NODE_TOOLTIP_MAX_LINES = 25;
   private static final String MISSING_STRING = "missing";

   private static String createTwoSidedContent(String var0, String var1, String var2) {
      StringBuilder var3 = new StringBuilder(String.format("<html><font face=\"%s\" size=\"3\" color=\"000000\">", new Object[]{var0}));
      var3.append("<table cellspacing=\"5\" border=\"0\" cellpadding=\"0\">");
      var3.append("<tr valign=\"middle\" align=\"left\">");
      var3.append("<td>");
      var3.append(var1);
      var3.append("</td>");
      var3.append("<td width=\"1\" bgcolor=\"#000000\"><br></td>");
      var3.append("<td>");
      var3.append(var2);
      var3.append("</td>");
      var3.append("</tr>");
      var3.append("</table>");
      var3.append("</font></html>");
      return var3.toString();
   }

   private static String getHtml(ZyLabelContent var0, String var1, int var2) {
      StringBuilder var3 = new StringBuilder(String.format("<html><font face=\"%s\" size=\"3\" color=\"000000\">", new Object[]{var1}));
      int var4 = Math.min(var0.getLineCount(), 25);

      for(int var5 = 0; var5 < var4; ++var5) {
         String var6 = var0.getLineContent(var5).getText();
         if(var5 == 0 && var6.length() < var2) {
            for(int var7 = var6.length(); var7 < var2; ++var7) {
               var6 = String.valueOf(var6).concat(" ");
            }
         }

         var3.append(HtmlGenerator.escapeHtml(var6));
         var3.append("<br>");
      }

      if(var0.getLineCount() > 25) {
         var3.append("...");
         var3.append("<br>");
      }

      var3.append("</font></html>");
      return var3.toString();
   }

   private static int getMaxLineCharacterCount(SingleDiffNode var0) {
      if(var0 == null) {
         return "missing".length();
      } else {
         int var1 = 0;
         int var2 = 0;
         Iterator var3 = var0.getRealizer().getNodeContent().iterator();

         do {
            if(!var3.hasNext()) {
               return var2;
            }

            ZyLineContent var4 = (ZyLineContent)var3.next();
            var2 = Math.max(var2, var4.getText().length());
            ++var1;
         } while(var1 <= 25);

         return var2;
      }
   }

   public static String generateCombinedEdgeTooltips(String var0, CombinedDiffNode var1, CombinedDiffNode var2) {
      StringBuilder var3 = new StringBuilder();
      SingleDiffNode var4 = var1.getPrimaryDiffNode();
      SingleDiffNode var5 = var1.getSecondaryDiffNode();
      SingleDiffNode var6 = var2.getPrimaryDiffNode();
      SingleDiffNode var7 = var2.getSecondaryDiffNode();
      int var8 = getMaxLineCharacterCount(var4);
      var8 = Math.max(var8, getMaxLineCharacterCount(var6));
      int var9 = getMaxLineCharacterCount(var5);
      var9 = Math.max(var9, getMaxLineCharacterCount(var7));
      String var10 = generateCombinedNodeTooltip(var0, var4, var5, var8, var9);
      var10 = var10.replace("</html>", "");
      String var11 = generateCombinedNodeTooltip(var0, var6, var7, var8, var9);
      var11 = var11.replace("<html>", "");
      var3.append(var10);
      var3.append("<hr></hr>");
      var3.append(var11);
      return var3.toString();
   }

   public static String generateCombinedNodeTooltip(String var0, SingleDiffNode var1, SingleDiffNode var2, int var3, int var4) {
      String var5 = Strings.padEnd("missing", var3 + 1, ' ');
      String var6 = Strings.padEnd("missing", var4 + 1, ' ');
      ZyLabelContent var7;
      ArrayList var8;
      if(var1 != null) {
         var7 = var1.getRealizer().getNodeContent();
         var5 = getHtml(var7, Fonts.NORMAL_FONT.getName(), var3);
         var5 = var5.replace("<html>", "");
         var5 = var5.replace("</html>", "");
      } else {
         var8 = new ArrayList();
         var8.add(var5);
         var5 = HtmlGenerator.getHtml((Collection)var8, Fonts.NORMAL_FONT.getName(), false);
      }

      if(var2 != null) {
         var7 = var2.getRealizer().getNodeContent();
         var6 = getHtml(var7, Fonts.NORMAL_FONT.getName(), var4);
         var6 = var6.replace("<html>", "");
         var6 = var6.replace("</html>", "");
      } else {
         var8 = new ArrayList();
         var8.add(var6);
         var6 = HtmlGenerator.getHtml((Collection)var8, Fonts.NORMAL_FONT.getName(), false);
      }

      return createTwoSidedContent(var0, var5, var6);
   }

   public static String generateProximityNodeTooltip(ZyProximityNode var0) {
      LinkedHashSet var1 = new LinkedHashSet();
      List var2 = var0.isIncoming()?((IGraphNode)var0.getRawNode().getAttachedNode()).getChildren():((IGraphNode)var0.getRawNode().getAttachedNode()).getParents();
      boolean var3 = false;
      int var4 = 0;
      Iterator var5 = var2.iterator();

      while(var5.hasNext()) {
         Object var6 = var5.next();
         IViewNode var7 = (IViewNode)var6;
         if(!var7.isVisible()) {
            if(var3) {
               var4 = 0;
               break;
            }

            if(var6 instanceof RawFunction) {
               RawFunction var8 = (RawFunction)var6;
               var1.add(String.format("%s  %s", new Object[]{var8.getAddress().toHexString(), var8.getName()}));
            } else if(var6 instanceof RawBasicBlock) {
               RawBasicBlock var9 = (RawBasicBlock)var6;
               var1.add(var9.getAddress().toHexString());
            }

            ++var4;
            if(var4 == 25) {
               var3 = true;
            }
         }
      }

      if(var3 && var4 == 0) {
         var1.add("...");
      }

      return HtmlGenerator.getHtml((Collection)var1, GuiHelper.getMonospaceFont(), false);
   }

   public static String generateProximityNodeTooltip(String var0, ZyProximityNode var1) {
      List var2 = var1.isIncoming()?((IGraphNode)var1.getRawNode().getAttachedNode()).getChildren():((IGraphNode)var1.getRawNode().getAttachedNode()).getParents();
      boolean var3 = false;
      int var4 = 0;
      StringBuffer var5 = new StringBuffer();
      StringBuffer var6 = new StringBuffer();
      Iterator var7 = var2.iterator();

      while(var7.hasNext()) {
         Object var8 = var7.next();
         IViewNode var9 = (IViewNode)var8;
         if(!var9.isVisible()) {
            if(var3) {
               var4 = 0;
               break;
            }

            if(var8 instanceof RawCombinedFunction) {
               RawCombinedFunction var10 = (RawCombinedFunction)var8;
               RawFunction var11 = var10.getRawNode(ESide.PRIMARY);
               String var12 = var11 == null?"missing":String.format("%s  %s", new Object[]{var11.getAddress().toHexString(), HtmlGenerator.escapeHtml(var11.getName())});
               var5.append(var12);
               RawFunction var13 = var10.getRawNode(ESide.SECONDARY);
               String var14 = var13 == null?"missing":String.format("%s  %s", new Object[]{var13.getAddress().toHexString(), HtmlGenerator.escapeHtml(var13.getName())});
               var6.append(var14);
            } else {
               if(!(var8 instanceof RawCombinedBasicBlock)) {
                  continue;
               }

               RawCombinedBasicBlock var15 = (RawCombinedBasicBlock)var8;
               RawBasicBlock var16 = var15.getRawNode(ESide.PRIMARY);
               var5.append(var16 == null?MISSING_STRING:var16.getAddress().toHexString());
               RawBasicBlock var17 = var15.getRawNode(ESide.SECONDARY);
               var6.append(var17 == null?MISSING_STRING:var17.getAddress().toHexString());
            }

            var5.append("<br>");
            var6.append("<br>");
            ++var4;
            if(var4 == 25) {
               var3 = true;
            }
         }
      }

      if(var3 && var4 == 0) {
         var5.append("...");
         var6.append("...");
      }

      return createTwoSidedContent(var0, var5.toString(), var6.toString());
   }
}
