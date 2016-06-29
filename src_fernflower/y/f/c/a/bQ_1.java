package y.f.c.a;

import y.f.c.a.A;
import y.f.c.a.aP;
import y.f.c.a.aU;
import y.f.c.a.aV;

class bQ {
   private static final Object a = "AutoEdgeGroupConstraintHandler.TEST_SOURCE_GROUP_ID";
   private static final Object b = "AutoEdgeGroupConstraintHandler.TEST_TARGET_GROUP_ID";

   private static boolean a(y.c.d var0, aV var1, boolean var2, y.c.c var3) {
      A var4;
      if(var2) {
         if(var3 != null && var3.b(var0.c()) != null) {
            return false;
         } else {
            var4 = var1.a(var0);
            if(var4 != null) {
               if(var4.c() != null && !var4.c().g()) {
                  return false;
               }

               if(var4.d() != null && !var4.d().isEmpty()) {
                  return false;
               }
            }

            return true;
         }
      } else if(var3 != null && var3.b(var0.d()) != null) {
         return false;
      } else {
         var4 = var1.a(var0);
         if(var4 != null) {
            if(var4.e() != null && !var4.e().g()) {
               return false;
            }

            if(var4.f() != null && !var4.f().isEmpty()) {
               return false;
            }
         }

         return true;
      }
   }

   static void a(y.f.X param0, aU param1, aV param2, aP param3) {
      // $FF: Couldn't be decompiled
   }

   private static boolean a(y.c.d var0, y.c.A var1) {
      return var1.a(var0.c()) > var1.a(var0.d());
   }
}
