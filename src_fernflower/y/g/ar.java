package y.g;

import java.util.Random;
import y.g.p;

public class ar extends Random {
   public ar() {
   }

   public ar(long var1) {
      super(var1);
   }

   public int nextInt(int var1) {
      boolean var4 = p.c;
      if(var1 <= 0) {
         throw new IllegalArgumentException("n must be positive");
      } else {
         while(true) {
            int var2 = this.next(31);
            int var3 = var2 % var1;
            int var10000 = var2 - var3 + (var1 - 1);

            while(var10000 >= 0) {
               var10000 = var3;
               if(!var4) {
                  return var3;
               }
            }
         }
      }
   }

   public double a(double var1, double var3) {
      return this.nextDouble() * (var3 - var1) + var1;
   }

   public int a(int var1, int var2) {
      return this.nextInt(var2 - var1) + var1;
   }

   public void a(Object[] var1) {
      boolean var5 = p.c;
      int var2 = 0;

      int var3;
      Object var4;
      while(true) {
         if(var2 < var1.length) {
            var3 = this.nextInt(var1.length);
            var4 = var1[var2];
            var1[var2] = var1[var3];
            var1[var3] = var4;
            ++var2;
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         var2 = var1.length - 1;
         break;
      }

      while(var2 >= 0) {
         var3 = this.nextInt(var1.length);
         var4 = var1[var2];
         var1[var2] = var1[var3];
         var1[var3] = var4;
         --var2;
         if(var5) {
            break;
         }
      }

   }
}
