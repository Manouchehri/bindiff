package y.f.c.a;

import java.util.Collection;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.N;
import y.f.c.a.ai;
import y.f.c.a.ak;

class aL implements ai {
   final y.c.d a;
   final A b;

   aL(y.c.d var1, A var2) {
      this.a = var1;
      this.b = var2;
   }

   public B k() {
      return this.b.k();
   }

   public y.c.d b() {
      return this.a;
   }

   public y.f.aE c() {
      return null;
   }

   public Collection d() {
      return null;
   }

   public Object g() {
      return null;
   }

   public y.f.aE e() {
      return null;
   }

   public Collection f() {
      return null;
   }

   public Object h() {
      return null;
   }

   public byte a() {
      return (byte)0;
   }

   public boolean i() {
      return this.b.i();
   }

   public boolean j() {
      return this.l();
   }

   public void b(boolean var1) {
      throw new UnsupportedOperationException();
   }

   public A a(boolean var1, y.f.aE var2) {
      ak var3;
      label33: {
         if(this.i()) {
            var3 = new ak(this.b(), this.k(), var1?null:var2, this.f(), var1?var2:null, this.d());
            var3.b(true);
            if(!N.x) {
               break label33;
            }
         }

         var3 = new ak(this.b(), this.k(), var1?var2:null, this.d(), var1?null:var2, this.f());
      }

      var3.a(this.l());
      return var3;
   }

   public void a(boolean var1) {
      this.b.a(var1);
   }

   public boolean l() {
      return this.b.l();
   }
}
