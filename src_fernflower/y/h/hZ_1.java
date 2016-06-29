package y.h;

import java.util.Map;

class hZ implements y.g.C {
   private y.g.C a;
   private Map b;
   private Map c;
   private Map d;
   private y.c.f e;

   hZ(y.g.C var1, y.c.f var2, Map var3, Map var4, Map var5) {
      this.a = var1;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var2;
   }

   public y.c.d a(y.c.i var1, y.c.q var2, y.c.q var3, y.c.d var4) {
      y.c.d var5 = this.a.a(var1, var2, var3, var4);
      this.d.put(var5, var4);
      this.e.add(var5);
      return var5;
   }

   public y.c.q a(y.c.i var1, y.c.q var2) {
      y.c.q var3 = this.a.a(var1, var2);
      this.b.put(var3, var2);
      this.c.put(var2, var3);
      return var3;
   }

   public void a(y.c.i var1, y.c.i var2, Map var3, Map var4) {
      this.a.a(var1, var2, var3, var4);
   }

   public void a(y.c.i var1, y.c.i var2) {
      this.a.a(var1, var2);
   }
}
