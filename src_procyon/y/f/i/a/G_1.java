package y.f.i.a;

import y.f.*;
import java.util.*;
import y.c.*;

class G implements Iterator
{
    private final C a;
    private final D b;
    
    G(final f f, final X x) {
        final int a = ab.a;
        this.b = new D();
        final c c = x.c(y.a);
        final HashMap<Object, f> hashMap = new HashMap<Object, f>();
        final e a2 = f.a();
        while (a2.f()) {
            final d a3 = a2.a();
            if (a != 0) {
                return;
            }
            final Object o = (c == null) ? null : c.b(a3);
            Label_0173: {
                if (o == null) {
                    this.b.add(new f(a3));
                    if (a == 0) {
                        break Label_0173;
                    }
                }
                final f f2 = hashMap.get(o);
                if (f2 == null) {
                    final f f3 = new f(a3);
                    hashMap.put(o, f3);
                    this.b.add(f3);
                    if (a == 0) {
                        break Label_0173;
                    }
                }
                f2.add(a3);
            }
            a2.g();
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
