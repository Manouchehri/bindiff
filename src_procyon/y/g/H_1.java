package y.g;

import y.c.*;

public class H extends F
{
    private A[] a;
    private A[] b;
    
    public H(final C c) {
        super(c);
    }
    
    protected void b(final i i, final i j) {
        final boolean c = p.c;
        super.b(i, j);
        this.a = i.v();
        this.b = new A[this.a.length];
        int k = 0;
        while (k < this.a.length) {
            this.b[k] = j.t();
            ++k;
            if (c) {
                break;
            }
        }
    }
    
    protected void a(final q q, final q q2) {
        final boolean c = p.c;
        super.a(q, q2);
        int i = 0;
        while (i < this.a.length) {
            this.b[i].a(q2, this.a(q, q2, this.a[i].b(q)));
            ++i;
            if (c) {
                break;
            }
        }
    }
    
    protected Object a(final q q, final q q2, final Object o) {
        return o;
    }
}
