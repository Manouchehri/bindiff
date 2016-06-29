package a.a.c;

import a.a.c.b;
import a.a.c.c;
import a.a.c.d;
import java.awt.RenderingHints.Key;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import y.c.D;

public class a implements Cloneable {
   public static final Key a = new c((b)null);
   public static final Object b = new d("force vectorization", (b)null);
   public static final Object c = new d("force rasterization", (b)null);
   public static final Object d = new d("default", (b)null);
   private static final Map e = Collections.synchronizedMap(new WeakHashMap(11));
   private static final Map f = Collections.synchronizedMap(new WeakHashMap(11));
   private static final D g = new D();
   private static int h = 10;
   private static int i = 100000;
   private static boolean j = true;
   private static double k = 0.9D;
   private static final Map l = new WeakHashMap(11);

   public Object clone() {
      try {
         return super.clone();
      } catch (CloneNotSupportedException var2) {
         var2.printStackTrace();
         return null;
      }
   }
}
