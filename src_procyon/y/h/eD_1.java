package y.h;

import java.util.*;
import java.awt.*;
import javax.swing.event.*;

public class eD extends c implements bf
{
    private final Collection a;
    private final Collection b;
    private final eG c;
    private fj d;
    private ch e;
    private eF f;
    
    public eD() {
        this.a = new ArrayList();
        this.b = Collections.unmodifiableCollection((Collection<?>)this.a);
        this.c = new eG(this, null);
    }
    
    public void a(final eF ef) {
        if (ef != null) {
            this.a.add(ef);
        }
    }
    
    public dx a(final fj d, final ch e, final double n, final double n2, final cW cw) {
        if (!this.a()) {
            this.e = null;
            this.d = null;
            return null;
        }
        this.e = e;
        this.d = d;
        if (this.a(n, n2) != null) {
            return this;
        }
        this.e = null;
        this.d = null;
        return null;
    }
    
    public boolean a(final dw dw) {
        final boolean z = fj.z;
        final double a = dw.a();
        final double b = dw.b();
        boolean a2 = false;
        for (final eF ef : this.a) {
            ef.a(this.e, this, this.d);
            if (ef.a(a, b)) {
                a2 = ef.a(dw);
                if (z) {
                    return a2;
                }
                if (a2) {
                    return true;
                }
                continue;
            }
        }
        return a2;
    }
    
    public void e() {
        final boolean z = fj.z;
        if (this.f != null) {
            if (this.f.c()) {
                this.f.e();
            }
            this.f = null;
        }
        if (this.e != null) {
            this.e.setViewCursor(Cursor.getDefaultCursor());
            this.e = null;
        }
        this.d = null;
        final Iterator<eF> iterator = this.a.iterator();
        while (iterator.hasNext()) {
            iterator.next().a(null, null, null);
            if (z) {
                return;
            }
            if (z) {
                break;
            }
        }
        super.e();
    }
    
    public void b(final dw dw) {
        final boolean z = fj.z;
        Label_0235: {
            if (this.f == null) {
                final double a = dw.a();
                final double b = dw.b();
                boolean b2 = false;
                Cursor c = null;
                while (true) {
                    while (true) {
                        for (final eF f : this.a) {
                            f.a(this.e, this, this.d);
                            if (f.a(dw)) {
                                (this.f = f).a(this.c);
                                this.f.d();
                                this.f.b(dw);
                                if (!z) {
                                    break;
                                }
                            }
                            if (f.a(a, b)) {
                                b2 = true;
                                final Cursor cursor = c;
                                if (!z) {
                                    if (cursor != null) {
                                        continue;
                                    }
                                    c = f.c(dw);
                                    if (z) {
                                        break;
                                    }
                                    continue;
                                }
                                else {
                                    if (cursor != null) {
                                        this.e.setViewCursor(c);
                                        if (!z) {
                                            return;
                                        }
                                    }
                                    this.e.setViewCursor(Cursor.getDefaultCursor());
                                    if (!z) {
                                        return;
                                    }
                                    this.e();
                                    if (z) {
                                        break Label_0235;
                                    }
                                    return;
                                }
                            }
                        }
                        if (this.f != null) {
                            return;
                        }
                        if (b2 && this.e != null) {
                            continue;
                        }
                        break;
                    }
                    continue;
                }
            }
        }
        this.f.b(dw);
    }
    
    private eF a(final double n, final double n2) {
        if (!this.a.isEmpty()) {
            for (final eF ef : this.a) {
                ef.a(this.e, this, this.d);
                if (ef.a(n, n2)) {
                    return ef;
                }
            }
        }
        return null;
    }
    
    static eF a(final eD ed, final eF f) {
        return ed.f = f;
    }
}
