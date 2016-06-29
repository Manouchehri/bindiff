package y.h;

import y.h.b.*;
import y.h.a.*;
import y.c.*;
import java.util.*;
import java.awt.*;
import y.b.*;
import javax.swing.*;
import y.f.*;

public class bI
{
    private byte d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private v k;
    private ff l;
    private boolean m;
    private dj n;
    private boolean o;
    static Class a;
    static Class b;
    static Class c;
    
    public bI() {
        this((byte)3);
    }
    
    public bI(final byte b) {
        this.f = true;
        this.g = true;
        this.h = true;
        this.j = true;
        this.o = true;
        this.a(b);
    }
    
    public byte a() {
        return this.d;
    }
    
    public void a(final byte d) {
        switch (d) {
            case 0:
            case 1:
            case 3:
            case 5:
            case 7: {
                if (fj.z) {
                    break;
                }
                this.d = d;
                return;
            }
        }
        throw new IllegalArgumentException("illegal mode");
    }
    
    public boolean b() {
        return this.e;
    }
    
    public v c() {
        if (this.k == null) {
            this.k = new v();
        }
        return this.k;
    }
    
    public ff d() {
        if (this.l == null) {
            this.l = new ff();
        }
        return this.l;
    }
    
    public dj e() {
        if (this.n == null) {
            this.n = this.l();
        }
        return this.n;
    }
    
    public boolean f() {
        return this.g;
    }
    
    public boolean g() {
        return this.h;
    }
    
    public boolean h() {
        return this.i;
    }
    
    public boolean i() {
        return this.j;
    }
    
    public boolean j() {
        return this.f;
    }
    
    public void a(final boolean f) {
        this.f = f;
    }
    
    private void a(final ch ch, final bu bu, final ah ah, final Map map) {
        bu.r();
        if (this.j()) {
            bu.V();
        }
        A a = null;
        c b = null;
        Object o = null;
        Object b2 = null;
        Object c = null;
        if (this.o) {
            if (bu.c(ah.g_) == null) {
                a = gg.a(bu);
                bu.a(ah.g_, a);
            }
            if (bu.c(ah.h_) == null) {
                b = gg.b(bu);
                bu.a(ah.h_, b);
            }
        }
        if (this.i()) {
            c = this.c(ch, bu, ah);
        }
        if (bu.C() != null) {
            if (this.h()) {
                o = this.a(ch, bu, ah);
                b2 = this.b(ch, bu, ah);
            }
            else if (this.f()) {
                o = this.a(ch, bu, ah);
            }
        }
        map.put("nodeSelection", a);
        map.put("edgeSelection", b);
        map.put((bI.a == null) ? (bI.a = a("y.h.a.i")) : bI.a, o);
        map.put((bI.b == null) ? (bI.b = a("y.h.b.v")) : bI.b, b2);
        map.put((bI.c == null) ? (bI.c = a("y.h.ff")) : bI.c, c);
    }
    
    protected i a(final ch ch, final bu bu, final ah ah) {
        final i i = new i(bu);
        i.k();
        return i;
    }
    
    protected v b(final ch ch, final bu bu, final ah ah) {
        final v c = this.c();
        if (ah instanceof y.f.c) {
            final y.f.c c2 = (y.f.c)ah;
            if (c2.g() instanceof an && c2.i()) {
                c.a(((an)c2.g()).d());
            }
        }
        c.a(bu);
        return c;
    }
    
    protected ff c(final ch ch, final bu bu, final ah ah) {
        final ff d = this.d();
        d.a(bu);
        return d;
    }
    
    private void a(final bu bu, final Map map) {
        final A a = map.get("nodeSelection");
        final h h = (h)map.get("edgeSelection");
        final i i = (i)map.get((bI.a == null) ? (bI.a = a("y.h.a.i")) : bI.a);
        this.b(bu, map);
        this.c(bu, map);
        if (map.get("nrics") instanceof c) {
            bu.d_(P.a);
        }
        if (map.get("nrict") instanceof c) {
            bu.d_(P.b);
        }
        if (i != null) {
            this.a(bu, i);
        }
        if (a != null) {
            bu.d_(ah.g_);
        }
        if (h != null) {
            bu.d_(ah.h_);
        }
        bu.s();
    }
    
    private void b(final bu bu, final Map map) {
        final v v = map.get((bI.b == null) ? (bI.b = a("y.h.b.v")) : bI.b);
        if (v != null) {
            this.a(bu, v);
            map.remove((bI.b == null) ? (bI.b = a("y.h.b.v")) : bI.b);
        }
    }
    
    private void c(final bu bu, final Map map) {
        final Class clazz = (bI.c == null) ? (bI.c = a("y.h.ff")) : bI.c;
        final ff ff = map.get(clazz);
        if (ff != null) {
            this.a(bu, ff);
            map.remove(clazz);
        }
    }
    
    protected void a(final bu bu, final i i) {
        i.l();
    }
    
    protected void a(final bu bu, final v v) {
        v.d(bu);
    }
    
    protected void a(final bu bu, final ff ff) {
        ff.d(bu);
    }
    
    private ah a(final ch ch, ah ah) {
        if (this.g() && ch != null && ah instanceof y.f.c) {
            final y.f.c c = (y.f.c)ah;
            if (c.e() instanceof e) {
                this.a(ch, (e)c.e());
            }
        }
        final ad d = this.d().d();
        if (d != null) {
            d.a(ah);
            ah = d;
        }
        return ah;
    }
    
    final void a(final X x, final aw aw) {
        if (this.m()) {
            aw.c(x);
        }
    }
    
    private aw d(final bu bu, final Map map) {
        final aw aw = new aw();
        if (bu.c(P.a) == null) {
            final fk fk = new fk(bu, true);
            map.put("nrics", fk);
            bu.a(P.a, fk);
        }
        if (bu.c(P.b) == null) {
            final fk fk2 = new fk(bu, false);
            map.put("nrict", fk2);
            bu.a(P.b, fk2);
        }
        return aw;
    }
    
    private bS a(final ch ch, final bu bu, final ah ah, final Runnable runnable, final bQ bq, final boolean b) {
        return new bJ(this, ch, bu, ah, b, bq, runnable);
    }
    
    private bS b(final ch ch, final bu bu, final ah ah, final Runnable runnable, final bQ bq, final boolean b) {
        return new bO(this, ch, bu, ah, b, bq, runnable);
    }
    
    public void a(final bu bu, final ah ah) {
        this.a(null, bu, ah, null, null);
    }
    
    public void d(final ch ch, final bu bu, final ah ah) {
        this.a(ch, bu, ah, null, null);
    }
    
    public bR a(final ch ch, final bu bu, final ah ah, final Runnable runnable, bQ bq) {
        final boolean z = fj.z;
        if (bu == null) {
            throw new IllegalArgumentException("graph may not be null.");
        }
        if (ah == null) {
            throw new IllegalArgumentException("layouter may not be null.");
        }
        final boolean b = (this.a() & 0x4) == 0x4;
        final boolean b2 = b || this.a(ch);
        final boolean b3 = ch != null && (this.a() & 0x2) == 0x2 && this.e().preferredDuration() > 0L;
        if ((this.a() & 0x1) != 0x1) {
            final HashMap hashMap = new HashMap();
            this.a(ch, bu, ah, hashMap);
            final ah a = this.a(ch, ah);
            try {
                a.c(bu);
                if (this.m()) {
                    this.a((X)bu, this.d(bu, hashMap));
                }
                bu.T();
            }
            catch (RuntimeException ex) {
                if (bq != null) {
                    bq.a(ex);
                    if (!z) {
                        return null;
                    }
                }
                throw ex;
            }
            finally {
                this.a(bu, hashMap);
                if (runnable != null) {
                    runnable.run();
                }
            }
            return null;
        }
        final Throwable[] array = { null };
        if (!b && bq == null) {
            bq = new bP(this, array);
        }
        bS bs = null;
        Label_0381: {
            if (b3) {
                bs = this.a(ch, bu, ah, runnable, bq, b2);
                if (!z) {
                    break Label_0381;
                }
            }
            bs = this.b(ch, bu, ah, runnable, bq, b2);
        }
        if (b) {
            this.a(bs);
            if (!z) {
                return bs.b();
            }
        }
        bs.run();
        if (array[0] != null) {
            if (array[0] instanceof RuntimeException) {
                throw (RuntimeException)array[0];
            }
            if (array[0] instanceof Error) {
                throw (Error)array[0];
            }
        }
        return bs.b();
    }
    
    protected void a(final Runnable runnable) {
        final Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }
    
    private Map b(final ch ch) {
        if (ch != null && this.b()) {
            final HashMap hashMap = new HashMap();
            this.a(ch, hashMap);
            return hashMap;
        }
        return null;
    }
    
    protected void a(final ch ch, final Map map) {
        map.put("wasInputSuppressed", ch.isInputSuppressed() ? Boolean.TRUE : Boolean.FALSE);
        ch.setInputSuppressed(true);
        map.put("oldCursor", ch.getViewCursor());
        ch.setViewCursor(Cursor.getPredefinedCursor(3));
    }
    
    protected void b(final ch ch, final Map map) {
        if (map.get("wasInputSuppressed") == Boolean.FALSE) {
            ch.setInputSuppressed(false);
        }
        final Cursor value = map.get("oldCursor");
        if (value instanceof Cursor) {
            ch.setViewCursor(value);
        }
    }
    
    protected void a(final ch ch, final e e) {
        final Dimension size = ch.getSize();
        e.a(size.getWidth(), size.getHeight());
        final double n = ch.getGridMode() ? ch.getGridResolution() : 0.0;
        e.a(0.0);
        if (n > 0.0) {
            e.b(n);
            if (!fj.z) {
                return;
            }
        }
        e.b(45.0);
    }
    
    protected y.b.e k() {
        return new y.b.e();
    }
    
    protected dj l() {
        final dj dj = new dj();
        dj.setPreferredDuration(300L);
        dj.setEasedExecution(true);
        return dj;
    }
    
    protected d a(final ch ch, final bu bu, final O o) {
        final dj e = this.e();
        e.initialize(ch, o);
        return e;
    }
    
    protected boolean a(final ch ch) {
        return !SwingUtilities.isEventDispatchThread() && ch != null && ch.isShowing();
    }
    
    protected void a(final bu bu, final O o) {
        ae.a(bu, new dm(bu, o));
    }
    
    public boolean m() {
        return this.m;
    }
    
    public void b(final boolean m) {
        this.m = m;
    }
    
    static Class a(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static Map a(final bI bi, final ch ch) {
        return bi.b(ch);
    }
    
    static void a(final bI bi, final ch ch, final bu bu, final ah ah, final Map map) {
        bi.a(ch, bu, ah, map);
    }
    
    static ah a(final bI bi, final ch ch, final ah ah) {
        return bi.a(ch, ah);
    }
    
    static aw a(final bI bi, final bu bu, final Map map) {
        return bi.d(bu, map);
    }
    
    static void b(final bI bi, final bu bu, final Map map) {
        bi.a(bu, map);
    }
}
