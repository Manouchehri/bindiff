package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.CStyleRunData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import y.c.q;

public class SingleDiffBasicBlockNode extends SingleDiffNode {
   public SingleDiffBasicBlockNode(q var1, IZyNodeRealizer var2, SingleViewNode var3, ESide var4) {
      super(var1, var2, var3, var4);
   }

   protected void onSelectionChanged() {
      Color var1 = this.getSide() == ESide.PRIMARY?Colors.PRIMARY_BASE:Colors.SECONDARY_BASE;
      if(this.isSelected()) {
         var1 = var1.darker();
      }

      Iterator var2 = this.getRealizer().getNodeContent().getContent().iterator();

      while(true) {
         ZyLineContent var3;
         int var4;
         do {
            if(!var2.hasNext()) {
               return;
            }

            var3 = (ZyLineContent)var2.next();
            var4 = var3.getText().length();
         } while(var4 <= 0);

         List var5 = var3.getBackgroundStyleRunData(0, var4 - 1);
         Iterator var6 = var5.iterator();

         while(var6.hasNext()) {
            CStyleRunData var7 = (CStyleRunData)var6.next();
            Color var8 = var7.getColor();
            if(var8 != Colors.SEARCH_HIGHLIGHT_COLOR && var8 != null) {
               if(var4 == var7.getEnd()) {
                  var3.setBackgroundColor(var7.getStart(), var7.getLength(), var1);
               } else {
                  var3.setBackgroundColor(var7.getStart(), var7.getLength() - 1, var1);
               }
            }
         }
      }
   }
}
