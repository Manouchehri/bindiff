package y.f.c;

import y.f.c.a;
import y.f.c.z;

public class y {
   public z[] a;
   public y.c.D b;
   private double c;
   private double d;

   public y(y.f.am var1) {
      this(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight());
   }

   public y(double var1, double var3, double var5, double var7) {
      this.a = new z[12];
      this.b = new y.c.D();
      this.a[0] = new z(var1, var3, 0, false);
      this.a[1] = new z(var1, var3, 0, false);
      this.a[2] = new z(var1 + var5, var3, 0, true);
      this.a[3] = new z(var1 + var5, var3, 1, false);
      this.a[4] = new z(var1 + var5, var3, 1, false);
      this.a[5] = new z(var1 + var5, var3 + var7, 1, true);
      this.a[6] = new z(var1 + var5, var3 + var7, 2, false);
      this.a[7] = new z(var1 + var5, var3 + var7, 2, false);
      this.a[8] = new z(var1, var3 + var7, 2, true);
      this.a[9] = new z(var1, var3 + var7, 3, false);
      this.a[10] = new z(var1, var3 + var7, 3, false);
      this.a[11] = new z(var1, var3, 3, true);
      this.d = var5;
      this.c = var7;
   }

   public void a() {
      boolean var2 = a.i;
      int var1 = 11;

      while(var1 >= 0) {
         this.a[var1].c();
         --var1;
         if(var2) {
            break;
         }
      }

   }

   public void a(y.f.am var1) {
      double var2 = var1.getX();
      double var4 = var1.getY();
      double var6 = var2 + var1.getWidth();
      double var8 = var4 + var1.getHeight();
      this.a[0].d = var2;
      this.a[0].c = var4;
      this.a[1].d = var2;
      this.a[1].c = var4;
      this.a[2].d = var6;
      this.a[2].c = var4;
      this.a[3].d = var6;
      this.a[3].c = var4;
      this.a[4].d = var6;
      this.a[4].c = var4;
      this.a[5].d = var6;
      this.a[5].c = var8;
      this.a[6].d = var6;
      this.a[6].c = var8;
      this.a[7].d = var6;
      this.a[7].c = var8;
      this.a[8].d = var2;
      this.a[8].c = var8;
      this.a[9].d = var2;
      this.a[9].c = var8;
      this.a[10].d = var2;
      this.a[10].c = var8;
      this.a[11].d = var2;
      this.a[11].c = var4;
   }

   public z a(int var1) {
      return this.a[(4 + var1 & 3) * 3];
   }

   public z b(int var1) {
      return this.a[2 + (4 + var1 & 3) * 3];
   }

   public z c(int var1) {
      return this.a[1 + (4 + var1 & 3) * 3];
   }

   public double d(int var1) {
      var1 = 4 + var1 & 3;
      return (var1 & 1) == 1?this.c:this.d;
   }

   public double e(int var1) {
      var1 = (4 + var1 & 3) * 3;
      return Math.max(this.a[var1++].d(), Math.max(this.a[var1++].d(), this.a[var1++].d()));
   }

   public double f(int var1) {
      var1 = (4 + var1 & 3) * 3;
      return Math.max(this.a[var1++].e(), Math.max(this.a[var1++].e(), this.a[var1++].e()));
   }

   public double g(int var1) {
      var1 = (4 + var1 & 3) * 3;
      double var2 = Math.max(this.a[var1].k, Math.max(this.a[var1 + 1].k, this.a[var1 + 2].k));
      double var4 = Math.max(this.a[var1].f + var2, Math.max(this.a[var1 + 1].f + var2, this.a[var1 + 2].f + var2));
      this.a[var1++].b(var4);
      this.a[var1++].b(var4);
      this.a[var1++].b(var4);
      return var4;
   }
}
