package y.f.i;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import y.f.i.aa;
import y.f.i.v;

public class X extends y.f.a {
   private int a = 1000;

   public X(y.f.ah var1) {
      this.a(var1);
   }

   public int b() {
      return this.a;
   }

   public void c(y.f.X var1) {
      int var24 = v.f;
      v var2 = this.c();
      if(var2 == null) {
         throw new IllegalStateException("No OrthogonalEdgeRouter in coreLayouter");
      } else if(!this.a(var1, var2)) {
         this.a().c(var1);
      } else {
         y.c.A var3 = var1.t();
         int var4 = Integer.MAX_VALUE;
         int var5 = Math.min(this.b() / 4, 200);
         int var6 = var5;
         int var7 = var5;

         Set var10000;
         while(true) {
            if(var7 <= Math.max(var5, 2000)) {
               int var8 = this.a(var1, var3, var7);
               int var9 = var1.e() / var8;
               Set var10 = this.a(var1, (y.c.c)var3);
               var10000 = var10;
               if(var24 != 0) {
                  break;
               }

               if(var10 != null && var10.size() < var4 && var9 < var4) {
                  var4 = var10.size();
                  var6 = var7;
               }

               var7 = (int)((double)var7 * 2.0D);
               if(var24 == 0) {
                  continue;
               }
            }

            var7 = this.a(var1, var3, var6);
            var10000 = this.a(var1, (y.c.c)var3);
            break;
         }

         Set var25 = var10000;
         y.c.A var26 = var1.t();
         y.c.h var27 = var1.u();
         y.c.f var11 = new y.c.f();
         new y.c.y();
         y.c.e var13 = var1.p();

         while(var13.f()) {
            y.c.d var14 = var13.a();
            if(var3.a(var14.c()) != var3.a(var14.d())) {
               var27.a(var14, true);
               var11.add(var14);
               var26.a(var14.c(), true);
               var26.a(var14.d(), true);
            }

            var13.g();
            if(var24 != 0) {
               break;
            }
         }

         y.g.I var28 = new y.g.I(var1);
         y.c.e var29 = var1.p();

         while(var29.f()) {
            if(!var27.d(var29.a())) {
               var28.a(var29.a());
            }

            var29.g();
            if(var24 != 0) {
               break;
            }
         }

         y.g.I var30 = new y.g.I(var1);
         y.c.x var15 = var1.o();

         while(var15.f()) {
            if(!var26.d(var15.e())) {
               var30.a(var15.e());
            }

            var15.g();
            if(var24 != 0) {
               break;
            }
         }

         Iterator var16;
         ArrayList var31;
         label99: {
            var31 = null;
            if(var25 != null) {
               var31 = new ArrayList(var25.size());
               var16 = var25.iterator();

               while(var16.hasNext()) {
                  Rectangle2D var17 = (Rectangle2D)var16.next();
                  y.c.q var18 = var1.d();
                  var31.add(var18);
                  var1.b(var18, var17.getWidth(), var17.getHeight());
                  var1.c(var18, var17.getX(), var17.getY());
                  if(var24 != 0) {
                     break label99;
                  }

                  if(var24 != 0) {
                     break;
                  }
               }
            }

            this.a().c(var1);
         }

         label87: {
            if(var31 != null) {
               var16 = var31.iterator();

               while(var16.hasNext()) {
                  var1.a((y.c.q)((y.c.q)var16.next()));
                  if(var24 != 0) {
                     break label87;
                  }

                  if(var24 != 0) {
                     break;
                  }
               }
            }

            var30.f();
            var28.f();
         }

         byte var32 = var2.p();
         Object var33 = var2.c();
         y.c.c var34 = var1.c(var33);
         var2.b((byte)2);
         var1.a((Object)var33, (y.c.c)y.g.q.a((y.c.c)var27));
         y.g.J var19 = new y.g.J(var1, var3);
         var19.a();
         y.c.y var20 = new y.c.y();
         y.c.f var21 = new y.c.f();
         int var22 = 0;

         while(true) {
            if(var22 < var7) {
               Integer var23 = new Integer(var22);
               var19.b((Object)var23);
               this.a(var21, var20, var11, var1);
               this.a().c(var1);
               this.a(var21, var20, var1);
               var19.a((Object)var23);
               ++var22;
               if(var24 != 0) {
                  break;
               }

               if(var24 == 0) {
                  continue;
               }
            }

            var19.b();
            break;
         }

         label66: {
            if(var34 != null) {
               var1.a((Object)var33, (y.c.c)var34);
               if(var24 == 0) {
                  break label66;
               }
            }

            var1.d_(var33);
         }

         var2.b(var32);
         var1.a((y.c.h)var27);
         var1.a((y.c.A)var26);
         var1.a((y.c.A)var3);
      }
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

   void a(y.c.f var1, y.c.y var2, y.f.X var3) {
      int var4 = v.f;

      while(true) {
         if(!var1.isEmpty()) {
            var3.d(var1.d());
            if(var4 != 0) {
               return;
            }

            if(var4 == 0) {
               continue;
            }
         }

         do {
            if(var2.isEmpty()) {
               return;
            }

            var3.c(var2.d());
         } while(var4 == 0);

         return;
      }
   }

   void a(y.c.f var1, y.c.y var2, y.c.f var3, y.f.X var4) {
      int var12 = v.f;
      Double var5 = new Double();
      var1.clear();
      var2.clear();
      Rectangle2D var6 = y.f.ae.a(var4, var4.o());
      var6.setFrame(var6.getX() - 10.0D, var6.getY() - 10.0D, var6.getWidth() + 20.0D, var6.getHeight() + 20.0D);
      y.c.e var7 = var3.a();

      do {
         boolean var10000 = var7.f();

         y.c.d var8;
         label50:
         while(true) {
            if(!var10000) {
               return;
            }

            var8 = var7.a();
            y.c.D var9 = var4.m(var8);
            y.c.C var10 = var9.m();

            while(true) {
               if(!var10.f()) {
                  break label50;
               }

               y.d.t var11 = (y.d.t)var10.d();
               var10000 = var6.contains(var11.a, var11.b);
               if(var12 != 0) {
                  break;
               }

               if(var10000) {
                  var1.add(var8);
                  if(var8.c().e() == null) {
                     var4.d(var8.c());
                     var2.add(var8.c());
                  }

                  if(var8.d().e() == null) {
                     var4.d(var8.d());
                     var2.add(var8.d());
                  }

                  var4.e(var8);
                  if(var12 == 0) {
                     break label50;
                  }
               }

               var10.g();
               if(var12 != 0) {
                  break label50;
               }
            }
         }

         y.f.am var13 = var4.h(var8.c());
         var5.setFrame(var13.getX(), var13.getY(), var13.getWidth(), var13.getHeight());
         if(var8.c().e() == null && var6.intersects(var5)) {
            var4.d(var8.c());
            var2.add(var8.c());
         }

         y.f.am var14 = var4.h(var8.d());
         var5.setFrame(var14.getX(), var14.getY(), var14.getWidth(), var14.getHeight());
         if(var8.d().e() == null && var6.intersects(var5)) {
            var4.d(var8.d());
            var2.add(var8.d());
         }

         var7.g();
      } while(var12 == 0);

   }

   int a(y.f.X var1, y.c.A var2, int var3) {
      y.c.q[] var4 = var1.m();
      aa var5 = new aa(var1, true);
      aa var6 = new aa(var1, false);
      return this.a(var2, var3, var4, 0, var4.length, var5, var6, true, 0);
   }

   int a(y.c.A var1, int var2, y.c.q[] var3, int var4, int var5, Comparator var6, Comparator var7, boolean var8, int var9) {
      int var12 = v.f;
      int var10 = var5 - var4 - 1;
      if(var10 < var2) {
         int var11 = var4;

         label38: {
            while(var11 < var5) {
               var1.a(var3[var11], var9);
               ++var11;
               if(var12 != 0) {
                  break label38;
               }

               if(var12 != 0) {
                  break;
               }
            }

            ++var9;
         }

         if(var12 == 0) {
            return var9;
         }
      }

      Comparator var13 = var8?var6:var7;
      y.g.e.a(var3, var4, var5, var13);
      var9 = this.a(var1, var2, var3, var4, var4 + var10 / 2, var6, var7, !var8, var9);
      var9 = this.a(var1, var2, var3, var4 + var10 / 2, var5, var6, var7, !var8, var9);
      return var9;
   }

   double b(y.f.X var1) {
      int var5 = v.f;
      double var2 = 0.0D;
      if(var1.i()) {
         return 0.0D;
      } else {
         y.c.x var4 = var1.o();

         double var10000;
         while(true) {
            if(var4.f()) {
               var2 += var1.p(var4.e());
               var10000 = var2 + var1.q(var4.e());
               if(var5 != 0) {
                  break;
               }

               var2 = var10000;
               var4.g();
               if(var5 == 0) {
                  continue;
               }
            }

            var10000 = var2 / (2.0D * (double)var1.e());
            break;
         }

         return var10000;
      }
   }

   Set a(y.f.X var1, y.c.c var2) {
      int var13 = v.f;
      double var3 = this.b(var1);
      y.c.A var5 = y.g.M.a(new boolean[var1.e()]);
      y.c.e var6 = var1.p();

      while(var6.f()) {
         y.c.d var7 = var6.a();
         if(var2.a(var7.c()) != var2.a(var7.d())) {
            var5.a(var7.c(), true);
            var5.a(var7.d(), true);
         }

         var6.g();
         if(var13 != 0) {
            break;
         }
      }

      Set var14 = this.a(var1, var5, var3);
      if(var14 == null) {
         return null;
      } else {
         double var15 = var3;
         double var9 = (double)var14.size();
         double var11 = var3 / 2.0D;

         Set var10000;
         while(true) {
            if(var11 > 10.0D) {
               var14 = this.a(var1, var5, var11);
               var10000 = var14;
               if(var13 != 0) {
                  break;
               }

               if(var14 != null && (double)var14.size() < var9) {
                  var9 = (double)var14.size();
                  var15 = var11;
               }

               var11 /= 2.0D;
               if(var13 == 0) {
                  continue;
               }
            }

            var11 = var3 * 2.0D;

            while(var11 < 1000.0D) {
               var14 = this.a(var1, var5, var11);
               var10000 = var14;
               if(var13 != 0) {
                  return var10000;
               }

               if(var14 != null && (double)var14.size() < var9) {
                  var9 = (double)var14.size();
                  var15 = var11;
               }

               var11 *= 2.0D;
               if(var13 != 0) {
                  break;
               }
            }

            var10000 = this.a(var1, var5, var15);
            break;
         }

         return var10000;
      }
   }

   Set a(y.f.X param1, y.c.c param2, double param3) {
      // $FF: Couldn't be decompiled
   }

   boolean a(y.f.X var1, v var2) {
      return var2.p() != 0?false:var1.e() + var1.g() >= this.b();
   }
}
