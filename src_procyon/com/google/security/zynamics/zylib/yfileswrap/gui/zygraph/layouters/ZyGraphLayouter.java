package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.layouters;

import y.h.*;
import y.f.c.*;
import com.google.common.base.*;
import y.f.a.*;
import y.f.k.*;
import y.f.*;
import y.f.c.a.*;
import com.google.security.zynamics.zylib.gui.zygraph.layouters.*;

public class ZyGraphLayouter
{
    public static void alignNodesToTopLayer(final bu bu, final c c) {
        if (c instanceof K) {
            final K k = (K)c;
            k.c((byte)1);
            final an an = (an)k.g();
            k.a(new b(k.o()));
            bu.a(b.a, (an.b() == 0) ? new d() : new y.f.c.c());
        }
        else if (c instanceof M) {
            final M m = (M)c;
            m.b((byte)1);
            m.E().a(0.0);
        }
    }
    
    public static c createCircularLayouter(final CircularStyle circularStyle, final long n) {
        Preconditions.checkNotNull(circularStyle, (Object)"Internal Error: Layout style can't be null");
        Preconditions.checkArgument(n >= 0L, (Object)"Internal Error: Minimum node distance can't be negative");
        final a a = new a();
        switch (ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$CircularStyle[circularStyle.ordinal()]) {
            case 1: {
                a.b((byte)0);
                break;
            }
            case 2: {
                a.b((byte)1);
                break;
            }
            case 3: {
                a.b((byte)3);
                break;
            }
            default: {
                throw new IllegalStateException("Internal Error: Unknown layout style");
            }
        }
        a.c((byte)0);
        final f n2 = a.n();
        n2.h(true);
        n2.a((int)n);
        final o o = a.o();
        o.b((int)n);
        o.h(false);
        return a;
    }
    
    public static c createHierarchicalLayouter(final HierarchicStyle hierarchicStyle, final long n, final long n2, final long n3, final long n4, final HierarchicOrientation hierarchicOrientation) {
        Preconditions.checkNotNull(hierarchicStyle, (Object)"Internal Error: Layout style can't be null");
        Preconditions.checkArgument(n >= 0L, (Object)"Internal Error: Minimum layer distance can't be negative");
        Preconditions.checkArgument(n2 >= 0L, (Object)"Internal Error: Minimum node distance can't be negative");
        Preconditions.checkArgument(n3 >= 0L, (Object)"Internal Error: Minimum edge distance can't be negative");
        final M m = new M();
        m.c((byte)1);
        m.k(true);
        m.g(true);
        m.a((byte)((hierarchicOrientation != HierarchicOrientation.HORIZONTAL) ? 1 : 0));
        m.h(true);
        final B c = m.C();
        c.a(true);
        c.b(true);
        c.a(25.0);
        c.b(25.0);
        m.E().a(0.0);
        new aN(m).a(true);
        switch (ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$HierarchicStyle[hierarchicStyle.ordinal()]) {
            case 1: {
                setStyle((byte)1, (byte)1, true, m, c);
                break;
            }
            case 2: {
                setStyle((byte)1, (byte)0, true, m, c);
                break;
            }
            case 3: {
                setStyle((byte)1, (byte)2, false, m, c);
                break;
            }
            case 4: {
                setStyle((byte)0, (byte)1, true, m, c);
                break;
            }
            case 5: {
                setStyle((byte)0, (byte)0, true, m, c);
                break;
            }
            case 6: {
                setStyle((byte)0, (byte)2, true, m, c);
                break;
            }
            case 7: {
                setStyle((byte)2, (byte)1, true, m, c);
                break;
            }
            case 8: {
                setStyle((byte)2, (byte)0, true, m, c);
                break;
            }
            case 9: {
                setStyle((byte)2, (byte)2, true, m, c);
                break;
            }
            case 10: {
                setStyle((byte)4, (byte)1, true, m, c);
                break;
            }
            case 11: {
                setStyle((byte)4, (byte)0, true, m, c);
                break;
            }
            case 12: {
                setStyle((byte)4, (byte)2, false, m, c);
                break;
            }
            default: {
                throw new IllegalStateException("Internal Error: Unknown layout style");
            }
        }
        m.a(n);
        m.b(n2);
        m.c(n3);
        m.d(n4);
        return m;
    }
    
    private static void setStyle(final byte b, final byte b2, final boolean b3, final M m, final B b4) {
        m.b(b);
        m.i(b3);
        b4.a(new bs(b2));
    }
    
    public static c createIncrementalHierarchicalLayouter(final boolean b, final long n, final long n2, final HierarchicOrientation hierarchicOrientation) {
        final M m = new M();
        ((an)m.g()).a((byte)((hierarchicOrientation != HierarchicOrientation.HORIZONTAL) ? 1 : 0));
        m.a(n);
        m.b(n2);
        m.d(25.0);
        m.c(25.0);
        m.h(true);
        m.b(true);
        m.i(b);
        return m;
    }
    
    public static c createOrthoLayouter(final OrthogonalStyle orthogonalStyle, final long n, final boolean b) {
        Preconditions.checkArgument(n > 0L, (Object)"Internal Error: Grid size can not be 0 or lower.");
        Preconditions.checkNotNull(orthogonalStyle, (Object)"Internal Error: Layout style can't be null");
        final y.f.f.c c = new y.f.f.c();
        c.b((orthogonalStyle == OrthogonalStyle.NORMAL) ? 0 : 4);
        ((an)c.g()).a((byte)(b ? 0 : 1));
        c.a((int)n);
        return c;
    }
}
