/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.c.i;
import y.c.q;
import y.h.bu;
import y.h.fj;

class ii
extends q {
    fj l;

    protected ii(bu bu2, fj fj2) {
        super(bu2);
        if (fj2 == null) return;
        this.l = fj2;
        fj2.b(this);
    }

    @Override
    public q a(i i2) {
        if (!(i2 instanceof bu)) return super.a(i2);
        bu bu2 = (bu)i2;
        return bu2.a(this.l.createCopy());
    }

    @Override
    public String toString() {
        if (this.l == null) return super.toString();
        if (this.l.labelCount() <= 0) return super.toString();
        String string = this.l.getLabelText();
        if (string == null) return super.toString();
        if (string.length() <= 0) return super.toString();
        return string;
    }
}

