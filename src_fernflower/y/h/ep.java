package y.h;

import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.List;
import y.h.az;
import y.h.ch;
import y.h.e;
import y.h.eb;
import y.h.ew;
import y.h.fj;
import y.h.gz;

class ep extends gz {
   private ch a;
   private double c;
   private y.d.t d;
   private List e;
   private List f;

   public ep(double var1, ch var3, double var4, y.d.t var6, List var7) {
      super(var1);
      if(var7.isEmpty()) {
         throw new IllegalArgumentException("movingObjects is empty.");
      } else {
         this.a = var3;
         this.c = var4;
         this.d = var6;
         this.e = var7;
         this.f = new ArrayList();
      }
   }

   public byte a(y.d.t var1, Double var2, byte var3) {
      double var4 = var2.x - this.d.a;
      double var6 = var2.y - this.d.b;
      y.d.z var8 = this.a(var4, var6);
      double var9 = Math.abs(var8.a());
      double var11 = Math.abs(var8.b());
      double var13 = this.c / this.a.getZoom();
      if(Math.max(var9, var11) < var13) {
         var2.x += var8.a();
         var2.y += var8.b();
         return (byte)3;
      } else if(var9 < var13) {
         var2.x += var8.a();
         return (byte)1;
      } else if(var11 < var13) {
         var2.y += var8.b();
         return (byte)2;
      } else {
         return (byte)0;
      }
   }

   private y.d.z a(double var1, double var3) {
      boolean var19 = fj.z;
      ew var5 = null;
      ew var6 = null;
      double var7 = java.lang.Double.MAX_VALUE;
      double var9 = java.lang.Double.MAX_VALUE;
      double var11 = this.a.getGridResolution();
      int var13 = 0;

      while(true) {
         if(var13 < this.e.size()) {
            ew var14 = (ew)this.e.get(var13);
            double var15 = var14.c(var11, var1, var3);
            if(var19) {
               break;
            }

            label39: {
               if(var15 < var7) {
                  var9 = var7;
                  var7 = var15;
                  var6 = var5;
                  var5 = var14;
                  if(!var19) {
                     break label39;
                  }
               }

               if(var15 < var9) {
                  var9 = var15;
                  var6 = var14;
               }
            }

            ++var13;
            if(!var19) {
               continue;
            }
         }

         if(var5 == null) {
            return new y.d.z(java.lang.Double.MAX_VALUE, java.lang.Double.MAX_VALUE);
         }
         break;
      }

      y.d.z var20 = var5.a(var11, var1, var3);
      if(var6 == null) {
         return var20;
      } else {
         double var21 = var20.a();
         double var16 = var20.b();
         y.d.z var18 = var5.a(var11, var1, var3);
         if(var18.a() < java.lang.Double.MAX_VALUE && var5.b()) {
            var21 = var18.a();
         }

         if(var18.b() < java.lang.Double.MAX_VALUE && var5.a()) {
            var16 = var18.b();
         }

         return new y.d.z(var21, var16);
      }
   }

   public boolean a(y.d.t var1, y.d.t var2, byte var3) {
      boolean var14 = fj.z;
      this.f.clear();
      double var4 = var2.a - this.d.a;
      double var6 = var2.b - this.d.b;
      double var8 = this.a.getGridResolution();
      int var10 = 0;

      int var10000;
      while(true) {
         if(var10 < this.e.size()) {
            ew var11 = (ew)this.e.get(var10);
            double var12 = var11.b(var8, var4, var6);
            double var15;
            var10000 = (var15 = var12 - 0.0D) == 0.0D?0:(var15 < 0.0D?-1:1);
            if(var14) {
               break;
            }

            if(var10000 == 0) {
               this.f.add(var11);
            }

            ++var10;
            if(!var14) {
               continue;
            }
         }

         var10000 = this.f.isEmpty();
         break;
      }

      return var10000 == 0;
   }

   public az a(e var1, y.d.t var2) {
      return new eb(this, var2);
   }

   static List a(ep var0) {
      return var0.f;
   }

   static y.d.t b(ep var0) {
      return var0.d;
   }
}
