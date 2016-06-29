package y.f.i.a;

import java.util.Iterator;
import java.util.List;
import y.f.i.a.H;
import y.f.i.a.I;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.U;
import y.f.i.a.V;
import y.f.i.a.Z;
import y.f.i.a.aU;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.ac;
import y.f.i.a.bl;
import y.f.i.a.f;
import y.f.i.a.v;
import y.f.i.a.w;

class bi extends ab implements H {
   private aU b;
   private List c;
   private List d;
   private List e;
   private int f;
   private boolean g;
   private boolean h;

   protected void a(Z var1) {
      super.a(var1);
      var1.a().a((Object)bl.a, (y.c.c)y.g.M.a());
   }

   protected void c() {
      this.a().a().d_(bl.a);
      super.c();
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = null;
   }

   protected void b(aa var1) {
      super.b(var1);
      y.c.d var2 = var1.c();
      y.f.X var3 = this.a().a();
      this.f = var1.d().f().o();
      if(this.f <= 0) {
         this.h = false;
      } else {
         this.b = this.a().a(var2);
         this.c = this.b.a(true);
         this.d = this.b.a(false);
         this.h = this.c != null && this.c.size() > 0 || this.d != null && this.d.size() > 0;
         if(this.h) {
            List var4 = this.b.b(true);
            if(var4.size() > 0) {
               this.a(var3, var2, var4, true);
            }

            this.e = this.b.b(false);
            if(this.e.size() > 0) {
               this.a(var3, var2, this.e, false);
               var1.a().a((H)this);
            }

         }
      }
   }

   private void a(y.f.X var1, y.c.d var2, List var3, boolean var4) {
      int var12 = ab.a;
      y.c.q var5 = var4?var2.c():var2.d();
      y.f.am var6 = var1.a((Object)var5);
      Iterator var7 = var3.iterator();

      label41:
      while(true) {
         boolean var10000 = var7.hasNext();

         label39:
         while(var10000) {
            y.d.t var8 = this.b.a((y.f.ax)var7.next(), var4);
            if(y.d.y.a(var6.getX(), var6.getY(), var6.getWidth(), var6.getHeight(), var8.a(), var8.b())) {
               continue label41;
            }

            List var9 = this.a().c().r().a(new y.d.y(var8.a(), var8.b(), 0.0D, 0.0D));
            Iterator var10 = var9.iterator();

            do {
               R var11;
               do {
                  if(!var10.hasNext()) {
                     continue label41;
                  }

                  var11 = (R)var10.next();
                  var10000 = var4;
                  if(var12 != 0) {
                     continue label39;
                  }

                  if(!var4) {
                     break;
                  }

                  this.b().a(var11);
               } while(var12 == 0);

               this.b().c(var11);
            } while(var12 == 0);

            return;
         }

         return;
      }
   }

   protected void c(aa var1) {
      super.c(var1);
      if(this.h && this.e.size() > 0) {
         var1.a().b((H)this);
      }

   }

   protected void d(aa var1) {
      super.d(var1);
      if(this.h && this.e.size() > 0) {
         var1.a().b((H)this);
      }

   }

   double[] a(f var1, R var2, P[] var3, v[] var4, double[] var5) {
      int var7 = ab.a;
      if(!this.h) {
         this.b("source port penalty", 0.0D, false);
         this.b("target port penalty", 0.0D, false);
         return new double[var3.length];
      } else {
         this.g = this.c != null;
         f var6 = var1;

         while(this.g && var6 != null) {
            this.g = this.b().b(var6.a());
            var6 = var6.b();
            if(var7 != 0) {
               break;
            }
         }

         return super.a(var1, var2, var3, var4, var5);
      }
   }

   protected double a(f var1, R var2, P var3, v var4, double var5) {
      R var7;
      double var8;
      int var15;
      label45: {
         var15 = ab.a;
         var7 = var1.a();
         var8 = 0.0D;
         if(this.g) {
            var8 = (double)this.f;
            List var10 = this.b.a(var7, var2, var3, true);
            Iterator var11 = var10.iterator();

            while(var11.hasNext()) {
               y.f.ax var12 = (y.f.ax)var11.next();
               var8 = Math.min(var8, var12.f());
               if(var15 != 0) {
                  break label45;
               }

               if(var15 != 0) {
                  break;
               }
            }
         }

         this.a("source port penalty", var8, false);
      }

      if(var8 > var5) {
         return var8;
      } else {
         double var16 = 0.0D;
         if(this.d != null && this.b().d(var2)) {
            var16 = (double)this.f;
            List var17 = this.b.a(var7, var2, var3, false);
            Iterator var13 = var17.iterator();

            while(var13.hasNext()) {
               y.f.ax var14 = (y.f.ax)var13.next();
               var16 = Math.min(var16, var14.f());
               if(var15 != 0) {
                  return var8 + var16;
               }

               if(var15 != 0) {
                  break;
               }
            }
         }

         this.a("target port penalty", var16, false);
         return var8 + var16;
      }
   }

   public void a(f var1, R var2, P var3, List var4, aa var5) {
      int var12 = ab.a;
      if(this.e.size() > 0 && var5.d(var2)) {
         List var6 = this.b.a(this.e, var1.a(), var2, false);
         Iterator var7 = var6.iterator();

         while(var7.hasNext()) {
            y.f.ax var8 = (y.f.ax)var7.next();
            y.d.t var9 = this.b.a(var8, false);
            double var10 = var3.a()?var9.b():var9.a();
            if(var3.e().a(var10)) {
               var4.add(new P(var10, var10, var3.f(), var3.a()));
               if(var12 != 0) {
                  break;
               }
            }
         }
      }

   }

   protected double a(f var1) {
      int var8 = ab.a;
      if(!this.h) {
         return 0.0D;
      } else {
         f var2 = var1.b();
         double var3 = 0.0D;
         double var10000;
         if(var2 != null && this.c != null && this.b().b(var2.a())) {
            var3 = (double)this.f;
            List var5 = this.b.a(var2.a(), var1.a(), var1.c(), true);
            Iterator var6 = var5.iterator();

            while(var6.hasNext()) {
               y.f.ax var7 = (y.f.ax)var6.next();
               var10000 = Math.min(var3, var7.f());
               if(var8 != 0) {
                  return var10000;
               }

               var3 = var10000;
               if(var8 != 0) {
                  break;
               }
            }
         }

         var10000 = var3;
         return var10000;
      }
   }

   protected void a(List var1) {
      int var21 = ab.a;
      if(this.h) {
         List var2 = this.b.b(true);
         if(!var2.isEmpty()) {
            aa var3 = this.b();
            int var4 = 0;
            int var5 = var3.e();

            label59:
            do {
               int var10000 = var4;

               label56:
               while(var10000 < var5) {
                  R var6 = var3.a(var4);
                  f var7 = new f(var6);
                  I var8 = this.a().c().r();
                  Iterator var9 = var8.c(var6).iterator();

                  label53:
                  while(var9.hasNext()) {
                     R var10 = (R)var9.next();
                     if(!var3.b(var10)) {
                        P var11 = V.a(var6, var10);
                        List var12 = this.b.a(var2, var6, var10, true);
                        Iterator var13 = var12.iterator();

                        while(var13.hasNext()) {
                           y.f.ax var14 = (y.f.ax)var13.next();
                           y.d.t var15 = this.b.a(var14, true);
                           var10000 = var11.a();
                           if(var21 != 0) {
                              continue label56;
                           }

                           double var16 = var10000 != 0?var15.b():var15.a();
                           if(var11.e().a(var16)) {
                              y.f.y var18 = V.a(var7, var10);
                              P var19 = new P(var16, var16, var11.f(), var11.a());
                              f var20 = new f(var10);
                              var20.a(var18);
                              var20.a(var19);
                              var20.a(var7);
                              var1.add(var20);
                              if(var21 != 0) {
                                 continue label59;
                              }

                              if(var21 != 0) {
                                 break label53;
                              }
                           }
                        }
                     }
                  }

                  ++var4;
                  continue label59;
               }

               return;
            } while(var21 == 0);

         }
      }
   }

   protected void a(ac var1) {
      int var6 = ab.a;
      super.a(var1);
      y.c.e var2 = this.b().b();

      while(var2.f()) {
         y.c.d var3 = var2.a();
         U var4 = var1.b(var3);
         if(var4 != null) {
            aU var5 = this.a().a(var3);
            var5.b(var4, true);
            var5.b(var4, false);
            this.a(var4, var5, true);
            this.a(var4, var5, false);
         }

         var2.g();
         if(var6 != 0) {
            break;
         }
      }

   }

   private void a(U var1, aU var2, boolean var3) {
      List var4 = var2.a(var1, var3);
      if(var4.size() > 0) {
         List var5 = var2.a(var4);
         y.f.ax var6 = var5.size() > 0?(y.f.ax)var5.get(0):null;
         if(var6 != null) {
            y.d.t var7 = var2.a(var6, var3);
            w var8 = this.b().i().a(var1);
            if(var3) {
               var8.a(var7);
               if(ab.a == 0) {
                  return;
               }
            }

            var8.b(var7);
         }
      }

   }
}
