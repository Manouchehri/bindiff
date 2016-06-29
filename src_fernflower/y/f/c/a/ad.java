package y.f.c.a;

import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.ac;
import y.f.c.a.as;
import y.f.c.a.bt;

final class ad implements aQ {
   bt a;
   int b;
   y.c.y c;
   byte d;
   y.c.f e;
   private final ac f;

   public void a() {
      if(this.b < 0) {
         throw new IllegalStateException();
      } else {
         this.f.b(this.c());
      }
   }

   public ad(ac var1, byte var2, int var3) {
      this.f = var1;
      this.a = null;
      this.c = new y.c.y();
      this.e = new y.c.f();
      this.b = var3;
      this.d = var2;
   }

   public bt b() {
      return this.a;
   }

   public void a(bt var1) {
      this.a = var1;
   }

   public void a(y.c.q var1) {
      as var2 = (as)this.f.b.a(var1);
      var2.a((aQ)this);
      var2.b(this.c.size());
      this.c.add(var1);
   }

   public int c() {
      if(this.f.c) {
         this.f.c();
      }

      return this.b;
   }

   public y.c.y d() {
      return this.c;
   }

   public byte e() {
      return this.d;
   }

   public void a(y.c.D var1) {
      boolean var7 = N.x;
      if(var1.size() != this.c.size()) {
         throw new IllegalArgumentException();
      } else {
         y.c.p var2 = var1.k();
         y.c.p var3 = this.c.k();
         int var4 = 0;

         while(var2 != null) {
            y.c.q var5 = (y.c.q)var2.c();
            var3.a(var5);
            as var6 = (as)this.f.b.a(var5);
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
      y.c.p var3 = this.c.k();

      while(var3 != null) {
         label17: {
            y.c.q var4 = (y.c.q)var3.c();
            if(var4 == var1) {
               this.c.h(var3);
               if(!var6) {
                  break label17;
               }
            }

            as var5 = (as)this.f.b.a(var4);
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
      return this.e;
   }

   public void a(y.c.d var1) {
      this.e.add(var1);
   }
}
