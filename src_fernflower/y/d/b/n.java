package y.d.b;

import java.math.BigInteger;
import y.d.b.A;
import y.d.b.b;
import y.d.b.c;
import y.d.b.v;
import y.d.b.x;
import y.d.b.z;

public class n extends x {
   private boolean i = true;
   private static final n j = new n();
   private static BigInteger k = BigInteger.valueOf(1L);
   private static BigInteger l = BigInteger.valueOf(2L);

   public static n f() {
      return j;
   }

   public Object a(double var1, double var3) {
      Object var7;
      Object var8;
      Object var9;
      Object var10;
      label11: {
         BigInteger[] var5 = new BigInteger[2];
         BigInteger[] var6 = new BigInteger[2];
         a(var1, var5);
         a(var3, var6);
         if(this.i) {
            var7 = new A(var5[0]);
            var9 = new A(var5[1]);
            var8 = new A(var6[0]);
            var10 = new A(var6[1]);
            if(c.a == 0) {
               break label11;
            }
         }

         var7 = new v(var5[0]);
         var9 = new v(var5[1]);
         var8 = new v(var6[0]);
         var10 = new v(var6[1]);
      }

      z var11 = ((z)var7).c((z)var10);
      z var12 = ((z)var8).c((z)var9);
      z var13 = ((z)var9).c((z)var10);
      b var14 = new b(var11, var12, var13, this);
      var14.g();
      return var14;
   }

   private static void a(double var0, BigInteger[] var2) {
      int var10 = c.a;
      long var3 = Double.doubleToLongBits(var0);
      int var5 = var3 >> 63 == 0L?1:-1;
      int var6 = (int)(var3 >> 52 & 2047L);
      long var7 = var6 == 0?(var3 & 4503599627370495L) << 1:var3 & 4503599627370495L | 4503599627370496L;
      int var9 = var6 - 1075;
      var2[0] = BigInteger.valueOf((long)var5 * var7);
      if(var9 == 0) {
         var2[1] = k;
         if(var10 == 0) {
            return;
         }
      }

      if(var9 > 0) {
         var2[0] = var2[0].multiply(l.pow(var9));
         var2[1] = k;
         if(var10 == 0) {
            return;
         }
      }

      var9 = -var9;
      var2[1] = l.pow(var9);
   }
}
