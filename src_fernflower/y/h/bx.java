package y.h;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import y.h.bw;

class bx extends JTextArea {
   private final bw a;

   bx(bw var1, String var2) {
      super(var2);
      this.a = var1;
   }

   public Dimension getPreferredSize() {
      Dimension var1 = super.getPreferredSize();
      if(this.isEditable()) {
         try {
            Rectangle var2 = this.modelToView(this.getCaretPosition());
            if(var2 != null && var1 != null && var2.x + 3 > var1.width) {
               var1.width = var2.x + Math.max(0, var2.width) + 3;
            }
         } catch (BadLocationException var4) {
            ;
         }
      }

      return var1;
   }

   protected void paintComponent(Graphics var1) {
      if(var1.getFontMetrics().getHeight() > 0) {
         super.paintComponent(var1);
      }

   }
}
