package y.a;

import y.c.*;

final class f
{
    int a;
    byte[] b;
    d[] c;
    int[] d;
    q[] e;
    
    f(final int n) {
        this.a = -1;
        this.d = new int[n];
        this.c = new d[n];
        this.b = new byte[n];
        this.e = new q[n];
    }
    
    final boolean a() {
        return this.a < 0;
    }
    
    final void b() {
        --this.a;
    }
    
    final q c() {
        return this.e[this.a];
    }
    
    final d d() {
        return this.c[this.a];
    }
    
    final byte e() {
        return this.b[this.a];
    }
    
    final int f() {
        return this.d[this.a];
    }
    
    final int a(final q q, final d d, final byte b, final int n) {
        ++this.a;
        if (this.a == this.e.length) {
            final int n2 = (this.a + 1) * 2;
            final q[] e = new q[n2];
            System.arraycopy(this.e, 0, e, 0, this.e.length);
            this.e = e;
            final d[] c = new d[n2];
            System.arraycopy(this.c, 0, c, 0, this.c.length);
            this.c = c;
            final int[] d2 = new int[n2];
            System.arraycopy(this.d, 0, d2, 0, this.d.length);
            this.d = d2;
            final byte[] b2 = new byte[n2];
            System.arraycopy(this.b, 0, b2, 0, this.b.length);
            this.b = b2;
        }
        this.e[this.a] = q;
        this.c[this.a] = d;
        this.b[this.a] = b;
        return this.d[this.a] = n;
    }
    
    final void a(final d d, final byte b) {
        this.c[this.a] = d;
        this.b[this.a] = b;
    }
}
