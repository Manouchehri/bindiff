package y.h;

import java.util.HashMap;
import java.util.Map;
import y.h.bD;
import y.h.bu;
import y.h.fj;

public class bE extends y.g.F {
   private y.c.c a;
   private y.h.a.v b;

   public bE() {
      this(new bD());
   }

   public bE(y.g.C var1) {
      super(var1);
   }

   protected void b(y.c.i var1, y.c.i var2) {
      boolean var4;
      label21: {
         var4 = fj.z;
         super.b(var1, var2);
         y.h.a.v var3 = this.a(var1);
         if(var3 != null) {
            this.a = var3.e();
            if(!var4) {
               break label21;
            }
         }

         this.a = var1.c(y.f.b.f.d);
      }

      if(this.a == null) {
         this.a = y.g.q.a((Object)Boolean.FALSE);
         if(!var4) {
            return;
         }
      }

      this.b = this.a(var2);
      if(this.b == null) {
         ((bu)var2).a(this.b = new y.h.a.v(var2));
      }

   }

   public void a(y.c.i var1, y.c.i var2, Map var3, Map var4) {
      y.c.c var5;
      y.c.c var6;
      boolean var15;
      label69: {
         var15 = fj.z;
         super.a(var1, var2, var3, var4);
         y.h.a.v var7 = this.a(var1);
         if(var7 != null) {
            var5 = var7.c();
            var6 = var7.d();
            if(!var15) {
               break label69;
            }
         }

         var5 = var1.c(y.f.b.f.b);
         var6 = var1.c(y.f.b.f.c);
      }

      if(this.b != null && var5 != null && var6 != null) {
         HashMap var8 = new HashMap();
         HashMap var9 = new HashMap();
         y.c.x var10 = var1.o();

         y.c.q var11;
         label42: {
            while(var10.f()) {
               var11 = var10.e();
               var8.put(var5.b(var11), var11);
               var10.g();
               if(var15) {
                  break label42;
               }

               if(var15) {
                  break;
               }
            }

            var10 = var1.o();
         }

         label52: {
            while(var10.f()) {
               var11 = var10.e();
               Object var12 = var6.b(var11);
               var9.put(var11, var8.get(var12));
               var10.g();
               if(var15) {
                  break label52;
               }

               if(var15) {
                  break;
               }
            }

            var10 = var1.o();
         }

         while(var10.f()) {
            var11 = var10.e();
            y.c.q var16 = (y.c.q)var9.get(var11);
            if(var15) {
               return;
            }

            if(var16 != null) {
               y.c.q var13 = (y.c.q)var3.get(var11);
               if(var13 != null) {
                  y.c.q var14 = (y.c.q)var3.get(var16);
                  if(var14 != null) {
                     this.b.c(var13, var14);
                  }
               }
            }

            var10.g();
            if(var15) {
               break;
            }
         }
      }

      this.b = null;
      this.a = null;
   }

   private y.h.a.v a(y.c.i var1) {
      y.h.a.v var2 = null;
      if(var1 instanceof bu) {
         var2 = ((bu)var1).C();
      } else if(y.h.a.v.a(var1) != null) {
         var2 = y.h.a.v.a(var1);
      }

      return var2;
   }

   protected void a(y.c.q var1, y.c.q var2) {
      super.a(var1, var2);
      boolean var3 = this.a.d(var1);
      if(var3) {
         this.b.c(var2);
      }

   }

   protected void a(y.c.d var1, y.c.d var2) {
      super.a(var1, var2);
   }
}
