package y.f.i.a;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y.f.i.a.P;
import y.f.i.a.ab;
import y.f.i.a.f;

public class U {
   private final List a;
   private final double b;
   private final y.c.d c;

   public U(y.c.d var1, List var2, double var3) {
      this.c = var1;
      this.a = new ArrayList(var2);
      this.b = var3;
   }

   public y.c.d a() {
      return this.c;
   }

   public f a(int var1) {
      return (f)this.a.get(var1);
   }

   public void a(int var1, f var2) {
      this.a.set(var1, var2);
   }

   public int a(f var1) {
      return this.a.indexOf(var1);
   }

   public int b() {
      return this.a.size();
   }

   public String toString() {
      int var6 = ab.a;
      NumberFormat var1 = NumberFormat.getNumberInstance();
      var1.setMaximumFractionDigits(2);
      StringBuffer var2 = new StringBuffer();
      var2.append(this.c);
      var2.append(": ");
      Iterator var3 = this.a.iterator();

      StringBuffer var10000;
      while(true) {
         if(var3.hasNext()) {
            f var4 = (f)var3.next();
            var10000 = var2.append(" << ").append(var4.a().e());
            if(var6 != 0) {
               break;
            }

            P var5 = var4.c();
            if(var5 != null) {
               var2.append(" [").append(var5.b()).append(" ").append(var5.c()).append("]");
            }

            var2.append(" (cost ").append(var1.format(var4.f())).append(")");
            if(var6 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000.toString();
   }
}
