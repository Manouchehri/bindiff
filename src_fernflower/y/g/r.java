package y.g;

import java.util.Iterator;
import y.g.p;
import y.g.s;

public class r {
   private final y.c.i b;
   y.c.D a;

   public r(y.c.i var1) {
      this.b = var1;
      this.a = new y.c.D();
   }

   public void a(Object var1, y.c.c var2) {
      this.a.add(new s(var1, this.b.c(var1)));
      this.b.a(var1, var2);
   }

   public void a() {
      boolean var3 = p.c;
      Iterator var1 = this.a.iterator();

      while(true) {
         if(var1.hasNext()) {
            s var2 = (s)var1.next();
            this.b.d_(var2.a);
            if(var2.b == null) {
               continue;
            }

            this.b.a(var2.a, var2.b);
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         this.a.clear();
         break;
      }

   }
}
