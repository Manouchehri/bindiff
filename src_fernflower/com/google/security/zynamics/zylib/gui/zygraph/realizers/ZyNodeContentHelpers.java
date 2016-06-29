package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent$ObjectWrapper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.geom.Rectangle2D;

public class ZyNodeContentHelpers {
   public static Object getObject(ZyGraphNode var0, double var1, double var3) {
      ZyLineContent$ObjectWrapper var5 = getObjectWrapper(var0, var1, var3);
      return var5 == null?null:var5.getObject();
   }

   public static ZyLineContent$ObjectWrapper getObjectWrapper(ZyGraphNode var0, double var1, double var3) {
      IZyNodeRealizer var5 = var0.getRealizer();
      ZyLabelContent var6 = var5.getNodeContent();
      Rectangle2D var7 = var6.getBounds();
      double var8 = var5.getWidth() / var7.getWidth();
      double var10 = var3 - var0.getY();
      int var12 = var0.positionToRow(var10);
      if(var12 == -1) {
         return null;
      } else {
         ZyLineContent var13 = var6.getLineContent(var12);
         double var14 = ((var1 - var0.getX()) / var8 - (double)var6.getPaddingLeft()) / var13.getCharWidth();
         return var13.getObjectWrapper((int)var14);
      }
   }
}
