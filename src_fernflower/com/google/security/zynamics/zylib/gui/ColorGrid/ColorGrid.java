package com.google.security.zynamics.zylib.gui.ColorGrid;

import com.google.common.base.Preconditions;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

public class ColorGrid extends JPanel {
   private static final long serialVersionUID = -5981626927250840656L;
   private static final int squareSize = 40;
   private final List m_colors;
   private final int m_columns;

   public ColorGrid(List var1, int var2) {
      this.m_colors = (List)Preconditions.checkNotNull(var1, "Error: colors argument can not be null");
      this.m_columns = var2;
      int var3 = this.m_colors.size() / this.m_columns + (this.m_colors.size() % this.m_columns == 0?0:1);
      this.setPreferredSize(new Dimension(var2 * 40, var3 * 40));
   }

   public Color getColorAt(int var1, int var2) {
      int var3 = var2 / 40;
      int var4 = var1 / 40;
      return var3 * this.m_columns + var4 < this.m_colors.size()?(Color)this.m_colors.get(var3 * this.m_columns + var4):null;
   }

   public void paint(Graphics var1) {
      int var2 = this.m_colors.size() / this.m_columns + (this.m_colors.size() % this.m_columns == 0?0:1);

      for(int var3 = 0; var3 < var2; ++var3) {
         for(int var4 = 0; var4 < this.m_columns && var3 * this.m_columns + var4 < this.m_colors.size(); ++var4) {
            var1.setColor((Color)this.m_colors.get(var3 * this.m_columns + var4));
            var1.fillRect(var4 * 40, var3 * 40, 40, 40);
            var1.setColor(Color.BLACK);
            var1.drawRect(var4 * 40, var3 * 40, 40, 40);
         }
      }

   }
}
