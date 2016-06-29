package y.f.f.a.a;

import java.util.*;
import y.c.*;

public class p extends a
{
    protected i b;
    protected Map c;
    
    public p() {
        this.c = new HashMap();
    }
    
    public p(final i i) {
        this();
        this.a(i);
    }
    
    public b a(final b b, final q q) {
        return this.a(b, null, q);
    }
    
    public b a(final b b, final D d, final q q) {
        final b b2 = new b(b, d, q);
        if (q != null) {
            this.a(q, b2);
        }
        return b2;
    }
    
    public void a(final i b) {
        this.b = b;
    }
    
    public void a(final b a) {
        if (a == null) {
            this.a = this.a(null, null, null);
            if (!f.e) {
                return;
            }
        }
        this.a = a;
    }
    
    public void a(final q q, final b b) {
        this.c.put(q, b);
    }
    
    public b a(final q q) {
        return this.c.get(q);
    }
    
    public String toString() {
        return n.a(this);
    }
}
