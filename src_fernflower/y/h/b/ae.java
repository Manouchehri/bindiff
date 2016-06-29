package y.h.b;

import java.awt.Cursor;
import java.awt.geom.Rectangle2D;
import y.h.bu;
import y.h.cW;
import y.h.ch;
import y.h.dw;
import y.h.eD;
import y.h.eF;
import y.h.fj;
import y.h.b.a;
import y.h.b.aa;
import y.h.b.c;
import y.h.b.f;

abstract class ae extends y.h.c implements eF {
   ch h;
   a i;

   public void a(ch var1, eD var2, fj var3) {
      if(var3 instanceof a) {
         this.h = var1;
         this.i = (a)var3;
         if(a.H == 0) {
            return;
         }
      }

      this.h = null;
      this.i = null;
   }

   public Cursor c(dw var1) {
      return null;
   }

   public void e() {
      this.i();
      super.e();
   }

   void i() {
      this.h = null;
      this.i = null;
   }

   boolean e(dw var1) {
      return var1.e() == 1;
   }

   boolean f(dw var1) {
      return var1.c() == 501 && this.e(var1);
   }

   boolean g(dw var1) {
      return var1.c() == 500 && var1.f() == 1 && this.e(var1);
   }

   boolean h(dw var1) {
      return var1.c() == 500 && var1.f() == 2 && this.e(var1);
   }

   boolean a(a var1, c var2, double var3, double var5, boolean var7) {
      if(var7 && var2.k() == 0) {
         double var11 = var1.l().c(0).h().getY();
         Rectangle2D var10 = var2.h();
         if(var11 > var10.getY()) {
            var10.setFrame(var10.getX(), var10.getY(), var10.getWidth(), var11 - var10.getY());
            return var10.contains(var3, var5);
         }
      } else {
         y.d.r var8 = var2.i();
         if(var8.a > 0.0D) {
            Rectangle2D var9 = var2.h();
            var9.setFrame(var9.getX(), var9.getY(), var9.getWidth(), var8.a);
            return var9.contains(var3, var5);
         }
      }

      return false;
   }

   boolean a(a var1, f var2, double var3, double var5, boolean var7) {
      if(var7 && var2.n() == 0) {
         double var11 = var1.l().b(0).h().getX();
         Rectangle2D var10 = var2.h();
         if(var11 > var10.getX()) {
            var10.setFrame(var10.getX(), var10.getY(), var11 - var10.getX(), var10.getHeight());
            return var10.contains(var3, var5);
         }
      } else {
         y.d.r var8 = var2.i();
         if(var8.b > 0.0D) {
            Rectangle2D var9 = var2.h();
            var9.setFrame(var9.getX(), var9.getY(), var8.b, var9.getHeight());
            return var9.contains(var3, var5);
         }
      }

      return false;
   }

   y.c.q a(cW var1) {
      return var1.t()?var1.i():(var1.s()?var1.l().f():null);
   }

   static fj a(bu var0, y.c.q var1) {
      return aa.a(var0, var1);
   }
}
