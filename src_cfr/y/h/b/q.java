/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import y.d.r;
import y.h.b.J;
import y.h.b.M;
import y.h.b.N;
import y.h.b.Y;
import y.h.fj;

final class Q
extends M {
    Q(boolean bl2) {
        super(bl2);
    }

    @Override
    r a(fj fj2) {
        return J.b(fj2).d();
    }

    @Override
    Y b(fj fj2) {
        Y y2 = this.c(fj2);
        if (y2 != null) return y2;
        return new N(fj2.isSelected());
    }

    private Y c(fj fj2) {
        String string;
        if (fj2.isSelected()) {
            string = "y.view.tabular.TableNodePainter.TABLE_SELECTION_STYLE";
            return J.a(fj2, string);
        }
        string = "y.view.tabular.TableNodePainter.TABLE_STYLE";
        return J.a(fj2, string);
    }
}

