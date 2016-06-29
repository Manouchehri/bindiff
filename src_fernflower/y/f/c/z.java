package y.f.c;

import y.f.c.a;

public class z {
   int a;
   boolean b;
   double c;
   double d;
   public double e;
   public double f;
   double g = 0.0D;
   double h = 20.0D;
   double i = 0.0D;
   double j = 20.0D;
   double k = 20.0D;
   public y.c.f l = new y.c.f();

   z(double var1, double var3, int var5, boolean var6) {
      this.a = var5;
      this.b = var6;
      this.d = var1;
      this.c = var3;
   }

   public void a(double var1) {
      this.h = var1;
   }

   public void a(double var1, double var3) {
      this.k = var3;
      this.a(var1);
   }

   public double a() {
      this.e += this.j;
      return this.e;
   }

   public double b() {
      if(this.f < this.h) {
         this.f = Math.max(this.f + this.k, this.h);
         if(!a.i) {
            return this.f;
         }
      }

      this.f += this.k;
      return this.f;
   }

   public void b(double var1) {
      this.f = var1;
   }

   public void b(double var1, double var3) {
      this.d(var1);
      this.c(var3);
   }

   public void c(double var1) {
      this.i = var1;
      this.f = var1;
   }

   public void d(double var1) {
      this.g = var1;
      this.e = var1 - this.j;
   }

   public void c() {
      this.c(this.i);
      this.d(this.g);
   }

   public double d() {
      return this.l.size() < 1?this.i:Math.max(this.i + this.k * (double)this.l.size(), this.h + this.k * (double)(this.l.size() - 1));
   }

   public double a(int var1) {
      return var1 == 0?this.i:Math.max(this.i + this.k * (double)var1, this.h + this.k * (double)(var1 - 1));
   }

   public double e() {
      return this.l.size() == 0?this.i:Math.max(this.i + this.k * (double)this.l.size(), this.h + this.k * (double)(this.l.size() - 1));
   }

   public double f() {
      return this.l.size() < 1?this.g:this.g + this.j * (double)(this.l.size() - 1);
   }

   public double g() {
      return this.l.size() < 1?this.g:this.g + this.j * (double)this.l.size();
   }

   public y.d.t c(double var1, double var3) {
      if(this.b) {
         switch(this.a) {
         case 0:
            return new y.d.t(this.d - var1, this.c - var3);
         case 1:
            return new y.d.t(this.d + var3, this.c - var1);
         case 2:
            return new y.d.t(this.d + var1, this.c + var3);
         case 3:
            return new y.d.t(this.d - var3, this.c + var1);
         default:
            throw new RuntimeException("Cannot be!");
         }
      } else {
         switch(this.a) {
         case 0:
            return new y.d.t(this.d + var1, this.c - var3);
         case 1:
            return new y.d.t(this.d + var3, this.c + var1);
         case 2:
            return new y.d.t(this.d - var1, this.c + var3);
         case 3:
            return new y.d.t(this.d - var3, this.c - var1);
         default:
            throw new RuntimeException("Cannot be!");
         }
      }
   }

   public double d(double var1, double var3) {
      if(this.b) {
         switch(this.a) {
         case 0:
            return this.d - var1;
         case 1:
            return this.c - var3;
         case 2:
            return var1 - this.d;
         case 3:
            return var3 - this.c;
         default:
            throw new RuntimeException("Cannot be!");
         }
      } else {
         switch(this.a) {
         case 0:
            return var1 - this.d;
         case 1:
            return var3 - this.c;
         case 2:
            return this.d - var1;
         case 3:
            return this.c - var3;
         default:
            throw new RuntimeException("Cannot be!");
         }
      }
   }

   public double e(double var1, double var3) {
      if(this.b) {
         switch(this.a) {
         case 0:
            return this.c - var3;
         case 1:
            return this.c - var1;
         case 2:
            return this.c + var3;
         case 3:
            return this.c + var1;
         default:
            throw new RuntimeException("Cannot be!");
         }
      } else {
         switch(this.a) {
         case 0:
            return this.c - var3;
         case 1:
            return this.c + var1;
         case 2:
            return this.c + var3;
         case 3:
            return this.c - var1;
         default:
            throw new RuntimeException("Cannot be!");
         }
      }
   }

   public double f(double var1, double var3) {
      if(this.b) {
         switch(this.a) {
         case 0:
            return this.d - var1;
         case 1:
            return this.d + var3;
         case 2:
            return this.d + var1;
         case 3:
            return this.d - var3;
         default:
            throw new RuntimeException("Cannot be!");
         }
      } else {
         switch(this.a) {
         case 0:
            return this.d + var1;
         case 1:
            return this.d + var3;
         case 2:
            return this.d - var1;
         case 3:
            return this.d - var3;
         default:
            throw new RuntimeException("Cannot be!");
         }
      }
   }
}
