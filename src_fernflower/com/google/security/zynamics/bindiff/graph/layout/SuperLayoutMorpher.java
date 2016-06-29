package com.google.security.zynamics.bindiff.graph.layout;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeListener;
import y.c.i;
import y.f.O;
import y.h.bu;
import y.h.ch;
import y.h.dj;

public class SuperLayoutMorpher extends dj {
   private final bu superGraph;
   private ch view;

   public SuperLayoutMorpher(ch var1, O var2, bu var3) {
      super(var1, var2);
      this.superGraph = var3;
   }

   protected Rectangle2D calcBoundingBox(i var1, O var2, Rectangle2D var3) {
      super.calcBoundingBox(this.superGraph, var2, var3);
      Rectangle var4 = this.view.getVisibleRect();
      double var5 = this.view.getZoom();
      PropertyChangeListener[] var7 = this.view.getPropertyChangeListeners();
      PropertyChangeListener[] var8 = var7;
      int var9 = var7.length;

      int var10;
      for(var10 = 0; var10 < var9; ++var10) {
         PropertyChangeListener var11 = var8[var10];
         this.view.removePropertyChangeListener(var11);
      }

      this.view.fitRectangle(var3.getBounds());
      this.view.setZoom(this.view.getZoom() * 0.95D);
      Rectangle var14 = this.view.getVisibleRect();
      var3.setFrame(var14.getX(), var14.getY(), var14.getWidth(), var14.getHeight());
      this.view.fitRectangle(var4);
      this.view.setZoom(var5);
      PropertyChangeListener[] var15 = var7;
      var10 = var7.length;

      for(int var13 = 0; var13 < var10; ++var13) {
         PropertyChangeListener var12 = var15[var13];
         this.view.addPropertyChangeListener(var12);
      }

      return var3;
   }

   protected void initialize(ch var1, O var2) {
      super.initialize(var1, var2);
      this.view = var1;
   }
}
