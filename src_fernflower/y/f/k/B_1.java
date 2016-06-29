package y.f.k;

import y.f.aE;
import y.f.k.D;
import y.f.k.E;
import y.f.k.F;
import y.f.k.G;
import y.f.k.K;
import y.f.k.P;
import y.f.k.T;
import y.f.k.W;
import y.f.k.X;
import y.f.k.Y;
import y.f.k.d;
import y.f.k.l;
import y.f.k.m;
import y.f.k.x;

public class B extends d {
   public static final Object h = "LayeredNodePlacer.DP_KEY_DISTANCE_TO_PARENT_MAP";
   private m i;
   private double j;
   private double k;
   private boolean l;
   private boolean m;
   private Object n;
   private double o;
   private int p;

   public B(l var1, Object var2) {
      super(var1);
      this.i = m.g;
      this.j = 0.5D;
      this.k = 0.3D;
      this.m = false;
      this.o = 40.0D;
      this.n = var2;
   }

   public B() {
      this(l.a, "TheDefaultKey");
   }

   public boolean b() {
      return this.m;
   }

   protected byte d(y.c.q var1) {
      return (byte)0;
   }

   protected P a(y.c.q var1, byte var2) {
      int var29 = d.g;
      P var3 = this.a(var1);
      if(var1.c() == 0) {
         this.a(var1, var2, var3);
         return var3;
      } else {
         y.c.c var4 = this.b.c(h);
         if(var4 == null) {
            throw new IllegalStateException("distances not set!");
         } else {
            F var5 = (F)var4.b(var1);
            T var6 = new T(this.a().a(), this.b.h(var1));
            double var7 = var6.d() + var6.a() * this.j;
            double var9 = var7 + var5.a();
            y.d.t var11 = new y.d.t(0.0D, var9 + this.o * this.k);
            Y var12 = new Y(var11);
            P var13 = null;
            boolean var14 = false;
            y.c.d var15 = var1.f();

            y.c.q var16;
            P var10000;
            P var17;
            while(true) {
               if(var15 != null) {
                  var16 = var15.d();
                  var17 = this.b(var16);
                  F var18 = (F)var4.b(var16);
                  double var19 = this.a(var5, var18);
                  double var21 = var7 + var19;
                  T var23 = new T(this.a().a(), this.b.h(var16));
                  double var24 = var23.d() + var23.a() * this.j;
                  double var26 = var21 - var24;
                  var17.a(var26);
                  var10000 = var13;
                  if(var29 != 0) {
                     break;
                  }

                  if(var13 != null) {
                     y.d.c var28 = var13.a(1);
                     if(var14 || var5.c() - var18.c() < -1) {
                        var14 = var5.c() - var18.c() < -1;
                        var28 = new y.d.c(var28.a(), var28.b(), var28.d());
                     }

                     var17.a(var28, this.a);
                  }

                  label75: {
                     var17.h();
                     var17.j();
                     if(var13 == null) {
                        var13 = var17;
                        if(var29 == 0) {
                           break label75;
                        }
                     }

                     var13.a(var17);
                  }

                  var15 = var15.g();
                  if(var29 == 0) {
                     continue;
                  }
               }

               this.i.a(var3, this.f, this.a);
               var10000 = var3;
               break;
            }

            var10000.j();
            var15 = var1.f();

            B var30;
            while(true) {
               if(var15 != null) {
                  var16 = var15.d();
                  var30 = this;
                  if(var29 != 0) {
                     break;
                  }

                  label105: {
                     if(this.e() || this.d() || this.b()) {
                        var17 = this.b(var16);
                        W var31 = this.a(var15, var17);
                        if(this.e() || this.b()) {
                           var31.a(var12);
                           var31.d(1);
                           if(this.e()) {
                              var31.c(0);
                           }
                        }

                        var31.e();
                        if(var29 == 0) {
                           break label105;
                        }
                     }

                     this.b.b(var15).clearPoints();
                  }

                  var15 = var15.g();
                  if(var29 == 0) {
                     continue;
                  }
               }

               var3.a(this.f);
               var30 = this;
               break;
            }

            var30.a(var1, var2, var3);
            return var3;
         }
      }
   }

   private double a(F var1, F var2) {
      int var8 = d.g;
      double var3 = var1.a() + var2.b() + (double)(var2.c() - var1.c()) * this.o;
      E var5 = var1.d();
      int var6 = var1.c() + 1;

      double var10000;
      while(true) {
         if(var6 < var2.c()) {
            F var7 = var5.b(var6);
            var10000 = var3 + var7.a() + var7.b();
            if(var8 != 0) {
               break;
            }

            var3 = var10000;
            ++var6;
            if(var8 == 0) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   private boolean e() {
      return this.p == 1;
   }

   private void a(y.c.q var1, byte var2, P var3) {
      int var6 = d.g;
      if(this.p != 0) {
         if(var1.g() != null) {
            aE var4 = this.c(var1);
            X var5 = this.a(var1, var3);
            label54:
            switch(var2) {
            case 0:
               switch(var4.b()) {
               case 1:
               case 3:
               case 5:
               case 6:
               case 7:
               default:
                  if(var6 == 0) {
                     break label54;
                  }
               case 4:
                  var5.a(0, true);
                  if(var6 == 0) {
                     break label54;
                  }
               case 2:
                  var5.d(0, true);
                  var5.b(0, true);
                  if(var6 == 0) {
                     break label54;
                  }
               case 8:
                  var5.b(0, true);
                  if(var6 == 0) {
                     break label54;
                  }
               }
            case 1:
               switch(var4.b()) {
               case 1:
                  var5.c(1, true);
                  if(var6 == 0) {
                     break label54;
                  }
               case 3:
               case 4:
               case 5:
               case 6:
               case 7:
               default:
                  if(var6 == 0) {
                     break label54;
                  }
               case 2:
                  var5.d(0, true);
                  if(var6 == 0) {
                     break label54;
                  }
               case 8:
                  var5.b(0, true);
                  var5.c(1, true);
                  if(var6 == 0) {
                     break label54;
                  }
               }
            case 2:
               switch(var4.b()) {
               case 1:
                  var5.c(0, true);
                  var5.b(1, true);
                  if(var6 == 0) {
                     break label54;
                  }
               case 4:
                  var5.a(1, true);
                  if(var6 == 0) {
                     break label54;
                  }
               case 2:
                  var5.d(0, true);
                  var5.b(1, true);
                  if(var6 == 0) {
                     break label54;
                  }
               case 3:
               case 5:
               case 6:
               case 7:
               case 8:
               default:
                  var5.b(1, true);
                  if(var6 == 0) {
                     break label54;
                  }
               }
            case 3:
               switch(var4.b()) {
               case 1:
                  var5.c(0, true);
                  if(var6 == 0) {
                     break;
                  }
               case 4:
                  var5.a(0, true);
                  var5.c(1, true);
                  if(var6 == 0) {
                     break;
                  }
               case 2:
                  var5.d(0, true);
                  if(var6 != 0) {
                     ;
                  }
               case 3:
               case 5:
               case 6:
               case 7:
               case 8:
               }
            }

            var3.h();
         }
      }
   }

   public K a(x var1, y.f.X var2, y.c.q var3) {
      y.c.c var4 = var2.c(h);
      if(var4 != null && var4.b(var3) != null) {
         return null;
      } else {
         Object var5;
         if(this.m) {
            var5 = new D(this, var1, var2, var3);
            ((D)var5).a(this.a);
            if(d.g == 0) {
               return (K)var5;
            }
         }

         var5 = new G(this, var1, var2, var3);
         ((G)var5).a(this.a);
         return (K)var5;
      }
   }

   public Object c() {
      return this.n;
   }

   public boolean d() {
      return this.l;
   }

   static double a(B var0) {
      return var0.o;
   }

   static double b(B var0) {
      return var0.j;
   }
}
