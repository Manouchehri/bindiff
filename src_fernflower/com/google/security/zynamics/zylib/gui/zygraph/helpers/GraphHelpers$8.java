package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.util.Iterator;

final class GraphHelpers$8 implements INodeCallback {
   // $FF: synthetic field
   final StringBuilder val$selection;

   GraphHelpers$8(StringBuilder var1) {
      this.val$selection = var1;
   }

   public IterationMode next(ZyGraphNode var1) {
      IZyNodeRealizer var2 = var1.getRealizer();
      ZyLabelContent var3 = var2.getNodeContent();
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         ZyLineContent var5 = (ZyLineContent)var4.next();
         this.val$selection.append(var5.getText());
         this.val$selection.append("\n");
      }

      this.val$selection.append("\n");
      return IterationMode.CONTINUE;
   }
}
