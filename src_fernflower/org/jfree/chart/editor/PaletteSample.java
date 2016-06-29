package org.jfree.chart.editor;

import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.Line2D.Double;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import org.jfree.chart.plot.ColorPalette;

public class PaletteSample extends JComponent implements ListCellRenderer {
   private ColorPalette palette;
   private Dimension preferredSize;

   public PaletteSample(ColorPalette var1) {
      this.palette = var1;
      this.preferredSize = new Dimension(80, 18);
   }

   public Component getListCellRendererComponent(JList var1, Object var2, int var3, boolean var4, boolean var5) {
      if(var2 instanceof PaletteSample) {
         PaletteSample var6 = (PaletteSample)var2;
         this.setPalette(var6.getPalette());
      }

      return this;
   }

   public ColorPalette getPalette() {
      return this.palette;
   }

   public Dimension getPreferredSize() {
      return this.preferredSize;
   }

   public void paintComponent(Graphics var1) {
      Graphics2D var2 = (Graphics2D)var1;
      var2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
      Dimension var3 = this.getSize();
      Insets var4 = this.getInsets();
      double var5 = var3.getWidth() - (double)var4.left - (double)var4.right;
      double var7 = var3.getHeight() - (double)var4.top - (double)var4.bottom;
      var2.setStroke(new BasicStroke(1.0F));
      double var9 = (double)var4.top;
      double var11 = var9 + var7;
      double var13 = (double)var4.left;
      Double var15 = new Double();

      for(int var16 = 0; var13 <= (double)var4.left + var5; ++var13) {
         ++var16;
         var15.setLine(var13, var9, var13, var11);
         var2.setPaint(this.palette.getColor(var16));
         var2.draw(var15);
      }

   }

   public void setPalette(ColorPalette var1) {
      this.palette = var1;
      this.repaint();
   }
}
