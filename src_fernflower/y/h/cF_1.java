package y.h;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractAction;
import y.h.bu;
import y.h.ch;
import y.h.cm;
import y.h.hV;

public class cF extends AbstractAction {
   private ch a;
   private hV b;

   public cF(ch var1) {
      this.a = var1;
      this.b = new hV(this);
   }

   public void actionPerformed(ActionEvent var1) {
      ch var2 = this.a(var1);
      if(var2 != null) {
         this.a(var2);
         var2.getGraph2D().T();
      }

   }

   public void a(ch var1) {
      bu var2 = var1.getGraph2D();
      var2.r();

      try {
         this.b.a(var2);
      } finally {
         var2.s();
      }

      var1.updateWorldRect();
      var2.T();
   }

   protected void a(bu var1, y.c.y var2, y.c.f var3, Map var4, Map var5) {
      this.b.a(var1, var2, var3, var4, var5);
   }

   protected y.c.y a(bu var1) {
      return this.b.b(var1);
   }

   protected y.c.f b(bu var1) {
      return this.b.c(var1);
   }

   protected void b(bu var1, y.c.y var2, y.c.f var3, Map var4, Map var5) {
      this.b.b(var1, var2, var3, var4, var5);
   }

   protected void c(bu var1, y.c.y var2, y.c.f var3, Map var4, Map var5) {
      this.b.a(var1, var2, var3);
   }

   protected void a(bu var1, List var2, List var3, Map var4, Map var5) {
      this.b.a(var1, var2, var3, var4, var5);
   }

   protected List c(bu var1) {
      return this.b.d(var1);
   }

   protected List d(bu var1) {
      return this.b.e(var1);
   }

   protected void b(bu var1, List var2, List var3, Map var4, Map var5) {
      this.b.a(var2, var3);
   }

   protected void c(bu var1, List var2, List var3, Map var4, Map var5) {
      this.b.a(var1, var2, var3);
   }

   protected ch a(ActionEvent var1) {
      return cm.a(var1, this.a);
   }
}
