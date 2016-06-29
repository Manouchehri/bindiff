/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import y.d.r;
import y.h.b.J;
import y.h.b.M;
import y.h.b.O;
import y.h.b.Y;
import y.h.b.c;
import y.h.fj;

class R
extends M {
    private final boolean a;

    R(boolean bl2, boolean bl3) {
        super(bl2);
        this.a = bl3;
    }

    @Override
    r a(fj fj2) {
        return J.c(fj2).i();
    }

    @Override
    Y b(fj fj2) {
        Y y2 = this.c(fj2);
        if (y2 != null) return y2;
        return new O(J.c(fj2).e());
    }

    private Y c(fj fj2) {
        String string;
        if (this.a) {
            String string2;
            c c2 = J.c(fj2);
            if (c2.b() % 2 == 0) {
                String string3;
                if (J.c(fj2).e()) {
                    string3 = "y.view.tabular.TableNodePainter.COLUMN_SELECTION_STYLE";
                    return J.a(fj2, string3);
                }
                string3 = "y.view.tabular.TableNodePainter.COLUMN_STYLE";
                return J.a(fj2, string3);
            }
            if (J.c(fj2).e()) {
                string2 = "y.view.tabular.TableNodePainter.ALTERNATE_COLUMN_SELECTION_STYLE";
                return J.a(fj2, string2);
            }
            string2 = "y.view.tabular.TableNodePainter.ALTERNATE_COLUMN_STYLE";
            return J.a(fj2, string2);
        }
        if (J.c(fj2).e()) {
            string = "y.view.tabular.TableNodePainter.COLUMN_SELECTION_STYLE";
            return J.a(fj2, string);
        }
        string = "y.view.tabular.TableNodePainter.COLUMN_STYLE";
        return J.a(fj2, string);
    }
}

