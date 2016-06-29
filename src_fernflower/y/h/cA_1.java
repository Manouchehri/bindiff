package y.h;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import y.h.bu;
import y.h.ch;
import y.h.cm;
import y.h.fo;
import y.h.fs;

public abstract class cA extends AbstractAction {
   protected final ch a;
   private fs b = new fo();
   private boolean c = true;

   protected cA(String var1, ch var2) {
      super(var1);
      this.a = var2;
   }

   public fs a() {
      return this.b;
   }

   protected y.h.a.v a(bu var1) {
      return y.h.a.v.a((y.c.i)var1);
   }

   protected ch a(ActionEvent var1) {
      return cm.a(var1, this.a);
   }

   public boolean b() {
      return this.c;
   }

   protected void a(y.c.q var1, bu var2) {
      fs var3 = this.a();
      if(var3 != null) {
         var3.a(var1);
      }

   }

   protected void b(y.c.q var1, bu var2) {
      fs var3 = this.a();
      if(var3 != null) {
         var3.b(var1);
      }

   }
}
