package y.h.b;

import y.h.*;
import y.d.*;

final class Q extends M
{
    Q(final boolean b) {
        super(b);
    }
    
    r a(final fj fj) {
        return J.b(fj).d();
    }
    
    Y b(final fj fj) {
        final Y c = this.c(fj);
        if (c == null) {
            return new N(fj.isSelected());
        }
        return c;
    }
    
    private Y c(final fj fj) {
        return J.a(fj, fj.isSelected() ? "y.view.tabular.TableNodePainter.TABLE_SELECTION_STYLE" : "y.view.tabular.TableNodePainter.TABLE_STYLE");
    }
}
