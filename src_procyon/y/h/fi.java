package y.h;

import y.c.*;
import y.d.*;
import y.f.*;
import java.util.*;

final class fi extends a
{
    private final ff a;
    
    private fi(final ff a) {
        this.a = a;
    }
    
    public void c(final X x) {
        this.a(x);
        if (this.a.a()) {
            this.b(x);
            if (!fj.z) {
                return;
            }
        }
        this.d(x);
    }
    
    private void b(final X x) {
        final boolean z = fj.z;
        final c c = x.c(ff.a);
        final c c2 = x.c(aF.a);
        final c c3 = x.c(aF.b);
        if (c != null && x.h() > 0) {
            final bu bu = (bu)((d)c.b(x.l())).a();
            final aZ az = new aZ(ff.e());
            final eU port = az.getPort(0);
            final e p = x.p();
            while (p.f()) {
                final d a = p.a();
                final d d = (d)c.b(a);
                final eU a2 = eU.a(bu, d, true);
                if (a2 != null && ff.a(c2, a)) {
                    final am a3 = x.a((Object)a.c());
                    az.setFrame(a3.getX(), a3.getY(), a3.getWidth(), a3.getHeight());
                    port.a(a2.g());
                    final t b = eU.b(port);
                    final I b2 = x.b((Object)a);
                    if (!b.equals(b2.getSourcePoint())) {
                        b2.setSourcePoint(b);
                    }
                }
                final eU a4 = eU.a(bu, d, false);
                if (a4 != null && ff.a(c3, a)) {
                    final am a5 = x.a((Object)a.d());
                    az.setFrame(a5.getX(), a5.getY(), a5.getWidth(), a5.getHeight());
                    port.a(a4.g());
                    final t b3 = eU.b(port);
                    final I b4 = x.b((Object)a);
                    if (!b3.equals(b4.getTargetPoint())) {
                        b4.setTargetPoint(b3);
                    }
                }
                p.g();
                if (z) {
                    break;
                }
            }
        }
    }
    
    private void d(final X x) {
        final boolean z = fj.z;
        final c c = x.c(ff.a);
        Label_0619: {
            if (c != null && x.h() > 0) {
                final bu bu = (bu)((d)c.b(x.l())).a();
                final aZ az = new aZ(ff.e());
                final eU port = az.getPort(0);
                final HashMap<Object, fh> hashMap = new HashMap<Object, fh>();
                final e p = x.p();
                while (p.f()) {
                    final d a = p.a();
                    final d d = (d)c.b(a);
                    final eU a2 = eU.a(bu, d, true);
                    if (z) {
                        return;
                    }
                    if (a2 != null) {
                        fh fh = hashMap.get(a2);
                        if (fh == null) {
                            fh = new fh();
                            hashMap.put(a2, fh);
                        }
                        if (fh.c() || (fh.d() && !a.e())) {
                            final am a3 = x.a((Object)a.c());
                            az.setFrame(a3.getX(), a3.getY(), a3.getWidth(), a3.getHeight());
                            port.a(a2.g().a().a(az, x.p(a)));
                            fh.a(eU.b(port));
                        }
                        fh.b(a);
                    }
                    final eU a4 = eU.a(bu, d, false);
                    if (a4 != null) {
                        fh fh2 = hashMap.get(a4);
                        if (fh2 == null) {
                            fh2 = new fh();
                            hashMap.put(a4, fh2);
                        }
                        if (fh2.c() || (fh2.d() && !a.e())) {
                            final am a5 = x.a((Object)a.d());
                            az.setFrame(a5.getX(), a5.getY(), a5.getWidth(), a5.getHeight());
                            port.a(a4.g().a().a(az, x.q(a)));
                            fh2.a(eU.b(port));
                        }
                        fh2.a(a);
                    }
                    p.g();
                    if (z) {
                        break;
                    }
                }
            Label_0479:
                for (final fh fh3 : hashMap.values()) {
                    Iterator iterator2 = fh3.a();
                    while (true) {
                        while (iterator2.hasNext()) {
                            x.b((Object)iterator2.next()).setTargetPoint(fh3.e());
                            if (z) {
                                while (iterator2.hasNext()) {
                                    x.b((Object)iterator2.next()).setSourcePoint(fh3.e());
                                    if (z || z) {
                                        break Label_0619;
                                    }
                                }
                                continue Label_0479;
                            }
                            if (z) {
                                break;
                            }
                        }
                        iterator2 = fh3.b();
                        continue;
                    }
                }
            }
        }
    }
    
    fi(final ff ff, final fg fg) {
        this(ff);
    }
}
