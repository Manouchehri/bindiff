package y.g;

import java.util.HashMap;
import java.util.Map;
import y.g.C;
import y.g.E;
import y.g.G;
import y.g.H;
import y.g.p;

public class B {
   private C a;
   private boolean b;
   private boolean c;
   private boolean d;

   public B() {
      this.a = new y.c.k();
   }

   public B(C var1) {
      if(var1 == null) {
         throw new NullPointerException("copyFactory");
      } else {
         this.a = var1;
      }
   }

   public y.c.y a(y.c.i var1, y.c.i var2) {
      return this.a(var1, this.b(var1), var2);
   }

   public C a() {
      return this.a;
   }

   public void a(C var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.a = var1;
      }
   }

   private C a(C var1, y.c.i var2) {
      boolean var6 = p.c;
      if(this.c) {
         var1 = new H((C)var1);
      }

      if(this.d) {
         var1 = new E((C)var1);
      }

      Object var10000;
      if(this.b) {
         Object[] var3 = var2.z();
         int var4 = 0;

         while(var4 < var3.length) {
            Object var5 = var3[var4];
            var10000 = new G((C)var1, var5);
            if(var6) {
               return (C)var10000;
            }

            var1 = var10000;
            ++var4;
            if(var6) {
               break;
            }
         }
      }

      var10000 = var1;
      return (C)var10000;
   }

   public y.c.y a(y.c.i var1, y.c.x var2, y.c.i var3) {
      return this.a(this.a(this.a, var1), var1, (y.c.x)var2, (y.c.e)null, (y.c.i)var3);
   }

   public y.c.y a(y.c.i var1, y.c.x var2, y.c.e var3, y.c.i var4) {
      return this.a(this.a(this.a, var1), var1, var2, var3, var4);
   }

   private y.c.y a(C var1, y.c.i var2, y.c.x var3, y.c.e var4, y.c.i var5) {
      boolean var16 = p.c;
      this.a(var1, var2, var5);
      y.c.y var6 = new y.c.y();
      Map var7 = this.c();
      Map var8 = this.b();
      if(var2 == var5) {
         var3 = (new y.c.y(var3)).a();
      }

      y.c.e var10000;
      label47: {
         while(true) {
            if(var3.f()) {
               y.c.q var9 = var3.e();
               y.c.q var10 = this.a(var1, var5, var9);
               var7.put(var9, var10);
               var6.add(var10);
               var3.g();
               if(var16) {
                  break;
               }

               if(!var16) {
                  continue;
               }
            }

            if(var4 != null) {
               var10000 = var4;
               break label47;
            }
            break;
         }

         var10000 = this.a(var2);
      }

      y.c.e var17 = var10000;
      if(var2 == var5) {
         var17 = (new y.c.f(var17)).a();
      }

      while(true) {
         if(var17.f()) {
            y.c.d var18 = var17.a();
            y.c.q var11 = var18.c();
            y.c.q var12 = var18.d();
            y.c.q var13 = (y.c.q)var7.get(var11);
            y.c.q var14 = (y.c.q)var7.get(var12);
            if(var16) {
               break;
            }

            if(var13 != null && var14 != null) {
               y.c.d var15 = this.a(var1, var5, var13, var14, var18);
               if(var8 != null) {
                  var8.put(var18, var15);
               }
            }

            var17.g();
            if(!var16) {
               continue;
            }
         }

         this.a(var1, var2, var5, var7, var8);
         break;
      }

      return var6;
   }

   protected void a(C var1, y.c.i var2, y.c.i var3) {
      var1.a(var2, var3);
   }

   protected void a(C var1, y.c.i var2, y.c.i var3, Map var4, Map var5) {
      var1.a(var2, var3, var4, var5);
   }

   protected Map b() {
      return new HashMap();
   }

   protected y.c.d a(C var1, y.c.i var2, y.c.q var3, y.c.q var4, y.c.d var5) {
      return var1.a(var2, var3, var4, var5);
   }

   protected y.c.e a(y.c.i var1) {
      return var1.p();
   }

   protected y.c.q a(C var1, y.c.i var2, y.c.q var3) {
      return var1.a(var2, var3);
   }

   protected Map c() {
      return new HashMap();
   }

   protected y.c.x b(y.c.i var1) {
      return var1.o();
   }
}
