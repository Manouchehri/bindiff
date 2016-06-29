package y.f.c.a;

import java.util.Collection;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.N;
import y.f.c.a.ai;
import y.f.c.a.ak;

class ao implements ai {
   boolean h;
   boolean i;
   final B j;

   public void a(boolean var1) {
      this.h = var1;
   }

   public boolean l() {
      return this.h;
   }

   ao(B var1) {
      this.j = var1;
   }

   public B k() {
      return this.j;
   }

   public y.c.d b() {
      return null;
   }

   public Object g() {
      return null;
   }

   public Object h() {
      return null;
   }

   public byte a() {
      return (byte)0;
   }

   public boolean i() {
      return this.i;
   }

   public void b(boolean var1) {
      this.i = var1;
   }

   public y.f.aE c() {
      return null;
   }

   public Collection d() {
      return null;
   }

   public y.f.aE e() {
      return null;
   }

   public Collection f() {
      return null;
   }

   public boolean j() {
      return this.l();
   }

   public A a(boolean var1, y.f.aE var2) {
      ak var3;
      if(this.i()) {
         var3 = new ak(this.b(), this.k(), var1?null:var2, this.f(), var1?var2:null, this.d());
         var3.b(true);
         if(!N.x) {
            return var3;
         }
      }

      var3 = new ak(this.b(), this.k(), var1?var2:null, this.d(), var1?null:var2, this.f());
      return var3;
   }
}
