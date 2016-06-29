package y.h;

import java.awt.Graphics2D;
import java.awt.RenderingHints.Key;
import y.h.cV;
import y.h.hl;
import y.h.hm;
import y.h.hn;
import y.h.ho;
import y.h.hp;
import y.h.hq;
import y.h.hr;
import y.h.hs;
import y.h.ht;
import y.h.hu;
import y.h.hv;

public class hk {
   public static final Key a;
   public static final Object b;
   public static final Key c;
   public static final Object d;
   public static final Object e;
   public static final Object f;
   public static final Key g;
   public static final Object h;
   public static final Object i;
   public static final Object j;
   public static final Key k;
   public static final Object l;
   public static final Object m;
   public static final Object n;
   public static final Key o;
   public static final Object p;
   public static final Object q;
   public static final Object r;
   public static final Key s;
   public static final Object t;
   public static final Key u;
   public static final Object v;
   public static final Key w;
   public static final Object x;
   public static final Key y;
   public static final Key z;
   static Class A;
   static Class B;
   static Class C;
   static Class D;
   static Class E;
   static Class F;
   static Class G;
   static Class H;

   public static cV a(Graphics2D var0) {
      return (cV)var0.getRenderingHint(z);
   }

   public static boolean b(Graphics2D var0) {
      return var0.getRenderingHint(a) != b;
   }

   public static boolean c(Graphics2D var0) {
      return var0.getRenderingHint(s) != t;
   }

   public static boolean d(Graphics2D var0) {
      return var0.getRenderingHint(u) != v;
   }

   public static boolean e(Graphics2D var0) {
      return var0.getRenderingHint(w) != x;
   }

   static Class a(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      a = new hv(6003, A == null?(A = a("y.h.hl")):A, "Selection painting enable key");
      b = new hl("selection painting off");
      c = new hv(6004, B == null?(B = a("y.h.hu")):B, "Edge label painting enable key");
      d = new hu("edge label painting default");
      e = new hu("edge label painting on");
      f = new hu("edge label painting off");
      g = new hv(6005, C == null?(C = a("y.h.hm")):C, "Node label painting enable key");
      h = new hm("node label painting default");
      i = new hm("node label painting on");
      j = new hm("node label painting off");
      k = new hv(6006, D == null?(D = a("y.h.ho")):D, "Node port painting enable key");
      l = new ho("node port painting default");
      m = new ho("node port painting on");
      n = new ho("node port painting off");
      o = new hv(6007, E == null?(E = a("y.h.hp")):E, "Group state painting enable key");
      p = new hp("group state painting default");
      q = new hp("group state painting on");
      r = new hp("group state painting off");
      s = new hv(6008, F == null?(F = a("y.h.ht")):F, "Gradient painting enable key");
      t = new ht("gradient painting off");
      u = new hv(6009, G == null?(G = a("y.h.hr")):G, "Shadow painting enable key");
      v = new hr("shadow painting off");
      w = new hv(6010, H == null?(H = a("y.h.hq")):H, "Sloppy polyline painting key");
      x = new hq("sloppy polyline painting off");
      y = new hs();
      z = new hn();
   }
}
