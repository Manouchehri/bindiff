package org.jfree.chart.title;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import org.jfree.chart.event.TitleChangeEvent;
import org.jfree.chart.title.Title;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.Size2D;
import org.jfree.ui.VerticalAlignment;

public class ImageTitle extends Title {
   private Image image;

   public ImageTitle(Image var1) {
      this(var1, var1.getHeight((ImageObserver)null), var1.getWidth((ImageObserver)null), Title.DEFAULT_POSITION, Title.DEFAULT_HORIZONTAL_ALIGNMENT, Title.DEFAULT_VERTICAL_ALIGNMENT, Title.DEFAULT_PADDING);
   }

   public ImageTitle(Image var1, RectangleEdge var2, HorizontalAlignment var3, VerticalAlignment var4) {
      this(var1, var1.getHeight((ImageObserver)null), var1.getWidth((ImageObserver)null), var2, var3, var4, Title.DEFAULT_PADDING);
   }

   public ImageTitle(Image var1, int var2, int var3, RectangleEdge var4, HorizontalAlignment var5, VerticalAlignment var6, RectangleInsets var7) {
      super(var4, var5, var6, var7);
      if(var1 == null) {
         throw new NullPointerException("Null \'image\' argument.");
      } else {
         this.image = var1;
         this.setHeight((double)var2);
         this.setWidth((double)var3);
      }
   }

   public Image getImage() {
      return this.image;
   }

   public void setImage(Image var1) {
      if(var1 == null) {
         throw new NullPointerException("Null \'image\' argument.");
      } else {
         this.image = var1;
         this.notifyListeners(new TitleChangeEvent(this));
      }
   }

   public void draw(Graphics2D var1, Rectangle2D var2) {
      RectangleEdge var3 = this.getPosition();
      if(var3 != RectangleEdge.TOP && var3 != RectangleEdge.BOTTOM) {
         if(var3 != RectangleEdge.LEFT && var3 != RectangleEdge.RIGHT) {
            throw new RuntimeException("Invalid title position.");
         }

         this.drawVertical(var1, var2);
      } else {
         this.drawHorizontal(var1, var2);
      }

   }

   protected Size2D drawHorizontal(Graphics2D var1, Rectangle2D var2) {
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      double var11 = 0.0D;
      double var13 = this.getWidth();
      double var15 = this.getHeight();
      RectangleInsets var17 = this.getPadding();
      var5 = var17.calculateTopOutset(var15);
      var7 = var17.calculateBottomOutset(var15);
      var9 = var17.calculateLeftOutset(var13);
      var11 = var17.calculateRightOutset(var13);
      if(this.getPosition() == RectangleEdge.TOP) {
         var3 = var2.getY() + var5;
      } else {
         var3 = var2.getY() + var2.getHeight() - var7 - var15;
      }

      HorizontalAlignment var18 = this.getHorizontalAlignment();
      double var19 = 0.0D;
      if(var18 == HorizontalAlignment.CENTER) {
         var19 = var2.getX() + var9 + var2.getWidth() / 2.0D - var13 / 2.0D;
      } else if(var18 == HorizontalAlignment.LEFT) {
         var19 = var2.getX() + var9;
      } else if(var18 == HorizontalAlignment.RIGHT) {
         var19 = var2.getX() + var2.getWidth() - var11 - var13;
      }

      var1.drawImage(this.image, (int)var19, (int)var3, (int)var13, (int)var15, (ImageObserver)null);
      return new Size2D(var2.getWidth() + var9 + var11, var15 + var5 + var7);
   }

   protected Size2D drawVertical(Graphics2D var1, Rectangle2D var2) {
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      double var11 = 0.0D;
      double var13 = this.getWidth();
      double var15 = this.getHeight();
      RectangleInsets var17 = this.getPadding();
      if(var17 != null) {
         var5 = var17.calculateTopOutset(var15);
         var7 = var17.calculateBottomOutset(var15);
         var9 = var17.calculateLeftOutset(var13);
         var11 = var17.calculateRightOutset(var13);
      }

      if(this.getPosition() == RectangleEdge.LEFT) {
         var3 = var2.getX() + var9;
      } else {
         var3 = var2.getMaxX() - var11 - var13;
      }

      VerticalAlignment var18 = this.getVerticalAlignment();
      double var19 = 0.0D;
      if(var18 == VerticalAlignment.CENTER) {
         var19 = var2.getMinY() + var5 + var2.getHeight() / 2.0D - var15 / 2.0D;
      } else if(var18 == VerticalAlignment.TOP) {
         var19 = var2.getMinY() + var5;
      } else if(var18 == VerticalAlignment.BOTTOM) {
         var19 = var2.getMaxY() - var7 - var15;
      }

      var1.drawImage(this.image, (int)var3, (int)var19, (int)var13, (int)var15, (ImageObserver)null);
      return new Size2D(var2.getWidth() + var9 + var11, var15 + var5 + var7);
   }

   public Object draw(Graphics2D var1, Rectangle2D var2, Object var3) {
      this.draw(var1, var2);
      return null;
   }
}
