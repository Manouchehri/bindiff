package y.h;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import y.h.cm;

class cy extends AbstractAction {
   private final boolean a;
   private final byte b;
   private final cm c;

   cy(cm var1, String var2, boolean var3, byte var4) {
      super(var2);
      this.c = var1;
      this.a = var3;
      this.b = var4;
   }

   public void actionPerformed(ActionEvent var1) {
      this.c.a(this.c.a(var1), this.a, this.b);
   }
}
