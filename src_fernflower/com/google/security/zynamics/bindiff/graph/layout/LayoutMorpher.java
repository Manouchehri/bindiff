package com.google.security.zynamics.bindiff.graph.layout;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import y.c.i;
import y.f.O;
import y.h.ch;
import y.h.dj;

public class LayoutMorpher extends dj {
   private ch view;

   public LayoutMorpher(ch var1, O var2) {
      super(var1, var2);
   }

   protected Rectangle2D calcBoundingBox(i var1, O var2, Rectangle2D var3) {
      super.calcBoundingBox(var1, var2, var3);
      Rectangle var4 = this.view.getVisibleRect();
      double var5 = this.view.getZoom();
      this.view.fitRectangle(var3.getBounds());
      this.view.setZoom(this.view.getZoom() * 0.95D);
      Rectangle var7 = this.view.getVisibleRect();
      var3.setFrame(var7.getX(), var7.getY(), var7.getWidth(), var7.getHeight());
      this.view.fitRectangle(var4);
      this.view.setZoom(var5);
      return var3;
   }

   protected void initialize(ch var1, O var2) {
      super.initialize(var1, var2);
      this.view = var1;
   }
}
