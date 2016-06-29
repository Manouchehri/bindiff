package y.f.c.a;

import y.f.c.a.cn;

class cE extends cn {
   protected int h;
   protected boolean i;
   protected y.f.am j;

   public cE(y.f.am var1, int var2, boolean var3) {
      this.j = var1;
      this.h = var2;
      this.i = var3;
   }

   public double b(double var1, double var3) {
      if(this.i) {
         switch(this.h) {
         case 0:
            return this.j.getWidth() * 0.5D - var1;
         case 1:
            return this.j.getWidth() * 0.5D + var3;
         case 2:
            return this.j.getWidth() * -0.5D + var1;
         case 3:
            return this.j.getWidth() * -0.5D - var3;
         default:
            throw new RuntimeException("Cannot be!");
         }
      } else {
         switch(this.h) {
         case 0:
            return this.j.getWidth() * -0.5D + var1;
         case 1:
            return this.j.getWidth() * 0.5D + var3;
         case 2:
            return this.j.getWidth() * 0.5D - var1;
         case 3:
            return this.j.getWidth() * -0.5D - var3;
         default:
            throw new RuntimeException("Cannot be!");
         }
      }
   }

   public double c(double var1, double var3) {
      if(this.i) {
         switch(this.h) {
         case 0:
            return this.j.getHeight() * -0.5D - var3;
         case 1:
            return this.j.getHeight() * 0.5D - var1;
         case 2:
            return this.j.getHeight() * 0.5D + var3;
         case 3:
            return this.j.getHeight() * -0.5D + var1;
         default:
            throw new RuntimeException("Cannot be!");
         }
      } else {
         switch(this.h) {
         case 0:
            return this.j.getHeight() * -0.5D - var3;
         case 1:
            return this.j.getHeight() * -0.5D + var1;
         case 2:
            return this.j.getHeight() * 0.5D + var3;
         case 3:
            return this.j.getHeight() * 0.5D - var1;
         default:
            throw new RuntimeException("Cannot be!");
         }
      }
   }

   public y.d.t d(double var1, double var3) {
      return new y.d.t(this.j.getX() + this.j.getWidth() * 0.5D + this.b(var1, var3), this.j.getY() + this.j.getHeight() * 0.5D + this.c(var1, var3));
   }
}
