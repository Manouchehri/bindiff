package y.f.i.a;

import java.util.Arrays;
import java.util.List;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.T;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.f;
import y.f.i.a.v;

class av extends ab {
   private int b;
   private boolean c;

   protected void b(aa var1) {
      super.b(var1);
      this.b = this.b().d().f().f();
      this.c = this.b > 0;
   }

   double[] a(f var1, R var2, P[] var3, v[] var4, double[] var5) {
      double var6 = this.c && this.a(var2)?(double)this.b:0.0D;
      this.b("punish edge label crossing", var6, false);
      double[] var8 = new double[var3.length];
      if(var6 > 0.0D) {
         Arrays.fill(var8, var6);
      }

      return var8;
   }

   private boolean a(R var1) {
      List var2 = (List)var1.a(T.d);
      return var2 != null && var2.size() > 0;
   }
}
