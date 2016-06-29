package y.h;

import java.util.*;
import y.c.*;
import y.f.*;
import java.awt.*;
import java.awt.geom.*;

final class dm implements O
{
    private final Map a;
    private final Map b;
    private final bu c;
    private final O d;
    
    dm(final bu c, final O d) {
        final boolean z = fj.z;
        this.c = c;
        this.d = d;
        this.a = new WeakHashMap();
        final x o = c.o();
        while (true) {
            while (o.f()) {
                this.a.put(o.e(), null);
                o.g();
                if (z) {
                    final e p2 = c.p();
                    while (p2.f()) {
                        this.b.put(p2.a(), null);
                        p2.g();
                        if (z) {
                            break;
                        }
                    }
                    return;
                }
                if (z) {
                    break;
                }
            }
            this.b = new WeakHashMap();
            continue;
        }
    }
    
    public am a(final Object o) {
        if (this.a.containsKey(o)) {
            try {
                return this.d.a(o);
            }
            catch (NullPointerException ex) {
                return this.c.a(o);
            }
        }
        return this.c.a(o);
    }
    
    public I b(final Object o) {
        if (this.b.containsKey(o)) {
            try {
                return this.d.b(o);
            }
            catch (NullPointerException ex) {
                return this.c.b(o);
            }
        }
        return this.c.b(o);
    }
    
    public aj[] a_(final Object o) {
        if (this.a.containsKey(o)) {
            try {
                return this.d.a_(o);
            }
            catch (NullPointerException ex) {
                return this.c.a_(o);
            }
        }
        return this.c.a_(o);
    }
    
    public C[] d(final Object o) {
        if (this.b.containsKey(o)) {
            try {
                return this.d.d(o);
            }
            catch (NullPointerException ex) {
                return this.c.d(o);
            }
        }
        return this.c.d(o);
    }
    
    public Rectangle a() {
        final boolean z = fj.z;
        final Rectangle a = this.d.a();
        final x o = this.c.o();
        while (true) {
            while (o.f()) {
                final dm dm = this;
                if (z) {
                    final e p = dm.c.p();
                    while (p.f()) {
                        if (!this.b.containsKey(p.a())) {
                            this.c.i(p.a()).calcUnionRect(a);
                        }
                        p.g();
                        if (z) {
                            break;
                        }
                    }
                    return a;
                }
                if (!this.a.containsKey(o.e())) {
                    this.c.t(o.e()).calcUnionRect(a);
                }
                o.g();
                if (z) {
                    break;
                }
            }
            final dm dm = this;
            continue;
        }
    }
}
