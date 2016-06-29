package y.f.k;

import y.d.*;

class X extends V
{
    X() {
        super(null);
    }
    
    X(final P p2, final P p3) {
        super(p3);
        final Y y = new Y();
        y.a(new t(p2.f(), p2.g()));
        y.a(new t(p2.e(), p2.d()));
        this.a(y);
        final Y y2 = new Y();
        y2.a(new t(p3.f(), p3.g()));
        y2.a(new t(p3.e(), p3.d()));
        this.a(y2);
    }
}
