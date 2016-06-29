package y.f.i;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y.f.i.T;
import y.f.i.U;
import y.f.i.V;
import y.f.i.v;

class S {
   private Map a = new HashMap(11);
   private List b = new ArrayList(62);
   private List c = new ArrayList(62);
   private double d;
   private double e = -1.7976931348623157E308D;
   private double f = Double.MAX_VALUE;
   private double g = 10.0D;
   private Map h = new HashMap();
   private List i = new ArrayList();
   private Map j = new HashMap();
   private Set k = new HashSet();
   private y.d.c l;
   private y.d.c m;
   private double n;
   private double o = 10.0D;
   private boolean p = true;
   private double q = 1.0D;
   private double r = 0.5D;
   private double s;
   private double t;
   private Comparator u;
   private double v;
   private double w;
   private Comparator x;
   private U[] y;
   private U[] z;
   private y.c.D A;
   private y.c.D B;
   private double C;
   private double D;

   public void a(double var1) {
      this.v = var1;
   }

   public void b(double var1) {
      this.w = var1;
   }

   public void a(Comparator var1) {
      this.u = var1;
   }

   public void a() {
      this.s = 0.0D;
      this.k.clear();
      this.j.clear();
      this.i.clear();
      this.h.clear();
      this.a.clear();
      this.b.clear();
      this.c.clear();
      this.t = 0.0D;
      this.d = -1.0D;
   }

   public void c(double var1) {
      this.n = var1;
   }

   public void a(y.d.c var1) {
      this.l = var1;
   }

   public void b(y.d.c var1) {
      this.m = var1;
   }

   public U a(Object var1, double var2, double var4, double var6, boolean var8, double var9, boolean var11, boolean var12) {
      U var13 = this.a(var1, var2, var4, var6, var8, var9, var11);
      var13.a(var12);
      return var13;
   }

   public U a(Object var1, double var2, double var4, double var6, boolean var8, double var9, boolean var11) {
      U var12;
      int var13;
      label19: {
         var13 = v.f;
         if(var6 > var9) {
            var12 = U.a(var1, var2, var4, var9, var11, var6, var8);
            if(var13 == 0) {
               break label19;
            }
         }

         var12 = U.a(var1, var2, var4, var6, var8, var9, var11);
      }

      label14: {
         this.a.put(var1, var12);
         if(U.a(var12) == 3) {
            this.b.add(var12);
            if(var13 == 0) {
               break label14;
            }
         }

         this.c.add(var12);
      }

      this.k.add(var1);
      return var12;
   }

   public void b() {
      int var3 = v.f;
      if(this.h.size() > 0) {
         this.f();
      }

      this.y = new U[this.b.size()];
      this.z = new U[this.c.size()];
      this.C = Double.MAX_VALUE;
      this.D = -1.7976931348623157E308D;
      int var1 = this.b.size() - 1;

      U var2;
      while(true) {
         if(var1 >= 0) {
            var2 = (U)this.b.get(var1);
            this.D = Math.max(this.D, U.b(var2));
            this.C = Math.min(this.C, U.c(var2));
            this.y[var1] = var2;
            --var1;
            if(var3 != 0) {
               break;
            }

            if(var3 == 0) {
               continue;
            }
         }

         var1 = this.c.size() - 1;
         break;
      }

      while(true) {
         if(var1 >= 0) {
            var2 = (U)this.c.get(var1);
            this.D = Math.max(this.D, U.b(var2));
            this.C = Math.min(this.C, U.c(var2));
            this.z[var1] = var2;
            --var1;
            if(var3 != 0) {
               break;
            }

            if(var3 == 0) {
               continue;
            }
         }

         this.x = new V(this.u);
         y.g.e.a((Object[])this.y, this.x);
         y.g.e.a((Object[])this.z, this.x);
         this.e();
         break;
      }

   }

   private void e() {
      int var10000;
      y.d.d var1;
      y.d.d var2;
      double var3;
      double var5;
      double var7;
      int var9;
      label81: {
         var9 = v.f;
         this.A = new y.c.D();
         if(this.l != null) {
            var1 = this.l.e();
            if(this.l.b(var1) > this.C) {
               this.A.a((Object)(new T(this.C, -this.f, 0.0D, this.t, false)));
            }

            var2 = this.l.e();

            label77: {
               while(var2 != null) {
                  var3 = this.l.a(var2);
                  var5 = this.l.b(var2);
                  double var10;
                  var10000 = (var10 = var3 - Double.MAX_VALUE) == 0.0D?0:(var10 < 0.0D?-1:1);
                  if(var9 != 0) {
                     break label77;
                  }

                  label73: {
                     if(var10000 == 0) {
                        var7 = -this.f;
                        if(var9 == 0) {
                           break label73;
                        }
                     }

                     var7 = -var3;
                  }

                  this.A.b((Object)(new T(var5, var7, 0.0D, this.t, false)));
                  var2 = this.l.e(var2);
                  if(var9 != 0) {
                     break;
                  }
               }

               var2 = this.l.f();
               double var11;
               var10000 = (var11 = this.l.b(var2) - this.D) == 0.0D?0:(var11 < 0.0D?-1:1);
            }

            if(var10000 >= 0) {
               break label81;
            }

            this.A.b((Object)(new T(this.D, -this.f, 0.0D, this.t, false)));
            if(var9 == 0) {
               break label81;
            }
         }

         this.A.a((Object)(new T(this.C, -this.f, 0.0D, this.t, false)));
         this.A.b((Object)(new T(this.D, -this.f, 0.0D, this.t, false)));
      }

      this.B = new y.c.D();
      if(this.m != null) {
         var1 = this.m.e();
         if(this.m.b(var1) > this.C) {
            this.B.a((Object)(new T(this.C, this.e, 0.0D, this.t, false)));
         }

         var2 = this.m.e();

         label54: {
            while(var2 != null) {
               var3 = this.m.a(var2);
               var5 = this.m.b(var2);
               double var12;
               var10000 = (var12 = var3 - -1.7976931348623157E308D) == 0.0D?0:(var12 < 0.0D?-1:1);
               if(var9 != 0) {
                  break label54;
               }

               label50: {
                  if(var10000 == 0) {
                     var7 = this.e;
                     if(var9 == 0) {
                        break label50;
                     }
                  }

                  var7 = var3;
               }

               this.B.b((Object)(new T(var5, var7, 0.0D, this.t, false)));
               var2 = this.m.e(var2);
               if(var9 != 0) {
                  break;
               }
            }

            var2 = this.m.f();
            double var13;
            var10000 = (var13 = this.m.b(var2) - this.D) == 0.0D?0:(var13 < 0.0D?-1:1);
         }

         if(var10000 >= 0) {
            return;
         }

         this.B.b((Object)(new T(this.D, this.e, 0.0D, this.t, true)));
         if(var9 == 0) {
            return;
         }
      }

      this.B.a((Object)(new T(this.C, this.e, 0.0D, this.t, true)));
      this.B.b((Object)(new T(this.D, this.e, 0.0D, this.t, true)));
   }

   private double b(y.c.D var1, y.c.D var2) {
      int var13 = v.f;
      y.c.p var3 = var1.k();
      y.c.p var4 = var2.k();
      double var5 = 0.0D;
      double var7 = -1.7976931348623157E308D;

      while(var3 != null && var4 != null) {
         T var9 = (T)var3.c();
         T var10 = (T)var4.c();
         double var11 = -(var10.c + var10.d) - (var9.c + var9.d);
         var7 = Math.max(var7, Math.max(var9.e, var10.e) - var11);
         if(var3.a() != null && var4.a() != null) {
            if(((T)var3.a().c()).b < ((T)var4.a().c()).b) {
               var3 = var3.a();
               if(var13 == 0) {
                  continue;
               }
            }

            var4 = var4.a();
            if(var13 == 0) {
               continue;
            }
         }

         if(var4.a() != null) {
            var4 = var4.a();
            if(var13 == 0) {
               continue;
            }
         }

         if(var3.a() == null) {
            break;
         }

         var3 = var3.a();
         if(var13 != 0) {
            break;
         }
      }

      return -var7;
   }

   public double a(y.c.D var1, y.c.D var2) {
      double var3 = Math.max(this.s, -this.b(var1, var2));
      if(var3 == -1.7976931348623157E308D) {
         var3 = 0.0D;
      }

      return var3;
   }

   public void c() {
      int var11 = v.f;
      this.b();
      int var1 = 0;

      U var2;
      double var5;
      byte var10000;
      while(true) {
         if(var1 < this.y.length) {
            var2 = this.y[var1];
            var10000 = var2.b();
            if(var11 != 0) {
               break;
            }

            if(var10000 == 0) {
               double var3 = var2.e();
               var5 = var2.f();
               var2.c(-var3);
               var2.b(-var5);
               this.a(this.A, var2, 0.0D, false);
               var2.a(-var2.d());
               var2.b(var3);
               var2.c(var5);
            }

            ++var1;
            if(var11 == 0) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      var1 = var10000;

      S var15;
      while(true) {
         if(var1 < this.z.length) {
            var15 = this;
            if(var11 != 0) {
               break;
            }

            var2 = this.z[var1];
            if(var2.a() == 0 && !var2.b()) {
               this.a(this.B, var2, 0.0D, false);
            }

            ++var1;
            if(var11 == 0) {
               continue;
            }
         }

         var15 = this;
         break;
      }

      y.c.D var12 = var15.a(this.A);
      y.c.D var13 = this.a(this.B);
      int var14 = 0;

      U var4;
      int var16;
      while(true) {
         if(var14 < this.z.length) {
            var4 = this.z[var14];
            var16 = var4.b();
            if(var11 != 0) {
               break;
            }

            if(var16 != 0) {
               this.a(var13, var4, 0.0D, false);
            }

            ++var14;
            if(var11 == 0) {
               continue;
            }
         }

         var16 = this.y.length - 1;
         break;
      }

      var14 = var16;

      while(true) {
         if(var14 >= 0) {
            var4 = this.y[var14];
            var10000 = var4.b();
            if(var11 != 0) {
               break;
            }

            if(var10000 != 0) {
               this.a(var13, var4, 0.0D, false);
            }

            --var14;
            if(var11 == 0) {
               continue;
            }
         }

         this.s = Math.max(this.s, this.a(var13, this.A));
         var10000 = 0;
         break;
      }

      var14 = var10000;

      double var7;
      double var9;
      while(true) {
         if(var14 < this.y.length) {
            var4 = this.y[var14];
            var16 = var4.b();
            if(var11 != 0) {
               break;
            }

            if(var16 != 0) {
               var5 = var4.e();
               var7 = var4.f();
               var4.c(-var5);
               var4.b(-var7);
               var9 = var4.d();
               this.a(var12, var4, var9, true);
               var4.a(-var4.d());
               var4.a((U.d(var4) + var9) * 0.5D);
               var4.b(var5);
               var4.c(var7);
            }

            ++var14;
            if(var11 == 0) {
               continue;
            }
         }

         var16 = this.z.length - 1;
         break;
      }

      var14 = var16;

      while(true) {
         if(var14 >= 0) {
            var4 = this.z[var14];
            if(var11 != 0) {
               break;
            }

            if(var4.b()) {
               var5 = var4.e();
               var7 = var4.f();
               var4.c(-var5);
               var4.b(-var7);
               var9 = var4.d();
               this.a(var12, var4, var9, true);
               var4.a(-var4.d());
               var4.a((var4.d() + var9) * 0.5D);
               var4.b(var5);
               var4.c(var7);
            }

            --var14;
            if(var11 == 0) {
               continue;
            }
         }

         this.s = Math.max(this.s, this.a(this.B, var12));
         break;
      }

   }

   private y.c.D a(y.c.D var1) {
      int var5 = v.f;
      y.c.D var2 = new y.c.D(var1);
      y.c.p var3 = var2.k();

      while(var3 != null) {
         T var4 = (T)var3.c();
         var3.a(var4.clone());
         var3 = var3.a();
         if(var5 != 0) {
            break;
         }
      }

      return var2;
   }

   public double d() {
      return this.s;
   }

   private void f() {
      int var20 = v.f;
      int var1 = this.i.size() - 1;

      do {
         int var10000 = var1;

         double var2;
         double var4;
         double var6;
         double var8;
         boolean var10;
         boolean var11;
         y.c.D var12;
         double var13;
         double var15;
         label63:
         while(true) {
            if(var10000 < 0) {
               return;
            }

            var2 = Double.MAX_VALUE;
            var4 = -1.7976931348623157E308D;
            var6 = -1.7976931348623157E308D;
            var8 = Double.MAX_VALUE;
            var10 = true;
            var11 = true;
            var12 = (y.c.D)this.i.get(var1);
            var13 = 0.0D;
            var15 = 0.0D;
            y.c.p var17 = var12.k();

            while(true) {
               if(var17 == null) {
                  break label63;
               }

               U var18 = (U)var17.c();
               var6 = Math.max(var6, var18.e());
               var8 = Math.min(var8, var18.f());
               var15 = Math.max(var15, var18.a);
               var13 = Math.max(var13, U.e(var18));
               double var22;
               var10000 = (var22 = U.c(var18) - var2) == 0.0D?0:(var22 < 0.0D?-1:1);
               if(var20 != 0) {
                  break;
               }

               byte var19;
               if(var10000 < 0) {
                  var2 = U.c(var18);
                  var19 = var18.a();
                  var10 = var19 == 2 || var19 == 0;
               }

               if(U.b(var18) > var4) {
                  var4 = U.b(var18);
                  var19 = var18.a();
                  var11 = var19 == 1 || var19 == 0;
               }

               this.k.add(var18.c());
               var17 = var17.a();
               if(var20 != 0) {
                  break label63;
               }
            }
         }

         label35: {
            U var21 = U.a(var12, var15 * 2.0D, var13, var2, var10, var4, var11);
            var21.b(var6);
            var21.c(var8);
            this.a.put(var12, var21);
            if(U.a(var21) == 3) {
               this.b.add(var21);
               if(var20 == 0) {
                  break label35;
               }
            }

            this.c.add(var21);
         }

         --var1;
      } while(var20 == 0);

   }

   public double a(Object var1) {
      double var2 = this.b(var1).d();
      return Double.isNaN(var2)?this.n:var2;
   }

   private void a(y.c.D var1, U var2, double var3, boolean var5) {
      int var18 = v.f;
      if(this.p && Math.abs(U.b(var2) - U.c(var2)) < this.r) {
         var2.a(Double.NaN);
      } else {
         byte var6 = var2.a();
         T var7 = new T(U.c(var2), 0.0D, var2.a, U.e(var2), var6 == 0 || var6 == 2);
         T var8 = new T(U.b(var2), 0.0D, var2.a, U.e(var2), var6 == 1 || var6 == 0);
         y.c.p var9 = var1.k();
         T var10 = (T)var9.c();
         double var11 = var10.c + var10.d + Math.max(var10.e, U.e(var2));
         T var13 = var10;

         while(true) {
            if(U.c(var2) - var2.a > var10.b + var10.d) {
               var11 = var10.c + var10.d + Math.max(var10.e, U.e(var2));
               var13 = var10;
               var9 = var9.a();
               var10 = (T)var9.c();
               if(var18 != 0) {
                  break;
               }

               if(var18 == 0) {
                  continue;
               }
            }

            var11 = Math.max(var11, var2.e());
            break;
         }

         while(var9 != null && U.c(var2) > var10.b) {
            var11 = Math.max(var11, var10.c + var10.d + Math.max(var10.e, U.e(var2)));
            var13 = var10;
            var9 = var9.a();
            var10 = (T)var9.c();
            if(var18 != 0) {
               break;
            }
         }

         y.c.p var14 = var1.a((Object)var7, (y.c.p)var9);

         int var19;
         label145: {
            label111:
            while(true) {
               y.c.p var10000;
               if(U.b(var2) >= var10.b) {
                  var13 = var10;
                  double var15 = var10.c;
                  var11 = Math.max(var15 + var10.d + Math.max(var10.e, U.e(var2)), var11);
                  var1.h(var9);
                  var9 = var9.a();
                  var10000 = var9;
                  if(var18 == 0) {
                     if(var9 != null) {
                        var10 = (T)var9.c();
                        if(var18 == 0) {
                           continue;
                        }
                     }

                     var10000 = var9;
                  }
               } else {
                  var10000 = var9;
               }

               while(true) {
                  if(var10000 == null) {
                     break label111;
                  }

                  double var20;
                  var19 = (var20 = U.b(var2) + var2.a - (var10.b - var10.d)) == 0.0D?0:(var20 < 0.0D?-1:1);
                  if(var18 != 0) {
                     break label145;
                  }

                  if(var19 <= 0) {
                     break label111;
                  }

                  var11 = Math.max(var10.c + var10.d + Math.max(var10.e, U.e(var2)), var11);
                  var9 = var9.a();
                  if(var9 == null) {
                     break label111;
                  }

                  var10 = (T)var9.c();
                  if(var18 != 0) {
                     break label111;
                  }

                  var10000 = var9;
               }
            }

            T var17;
            if(var14.b() != null) {
               var17 = (T)var14.b().c();
               if(var17.b + this.q > U.c(var2) && var17.a != var7.a && var14.b().b() != null) {
                  var17 = (T)var14.b().b().c();
                  var11 = Math.max(var11, var17.c + var17.d + Math.max(var17.e, U.e(var2)));
               }
            }

            if(var14.a() != null) {
               var17 = (T)var14.a().c();
               if(var17.b - this.q < U.b(var2) && var17.a != var8.a) {
                  var11 = Math.max(var11, var17.c + var17.d + Math.max(var17.e, U.e(var2)));
               }
            }

            double var21;
            var19 = (var21 = this.v - 0.0D) == 0.0D?0:(var21 < 0.0D?-1:1);
         }

         if(var19 > 0) {
            var11 = Math.ceil((var11 - this.w) / this.v) * this.v + this.w;
            if(var5 && Math.abs(((var11 + var3) * 0.5D - this.w) % this.v) > 0.0D) {
               var11 += this.v;
            }
         }

         var11 += var2.a;
         var14.a(new T(U.c(var2), var11, var2.a * 2.0D, U.e(var2), U.a(var2) == 2 || U.a(var2) == 0));
         var1.b((Object)(new T(U.b(var2), var13.c, var13.d * 2.0D, var13.e, U.a(var2) == 0 || U.a(var2) == 1)), var14);
         var2.a(var11);
         if(var11 - var2.f() > this.s) {
            this.s = Math.max(this.s, var11 - var2.f());
         }

         this.d = Math.max(this.d, var11);
      }
   }

   private U b(Object var1) {
      U var2 = (U)this.a.get(var1);
      if(var2 == null) {
         Object var3 = this.j.get(var1);
         if(var3 != null) {
            return (U)this.a.get(var3);
         } else {
            throw new IllegalArgumentException("No such key registered!");
         }
      } else {
         return var2;
      }
   }
}
