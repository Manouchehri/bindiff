/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.yfiles;

import com.google.common.base.Preconditions;
import java.awt.geom.Rectangle2D;
import y.c.C;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.t;
import y.f.X;
import y.f.ae;
import y.h.a.v;
import y.h.bu;
import y.h.fj;

public final class YHelpers {
    private YHelpers() {
    }

    public static void closeGroup(bu bu2, q q2) {
        Preconditions.checkNotNull(bu2, "Error: Graph argument can not be null");
        Preconditions.checkNotNull(q2, "Error: Group node argument can not be null");
        v v2 = bu2.C();
        double d2 = bu2.p(q2);
        double d3 = bu2.q(q2);
        y y2 = new y();
        y2.add(q2);
        bu2.r();
        C c2 = y2.a();
        while (c2.f()) {
            v2.e(c2.e());
            c2.g();
        }
        bu2.s();
        if (d2 != bu2.p(q2) || d3 != bu2.q(q2)) {
            c2 = q2.l();
            while (c2.f()) {
                bu2.a(c2.a(), t.c);
                c2.g();
            }
            c2 = q2.k();
            while (c2.f()) {
                bu2.b(c2.a(), t.c);
                c2.g();
            }
        }
        bu2.T();
    }

    public static void openFolder(bu bu2, q q2) {
        Preconditions.checkNotNull(bu2, "Error: Graph argument can not be null");
        Preconditions.checkNotNull(q2, "Error: Folder node argument can not be null");
        v v2 = bu2.C();
        double d2 = bu2.p(q2);
        double d3 = bu2.q(q2);
        y y2 = new y();
        y2.add(q2);
        bu2.r();
        C c2 = y2.a();
        while (c2.f()) {
            bu bu3 = (bu)v2.m(c2.e());
            t t2 = bu2.o(c2.e());
            y y3 = new y(bu3.o());
            v2.f(c2.e());
            Rectangle2D.Double double_ = bu2.t(c2.e()).getBoundingBox();
            ae.a((X)bu2, y3.a(), t2.a - double_.x, t2.b - double_.y);
            c2.g();
        }
        bu2.s();
        bu2.N();
        c2 = y2.a();
        while (c2.f()) {
            bu2.a(c2.e(), true);
            c2.g();
        }
        if (d2 != bu2.p(q2) || d3 != bu2.q(q2)) {
            c2 = q2.l();
            while (c2.f()) {
                bu2.a(c2.a(), t.c);
                c2.g();
            }
            c2 = q2.k();
            while (c2.f()) {
                bu2.b(c2.a(), t.c);
                c2.g();
            }
        }
        bu2.T();
    }
}

