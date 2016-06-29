package y.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y.c.C;
import y.c.D;
import y.d.m;
import y.d.s;
import y.d.t;
import y.d.u;
import y.d.w;
import y.d.x;

public final class v {
   public static final v a = new v();
   D b;

   public v() {
      this.b = new D();
   }

   public v(List var1) {
      boolean var3 = t.d;
      super();
      this.b = new D();
      if(var1 != null && !var1.isEmpty()) {
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            this.b.add(var2.next());
            if(var3) {
               break;
            }
         }
      }

   }

   public v(t[] var1) {
      if(var1 == null) {
         this.b = new D();
         if(!t.d) {
            return;
         }
      }

      this.b = new D(var1);
   }

   public C a() {
      return this.b.m();
   }

   public u b() {
      return new w(this.b.m());
   }

   public t c() {
      return (t)this.b.f();
   }

   public t d() {
      return (t)this.b.i();
   }

   public List e() {
      boolean var3 = t.d;
      ArrayList var1 = new ArrayList(this.b.size());
      C var2 = this.a();

      ArrayList var10000;
      while(true) {
         if(var2.f()) {
            var10000 = var1;
            if(var3) {
               break;
            }

            var1.add(var2.d());
            var2.g();
            if(!var3) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   public t[] f() {
      boolean var4 = t.d;
      t[] var1 = new t[this.b.size()];
      int var2 = 0;
      C var3 = this.a();

      t[] var10000;
      while(true) {
         if(var3.f()) {
            var10000 = var1;
            if(var4) {
               break;
            }

            var1[var2++] = (t)var3.d();
            var3.g();
            if(!var4) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   public v g() {
      boolean var3 = t.d;
      ArrayList var1 = new ArrayList();
      C var2 = this.a();

      while(var2.f()) {
         var1.add(0, var2.d());
         var2.g();
         if(var3) {
            break;
         }
      }

      return new v(var1);
   }

   public int h() {
      return this.b.size();
   }

   public int i() {
      int var1 = this.b.size();
      return var1 > 0?var1 - 1:0;
   }

   public s j() {
      return new x(this.b());
   }

   public m a(int var1) {
      if(var1 + 1 >= this.b.size()) {
         return null;
      } else {
         t var2 = (t)this.b.a(var1);
         t var3 = (t)this.b.a(var1 + 1);
         return var2 != null && var3 != null?new m(var2, var3):null;
      }
   }

   public String toString() {
      boolean var4 = t.d;
      StringBuffer var1 = new StringBuffer();
      var1.append("YPointPath:\n");
      C var2 = this.a();

      StringBuffer var10000;
      while(true) {
         if(var2.f()) {
            t var3 = (t)var2.d();
            var10000 = var1.append(var3.toString() + "\n");
            if(var4) {
               break;
            }

            var2.g();
            if(!var4) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000.toString();
   }

   public double k() {
      boolean var6 = t.d;
      if(this.b.size() <= 1) {
         return 0.0D;
      } else {
         t var1 = (t)this.b.f();
         double var2 = 0.0D;
         y.c.p var4 = this.b.k().a();

         double var10000;
         while(true) {
            if(var4 != null) {
               t var5 = (t)var4.c();
               var10000 = var2 + t.a(var1, var5);
               if(var6) {
                  break;
               }

               var2 = var10000;
               var1 = var5;
               var4 = var4.a();
               if(!var6) {
                  continue;
               }
            }

            var10000 = var2;
            break;
         }

         return var10000;
      }
   }
}
