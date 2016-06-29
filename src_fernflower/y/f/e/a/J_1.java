package y.f.e.a;

import y.f.e.a.K;
import y.f.e.a.L;
import y.f.e.a.M;
import y.f.e.a.N;
import y.f.e.a.O;
import y.f.e.a.P;
import y.f.e.a.Q;
import y.f.e.a.R;
import y.f.e.a.S;
import y.f.e.a.T;
import y.f.e.a.U;
import y.f.e.a.V;
import y.f.e.a.W;
import y.f.e.a.X;
import y.f.e.a.Y;
import y.f.e.a.a;
import y.f.e.a.ax;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;

public class J implements ax {
   public static final Y a = new R();
   public static final Y b = new V();
   public static final Y c = new Q();
   public static final Y d = new K();
   public static final Y e = new W();
   public static final Y f = new T();
   public static final Y g = new X();
   public static final Y h = new L();
   public static final Y i = new M();
   public static final Y j = new S();
   public static final Y k = new N();
   public static final Y l = new O();
   public static final Y m = new U();
   public static final Y n = new P();
   public static final Y[] o;
   private final double s;
   private final double t;
   protected ax p;
   protected Y q;
   protected Y r;
   private final double u;
   private double v;

   public J(ax var1, Y var2, double var3, double var5) {
      this.r = c;
      this.v = 1.0D;
      this.p = var1;
      this.q = var2;
      this.t = var3;
      this.s = var5;
      this.u = var5 - var3;
      if(this.u == 0.0D) {
         throw new IllegalArgumentException("Length must not be 0");
      }
   }

   public void a(Y var1) {
      this.r = var1;
   }

   public k a(m var1, l var2, a var3) {
      if(this.a(var2)) {
         return var3;
      } else {
         a var4 = (a)this.p.a(var1, var2, var3);
         this.a(var4);
         this.a(var2, var4);
         return var4;
      }
   }

   private void a(l var1, a var2) {
      var2.d(this.b(var1.a()));
   }

   private boolean a(l var1) {
      return this.r.b(var1.a()) || this.v == 0.0D;
   }

   void a(a var1) {
      if(this.v == 0.0D) {
         var1.a();
      } else {
         double var2 = var1.c();
         if(var2 != 0.0D) {
            double var4 = this.a(var2);
            if(var4 == 0.0D) {
               var1.a();
            } else {
               double var6 = var4 * this.v / var2;
               var1.a(var1.d() * var6);
               var1.b(var1.e() * var6);
               var1.c(var1.f() * var6);
            }
         }
      }
   }

   double a(double var1) {
      return this.q.a((var1 - this.t) / this.u);
   }

   double b(double var1) {
      return this.r.a(var1);
   }

   public double a() {
      return this.v;
   }

   public void c(double var1) {
      this.v = var1;
   }

   public ax b() {
      return this.p;
   }

   public String toString() {
      return "WeightedCalculator{coreCalculator=" + this.p + ", factor=" + this.v + ", model=" + this.q + ", timeModel=" + this.r + "}";
   }

   static {
      o = new Y[]{c, a, b, h, i, d, e, f, g, j, k, l, m, n};
   }
}
