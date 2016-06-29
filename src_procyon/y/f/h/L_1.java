package y.f.h;

import y.c.*;

class L
{
    private M[] a;
    private int b;
    private int c;
    
    L(final int c) {
        this.a = new M[c + 2];
        this.b = 0;
        this.c = c;
    }
    
    public M a(final int a, final q b, final M m, final int c) {
        if (this.b == this.c) {
            this.c += 1024;
            final M[] a2 = new M[this.c + 2];
            System.arraycopy(this.a, 0, a2, 0, this.a.length);
            this.a = a2;
        }
        ++this.b;
        M i = null;
        Label_0120: {
            if (m == null) {
                i = new M(a, b, this.b, c);
                if (!N.d) {
                    break Label_0120;
                }
            }
            i = m;
            m.a = a;
            m.b = b;
            m.d = this.b;
            m.c = c;
        }
        this.a(this.b, i);
        return i;
    }
    
    public void a() {
        final boolean d = N.d;
        int i = 1;
        while (i <= this.b) {
            this.a[i] = null;
            ++i;
            if (d) {
                return;
            }
            if (d) {
                break;
            }
        }
        this.b = 0;
    }
    
    public void a(int n, final M m) {
        final boolean d = N.d;
        this.a[0] = m;
        int n2 = n / 2;
        M i = this.a[n2];
        while (i.a > m.a) {
            this.a[n] = i;
            i.d = n;
            n = n2;
            n2 >>= 1;
            i = this.a[n2];
            if (d) {
                return;
            }
            if (d) {
                break;
            }
        }
        this.a[n] = m;
        m.d = n;
    }
    
    public void b(int n, final M m) {
        final boolean d = N.d;
        int i = n << 1;
        this.a[this.b + 1] = this.a[this.b];
        while (i <= this.b) {
            M j = this.a[i];
            if (d) {
                return;
            }
            if (i < this.b && this.a[i + 1].a < j.a) {
                j = this.a[++i];
            }
            if (m.a <= j.a) {
                break;
            }
            this.a[n] = j;
            j.d = n;
            n = i;
            i <<= 1;
            if (d) {
                break;
            }
        }
        this.a[n] = m;
        m.d = n;
    }
    
    public void a(final M m) {
        final M i = this.a[this.b];
        this.a[this.b] = null;
        --this.b;
        if (m != i) {
            if (i.a > m.a) {
                this.b(m.d, i);
                if (!N.d) {
                    return;
                }
            }
            this.a(m.d, i);
        }
    }
    
    public void a(final M m, final int a) {
        m.a = a;
        this.a(m.d, m);
    }
    
    public M b() {
        return this.a[1];
    }
    
    public boolean c() {
        return this.b == 0;
    }
}
