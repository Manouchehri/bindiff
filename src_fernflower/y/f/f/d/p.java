package y.f.f.d;

import y.f.f.d.o;

public class p {
   private y.c.D a;

   public p() {
      this.a = new y.c.D();
   }

   public p(y.f.f.c.g var1) {
      this();
      this.a(var1);
   }

   public void a(y.f.f.c.g var1) {
      this.a.add(var1);
   }

   public y.c.C a() {
      return this.a.m();
   }

   public y.f.f.c.g b() {
      y.c.C var1 = this.a();
      y.f.f.c.g var2 = (y.f.f.c.g)var1.d();
      return var2;
   }

   public static void a(y.f.f.c.p var0, p var1, p var2, int var3) {
      boolean var8 = o.p;
      y.c.C var4 = var1.a();

      while(var4.f()) {
         y.f.f.c.g var5 = (y.f.f.c.g)var4.d();
         y.c.C var6 = var2.a();

         while(true) {
            if(var6.f()) {
               y.f.f.c.g var7 = (y.f.f.c.g)var6.d();
               var0.a(var5, var7, var3);
               var6.g();
               if(var8) {
                  break;
               }

               if(!var8) {
                  continue;
               }
            }

            var4.g();
            break;
         }

         if(var8) {
            break;
         }
      }

   }

   public String toString() {
      boolean var4 = o.p;
      StringBuffer var1 = new StringBuffer();
      y.c.C var2 = this.a();

      StringBuffer var10000;
      while(true) {
         if(var2.f()) {
            y.f.f.c.g var3 = (y.f.f.c.g)var2.d();
            var10000 = var1.append(var3.toString() + "  ");
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
}
