package y.f.i;

import y.f.i.R;

class Q extends R {
   private y.d.m a;
   private y.c.d b;
   private boolean c;
   private int d;
   private final boolean e;
   private final boolean f;

   public Q(byte var1, y.d.m var2, y.c.d var3, boolean var4, int var5, boolean var6, boolean var7) {
      super(var1, var2.c().a());
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var6;
      this.f = var7;
   }

   public y.d.m a() {
      return this.a;
   }

   private boolean l() {
      return this.g() > 0;
   }

   public boolean b() {
      y.c.D var1 = ((y.f.X)this.e().a()).m(this.b);
      if(this.l()) {
         y.c.p var2 = var1.b(this.g() - 1);
         y.d.t var3 = (y.d.t)var2.c();
         y.c.p var4 = var1.b(this.g());
         y.d.t var5 = (y.d.t)var4.c();
         return var3.a() <= var5.a();
      } else {
         return !this.m() || this.c();
      }
   }

   private boolean m() {
      y.c.D var1 = ((y.f.X)this.e().a()).m(this.b);
      return this.g() < var1.size() - 2;
   }

   public boolean c() {
      y.c.D var1 = ((y.f.X)this.e().a()).m(this.b);
      if(this.m()) {
         y.c.p var2 = var1.b(this.g() + 1);
         y.d.t var3 = (y.d.t)var2.c();
         y.c.p var4 = var1.b(this.g() + 2);
         y.d.t var5 = (y.d.t)var4.c();
         return var3.a() > var5.a();
      } else {
         return !this.l() || this.b();
      }
   }

   public boolean d() {
      return this.l() && this.m()?this.l() && this.m() && this.b() != this.c():true;
   }

   public y.c.d e() {
      return this.b;
   }

   public boolean f() {
      return this.c;
   }

   public int g() {
      return this.d;
   }

   public String toString() {
      return "Edge: " + this.b.c() + " -> " + this.b.d() + ", " + (this.f()?"locked":"unlocked") + " segment " + this.g() + ", " + this.a.toString();
   }

   public boolean h() {
      return this.e;
   }

   public boolean i() {
      return this.f;
   }

   static y.c.d a(Q var0) {
      return var0.b;
   }
}
