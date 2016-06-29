package y.h;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import y.h.bw;
import y.h.fj;

class by extends KeyAdapter {
   private final boolean a;
   private final JTextArea b;
   private final bw c;

   by(bw var1, boolean var2, JTextArea var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void keyPressed(KeyEvent var1) {
      boolean var2 = fj.z;
      if(var1.getKeyCode() == 10) {
         if(this.a) {
            if(var1.isControlDown() || var1.isShiftDown()) {
               this.b.insert("\n", this.b.getCaretPosition());
               if(!var2) {
                  return;
               }
            }

            this.c.d(true);
            if(!var2) {
               return;
            }
         }

         if(!var1.isControlDown() && !var1.isShiftDown()) {
            return;
         }

         this.c.d(true);
         if(!var2) {
            return;
         }
      }

      if(var1.getKeyCode() == 27) {
         this.c.d(false);
      }

   }
}
