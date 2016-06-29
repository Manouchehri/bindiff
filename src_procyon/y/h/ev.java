package y.h;

import y.g.*;

final class ev implements Comparable
{
    final double a;
    private final el b;
    private final el c;
    
    public int compareTo(final Object o) {
        return e.a(this.a, ((ev)o).a);
    }
    
    protected ev(final double a, final el b, final el c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public gz a(final boolean b) {
        return new dV(this, 0.5, null, b, this.a, null);
    }
    
    static el a(final ev ev) {
        return ev.c;
    }
    
    static el b(final ev ev) {
        return ev.b;
    }
}
