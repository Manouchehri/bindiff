package y.h;

import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JToolTip;
import y.h.il;

class hE extends JLabel {
   public void setText(String var1) {
      try {
         super.setText(var1);
      } catch (ClassCastException var3) {
         if(!a(this.getText())) {
            throw var3;
         }
      }

   }

   protected void paintComponent(Graphics var1) {
      try {
         super.paintComponent(var1);
      } catch (ClassCastException var3) {
         if(!a(this.getText())) {
            throw var3;
         }
      }

   }

   public JToolTip createToolTip() {
      il var1 = new il();
      var1.setComponent(this);
      return var1;
   }

   private static boolean a(String var0) {
      return il.a(var0);
   }
}
