package com.google.security.zynamics.zylib.gui.tables;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

class CTableSorter$Arrow implements Icon {
   private final boolean descending;
   private final int size;
   private final int priority;

   public CTableSorter$Arrow(boolean var1, int var2, int var3) {
      this.descending = var1;
      this.size = var2;
      this.priority = var3;
   }

   public int getIconHeight() {
      return this.size;
   }

   public int getIconWidth() {
      return this.size;
   }

   public void paintIcon(Component var1, Graphics var2, int var3, int var4) {
      Color var5 = var1 == null?Color.GRAY:var1.getBackground();
      int var6 = (int)((double)(this.size / 2) * Math.pow(0.8D, (double)this.priority));
      int var7 = this.descending?var6:-var6;
      var4 = var4 + 5 * this.size / 6 + (this.descending?-var7:0);
      int var8 = this.descending?1:-1;
      var2.translate(var3, var4);
      var2.setColor(var5.darker());
      var2.drawLine(var6 / 2, var7, 0, 0);
      var2.drawLine(var6 / 2, var7 + var8, 0, var8);
      var2.setColor(var5.brighter());
      var2.drawLine(var6 / 2, var7, var6, 0);
      var2.drawLine(var6 / 2, var7 + var8, var6, var8);
      if(this.descending) {
         var2.setColor(var5.darker().darker());
      } else {
         var2.setColor(var5.brighter().brighter());
      }

      var2.drawLine(var6, 0, 0, 0);
      var2.setColor(var5);
      var2.translate(-var3, -var4);
   }
}
