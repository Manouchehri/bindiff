package y.f.g;

import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;
import y.f.X;
import y.f.ae;
import y.f.g.b;
import y.f.g.d;
import y.f.g.u;

class z {
   public SortedSet a(X var1, y.c.y var2, y.c.y var3, b var4, y.d.t var5, boolean var6) {
      boolean var33 = d.d;
      TreeSet var7 = new TreeSet(u.a);
      y.f.b.c var8 = new y.f.b.c(var1);
      Rectangle2D var9 = ae.a(var1, var3.a());
      Rectangle2D var10 = ae.a(var1, var2.a());
      HashSet var11 = new HashSet();
      HashSet var12 = new HashSet();
      double var13 = var10.getMinX() - (double)var1.f() * var9.getWidth();
      double var15 = var10.getMaxX() + (double)var1.f() * var9.getWidth();
      double var17 = var10.getMinY() - (double)var1.f() * var9.getHeight();
      double var19 = var10.getMaxY() + (double)var1.f() * var9.getHeight();
      boolean var21 = false;
      y.c.x var22 = var3.a();

      label64:
      while(true) {
         boolean var10000 = var22.f();

         label61:
         while(var10000) {
            y.c.q var23 = var22.e();
            if(var33) {
               return var7;
            }

            y.c.x var24 = var2.a();

            while(var24.f()) {
               y.c.q var25 = var24.e();
               double var26 = var1.k(var25) - var1.k(var23);
               var10000 = var11.add(new Double(var26));
               if(var33) {
                  continue label61;
               }

               double var28;
               if(var10000) {
                  var28 = var9.getCenterY() + var26;
                  if(var28 >= var4.d() && var28 <= var4.d() + var4.b()) {
                     int var30;
                     label51: {
                        if(var6) {
                           var30 = (int)Math.abs(var1.k(var25) - var5.b());
                           if(!var33) {
                              break label51;
                           }
                        }

                        var30 = (int)y.d.t.a(var1.l(var25), var5);
                     }

                     var21 = true;
                     var7.add(new u(new y.d.t(var13, var28), new y.d.t(var15, var28), var30));
                  }
               }

               var28 = var1.j(var25) - var1.j(var23);
               if(var12.add(new Double(var28))) {
                  double var36 = var9.getCenterX() + var28;
                  if(var36 >= var4.c() && var36 <= var4.c() + var4.a()) {
                     int var32 = (int)y.d.t.a(var1.l(var25), var5);
                     var7.add(new u(new y.d.t(var36, var17), new y.d.t(var36, var19), var32));
                  }
               }

               var24.g();
               if(var33) {
                  break;
               }
            }

            var22.g();
            if(!var33) {
               continue label64;
            }
            break;
         }

         if(!var21 && var6) {
            double var34 = var4.f().b();
            int var35 = (int)Math.abs(var34 - var5.b());
            var7.add(new u(new y.d.t(var13, var34), new y.d.t(var15, var34), var35));
         }

         var8.c();
         return var7;
      }
   }
}
