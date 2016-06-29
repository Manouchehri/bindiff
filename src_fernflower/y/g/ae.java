package y.g;

import java.awt.Color;
import y.g.X;
import y.g.a;

final class ae extends a {
   ae() {
      super(X.i == null?(X.i = X.a("java.awt.Color")):X.i);
   }

   protected Object a(String var1) {
      return Color.decode("0x" + var1.substring(1));
   }

   protected String a(Object var1) {
      Color var2 = (Color)var1;
      StringBuffer var3 = new StringBuffer(7);
      var3.append('#');
      String var4 = Integer.toHexString(var2.getRed());
      if(var4.length() == 1) {
         var3.append('0');
      }

      var3.append(var4);
      var4 = Integer.toHexString(var2.getGreen());
      if(var4.length() == 1) {
         var3.append('0');
      }

      var3.append(var4);
      var4 = Integer.toHexString(var2.getBlue());
      if(var4.length() == 1) {
         var3.append('0');
      }

      var3.append(var4);
      return var3.toString();
   }
}
