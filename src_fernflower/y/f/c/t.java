package y.f.c;

import y.f.c.s;
import y.f.c.u;

class t implements s {
   private y.c.i b;
   private y.c.b c;

   public t(y.c.i var1) {
      this.b = var1;
      this.c = y.g.M.c();
      if(var1 != null) {
         var1.a(s.a, y.g.q.a((Object)this.c));
      }

   }

   public void a() {
      if(this.b != null) {
         this.b.d_(s.a);
         this.b = null;
      }

      this.c = null;
   }

   public void a(Object var1, Object var2) {
      this.a(var2, new u((byte)1, var1, 1));
   }

   public void a(Object var1, Object var2, int var3) {
      this.a(var2, new u((byte)1, var1, var3));
   }

   public void a(Object var1, Object var2, int var3, int var4) {
      this.a(var2, new u((byte)1, var1, var3, var4));
   }

   public void b(Object var1, Object var2, int var3) {
      this.a(var2, new u((byte)-1, var1, var3));
   }

   public void b(Object var1, Object var2, int var3, int var4) {
      this.a(var2, new u((byte)-1, var1, var3, var4));
   }

   public void b(Object var1, Object var2) {
      this.a(var2, new u((byte)0, var1, 0));
   }

   public void a(Object var1) {
      this.a(var1, new u((byte)2, (Object)null, 0));
   }

   public void b(Object var1) {
      this.a(var1, new u((byte)-2, (Object)null, 0));
   }

   private void a(Object var1, u var2) {
      y.c.D var3 = (y.c.D)this.c.b(var1);
      if(var3 == null) {
         var3 = new y.c.D();
         this.c.a(var1, var3);
      }

      var3.add(var2);
   }
}
