package y.f.i;

import java.util.Comparator;
import y.f.i.b;
import y.f.i.c;
import y.f.i.e;

class f implements Comparator, y.g.g {
   private final b a;

   private f(b var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      e var3 = (e)var1;
      e var4 = (e)var2;
      byte var5 = var3.a(b.a(this.a));
      byte var6 = var4.a(b.a(this.a));
      if(var5 != var6) {
         return y.g.e.a(var5, var6);
      } else {
         switch(var5) {
         case 0:
            if(var3.b.a > var4.b.a && var3.c.a < var4.c.a) {
               return -1;
            }

            if(var4.b.a > var3.b.a && var4.c.a < var3.c.a) {
               return 1;
            }

            if(var3.c.a < var4.b.a) {
               return -1;
            }

            if(var4.c.a < var3.b.a) {
               return 1;
            }
            break;
         case 1:
            if(var3.b.a > var4.b.a && var3.c.a > var4.c.a) {
               return -1;
            }

            if(var4.b.a > var3.b.a && var4.c.a > var3.c.a) {
               return 1;
            }

            if(var3.b.a == var4.b.a) {
               return var3.c.a > var4.c.a?-1:1;
            }

            if(var3.c.a == var4.c.a) {
               return var3.b.a > var4.b.a?-1:1;
            }

            return var3.b.a <= var4.b.a?-1:1;
         case 2:
            if(var3.b.a < var4.b.a && var3.c.a < var4.c.a) {
               return -1;
            }

            if(var4.b.a < var3.b.a && var4.c.a < var3.c.a) {
               return 1;
            }

            if(var3.b.a == var4.b.a) {
               return var3.c.a < var4.c.a?-1:1;
            }

            if(var3.c.a == var4.c.a) {
               return var3.b.a < var4.b.a?-1:1;
            }

            return var3.b.a >= var4.b.a?-1:1;
         case 3:
            if(var3.b.a < var4.b.a && var3.c.a > var4.c.a) {
               return -1;
            }

            if(var4.b.a < var3.b.a && var4.c.a > var3.c.a) {
               return 1;
            }

            if(var3.c.a < var4.b.a) {
               return -1;
            }

            if(var4.c.a < var3.b.a) {
               return 1;
            }
         }

         int var7 = y.g.e.a(var3.b.a, var4.b.a);
         if(var7 == 0) {
            var7 = y.g.e.a(var3.c.a, var4.c.a);
            if(var7 == 0) {
               var7 = y.g.e.a(var3.b.a, var4.b.a);
               return -var7;
            } else {
               return var7;
            }
         } else {
            return var7;
         }
      }
   }

   f(b var1, c var2) {
      this(var1);
   }
}
