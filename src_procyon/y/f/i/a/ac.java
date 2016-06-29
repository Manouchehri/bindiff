package y.f.i.a;

import java.util.*;
import y.g.*;
import y.c.*;

public class ac
{
    private final Z a;
    private final h b;
    private final HashMap c;
    private final h d;
    private final h e;
    private boolean f;
    
    public ac(final Z a) {
        this.a = a;
        this.b = M.b();
        this.c = new HashMap();
        this.d = M.b();
        this.e = M.b();
    }
    
    public w a(final U u) {
        w w = this.c.get(u);
        if (w == null) {
            w = new w(u, this.a);
            this.c.put(u, w);
        }
        return w;
    }
    
    public w a(final d d) {
        final U b = this.b(d);
        w w = null;
        if (b != null) {
            w = this.c.get(b);
            if (w == null) {
                w = new w(b, this.a);
                this.c.put(b, w);
            }
        }
        else {
            if (this.d.b(d) != null) {
                return (w)this.d.b(d);
            }
            if (!this.a.c().a(d, d.a())) {
                w = (w)this.e.b(d);
                if (w == null) {
                    w = new w(d, this.a);
                    this.e.a(d, w);
                }
            }
        }
        return w;
    }
    
    public void a(final d d, final U u) {
        this.b.a(d, u);
    }
    
    public U b(final d d) {
        return (U)this.b.b(d);
    }
    
    void a(final d d, final w w) {
        this.d.a(d, w);
    }
    
    boolean a() {
        return this.f;
    }
    
    void a(final boolean f) {
        this.f = f;
    }
}
