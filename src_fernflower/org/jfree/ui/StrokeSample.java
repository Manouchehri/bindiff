package org.jfree.ui;

import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Point2D.Double;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class StrokeSample extends JComponent implements ListCellRenderer {
   private Stroke stroke;
   private Dimension preferredSize;

   public StrokeSample(Stroke var1) {
      this.stroke = var1;
      this.preferredSize = new Dimension(80, 18);
   }

   public Stroke getStroke() {
      return this.stroke;
   }

   public void setStroke(Stroke var1) {
      this.stroke = var1;
      this.repaint();
   }

   public Dimension getPreferredSize() {
      return this.preferredSize;
   }

   public void paintComponent(Graphics var1) {
      Graphics2D var2 = (Graphics2D)var1;
      var2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      Dimension var3 = this.getSize();
      Insets var4 = this.getInsets();
      double var5 = (double)var4.left;
      double var7 = (double)var4.top;
      double var9 = var3.getWidth() - (double)var4.left - (double)var4.right;
      double var11 = var3.getHeight() - (double)var4.top - (double)var4.bottom;
      Double var13 = new Double(var5 + 6.0D, var7 + var11 / 2.0D);
      Double var14 = new Double(var5 + var9 - 6.0D, var7 + var11 / 2.0D);
      java.awt.geom.Ellipse2D.Double var15 = new java.awt.geom.Ellipse2D.Double(var13.getX() - 5.0D, var13.getY() - 5.0D, 10.0D, 10.0D);
      java.awt.geom.Ellipse2D.Double var16 = new java.awt.geom.Ellipse2D.Double(var14.getX() - 6.0D, var14.getY() - 5.0D, 10.0D, 10.0D);
      var2.draw(var15);
      var2.fill(var15);
      var2.draw(var16);
      var2.fill(var16);
      java.awt.geom.Line2D.Double var17 = new java.awt.geom.Line2D.Double(var13, var14);
      if(this.stroke != null) {
         var2.setStroke(this.stroke);
      } else {
         var2.setStroke(new BasicStroke(0.0F));
      }

      var2.draw(var17);
   }

   public Component getListCellRendererComponent(JList var1, Object var2, int var3, boolean var4, boolean var5) {
      if(var2 instanceof StrokeSample) {
         StrokeSample var6 = (StrokeSample)var2;
         this.setStroke(var6.getStroke());
      }

      return this;
   }
}
