package y.h;

import java.awt.Component;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import y.h.bB;

final class bC implements ContainerListener {
   private final bB a;

   bC(bB var1) {
      this.a = var1;
   }

   public void componentRemoved(ContainerEvent var1) {
      Component var2 = var1.getChild();
      this.a.b(var2);
   }

   public void componentAdded(ContainerEvent var1) {
      Component var2 = var1.getChild();
      this.a.a(var2);
   }
}
