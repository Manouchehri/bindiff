package y.g;

import java.awt.geom.Rectangle2D;
import java.beans.Beans;
import java.io.IOException;
import java.util.StringTokenizer;
import y.g.X;
import y.g.a;

final class ab extends a {
   ab() {
      super(X.n == null?(X.n = X.a("java.awt.geom.Rectangle2D")):X.n);
   }

   protected Object a(String var1) {
      StringTokenizer var2 = new StringTokenizer(var1, "(,)", false);

      try {
         String var3 = var2.nextToken();
         Rectangle2D var4 = (Rectangle2D)Beans.instantiate(this.getClass().getClassLoader(), var3);
         double var5 = Double.parseDouble(var2.nextToken());
         double var7 = Double.parseDouble(var2.nextToken());
         double var9 = Double.parseDouble(var2.nextToken());
         double var11 = Double.parseDouble(var2.nextToken());
         var4.setFrame(var5, var7, var9, var11);
         return var4;
      } catch (NumberFormatException var13) {
         throw new IllegalArgumentException("Could not parse number " + var1);
      } catch (ClassNotFoundException var14) {
         throw new IllegalArgumentException("Unknown class " + var14);
      } catch (IOException var15) {
         throw new IllegalArgumentException("Could not load class " + var15);
      }
   }

   protected String a(Object var1) {
      Rectangle2D var2 = (Rectangle2D)var1;
      StringBuffer var3 = new StringBuffer(50);
      var3.append(var2.getClass().getName());
      var3.append('(');
      var3.append(var2.getX());
      var3.append(',');
      var3.append(var2.getY());
      var3.append(',');
      var3.append(var2.getWidth());
      var3.append(',');
      var3.append(var2.getHeight());
      var3.append(')');
      return var3.toString();
   }
}
