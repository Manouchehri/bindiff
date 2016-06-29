package org.jfree.chart.renderer.category;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import javax.swing.Icon;
import org.jfree.chart.renderer.category.MinMaxCategoryRenderer;

final class MinMaxCategoryRenderer$2 implements Icon {
   private final GeneralPath val$path;
   private final boolean val$fill;
   private final boolean val$outline;
   private final int val$width;
   private final int val$height;
   private final MinMaxCategoryRenderer this$0;

   MinMaxCategoryRenderer$2(MinMaxCategoryRenderer var1, GeneralPath var2, boolean var3, boolean var4, int var5, int var6) {
      this.this$0 = var1;
      this.val$path = var2;
      this.val$fill = var3;
      this.val$outline = var4;
      this.val$width = var5;
      this.val$height = var6;
   }

   public void paintIcon(Component var1, Graphics var2, int var3, int var4) {
      Graphics2D var5 = (Graphics2D)var2;
      this.val$path.transform(AffineTransform.getTranslateInstance((double)var3, (double)var4));
      if(this.val$fill) {
         var5.fill(this.val$path);
      }

      if(this.val$outline) {
         var5.draw(this.val$path);
      }

      this.val$path.transform(AffineTransform.getTranslateInstance((double)(-var3), (double)(-var4)));
   }

   public int getIconWidth() {
      return this.val$width;
   }

   public int getIconHeight() {
      return this.val$height;
   }
}
