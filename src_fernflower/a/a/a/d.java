package a.a.a;

import a.a.a.c;
import java.lang.reflect.Method;

final class d extends c {
   private d(Class var1, Method[] var2) {
      super(var1, var2);
   }

   static d a() {
      String[] var1 = new String[]{"getStartPoint", "getEndPoint", "getFractions", "getColors"};

      try {
         Class var2 = Class.forName("java.awt.LinearGradientPaint");
         Method[] var3 = new Method[var1.length];

         for(int var4 = 0; var4 < var1.length; ++var4) {
            var3[var4] = var2.getMethod(var1[var4], a);
         }

         return new d(var2, var3);
      } catch (ClassNotFoundException var5) {
         return new d((Class)null, (Method[])null);
      } catch (NoSuchMethodException var6) {
         return new d((Class)null, (Method[])null);
      }
   }
}
