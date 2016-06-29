package y.h;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import y.h.cm;

class cs extends AbstractAction {
   private final cm a;

   cs(cm var1, String var2) {
      super(var2);
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.a.a((byte)0, this.a.a(var1));
   }
}
