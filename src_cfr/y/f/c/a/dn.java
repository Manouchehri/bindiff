/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.ArrayList;
import java.util.List;
import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.do;

final class dn
implements aU {
    final List a = new ArrayList();
    final aV b;
    boolean c;

    dn(aV aV2) {
        this.b = aV2;
    }

    @Override
    public aU a() {
        return new dn(this.b);
    }

    @Override
    public aQ a(int n2) {
        return (aQ)this.a.get(n2);
    }

    @Override
    public aQ a(byte by2, int n2) {
        if (this.a.size() > n2) {
            do do_ = new do(this, by2, n2);
            this.a.add(n2, do_);
            this.c = true;
            return do_;
        }
        if (this.a.size() != n2) throw new IndexOutOfBoundsException();
        do do_ = new do(this, by2, n2);
        this.a.add(do_);
        return do_;
    }

    @Override
    public void b(int n2) {
        if (n2 < this.a.size() - 1) {
            this.c = true;
        }
        do do_ = (do)this.a.remove(n2);
        do_.a = -1;
    }

    @Override
    public int b() {
        return this.a.size();
    }

    void c() {
        boolean bl2 = N.x;
        if (!this.c) return;
        int n2 = 0;
        while (n2 < this.a.size()) {
            do do_ = (do)this.a.get(n2);
            do_.a = n2++;
            if (bl2) return;
            if (!bl2) continue;
        }
        this.c = false;
    }
}

