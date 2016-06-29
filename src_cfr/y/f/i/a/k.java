/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.List;
import y.f.i.a.I;
import y.f.i.a.J;
import y.f.i.a.R;
import y.f.i.a.Z;

public abstract class K
implements J {
    private Z a;
    private I b;

    protected I b() {
        return this.b;
    }

    @Override
    public void a(R r2) {
    }

    @Override
    public void a(R r2, List list) {
    }

    @Override
    public void b(R r2) {
    }

    @Override
    public void a(Z z2, I i2) {
        this.a = z2;
        this.b = i2;
    }

    @Override
    public void a() {
        this.a = null;
        this.b = null;
    }
}

