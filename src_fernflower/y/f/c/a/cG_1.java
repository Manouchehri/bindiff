package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.N;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;

final class cG implements Comparator {
   private final aV a;
   private final y.f.X b;
   private final aU c;

   public cG(y.f.X var1, aU var2, aV var3) {
      this.b = var1;
      this.a = var3;
      this.c = var2;
   }

   final float a(y.c.d var1) {
      boolean var5 = N.x;
      y.f.aE var2 = this.a.a(var1).e();
      y.d.t var4 = this.b.o(var1);
      float var3;
      if(var2 == null || var2.g()) {
         var3 = (float)(var4.a / 10000.0D);
         if(!var5) {
            return (float)this.a.a(var1.d()).k() + var3;
         }
      }

      switch(var2.b()) {
      case 4:
         var3 = 0.3F + (float)(var4.b / 10000.0D);
         if(!var5) {
            break;
         }
      case 8:
         var3 = -0.3F - (float)(var4.b / 10000.0D);
         if(!var5) {
            break;
         }
      case 1:
      case 2:
      case 3:
      case 5:
      case 6:
      case 7:
      default:
         var3 = (float)(var4.a / 10000.0D);
      }

      return (float)this.a.a(var1.d()).k() + var3;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      y.c.d var4 = (y.c.d)var2;
      byte var5 = this.a.a(var3.c()).b();
      if(var5 == 12 || var5 == 13) {
         boolean var6 = var5 == 12;
         aX var7 = this.a.a(var3.d());
         aX var8 = this.a.a(var4.d());
         if(var5 == var7.b() && var5 != var8.b()) {
            return var6?1:-1;
         }

         if(var5 != var7.b() && var5 == var8.b()) {
            return var6?-1:1;
         }
      }

      return y.g.e.a(this.a(var3), this.a(var4));
   }
}
