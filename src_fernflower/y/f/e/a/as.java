package y.f.e.a;

import y.f.e.a.am;
import y.f.e.a.at;
import y.f.e.a.ay;
import y.f.e.a.d;
import y.f.e.a.n;
import y.f.e.a.t;

public class as extends d {
   public static final Object a = "y.layout.organic.generic.FixedGroupingFeature.FIXED_GROUP_NODE_DP_KEY";
   static Class b;

   public void a(ay var1) {
      super.a(var1);
      this.a(var1, b == null?(b = a("y.f.e.a.e")):b);
      var1.a((y.f.ad)(new n()));
      t var2 = new t(var1);
      var1.e((am)var2);
      var1.b((am)(new at(this, var2)));
   }

   static Class a(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
