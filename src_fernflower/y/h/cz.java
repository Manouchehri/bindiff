package y.h;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import y.h.cm;

class cz extends AbstractAction {
   private final cm a;

   cz(cm var1, String var2) {
      super(var2);
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.a.b((byte)2, this.a.a(var1));
   }
}
