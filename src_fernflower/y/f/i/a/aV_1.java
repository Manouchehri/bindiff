package y.f.i.a;

import java.util.List;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.T;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.f;
import y.f.i.a.v;

class aV extends ab {
   private int b;
   private boolean c;

   protected void b(aa var1) {
      super.b(var1);
      this.b = var1.d().f().l();
      this.c = this.b > 0;
   }

   double[] a(f var1, R var2, P[] var3, v[] var4, double[] var5) {
      if(!this.c) {
         this.b("punish bends in node to edge distance", 0.0D, false);
         return new double[var3.length];
      } else {
         return super.a(var1, var2, var3, var4, var5);
      }
   }

   protected double a(f var1, R var2, P var3, v var4, double var5) {
      R var7 = var1.a();
      double var8 = 0.0D;
      if(a(var7)) {
         var8 = (double)(this.b * a(var4));
      }

      this.a("punish bends in node to edge distance", var8, false);
      return var8;
   }

   private static boolean a(R var0) {
      return !b(var0).isEmpty();
   }

   private static int a(v var0) {
      if(var0 == null) {
         return 0;
      } else {
         switch(var0.c()) {
         case 1:
         case 3:
            return 2;
         case 2:
            return 1;
         default:
            return 0;
         }
      }
   }

   private static List b(R var0) {
      return (List)var0.a(T.b);
   }
}
