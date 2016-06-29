package y.c;

import java.util.*;

public class y extends D
{
    public y() {
    }
    
    public y(final x x) {
        super(x);
    }
    
    public y(final x x, final c c) {
        super(x, c);
    }
    
    public y(final Iterator iterator) {
        super(iterator);
    }
    
    public y(final q[] array) {
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
    
    public y(final q q) {
        this.b(q);
    }
    
    public y(final y y) {
        this(y.a());
    }
    
    public x a() {
        return new z(this);
    }
    
    public q b() {
        return (q)this.f();
    }
    
    public q c() {
        return (q)this.i();
    }
    
    public q d() {
        return (q)this.g();
    }
    
    public q[] e() {
        return (q[])this.toArray(new q[this.size()]);
    }
}
