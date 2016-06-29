package y.f.i.a;

import y.f.i.a.M;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.aW;
import y.f.i.a.ab;
import y.f.i.a.ah;
import y.f.i.a.bC;
import y.f.i.a.g;
import y.f.i.a.w;

public class v {
   private final y.c.d b;
   private final R c;
   private P d;
   private P e;
   private final y.f.y f;
   private final y.f.y g;
   private int h;
   private int i;
   private final y.f.y[] j;
   private byte k = -1;
   private bC l;
   private y.c.D m;
   private ah n;
   private ah o;
   private aW p;
   y.c.D a;

   public v(y.c.d var1, R var2, P var3, P var4, y.f.y var5, y.f.y var6, int var7) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.f = var5;
      this.g = var6;
      this.i = var7;
      this.j = this.n();
   }

   bC a() {
      if(this.l == null) {
         this.l = new bC(this);
      }

      return this.l;
   }

   void a(w var1) {
      if(var1.c() != this.b) {
         throw new RuntimeException("edgeInfo does not match edge!");
      } else {
         double var2;
         if(this.d != null) {
            var2 = var1.a(this.i).e();
            this.d = new P(var2, var2, this.d.f(), this.d.a());
         }

         if(this.e != null) {
            var2 = var1.a(this.h).e();
            this.e = new P(var2, var2, this.e.f(), this.e.a());
         }

         this.l = new bC(this);
      }
   }

   private y.f.y[] n() {
      if(this.f == null) {
         return new y.f.y[]{this.g};
      } else if(this.g == null) {
         return new y.f.y[]{this.f};
      } else {
         y.f.y var1;
         if(this.f == this.g) {
            if(this.e.c(this.d)) {
               return new y.f.y[]{this.f};
            } else {
               var1 = a(this.d, this.f, this.e)?this.f.b():this.f.a();
               return new y.f.y[]{this.f, var1, this.g};
            }
         } else if(this.f.c() == this.g) {
            var1 = a(this.d, this.f, this.e)?this.f.b():this.f.a();
            return new y.f.y[]{this.f, var1, this.g};
         } else {
            return new y.f.y[]{this.f, this.g};
         }
      }
   }

   public String toString() {
      int var3 = ab.a;
      StringBuffer var1 = new StringBuffer();
      int var2 = 0;

      StringBuffer var10000;
      while(true) {
         if(var2 < this.j.length) {
            var10000 = var1.append(this.j[var2].toString());
            if(var3 != 0) {
               break;
            }

            ++var2;
            if(var3 == 0) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000.toString();
   }

   y.f.y[] b() {
      return this.j;
   }

   public byte c() {
      if(this.k == -1) {
         this.m();
      }

      return this.k;
   }

   public int d() {
      return this.i;
   }

   public void a(int var1) {
      this.i = var1;
   }

   public int e() {
      return this.h;
   }

   public void b(int var1) {
      this.h = var1;
   }

   public void a(ah var1) {
      this.n = var1;
      this.d = new P(var1.a(), this.d.f(), this.d.a());
      this.p = null;
   }

   public void b(ah var1) {
      this.o = var1;
      this.e = new P(var1.a(), this.e.f(), this.e.a());
      this.p = null;
   }

   aW f() {
      if(this.p == null && (this.n != null || this.o != null)) {
         this.p = new aW(this.n, this.o);
      }

      return this.p;
   }

   public y.c.d g() {
      return this.b;
   }

   public R h() {
      return this.c;
   }

   public P i() {
      return this.d;
   }

   public P j() {
      return this.e;
   }

   public y.f.y k() {
      return this.f;
   }

   public y.f.y l() {
      return this.g;
   }

   public y.c.D m() {
      if(this.m == null) {
         this.m = this.o();
      }

      return this.m;
   }

   private y.c.D o() {
      int var12 = ab.a;
      y.c.D var1 = new y.c.D();
      int var2 = this.i;
      if(this.d != null && this.e != null) {
         label48: {
            M var3;
            M var4;
            if(this.d.a() == this.e.a()) {
               var3 = M.b(this.d.e(), this.e.e());
               var4 = this.f.e()?new M(this.c.i(), this.c.k()):new M(this.c.h(), this.c.j());
               M var5 = M.c(this.d.e(), this.e.e());
               boolean var6 = this.f != this.g;
               boolean var7 = !this.e.e().c(this.d.e());
               g var8;
               if(var6 || var7) {
                  this.k = (byte)(var6?3:1);
                  var8 = new g(this.b, var2, this.f, this.d.e(), new M(this.d.f(), this.d.f()), var4, this.c);
                  var1.add(var8);
                  ++var2;
                  y.f.y var9 = a(this.d, this.f, this.e)?this.f.b():this.f.a();
                  g var10 = new g(this.b, var2, var9, var4, var5, var3, this.c);
                  var1.add(var10);
                  ++var2;
                  g var11 = new g(this.b, var2, this.g, this.e.e(), new M(this.e.f(), this.e.f()), var4, this.c);
                  var1.add(var11);
                  if(var12 == 0) {
                     break label48;
                  }
               }

               this.k = 0;
               var8 = new g(this.b, var2, this.f, this.e.e(), var4, var4, this.c);
               var1.add(var8);
               if(var12 == 0) {
                  break label48;
               }
            }

            this.k = 2;
            var3 = M.d(this.e.e(), this.d.f());
            var4 = new M(this.d.f(), this.e.e().c(this.d.f()));
            g var13 = new g(this.b, var2, this.f, this.d.e(), var4, var3, this.c);
            var1.add(var13);
            ++var2;
            var3 = M.d(this.d.e(), this.e.f());
            var4 = new M(this.e.f(), this.d.e().c(this.e.f()));
            g var14 = new g(this.b, var2, this.g, this.e.e(), var4, var3, this.c);
            var1.add(var14);
         }

         this.b(var2);
         return var1;
      } else {
         this.b(var2);
         this.k = 4;
         return var1;
      }
   }

   private static boolean a(P var0, y.f.y var1, P var2) {
      double var3 = var0.e().c();
      double var5 = var2.e().c();
      return y.f.y.c != var1 && y.f.y.d != var1?var3 > var5:var3 <= var5;
   }
}
