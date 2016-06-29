package y.f;

import java.util.HashMap;
import java.util.Map;
import y.f.C;
import y.f.I;
import y.f.X;
import y.f.Z;
import y.f.aj;
import y.f.am;
import y.f.u;
import y.f.x;

public class w extends X {
   private y.c.A k = this.t();
   private y.c.h l = this.u();
   protected y.c.A a = this.t();
   protected y.c.h b = this.u();
   protected Map h = new HashMap();
   protected Map i = new HashMap();

   protected y.g.C b() {
      return new Z();
   }

   public am h(y.c.q var1) {
      am var2 = (am)this.k.b(var1);
      if(var2 == null) {
         var2 = this.D();
         this.k.a(var1, var2);
      }

      return var2;
   }

   public void a(y.c.q var1, am var2) {
      this.k.a(var1, var2);
   }

   public void a(y.c.d var1, I var2) {
      this.l.a(var1, var2);
   }

   public I g(y.c.d var1) {
      I var2 = (I)this.l.b(var1);
      if(var2 == null) {
         var2 = this.C();
         this.l.a(var1, var2);
      }

      return var2;
   }

   public aj[] i(y.c.q var1) {
      aj[] var2 = (aj[])this.a.b(var1);
      if(var2 == null) {
         var2 = new aj[0];
         this.a.a(var1, var2);
      }

      return var2;
   }

   public void a(y.c.q var1, aj[] var2) {
      boolean var7;
      label31: {
         var7 = X.j;
         Object var3 = this.a.b(var1);
         if(var3 instanceof aj[]) {
            aj[] var4 = (aj[])var3;
            int var5 = 0;

            while(var5 < var4.length) {
               aj var6 = var4[var5];
               this.h.remove(var6);
               ++var5;
               if(var7) {
                  break label31;
               }

               if(var7) {
                  break;
               }
            }
         }

         this.a.a(var1, var2);
      }

      int var8 = 0;

      while(var8 < var2.length) {
         aj var9 = var2[var8];
         this.h.put(var9, var1);
         ++var8;
         if(var7) {
            break;
         }
      }

   }

   public void a(y.c.d var1, C[] var2) {
      boolean var7;
      label31: {
         var7 = X.j;
         Object var3 = this.b.b(var1);
         if(var3 instanceof C[]) {
            C[] var4 = (C[])var3;
            int var5 = 0;

            while(var5 < var4.length) {
               C var6 = var4[var5];
               this.i.remove(var6);
               ++var5;
               if(var7) {
                  break label31;
               }

               if(var7) {
                  break;
               }
            }
         }

         this.b.a(var1, var2);
      }

      int var8 = 0;

      while(var8 < var2.length) {
         this.i.put(var2[var8], var1);
         ++var8;
         if(var7) {
            break;
         }
      }

   }

   public C[] h(y.c.d var1) {
      C[] var2 = (C[])this.b.b(var1);
      if(var2 == null) {
         var2 = new C[0];
         this.b.a(var1, var2);
      }

      return var2;
   }

   public y.c.q a(aj var1) {
      return (y.c.q)this.h.get(var1);
   }

   public y.c.d a(C var1) {
      return (y.c.d)this.i.get(var1);
   }

   protected I C() {
      return new u();
   }

   protected am D() {
      return new x();
   }
}
