package org.jfree.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.UIManager;

public class BevelArrowIcon implements Icon {
   public static final int UP = 0;
   public static final int DOWN = 1;
   private static final int DEFAULT_SIZE = 11;
   private Color edge1;
   private Color edge2;
   private Color fill;
   private int size;
   private int direction;

   public BevelArrowIcon(int var1, boolean var2, boolean var3) {
      if(var2) {
         if(var3) {
            this.init(UIManager.getColor("controlLtHighlight"), UIManager.getColor("controlDkShadow"), UIManager.getColor("controlShadow"), 11, var1);
         } else {
            this.init(UIManager.getColor("controlHighlight"), UIManager.getColor("controlShadow"), UIManager.getColor("control"), 11, var1);
         }
      } else if(var3) {
         this.init(UIManager.getColor("controlDkShadow"), UIManager.getColor("controlLtHighlight"), UIManager.getColor("controlShadow"), 11, var1);
      } else {
         this.init(UIManager.getColor("controlShadow"), UIManager.getColor("controlHighlight"), UIManager.getColor("control"), 11, var1);
      }

   }

   public BevelArrowIcon(Color var1, Color var2, Color var3, int var4, int var5) {
      this.init(var1, var2, var3, var4, var5);
   }

   public void paintIcon(Component var1, Graphics var2, int var3, int var4) {
      switch(this.direction) {
      case 0:
         this.drawUpArrow(var2, var3, var4);
         break;
      case 1:
         this.drawDownArrow(var2, var3, var4);
      }

   }

   public int getIconWidth() {
      return this.size;
   }

   public int getIconHeight() {
      return this.size;
   }

   private void init(Color var1, Color var2, Color var3, int var4, int var5) {
      this.edge1 = var1;
      this.edge2 = var2;
      this.fill = var3;
      this.size = var4;
      this.direction = var5;
   }

   private void drawDownArrow(Graphics var1, int var2, int var3) {
      var1.setColor(this.edge1);
      var1.drawLine(var2, var3, var2 + this.size - 1, var3);
      var1.drawLine(var2, var3 + 1, var2 + this.size - 3, var3 + 1);
      var1.setColor(this.edge2);
      var1.drawLine(var2 + this.size - 2, var3 + 1, var2 + this.size - 1, var3 + 1);
      int var4 = var2 + 1;
      int var5 = var3 + 2;

      for(int var6 = this.size - 6; var5 + 1 < var3 + this.size; var6 -= 2) {
         var1.setColor(this.edge1);
         var1.drawLine(var4, var5, var4 + 1, var5);
         var1.drawLine(var4, var5 + 1, var4 + 1, var5 + 1);
         if(0 < var6) {
            var1.setColor(this.fill);
            var1.drawLine(var4 + 2, var5, var4 + 1 + var6, var5);
            var1.drawLine(var4 + 2, var5 + 1, var4 + 1 + var6, var5 + 1);
         }

         var1.setColor(this.edge2);
         var1.drawLine(var4 + var6 + 2, var5, var4 + var6 + 3, var5);
         var1.drawLine(var4 + var6 + 2, var5 + 1, var4 + var6 + 3, var5 + 1);
         ++var4;
         var5 += 2;
      }

      var1.setColor(this.edge1);
      var1.drawLine(var2 + this.size / 2, var3 + this.size - 1, var2 + this.size / 2, var3 + this.size - 1);
   }

   private void drawUpArrow(Graphics var1, int var2, int var3) {
      var1.setColor(this.edge1);
      int var4 = var2 + this.size / 2;
      var1.drawLine(var4, var3, var4, var3);
      --var4;
      int var5 = var3 + 1;

      for(int var6 = 0; var5 + 3 < var3 + this.size; var6 += 2) {
         var1.setColor(this.edge1);
         var1.drawLine(var4, var5, var4 + 1, var5);
         var1.drawLine(var4, var5 + 1, var4 + 1, var5 + 1);
         if(0 < var6) {
            var1.setColor(this.fill);
            var1.drawLine(var4 + 2, var5, var4 + 1 + var6, var5);
            var1.drawLine(var4 + 2, var5 + 1, var4 + 1 + var6, var5 + 1);
         }

         var1.setColor(this.edge2);
         var1.drawLine(var4 + var6 + 2, var5, var4 + var6 + 3, var5);
         var1.drawLine(var4 + var6 + 2, var5 + 1, var4 + var6 + 3, var5 + 1);
         --var4;
         var5 += 2;
      }

      var1.setColor(this.edge1);
      var1.drawLine(var2, var3 + this.size - 3, var2 + 1, var3 + this.size - 3);
      var1.setColor(this.edge2);
      var1.drawLine(var2 + 2, var3 + this.size - 2, var2 + this.size - 1, var3 + this.size - 2);
      var1.drawLine(var2, var3 + this.size - 1, var2 + this.size, var3 + this.size - 1);
   }
}
