package y.h;

import javax.swing.JPopupMenu;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import y.h.ch;

class cj implements PopupMenuListener {
   private final JPopupMenu a;
   private final boolean b;
   private final boolean c;
   private final ch d;

   cj(ch var1, JPopupMenu var2, boolean var3, boolean var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public void popupMenuCanceled(PopupMenuEvent var1) {
   }

   public void popupMenuWillBecomeInvisible(PopupMenuEvent var1) {
      this.a.removePopupMenuListener(this);
      if(this.b) {
         ch.access$600(this.d).removeMouseMotionListener(ch.access$500(this.d));
      }

      if(this.c) {
         ch.access$600(this.d).removeMouseListener(ch.access$500(this.d));
      }

   }

   public void popupMenuWillBecomeVisible(PopupMenuEvent var1) {
   }
}
