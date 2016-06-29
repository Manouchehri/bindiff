package y.h.b;

import y.h.fj;
import y.h.b.J;
import y.h.b.M;
import y.h.b.N;
import y.h.b.Y;

final class Q extends M {
   Q(boolean var1) {
      super(var1);
   }

   y.d.r a(fj var1) {
      return J.b(var1).d();
   }

   Y b(fj var1) {
      Y var2 = this.c(var1);
      return (Y)(var2 == null?new N(var1.isSelected()):var2);
   }

   private Y c(fj var1) {
      return J.a(var1, var1.isSelected()?"y.view.tabular.TableNodePainter.TABLE_SELECTION_STYLE":"y.view.tabular.TableNodePainter.TABLE_STYLE");
   }
}
