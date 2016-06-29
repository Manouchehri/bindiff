package y.h;

import java.awt.Graphics;
import javax.swing.JToolTip;

final class il extends JToolTip {
   public void setTipText(String var1) {
      try {
         super.setTipText(var1);
      } catch (ClassCastException var3) {
         if(!a(var1)) {
            throw var3;
         }
      }

   }

   protected void paintComponent(Graphics var1) {
      try {
         super.paintComponent(var1);
      } catch (ClassCastException var3) {
         if(!a(this.getTipText())) {
            throw var3;
         }
      }

   }

   static boolean a(String var0) {
      return var0 != null && var0.length() > 5 && "<html>".equalsIgnoreCase(var0.substring(0, 6));
   }
}
