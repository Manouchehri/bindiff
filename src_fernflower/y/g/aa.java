package y.g;

import java.awt.Font;
import y.g.X;
import y.g.a;
import y.g.p;

final class aa extends a {
   aa() {
      super(X.l == null?(X.l = X.a("java.awt.Font")):X.l);
   }

   protected Object a(String var1) {
      return Font.decode(var1);
   }

   protected String a(Object var1) {
      Font var2;
      StringBuffer var3;
      label19: {
         var2 = (Font)var1;
         var3 = new StringBuffer(50);
         var3.append(var2.getFamily());
         var3.append('-');
         if(var2.getStyle() == 0) {
            var3.append("PLAIN");
            if(!p.c) {
               break label19;
            }
         }

         if((var2.getStyle() & 1) == 1) {
            var3.append("BOLD");
         }

         if((var2.getStyle() & 2) == 2) {
            var3.append("ITALIC");
         }
      }

      var3.append('-');
      var3.append(var2.getSize());
      return var3.toString();
   }
}
