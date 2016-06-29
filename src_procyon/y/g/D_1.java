package y.g;

import y.c.*;

public abstract class D extends F
{
    protected final Object a;
    private b b;
    
    protected D(final C c, final Object a) {
        super(c);
        this.a = a;
    }
    
    protected void b(final i i, final i j) {
        super.b(i, j);
        if (j.c(this.a) != null) {
            this.b = (b)j.c(this.a);
            if (!p.c) {
                return;
            }
        }
        this.b = this.a(j);
        j.a(this.a, this.b);
    }
    
    protected abstract b a(final i p0);
    
    protected b b(final i i) {
        if (this.b == null) {
            this.b = this.a(i);
        }
        return this.b;
    }
}
