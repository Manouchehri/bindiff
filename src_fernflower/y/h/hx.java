package y.h;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import y.h.hw;

abstract class hx {
   private JComponent a;
   private final hw b;

   hx(hw var1, JComponent var2) {
      this.b = var1;
      this.a = var2;
   }

   public JComponent a() {
      return this.a;
   }

   public abstract Cursor b();

   public void a(MouseEvent var1) {
      this.a(var1, var1.getID());
   }

   public abstract void a(MouseEvent var1, int var2);

   protected void a(Component var1, MouseEvent var2, int var3, int var4, int var5) {
      this.b.a(var1, var2, var3, var4, var5);
   }
}
