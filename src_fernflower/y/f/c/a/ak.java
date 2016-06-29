package y.f.c.a;

import java.util.Collection;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.N;
import y.f.c.a.ao;

class ak extends ao {
   y.f.aE a;
   y.f.aE b;
   Collection c;
   Collection d;
   Object e;
   Object f;
   y.c.d g;

   ak(y.c.d var1, B var2, y.f.aE var3, Collection var4, y.f.aE var5, Collection var6) {
      this(var1, var2, var3, var4, var5, var6, (Object)null, (Object)null);
   }

   ak(y.c.d var1, B var2, y.f.aE var3, Collection var4, y.f.aE var5, Collection var6, Object var7, Object var8) {
      super(var2);
      this.g = var1;
      this.d = var6;
      this.c = var4;
      this.a = var3;
      this.b = var5;
      this.e = var7;
      this.f = var8;
   }

   public Object g() {
      return this.i?this.f:this.e;
   }

   public Object h() {
      return this.i?this.e:this.f;
   }

   public y.c.d b() {
      return this.g;
   }

   public y.f.aE c() {
      return this.i?this.b:this.a;
   }

   public Collection d() {
      return this.i?this.d:this.c;
   }

   public y.f.aE e() {
      return this.i?this.a:this.b;
   }

   public Collection f() {
      return this.i?this.c:this.d;
   }

   public boolean j() {
      y.f.aE var1 = this.c();
      y.f.aE var2 = this.e();
      if(var1 != null) {
         if(var1.c()) {
            return true;
         }

         if(var1.d()) {
            return false;
         }
      }

      if(var2 != null) {
         if(var2.c()) {
            return true;
         }

         if(var2.d()) {
            return false;
         }
      }

      return this.l();
   }

   public A a(boolean var1, y.f.aE var2) {
      boolean var3 = N.x;
      if(var1) {
         if(this.i) {
            this.b = var2;
            if(!var3) {
               return this;
            }
         }

         this.a = var2;
         if(!var3) {
            return this;
         }
      }

      if(this.i) {
         this.a = var2;
         if(!var3) {
            return this;
         }
      }

      this.b = var2;
      return this;
   }
}
