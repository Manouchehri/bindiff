/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.d;
import y.c.q;
import y.f.c.a.bT;
import y.g.e;

class bV
implements Comparator {
    private final bT a;

    bV(bT bT2) {
        this.a = bT2;
    }

    public int compare(Object object, Object object2) {
        return e.a((int)bT.a(this.a)[((d)object).d().d()], (int)bT.a(this.a)[((d)object2).d().d()]);
    }
}

