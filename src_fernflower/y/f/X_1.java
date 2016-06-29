package y.f;

import java.awt.Rectangle;
import java.util.ArrayList;
import y.f.C;
import y.f.I;
import y.f.O;
import y.f.aj;
import y.f.am;

public abstract class X extends y.c.i implements O {
   public static boolean j;

   public X() {
   }

   public X(X var1, y.c.C var2) {
      super(var1, var2);
   }

   protected abstract y.g.C b();

   public abstract am h(y.c.q var1);

   public abstract I g(y.c.d var1);

   public abstract aj[] i(y.c.q var1);

   public abstract C[] h(y.c.d var1);

   public abstract y.c.q a(aj var1);

   public abstract y.c.d a(C var1);

   public am a(Object var1) {
      return this.h((y.c.q)var1);
   }

   public I b(Object var1) {
      return this.g((y.c.d)var1);
   }

   public aj[] a_(Object var1) {
      return this.i((y.c.q)var1);
   }

   public C[] d(Object var1) {
      return this.h((y.c.d)var1);
   }

   public double j(y.c.q var1) {
      am var2 = this.h(var1);
      return var2.getX() + var2.getWidth() / 2.0D;
   }

   public double k(y.c.q var1) {
      am var2 = this.h(var1);
      return var2.getY() + var2.getHeight() / 2.0D;
   }

   public y.d.t l(y.c.q var1) {
      return new y.d.t(this.j(var1), this.k(var1));
   }

   public double m(y.c.q var1) {
      return this.h(var1).getX();
   }

   public double n(y.c.q var1) {
      return this.h(var1).getY();
   }

   public y.d.t o(y.c.q var1) {
      am var2 = this.h(var1);
      return new y.d.t(var2.getX(), var2.getY());
   }

   public double p(y.c.q var1) {
      return this.h(var1).getWidth();
   }

   public double q(y.c.q var1) {
      return this.h(var1).getHeight();
   }

   public y.d.q r(y.c.q var1) {
      return new y.d.q(this.p(var1), this.q(var1));
   }

   public y.d.y s(y.c.q var1) {
      return new y.d.y(this.o(var1), this.r(var1));
   }

   public void a(y.c.q var1, y.d.t var2) {
      this.a(var1, var2.a(), var2.b());
   }

   public void a(y.c.q var1, double var2, double var4) {
      am var6 = this.h(var1);
      var6.setLocation(var2 - var6.getWidth() / 2.0D, var4 - var6.getHeight() / 2.0D);
   }

   public void b(y.c.q var1, double var2, double var4) {
      this.h(var1).setSize(var2, var4);
   }

   public void a(y.c.q var1, y.d.q var2) {
      this.b(var1, var2.a(), var2.b());
   }

   public void c(y.c.q var1, double var2, double var4) {
      this.h(var1).setLocation(var2, var4);
   }

   public void b(y.c.q var1, y.d.t var2) {
      this.c(var1, var2.a(), var2.b());
   }

   public void d(y.c.q var1, double var2, double var4) {
      am var6 = this.h(var1);
      var6.setLocation(var6.getX() + var2, var6.getY() + var4);
   }

   public y.d.v j(y.c.d var1) {
      boolean var5 = j;
      I var2 = this.g(var1);
      ArrayList var3 = new ArrayList(var2.pointCount());
      int var4 = 0;

      while(var4 < var2.pointCount()) {
         var3.add(var2.getPoint(var4));
         ++var4;
         if(var5) {
            break;
         }
      }

      return new y.d.v(var3);
   }

   public y.c.D k(y.c.d var1) {
      boolean var5 = j;
      I var2 = this.g(var1);
      y.c.D var3 = new y.c.D();
      int var4 = 0;

      y.c.D var10000;
      while(true) {
         if(var4 < var2.pointCount()) {
            var10000 = var3;
            if(var5) {
               break;
            }

            var3.add(var2.getPoint(var4));
            ++var4;
            if(!var5) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   public y.d.v l(y.c.d var1) {
      boolean var4 = j;
      ArrayList var2 = new ArrayList();
      var2.add(this.p(var1));
      y.d.u var3 = this.j(var1).b();

      while(true) {
         if(var3.f()) {
            var2.add(var3.d());
            var3.g();
            if(var4) {
               break;
            }

            if(!var4) {
               continue;
            }
         }

         var2.add(this.q(var1));
         break;
      }

      return new y.d.v(var2);
   }

   public y.c.D m(y.c.d var1) {
      boolean var4 = j;
      y.c.D var2 = new y.c.D();
      var2.add(this.p(var1));
      y.d.u var3 = this.j(var1).b();

      while(true) {
         if(var3.f()) {
            var2.add(var3.d());
            var3.g();
            if(var4) {
               break;
            }

            if(!var4) {
               continue;
            }
         }

         var2.add(this.q(var1));
         break;
      }

      return var2;
   }

   public void a(y.c.d var1, y.d.v var2) {
      boolean var7 = j;
      I var3 = this.g(var1);
      var3.clearPoints();
      y.d.u var4 = var2.b();
      y.d.t var5 = var4.a();
      this.c(var1, var5);
      y.d.t var6 = var2.d();
      var4.g();

      while(true) {
         if(var4.d() != var6) {
            var5 = var4.a();
            var3.addPoint(var5.a(), var5.b());
            var4.g();
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         this.d(var1, var6);
         break;
      }

   }

   public void a(y.c.d var1, y.c.D var2) {
      boolean var7 = j;
      I var3 = this.g(var1);
      var3.clearPoints();
      y.c.C var4 = var2.m();
      y.d.t var5 = (y.d.t)var4.d();
      this.c(var1, var5);
      y.d.t var6 = (y.d.t)var2.i();
      var4.g();

      while(true) {
         if(var4.d() != var6) {
            var5 = (y.d.t)var4.d();
            var3.addPoint(var5.a(), var5.b());
            var4.g();
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         this.d(var1, var6);
         break;
      }

   }

   public void b(y.c.d var1, y.d.v var2) {
      boolean var6 = j;
      I var3 = this.g(var1);
      var3.clearPoints();
      y.d.u var4 = var2.b();

      while(var4.f()) {
         y.d.t var5 = var4.a();
         var3.addPoint(var5.a(), var5.b());
         var4.g();
         if(var6) {
            break;
         }
      }

   }

   public void b(y.c.d var1, y.c.D var2) {
      boolean var6 = j;
      I var3 = this.g(var1);
      var3.clearPoints();
      y.c.p var4 = var2.k();

      while(var4 != null) {
         y.d.t var5 = (y.d.t)var4.c();
         var3.addPoint(var5.a(), var5.b());
         var4 = var4.a();
         if(var6) {
            break;
         }
      }

   }

   public void a(y.c.d var1, y.d.t var2, y.d.t var3) {
      this.c(var1, var2);
      this.d(var1, var3);
   }

   public y.d.t n(y.c.d var1) {
      return this.g(var1).getSourcePoint();
   }

   public y.d.t o(y.c.d var1) {
      return this.g(var1).getTargetPoint();
   }

   public void a(y.c.d var1, y.d.t var2) {
      this.g(var1).setSourcePoint(var2);
   }

   public void b(y.c.d var1, y.d.t var2) {
      this.g(var1).setTargetPoint(var2);
   }

   public y.d.t p(y.c.d var1) {
      y.d.t var2 = this.g(var1).getSourcePoint();
      if(var2 == null) {
         return this.l(var1.c());
      } else {
         y.d.t var3 = new y.d.t(this.j(var1.c()) + var2.a(), this.k(var1.c()) + var2.b());
         return var3;
      }
   }

   public y.d.t q(y.c.d var1) {
      y.d.t var2 = this.g(var1).getTargetPoint();
      if(var2 == null) {
         return this.l(var1.d());
      } else {
         y.d.t var3 = new y.d.t(this.j(var1.d()) + var2.a(), this.k(var1.d()) + var2.b());
         return var3;
      }
   }

   public void c(y.c.d var1, y.d.t var2) {
      y.d.t var3 = new y.d.t(var2.a() - this.j(var1.c()), var2.b() - this.k(var1.c()));
      this.g(var1).setSourcePoint(var3);
   }

   public void d(y.c.d var1, y.d.t var2) {
      y.d.t var3 = new y.d.t(var2.a() - this.j(var1.d()), var2.b() - this.k(var1.d()));
      this.g(var1).setTargetPoint(var3);
   }

   public y.c.f E() {
      return new y.c.f(this.p());
   }

   public Rectangle a() {
      boolean var12 = j;
      double var3 = Double.MAX_VALUE;
      double var1 = Double.MAX_VALUE;
      double var7 = -1.7976931348623157E308D;
      double var5 = -1.7976931348623157E308D;
      y.c.x var9 = this.o();

      X var10000;
      while(true) {
         if(var9.f()) {
            y.d.t var10 = this.o(var9.e());
            var10000 = this;
            if(var12) {
               break;
            }

            y.d.q var11 = this.r(var9.e());
            var1 = Math.min(var10.a(), var1);
            var3 = Math.min(var10.b(), var3);
            var5 = Math.max(var10.a() + var11.a(), var5);
            var7 = Math.max(var10.b() + var11.b(), var7);
            var9.g();
            if(!var12) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.c.e var13 = var10000.p();

      while(var13.f()) {
         y.c.C var14 = this.j(var13.a()).a();

         while(true) {
            if(var14.f()) {
               y.d.t var15 = (y.d.t)var14.d();
               var1 = Math.min(var15.a(), var1);
               var3 = Math.min(var15.b(), var3);
               var5 = Math.max(var15.a(), var5);
               var7 = Math.max(var15.b(), var7);
               var14.g();
               if(var12) {
                  break;
               }

               if(!var12) {
                  continue;
               }
            }

            var13.g();
            break;
         }

         if(var12) {
            break;
         }
      }

      if(var1 == Double.MAX_VALUE && var3 == Double.MAX_VALUE) {
         return new Rectangle(0, 0, -1, -1);
      } else {
         var1 = Math.floor(var1);
         var3 = Math.floor(var3);
         var5 = Math.ceil(var5);
         var7 = Math.ceil(var7);
         return new Rectangle((int)var1, (int)var3, (int)(var5 - var1), (int)(var7 - var3));
      }
   }
}
