package y.f.i;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y.f.i.v;

class h {
   y.c.d a;
   int b;
   List c = new ArrayList();

   public h(y.c.d var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean a() {
      return this.c.isEmpty();
   }

   public void a(y.d.t var1, y.d.t var2) {
      int var9 = v.f;
      double var3 = var1.a(var2);
      if(var3 > 0.0D) {
         ArrayList var5 = new ArrayList();
         Iterator var6 = this.c.iterator();

         while(var6.hasNext()) {
            double var7 = ((Double)var6.next()).doubleValue();
            var5.add(new Double(var7 / var3));
            if(var9 != 0) {
               return;
            }

            if(var9 != 0) {
               break;
            }
         }

         this.c = var5;
      }

   }
}
