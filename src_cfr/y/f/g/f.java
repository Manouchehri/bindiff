/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import java.util.ArrayList;
import java.util.List;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.g.G;
import y.f.g.d;

final class F
implements aU {
    final List a = new ArrayList();
    final aV b;
    boolean c;

    F(aV aV2) {
        this.b = aV2;
    }

    @Override
    public aU a() {
        return new F(this.b);
    }

    @Override
    public aQ a(int n2) {
        return (aQ)this.a.get(n2);
    }

    @Override
    public aQ a(byte by2, int n2) {
        if (this.a.size() > n2) {
            G g2 = new G(this, by2, n2);
            this.a.add(n2, g2);
            this.c = true;
            return g2;
        }
        if (this.a.size() != n2) throw new IndexOutOfBoundsException();
        G g3 = new G(this, by2, n2);
        this.a.add(g3);
        return g3;
    }

    @Override
    public void b(int n2) {
        if (n2 < this.a.size() - 1) {
            this.c = true;
        }
        G g2 = (G)this.a.remove(n2);
        g2.a = -1;
    }

    @Override
    public int b() {
        return this.a.size();
    }

    void c() {
        boolean bl2 = d.d;
        if (!this.c) return;
        int n2 = 0;
        while (n2 < this.a.size()) {
            G g2 = (G)this.a.get(n2);
            g2.a = n2++;
            if (bl2) return;
            if (!bl2) continue;
        }
        this.c = false;
    }
}

