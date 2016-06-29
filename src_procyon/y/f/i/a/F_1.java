package y.f.i.a;

import y.f.*;
import java.util.*;
import y.c.*;

class F implements Iterator
{
    private final C a;
    private final D b;
    
    F(final X x) {
        final int a = ab.a;
        this.b = new D();
        final c c = x.c(y.a);
        final HashMap<Object, f> hashMap = new HashMap<Object, f>();
        final e p = x.p();
        while (p.f()) {
            final d a2 = p.a();
            if (a != 0) {
                return;
            }
            final Object o = (c == null) ? null : c.b(a2);
            Label_0170: {
                if (o == null) {
                    this.b.add(new f(a2));
                    if (a == 0) {
                        break Label_0170;
                    }
                }
                final f f = hashMap.get(o);
                if (f == null) {
                    final f f2 = new f(a2);
                    hashMap.put(o, f2);
                    this.b.add(f2);
                    if (a == 0) {
                        break Label_0170;
                    }
                }
                f.add(a2);
            }
            p.g();
            if (a != 0) {
                break;
            }
        }
        this.a = this.b.m();
    }
    
    public boolean hasNext() {
        return this.a.f();
    }
    
    public Object next() {
        if (!this.a.f()) {
            return null;
        }
        final Object d = this.a.d();
        this.a.g();
        return d;
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
