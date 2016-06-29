package y.f.i.a;

import java.util.List;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.U;
import y.f.i.a.Z;
import y.f.i.a.aa;
import y.f.i.a.ac;
import y.f.i.a.f;
import y.f.i.a.v;

public abstract class ab {
   private Z b;
   private aa c;
   private int d;
   public static int a;

   protected Z a() {
      return this.b;
   }

   protected aa b() {
      return this.c;
   }

   protected void a(Z var1) {
      this.b = var1;
   }

   protected void a(aa var1) {
      this.c = var1;
   }

   protected void b(aa var1) {
   }

   protected void a(List var1) {
   }

   protected double a(f var1) {
      return 0.0D;
   }

   protected double a(f var1, R var2, P var3, v var4, double var5) {
      return 0.0D;
   }

   double[] a(f var1, R var2, P[] var3, v[] var4, double[] var5) {
      int var8 = a;
      double[] var6 = new double[var3.length];
      this.d = var3.length;
      int var7 = 0;

      double[] var10000;
      while(true) {
         if(var7 < var3.length) {
            var10000 = var6;
            if(var8 != 0) {
               break;
            }

            var6[var7] = this.a(var1, var2, var3[var7], var4[var7], var5[var7]);
            ++var7;
            --this.d;
            if(var8 == 0) {
               continue;
            }
         }

         var10000 = var6;
         break;
      }

      return var10000;
   }

   protected double b(f var1) {
      return 0.0D;
   }

   protected boolean c(f var1) {
      return true;
   }

   protected void a(U var1) {
   }

   protected void c(aa var1) {
   }

   protected void d(aa var1) {
   }

   protected void e(aa var1) {
   }

   protected void a(ac var1) {
   }

   protected void c() {
      this.b = null;
      this.c = null;
   }

   void a(String var1, double var2, boolean var4) {
   }

   void b(String var1, double var2, boolean var4) {
   }
}
