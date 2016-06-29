package y.h.b;

import y.h.fj;
import y.h.b.J;
import y.h.b.M;
import y.h.b.O;
import y.h.b.Y;
import y.h.b.c;

class R extends M {
   private final boolean a;

   R(boolean var1, boolean var2) {
      super(var1);
      this.a = var2;
   }

   y.d.r a(fj var1) {
      return J.c(var1).i();
   }

   Y b(fj var1) {
      Y var2 = this.c(var1);
      return (Y)(var2 == null?new O(J.c(var1).e()):var2);
   }

   private Y c(fj var1) {
      if(this.a) {
         c var2 = J.c(var1);
         return var2.b() % 2 == 0?J.a(var1, J.c(var1).e()?"y.view.tabular.TableNodePainter.COLUMN_SELECTION_STYLE":"y.view.tabular.TableNodePainter.COLUMN_STYLE"):J.a(var1, J.c(var1).e()?"y.view.tabular.TableNodePainter.ALTERNATE_COLUMN_SELECTION_STYLE":"y.view.tabular.TableNodePainter.ALTERNATE_COLUMN_STYLE");
      } else {
         return J.a(var1, J.c(var1).e()?"y.view.tabular.TableNodePainter.COLUMN_SELECTION_STYLE":"y.view.tabular.TableNodePainter.COLUMN_STYLE");
      }
   }
}
