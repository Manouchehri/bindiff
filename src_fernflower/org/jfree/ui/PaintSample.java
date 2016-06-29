package org.jfree.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.JComponent;

public class PaintSample extends JComponent {
   private Paint paint;
   private Dimension preferredSize;

   public PaintSample(Paint var1) {
      this.paint = var1;
      this.preferredSize = new Dimension(80, 12);
   }

   public Paint getPaint() {
      return this.paint;
   }

   public void setPaint(Paint var1) {
      this.paint = var1;
      this.repaint();
   }

   public Dimension getPreferredSize() {
      return this.preferredSize;
   }

   public void paintComponent(Graphics var1) {
      Graphics2D var2 = (Graphics2D)var1;
      Dimension var3 = this.getSize();
      Insets var4 = this.getInsets();
      double var5 = (double)var4.left;
      double var7 = (double)var4.top;
      double var9 = var3.getWidth() - (double)var4.left - (double)var4.right - 1.0D;
      double var11 = var3.getHeight() - (double)var4.top - (double)var4.bottom - 1.0D;
      Double var13 = new Double(var5, var7, var9, var11);
      var2.setPaint(this.paint);
      var2.fill(var13);
      var2.setPaint(Color.black);
      var2.draw(var13);
   }
}
