/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.a;

import java.util.HashMap;
import java.util.Map;
import y.f.f.a.a.a;
import y.f.f.a.a.e;
import y.f.f.a.a.f;
import y.f.f.a.a.g;
import y.f.f.a.a.h;
import y.f.f.a.a.k;
import y.f.f.a.a.l;
import y.f.f.a.a.m;

public class j
implements g {
    protected a a;
    private Map b;

    public j(a a2) {
        this.a = a2;
        this.b = new HashMap();
    }

    public void b() {
        this.b.clear();
    }

    @Override
    public e a() {
        f f2 = (f)this.a.a();
        return (e)this.a(f2);
    }

    public void a(l l2) {
        m.a((h)new k(this, l2), this.a);
    }

    public void a(f f2, Object object) {
        this.b.put(f2, object);
    }

    public Object a(f f2) {
        return this.b.get(f2);
    }
}

