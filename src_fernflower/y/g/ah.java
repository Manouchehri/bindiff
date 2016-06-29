package y.g;

import java.lang.reflect.Constructor;
import y.g.a;

public class ah extends a {
   private Class c;
   static Class b;

   public ah(Class var1) {
      super(var1);
      this.c = var1;
   }

   public ah(Class var1, Class var2) {
      super(var2);
      this.c = var1;
   }

   protected Object a(String var1) {
      try {
         Constructor var2 = this.c.getConstructor(new Class[]{b == null?(b = b("java.lang.String")):b});
         return var2.newInstance(new Object[]{var1});
      } catch (Exception var3) {
         throw new IllegalArgumentException("Could not deserialize " + var1 + " " + var3);
      }
   }

   protected String a(Object var1) {
      return var1.toString();
   }

   static Class b(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
