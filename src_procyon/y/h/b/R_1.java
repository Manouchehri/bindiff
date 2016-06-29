package y.h.b;

import y.h.*;
import y.d.*;

class R extends M
{
    private final boolean a;
    
    R(final boolean b, final boolean a) {
        super(b);
        this.a = a;
    }
    
    r a(final fj fj) {
        return J.c(fj).i();
    }
    
    Y b(final fj fj) {
        final Y c = this.c(fj);
        if (c == null) {
            return new O(J.c(fj).e());
        }
        return c;
    }
    
    private Y c(final fj fj) {
        if (!this.a) {
            return J.a(fj, J.c(fj).e() ? "y.view.tabular.TableNodePainter.COLUMN_SELECTION_STYLE" : "y.view.tabular.TableNodePainter.COLUMN_STYLE");
        }
        if (J.c(fj).b() % 2 == 0) {
            return J.a(fj, J.c(fj).e() ? "y.view.tabular.TableNodePainter.COLUMN_SELECTION_STYLE" : "y.view.tabular.TableNodePainter.COLUMN_STYLE");
        }
        return J.a(fj, J.c(fj).e() ? "y.view.tabular.TableNodePainter.ALTERNATE_COLUMN_SELECTION_STYLE" : "y.view.tabular.TableNodePainter.ALTERNATE_COLUMN_STYLE");
    }
}
