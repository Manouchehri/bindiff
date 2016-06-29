package y.h;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import y.h.O;
import y.h.bw;
import y.h.cd;
import y.h.ch;
import y.h.fE;
import y.h.fF;
import y.h.fG;
import y.h.fH;
import y.h.fI;
import y.h.fj;
import y.h.gV;
import y.h.hF;

public class fD extends ch implements PropertyChangeListener {
   ch tc;
   fF wc;
   boolean xc;
   private Rectangle2D vc;
   private final fH uc = new fH(this);
   private static boolean yc = false;

   public fD(ch var1) {
      super(var1.getGraph2D(), (gV)null);
      this.addViewMode(new fG(this, this));
      this.getCanvasComponent().addKeyListener(new fE(this));
      new hF(this);
      cd var2 = this.getGraph2DRenderer();
      if(var2 instanceof O) {
         O var3 = (O)var2;
         var3.setDrawEdgesFirst(true);
         var3.setSloppyNestedEdgeDrawingOrderEnabled(true);
      }

      this.tc = var1;
      this.tc.r().addPropertyChangeListener(this);
      this.tc.addPropertyChangeListener(this);
      this.wc = new fF((fE)null);
      this.setScrollBarPolicy(21, 31);
      this.setPaintDetailThreshold(Double.MAX_VALUE);
   }

   bw u() {
      return new fI(this, this);
   }

   private static double c(double var0, double var2, double var4) {
      boolean var12 = fj.z;
      double var6 = 0.0D;
      double var8 = var4 - 0.5D;

      double var10000;
      while(true) {
         if(var8 < var4 + 0.6D) {
            var10000 = var2 - 0.5D;
            if(var12) {
               break;
            }

            double var10 = var10000;

            label27: {
               while(var10 < var2 + 0.6D) {
                  var6 += 1.0D / (6.283185307179586D * var0 * var0) * Math.pow(2.718281828459045D, -(var10 * var10 + var8 * var8) / (2.0D * var0 * var0));
                  var10 += 0.1D;
                  if(var12) {
                     break label27;
                  }

                  if(var12) {
                     break;
                  }
               }

               var8 += 0.1D;
            }

            if(!var12) {
               continue;
            }
         }

         var6 /= 121.0D;
         var10000 = var6;
         break;
      }

      return var10000;
   }

   private static float[] b(double var0, int var2) {
      boolean var8 = fj.z;
      float[] var3 = new float[var2 * var2];
      float var4 = 0.0F;
      int var5 = 0;

      byte var10000;
      while(true) {
         if(var5 < var2) {
            var10000 = 0;
            if(var8) {
               break;
            }

            int var6 = 0;

            label41: {
               while(var6 < var2) {
                  float var7 = (float)c(var0, (double)var6 - (double)var2 * 0.5D, (double)var5 - (double)var2 * 0.5D);
                  var3[var6 + var5 * var2] = var7;
                  var4 += var7;
                  ++var6;
                  if(var8) {
                     break label41;
                  }

                  if(var8) {
                     break;
                  }
               }

               ++var5;
            }

            if(!var8) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      var5 = var10000;

      float[] var9;
      while(true) {
         if(var5 < var3.length) {
            var9 = var3;
            if(var8) {
               break;
            }

            var3[var5] /= var4;
            ++var5;
            if(!var8) {
               continue;
            }
         }

         var9 = var3;
         break;
      }

      return var9;
   }

   protected void adjustWorldRect(ch var1) {
      Rectangle var2 = var1.getGraph2D().a();
      var1.setWorldRect(var2.x - 20, var2.y - 20, var2.width + 40, var2.height + 40);
   }

   public void updateView() {
      if(this.tc != null) {
         Rectangle var1 = this.tc.getVisibleRect();
         if(this.wc != null) {
            this.wc.a(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight());
         }

         this.xc = true;
         super.updateView();
      }
   }

   void c(int var1, int var2, int var3, int var4) {
      if(this.tc != null) {
         Rectangle var5 = this.tc.getVisibleRect();
         if(this.wc != null) {
            this.wc.a(var5.getX(), var5.getY(), var5.getWidth(), var5.getHeight());
         }

         this.xc = true;
         this.repaint(var1, var2, var3, var4);
      }
   }

   public void reshape(int var1, int var2, int var3, int var4) {
      super.reshape(var1, var2, var3, var4);
      this.updateView();
   }

   public void propertyChange(PropertyChangeEvent var1) {
      boolean var12 = fj.z;
      if("Graph2D".equals(var1.getPropertyName())) {
         this.setGraph2D(this.tc.getGraph2D());
         if(!var12) {
            return;
         }
      }

      boolean var2;
      Rectangle var3;
      Rectangle2D var4;
      int var8;
      int var9;
      int var10;
      int var11;
      if("Zoom".equals(var1.getPropertyName())) {
         label32: {
            var2 = this.xc;
            if(this.vc != null) {
               var3 = this.tc.getVisibleRect();
               var4 = var3.createUnion(this.vc);
               double var5 = Math.max(((Double)var1.getOldValue()).doubleValue(), ((Double)var1.getNewValue()).doubleValue());
               Point var7 = this.getViewPoint();
               var8 = (int)Math.floor((var4.getX() - var7.getX()) * var5);
               var9 = (int)Math.floor((var4.getY() - var7.getY()) * var5);
               var10 = (int)Math.ceil(var4.getWidth() * var5);
               var11 = (int)Math.ceil(var4.getHeight() * var5);
               this.c(var8 - 1, var9 - 1, var10 + 4, var11 + 4);
               this.vc = var3;
               if(!var12) {
                  break label32;
               }
            }

            this.updateView();
            this.vc = this.tc.getVisibleRect();
         }

         this.xc = var2;
         if(!var12) {
            return;
         }
      }

      if("ViewPoint".equals(var1.getPropertyName())) {
         label23: {
            var2 = this.xc;
            if(this.vc != null) {
               var3 = this.tc.getVisibleRect();
               var4 = var3.createUnion(this.vc);
               Point var13 = this.getViewPoint();
               double var6 = this.getZoom();
               var8 = (int)Math.floor((var4.getX() - var13.getX()) * var6);
               var9 = (int)Math.floor((var4.getY() - var13.getY()) * var6);
               var10 = (int)Math.ceil(var4.getWidth() * var6);
               var11 = (int)Math.ceil(var4.getHeight() * var6);
               this.c(var8 - 1, var9 - 1, var10 + 4, var11 + 4);
               this.vc = var3;
               if(!var12) {
                  break label23;
               }
            }

            this.updateView();
            this.vc = this.tc.getVisibleRect();
         }

         this.xc = var2;
         if(!var12) {
            return;
         }
      }

      this.updateView();
   }

   void b(double var1, double var3, double var5) {
      if(var5 < 1.0D && Boolean.TRUE.equals(this.getClientProperty("Overview.AnimateScrollTo"))) {
         this.uc.a(var1, var3, var5);
         if(!fj.z) {
            return;
         }
      }

      this.tc.setCenter(var1, var3);
      this.tc.updateView();
   }

   static float[] access$100(double var0, int var2) {
      return b(var0, var2);
   }

   static boolean access$200() {
      return yc;
   }

   static {
      try {
         String var0 = System.getProperty("os.name").toLowerCase();
         yc = var0.startsWith("mac");
      } catch (SecurityException var1) {
         yc = false;
      }

   }
}
