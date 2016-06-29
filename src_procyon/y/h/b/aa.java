package y.h.b;

import java.awt.geom.*;
import y.h.a.*;
import y.c.*;
import y.d.*;
import java.util.*;
import y.h.*;

public class aa
{
    private boolean a;
    
    public aa() {
        this.a = true;
    }
    
    private bu a(final a a) {
        final q node = a.getNode();
        return (node == null) ? null : ((bu)node.e());
    }
    
    private boolean b(final a a) {
        final y.h.a.a autoBoundsFeature = a.getAutoBoundsFeature();
        return autoBoundsFeature != null && autoBoundsFeature.isAutoBoundsEnabled();
    }
    
    private void a(final a a, final boolean autoBoundsEnabled) {
        final y.h.a.a autoBoundsFeature = a.getAutoBoundsFeature();
        if (autoBoundsFeature != null) {
            autoBoundsFeature.setAutoBoundsEnabled(autoBoundsEnabled);
        }
    }
    
    public void a(final bu bu, final y y, final z z, final double n, final double n2) {
        final int h = y.h.b.a.H;
        if (!y.isEmpty()) {
            final x a = y.a();
            while (a.f()) {
                bu.t(a.e()).moveBy(n, n2);
                a.g();
                if (h != 0) {
                    return;
                }
                if (h != 0) {
                    break;
                }
            }
        }
        if (!z.isEmpty()) {
            final y.h.y b = z.b();
            while (b.f()) {
                final y.h.x a2 = b.a();
                a2.a(a2.b() + n, a2.c() + n2);
                b.g();
                if (h != 0) {
                    break;
                }
            }
        }
    }
    
    public void a(final q q, final Rectangle2D rectangle2D, final Collection collection) {
        final bu bu = (q == null) ? null : ((bu)q.e());
        final v v = (bu == null) ? null : y.h.a.v.a(bu);
        if (v != null && rectangle2D != null && collection != null) {
            this.a(v, q, rectangle2D, collection);
        }
    }
    
    public void a(final bu bu, final Rectangle2D rectangle2D, final Collection collection) {
        final int i = y.h.b.a.H;
        if (bu != null && rectangle2D != null && collection != null) {
            final e p3 = bu.p();
            do {
                Label_0023: {
                    p3.f();
                }
                boolean contains = false;
                Label_0030:
                while (contains) {
                    final y.h.y bends = bu.i(p3.a()).bends();
                    while (bends.f()) {
                        final y.h.x a = bends.a();
                        contains = rectangle2D.contains(a.b(), a.c());
                        if (i != 0) {
                            continue Label_0030;
                        }
                        if (contains) {
                            collection.add(a);
                        }
                        bends.g();
                        if (i != 0) {
                            break;
                        }
                    }
                    p3.g();
                    continue Label_0023;
                }
                break;
            } while (i == 0);
        }
    }
    
    private void a(final q q, final Rectangle2D rectangle2D, final Collection collection, final Collection collection2) {
        final int i = y.h.b.a.H;
        this.a(q, rectangle2D, collection);
        final bu bu = (q == null) ? null : ((bu)q.e());
        if (this.a()) {
            this.a(bu, rectangle2D, collection2);
            if (i == 0) {
                return;
            }
        }
        if (bu != null && rectangle2D != null && collection != null && collection2 != null) {
            final HashSet set = new HashSet(collection);
            final e p4 = bu.p();
            do {
                Label_0085: {
                    p4.f();
                }
                boolean contains = false;
                Label_0092:
                while (contains) {
                    final d a = p4.a();
                    if (set.contains(a.c()) && set.contains(a.d())) {
                        final y.h.y bends = bu.i(a).bends();
                        while (bends.f()) {
                            final y.h.x a2 = bends.a();
                            contains = rectangle2D.contains(a2.b(), a2.c());
                            if (i != 0) {
                                continue Label_0092;
                            }
                            if (contains) {
                                collection2.add(a2);
                            }
                            bends.g();
                            if (i != 0) {
                                break;
                            }
                        }
                    }
                    p4.g();
                    continue Label_0085;
                }
                break;
            } while (i == 0);
        }
    }
    
    private void a(final v v, final q q, final Rectangle2D rectangle2D, final Collection collection) {
        final int h = y.h.b.a.H;
        final bu bu = (bu)q.e();
        final x p4 = v.p(q);
        while (p4.f()) {
            final q e = p4.e();
            Label_0246: {
                if (v.k(e)) {
                    final x p5 = v.p(e);
                    if (p5.f()) {
                        final LinkedHashSet<q> set = new LinkedHashSet<q>();
                        this.a(v, e, rectangle2D, set);
                        boolean contains = false;
                        Label_0141: {
                            while (p5.f()) {
                                contains = set.contains(p4.e());
                                if (h != 0 || (contains && h == 0)) {
                                    break Label_0141;
                                }
                                p5.g();
                                if (h != 0) {
                                    goto Label_0139;
                                }
                            }
                            goto Label_0139;
                        }
                        if (contains) {
                            collection.add(e);
                        }
                        collection.addAll(set);
                        if (h == 0) {
                            break Label_0246;
                        }
                    }
                    final fj t = bu.t(e);
                    if (!rectangle2D.contains(t.getCenterX(), t.getCenterY())) {
                        break Label_0246;
                    }
                    collection.add(e);
                    if (h == 0) {
                        break Label_0246;
                    }
                }
                final fj t2 = bu.t(e);
                if (rectangle2D.contains(t2.getCenterX(), t2.getCenterY())) {
                    collection.add(e);
                }
            }
            p4.g();
            if (h != 0) {
                break;
            }
        }
    }
    
    public void a(final c c, final y.h.b.d d) {
        final a a = y.h.b.a.a(c);
        final bu a2 = this.a(a);
        if (a2 == null) {
            final boolean b = this.b(a);
            if (b) {
                this.a(a, false);
            }
            try {
                c.a(d);
                return;
            }
            finally {
                if (b) {
                    this.a(a, true);
                }
            }
        }
        a2.r();
        try {
            final q node = a.getNode();
            a2.a(new y(node).a());
            final fj a3 = a(a2, node);
            if (a3 == a) {
                this.a(a, c, d);
                if (y.h.b.a.H == 0) {
                    return;
                }
            }
            if (a3 instanceof a) {
                final a a4 = (a)a3;
                final ArrayList list = new ArrayList();
                this.a(a4, a(c, a4, list), a(d, a4, list));
            }
        }
        finally {
            a2.s();
        }
    }
    
    private void a(final a a, final c c, final y.h.b.d d) {
        final int h = a.H;
        final boolean b = this.b(a);
        if (b) {
            this.a(a, false);
        }
        try {
            final y y = new y();
            final z z = new z();
            final Rectangle2D h2 = c.h();
            this.a(a.getNode(), h2, y, z);
            final double t = a.t();
            final y y2 = new y();
            final z z2 = new z();
            this.a(a.getNode(), new Rectangle2D.Double(a.getX(), a.getY() + t, a.getWidth(), a.getHeight() - t), y2, z2);
            final y.h.b.d a2 = c.a();
            double g = 0.0;
            boolean b2 = false;
            double n = 0.0;
            if (a2 instanceof c) {
                final c c2 = (c)a2;
                g = c2.g();
                b2 = (c2.k() == 1);
            }
            double g2 = 0.0;
            if (d instanceof c) {
                g2 = ((c)d).g();
            }
            final double g3 = c.g();
            c.a(d);
            final double g4 = c.g();
            Label_0277: {
                if (a2 instanceof y.h.b.i) {
                    n = g3;
                    if (h == 0) {
                        break Label_0277;
                    }
                }
                if (a2 instanceof c) {
                    n = g - ((c)a2).g();
                }
            }
            boolean b3 = false;
            double n2 = 0.0;
            Label_0345: {
                if (d instanceof y.h.b.i) {
                    n2 = g4;
                    if (h == 0) {
                        break Label_0345;
                    }
                }
                if (d instanceof c) {
                    final c c3 = (c)d;
                    n2 = c3.g() - g2;
                    b3 = (c3.k() == 1);
                }
            }
            this.a(a, y, z, d, g4, b2, b3, n, n2, c.h(), h2, true);
            final double t2 = a.t();
            if (t2 != t) {
                this.a(a, y2, z2, t2 - t, false);
            }
        }
        finally {
            if (b) {
                this.a(a, true);
            }
        }
    }
    
    public void a(final f f, final g g) {
        final a a = y.h.b.a.a(f);
        final bu a2 = this.a(a);
        if (a2 == null) {
            final boolean b = this.b(a);
            if (b) {
                this.a(a, false);
            }
            try {
                f.a(g);
                return;
            }
            finally {
                if (b) {
                    this.a(a, true);
                }
            }
        }
        a2.r();
        try {
            final q node = a.getNode();
            a2.a(new y(node).a());
            final fj a3 = a(a2, node);
            if (a3 == a) {
                this.a(a, f, g);
                if (y.h.b.a.H == 0) {
                    return;
                }
            }
            if (a3 instanceof a) {
                final a a4 = (a)a3;
                final ArrayList list = new ArrayList();
                this.a(a4, a(f, a4, list), a(g, a4, list));
            }
        }
        finally {
            a2.s();
        }
    }
    
    private void a(final a a, final f f, final g g) {
        final int h = a.H;
        final boolean b = this.b(a);
        if (b) {
            this.a(a, false);
        }
        try {
            final y y = new y();
            final z z = new z();
            final Rectangle2D h2 = f.h();
            this.a(a.getNode(), h2, y, z);
            final double v = a.v();
            final y y2 = new y();
            final z z2 = new z();
            this.a(a.getNode(), new Rectangle2D.Double(a.getX() + v, a.getY(), a.getWidth() - v, a.getHeight()), y2, z2);
            final g a2 = f.a();
            double g2 = 0.0;
            boolean b2 = false;
            double n = 0.0;
            if (a2 instanceof f) {
                final f f2 = (f)a2;
                g2 = f2.g();
                b2 = (f2.n() == 1);
            }
            double g3 = 0.0;
            if (g instanceof f) {
                g3 = ((f)g).g();
            }
            final double g4 = f.g();
            f.a(g);
            final double g5 = f.g();
            Label_0277: {
                if (a2 instanceof y.h.b.i) {
                    n = g4;
                    if (h == 0) {
                        break Label_0277;
                    }
                }
                if (a2 instanceof f) {
                    n = g2 - ((f)a2).g();
                }
            }
            boolean b3 = false;
            double n2 = 0.0;
            Label_0345: {
                if (g instanceof y.h.b.i) {
                    n2 = g5;
                    if (h == 0) {
                        break Label_0345;
                    }
                }
                if (g instanceof f) {
                    final f f3 = (f)g;
                    n2 = f3.g() - g3;
                    b3 = (f3.n() == 1);
                }
            }
            this.a(a, y, z, g, g5, b2, b3, n, n2, f.h(), h2, false);
            final double v2 = a.v();
            if (v2 != v) {
                this.a(a, y2, z2, v2 - v, true);
            }
        }
        finally {
            if (b) {
                this.a(a, true);
            }
        }
    }
    
    private void a(final a a, final y y, final z z, final Object o, final double n, final boolean b, final boolean b2, final double n2, final double n3, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final boolean b3) {
        final int h = a.H;
        final double a2 = a(rectangle2D, b3);
        final double a3 = a(rectangle2D2, b3);
        final double b4 = b(rectangle2D, b3);
        final double b5 = b(rectangle2D2, b3);
        final double a4 = a((fj)a, b3);
        if (b) {
            if (b2) {
                final double n4 = b(a(o, b3), b3) - n3;
                if (a2 > a3) {
                    final y y2 = new y();
                    final z z2 = new z();
                    this.a(a, n4, a4 - n4, y2, z2, b3);
                    this.a(a, y2, z2, n3, b3);
                    this.a(a, y, z, a2 - a3, b3);
                    if (h == 0) {
                        return;
                    }
                }
                this.a(a, y, z, a2 - a3, b3);
                final y y3 = new y();
                final z z3 = new z();
                this.a(a, n4, a4 - n4, y3, z3, b3);
                this.a(a, y3, z3, n3, b3);
                if (h == 0) {
                    return;
                }
            }
            if (a2 > a3) {
                final y y4 = new y();
                final z z4 = new z();
                this.a(a, a2, a4 - a2, y4, z4, b3);
                this.a(a, y4, z4, n, b3);
                this.a(a, y, z, a2 - a3, b3);
                if (h == 0) {
                    return;
                }
            }
            final y y5 = new y();
            final z z5 = new z();
            this.a(a, a2, a3 - a2, y5, z5, b3);
            this.a(a, y, z, a2 - a3, b3);
            this.a(a, b4, a4 - b4, y5, z5, b3);
            this.a(a, y5, z5, n, b3);
            if (h == 0) {
                return;
            }
        }
        if (b2) {
            final double n5 = b(a(o, b3), b3) - n3;
            if (a2 > a3) {
                final y y6 = new y();
                final z z6 = new z();
                this.a(a, b5, n5 - b5 + n2, y6, z6, b3);
                this.a(a, y6, z6, -n2, b3);
                y6.clear();
                this.a(a, n5 + n2, a4 - n5, y6, z6, b3);
                this.a(a, y6, z6, n3 - n2, b3);
                this.a(a, y, z, a2 - a3, b3);
                if (h == 0) {
                    return;
                }
            }
            final y y7 = new y();
            final z z7 = new z();
            this.a(a, n5, a3 - n5, y7, z7, b3);
            this.a(a, y7, z7, n3, b3);
            this.a(a, y, z, a2 - a3, b3);
            y7.clear();
            this.a(a, b5, a4 + n2 - n3 - b5, y7, z7, b3);
            this.a(a, y7, z7, n3 - n2, b3);
            if (h == 0) {
                return;
            }
        }
        if (a2 > a3) {
            final y y8 = new y();
            final z z8 = new z();
            this.a(a, b5, b4 - b5, y8, z8, b3);
            this.a(a, y, z, a2 - a3, b3);
            this.a(a, y8, z8, -n, b3);
            if (h == 0) {
                return;
            }
        }
        final y y9 = new y();
        final z z9 = new z();
        this.a(a, a2, a3 - a2, y9, z9, b3);
        this.a(a, y9, z9, n, b3);
        this.a(a, y, z, a2 - a3, b3);
    }
    
    private static double a(final Rectangle2D rectangle2D, final boolean b) {
        if (b) {
            return rectangle2D.getX();
        }
        return rectangle2D.getY();
    }
    
    private static double b(final Rectangle2D rectangle2D, final boolean b) {
        if (b) {
            return rectangle2D.getMaxX();
        }
        return rectangle2D.getMaxY();
    }
    
    private static double a(final fj fj, final boolean b) {
        if (b) {
            return fj.getX() + fj.getWidth();
        }
        return fj.getY() + fj.getHeight();
    }
    
    private static Rectangle2D a(final Object o, final boolean b) {
        if (b) {
            return ((c)o).h();
        }
        return ((f)o).h();
    }
    
    private void a(final a a, final double n, final double n2, final y y, final z z, final boolean b) {
        if (b) {
            this.a(a.getNode(), new Rectangle2D.Double(n, a.getY(), n2, a.getHeight()), y, z);
            if (a.H == 0) {
                return;
            }
        }
        this.a(a.getNode(), new Rectangle2D.Double(a.getX(), n, a.getWidth(), n2), y, z);
    }
    
    private void a(final a a, final y y, final z z, final double n, final boolean b) {
        final int i = a.H;
        final z z2 = new z();
        final bu a2 = this.a(a);
        a2.r();
        Label_0330: {
            try {
                a2.a(y.a());
                final HashSet<y.h.x> set = new HashSet<y.h.x>();
                final y.c.f f = new y.c.f();
                final HashMap hashMap = new HashMap<d, aB>();
                hashMap.put(null, null);
                final y.h.y b2 = z.b();
                while (true) {
                    while (b2.f()) {
                        final y.h.x a3 = b2.a();
                        set.add(a3);
                        final d a4 = a3.a();
                        if (i != 0) {
                            final e a5 = f.a();
                            while (true) {
                                do {
                                    Label_0177: {
                                        a5.f();
                                    }
                                    boolean f2 = false;
                                    Label_0184:
                                    while (f2) {
                                        final d a6 = a5.a();
                                        final y.h.y bends = a2.i(a6).bends();
                                        if (i == 0) {
                                            final y.h.y bends2 = hashMap.get(a6).bends();
                                            while (bends2.f()) {
                                                f2 = bends.f();
                                                if (i != 0) {
                                                    continue Label_0184;
                                                }
                                                if (!f2) {
                                                    break;
                                                }
                                                if (set.contains(bends2.a())) {
                                                    z2.add(bends.a());
                                                }
                                                bends2.g();
                                                bends.g();
                                                if (i != 0) {
                                                    break;
                                                }
                                            }
                                            a5.g();
                                            continue Label_0177;
                                        }
                                        break Label_0330;
                                    }
                                    break;
                                } while (i == 0);
                                continue;
                            }
                        }
                        if (!hashMap.containsKey(a4)) {
                            hashMap.put(a4, a2.i(a4));
                            f.add(a4);
                        }
                        b2.g();
                        if (i != 0) {
                            break;
                        }
                    }
                    a2.a(f.a());
                    continue;
                }
            }
            finally {
                a2.s();
            }
        }
        if (b) {
            this.a(a2, y, z2, n, 0.0);
            if (i == 0) {
                return;
            }
        }
        this.a(a2, y, z2, 0.0, n);
    }
    
    public void a(final c c, final int n) {
        final int h = y.h.b.a.H;
        final a a = y.h.b.a.a(c);
        final bu a2 = this.a(a);
        final int b = c.b();
        if (b != n) {
            if (a2 == null) {
                c.a(n);
                if (h == 0) {
                    return;
                }
            }
            a2.r();
            try {
                final q node = a.getNode();
                a2.a(new y(node).a());
                final fj a3 = a(a2, node);
                if (a3 == a) {
                    this.a(a, c, b, n);
                    if (h == 0) {
                        return;
                    }
                }
                if (a3 instanceof a) {
                    final a a4 = (a)a3;
                    this.a(a4, a(c, a4), b, n);
                }
            }
            finally {
                a2.s();
            }
        }
    }
    
    private void a(final a a, final c c, final int n, final int n2) {
        final boolean b = this.b(a);
        if (b) {
            this.a(a, false);
        }
        try {
            final Rectangle2D h = c.h();
            c.a(n2);
            this.a(a, c.g(), n, n2, h, c.h(), true);
        }
        finally {
            if (b) {
                this.a(a, b);
            }
        }
    }
    
    public void a(final f f, final int n) {
        final int h = y.h.b.a.H;
        final a a = y.h.b.a.a(f);
        final bu a2 = this.a(a);
        final int b = f.b();
        if (b != n) {
            if (a2 == null) {
                f.a(n);
                if (h == 0) {
                    return;
                }
            }
            a2.r();
            try {
                final q node = a.getNode();
                a2.a(new y(node).a());
                final fj a3 = a(a2, node);
                if (a3 == a) {
                    this.a(a, f, b, n);
                    if (h == 0) {
                        return;
                    }
                }
                if (a3 instanceof a) {
                    final a a4 = (a)a3;
                    this.a(a4, a(f, a4), b, n);
                }
            }
            finally {
                a2.s();
            }
        }
    }
    
    private void a(final a a, final f f, final int n, final int n2) {
        final boolean b = this.b(a);
        if (b) {
            this.a(a, false);
        }
        try {
            final Rectangle2D h = f.h();
            f.a(n2);
            this.a(a, f.g(), n, n2, h, f.h(), false);
        }
        finally {
            if (b) {
                this.a(a, b);
            }
        }
    }
    
    private void a(final a a, final double n, final int n2, final int n3, final Rectangle2D rectangle2D, final Rectangle2D rectangle2D2, final boolean b) {
        final double a2 = a(rectangle2D2, b);
        final double a3 = a(rectangle2D, b);
        final double b2 = b(rectangle2D, b);
        final double b3 = b(rectangle2D2, b);
        final y y = new y();
        final z z = new z();
        this.a(a.getNode(), rectangle2D, y, z);
        Label_0201: {
            if (n3 > n2) {
                final y y2 = new y();
                final z z2 = new z();
                this.a(a.getNode(), a(rectangle2D, b2, b3 - b2, b), y2, z2);
                this.a(a, y2, z2, -n, b);
                if (a.H == 0) {
                    break Label_0201;
                }
            }
            if (n3 < n2) {
                final y y3 = new y();
                final z z3 = new z();
                this.a(a.getNode(), a(rectangle2D, a2, a3 - a2, b), y3, z3);
                this.a(a, y3, z3, n, b);
            }
        }
        this.a(a, y, z, a2 - a3, b);
    }
    
    private static Rectangle2D a(final Rectangle2D rectangle2D, final double n, final double n2, final boolean b) {
        if (b) {
            return new Rectangle2D.Double(n, rectangle2D.getY(), n2, rectangle2D.getHeight());
        }
        return new Rectangle2D.Double(rectangle2D.getX(), n, rectangle2D.getWidth(), n2);
    }
    
    public boolean a(final f f, final double n, final boolean b) {
        final int h = y.h.b.a.H;
        final a a = y.h.b.a.a(f);
        if (this.a(f) > n) {
            return false;
        }
        final bu a2 = this.a(a);
        if (a2 == null) {
            this.a(a, f, n, b);
            if (h == 0) {
                return true;
            }
        }
        a2.r();
        try {
            final q node = a.getNode();
            a2.a(new y(node).a());
            final fj a3 = a(a2, node);
            if (a3 == a) {
                this.a(a, f, n, b);
                if (h == 0) {
                    return true;
                }
            }
            if (a3 instanceof a) {
                final a a4 = (a)a3;
                this.a(a4, a(f, a4), n, b);
                if (h == 0) {
                    return true;
                }
            }
            throw new IllegalStateException();
        }
        finally {
            a2.s();
        }
        return true;
    }
    
    private void a(final a a, final f f, final double n, final boolean b) {
        final int h = a.H;
        final boolean b2 = this.b(a);
        if (b2) {
            this.a(a, false);
        }
        try {
            final double n2 = n - f.g();
            final Rectangle2D h2 = f.h();
            g a2 = f;
            while (a2 instanceof f) {
                final f f2 = (f)a2;
                f2.b(f2.g() + n2);
                a2 = f2.a();
                if (h != 0) {
                    break;
                }
            }
            final y y = new y();
            final double n3 = b ? h2.getY() : (h2.getY() + h2.getHeight());
            final z z = new z();
            this.a(a.getNode(), new Rectangle2D.Double(a.getX(), n3, a.getWidth(), a.getHeight() - n3 + a.getY()), y, z);
            this.a(a, y, z, n2, false);
            final boolean k = a.k();
            a.c(false);
            a.setFrame(a.getX(), a.getY(), a.getWidth(), a.getHeight() + n2);
            a.c(k);
        }
        finally {
            if (b2) {
                this.a(a, b2);
            }
        }
    }
    
    double a(final f f) {
        final int h = y.h.b.a.H;
        double max = f.g() - f.f();
        g a = f;
        double n = 0.0;
    Label_0133_Outer:
        while (a instanceof f) {
            final f f2 = (f)a;
            final r i = f2.i();
            final Iterator iterator = f2.o().iterator();
            n = 0.0;
            if (h != 0) {
                return n;
            }
            double n2 = n;
            while (true) {
                while (iterator.hasNext()) {
                    n2 += iterator.next().g();
                    if (h == 0) {
                        if (h != 0) {
                            break;
                        }
                        continue Label_0133_Outer;
                    }
                    else {
                        if (f2 != f) {
                            n2 -= max;
                        }
                        max = Math.max(0.0, Math.min(max, f2.g() - Math.max(f2.f(), n2)));
                        a = f2.a();
                        if (h != 0) {
                            break Label_0133_Outer;
                        }
                        continue Label_0133_Outer;
                    }
                }
                if (i != null) {
                    n2 += i.a + i.c;
                }
                continue;
            }
        }
        final double n3 = f.g() - max;
        return n;
    }
    
    public boolean a(final c c, final double n, final boolean b) {
        final int h = y.h.b.a.H;
        final a a = y.h.b.a.a(c);
        if (this.a(c) > n) {
            return false;
        }
        final bu a2 = this.a(a);
        if (a2 == null) {
            this.a(a, c, n, b);
            if (h == 0) {
                return true;
            }
        }
        a2.r();
        try {
            final q node = a.getNode();
            a2.a(new y(node).a());
            final fj a3 = a(a2, node);
            if (a3 == a) {
                this.a(a, c, n, b);
                if (h == 0) {
                    return true;
                }
            }
            if (a3 instanceof a) {
                final a a4 = (a)a3;
                this.a(a4, a(c, a4), n, b);
                if (h == 0) {
                    return true;
                }
            }
            throw new IllegalStateException();
        }
        finally {
            a2.s();
        }
        return true;
    }
    
    private void a(final a a, final c c, final double n, final boolean b) {
        final int h = a.H;
        final boolean b2 = this.b(a);
        if (b2) {
            this.a(a, false);
        }
        try {
            final double n2 = n - c.g();
            final Rectangle2D h2 = c.h();
            y.h.b.d a2 = c;
            while (a2 instanceof c) {
                final c c2 = (c)a2;
                c2.b(c2.g() + n2);
                a2 = c2.a();
                if (h != 0) {
                    break;
                }
            }
            final y y = new y();
            final double n3 = b ? h2.getX() : (h2.getX() + h2.getWidth());
            final z z = new z();
            this.a(a.getNode(), new Rectangle2D.Double(n3, a.getY(), a.getWidth() - n3 + a.getX(), a.getHeight()), y, z);
            this.a(a, y, z, n2, true);
            final boolean k = a.k();
            a.c(false);
            a.setFrame(a.getX(), a.getY(), a.getWidth() + n2, a.getHeight());
            a.c(k);
        }
        finally {
            if (b2) {
                this.a(a, b2);
            }
        }
    }
    
    double a(final c c) {
        final int h = y.h.b.a.H;
        double max = c.g() - c.f();
        y.h.b.d a = c;
        double n = 0.0;
    Label_0133_Outer:
        while (a instanceof c) {
            final c c2 = (c)a;
            final r i = c2.i();
            final Iterator iterator = c2.l().iterator();
            n = 0.0;
            if (h != 0) {
                return n;
            }
            double n2 = n;
            while (true) {
                while (iterator.hasNext()) {
                    n2 += iterator.next().g();
                    if (h == 0) {
                        if (h != 0) {
                            break;
                        }
                        continue Label_0133_Outer;
                    }
                    else {
                        if (c2 != c) {
                            n2 -= max;
                        }
                        max = Math.max(0.0, Math.min(max, c2.g() - Math.max(c2.f(), n2)));
                        a = c2.a();
                        if (h != 0) {
                            break Label_0133_Outer;
                        }
                        continue Label_0133_Outer;
                    }
                }
                if (i != null) {
                    n2 += i.b + i.d;
                }
                continue;
            }
        }
        final double n3 = c.g() - max;
        return n;
    }
    
    public boolean a() {
        return this.a;
    }
    
    static c a(final c c, final a a) {
        return a(c, a, new ArrayList());
    }
    
    static c a(final c c, final a a, final List list) {
        final int h = a.H;
        list.clear();
        list.add(c);
        y.h.b.d d = c.a();
        while (d instanceof c) {
            list.add(d);
            d = ((c)d).a();
            if (h != 0) {
                break;
            }
        }
        Object l = a.l();
        final ListIterator<c> listIterator = list.listIterator(list.size());
        c b = null;
        while (listIterator.hasPrevious()) {
            b = ((y.h.b.d)l).b(listIterator.previous().b());
            if (h != 0) {
                return b;
            }
            l = b;
            if (h != 0) {
                break;
            }
        }
        final c c2 = (c)l;
        return b;
    }
    
    static y.h.b.d a(final y.h.b.d d, final a a, final List list) {
        if (d instanceof y.h.b.i) {
            return a.l();
        }
        return a((c)d, a, list);
    }
    
    static f a(final f f, final a a) {
        return a(f, a, new ArrayList());
    }
    
    static f a(final f f, final a a, final List list) {
        final int h = a.H;
        list.clear();
        list.add(f);
        g g = f.a();
        while (g instanceof f) {
            list.add(g);
            g = ((f)g).a();
            if (h != 0) {
                break;
            }
        }
        Object l = a.l();
        final ListIterator<f> listIterator = list.listIterator(list.size());
        f c = null;
        while (listIterator.hasPrevious()) {
            c = ((g)l).c(listIterator.previous().b());
            if (h != 0) {
                return c;
            }
            l = c;
            if (h != 0) {
                break;
            }
        }
        final f f2 = (f)l;
        return c;
    }
    
    static g a(final g g, final a a, final List list) {
        if (g instanceof y.h.b.i) {
            return a.l();
        }
        return a((f)g, a, list);
    }
    
    static fj a(final bu bu, final q q) {
        final fj t = bu.t(q);
        if (t instanceof gd) {
            return ((gd)t).e();
        }
        return t;
    }
}
