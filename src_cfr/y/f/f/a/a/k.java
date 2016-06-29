/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.a;

import y.f.f.a.a.c;
import y.f.f.a.a.e;
import y.f.f.a.a.f;
import y.f.f.a.a.h;
import y.f.f.a.a.j;
import y.f.f.a.a.l;

public class k
implements h {
    private l a;
    private final j b;

    public k(j j2, l l2) {
        this.b = j2;
        this.a = l2;
    }

    @Override
    public void a(e e2) {
        f f2 = (f)e2;
        Object object = this.a.b();
        this.b.a(f2, object);
        if (!(object instanceof c)) return;
        ((c)object).a(f2);
        ((c)object).a(this.b);
    }
}

