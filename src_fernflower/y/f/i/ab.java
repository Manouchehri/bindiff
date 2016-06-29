package y.f.i;

import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import y.f.i.v;

public class ab extends y.f.a {
   private int a = 200;

   public ab(y.f.ah var1) {
      this.a(var1);
   }

   public void c(y.f.X var1) {
      int var13 = v.f;
      v var2 = this.c();
      if(var2 == null) {
         throw new IllegalStateException("No OrthogonalEdgeRouter in coreLayouter");
      } else if(!this.a(var1, var2)) {
         this.a().c(var1);
      } else {
         y.c.y var3;
         label102: {
            var3 = new y.c.y();
            y.c.c var4;
            if(var2.p() == 4) {
               var4 = var1.c(var2.b());
               if(var4 == null) {
                  break label102;
               }

               y.c.x var5 = var1.o();

               label99:
               do {
                  if(!var5.f()) {
                     break label102;
                  }

                  if(var4.d(var5.e())) {
                     var3.add(var5.e());
                     y.c.x var6 = var5.e().m();

                     while(var6.f()) {
                        var3.add(var6.e());
                        var6.g();
                        if(var13 != 0) {
                           continue label99;
                        }

                        if(var13 != 0) {
                           break;
                        }
                     }
                  }

                  var5.g();
               } while(var13 == 0);
            }

            if(var2.p() == 2) {
               var4 = var1.c(var2.c());
               if(var4 != null) {
                  y.c.e var15 = var1.p();

                  while(var15.f()) {
                     if(var4.d(var15.a())) {
                        var3.add(var15.a().c());
                        var3.add(var15.a().d());
                     }

                     var15.g();
                     if(var13 != 0) {
                        break;
                     }
                  }
               }
            }
         }

         Rectangle2D var14 = y.f.ae.a(var1, var3.a());
         double var16 = (double)Math.max(5 * var2.t(), 50);
         var14.setFrame(var14.getX() - var16, var14.getY() - var16, var14.getWidth() + 2.0D * var16, var14.getHeight() + 2.0D * var16);
         y.g.I var7 = new y.g.I(var1);
         HashSet var8 = new HashSet();
         y.c.e var9 = var1.p();

         y.f.X var10000;
         while(true) {
            if(var9.f()) {
               y.c.d var10 = var9.a();
               var10000 = var1;
               if(var13 != 0) {
                  break;
               }

               label63: {
                  if(y.f.ae.a(var1, var10, var14)) {
                     var8.add(var10.c());
                     var8.add(var10.d());
                     if(var13 == 0) {
                        break label63;
                     }
                  }

                  var7.a(var10);
               }

               var9.g();
               if(var13 == 0) {
                  continue;
               }
            }

            var10000 = var1;
            break;
         }

         y.c.x var17 = var10000.o();

         y.c.q var19;
         while(true) {
            if(var17.f()) {
               var19 = var17.e();
               var10000 = var1;
               if(var13 != 0) {
                  break;
               }

               y.f.am var11 = var1.h(var19);
               if(!var14.intersects(var11.getX(), var11.getY(), var11.getWidth(), var11.getHeight()) && !var8.contains(var19)) {
                  var7.a(var19);
               }

               var17.g();
               if(var13 == 0) {
                  continue;
               }
            }

            var10000 = var1;
            break;
         }

         y.c.q var18 = var10000.d();
         var1.b(var18, 10.0D, 20.0D + var14.getHeight());
         var1.c(var18, var14.getX() - 10.0D, var14.getY() - 10.0D);
         var19 = var1.d();
         var1.b(var19, 10.0D, 20.0D + var14.getHeight());
         var1.c(var19, var14.getX() + var14.getWidth(), var14.getY() - 10.0D);
         y.c.q var20 = var1.d();
         var1.b(var20, 20.0D + var14.getWidth(), 10.0D);
         var1.c(var20, var14.getX() - 10.0D, var14.getY() - 10.0D);
         y.c.q var12 = var1.d();
         var1.b(var12, 20.0D + var14.getWidth(), 10.0D);
         var1.c(var12, var14.getX() - 10.0D, var14.getY() + var14.getHeight());
         this.a().c(var1);
         var1.a((y.c.q)var18);
         var1.a((y.c.q)var19);
         var1.a((y.c.q)var20);
         var1.a((y.c.q)var12);
         var7.f();
      }
   }

   public int b() {
      return this.a;
   }

   v c() {
      int var2 = v.f;
      y.f.ah var1 = this.a();

      while(var1 instanceof y.f.ad) {
         if(var1 instanceof v) {
            return (v)var1;
         }

         var1 = ((y.f.ad)var1).a();
         if(var2 != 0) {
            break;
         }
      }

      return null;
   }

   boolean a(y.f.X var1, v var2) {
      return var2.p() == 0?false:var1.e() + var1.g() >= this.b();
   }
}
