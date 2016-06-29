package com.google.security.zynamics.zylib.yfileswrap.yfiles;

import y.h.*;
import com.google.common.base.*;
import y.d.*;
import y.h.a.*;
import y.c.*;
import y.f.*;
import java.awt.geom.*;

public final class YHelpers
{
    public static void closeGroup(final bu bu, final q q) {
        Preconditions.checkNotNull(bu, (Object)"Error: Graph argument can not be null");
        Preconditions.checkNotNull(q, (Object)"Error: Group node argument can not be null");
        final v c = bu.C();
        final double p2 = bu.p(q);
        final double q2 = bu.q(q);
        final y y = new y();
        y.add(q);
        bu.r();
        final x a = y.a();
        while (a.f()) {
            c.e(a.e());
            a.g();
        }
        bu.s();
        if (p2 != bu.p(q) || q2 != bu.q(q)) {
            final e l = q.l();
            while (l.f()) {
                bu.a(l.a(), t.c);
                l.g();
            }
            final e k = q.k();
            while (k.f()) {
                bu.b(k.a(), t.c);
                k.g();
            }
        }
        bu.T();
    }
    
    public static void openFolder(final bu bu, final q q) {
        Preconditions.checkNotNull(bu, (Object)"Error: Graph argument can not be null");
        Preconditions.checkNotNull(q, (Object)"Error: Folder node argument can not be null");
        final v c = bu.C();
        final double p2 = bu.p(q);
        final double q2 = bu.q(q);
        final y y = new y();
        y.add(q);
        bu.r();
        final x a = y.a();
        while (a.f()) {
            final bu bu2 = (bu)c.m(a.e());
            final t o = bu.o(a.e());
            final y y2 = new y(bu2.o());
            c.f(a.e());
            final Rectangle2D.Double boundingBox = bu.t(a.e()).getBoundingBox();
            ae.a(bu, y2.a(), o.a - boundingBox.x, o.b - boundingBox.y);
            a.g();
        }
        bu.s();
        bu.N();
        final x a2 = y.a();
        while (a2.f()) {
            bu.a(a2.e(), true);
            a2.g();
        }
        if (p2 != bu.p(q) || q2 != bu.q(q)) {
            final e l = q.l();
            while (l.f()) {
                bu.a(l.a(), t.c);
                l.g();
            }
            final e k = q.k();
            while (k.f()) {
                bu.b(k.a(), t.c);
                k.g();
            }
        }
        bu.T();
    }
}
