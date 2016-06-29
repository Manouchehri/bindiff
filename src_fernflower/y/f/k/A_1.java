package y.f.k;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import y.f.am;
import y.f.k.d;
import y.f.k.l;
import y.f.k.n;

public final class A {
   private y.d.c[] c;
   double a;
   double b;
   private double d;
   private double e;
   private List f;
   private double g;
   private double h;
   private byte i;
   private y.c.q j;
   private am k;

   A(y.c.q var1, am var2) {
      int var9 = d.g;
      super();
      this.c = new y.d.c[4];
      this.j = var1;
      this.k = var2;
      this.d = var2.getX();
      this.e = var2.getY();
      double var3 = var2.getWidth();
      if(var3 <= 0.0D) {
         var3 = 1.0D;
         this.d -= 0.5D;
      }

      double var5 = var2.getHeight();
      if(var5 <= 0.0D) {
         var5 = 1.0D;
         this.e -= 0.5D;
      }

      label23: {
         this.c[0] = new y.d.c(0.0D, var3, 0.0D);
         this.c[0].b(this.d);
         this.c[0].a(this.e);
         this.c[2] = new y.d.c(0.0D, var3, 0.0D);
         this.c[2].b(this.d);
         this.c[2].a(this.e + var5);
         this.c[1] = new y.d.c(0.0D, var5, 0.0D);
         this.c[1].b(this.e);
         this.c[1].a(this.d + var3);
         this.c[3] = new y.d.c(0.0D, var5, 0.0D);
         this.c[3].b(this.e);
         this.c[3].a(this.d);
         if(var1.b() > 0) {
            y.f.X var7 = (y.f.X)var1.e();
            y.d.t var8 = var7.o(var1.g());
            this.g = var8.a + var3 * 0.5D;
            this.h = var8.b + var5 * 0.5D;
            if(var9 == 0) {
               break label23;
            }

            y.c.i.g = !y.c.i.g;
         }

         this.g = 0.0D;
         this.h = 0.0D;
      }

      this.i = 1;
   }

   public Rectangle2D a() {
      double var1 = this.e();
      double var3 = this.f();
      return new Double(var1, var3, this.g() - var1, this.h() - var3);
   }

   public double b() {
      return this.f == null?this.g + this.d:((y.d.t)this.f.get(this.f.size() - 1)).a + this.d;
   }

   public double c() {
      return this.f == null?this.h + this.e:((y.d.t)this.f.get(this.f.size() - 1)).b + this.e;
   }

   public void d() {
      int var7 = d.g;
      if(this.f != null) {
         double var1 = this.g + this.d;
         double var3 = this.h + this.e;
         int var5 = 0;

         while(var5 < this.f.size()) {
            y.d.t var6 = (y.d.t)this.f.get(var5);
            this.a(var1, var3, var6.a + this.d, var6.b + this.e);
            var1 = var6.a + this.d;
            var3 = var6.b + this.e;
            ++var5;
            if(var7 != 0) {
               break;
            }
         }
      }

   }

   public void a(double var1, double var3) {
      if(this.f == null) {
         this.f = new ArrayList(8);
      }

      this.f.add(new y.d.t(var1 - this.d, var3 - this.e));
   }

   public void a(y.f.X var1, y.c.d var2) {
      int var11 = d.g;
      y.f.I var3 = var1.b(var2);
      y.d.t var4 = var1.p(var2);
      double var5 = var4.a;
      double var7 = var4.b;
      int var9 = 0;

      y.d.t var10000;
      while(true) {
         if(var9 < var3.pointCount()) {
            y.d.t var10 = var3.getPoint(var9);
            this.a(var5, var7, var10.a, var10.b);
            var5 = var10.a;
            var10000 = var10;
            if(var11 != 0) {
               break;
            }

            var7 = var10.b;
            ++var9;
            if(var11 == 0) {
               continue;
            }
         }

         var10000 = var1.q(var2);
         break;
      }

      y.d.t var12 = var10000;
      this.a(var5, var7, var12.a, var12.b);
   }

   public void a(y.f.I var1) {
      int var4 = d.g;
      if(this.f != null) {
         int var2 = this.f.size() - 1;

         while(var2 >= 0) {
            y.d.t var3 = (y.d.t)this.f.get(var2);
            var1.addPoint(var3.a + this.d, var3.b + this.e);
            --var2;
            if(var4 != 0) {
               break;
            }
         }
      }

   }

   public void a(double var1, double var3, double var5, double var7) {
      int var25;
      label69: {
         var25 = d.g;
         double var9 = var1 < var5?var1:var5;
         double var11 = var1 < var5?var5:var1;
         double var13 = var1 < var5?var3:var7;
         double var15 = var1 < var5?var7:var3;
         double var17 = var3 < var7?var3:var7;
         double var19 = var3 < var7?var7:var3;
         double var21 = var3 < var7?var1:var5;
         double var23 = var3 < var7?var5:var1;
         if(Math.abs(var1 - var5) > 1.0D) {
            if(Math.abs(var3 - var7) > 1.0D) {
               this.c[0].b(new y.d.c(var9, var11, var13, var15));
               this.c[1].a(new y.d.c(var17, var19, var21, var23));
               this.c[2].a(new y.d.c(var9, var11, var13, var15));
               this.c[3].b(new y.d.c(var17, var19, var21, var23));
               if(var25 == 0) {
                  break label69;
               }
            }

            this.c[0].a(var9, var11, var17);
            this.c[1].b(var17 - 0.5D, var19 + 0.5D, var11);
            this.c[2].b(var9, var11, var19);
            this.c[3].a(var17 - 0.5D, var19 + 0.5D, var9);
            if(var25 == 0) {
               break label69;
            }
         }

         if(Math.abs(var3 - var7) > 1.0D) {
            this.c[0].a(var9 - 0.5D, var11 + 0.5D, var17);
            this.c[1].b(var17, var19, var11);
            this.c[2].b(var9 - 0.5D, var11 + 0.5D, var19);
            this.c[3].a(var17, var19, var9);
            if(var25 == 0) {
               break label69;
            }
         }

         this.c[0].a(var9 - 0.5D, var11 + 0.5D, var17);
         this.c[1].b(var17 - 0.5D, var19 + 0.5D, var11);
         this.c[2].b(var9 - 0.5D, var11 + 0.5D, var19);
         this.c[3].a(var17 - 0.5D, var19 + 0.5D, var9);
      }

      if(y.c.i.g) {
         ++var25;
         d.g = var25;
      }

   }

   public void b(double var1, double var3, double var5, double var7) {
      y.d.c var9 = this.a(0);
      y.d.c var10 = this.a(1);
      y.d.c var11 = this.a(2);
      y.d.c var12 = this.a(3);
      if(var5 > 0.0D) {
         var9.a(var1, var1 + var5, var3);
         var11.b(var1, var1 + var5, var3 + var7);
      }

      if(var7 > 0.0D) {
         var10.b(var3, var3 + var7, var1 + var5);
         var12.a(var3, var3 + var7, var1);
      }

   }

   void a(y.d.n var1) {
      int var6 = d.g;
      if(b(var1)) {
         y.d.y var2 = var1.h();
         this.b(var2.c(), var2.d(), var2.a(), var2.b());
         if(var6 == 0) {
            return;
         }
      }

      y.d.t[] var7 = y.d.n.a(var1);
      int var3 = 0;

      while(var3 < var7.length) {
         y.d.t var4 = var7[var3];
         y.d.t var5 = var7[(var3 + 1) % var7.length];
         this.a(var4.a, var4.b, var5.a, var5.b);
         ++var3;
         if(var6 != 0) {
            break;
         }
      }

   }

   private static boolean b(y.d.n var0) {
      return Math.abs(var0.g()) < 1.0E-4D || Math.abs(var0.i()) < 1.0E-4D;
   }

   public void a(A var1) {
      this.c[0].b(var1.c[0]);
      this.c[1].a(var1.c[1]);
      this.c[2].a(var1.c[2]);
      this.c[3].b(var1.c[3]);
   }

   public double e() {
      return Math.min(this.c[0].a(), Math.min(this.c[2].a(), this.c[3].c()));
   }

   public double f() {
      return Math.min(this.c[0].c(), Math.min(this.c[1].a(), this.c[3].a()));
   }

   public double g() {
      return Math.max(this.c[0].b(), Math.max(this.c[2].b(), this.c[1].d()));
   }

   public double h() {
      return Math.max(this.c[1].b(), Math.max(this.c[2].d(), this.c[3].b()));
   }

   public y.d.c a(int var1) {
      if(var1 >= 0 && var1 <= 3) {
         return this.c[var1];
      } else {
         throw new IllegalArgumentException("Unknown border line index" + var1);
      }
   }

   public void b(double var1, double var3) {
      this.c[0].b(var1);
      this.c[0].a(var3);
      this.c[1].b(var3);
      this.c[1].a(var1);
      this.c[2].b(var1);
      this.c[2].a(var3);
      this.c[3].b(var3);
      this.c[3].a(var1);
      this.d += var1;
      this.e += var3;
      this.k.setLocation(this.k.getX() + var1, this.k.getY() + var3);
   }

   public double i() {
      return this.d;
   }

   public double j() {
      return this.e;
   }

   public A a(l var1) {
      A var2 = new A(this.j, new y.f.x());
      var2.i = this.i;
      this.a(var2, var1);
      return var2;
   }

   public void a(A var1, l var2) {
      int var16 = d.g;
      n var3 = n.a(this.k.getWidth(), this.k.getHeight());
      n var4 = var3.a(var2);
      var1.k.setSize(var4.a(0), var4.a(1));
      n var5 = n.a(this.d, this.e);
      n var6 = var5.a(var2);
      var1.d = var6.a(0);
      var1.e = var6.a(1);
      var1.k.setLocation(var6.a(0), var6.a(1));
      n var7 = n.a(this.g, this.h);
      n var8 = var7.a(var2);
      var1.g = var8.a(0);
      var1.h = var8.a(1);
      y.d.c[] var9 = new y.d.c[4];
      int var10 = 0;

      n var14;
      while(true) {
         if(var10 < this.c.length) {
            y.d.c var11 = this.c[var10];
            l var12 = var2.a();
            if(var16 != 0) {
               break;
            }

            y.d.c var13;
            label83: {
               n var15;
               if(var10 == 0 || var10 == 2) {
                  var14 = var12.a(0);
                  var15 = var12.a(1);
                  var13 = var11.a(var15.a() < 0.0D, var14.a() < 0.0D);
                  if(var16 == 0) {
                     break label83;
                  }
               }

               var14 = var12.a(0);
               var15 = var12.a(1);
               var13 = var11.a(var14.a() < 0.0D, var15.a() < 0.0D);
            }

            int var21 = n.b(var10).a(var2).b();
            var9[var21] = var13;
            ++var10;
            if(var16 == 0) {
               continue;
            }
         }

         var1.c = var9;
         break;
      }

      if(this.f != null) {
         ArrayList var17 = new ArrayList();
         Iterator var18 = this.f.iterator();

         while(var18.hasNext()) {
            y.d.t var19 = (y.d.t)var18.next();
            n var20 = n.a(var19);
            var14 = var20.a(var2);
            var17.add(new y.d.t(var14.a(0), var14.a(1)));
            if(var16 != 0) {
               return;
            }

            if(var16 != 0) {
               break;
            }
         }

         var1.f = var17;
      }

   }

   y.c.q k() {
      return this.j;
   }

   public String toString() {
      return "SubtreeShape{x=" + this.d + ", y=" + this.e + ", dx=" + this.a + ", dy=" + this.b + ", borderLines=" + (this.c == null?null:Arrays.asList(this.c)) + "}";
   }
}
