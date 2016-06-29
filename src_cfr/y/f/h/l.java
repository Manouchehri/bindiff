/*
 * Decompiled with CFR 0_115.
 */
package y.f.h;

import y.c.q;
import y.f.h.M;
import y.f.h.N;

class L {
    private M[] a;
    private int b;
    private int c;

    L(int n2) {
        this.a = new M[n2 + 2];
        this.b = 0;
        this.c = n2;
    }

    /*
     * Unable to fully structure code
     */
    public M a(int var1_1, q var2_2, M var3_3, int var4_4) {
        if (this.b == this.c) {
            this.c += 1024;
            var5_5 = new M[this.c + 2];
            System.arraycopy(this.a, 0, var5_5, 0, this.a.length);
            this.a = var5_5;
        }
        ++this.b;
        if (var3_3 != null) ** GOTO lbl-1000
        var5_5 = new M(var1_1, var2_2, this.b, var4_4);
        if (N.d) lbl-1000: // 2 sources:
        {
            var5_5 = var3_3;
            var3_3.a = var1_1;
            var3_3.b = var2_2;
            var3_3.d = this.b;
            var3_3.c = var4_4;
        }
        this.a(this.b, (M)var5_5);
        return var5_5;
    }

    public void a() {
        boolean bl2 = N.d;
        for (int i2 = 1; i2 <= this.b; ++i2) {
            this.a[i2] = null;
            if (bl2) return;
            if (!bl2) continue;
        }
        this.b = 0;
    }

    public void a(int n2, M m2) {
        boolean bl2 = N.d;
        this.a[0] = m2;
        int n3 = n2 / 2;
        M m3 = this.a[n3];
        while (m3.a > m2.a) {
            this.a[n2] = m3;
            m3.d = n2;
            n2 = n3;
            m3 = this.a[n3 >>= 1];
            if (bl2) return;
            if (!bl2) continue;
        }
        this.a[n2] = m2;
        m2.d = n2;
    }

    public void b(int n2, M m2) {
        boolean bl2 = N.d;
        this.a[this.b + 1] = this.a[this.b];
        for (int i2 = n2 << 1; i2 <= this.b; i2 <<= 1) {
            M m3 = this.a[i2];
            if (bl2) return;
            if (i2 < this.b && this.a[i2 + 1].a < m3.a) {
                m3 = this.a[++i2];
            }
            if (m2.a <= m3.a) break;
            this.a[n2] = m3;
            m3.d = n2;
            n2 = i2;
            if (!bl2) continue;
        }
        this.a[n2] = m2;
        m2.d = n2;
    }

    public void a(M m2) {
        M m3 = this.a[this.b];
        this.a[this.b] = null;
        --this.b;
        if (m2 == m3) return;
        if (m3.a > m2.a) {
            this.b(m2.d, m3);
            if (!N.d) return;
        }
        this.a(m2.d, m3);
    }

    public void a(M m2, int n2) {
        m2.a = n2;
        this.a(m2.d, m2);
    }

    public M b() {
        return this.a[1];
    }

    public boolean c() {
        if (this.b != 0) return false;
        return true;
    }
}

