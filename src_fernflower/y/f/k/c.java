package y.f.k;

import y.f.k.A;
import y.f.k.I;
import y.f.k.K;
import y.f.k.d;
import y.f.k.x;

public abstract class c implements Cloneable, I {
   private y.c.c b;
   private y.c.c c;
   protected y.f.X a;

   public K a(x var1, y.f.X var2, y.c.q var3) {
      return null;
   }

   protected A b(y.c.q var1) {
      return (A)this.b.b(var1);
   }

   protected A c(y.c.q var1) {
      return (A)this.c.b(var1);
   }

   public void a(y.c.q var1, y.c.b var2) {
      int var7 = d.g;
      this.a = (y.f.X)var1.e();
      boolean var9 = false;

      try {
         var9 = true;
         y.c.d var3 = var1.f();

         while(true) {
            if(var3 == null) {
               var9 = false;
               break;
            }

            y.c.q var4 = var3.d();
            byte var5 = this.a(var4);
            var2.a(var4, var5);
            var3 = var3.g();
            if(var7 != 0) {
               var9 = false;
               return;
            }

            if(var7 != 0) {
               var9 = false;
               break;
            }
         }
      } finally {
         if(var9) {
            this.a = null;
         }
      }

      this.a = null;
   }

   protected abstract byte a(y.c.q var1);

   protected abstract A a(y.c.q var1, byte var2);

   public A a(y.c.c var1, y.c.c var2, y.f.X var3, y.c.q var4, byte var5) {
      this.b = var2;
      this.c = var1;
      this.a = var3;

      A var6;
      try {
         var6 = this.a(var4, var5);
      } finally {
         var2 = null;
         var1 = null;
         var3 = null;
      }

      return var6;
   }

   public Object clone() {
      try {
         return super.clone();
      } catch (CloneNotSupportedException var2) {
         throw new RuntimeException(var2.toString());
      }
   }
}
