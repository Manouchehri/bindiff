package y.f;

import java.io.*;
import y.f.b.*;
import java.util.*;
import y.g.*;
import y.c.*;
import y.d.*;

public final class aa
{
    private i a;
    private O b;
    
    public aa(final X x) {
        this(x, x);
    }
    
    public aa(final i a, final O b) {
        this.a = a;
        this.b = b;
    }
    
    public void a(final String s) {
        this.a(new File(s));
    }
    
    public void a(final File file) {
        final FileWriter fileWriter = new FileWriter(file);
        this.a(fileWriter);
        fileWriter.close();
    }
    
    public void a(final Writer writer) {
        final boolean j = X.j;
        final c c = this.a.c(f.c);
        final c c2 = this.a.c(f.b);
        final c c3 = this.a.c(f.d);
        final boolean b = c != null && c2 != null && c3 != null;
        final HashMap<Object, q> hashMap = new HashMap<Object, q>();
        if (b) {
            final x o = this.a.o();
            while (o.f()) {
                hashMap.put(c2.b(o.e()), o.e());
                o.g();
                if (j) {
                    break;
                }
            }
        }
        final ab ab = new ab(writer);
        ab.b("Creator", "yFiles-LayoutGraphWriter");
        ab.b("Version", as.a());
        ab.a("graph");
        ab.b("label", "");
        ab.a("directed", 1);
        if (b) {
            ab.a("hierarchic", 1);
        }
        int n = 0;
        final x o2 = this.a.o();
        while (o2.f()) {
            ++n;
            final q e = o2.e();
            ab.a("node");
            ab.a("id", e.d());
            if (b) {
                if (c3.d(e)) {
                    ab.a("isGroup", 1);
                }
                if (c.b(e) != null) {
                    ab.a("gid", hashMap.get(c.b(e)).d());
                }
            }
            if (this.b != null) {
                ab.a("graphics");
                final am a = this.b.a(e);
                ab.a("x", (float)a.getX() + a.getWidth() * 0.5);
                ab.a("y", (float)a.getY() + a.getHeight() * 0.5);
                ab.a("w", (float)a.getWidth());
                ab.a("h", (float)a.getHeight());
                ab.b("type", "rectangle");
                ab.b();
            }
            ab.b();
            o2.g();
            if (j) {
                break;
            }
        }
        final e p = this.a.p();
        while (p.f()) {
            final d a2 = p.a();
            ab.a("edge");
            ab.a("source", a2.c().d());
            ab.a("target", a2.d().d());
            if (j) {
                return;
            }
            if (this.b != null) {
                final I b2 = this.b.b(a2);
                ab.a("graphics");
                final int pointCount = b2.pointCount();
                Label_0868: {
                    if (pointCount > 0) {
                        ab.a("Line");
                        ab.a("point");
                        final am a3 = this.b.a(a2.c());
                        final t sourcePoint = b2.getSourcePoint();
                        ab.a("x", (float)(sourcePoint.a + a3.getX() + a3.getWidth() * 0.5));
                        ab.a("y", (float)(sourcePoint.b + a3.getY() + a3.getHeight() * 0.5));
                        ab.b();
                        int i = 0;
                        while (true) {
                            while (i < pointCount) {
                                ab.a("point");
                                final t point = b2.getPoint(i);
                                ab.a("x", (float)point.a);
                                ab.a("y", (float)point.b);
                                ab.b();
                                ++i;
                                if (j) {
                                    final am a4 = this.b.a(a2.d());
                                    final t targetPoint = b2.getTargetPoint();
                                    ab.a("x", (float)(targetPoint.a + a4.getX() + a4.getWidth() * 0.5));
                                    ab.a("y", (float)(targetPoint.b + a4.getY() + a4.getHeight() * 0.5));
                                    ab.b();
                                    ab.b();
                                    break Label_0868;
                                }
                                if (j) {
                                    break;
                                }
                            }
                            ab.a("point");
                            continue;
                        }
                    }
                }
                ab.b();
                ab.a("edgeAnchor");
                final t sourcePoint2 = b2.getSourcePoint();
                final am a5 = this.b.a(a2.c());
                if (sourcePoint2.a != 0.0) {
                    ab.a("xSource", (float)(2.0 * sourcePoint2.a / a5.getWidth()));
                }
                if (sourcePoint2.b != 0.0) {
                    ab.a("ySource", (float)(2.0 * sourcePoint2.b / a5.getHeight()));
                }
                final am a6 = this.b.a(a2.d());
                final t targetPoint2 = b2.getTargetPoint();
                if (targetPoint2.a != 0.0) {
                    ab.a("xTarget", (float)(2.0 * targetPoint2.a / a6.getWidth()));
                }
                if (targetPoint2.b != 0.0) {
                    ab.a("yTarget", (float)(2.0 * targetPoint2.b / a6.getHeight()));
                }
                ab.b();
            }
            ab.b();
            p.g();
            if (j) {
                break;
            }
        }
        ab.b();
    }
}
