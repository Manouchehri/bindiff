/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.d;
import y.c.q;
import y.f.c.a.bT;
import y.g.e;

class bU
implements Comparator {
    private final bT a;

    bU(bT bT2) {
        this.a = bT2;
    }

    public int compare(Object object, Object object2) {
        return e.a((int)bT.a(this.a)[((d)object).c().d()], (int)bT.a(this.a)[((d)object2).c().d()]);
    }
}

