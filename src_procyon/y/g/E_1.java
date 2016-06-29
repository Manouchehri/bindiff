package y.g;

import y.c.*;

public class E extends F
{
    private h[] a;
    private h[] b;
    
    public E(final C c) {
        super(c);
    }
    
    protected void b(final i i, final i j) {
        final boolean c = p.c;
        super.b(i, j);
        this.a = i.w();
        this.b = new h[this.a.length];
        int k = 0;
        while (k < this.a.length) {
            this.b[k] = j.u();
            ++k;
            if (c) {
                break;
            }
        }
    }
    
    protected void a(final d d, final d d2) {
        final boolean c = p.c;
        super.a(d, d2);
        int i = 0;
        while (i < this.a.length) {
            this.b[i].a(d2, this.a(d, d2, this.a[i].b(d)));
            ++i;
            if (c) {
                break;
            }
        }
    }
    
    protected Object a(final d d, final d d2, final Object o) {
        return o;
    }
}
