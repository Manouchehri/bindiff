package y.f.i.a;

import y.f.i.a.aI;
import y.f.i.a.aJ;
import y.f.i.a.aK;

class aL implements y.d.g {
   private aK a;
   private boolean b;

   private aL() {
      this.a = null;
      this.b = false;
   }

   public void a(Object var1, Object var2) {
      aJ var3 = (aJ)var1;
      aJ var4 = (aJ)var2;
      y.d.t var5 = y.d.m.a(var3, var4);
      if(var5 != null) {
         int var6 = Math.abs(var4.a - var3.a);
         if(this.a != null) {
            this.b = true;
         }

         if(this.a == null || var6 > this.a.d) {
            this.a = new aK(var3, var4, var5, var6, (aI)null);
         }
      }

   }

   aL(aI var1) {
      this();
   }

   static aK a(aL var0) {
      return var0.a;
   }

   static boolean b(aL var0) {
      return var0.b;
   }
}
