package y.f.i.a;

import java.util.Arrays;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.T;
import y.f.i.a.Z;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.f;
import y.f.i.a.v;

class aG extends ab {
   private int b;
   private boolean c;
   private y.f.c.a.bk d;

   protected void c() {
      super.c();
      this.d = null;
   }

   protected void a(Z var1) {
      super.a(var1);
      this.d = y.f.c.a.bk.c(var1.a());
   }

   protected void b(aa var1) {
      super.b(var1);
      this.b = this.b().d().f().n();
      this.c = this.d != null && this.b > 0;
   }

   double[] a(f var1, R var2, P[] var3, v[] var4, double[] var5) {
      double var6 = 0.0D;
      if(this.c && var1.d() != null && this.a(var1, var2)) {
         var6 = (double)this.b;
      }

      this.b("punish reentering partition grid cells", var6, false);
      double[] var8 = new double[var3.length];
      if(var6 > 0.0D) {
         Arrays.fill(var8, var6);
      }

      return var8;
   }

   private boolean a(f var1, R var2) {
      R var3 = this.b().a(0);
      int var4 = this.a(var3);
      int var5 = this.b(var3);
      R var6 = this.b().b(0);
      int var7 = this.a(var6);
      int var8 = this.b(var6);
      R var9 = var1.a();
      return var4 < var7 && this.a(var2) < this.a(var9) || var4 > var7 && this.a(var2) > this.a(var9) || var4 == var7 && this.a(var9) > var7 && this.a(var9) > this.a(var2) || var4 == var7 && this.a(var9) < var7 && this.a(var9) < this.a(var2) || var5 < var8 && this.b(var2) < this.b(var9) || var5 > var8 && this.b(var2) > this.b(var9) || var5 == var8 && this.b(var9) > var8 && this.b(var9) > this.b(var2) || var5 == var8 && this.b(var9) < var8 && this.b(var9) < this.b(var2);
   }

   private int a(R var1) {
      Integer var2 = (Integer)var1.a(T.f);
      return var2 != null?var2.intValue():-1;
   }

   private int b(R var1) {
      Integer var2 = (Integer)var1.a(T.g);
      return var2 != null?var2.intValue():-1;
   }
}
