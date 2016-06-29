package y.g;

import y.g.aq;
import y.g.p;

public class ap implements y.c.c {
   private y.c.c a;
   private Object b;
   private y.c.i c;
   private y.c.c d;
   private y.c.b e;

   public ap(y.c.c var1, y.c.i var2, Object var3) {
      this.d = var1;
      this.c(var2, var3);
      this.a(var1);
   }

   public y.c.b a() {
      if(this.e == null) {
         throw new IllegalStateException("wrapper must be of type DataAcceptor");
      } else {
         return this.e;
      }
   }

   private void a(y.c.c var1) {
      if(var1 instanceof y.c.a) {
         this.e = new aq(this);
      }

   }

   public static ap a(y.c.i var0, Object var1) {
      return new ap(var0.u(), var0, var1);
   }

   public static ap b(y.c.i var0, Object var1) {
      return new ap(var0.t(), var0, var1);
   }

   public void c(y.c.i var1, Object var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Key must be non-null!");
      } else {
         this.a = var1.c(var2);
         this.b = var2;
         this.c = var1;
         if(this.a != null) {
            var1.d_(var2);
            var1.a((Object)var2, (y.c.c)this);
            if(!p.c) {
               return;
            }
         }

         var1.a(var2, this.d);
      }
   }

   public void b() {
      if(this.b == null) {
         throw new IllegalStateException("Provider must have been wrapped previously!");
      } else {
         y.c.c var1 = this.c.c(this.b);
         if(var1 != null) {
            this.c.d_(this.b);
         }

         if(this.a != null) {
            this.c.a(this.b, this.a);
         }

      }
   }

   public Object b(Object var1) {
      Object var2 = this.d.b(var1);
      return var2 != null?var2:(this.a != null?this.a.b(var1):null);
   }

   public boolean d(Object var1) {
      throw new UnsupportedOperationException("Object supported only!");
   }

   public double c(Object var1) {
      throw new UnsupportedOperationException("Object supported only!");
   }

   public int a(Object var1) {
      throw new UnsupportedOperationException("Object supported only!");
   }

   public y.c.c c() {
      return this.a;
   }

   public y.c.c d() {
      return this.d;
   }

   public void e() {
      this.b();
      if(this.d instanceof y.c.A) {
         this.c.a((y.c.A)this.d);
      }

      if(this.d instanceof y.c.h) {
         this.c.a((y.c.h)this.d);
      }

      this.d = null;
      this.a = null;
      this.c = null;
   }

   static y.c.c a(ap var0) {
      return var0.a;
   }

   static y.c.c b(ap var0) {
      return var0.d;
   }
}
