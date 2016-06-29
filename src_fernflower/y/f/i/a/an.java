package y.f.i.a;

import y.f.i.a.ai;

class an {
   private int a;
   private int b;

   an(ai var1, ai var2, ai var3) {
      int var4 = this.a(var2);
      byte var5 = 1;
      int var6 = this.a(var4, var5);
      int var7 = this.b(this.a(var6, var1, var3));
      this.b = var6 * var7;
      byte var8 = -1;
      var6 = this.a(var4, var8);
      var7 = this.b(this.a(var6, var1, var3));
      this.a = var6 * var7;
   }

   private int a(ai var1) {
      y.f.y var2 = var1.h();
      return y.f.y.b != var2 && y.f.y.a != var2?-1:1;
   }

   private ai a(int var1, ai var2, ai var3) {
      return var1 > 0?var3:var2;
   }

   private int a(int var1, int var2) {
      return var1 * var2;
   }

   private int b(ai var1) {
      if(var1 == null) {
         return 0;
      } else {
         y.f.y var2 = var1.h();
         return y.f.y.d != var2 && y.f.y.a != var2?1:-1;
      }
   }

   public int a() {
      return this.a;
   }

   public int b() {
      return this.b;
   }
}
