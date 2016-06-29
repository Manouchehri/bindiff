package y.f.c.a;

import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.bt;
import y.f.c.a.dk;
import y.f.c.a.dn;

final class do implements aQ {
   int a;
   y.c.y b;
   byte c;
   y.c.f d;
   private final dn e;

   public void a() {
      if(this.a < 0) {
         throw new IllegalStateException();
      } else {
         this.e.b(this.c());
      }
   }

   public do(dn var1, byte var2, int var3) {
      this.e = var1;
      this.b = new y.c.y();
      this.d = new y.c.f();
      this.a = var3;
      this.c = var2;
   }

   public void a(y.c.q var1) {
      dk var2 = (dk)this.e.b.a(var1);
      var2.a(this);
      var2.b(this.b.size());
      this.b.add(var1);
   }

   public int c() {
      if(this.e.c) {
         this.e.c();
      }

      return this.a;
   }

   public bt b() {
      return null;
   }

   public void a(bt var1) {
   }

   public y.c.y d() {
      return this.b;
   }

   public byte e() {
      return this.c;
   }

   public void a(y.c.D var1) {
      boolean var7 = N.x;
      if(var1.size() != this.b.size()) {
         throw new IllegalArgumentException();
      } else {
         y.c.p var2 = var1.k();
         y.c.p var3 = this.b.k();
         int var4 = 0;

         while(var2 != null) {
            y.c.q var5 = (y.c.q)var2.c();
            var3.a(var5);
            dk var6 = (dk)this.e.b.a(var5);
            var6.b(var4);
            ++var4;
            var2 = var2.a();
            var3 = var3.a();
            if(var7) {
               break;
            }
         }

      }
   }

   public void b(y.c.q var1) {
      boolean var6 = N.x;
      int var2 = 0;
      y.c.p var3 = this.b.k();

      while(var3 != null) {
         label17: {
            y.c.q var4 = (y.c.q)var3.c();
            if(var4 == var1) {
               this.b.h(var3);
               if(!var6) {
                  break label17;
               }
            }

            dk var5 = (dk)this.e.b.a(var4);
            var5.b(var2);
            ++var2;
         }

         var3 = var3.a();
         if(var6) {
            break;
         }
      }

   }

   public y.c.D f() {
      return this.d;
   }

   public void a(y.c.d var1) {
      this.d.add(var1);
   }
}
