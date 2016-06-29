package y.f.c.a;

import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.z;

class cc implements z {
   double a;
   private y.c.A b;

   public void a(double var1) {
      this.a = var1;
   }

   public void a(y.f.X var1, aU var2, aV var3) {
      this.b = y.g.M.a(new double[var1.e()]);
      this.a(var1, var2, var3, this.b);
   }

   public void b(y.f.X var1, aU var2, aV var3) {
      this.b = null;
   }

   private void a(y.f.X param1, aU param2, aV param3, y.c.A param4) {
      // $FF: Couldn't be decompiled
   }

   private boolean a(aX var1, aX var2) {
      switch(var1.b()) {
      case 1:
      case 2:
      case 3:
      case 8:
      case 9:
         switch(var2.b()) {
         case 1:
         case 2:
         case 3:
         case 8:
         case 9:
            return true;
         case 4:
         case 5:
         case 6:
         case 7:
         default:
            return false;
         }
      case 4:
      case 5:
      case 6:
      case 7:
      default:
         return false;
      }
   }

   public double a(y.f.X var1, aQ var2, aV var3, y.c.q var4, y.c.q var5) {
      return var4 != null && var5 != null?this.b.c(var4):0.0D;
   }
}
