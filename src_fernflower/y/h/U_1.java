package y.h;

import java.util.Iterator;
import y.h.V;
import y.h.W;
import y.h.X;
import y.h.Y;
import y.h.ag;
import y.h.an;
import y.h.as;
import y.h.bu;
import y.h.cg;
import y.h.hN;

public class U implements cg {
   private static final Iterator a = new V();
   private boolean b = false;
   private boolean c = true;
   private boolean d = false;

   public void a(boolean var1) {
      this.b = var1;
   }

   public void b(boolean var1) {
      this.c = var1;
   }

   public void c(boolean var1) {
      this.d = var1;
   }

   public Iterator a(bu var1, int var2) {
      return this.a(var1, var2, true);
   }

   public Iterator b(bu var1, int var2) {
      return this.a(var1, var2, false);
   }

   private Iterator a(bu var1, int var2, boolean var3) {
      y.h.a.v var4 = y.h.a.v.a((y.c.i)var1);
      return (Iterator)((var2 & 81) != 0 && (var2 & 46) != 0?(var4 != null && this.d?(this.b?(var3?new ag(var1, var4, var2):new Y(var1, var4, var2)):(var3?new as(var1, var4, var2):new an(var1, var4, var2))):(var4 != null && this.c?new hN(new W(var1, var4, var2, var3), new X(var1, var2, var3), this.b ^ var3):new hN(new W(var1, var2, var3), new X(var1, var2, var3), this.b ^ var3))):((var2 & 81) != 0?(var4 != null && this.c?new W(var1, var4, var2, var3):new W(var1, var2, var3)):((var2 & 46) != 0?new X(var1, var2, var3):a)));
   }
}
