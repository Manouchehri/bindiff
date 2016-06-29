/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import y.a.R;
import y.a.h;
import y.c.p;
import y.c.q;
import y.c.y;

class ac
implements R {
    private int a;
    private int b;
    private y[] c;

    public ac(int n2) {
        boolean bl2 = h.a;
        this.a = n2;
        this.b = -1;
        this.c = new y[n2 + 1];
        int n3 = 0;
        do {
            if (n3 >= n2 + 1) return;
            this.c[n3] = new y();
            ++n3;
        } while (!bl2);
    }

    @Override
    public q a() {
        int n2;
        block2 : {
            boolean bl2 = h.a;
            while (this.b >= 0) {
                n2 = (int)this.c[this.b].isEmpty() ? 1 : 0;
                if (!bl2) {
                    if (n2 == 0) break;
                    --this.b;
                    if (!bl2) continue;
                }
                break block2;
            }
            n2 = this.b;
        }
        if (n2 < 0) return null;
        return this.c[this.b].d();
    }

    @Override
    public void a(q q2, int n2) {
        this.c[n2].c(q2);
        if (n2 <= this.b) return;
        this.b = n2;
    }

    @Override
    public void b(q q2, int n2) {
        this.c[n2].add(q2);
    }

    @Override
    public boolean b() {
        int n2;
        block2 : {
            boolean bl2 = h.a;
            while (this.b >= 0) {
                n2 = (int)this.c[this.b].isEmpty() ? 1 : 0;
                if (!bl2) {
                    if (n2 == 0) break;
                    --this.b;
                    if (!bl2) continue;
                }
                break block2;
            }
            n2 = this.b;
        }
        if (n2 >= 0) return false;
        return true;
    }

    @Override
    public void c() {
        boolean bl2 = h.a;
        for (int i2 = 0; i2 <= this.a; ++i2) {
            this.c[i2].clear();
            if (bl2) return;
            if (!bl2) continue;
        }
        this.b = -1;
    }
}

