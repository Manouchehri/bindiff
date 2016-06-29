package y.c;

import java.util.*;

public class f extends D
{
    public f() {
    }
    
    public f(final d[] array) {
        final boolean e = D.e;
        int i = 0;
        while (i < array.length) {
            this.b(array[i]);
            ++i;
            if (e) {
                break;
            }
        }
    }
    
    public f(final e e) {
        super(e);
    }
    
    public f(final Iterator iterator) {
        super(iterator);
    }
    
    public f(final d d) {
        this.b(d);
    }
    
    public f(final f f) {
        this(f.a());
    }
    
    public e a() {
        return new g(this);
    }
    
    public d b() {
        return (d)this.f();
    }
    
    public d c() {
        return (d)this.i();
    }
    
    public d d() {
        return (d)this.g();
    }
    
    public d[] e() {
        return (d[])this.toArray(new d[this.size()]);
    }
}
