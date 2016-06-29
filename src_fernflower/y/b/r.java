package y.b;

import y.b.d;
import y.b.e;
import y.b.s;

final class r extends s {
   boolean[] d = null;
   double[] e = null;

   public void initAnimation() {
      int var6 = e.a;
      this.b = true;
      if(!this.a.isEmpty()) {
         this.d = new boolean[this.a.size()];
         this.e = new double[this.a.size()];
         double var1 = (double)this.preferredDuration();
         int var3 = 0;
         int var4 = this.a.size();

         while(var3 < var4) {
            d var5 = (d)this.a.get(var3);
            var5.initAnimation();
            this.d[var3] = false;
            this.e[var3] = 0.0D < var1?(double)var5.preferredDuration() / var1:0.0D;
            ++var3;
            if(var6 != 0) {
               break;
            }
         }

      }
   }

   public void calcFrame(double var1) {
      int var7 = e.a;
      if(!this.a.isEmpty()) {
         int var3 = 0;
         int var4 = this.a.size();

         while(var3 < var4) {
            label41: {
               if(var1 <= this.e[var3]) {
                  double var5;
                  label37: {
                     var5 = 0.0D < this.e[var3]?var1 / this.e[var3]:1.0D;
                     if(1.0D < var5) {
                        var5 = 1.0D;
                        if(var7 == 0) {
                           break label37;
                        }
                     }

                     if(0.0D > var5) {
                        var5 = 0.0D;
                     }
                  }

                  ((d)this.a.get(var3)).calcFrame(var5);
                  if(1.0D != var5) {
                     break label41;
                  }

                  this.d[var3] = true;
                  if(var7 == 0) {
                     break label41;
                  }
               }

               if(!this.d[var3]) {
                  ((d)this.a.get(var3)).calcFrame(1.0D);
                  this.d[var3] = true;
               }
            }

            ++var3;
            if(var7 != 0) {
               break;
            }
         }

      }
   }
}
