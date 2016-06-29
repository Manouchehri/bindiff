package y.f.i;

import y.f.i.R;
import y.f.i.v;

class W extends R {
   private y.c.q a;
   private y.d.m b;

   W(y.c.q var1, byte var2) {
      super((byte)1, 0.0D);
      this.a = var1;
      y.f.am var3 = ((y.f.X)var1.e()).a((Object)var1);
      y.d.t var4 = new y.d.t(var3.getX(), var3.getY());
      y.d.t var5 = new y.d.t(var3.getX() + var3.getWidth(), var3.getY());
      y.d.t var6 = new y.d.t(var3.getX(), var3.getY() + var3.getHeight());
      y.d.t var7 = new y.d.t(var3.getX() + var3.getWidth(), var3.getY() + var3.getHeight());
      if(var2 == 0) {
         this.a((byte)1);
         this.b = new y.d.m(var5, var7);
         this.a(this.b.c().a());
         if(v.f == 0) {
            return;
         }
      }

      if(var2 == 1) {
         this.a((byte)2);
         this.b = new y.d.m(var4, var6);
         this.a(this.b.c().a());
      }

   }

   public y.c.q a() {
      return this.a;
   }

   public y.d.m b() {
      return this.b;
   }

   public String toString() {
      return "Node: " + this.a().d() + ", Side: " + (this.k() == 1?"EAST":"WEST");
   }
}
