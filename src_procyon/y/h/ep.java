package y.h;

import java.util.*;
import java.awt.geom.*;
import y.d.*;

class ep extends gz
{
    private ch a;
    private double c;
    private t d;
    private List e;
    private List f;
    
    public ep(final double n, final ch a, final double c, final t d, final List e) {
        super(n);
        if (e.isEmpty()) {
            throw new IllegalArgumentException("movingObjects is empty.");
        }
        this.a = a;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = new ArrayList();
    }
    
    public byte a(final t t, final Point2D.Double double1, final byte b) {
        final z a = this.a(double1.x - this.d.a, double1.y - this.d.b);
        final double abs = Math.abs(a.a());
        final double abs2 = Math.abs(a.b());
        final double n = this.c / this.a.getZoom();
        if (Math.max(abs, abs2) < n) {
            double1.x += a.a();
            double1.y += a.b();
            return 3;
        }
        if (abs < n) {
            double1.x += a.a();
            return 1;
        }
        if (abs2 < n) {
            double1.y += a.b();
            return 2;
        }
        return 0;
    }
    
    private z a(final double n, final double n2) {
        final boolean z = fj.z;
        ew ew = null;
        ew ew2 = null;
        double n3 = Double.MAX_VALUE;
        double n4 = Double.MAX_VALUE;
        final double gridResolution = this.a.getGridResolution();
        int i = 0;
        while (true) {
            while (i < this.e.size()) {
                final ew ew3 = this.e.get(i);
                final double c = ew3.c(gridResolution, n, n2);
                if (!z) {
                    Label_0124: {
                        if (c < n3) {
                            n4 = n3;
                            n3 = c;
                            ew2 = ew;
                            ew = ew3;
                            if (!z) {
                                break Label_0124;
                            }
                        }
                        if (c < n4) {
                            n4 = c;
                            ew2 = ew3;
                        }
                    }
                    ++i;
                    if (z) {
                        break;
                    }
                    continue;
                }
                else {
                    final z a = ew.a(gridResolution, n, n2);
                    if (ew2 == null) {
                        return a;
                    }
                    double n5 = a.a();
                    double n6 = a.b();
                    final z a2 = ew.a(gridResolution, n, n2);
                    if (a2.a() < Double.MAX_VALUE && ew.b()) {
                        n5 = a2.a();
                    }
                    if (a2.b() < Double.MAX_VALUE && ew.a()) {
                        n6 = a2.b();
                    }
                    return new z(n5, n6);
                }
            }
            if (ew == null) {
                return new z(Double.MAX_VALUE, Double.MAX_VALUE);
            }
            continue;
        }
    }
    
    public boolean a(final t t, final t t2, final byte b) {
        final boolean z = fj.z;
        this.f.clear();
        final double n = t2.a - this.d.a;
        final double n2 = t2.b - this.d.b;
        final double gridResolution = this.a.getGridResolution();
        int i = 0;
        double n3 = 0.0;
        while (i < this.e.size()) {
            final ew ew = this.e.get(i);
            n3 = dcmpl(ew.b(gridResolution, n, n2), 0.0);
            if (z) {
                return n3 == 0;
            }
            if (n3 == 0) {
                this.f.add(ew);
            }
            ++i;
            if (z) {
                break;
            }
        }
        this.f.isEmpty();
        return n3 == 0;
    }
    
    public az a(final e e, final t t) {
        return new eb(this, t);
    }
    
    static List a(final ep ep) {
        return ep.f;
    }
    
    static t b(final ep ep) {
        return ep.d;
    }
}
