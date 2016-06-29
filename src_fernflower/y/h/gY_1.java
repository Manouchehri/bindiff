package y.h;

import y.h.aA;
import y.h.bu;
import y.h.eR;
import y.h.eU;
import y.h.fL;
import y.h.x;

public class gY implements y.g.z {
   final bu a;
   int b;
   int c;
   int d;
   int e;

   public gY(bu var1, int var2, int var3, int var4, int var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public boolean a(Object var1) {
      if(var1 instanceof y.c.d) {
         return this.a.i((y.c.d)var1).isVisible()?(this.d & 1) != 0:(this.d & 2) != 0;
      } else if(var1 instanceof y.c.q) {
         return this.a.t((y.c.q)var1).isVisible()?(this.b & 1) != 0:(this.b & 2) != 0;
      } else if(!(var1 instanceof aA)) {
         return var1 instanceof x?(this.a.i(((x)var1).a()).isVisible()?(this.d & 1) != 0:(this.d & 2) != 0):(var1 instanceof fL?(((fL)var1).d().isVisible()?(this.d & 1) != 0:(this.d & 2) != 0):(var1 instanceof eR?(((eR)var1).isVisible()?(this.c & 1) != 0:(this.c & 2) != 0):(var1 instanceof eU?(((eU)var1).b().isVisible()?(this.b & 1) != 0:(this.b & 2) != 0):false)));
      } else {
         aA var2 = (aA)var1;
         return !var2.isVisible() || var2.getOwner() != null && !var2.getOwner().hasVisiblePath()?(this.e & 2) != 0:(this.e & 1) != 0;
      }
   }
}
