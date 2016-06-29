package y.h;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D.Double;
import java.awt.print.Paper;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import y.h.fQ;
import y.h.fY;
import y.h.fZ;
import y.h.fj;

final class gb extends JPanel implements Scrollable {
   private int a;
   private int b;
   private int c;
   private int d;
   private double e;
   private int f;
   private double g;
   private double h;
   private double i;
   private boolean j;
   private final fQ k;

   gb(fQ var1, int var2, int var3, int var4, int var5) {
      this.k = var1;
      this.b = 1;
      this.d = 10;
      this.g = 10.0D;
      this.h = 5.0D;
      this.a(var2);
      this.c(var4);
      this.b(var3);
      this.i = (double)Toolkit.getDefaultToolkit().getScreenResolution() / 72.0D;
      this.setMinimumSize(new Dimension((int)Math.rint((double)(var3 * 2) * this.g + 5.0D), (int)Math.rint((double)(this.c * 2) * this.g + 5.0D)));
      this.e(var5);
   }

   public void a(int var1) {
      if(var1 < 0) {
         throw new IllegalArgumentException("page must be non-negative");
      } else {
         this.a = var1;
      }
   }

   public void b(int var1) {
      boolean var2 = fj.z;
      if(var1 <= 0) {
         throw new IllegalArgumentException("columns must be greater 0");
      } else {
         this.b = var1;
         this.c = 1;

         while(this.c * this.b < this.d) {
            ++this.c;
            if(var2) {
               break;
            }
         }

      }
   }

   public void c(int var1) {
      boolean var2 = fj.z;
      if(var1 < 0) {
         throw new IllegalArgumentException("pages must be non-negative");
      } else {
         this.d = var1;
         this.c = 1;

         while(this.c * this.b < this.d) {
            ++this.c;
            if(var2) {
               break;
            }
         }

      }
   }

   public int d(int var1) {
      double var2 = ((double)var1 - (double)(this.b * 2) * this.g) / ((double)this.b * fQ.access$300(this.k).getWidth() * this.i);
      var2 = Math.max(0.05D, var2);
      return (int)Math.rint(Math.floor(var2 * 1000.0D));
   }

   public int a(int var1, int var2) {
      double var3 = ((double)var1 - (double)(this.b * 2) * this.g) / ((double)this.b * fQ.access$300(this.k).getWidth() * this.i);
      this.e = Math.max(0.05D, this.e);
      double var5 = ((double)var2 - (double)(this.c * 2) * this.g) / ((double)this.c * fQ.access$300(this.k).getHeight() * this.i);
      double var7 = Math.min(var3, var5);
      return (int)Math.rint(Math.floor(var7 * 1000.0D));
   }

   public synchronized void e(int var1) {
      if(!this.j) {
         if(this.f != var1) {
            if(var1 < 50) {
               var1 = 50;
            }

            int var2 = this.f;
            this.f = var1;
            this.e = (double)var1 / 1000.0D;
            this.setPreferredSize(new Dimension((int)Math.rint((double)this.b * (2.0D * this.g + fQ.access$300(this.k).getWidth() * this.e * this.i)), (int)Math.rint((double)this.c * (2.0D * this.g + fQ.access$300(this.k).getHeight() * this.e * this.i))));
            this.revalidate();
            this.repaint();

            try {
               this.j = true;
               this.firePropertyChange("ZOOM", var2, var1);
            } finally {
               this.j = false;
            }
         }

      }
   }

   public void a() {
      int var1 = this.b();
      this.f = 0;
      this.e(var1);
   }

   public int b() {
      return this.f;
   }

   protected void paintComponent(Graphics var1) {
      boolean var28 = fj.z;
      super.paintComponent(var1);
      Graphics2D var2 = (Graphics2D)var1;
      Paper var3 = fQ.access$300(this.k).getPaper();
      double var4 = var3.getWidth();
      double var6 = var3.getHeight();
      if(fQ.access$300(this.k).getOrientation() != 1) {
         double var8 = var4;
         var4 = var6;
         var6 = var8;
      }

      Insets var32 = super.getInsets();
      double var9 = this.i * this.e;
      Double var11 = new Double(0.0D, 0.0D, 0.0D, 0.0D);
      double var12 = this.g;
      double var14 = this.g;
      int var16 = 0;

      do {
         int var10000 = var16;
         int var10001 = (int)Math.ceil((double)((float)this.d / (float)this.b));

         label56:
         while(true) {
            if(var10000 >= var10001) {
               return;
            }

            int var17 = 0;

            while(true) {
               if(var17 >= this.b) {
                  break label56;
               }

               var12 = (double)var32.left + this.g + (double)var17 * var4 * var9 + (double)(var17 * 2) * this.g;
               var14 = (double)var32.top + this.g + (double)var16 * var6 * var9 + (double)(var16 * 2) * this.g;
               var10000 = var17 + var16 * this.b;
               var10001 = this.d;
               if(var28) {
                  break;
               }

               if(var10000 >= var10001) {
                  break label56;
               }

               var11.width = var4 * var9;
               var11.height = var6 * var9;
               var11.x = var12 + this.h;
               var11.y = var14 + this.h;
               var2.setColor(this.getBackground().darker());
               var2.fill(var11);
               var11.x = var12;
               var11.y = var14;
               var2.setColor(Color.white);
               var2.fill(var11);
               var2.setColor(Color.black);
               var2.draw(var11);
               double var18 = var11.x;
               double var20 = var11.y;
               var11.setFrame(fQ.access$300(this.k).getImageableX() * var9 + var18, fQ.access$300(this.k).getImageableY() * var9 + var20, fQ.access$300(this.k).getImageableWidth() * var9, fQ.access$300(this.k).getImageableHeight() * var9);
               boolean var22 = true;

               int var30;
               try {
                  AffineTransform var23;
                  Shape var24;
                  label49: {
                     var23 = var2.getTransform();
                     var24 = var2.getClip();
                     var2.translate(var18, var20);
                     var2.scale(var9, var9);
                     Shape var25 = var2.getClip();
                     Double var26 = new Double(fQ.access$300(this.k).getImageableX(), fQ.access$300(this.k).getImageableY(), fQ.access$300(this.k).getImageableWidth(), fQ.access$300(this.k).getImageableHeight());
                     Rectangle var27 = new Rectangle(0, 0, (int)Math.ceil(var4), (int)Math.ceil(var6));
                     if(var25.intersects(var27)) {
                        var2.clip(var26);
                        var30 = fQ.access$800(this.k).print(var2, fQ.access$300(this.k), this.a + var17 + this.b * var16);
                        if(!var28) {
                           break label49;
                        }
                     }

                     var30 = 0;
                  }

                  var2.setTransform(var23);
                  var2.setClip(var24);
               } catch (Exception var29) {
                  var30 = 1;
                  var29.printStackTrace();
               }

               if(var30 == 1) {
                  var11.width = var4 * var9;
                  var11.height = var6 * var9;
                  var11.x = var12;
                  var11.y = var14;
                  var2.setColor(Color.lightGray);
                  var2.fill(var11);
                  var2.setColor(Color.red);
                  java.awt.geom.Line2D.Double var31 = new java.awt.geom.Line2D.Double(var11.x, var11.y, var11.x + var11.width, var11.y + var11.height);
                  var2.draw(var31);
                  var31.x1 = var31.x2;
                  var31.x2 = var11.x;
                  var2.draw(var31);
                  var2.setColor(Color.darkGray);
                  var2.draw(var11);
               } else {
                  var2.setColor(Color.lightGray);
                  var2.draw(var11);
               }

               ++var17;
               if(var28) {
                  break label56;
               }
            }
         }

         ++var16;
      } while(!var28);

   }

   public Action c() {
      return new fY(this, "+");
   }

   public Action d() {
      return new fZ(this, "-");
   }

   public Dimension getPreferredScrollableViewportSize() {
      return this.getPreferredSize();
   }

   public int getScrollableBlockIncrement(Rectangle var1, int var2, int var3) {
      return 10;
   }

   public boolean getScrollableTracksViewportHeight() {
      return false;
   }

   public boolean getScrollableTracksViewportWidth() {
      return false;
   }

   public int getScrollableUnitIncrement(Rectangle var1, int var2, int var3) {
      return 20;
   }
}
