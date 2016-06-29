package org.jfree.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.JPanel;
import org.jfree.ui.Drawable;
import org.jfree.ui.ExtendedDrawable;

public class DrawablePanel extends JPanel {
   private Drawable drawable;

   public DrawablePanel() {
      this.setOpaque(false);
   }

   public Drawable getDrawable() {
      return this.drawable;
   }

   public void setDrawable(Drawable var1) {
      this.drawable = var1;
      this.revalidate();
      this.repaint();
   }

   public Dimension getPreferredSize() {
      if(this.drawable instanceof ExtendedDrawable) {
         ExtendedDrawable var1 = (ExtendedDrawable)this.drawable;
         return var1.getPreferredSize();
      } else {
         return super.getPreferredSize();
      }
   }

   public Dimension getMinimumSize() {
      if(this.drawable instanceof ExtendedDrawable) {
         ExtendedDrawable var1 = (ExtendedDrawable)this.drawable;
         return var1.getPreferredSize();
      } else {
         return super.getMinimumSize();
      }
   }

   public boolean isOpaque() {
      return this.drawable == null?false:super.isOpaque();
   }

   protected void paintComponent(Graphics var1) {
      super.paintComponent(var1);
      if(this.drawable != null) {
         Graphics2D var2 = (Graphics2D)var1.create(0, 0, this.getWidth(), this.getHeight());
         this.drawable.draw(var2, new Double(0.0D, 0.0D, (double)this.getWidth(), (double)this.getHeight()));
         var2.dispose();
      }
   }
}
