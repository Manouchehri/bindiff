package y.d.a;

import java.util.*;
import y.c.*;

class h
{
    private D a;
    private d b;
    private final b c;
    
    private h(final b c) {
        this.c = c;
        this.a = new D();
        this.b = new d(this.c);
    }
    
    void a(final Object o, final ArrayList list, final e[] array) {
        final int b = y.d.a.b.b;
        list.clear();
        p p3 = this.a.k();
        p p4 = null;
        p p5 = null;
        int n = 0;
    Label_0106_Outer:
        while (p3 != null) {
            e h = (e)this.a.g(p3);
            final int a = y.d.a.b.a(this.c).a(h.g, o);
            if (b != 0) {
                return;
            }
            if (a > 0) {
                p4 = p3;
            }
            int n2;
            while (true) {
                Label_0119: {
                    if (a != 0) {
                        break Label_0119;
                    }
                    if (n != 0) {
                        throw new RuntimeException("YStruct not correct on get !");
                    }
                    while (true) {
                        list.add(h);
                        h = h.h;
                        if (h != null) {
                            continue Label_0106_Outer;
                        }
                        break;
                    }
                }
                n2 = a;
                if (b != 0) {
                    continue;
                }
                break;
            }
            if (n2 < 0) {
                if (n == 0) {
                    p5 = p3;
                }
                n = 1;
            }
            p3 = this.a.c(p3);
            if (b != 0) {
                break;
            }
        }
        array[0] = (e)this.a.g(p4);
        array[1] = (e)this.a.g(p5);
    }
    
    void a(final Object o, final e e) {
        final int b = y.d.a.b.b;
        p p2 = this.a.k();
        this.b.a(o);
        int compare = -1;
        while (p2 != null && compare < 0) {
            e h = (e)this.a.g(p2);
            compare = this.b.compare(e, h);
            if (compare == 0) {
                e e2 = null;
                while (h.b() < e.b()) {
                    e2 = h;
                    h = h.h;
                    if (h == null) {
                        break;
                    }
                }
                Label_0150: {
                    if (e2 != null) {
                        e.a(e2.h);
                        e2.a(e);
                        if (b == 0) {
                            break Label_0150;
                        }
                    }
                    e.a((e)this.a.g(p2));
                    this.a.a(p2, e);
                }
                e.a(p2);
                return;
            }
            if (compare > 0) {
                e.a(this.a.a(e, p2));
                return;
            }
            p2 = this.a.c(p2);
            if (b != 0) {
                break;
            }
        }
        e.a(this.a.b(e, null));
    }
    
    void a(final e e) {
        final int b = y.d.a.b.b;
        e h = (e)this.a.g(e.b);
        if (h == e) {
            if (e.h == null) {
                this.a.h(h.b);
                if (b == 0) {
                    return;
                }
            }
            this.a.a(e.b, e.h);
            if (b == 0) {
                return;
            }
        }
        while (h.h != e) {
            h = h.h;
            if (b != 0) {
                return;
            }
            if (b != 0) {
                break;
            }
        }
        h.h = e.h;
    }
    
    void a(final Object o) {
        final int b = y.d.a.b.b;
        final ArrayList<e> list = new ArrayList<e>();
        p p = this.a.k();
        p p2 = null;
        int n = 0;
        while (true) {
            while (p != null) {
                final e e = (e)this.a.g(p);
                final h h = this;
                if (b != 0) {
                    h.a(list);
                    return;
                }
                Label_0108: {
                    if (y.d.a.b.a(this.c).e(e.g, o)) {
                        if (n != 0) {
                            throw new RuntimeException("YStruct not correct on swap !");
                        }
                        p2 = p;
                        list.add(e);
                        if (b == 0) {
                            break Label_0108;
                        }
                    }
                    if (p2 != null) {
                        n = 1;
                    }
                }
                p = this.a.c(p);
                if (b != 0) {
                    break;
                }
            }
            final h h = this;
            continue;
        }
    }
    
    void a(final ArrayList list) {
        final int b = y.d.a.b.b;
        if (list.size() == 0) {
            return;
        }
        p p = this.a.k();
        while (this.a.g(p) != list.get(0)) {
            p = this.a.c(p);
            if (b != 0) {
                break;
            }
        }
        int i = list.size() - 1;
        while (i >= 0) {
            if (!this.a.g(p).equals(list.get(list.size() - 1 - i))) {
                throw new RuntimeException("Cannot swap segments");
            }
            e h = list.get(i);
            this.a.a(p, h);
        Block_6:
            while (true) {
                h.a(p);
                h = h.h;
                while (h == null) {
                    p = this.a.c(p);
                    --i;
                    if (b == 0) {
                        break Block_6;
                    }
                }
            }
            if (b != 0) {
                break;
            }
        }
    }
    
    e b(final e e) {
        final p c = this.a.c(e.b);
        if (c == null) {
            return null;
        }
        return (e)this.a.g(c);
    }
    
    e c(final e e) {
        final p d = this.a.d(e.b);
        if (d == null) {
            return null;
        }
        return (e)this.a.g(d);
    }
    
    h(final b b, final c c) {
        this(b);
    }
}
