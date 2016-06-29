package y.h;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.List;
import y.h.aB;
import y.h.az;
import y.h.ch;
import y.h.fj;
import y.h.im;

public class cU implements y.b.c {
   private im a;
   private List b;
   private List c;
   private Double d;
   private boolean e;
   private final ch f;

   public void animationPerformed(y.b.a var1) {
      boolean var5 = fj.z;
      switch(var1.a()) {
      case 0:
         Object var2 = var1.getSource();
         boolean var3 = var2 instanceof y.b.e && ((y.b.e)var2).b() && ((y.b.e)var2).a();
         boolean var4 = this.f.r().B();
         if(var3) {
            this.f.r().f(true);
         }

         this.b();
         if(!var3) {
            return;
         }

         this.f.r().f(var4);
         if(!var5) {
            return;
         }
      case 3:
         this.a();
         if(!var5) {
            return;
         }
         break;
      case 1:
      case 2:
      default:
         return;
      case 4:
      }

      this.a();
   }

   public void a() {
      this.d = null;
   }

   public void b() {
      if(this.e) {
         this.f.updateView();
         this.a();
      } else {
         if(this.d == null) {
            this.c();
            this.f.updateView();
            if(!fj.z) {
               return;
            }
         }

         Double var1 = this.c();
         if(var1.width > 0.0D && var1.height > 0.0D) {
            this.f.updateView(var1.x, var1.y, var1.width, var1.height);
         }

      }
   }

   private Double c() {
      boolean var11 = fj.z;
      double var1 = this.f.toWorldCoordX(0);
      double var3 = this.f.toWorldCoordY(0);
      Double var5 = new Double(var1, var3, this.f.toWorldCoordX(this.f.getWidth()) - var1, this.f.toWorldCoordY(this.f.getHeight()) - var3);
      Double var6 = new Double();
      Double var7 = new Double();
      var7.setRect(0.0D, 0.0D, -1.0D, -1.0D);
      y.c.C var8 = this.a.m();

      byte var10000;
      while(true) {
         if(var8.f()) {
            var6.setRect(0.0D, 0.0D, -1.0D, -1.0D);
            this.a((az)((az)var8.d()), var6);
            var10000 = var5.intersects(var6);
            if(var11) {
               break;
            }

            if(var10000 != 0) {
               y.d.e.a((Rectangle2D)var7, (Rectangle2D)var6, (Rectangle2D)var7);
            }

            var8.g();
            if(!var11) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      int var12 = var10000;
      int var9 = this.b.size();

      int var14;
      while(true) {
         if(var12 < var9) {
            fj var10 = (fj)this.b.get(var12);
            var6.setRect(0.0D, 0.0D, -1.0D, -1.0D);
            this.a((fj)var10, var6);
            var14 = var5.intersects(var6);
            if(var11) {
               break;
            }

            if(var14 != 0) {
               y.d.e.a((Rectangle2D)var7, (Rectangle2D)var6, (Rectangle2D)var7);
            }

            ++var12;
            if(!var11) {
               continue;
            }
         }

         var12 = 0;
         var14 = this.c.size();
         break;
      }

      var9 = var14;

      while(true) {
         if(var12 < var9) {
            aB var13 = (aB)this.c.get(var12);
            var6.setRect(0.0D, 0.0D, -1.0D, -1.0D);
            this.a((aB)var13, var6);
            var14 = var5.intersects(var6);
            if(var11) {
               break;
            }

            if(var14 != 0) {
               y.d.e.a((Rectangle2D)var7, (Rectangle2D)var6, (Rectangle2D)var7);
            }

            ++var12;
            if(!var11) {
               continue;
            }
         }

         if(this.d == null) {
            this.d = var5;
         }

         y.d.e.a((Rectangle2D)this.d, (Rectangle2D)var7, (Rectangle2D)var6);
         y.d.e.b((Rectangle2D)var5, (Rectangle2D)var6, (Rectangle2D)var6);
         double var15;
         var14 = (var15 = var6.width - 0.0D) == 0.0D?0:(var15 < 0.0D?-1:1);
         break;
      }

      if(var14 >= 0 && var6.height >= 0.0D) {
         var6.x -= 10.0D;
         var6.y -= 10.0D;
         var6.width += 20.0D;
         var6.height += 20.0D;
      }

      this.d = var7;
      return var6;
   }

   protected void a(az var1, Rectangle2D var2) {
      y.d.e.a((Rectangle2D)var1.getBounds(), (Rectangle2D)var2, (Rectangle2D)var2);
   }

   protected void a(aB var1, Rectangle2D var2) {
      var1.calcUnionRect(var2);
   }

   protected void a(fj var1, Rectangle2D var2) {
      var1.calcUnionRect(var2);
   }
}
