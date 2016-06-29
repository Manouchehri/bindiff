package com.google.security.zynamics.bindiff.graph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D.Double;
import y.h.y;

public class SingleEdgeRealizer extends ZyEdgeRealizer {
   public static final Color BEND_SELECTION_COLOR = new Color(255, 200, 0);
   private final GraphSettings settings;

   public SingleEdgeRealizer(ZyLabelContent var1, IEdgeRealizerUpdater var2, GraphSettings var3) {
      super(var1, var2);
      Preconditions.checkNotNull(var3);
      this.settings = var3;
      this.setSmoothedBends(true);
   }

   public void paintBends(Graphics2D var1) {
      if(this.settings.getDrawBends()) {
         y var2 = this.bends();

         while(var2.f()) {
            double var3 = var2.a().b();
            double var5 = var2.a().c();
            boolean var7 = var2.a().d();
            Color var8 = var1.getColor();
            Stroke var9 = var1.getStroke();
            float var10 = var7?2.0F:1.0F;
            int var11 = var7?7:5;
            float var12 = var7?3.0F:2.0F;
            var1.setStroke(new BasicStroke(var10));
            var1.setColor(var7?BEND_SELECTION_COLOR:Color.WHITE);
            var1.fill(new Double(var3 - (double)var12, var5 - (double)var12, (double)var11, (double)var11));
            var1.setColor(Color.BLACK);
            var1.draw(new Double(var3 - (double)var12, var5 - (double)var12, (double)var11, (double)var11));
            var1.setColor(var8);
            var1.setStroke(var9);
            var2.g();
         }
      }

   }
}
