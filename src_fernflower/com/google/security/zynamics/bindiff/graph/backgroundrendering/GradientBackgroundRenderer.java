package com.google.security.zynamics.bindiff.graph.backgroundrendering;

import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.BackgroundRendererManager;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import y.h.M;
import y.h.ch;

public class GradientBackgroundRenderer extends M {
   private static int OFFSET = 15;
   private final Color GRADIENT_START_COLOR = new Color(250, 250, 250);
   private final ch graphView;
   private final Color gradientEndColor;
   private boolean update = false;
   private int oldViewWidth = 0;
   private int oldViewHeight = 0;
   private final String title;
   private final EGraph type;

   public GradientBackgroundRenderer(ViewData var1, ch var2, Color var3, EGraph var4) {
      super(var2);
      this.graphView = var2;
      this.gradientEndColor = var3;
      this.type = var4;
      this.title = BackgroundRendererManager.buildTitle(var1, var4);
   }

   public void paint(Graphics2D var1, int var2, int var3, int var4, int var5) {
      int var6 = this.graphView.getWidth();
      int var7 = this.graphView.getHeight();
      if(var6 != this.oldViewWidth || var7 != this.oldViewHeight || var6 == 0 && var7 == 0 || this.update) {
         this.update = false;
         this.oldViewWidth = var6;
         this.oldViewHeight = var7;
         BufferedImage var8 = new BufferedImage(var6, var7, 1);
         Graphics2D var9 = (Graphics2D)var8.getGraphics();
         GradientPaint var10 = new GradientPaint(0.0F, 0.0F, this.GRADIENT_START_COLOR, 0.0F, (float)var7, this.gradientEndColor);
         var9.setPaint(var10);
         var9.fill(new Double(0.0D, 0.0D, (double)var6, (double)var7));
         var9.setPaint(Color.GRAY.darker());
         int var11 = OFFSET;
         Font var12 = var9.getFont();
         Font var13 = new Font(var12.getName(), 1, var12.getSize());
         var9.setFont(var13);
         var9.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         if(this.type == EGraph.SECONDARY_GRAPH) {
            Rectangle2D var14 = var9.getFont().getStringBounds(this.title, var9.getFontRenderContext());
            var11 = Math.max(OFFSET, var6 - (int)var14.getWidth() - OFFSET);
         }

         var9.drawString(this.title, var11, OFFSET);
         var9.setFont(var12);
         this.setImage(var8);
      }

      super.paint(var1, var2, var3, var4, var5);
   }

   public void update() {
      this.update = true;
      this.graphView.getGraph2D().T();
   }
}
