/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import y.c.d;
import y.c.q;
import y.h.aA;
import y.h.aB;
import y.h.bu;
import y.h.eR;
import y.h.eU;
import y.h.fL;
import y.h.fj;
import y.h.x;
import y.h.y;

abstract class hO
implements Iterator {
    final bu d;
    final int e;
    ArrayList f;
    int g;

    protected hO(bu bu2, int n2) {
        this.d = bu2;
        this.e = n2;
    }

    @Override
    public boolean hasNext() {
        if (this.f == null) {
            this.c();
        }
        if (this.g > this.f.size() - 1) {
            this.g = 0;
            this.f.clear();
            this.a();
        }
        if (this.f.isEmpty()) return false;
        return true;
    }

    public Object next() {
        if (!this.hasNext()) throw new NoSuchElementException();
        return this.f.get(this.g++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    void c() {
        this.f = new ArrayList();
    }

    abstract void a();

    void a(d d2) {
        boolean bl2 = fj.z;
        if ((this.e & 2) != 0) {
            this.f.add(d2);
        }
        aB aB2 = this.d.i(d2);
        if ((this.e & 4) != 0) {
            this.f.add(aB2.getSourcePort());
            this.f.add(aB2.getTargetPort());
        }
        if ((this.e & 8) != 0) {
            y y2 = aB2.bends();
            while (y2.f()) {
                this.f.add(y2.a());
                y2.g();
                if (bl2) return;
                if (!bl2) continue;
            }
        }
        if ((this.e & 32) == 0) return;
        int n2 = 0;
        int n3 = aB2.labelCount();
        do {
            if (n2 >= n3) return;
            this.f.add(aB2.getLabel(n2));
            ++n2;
        } while (!bl2);
    }

    void a(q q2) {
        int n2;
        int n3;
        boolean bl2 = fj.z;
        if ((this.e & 1) != 0) {
            this.f.add(q2);
        }
        fj fj2 = this.d.t(q2);
        if ((this.e & 64) != 0) {
            n3 = fj2.portCount();
            for (n2 = 0; n2 < n3; ++n2) {
                this.f.add(fj2.getPort(n2));
                if (bl2) return;
                if (!bl2) continue;
            }
        }
        if ((this.e & 16) == 0) return;
        n2 = 0;
        n3 = fj2.labelCount();
        do {
            if (n2 >= n3) return;
            this.f.add(fj2.getLabel(n2));
            ++n2;
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    void b(d var1_1) {
        var4_2 = fj.z;
        var2_3 = this.d.i(var1_1);
        if ((this.e & 32) == 0) ** GOTO lbl10
        var3_4 = var2_3.labelCount();
        while (var3_4-- > 0) {
            this.f.add(var2_3.getLabel(var3_4));
            if (!var4_2) {
                if (!var4_2) continue;
            }
            ** GOTO lbl-1000
        }
lbl10: // 3 sources:
        if ((this.e & 8) != 0) {
            var3_5 = var2_3.bends();
            var3_5.j();
            while (var3_5.f()) {
                this.f.add(var3_5.a());
                var3_5.h();
                if (!var4_2) {
                    if (!var4_2) continue;
                }
                break;
            }
        } else if ((this.e & 4) != 0) {
            this.f.add(var2_3.getTargetPort());
            this.f.add(var2_3.getSourcePort());
        }
        if ((this.e & 2) == 0) return;
        this.f.add(var1_1);
    }

    void b(q q2) {
        int n2;
        boolean bl2 = fj.z;
        fj fj2 = this.d.t(q2);
        if ((this.e & 16) != 0) {
            n2 = fj2.labelCount();
            while (n2-- > 0) {
                this.f.add(fj2.getLabel(n2));
                if (!bl2) {
                    if (!bl2) continue;
                }
                break;
            }
        } else if ((this.e & 64) != 0) {
            n2 = fj2.portCount();
            while (n2-- > 0) {
                this.f.add(fj2.getPort(n2));
                if (bl2) return;
                if (!bl2) continue;
            }
        }
        if ((this.e & 1) == 0) return;
        this.f.add(q2);
    }
}

