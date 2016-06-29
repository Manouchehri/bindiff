package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions.LayoutFunctions$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.settings.ILayoutSettings;
import y.f.O;
import y.f.P;
import y.f.V;
import y.f.X;
import y.f.aE;
import y.f.aF;
import y.f.ad;
import y.f.ae;
import y.f.aw;
import y.f.b;
import y.f.c;
import y.f.a.a;
import y.g.q;
import y.h.bu;
import y.h.dj;
import y.h.fk;

public class LayoutFunctions {
   public static final int PREFERRED_ANIMATION_TIME_CONSTANT_FACTOR_MS = 100;

   public static O doLayout(AbstractZyGraph var0, c var1) {
      Preconditions.checkNotNull(var1, "Internal Error: Can not layout the graph without initializing the layouter first");
      O var2 = null;
      ILayoutSettings var3 = var0.getSettings().getLayoutSettings();
      if(var3.getCurrentLayouter().h() == 0) {
         var0.getGraph().a((Object)aF.a, (y.c.c)q.a((Object)aE.a((byte)2)));
         var0.getGraph().a((Object)aF.b, (y.c.c)q.a((Object)aE.a((byte)1)));
      }

      if(var3.getCurrentLayouter().h() == 1) {
         var0.getGraph().a((Object)aF.a, (y.c.c)q.a((Object)aE.a((byte)4)));
         var0.getGraph().a((Object)aF.b, (y.c.c)q.a((Object)aE.a((byte)8)));
      }

      var1.c((ad)(new V()));
      var1.c(true);
      dj var4;
      if(var0.getNodes().size() < var3.getAnimateLayoutNodeThreshold() && var0.getEdges().size() < var3.getAnimateLayoutEdgeThreshold()) {
         if(var0.getSettings().getLayoutSettings().getAnimateLayout()) {
            ((y.h.O)var0.getView().getGraph2DRenderer()).setDrawEdgesFirst(true);
            var2 = (new b(var1)).b(var0.getGraph());
            var4 = new dj();
            var4.setSmoothViewTransform(true);
            var4.setPreferredDuration((long)(100 * var0.getSettings().getDisplaySettings().getAnimationSpeed()));
            (new LayoutFunctions$1(var4, var0, var2)).invokeLater();
            recalculatePorts(var1, var0.getGraph());
         } else {
            var2 = (new b(var1)).b(var0.getGraph());
            ae.a((X)var0.getGraph(), (O)var2);
            recalculatePorts(var1, var0.getGraph());
         }
      } else {
         var2 = (new b(var1)).b(var0.getGraph());
         ae.a((X)var0.getGraph(), (O)var2);
         var4 = new dj();
         var4.setPreferredDuration((long)(100 * var0.getSettings().getDisplaySettings().getAnimationSpeed()));
         var4.execute(var0.getView(), var2);
      }

      return var2;
   }

   public static void recalculatePorts(c var0, bu var1) {
      if(var0 instanceof a) {
         ae.d(var1);
         aw var2 = new aw();
         fk var3 = new fk(var1, true);
         var1.a((Object)P.a, (y.c.c)var3);
         fk var4 = new fk(var1, false);
         var1.a((Object)P.b, (y.c.c)var4);
         var2.c(var1);
      }

   }
}
