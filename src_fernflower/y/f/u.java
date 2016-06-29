package y.f;

import java.util.ArrayList;
import y.f.I;
import y.f.X;

public class u implements I {
   private ArrayList a;
   private y.d.t b;
   private y.d.t c;

   public u() {
      this.b = y.d.t.c;
      this.c = y.d.t.c;
      this.a = new ArrayList(5);
   }

   public u(I var1) {
      boolean var3 = X.j;
      this();
      int var2 = 0;

      while(true) {
         if(var2 < var1.pointCount()) {
            this.a.add(var1.getPoint(var2));
            ++var2;
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         this.b = var1.getSourcePoint();
         this.c = var1.getTargetPoint();
         break;
      }

   }

   public int pointCount() {
      return this.a.size();
   }

   public y.d.t getPoint(int var1) {
      return (y.d.t)this.a.get(var1);
   }

   public void setPoint(int var1, double var2, double var4) {
      this.a.set(var1, new y.d.t(var2, var4));
   }

   public void addPoint(double var1, double var3) {
      this.a.add(new y.d.t(var1, var3));
   }

   public void clearPoints() {
      this.a.clear();
   }

   public y.d.t getSourcePoint() {
      return this.b;
   }

   public y.d.t getTargetPoint() {
      return this.c;
   }

   public void setSourcePoint(y.d.t var1) {
      this.b = var1;
   }

   public void setTargetPoint(y.d.t var1) {
      this.c = var1;
   }
}
