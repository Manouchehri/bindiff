/*
 * Decompiled with CFR 0_115.
 */
package y.b;

import java.util.ArrayList;
import java.util.List;
import y.b.d;
import y.b.l;

abstract class p
implements l {
    List a = new ArrayList(2);
    boolean b = false;
    boolean c = false;

    p() {
    }

    @Override
    public void a(d d2) {
        if (this.b) {
            throw new IllegalStateException();
        }
        if (null == d2) {
            return;
        }
        this.a.add(d2);
        this.c = true;
    }
}

