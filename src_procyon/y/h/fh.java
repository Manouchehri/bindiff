package y.h;

import y.d.*;
import y.c.*;
import java.util.*;

final class fh
{
    private final Collection a;
    private final Collection b;
    private t c;
    private boolean d;
    
    fh() {
        this.a = new ArrayList(1);
        this.b = new ArrayList(1);
        this.c = t.c;
        this.d = true;
    }
    
    void a(final d d) {
        this.a.add(d);
        this.d &= d.e();
    }
    
    Iterator a() {
        return this.a.iterator();
    }
    
    void b(final d d) {
        this.b.add(d);
        this.d &= d.e();
    }
    
    Iterator b() {
        return this.b.iterator();
    }
    
    boolean c() {
        return this.a.isEmpty() && this.b.isEmpty();
    }
    
    boolean d() {
        return this.d;
    }
    
    t e() {
        return this.c;
    }
    
    void a(final t c) {
        this.c = c;
    }
}
