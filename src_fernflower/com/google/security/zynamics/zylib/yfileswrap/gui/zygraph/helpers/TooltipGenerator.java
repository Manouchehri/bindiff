package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.HtmlGenerator;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ICodeNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IFunctionNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
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
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import y.c.d;
import y.c.q;

public final class TooltipGenerator {
   private static String generateProximityNodeRealizer(AbstractZyGraph var0, ZyProximityNode var1) {
      // $FF: Couldn't be decompiled
   }

   private static boolean requiresBoldFirstLine(ZyGraphNode var0) {
      return var0 != null && (var0.getRawNode() instanceof ICodeNode || var0.getRawNode() instanceof IFunctionNode);
   }

   public static String createTooltip(AbstractZyGraph var0, d var1) {
      Preconditions.checkNotNull(var0, "Error: Graph argument can not be null");
      Preconditions.checkNotNull(var1, "Error: Edge argument can not be null");
      String var2 = createTooltip(var0, var1.c()).replace("</html>", "");
      ZyEdgeRealizer var3 = (ZyEdgeRealizer)var0.getGraph().i(var1);
      if(var3.labelCount() > 0) {
         ZyEdgeLabel var4 = (ZyEdgeLabel)var3.getLabel();
         ZyLabelContent var5 = var4.getLabelContent();
         String var6 = String.valueOf(var2);
         String var7 = String.valueOf(HtmlGenerator.getHtml(var5, GuiHelper.getMonospaceFont(), false).replace("<html>", "").replace("</html>", ""));
         var2 = (new StringBuilder(4 + String.valueOf(var6).length() + String.valueOf(var7).length())).append(var6).append("<hr>").append(var7).toString();
      }

      String var8 = String.valueOf(var2);
      String var9 = String.valueOf(createTooltip(var0, var1.d()).replace("<html>", ""));
      var2 = (new StringBuilder(4 + String.valueOf(var8).length() + String.valueOf(var9).length())).append(var8).append("<hr>").append(var9).toString();
      return var2;
   }

   public static String createTooltip(AbstractZyGraph var0, q var1) {
      Preconditions.checkNotNull(var0, "Error: Graph argument can not be null");
      Preconditions.checkNotNull(var1, "Error: Node argument can not be null");
      IZyNodeRealizer var2 = (IZyNodeRealizer)var0.getGraph().t(var1);
      if(var2 instanceof ZyProximityNodeRealizer) {
         return generateProximityNodeRealizer(var0, (ZyProximityNode)var2.getUserData().getNode());
      } else {
         ZyLabelContent var3 = var2.getNodeContent();
         boolean var4 = requiresBoldFirstLine(var0.getNode(var1));
         return HtmlGenerator.getHtml(var3, GuiHelper.getMonospaceFont(), var4);
      }
   }
}
