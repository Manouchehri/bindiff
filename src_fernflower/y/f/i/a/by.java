package y.f.i.a;

import y.f.i.a.ab;
import y.f.i.a.bs;
import y.f.i.a.bw;

class by extends bw {
   private final int[] a;
   private final int[] b;
   private final bs c;

   by(bs var1, int var2, int var3) {
      int var6 = ab.a;
      super(var1);
      this.c = var1;
      boolean var4 = var2 > var3;
      this.a = new int[bs.c(var1).b()];
      this.b = new int[bs.c(var1).b()];
      int var5 = 0;

      while(var5 < bs.c(var1).b()) {
         label79: {
            if(var5 < var2 && var5 < var3 || var5 > var2 && var5 > var3) {
               this.a[var5] = var5;
               this.b[var5] = var5;
               if(var6 == 0) {
                  break label79;
               }
            }

            if(var5 != var2 && var5 != var3) {
               this.a[var5] = var4?var5 - 1:var5 + 1;
               this.b[var5] = var4?var5 + 1:var5 - 1;
            }
         }

         ++var5;
         if(var6 != 0) {
            break;
         }
      }

      this.a[var2] = var4?var2 - 1:var2 + 1;
      this.b[var2] = var3;
      this.a[var3] = var2;
      this.b[var3] = var4?var3 + 1:var3 - 1;
   }

   public int a(int var1) {
      return this.a[var1];
   }

   public int b(int var1) {
      return this.b[var1];
   }
}
