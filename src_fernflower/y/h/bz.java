package y.h;

import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import y.h.bw;

class bz implements CaretListener {
   private final JTextArea a;
   private final bw b;

   bz(bw var1, JTextArea var2) {
      this.b = var1;
      this.a = var2;
   }

   public void caretUpdate(CaretEvent var1) {
      this.a.revalidate();
   }
}
