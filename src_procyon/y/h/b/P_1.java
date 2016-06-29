package y.h.b;

import y.h.*;
import y.d.*;

class P extends M
{
    private final boolean a;
    
    P(final boolean b, final boolean a) {
        super(b);
        this.a = a;
    }
    
    r a(final fj fj) {
        return J.d(fj).i();
    }
    
    Y b(final fj fj) {
        final Y c = this.c(fj);
        if (c == null) {
            return new O(J.d(fj).e());
        }
        return c;
    }
    
    private Y c(final fj fj) {
        if (!this.a) {
            return J.a(fj, J.d(fj).e() ? "y.view.tabular.TableNodePainter.ROW_SELECTION_STYLE" : "y.view.tabular.TableNodePainter.ROW_STYLE");
        }
        if (J.d(fj).b() % 2 == 0) {
            return J.a(fj, J.d(fj).e() ? "y.view.tabular.TableNodePainter.ROW_SELECTION_STYLE" : "y.view.tabular.TableNodePainter.ROW_STYLE");
        }
        return J.a(fj, J.d(fj).e() ? "y.view.tabular.TableNodePainter.ALTERNATE_ROW_SELECTION_STYLE" : "y.view.tabular.TableNodePainter.ALTERNATE_ROW_STYLE");
    }
}
