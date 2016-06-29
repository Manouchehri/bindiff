package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.util.Iterator;

public final class ClipboardCopier {
   public static void copyToClipboard(ZyGraphNode var0) {
      Preconditions.checkNotNull(var0, "Error: Node argument can not be null");
      IZyNodeRealizer var1 = var0.getRealizer();
      ZyLabelContent var2 = var1.getNodeContent();
      if(var2.isSelectable()) {
         StringBuilder var4 = new StringBuilder();
         Iterator var5 = var2.iterator();

         while(var5.hasNext()) {
            ZyLineContent var6 = (ZyLineContent)var5.next();
            var4.append(var6.getText());
            var4.append("\n");
         }

         ClipboardHelpers.copyToClipboard(var4.toString());
      }

   }

   public static void copyToClipboard(ZyGraphNode var0, int var1) {
      Preconditions.checkNotNull(var0, "Error: Node argument can not be null");
      IZyNodeRealizer var2 = var0.getRealizer();
      ZyLabelContent var3 = var2.getNodeContent();
      Preconditions.checkArgument(var1 >= 0 && var1 < var3.getLineCount(), "Error: Line argument is out of bounds");
      if(var3.isSelectable()) {
         ClipboardHelpers.copyToClipboard(var3.getLineContent(var1).getText());
      }

   }
}
