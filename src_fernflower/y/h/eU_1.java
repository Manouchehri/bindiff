package y.h;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.HashSet;
import java.util.Iterator;
import y.h.aB;
import y.h.bu;
import y.h.eR;
import y.h.eV;
import y.h.eY;
import y.h.fM;
import y.h.fP;
import y.h.fe;
import y.h.fj;
import y.h.fm;
import y.h.gd;
import y.h.gq;
import y.h.hk;

public class eU {
   private static final eY f = new eY((eV)null);
   private static final gq g = new gq();
   fj a = null;
   fP b;
   fe c;
   boolean d;
   Object e;

   public eU() {
      this.b = fm.a;
      this.c = j().a();
      this.d = false;
      this.e = null;
   }

   public eU(eU var1) {
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
      if(this.c.g == null) {
         this.e = var1.e;
         if(!fj.z) {
            return;
         }
      }

      this.e = this.c.g.a(var1, var1.e, this);
   }

   public eU a() {
      return this.a(this);
   }

   public eU a(eU var1) {
      return new eU(var1);
   }

   protected void a(fj var1) {
      this.a = var1;
   }

   public fj b() {
      return this.a;
   }

   public void a(aB var1) {
      a(this, var1);
   }

   public static void a(eU var0, aB var1) {
      boolean var3 = fj.z;
      if(var0 == null) {
         var1.vb = null;
         if(!var3) {
            return;
         }
      }

      Object var2 = d(var0);
      if(var2 == null) {
         throw new IllegalArgumentException("NodePort not in NodeRealizer.");
      } else {
         var1.vb = var2;
         var1.setSourcePoint(b(var0));
         if(var3) {
            throw new IllegalArgumentException("NodePort not in NodeRealizer.");
         }
      }
   }

   public static eU b(aB var0) {
      return a(var0, true);
   }

   public void c(aB var1) {
      b(this, var1);
   }

   public static void b(eU var0, aB var1) {
      boolean var3 = fj.z;
      if(var0 == null) {
         var1.zb = null;
         if(!var3) {
            return;
         }
      }

      Object var2 = d(var0);
      if(var2 == null) {
         throw new IllegalArgumentException("NodePort not in NodeRealizer.");
      } else {
         var1.zb = var2;
         var1.setTargetPoint(b(var0));
         if(var3) {
            throw new IllegalArgumentException("NodePort not in NodeRealizer.");
         }
      }
   }

   public static eU d(aB var0) {
      return a(var0, false);
   }

   private static eU a(aB var0, boolean var1) {
      Object var2 = var1?var0.vb:var0.zb;
      if(var2 != null) {
         bu var3 = var0.i();
         if(var3 != null) {
            fj var4 = var1?var0.getSourceRealizer():var0.getTargetRealizer();
            return var4.b(var2);
         }
      }

      return null;
   }

   public y.c.e c() {
      return this.a(true, true).a();
   }

   public y.c.e d() {
      return this.a(true, false).a();
   }

   public y.c.e e() {
      return this.a(false, true).a();
   }

   private y.c.f a(boolean var1, boolean var2) {
      y.c.f var3 = new y.c.f();
      fj var4 = this.b();
      if(var4 != null) {
         Object var5 = d(this);
         y.c.q var6 = var4.getNode();
         if(var6 != null && var6.a() > 0 && var6.e() != null) {
            bu var7 = var4.d();
            HashSet var8 = new HashSet();
            y.c.e var9;
            aB var10;
            if(var1) {
               for(var9 = var6.k(); var9.f(); var9.g()) {
                  var10 = var7.i(var9.a());
                  if(var5 == var10.zb && var8.add(var9.a())) {
                     var3.add(var9.a());
                  }
               }
            }

            if(var2) {
               for(var9 = var6.l(); var9.f(); var9.g()) {
                  var10 = var7.i(var9.a());
                  if(var5 == var10.vb && var8.add(var9.a())) {
                     var3.add(var9.a());
                  }
               }
            }
         }
      }

      return var3;
   }

   public boolean f() {
      return this.d;
   }

   public void a(boolean var1) {
      if(this.d != var1) {
         this.d = var1;
         fj var2 = this.b();
         if(var2 != null) {
            bu var3 = var2.d();
            if(var3 != null) {
               var3.e(this);
            }
         }

         if(this.c.f != null) {
            this.c.f.a(this);
         }
      }

   }

   public fP g() {
      return this.b;
   }

   public void a(fP var1) {
      this.b = var1;
      this.i();
   }

   public y.d.t h() {
      fP var1 = this.g();
      return var1.a().a(this, var1);
   }

   void i() {
      if(d(this) != null) {
         this.l();
         this.m();
      }

   }

   private void l() {
      Iterator var1 = fM.a(this).iterator();

      while(var1.hasNext()) {
         ((eR)var1.next()).setOffsetDirty();
      }

   }

   private void m() {
      bu var1 = this.b().d();
      if(var1 != null) {
         y.d.t var2 = b(this);
         y.c.e var3 = this.e();

         aB var4;
         while(var3.f()) {
            var4 = var1.i(var3.a());
            var4.setSourcePoint(var2);
            var3.g();
         }

         var3 = this.d();

         while(var3.f()) {
            var4 = var1.i(var3.a());
            var4.setTargetPoint(var2);
            var3.g();
         }
      }

   }

   public static eY j() {
      return f;
   }

   static eU a(bu var0, y.c.d var1, boolean var2) {
      return a(var0.i(var1), var2);
   }

   static y.d.t b(eU var0) {
      y.d.t var1 = var0.h();
      fj var2 = var0.b();
      return new y.d.t(var1.a() - var2.getCenterX(), var1.b() - var2.getCenterY());
   }

   static void a(eU var0, y.d.t var1) {
      a(var0, var1.a(), var1.b());
   }

   static void a(eU var0, double var1, double var3) {
      fj var5 = var0.b();
      b(var0, var5.getCenterX() + var1, var5.getCenterY() + var3);
   }

   static void b(eU var0, double var1, double var3) {
      fP var5 = var0.g();
      var0.a(var5.a().a(var0.b(), new y.d.t(var1, var3)));
   }

   static Rectangle2D c(eU var0) {
      y.d.y var1 = var0.k();
      return new Double(var1.c(), var1.d(), var1.a(), var1.b());
   }

   static Object d(eU var0) {
      fj var1 = var0.b();
      return var1 == null?null:var1.c(var0);
   }

   static int e(eU var0) {
      boolean var4 = fj.z;
      fj var1 = var0.b();
      if(var1 != null) {
         int var2 = 0;
         Iterator var3 = var1.ports();

         while(var3.hasNext()) {
            if(var3.next() == var0) {
               return var2;
            }

            ++var2;
            if(var4) {
               break;
            }
         }
      }

      return -1;
   }

   static eU a(fj var0, double var1, double var3) {
      boolean var14 = fj.z;
      eU var5 = null;
      int var6 = var0.portCount();
      eU var15;
      if(var6 > 0) {
         double var7 = java.lang.Double.POSITIVE_INFINITY;
         int var9 = var6;

         while(var9-- > 0) {
            eU var10 = var0.getPort(var9);
            y.d.t var11 = var10.h();
            double var12 = a(var11.a(), var11.b(), var1, var3);
            if(var7 > var12) {
               var7 = var12;
               var15 = var10;
               if(var14) {
                  return var15;
               }

               var5 = var10;
               if(var14) {
                  break;
               }
            }
         }
      }

      var15 = var5;
      return var15;
   }

   static double a(double var0, double var2, double var4, double var6) {
      double var8 = var0 - var4;
      double var10 = var2 - var6;
      return var8 * var8 + var10 * var10;
   }

   static boolean a(eU var0, fj var1) {
      return a(var0.b(), var1);
   }

   static boolean a(fj var0, fj var1) {
      return var0 == var1 || var1 instanceof gd && var0 == ((gd)var1).e();
   }

   public boolean a(double var1, double var3) {
      return this.c.c == null?g.a(this, var1, var3):this.c.c.a(this, var1, var3);
   }

   public boolean a(double var1, double var3, double var5, double var7, Point2D var9) {
      return this.c.d == null?g.a(this, var1, var3, var5, var7, var9):this.c.d.a(this, var1, var3, var5, var7, var9);
   }

   public void a(Graphics2D var1) {
      if(this.c.b == null) {
         g.a(this, var1);
         if(!fj.z) {
            return;
         }
      }

      this.c.b.a(this, var1);
   }

   public y.d.y k() {
      return this.c.e == null?g.a(this):this.c.e.a(this);
   }

   public void a(Rectangle2D var1) {
      if(this.c.h == null) {
         g.a(this, var1);
         if(!fj.z) {
            return;
         }
      }

      this.c.h.a(this, var1);
   }

   static boolean a(eU var0, Graphics2D var1) {
      return var0.f() && hk.b(var1);
   }
}
