package a.a.a;

import a.a.a.c;
import java.lang.reflect.Method;

final class e extends c {
   private e(Class var1, Method[] var2) {
      super(var1, var2);
   }

   static e a() {
      String[] var1 = new String[]{"getCenterPoint", "getRadius", "getFocusPoint", "getFractions", "getColors"};

      try {
         Class var2 = Class.forName("java.awt.RadialGradientPaint");
         Method[] var3 = new Method[var1.length];

         for(int var4 = 0; var4 < var1.length; ++var4) {
            var3[var4] = var2.getMethod(var1[var4], a);
         }

         return new e(var2, var3);
      } catch (ClassNotFoundException var5) {
         return new e((Class)null, (Method[])null);
      } catch (NoSuchMethodException var6) {
         return new e((Class)null, (Method[])null);
      }
   }
}
