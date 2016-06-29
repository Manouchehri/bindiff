package y.f.f.a.a;

import y.c.C;
import y.c.D;
import y.f.f.a.a.e;
import y.f.f.a.a.f;
import y.f.f.a.a.g;
import y.f.f.a.a.h;

public class m {
   public static void a(h var0, e var1) {
      boolean var5 = f.e;
      D var2 = new D();
      var2.b((Object)var1);

      while(!var2.isEmpty()) {
         e var3 = (e)var2.g();
         var0.a(var3);
         C var4 = var3.a();

         while(var4.f()) {
            var2.b((Object)((e)var4.d()));
            var4.g();
            if(var5 || var5) {
               return;
            }
         }
      }

   }

   public static void a(h var0, g var1) {
      b(var0, var1.a());
   }

   public static void b(h var0, e var1) {
      boolean var5 = f.e;
      D var2 = new D();
      var2.a((Object)var1);

      while(!var2.isEmpty()) {
         e var3 = (e)var2.g();
         var0.a(var3);
         C var4 = var3.a();

         while(var4.f()) {
            var2.a((Object)((e)var4.d()));
            var4.g();
            if(var5 || var5) {
               return;
            }
         }
      }

   }

   public static void c(h var0, e var1) {
      boolean var4 = f.e;
      C var2 = var1.a();

      while(true) {
         if(var2.f()) {
            e var3 = (e)var2.d();
            c(var0, var3);
            var2.g();
            if(var4) {
               break;
            }

            if(!var4) {
               continue;
            }
         }

         var0.a(var1);
         break;
      }

   }

   public static void b(h var0, g var1) {
      c(var0, var1.a());
   }
}
