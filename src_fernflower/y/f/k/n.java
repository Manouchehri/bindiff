package y.f.k;

import y.f.k.d;
import y.f.k.l;

class n {
   static final n a = new n(0.0D, -1.0D);
   static final n b = new n(1.0D, 0.0D);
   static final n c = new n(0.0D, 1.0D);
   static final n d = new n(-1.0D, 0.0D);
   static final n e = new n(0.0D, 0.0D);
   private final double[] f;
   private double g;

   private n(double[] var1) {
      this.g = Double.NaN;
      this.f = var1;
   }

   private n(double var1, double var3) {
      this(new double[]{var1, var3});
   }

   double a(n var1) {
      int var9 = d.g;
      double var2 = 0.0D;
      int var4 = 0;

      double var10000;
      while(true) {
         if(var4 < this.f.length) {
            double var5 = this.f[var4];
            double var7 = var1.a(var4);
            var10000 = var2 + var5 * var7;
            if(var9 != 0) {
               break;
            }

            var2 = var10000;
            ++var4;
            if(var9 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   double a(int var1) {
      return this.f[var1];
   }

   n a(l var1) {
      double var2 = this.a(var1.a(0));
      double var4 = this.a(var1.a(1));
      return a(var2, var4);
   }

   public String toString() {
      int var5 = d.g;
      StringBuffer var1 = new StringBuffer("Vector:\n");
      int var2 = 0;

      while(true) {
         if(var2 < this.f.length) {
            double var3 = this.f[var2];
            var1.append(var3).append(' ');
            ++var2;
            if(var5 != 0) {
               break;
            }

            if(var5 == 0) {
               continue;
            }
         }

         if(this == a) {
            var1.append("\n NORTH");
         }
         break;
      }

      if(this == b) {
         var1.append("\n EAST");
      }

      if(this == c) {
         var1.append("\n SOUTH");
      }

      if(this == d) {
         var1.append("\n WEST");
      }

      return var1.toString();
   }

   n a(double var1) {
      int var7 = d.g;
      double[] var3 = new double[this.f.length];
      int var4 = 0;

      double[] var10000;
      while(true) {
         if(var4 < this.f.length) {
            double var5 = this.f[var4];
            var10000 = var3;
            if(var7 != 0) {
               break;
            }

            var3[var4] = var5 * var1;
            ++var4;
            if(var7 == 0) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return a(var10000);
   }

   double a() {
      int var2 = d.g;
      n var10000;
      if(Double.isNaN(this.g)) {
         this.g = 0.0D;
         int var1 = 0;

         while(var1 < this.f.length) {
            var10000 = this;
            if(var2 != 0) {
               return var10000.g;
            }

            this.g += this.f[var1];
            ++var1;
            if(var2 != 0) {
               break;
            }
         }
      }

      var10000 = this;
      return var10000.g;
   }

   int b() {
      if(this == a) {
         return 0;
      } else if(this == b) {
         return 1;
      } else if(this == c) {
         return 2;
      } else if(this == d) {
         return 3;
      } else {
         throw new IllegalArgumentException("not a direction " + this);
      }
   }

   static n b(int var0) {
      if(var0 == 0) {
         return a;
      } else if(var0 == 1) {
         return b;
      } else if(var0 == 2) {
         return c;
      } else if(var0 == 3) {
         return d;
      } else {
         throw new IllegalArgumentException("Invalid direction " + var0);
      }
   }

   static n a(double[] var0) {
      return var0.length == 2?a(var0[0], var0[1]):new n(var0);
   }

   static n a(double var0, double var2) {
      return e.f[0] == var0 && e.f[1] == var2?e:(a.f[0] == var0 && a.f[1] == var2?a:(b.f[0] == var0 && b.f[1] == var2?b:(c.f[0] == var0 && c.f[1] == var2?c:(d.f[0] == var0 && d.f[1] == var2?d:new n(var0, var2)))));
   }

   static n a(y.d.t var0) {
      return a(var0.a(), var0.b());
   }
}
