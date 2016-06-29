package y.f.e;

import y.c.D;
import y.f.X;
import y.f.e.i;
import y.g.ar;

class g {
   public final y.c.q a;
   public double b;
   public double c;
   public double d;
   public double e;
   public int f;
   public double g;
   public double h;
   public double i;
   public double j;
   public double k;
   public double l;
   public final boolean m;
   public int n;
   public byte o;
   public g p;
   public double q;
   public double r;
   public D s;

   g(y.c.q var1, double var2, boolean var4, double var5, int var7, ar var8, X var9, byte var10) {
      boolean var13 = i.b;
      super();
      this.a = var1;
      this.e = 1.0E-4D;
      this.m = var4;
      this.g = var2;
      this.l = 1.0D;
      this.k = (var9.p(var1) + var9.q(var1)) / 4.0D;
      this.q = var5;
      switch(var10) {
      case 0:
         double var11 = 0.45D * var5 * Math.sqrt((double)var7);
         this.h = var8.a(-var11, var11);
         this.i = var8.a(-var11, var11);
         this.j = var8.a(-var11, var11);
         if(!var13) {
            break;
         }
      case 1:
         this.h = this.i = this.j = 0.0D;
         if(!var13) {
            break;
         }
      case 2:
      default:
         this.h = var9.l(var1).a();
         this.i = var9.l(var1).b();
         if(this.m) {
            this.j = var8.a(-var5 * 0.3D, var5 * 0.3D);
            if(!var13) {
               return;
            }
         }

         this.j = 0.0D;
      }

   }
}
