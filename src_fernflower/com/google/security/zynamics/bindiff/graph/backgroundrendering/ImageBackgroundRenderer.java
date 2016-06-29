package com.google.security.zynamics.bindiff.graph.backgroundrendering;

import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.BackgroundRendererManager;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.ImageBackgroundRenderer$1;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import y.h.M;
import y.h.ch;

public class ImageBackgroundRenderer extends M {
   private static int OFFSET = 15;
   private final Image PRIMARY_TEXT_IMAGE = ImageUtils.getImage("data/graphview/primary.png");
   private final Image SECONDRAY_TEXT_IMAGE = ImageUtils.getImage("data/graphview/secondary.png");
   private final Image COMBINED_TEXT_IMAGE = ImageUtils.getImage("data/graphview/combined.png");
   private final ch graphView;
   private final EGraph type;
   private int oldViewWidth = 0;
   private int oldViewHeight = 0;
   private BufferedImage backgroundImage;
   private final String title;

   public ImageBackgroundRenderer(ViewData var1, ch var2, EGraph var3) {
      super(var2);
      this.graphView = var2;
      this.type = var3;
      this.title = BackgroundRendererManager.buildTitle(var1, var3);
   }

   private Image getTextImage() {
      return this.type == EGraph.PRIMARY_GRAPH?this.PRIMARY_TEXT_IMAGE:(this.type == EGraph.SECONDARY_GRAPH?this.SECONDRAY_TEXT_IMAGE:this.COMBINED_TEXT_IMAGE);
   }

   private int getX(int var1, int var2) {
      if(this.type == EGraph.SECONDARY_GRAPH) {
         int var3 = OFFSET;
         if(this.graphView.getVerticalScrollBarPolicy() == 22) {
            var3 += 15;
         }

         return var1 - var2 - var3;
      } else {
         return OFFSET;
      }
   }

   public void paint(Graphics2D var1, int var2, int var3, int var4, int var5) {
      if(var1 != null) {
         int var6 = this.graphView.getWidth();
         int var7 = this.graphView.getHeight();
         if(var6 != this.oldViewWidth || var7 != this.oldViewHeight && var6 != 0 && var7 != 0) {
            this.oldViewWidth = var6;
            this.oldViewHeight = var7;
            this.backgroundImage = new BufferedImage(var6, var7, 1);
         }

         if(this.backgroundImage != null) {
            Graphics2D var8 = (Graphics2D)this.backgroundImage.getGraphics();
            var8.setPaint(Color.WHITE);
            var8.fill(new Double(0.0D, 0.0D, (double)var6, (double)var7));
            var8.setPaint(Color.GRAY.darker());
            int var9 = this.getX(var6, this.SECONDRAY_TEXT_IMAGE.getWidth((ImageObserver)null));
            int var10 = var9;
            Font var11 = var8.getFont();
            Font var12 = new Font(var11.getName(), 1, var11.getSize());
            var8.setFont(var12);
            var8.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if(this.type == EGraph.SECONDARY_GRAPH) {
               Rectangle2D var13 = var8.getFont().getStringBounds(this.title, var8.getFontRenderContext());
               var10 = this.getX(var6, Math.max(OFFSET, (int)var13.getWidth()));
            }

            var8.drawString(this.title, var10, 15);
            var8.drawImage(this.getTextImage(), var9, 20, (ImageObserver)null);
            var8.setFont(var11);
            this.setImage(this.backgroundImage);
         }

         super.paint(var1, var2, var3, var4, var5);
      }
   }

   public void update() {
      EventQueue.invokeLater(new ImageBackgroundRenderer$1(this));
   }

   // $FF: synthetic method
   static ch access$000(ImageBackgroundRenderer var0) {
      return var0.graphView;
   }
}
