package y.g;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import y.g.Y;
import y.g.Z;
import y.g.aa;
import y.g.ab;
import y.g.ac;
import y.g.ad;
import y.g.ae;
import y.g.af;
import y.g.ag;
import y.g.ah;

public class X implements ag {
   private static X r;
   private Map s = new HashMap();
   static Class a;
   static Class b;
   static Class c;
   static Class d;
   static Class e;
   static Class f;
   static Class g;
   static Class h;
   static Class i;
   static Class j;
   static Class k;
   static Class l;
   static Class m;
   static Class n;
   static Class o;
   static Class p;
   static Class q;

   protected void a() {
      this.a((Class)(a == null?(a = a("java.lang.Integer")):a), (ag)(new ah(a == null?(a = a("java.lang.Integer")):a, a == null?(a = a("java.lang.Integer")):a)));
      this.a((Class)(b == null?(b = a("java.lang.Float")):b), (ag)(new ah(b == null?(b = a("java.lang.Float")):b, b == null?(b = a("java.lang.Float")):b)));
      this.a((Class)(c == null?(c = a("java.lang.Double")):c), (ag)(new ah(c == null?(c = a("java.lang.Double")):c, c == null?(c = a("java.lang.Double")):c)));
      this.a((Class)(d == null?(d = a("java.lang.Byte")):d), (ag)(new ah(d == null?(d = a("java.lang.Byte")):d, d == null?(d = a("java.lang.Byte")):d)));
      this.a((Class)(e == null?(e = a("java.lang.Short")):e), (ag)(new ah(e == null?(e = a("java.lang.Short")):e, e == null?(e = a("java.lang.Short")):e)));
      this.a((Class)(f == null?(f = a("java.lang.Boolean")):f), (ag)(new ah(f == null?(f = a("java.lang.Boolean")):f, f == null?(f = a("java.lang.Boolean")):f)));
      this.a((Class)(g == null?(g = a("java.lang.Long")):g), (ag)(new ah(g == null?(g = a("java.lang.Long")):g, g == null?(g = a("java.lang.Long")):g)));
      this.a((Class)Integer.TYPE, (ag)(new ah(a == null?(a = a("java.lang.Integer")):a, Integer.TYPE)));
      this.a((Class)Float.TYPE, (ag)(new ah(b == null?(b = a("java.lang.Float")):b, Float.TYPE)));
      this.a((Class)Double.TYPE, (ag)(new ah(c == null?(c = a("java.lang.Double")):c, Double.TYPE)));
      this.a((Class)Byte.TYPE, (ag)(new ah(d == null?(d = a("java.lang.Byte")):d, Byte.TYPE)));
      this.a((Class)Short.TYPE, (ag)(new ah(e == null?(e = a("java.lang.Short")):e, Short.TYPE)));
      this.a((Class)Boolean.TYPE, (ag)(new ah(f == null?(f = a("java.lang.Boolean")):f, Boolean.TYPE)));
      this.a((Class)Long.TYPE, (ag)(new ah(g == null?(g = a("java.lang.Long")):g, Long.TYPE)));
      this.a((Class)(h == null?(h = a("java.lang.String")):h), (ag)(new Z()));
      this.a((Class)(i == null?(i = a("java.awt.Color")):i), (ag)(new ae()));
      this.a((Class)(j == null?(j = a("java.io.File")):j), (ag)(new ah(j == null?(j = a("java.io.File")):j)));
      this.a((Class)(k == null?(k = a("java.util.Date")):k), (ag)(new ah(k == null?(k = a("java.util.Date")):k)));
      this.a((Class)(l == null?(l = a("java.awt.Font")):l), (ag)(new aa()));
      this.a((Class)(m == null?(m = a("java.net.URL")):m), (ag)(new af()));
      this.a((Class)(n == null?(n = a("java.awt.geom.Rectangle2D")):n), (ag)(new ab()));
      this.a((Class)(o == null?(o = a("java.awt.geom.Point2D")):o), (ag)(new Y()));
      this.a((Class)(p == null?(p = a("java.lang.Class")):p), (ag)(new ac()));
      this.a((Class)(q == null?(q = a("java.util.Locale")):q), (ag)(new ad()));
   }

   public void a(Class var1, ag var2) {
      this.s.put(var1, var2);
   }

   public static X b() {
      return r;
   }

   public Object a(String var1, Class var2) {
      if(var1 == null) {
         return null;
      } else {
         ag var3 = this.a(var2);
         if(var3 == null) {
            throw new IllegalArgumentException("No suitable objectStringConverter found for " + var1 + " [" + var2 + "]");
         } else {
            return var3.a(var1, var2);
         }
      }
   }

   public String a(Object var1, Class var2) {
      if(var1 == null) {
         return null;
      } else {
         ag var3 = this.a(var2);
         if(var3 == null) {
            throw new IllegalArgumentException("No suitable objectStringConverter found for " + var1 + " [" + var2 + "]");
         } else {
            return var3.a(var1, var2);
         }
      }
   }

   public ag a(Class var1) {
      ag var2 = (ag)this.s.get(var1);
      if(var2 == null) {
         Iterator var3 = this.s.entrySet().iterator();

         Entry var4;
         Class var5;
         do {
            if(!var3.hasNext()) {
               return null;
            }

            var4 = (Entry)var3.next();
            var5 = (Class)var4.getKey();
         } while(!var5.isAssignableFrom(var1));

         return (ag)var4.getValue();
      } else {
         return var2;
      }
   }

   static Class a(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      X var0 = new X();
      var0.a();
      r = var0;
   }
}
