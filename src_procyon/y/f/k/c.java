package y.f.k;

import y.f.*;
import y.c.*;

public abstract class c implements Cloneable, I
{
    private y.c.c b;
    private y.c.c c;
    protected X a;
    
    public K a(final x x, final X x2, final q q) {
        return null;
    }
    
    protected A b(final q q) {
        return (A)this.b.b(q);
    }
    
    protected A c(final q q) {
        return (A)this.c.b(q);
    }
    
    public void a(final q q, final b b) {
        final int g = d.g;
        this.a = (X)q.e();
        try {
            y.c.d d = q.f();
            while (d != null) {
                final q d2 = d.d();
                b.a(d2, this.a(d2));
                d = d.g();
                if (g == 0 && g == 0) {
                    continue;
                }
                return;
            }
            goto Label_0064;
        }
        finally {
            this.a = null;
        }
    }
    
    protected abstract byte a(final q p0);
    
    protected abstract A a(final q p0, final byte p1);
    
    public A a(final y.c.c c, final y.c.c b, final X a, final q q, final byte b2) {
        this.b = b;
        this.c = c;
        this.a = a;
        try {
            return this.a(q, b2);
        }
        finally {}
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException ex) {
            throw new RuntimeException(ex.toString());
        }
    }
}
