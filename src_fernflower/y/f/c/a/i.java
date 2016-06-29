package y.f.c.a;

import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.f;

class i {
   private y.c.y a;
   private Object b;
   private aU c;
   private double[][] d;
   private boolean e;
   private final f f;

   public i(f var1, y.c.q var2, int var3) {
      this.f = var1;
      this.e = true;
      this.a = new y.c.y(var2);
      this.b = new Integer(var3);
   }

   public Object a() {
      return this.b;
   }

   public aU b() {
      return this.c;
   }

   public y.c.y c() {
      return this.a;
   }

   public void a(aU var1) {
      this.c = var1;
      this.e = true;
   }

   public void a(y.c.q var1) {
      this.a.add(var1);
   }

   public double d() {
      boolean var6 = N.x;
      double var1 = 0.0D;
      double var3 = 0.0D;
      this.e();
      if(this.d != null) {
         int var5 = 0;

         while(var5 < this.c.b()) {
            if(var5 > 0) {
               var1 += 30.0D;
            }

            var1 += this.d[var5][0];
            var3 = Math.max(var3, this.d[var5][1]);
            ++var5;
            if(var6) {
               break;
            }
         }
      }

      return var1 * var1 + var3 * var3;
   }

   public double[][] e() {
      boolean var9 = N.x;
      if(this.c == null) {
         return (double[][])null;
      } else if(!this.e) {
         return this.d;
      } else {
         this.d = new double[this.c.b()][2];
         int var1 = 0;

         while(true) {
            if(var1 < this.c.b()) {
               aQ var2 = this.c.a(var1);
               double var3 = 0.0D;
               double var5 = 0.0D;
               if(var9) {
                  break;
               }

               y.c.p var7 = var2.d().k();

               label35: {
                  while(var7 != null) {
                     y.c.q var8 = (y.c.q)var7.c();
                     var3 = Math.max(var3, f.a(this.f, var8));
                     var5 += f.b(this.f, var8);
                     var7 = var7.a();
                     if(var9) {
                        break label35;
                     }

                     if(var9) {
                        break;
                     }
                  }

                  this.d[var1][0] = var3;
                  this.d[var1][1] = var5 + (double)(var2.d().size() - 1) * 30.0D;
                  ++var1;
               }

               if(!var9) {
                  continue;
               }
            }

            this.e = false;
            break;
         }

         return this.d;
      }
   }
}
