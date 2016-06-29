package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.cs;
import y.f.c.a.cy;

class cz implements Comparator, y.g.g {
   private cz() {
   }

   public int compare(Object var1, Object var2) {
      cy var3 = (cy)var1;
      cy var4 = (cy)var2;
      byte var5 = var3.a();
      byte var6 = var4.a();
      if(var5 != var6) {
         return y.g.e.a(var5, var6);
      } else {
         switch(var5) {
         case 0:
            if(var3.b > var4.b && var3.c < var4.c) {
               return -1;
            }

            if(var3.b <= var4.b && var3.c >= var4.c) {
               return 1;
            }

            if(var3.c < var4.b) {
               return -1;
            }

            if(var3.c >= var4.b) {
               return 1;
            }
            break;
         case 1:
            if(var3.b < var4.b && var3.c < var4.c) {
               return -1;
            }

            if(var3.b >= var4.b && var3.c >= var4.c) {
               return 1;
            }

            if(var3.b == var4.b) {
               return var3.c < var4.c?-1:1;
            }

            if(var3.c == var4.c) {
               return var3.b < var4.b?-1:1;
            }

            return var3.b >= var4.b?-1:1;
         case 2:
            if(var3.b > var4.b && var3.c > var4.c) {
               return -1;
            }

            if(var3.b <= var4.b && var3.c <= var4.c) {
               return 1;
            }

            if(var3.b == var4.b) {
               return var3.c > var4.c?-1:1;
            }

            if(var3.c == var4.c) {
               return var3.b > var4.b?-1:1;
            }

            return var3.b <= var4.b?-1:1;
         case 3:
            if(var3.b < var4.b && var3.c > var4.c) {
               return -1;
            }

            if(var3.b > var4.b && var3.c < var4.c) {
               return 1;
            }

            if(var3.c < var4.b) {
               return 1;
            }

            if(var4.c < var3.b) {
               return -1;
            }
         }

         int var7 = y.g.e.a(var3.b, var4.b);
         if(var7 == 0) {
            var7 = y.g.e.a(var3.c, var4.c);
            if(var7 == 0) {
               var7 = y.g.e.a(var3.b, var4.b);
               return -var7;
            } else {
               return var7;
            }
         } else {
            return var7;
         }
      }
   }

   cz(cs var1) {
      this();
   }
}
