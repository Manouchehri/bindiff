package y.h.a;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

class r implements Icon {
   public void paintIcon(Component var1, Graphics var2, int var3, int var4) {
      Color var5 = var2.getColor();
      var2.setColor(Color.white);
      var2.fillRect(var3 + 1, var4 + 1, 14, 14);
      var2.setColor(Color.black);
      var2.drawLine(var3 + 4, var4 + 8, var3 + 12, var4 + 8);
      var2.drawRect(var3 + 1, var4 + 1, 14, 14);
      var2.setColor(var5);
   }

   public int getIconWidth() {
      return 16;
   }

   public int getIconHeight() {
      return 16;
   }
}
