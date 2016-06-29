package y.g;

import java.awt.geom.Point2D;
import java.beans.Beans;
import java.io.IOException;
import java.util.StringTokenizer;
import y.g.X;
import y.g.a;

final class Y extends a {
   Y() {
      super(X.o == null?(X.o = X.a("java.awt.geom.Point2D")):X.o);
   }

   protected Object a(String var1) {
      StringTokenizer var2 = new StringTokenizer(var1, "(,)", false);

      try {
         String var3 = var2.nextToken();
         Point2D var4 = (Point2D)Beans.instantiate(this.getClass().getClassLoader(), var3);
         double var5 = Double.parseDouble(var2.nextToken());
         double var7 = Double.parseDouble(var2.nextToken());
         var4.setLocation(var5, var7);
         return var4;
      } catch (NumberFormatException var9) {
         throw new IllegalArgumentException("Could not parse number " + var1);
      } catch (ClassNotFoundException var10) {
         throw new IllegalArgumentException("Unknown class " + var10);
      } catch (IOException var11) {
         throw new IllegalArgumentException("Could not load class " + var11);
      }
   }

   protected String a(Object var1) {
      Point2D var2 = (Point2D)var1;
      StringBuffer var3 = new StringBuffer(50);
      var3.append(var2.getClass().getName());
      var3.append('(');
      var3.append(var2.getX());
      var3.append(',');
      var3.append(var2.getY());
      var3.append(')');
      return var3.toString();
   }
}
