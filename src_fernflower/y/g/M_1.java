package y.g;

import java.util.HashMap;
import java.util.Map;
import y.g.R;
import y.g.S;
import y.g.T;

public class M {
   public static y.c.A a(double[] var0) {
      return new S(var0, (int[])null, (boolean[])null, (Object[])null);
   }

   public static y.c.A a(int[] var0) {
      return new S((double[])null, var0, (boolean[])null, (Object[])null);
   }

   public static y.c.A a(boolean[] var0) {
      return new S((double[])null, (int[])null, var0, (Object[])null);
   }

   public static y.c.A a(Object[] var0) {
      return new S((double[])null, (int[])null, (boolean[])null, var0);
   }

   public static y.c.h b(double[] var0) {
      return new T(var0, (int[])null, (boolean[])null, (Object[])null);
   }

   public static y.c.h b(int[] var0) {
      return new T((double[])null, var0, (boolean[])null, (Object[])null);
   }

   public static y.c.h b(boolean[] var0) {
      return new T((double[])null, (int[])null, var0, (Object[])null);
   }

   public static y.c.h b(Object[] var0) {
      return new T((double[])null, (int[])null, (boolean[])null, var0);
   }

   public static y.c.A a() {
      return new R(new HashMap());
   }

   public static y.c.A a(Map var0) {
      return new R(var0);
   }

   public static y.c.h b() {
      return new R(new HashMap());
   }

   public static y.c.b c() {
      return b((Map)(new HashMap()));
   }

   public static y.c.b b(Map var0) {
      return new R(var0);
   }
}
