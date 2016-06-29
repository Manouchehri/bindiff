package y.f.i.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import y.f.i.a.I;
import y.f.i.a.M;
import y.f.i.a.R;
import y.f.i.a.Z;
import y.f.i.a.aC;
import y.f.i.a.aN;
import y.f.i.a.ab;
import y.f.i.a.ac;
import y.f.i.a.af;
import y.f.i.a.ag;
import y.f.i.a.ah;
import y.f.i.a.ai;
import y.f.i.a.az;
import y.f.i.a.g;
import y.f.i.a.n;
import y.f.i.a.w;
import y.f.i.a.y;

public class ae extends y.f.a {
   private static final y a = h();
   private Object b;
   private Object c;
   private byte d;
   private double e;
   private double f;
   private double g;

   public ae(y.f.ah var1) {
      super(var1);
      this.b = y.f.ah.h_;
      this.c = y.f.ah.g_;
      this.e = 10.0D;
      this.f = 0.5D;
      this.g = 50.0D;
   }

   public ae() {
      this.b = y.f.ah.h_;
      this.c = y.f.ah.g_;
      this.e = 10.0D;
      this.f = 0.5D;
      this.g = 50.0D;
   }

   private static y h() {
      y var0 = new y();
      var0.a((byte)2);
      return var0;
   }

   public Object b() {
      return this.c;
   }

   public void a(Object var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("null");
      } else {
         this.c = var1;
      }
   }

   public Object c() {
      return this.b;
   }

   public void b(Object var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("null");
      } else {
         this.b = var1;
      }
   }

   public void a(byte var1) {
      switch(var1) {
      case 0:
      case 2:
      case 4:
         this.d = var1;
         if(ab.a == 0) {
            return;
         }
      case 1:
      case 3:
      default:
         throw new IllegalArgumentException("Argument \'" + var1 + "\' not allowed.");
      }
   }

   public byte d() {
      return this.d;
   }

   public double e() {
      return this.e;
   }

   public void a(double var1) {
      if(var1 < 0.0D) {
         throw new IllegalArgumentException("The distance must not be less than 0!");
      } else {
         this.e = var1;
      }
   }

   public double f() {
      return this.f;
   }

   public void b(double var1) {
      if(var1 >= 0.0D && var1 <= 0.5D) {
         this.f = var1;
      } else {
         throw new IllegalArgumentException("The ratio must be between 0 and 0.5!");
      }
   }

   public double g() {
      return this.g;
   }

   public void c(double var1) {
      if(var1 < 0.0D) {
         throw new IllegalArgumentException("The length must not be less than 0!");
      } else {
         this.g = var1;
      }
   }

   public void c(y.f.X var1) {
      int var11 = ab.a;
      this.a((y.f.X)var1);
      y.c.f var2 = new y.c.f();
      y.g.I var3 = new y.g.I(var1);
      y.c.e var4 = var1.p();

      while(true) {
         if(var4.f()) {
            y.c.d var5 = var4.a();
            if(var11 != 0) {
               break;
            }

            label25: {
               if(!y.a(var5, var1)) {
                  var3.a(var5);
                  if(var11 == 0) {
                     break label25;
                  }
               }

               if(this.a((y.c.d)var5, (y.c.i)var1)) {
                  var2.add(var5);
               }
            }

            var4.g();
            if(var11 == 0) {
               continue;
            }
         }

         a.a(this.e());
         break;
      }

      n var12 = new n();
      ag var13 = new ag(var12, (af)null);
      var13.a(new aC());
      var13.a(new az());
      y.f.b.c var6 = new y.f.b.c(var1);
      Z var7 = new Z(var1, var6, a);
      var13.a(var7);
      ac var8 = this.a((y.f.X)var1, (I)var13, (Z)var7);
      aN var9 = new aN();
      var9.a(this.f());
      var9.b(this.g());
      var9.a(var2, var8, var7);
      var13.a();
      y.f.aI var10 = new y.f.aI();
      var10.c(var1);
      var6.c();
      var3.f();
      if(y.c.i.g) {
         ++var11;
         ab.a = var11;
      }

   }

   private boolean a(y.c.d var1, y.c.i var2) {
      if(this.d() == 0) {
         return true;
      } else {
         y.c.c var3;
         if(this.d() == 2) {
            var3 = var2.c(this.c());
            return var3 != null && var3.d(var1);
         } else if(this.d() != 4) {
            return false;
         } else {
            var3 = var2.c(this.b());
            return var3 != null && (var3.d(var1.c()) || var3.d(var1.d()));
         }
      }
   }

   private ac a(y.f.X var1, I var2, Z var3) {
      int var8 = ab.a;
      ac var4 = new ac(var3);
      y.c.e var5 = var1.p();

      while(true) {
         if(var5.f()) {
            y.c.d var6 = (y.c.d)var5.d();
            w var7 = this.a(var6, var1, var2, var3);
            var4.a(var6, var7);
            var5.g();
            if(var8 != 0) {
               break;
            }

            if(var8 == 0) {
               continue;
            }
         }

         this.a(var1, var4);
         break;
      }

      return var4;
   }

   private void a(y.f.X var1, ac var2) {
      int var14 = ab.a;
      HashMap var3 = new HashMap();
      y.c.e var4 = var1.p();

      Iterator var7;
      ai var10;
      label99:
      do {
         boolean var10000 = var4.f();

         label96:
         while(true) {
            if(!var10000) {
               break label99;
            }

            w var5 = var2.a(var4.a());
            if(var5 == null) {
               break;
            }

            y.c.D var6 = var5.g();
            var7 = var6.iterator();
            var7.next();
            int var8 = 1;

            while(true) {
               if(var8 >= var5.e()) {
                  break label96;
               }

               var10000 = var7.hasNext();
               if(var14 != 0) {
                  break;
               }

               if(!var10000) {
                  break label96;
               }

               label91: {
                  y.d.t var9 = (y.d.t)var7.next();
                  var10 = var5.a(var8);
                  if(var3.containsKey(var9)) {
                     ai var11 = (ai)var3.get(var9);
                     ah var12 = var11.k();
                     if(var12 == null) {
                        y.c.D var13 = new y.c.D();
                        var13.add(var11);
                        var13.add(var10);
                        var12 = new ah(var11.c(), var13);
                        var11.a(var12);
                        var10.a(var12);
                        if(var14 == 0) {
                           break label91;
                        }
                     }

                     var12.b().add(var10);
                     var10.a(var12);
                     if(var14 == 0) {
                        break label91;
                     }
                  }

                  var3.put(var9, var10);
               }

               ++var8;
               if(var14 != 0) {
                  break label96;
               }
            }
         }

         var4.g();
      } while(var14 == 0);

      y.c.D var15 = new y.c.D(var3.keySet());
      var15.sort(new af(this));
      y.d.t var16 = null;
      ah var17 = null;
      var7 = var15.iterator();

      while(var7.hasNext()) {
         label66: {
            y.d.t var18;
            label65: {
               var18 = (y.d.t)var7.next();
               if(var16 != null && Math.abs(var16.a() - var18.a()) < 1.0E-6D && Math.abs(var16.b() - var18.b()) < 1.0E-6D) {
                  ai var19;
                  if(var17 != null) {
                     var19 = (ai)var3.get(var18);
                     if(var19.k() != null) {
                        ah var20 = var19.k();
                        Iterator var21 = var20.b().iterator();

                        do {
                           if(!var21.hasNext()) {
                              break label65;
                           }

                           ai var22 = (ai)var21.next();
                           var22.a(var17);
                           var17.b().add(var22);
                           if(var14 != 0) {
                              break label66;
                           }
                        } while(var14 == 0);
                     }

                     var19.a(var17);
                     var17.b().add(var19);
                     if(var14 == 0) {
                        break label65;
                     }
                  }

                  var19 = (ai)var3.get(var16);
                  var10 = (ai)var3.get(var18);
                  if(var10.k() != null) {
                     var17 = var10.k();
                     var17.b().add(var19);
                     var19.a(var17);
                     if(var14 == 0) {
                        break label65;
                     }
                  }

                  var17 = new ah(var19.c(), new y.c.D());
                  var17.b().add(var19);
                  var17.b().add(var10);
                  var19.a(var17);
                  var10.a(var17);
                  if(var14 == 0) {
                     break label65;
                  }
               }

               var17 = null;
            }

            var16 = var18;
         }

         if(var14 != 0) {
            break;
         }
      }

   }

   private w a(y.c.d var1, y.f.X var2, I var3, Z var4) {
      int var16 = ab.a;
      if(!y.b(var1, var2)) {
         return null;
      } else {
         y.c.D var5 = new y.c.D();
         y.d.m[] var6 = y.c(var1, var2);
         if(var6.length == 0) {
            return null;
         } else {
            int var7 = 0;

            label62:
            do {
               int var10000 = var7;

               label59:
               while(true) {
                  if(var10000 >= var6.length) {
                     break label62;
                  }

                  R var8 = null;
                  y.d.m var9 = var6[var7];
                  y.f.y var10 = b(var9);

                  while(true) {
                     if(var9 == null) {
                        break label59;
                     }

                     var8 = this.a(var9, var3, var8);
                     y.d.m[] var11 = this.a(var9, var8, var10);
                     var10000 = var9.b();
                     if(var16 != 0) {
                        break;
                     }

                     M var12;
                     double var13;
                     label54: {
                        if(var10000 != 0) {
                           var13 = var9.c().b();
                           var12 = new M(var11[0].c().a(), var11[0].d().a());
                           if(var16 == 0) {
                              break label54;
                           }
                        }

                        var13 = var9.c().a();
                        var12 = new M(var11[0].c().b(), var11[0].d().b());
                     }

                     if(var12.d() > 0.0D) {
                        g var15 = new g(var1, var7, var10, new M(var13, var13), var12, var12, var8);
                        var15.a(var13);
                        var5.add(var15);
                     }

                     var9 = var11[1];
                     if(var16 != 0) {
                        break label59;
                     }
                  }
               }

               ++var7;
            } while(var16 == 0);

            w var17 = new w(var1, var5, var4);
            int var18 = 0;

            w var21;
            while(true) {
               if(var18 < var17.e()) {
                  var21 = var17;
                  if(var16 != 0) {
                     break;
                  }

                  ai var19 = var17.a(var18);
                  g var20 = var19.b(0);
                  var19.a(var20.e());
                  ++var18;
                  if(var16 == 0) {
                     continue;
                  }
               }

               var21 = var17;
               break;
            }

            return var21;
         }
      }
   }

   private R a(y.d.m var1, I var2, R var3) {
      double var4;
      double var6;
      int var16;
      label43: {
         var16 = ab.a;
         double var8 = this.a(var1);
         if(var8 > 3.0E-6D) {
            var4 = var1.c().a() + (var1.d().a() - var1.c().a()) / var8 * 1.0E-6D * 2.0D;
            var6 = var1.c().b() + (var1.d().b() - var1.c().b()) / var8 * 1.0E-6D * 2.0D;
            if(var16 == 0) {
               break label43;
            }
         }

         var4 = var1.d().a();
         var6 = var1.d().b();
      }

      y.d.y var10;
      if(var3 != null) {
         var10 = var3.g();
         if(y.d.y.a(var10.c() - 1.0E-6D, var10.d() - 1.0E-6D, var10.a() + 2.0E-6D, var10.b() + 2.0E-6D, var4, var6, true)) {
            return var3;
         }
      }

      Object var11;
      label46: {
         var10 = new y.d.y(var4 - 1.0E-6D, var6 - 1.0E-6D, 2.0E-6D, 2.0E-6D);
         if(var3 == null) {
            var11 = var2.a(var10);
            if(var16 == 0) {
               break label46;
            }
         }

         var11 = new y.c.D();
         List var12 = var2.c(var3);
         Iterator var13 = var12.iterator();

         while(var13.hasNext()) {
            R var14 = (R)var13.next();
            y.d.y var15 = var14.g();
            if(y.d.y.a(var15.c() - 1.0E-6D, var15.d() - 1.0E-6D, var15.a() + 2.0E-6D, var15.b() + 2.0E-6D, var4, var6, true)) {
               ((List)var11).add(var14);
               if(var16 != 0) {
                  return (R)((List)var11).get(0);
               }

               if(var16 != 0) {
                  break;
               }
            }
         }
      }

      if(((List)var11).isEmpty()) {
         return null;
      } else {
         return (R)((List)var11).get(0);
      }
   }

   private double a(y.d.m var1) {
      return var1.b()?Math.abs(var1.c().a() - var1.d().a()):(var1.a()?Math.abs(var1.c().b() - var1.d().b()):var1.g());
   }

   private static y.f.y b(y.d.m var0) {
      y.d.t var1 = var0.c();
      y.d.t var2 = var0.d();
      if(var1.a() < var2.a() && Math.abs(var1.b() - var2.b()) < 1.0E-6D) {
         return y.f.y.b;
      } else if(var1.b() < var2.b() && Math.abs(var1.a() - var2.a()) < 1.0E-6D) {
         return y.f.y.c;
      } else if(var2.a() < var1.a() && Math.abs(var1.b() - var2.b()) < 1.0E-6D) {
         return y.f.y.d;
      } else if(var2.b() < var1.b() && Math.abs(var1.a() - var2.a()) < 1.0E-6D) {
         return y.f.y.a;
      } else {
         throw new IllegalArgumentException("Segment isn\'t orthogonal");
      }
   }

   private y.d.m[] a(y.d.m var1, R var2, y.f.y var3) {
      y.d.y var4;
      y.d.t var5;
      y.d.t var6;
      double var7;
      double var9;
      label42: {
         var4 = var2.g();
         var5 = var1.c();
         var6 = var1.d();
         double var11 = this.a(var1);
         if(var11 > 3.0E-6D) {
            var7 = var5.a() + (var6.a() - var5.a()) / var11 * 1.0E-6D * 2.0D;
            var9 = var5.b() + (var6.b() - var5.b()) / var11 * 1.0E-6D * 2.0D;
            if(ab.a == 0) {
               break label42;
            }
         }

         var7 = var6.a();
         var9 = var6.b();
      }

      double var13 = var4.c();
      double var15 = var4.a();
      double var17 = var4.d();
      double var19 = var4.b();
      if(!y.d.y.a(var13 - 1.0E-6D, var17 - 1.0E-6D, var15 + 2.0E-6D, var19 + 2.0E-6D, var7, var9, true)) {
         throw new IllegalArgumentException("LineSegment doesn\'t start in passed cell");
      } else if(var3.d() && a(var13, var13 + var15, var6.a()) || !var3.d() && a(var17, var17 + var19, var6.b())) {
         return new y.d.m[]{var1, null};
      } else {
         y.d.t var21 = null;
         if(y.f.y.b.equals(var3)) {
            var21 = new y.d.t(var2.j(), var5.b());
         } else if(y.f.y.d.equals(var3)) {
            var21 = new y.d.t(var2.h(), var5.b());
         } else if(y.f.y.c.equals(var3)) {
            var21 = new y.d.t(var5.a(), var2.k());
         } else {
            var21 = new y.d.t(var5.a(), var2.i());
         }

         return new y.d.m[]{new y.d.m(var5, var21), new y.d.m(var21, var6)};
      }
   }

   private static boolean a(double var0, double var2, double var4) {
      return var4 + 1.0E-6D >= var0 && var4 - 1.0E-6D <= var2;
   }
}
