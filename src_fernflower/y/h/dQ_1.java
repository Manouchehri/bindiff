package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import y.h.az;
import y.h.dP;

class dQ implements az {
   private final dP a;

   dQ(dP var1) {
      this.a = var1;
   }

   public void a(Graphics2D var1) {
      y.c.q var2 = this.a();
      if(var2 != null) {
         this.a.a(var1, this.a.getGraph2D().t(var2));
      }

   }

   public Rectangle getBounds() {
      y.c.q var1 = this.a();
      return var1 != null?this.a.a(this.a.getGraph2D().t(var1)).getBounds():new Rectangle(0, 0, -1, -1);
   }

   private y.c.q a() {
      Object var1 = this.a.b(dP.a(this.a), dP.b(this.a));
      return var1 instanceof y.c.q?(y.c.q)var1:null;
   }
}
