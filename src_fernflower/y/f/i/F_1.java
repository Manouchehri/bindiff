package y.f.i;

import y.f.i.J;
import y.f.i.v;

class F implements Comparable {
   final boolean a;
   final double b;
   final double c;
   final double d;
   int e;
   final J f;

   F(boolean var1, double var2, double var4, double var6, J var8) {
      this.a = var1;
      this.f = var8;
      this.b = var2;
      if(var4 < var6) {
         this.c = var4;
         this.d = var6;
         if(v.f == 0) {
            return;
         }
      }

      this.c = var6;
      this.d = var4;
   }

   public int compareTo(Object var1) {
      F var2 = (F)var1;
      int var3 = y.g.e.a(this.b, var2.b);
      return var3 != 0?var3:(this.a?(var2.a?0:-1):(var2.a?1:0));
   }

   public String toString() {
      return "Event{open=" + this.a + ", x=" + this.b + ", yBegin=" + this.c + ", yEnd=" + this.d + ", openEventCount=" + this.e + ", graphicalObject=" + this.f + '}';
   }
}
