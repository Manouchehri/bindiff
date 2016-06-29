package y.a;

import y.a.N;
import y.a.h;

class M {
   public N a(Object var1) {
      N var2 = new N(var1);
      return var2;
   }

   public N a(N var1) {
      boolean var4 = h.a;
      N var2 = var1.a;
      if(var2 == null) {
         return var1;
      } else {
         N var3 = var1;

         N var10000;
         label30:
         while(true) {
            if(var3.a != null) {
               var3 = var3.a;
               if(var4) {
                  break;
               }

               if(!var4) {
                  continue;
               }
            }

            while(true) {
               if(var2 == var3) {
                  break label30;
               }

               var1.a = var3;
               var1 = var2;
               var10000 = var2.a;
               if(var4) {
                  return var10000;
               }

               var2 = var10000;
               if(var4) {
                  break label30;
               }
            }
         }

         var10000 = var3;
         return var10000;
      }
   }

   public void a(N var1, N var2) {
      var1 = this.a(var1);
      var2 = this.a(var2);
      if(var1 != var2) {
         if(var1.b > var2.b) {
            var2.a = var1;
            var1.b += var2.b;
            if(!h.a) {
               return;
            }
         }

         var1.a = var2;
         var2.b += var1.b;
      }
   }

   public Object b(N var1) {
      return var1.c;
   }
}
