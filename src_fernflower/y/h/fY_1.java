package y.h;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import y.h.gb;

class fY extends AbstractAction {
   private final gb a;

   fY(gb var1, String var2) {
      super(var2);
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.a.e(this.a.b() * 2);
   }
}
