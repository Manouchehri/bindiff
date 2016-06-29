package y.h;

import y.h.aB;
import y.h.bu;

class hH extends y.c.d {
   aB l;

   protected hH(bu var1, y.c.q var2, y.c.d var3, y.c.q var4, y.c.d var5, int var6, int var7, aB var8) {
      super(var1, var2, var3, var4, var5, var6, var7);
      if(var8 != null) {
         this.l = var8;
         var8.bindEdge(this);
      }

   }

   public y.c.d a(y.c.i var1, y.c.q var2, y.c.q var3) {
      return (y.c.d)(var1 instanceof bu?new hH((bu)var1, var2, (y.c.d)null, var3, (y.c.d)null, 0, 0, this.l.createCopy()):super.a(var1, var2, var3));
   }

   protected void f() {
      super.f();
      if(this.l != null) {
         this.l.setDirty();
      }

   }
}
