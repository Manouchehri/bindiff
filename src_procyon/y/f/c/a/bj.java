package y.f.c.a;

import y.g.*;

public final class bj implements Comparable
{
    final bt a;
    final l b;
    
    private bj(final bt a, final l b) {
        this.a = a;
        this.b = b;
    }
    
    public bt a() {
        return this.a;
    }
    
    public l b() {
        return this.b;
    }
    
    public int compareTo(final Object o) {
        final bj bj = (bj)o;
        final int a = e.a(this.a.a(), bj.a.a());
        if (a != 0) {
            return a;
        }
        return e.a(this.b.a(), bj.b.a());
    }
    
    bj(final bt bt, final l l, final bi bi) {
        this(bt, l);
    }
}
