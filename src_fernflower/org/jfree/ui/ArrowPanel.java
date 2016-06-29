package org.jfree.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import javax.swing.JPanel;

public class ArrowPanel extends JPanel {
   public static final int UP = 0;
   public static final int DOWN = 1;
   private int type = 0;
   private Rectangle2D available = new Float();

   public ArrowPanel(int var1) {
      this.type = var1;
      this.setPreferredSize(new Dimension(14, 9));
   }

   public void paintComponent(Graphics var1) {
      super.paintComponent(var1);
      Graphics2D var2 = (Graphics2D)var1;
      Dimension var3 = this.getSize();
      Insets var4 = this.getInsets();
      this.available.setRect((double)var4.left, (double)var4.top, var3.getWidth() - (double)var4.left - (double)var4.right, var3.getHeight() - (double)var4.top - (double)var4.bottom);
      var2.translate(var4.left, var4.top);
      var2.fill(this.getArrow(this.type));
   }

   private Shape getArrow(int var1) {
      switch(var1) {
      case 0:
         return this.getUpArrow();
      case 1:
         return this.getDownArrow();
      default:
         return this.getUpArrow();
      }
   }

   private Shape getUpArrow() {
      Polygon var1 = new Polygon();
      var1.addPoint(7, 2);
      var1.addPoint(2, 7);
      var1.addPoint(12, 7);
      return var1;
   }

   private Shape getDownArrow() {
      Polygon var1 = new Polygon();
      var1.addPoint(7, 7);
      var1.addPoint(2, 2);
      var1.addPoint(12, 2);
      return var1;
   }
}
