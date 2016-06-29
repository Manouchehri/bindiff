/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.awt.Font;
import y.g.X;
import y.g.a;
import y.g.p;

final class aa
extends a {
    aa() {
        Class class_ = X.l == null ? (X.l = X.a("java.awt.Font")) : X.l;
        super(class_);
    }

    @Override
    protected Object a(String string) {
        return Font.decode(string);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected String a(Object var1_1) {
        var2_2 = (Font)var1_1;
        var3_3 = new StringBuffer(50);
        var3_3.append(var2_2.getFamily());
        var3_3.append('-');
        if (var2_2.getStyle() != 0) ** GOTO lbl-1000
        var3_3.append("PLAIN");
        if (p.c) lbl-1000: // 2 sources:
        {
            if ((var2_2.getStyle() & 1) == 1) {
                var3_3.append("BOLD");
            }
            if ((var2_2.getStyle() & 2) == 2) {
                var3_3.append("ITALIC");
            }
        }
        var3_3.append('-');
        var3_3.append(var2_2.getSize());
        return var3_3.toString();
    }
}

