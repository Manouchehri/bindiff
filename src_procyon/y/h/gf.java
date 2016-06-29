package y.h;

import java.awt.*;
import java.awt.geom.*;
import y.h.a.*;
import y.c.*;
import java.util.*;

public class gf extends d
{
    public static final int TYPE_NODE = 1;
    public static final int TYPE_EDGE = 2;
    public static final int TYPE_BEND = 8;
    public static final int TYPE_NODE_LABEL = 16;
    public static final int TYPE_EDGE_LABEL = 32;
    public static final int TYPE_NODE_PORT = 64;
    private static final int sm = 9;
    private static final int rm = 48;
    private boolean tm;
    private boolean qm;
    
    public gf(final gU gu) {
        super(gu);
    }
    
    public gf() {
    }
    
    public boolean isExtendedTypeSelectionEnabled() {
        return this.tm;
    }
    
    public void setExtendedTypeSelectionEnabled(final boolean tm) {
        this.tm = tm;
    }
    
    public boolean isMixedSelectionEnabled() {
        return this.qm;
    }
    
    public void setMixedSelectionEnabled(final boolean qm) {
        this.qm = qm;
    }
    
    protected void selectionBoxAction(final Rectangle rectangle, final boolean b) {
        final bu graph2D = this.getGraph2D();
        graph2D.r();
        try {
            this.b(graph2D, rectangle, b);
        }
        finally {
            graph2D.s();
        }
        graph2D.T();
    }
    
    private void b(final bu bu, final Rectangle rectangle, final boolean b) {
        final boolean z = fj.z;
        if (this.isExtendedTypeSelectionEnabled()) {
            this.selectTypes(bu, this.adjustTypes(this.getSelectedTypes(bu)), rectangle, b);
            if (!z) {
                return;
            }
        }
        if (!b) {
            this.unselectAll(bu);
            this.c(rectangle);
            if (!z) {
                return;
            }
        }
        if (bu.K().f()) {
            this.b(rectangle);
            if (!z) {
                return;
            }
        }
        this.c(rectangle);
    }
    
    void c(final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        final bu graph2D = this.getGraph2D();
        final x o = graph2D.o();
        while (o.f()) {
            final q e = o.e();
            if (this.belongsToSelection(e, rectangle2D)) {
                this.setSelected(graph2D, e, true);
            }
            o.g();
            if (z) {
                break;
            }
        }
        final y d = graph2D.D();
        while (d.f()) {
            final y.h.x a = d.a();
            if (this.belongsToSelection(a, rectangle2D)) {
                this.setSelected(graph2D, a, true);
            }
            d.g();
            if (z) {
                break;
            }
        }
    }
    
    void b(final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        final bu graph2D = this.getGraph2D();
        final e p = graph2D.p();
        while (p.f()) {
            final y.c.d a = p.a();
            if (this.belongsToSelection(a, rectangle2D)) {
                this.setSelected(graph2D, a, true);
            }
            p.g();
            if (z) {
                break;
            }
        }
    }
    
    protected boolean belongsToSelection(final q q, final Rectangle2D rectangle2D) {
        final bu graph2D = this.getGraph2D();
        final fj t = this.getGraph2D().t(q);
        final v a = v.a(graph2D);
        if (a != null && a.k(q)) {
            return rectangle2D.contains(t.getX(), t.getY(), t.getWidth(), t.getHeight());
        }
        return t.isInBox(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }
    
    protected boolean belongsToSelection(final y.c.d d, final Rectangle2D rectangle2D) {
        return this.getGraph2D().i(d).pathIntersects(rectangle2D, false);
    }
    
    protected boolean belongsToSelection(final y.h.x x, final Rectangle2D rectangle2D) {
        return x.a(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }
    
    protected boolean belongsToSelection(final gZ gz, final Rectangle2D rectangle2D) {
        return this.b(gz.getBox(), rectangle2D);
    }
    
    protected boolean belongsToSelection(final eU eu, final Rectangle2D rectangle2D) {
        return this.b(eu.k(), rectangle2D);
    }
    
    private boolean b(final y.d.y y, final Rectangle2D rectangle2D) {
        final double n = y.c() + y.a() * 0.5;
        final double n2 = y.d() + y.b() * 0.5;
        return rectangle2D.getX() <= n && n <= rectangle2D.getX() + rectangle2D.getWidth() && rectangle2D.getY() <= n2 && n2 <= rectangle2D.getY() + rectangle2D.getHeight();
    }
    
    protected int adjustTypes(final int n) {
        final boolean z = fj.z;
        if (this.isMixedSelectionEnabled()) {
            int n2 = n;
            if (n2 == 0) {
                n2 = 9;
                if (!z) {
                    return n2;
                }
            }
            if ((n2 & 0x9) == n2) {
                n2 = 9;
            }
            return n2;
        }
        int b = n;
        if (b == 0) {
            b = 9;
        }
        Label_0078: {
            if ((b & 0x2) == 0x2) {
                b = 2;
                if (!z) {
                    break Label_0078;
                }
            }
            if ((b & 0x9) != 0x0) {
                b = 9;
                if (!z) {
                    break Label_0078;
                }
            }
            b = b(b);
        }
        if ((b & 0x30) != 0x0) {
            b = 48;
        }
        return b;
    }
    
    private static int b(final int n) {
        return n & -n;
    }
    
    protected int getSelectedTypes(final bu bu) {
        final boolean z = fj.z;
        int n = 0;
        final x o = bu.o();
        while (o.f()) {
            n |= this.getSelectedNodeTypes(bu, o.e());
            o.g();
            if (z) {
                break;
            }
        }
        final e p = bu.p();
        int n2 = 0;
        while (p.f()) {
            n2 = (n | this.getSelectedEdgeTypes(bu, p.a()));
            if (z) {
                return n2;
            }
            n = n2;
            p.g();
            if (z) {
                break;
            }
        }
        return n2;
    }
    
    protected int getSelectedEdgeTypes(final bu bu, final y.c.d d) {
        final boolean z = fj.z;
        int n = 0;
        if (this.isSelected(bu, d)) {
            n |= 0x2;
        }
        final aB i = bu.i(d);
        int selected = 0;
        Label_0103: {
            if ((n & 0x20) != 0x20 && i.labelCount() > 0) {
                int j = 0;
                while (j < i.labelCount()) {
                    final boolean b = (selected = (this.isSelected(bu, i.getLabel(j)) ? 1 : 0)) != 0;
                    if (z) {
                        break Label_0103;
                    }
                    if (b) {
                        n |= 0x20;
                        if (!z) {
                            break;
                        }
                    }
                    ++j;
                    if (z) {
                        break;
                    }
                }
            }
            selected = (n & 0x8);
        }
        if (selected != 8 && i.bendCount() > 0) {
            final y bends = i.bends();
            while (bends.f()) {
                final int selected2;
                final boolean b2 = (selected2 = (this.isSelected(bu, bends.a()) ? 1 : 0)) != 0;
                if (z) {
                    return selected2;
                }
                if (b2) {
                    n |= 0x8;
                    if (!z) {
                        break;
                    }
                }
                bends.g();
                if (z) {
                    break;
                }
            }
        }
        return n;
    }
    
    protected int getSelectedNodeTypes(final bu bu, final q q) {
        final boolean z = fj.z;
        int n = 0;
        if (this.isSelected(bu, q)) {
            n |= 0x1;
        }
        final fj t = bu.t(q);
        int selected = 0;
        Label_0103: {
            if ((n & 0x10) != 0x10 && t.labelCount() > 0) {
                int i = 0;
                while (i < t.labelCount()) {
                    final boolean b = (selected = (this.isSelected(bu, t.getLabel(i)) ? 1 : 0)) != 0;
                    if (z) {
                        break Label_0103;
                    }
                    if (b) {
                        n |= 0x10;
                        if (!z) {
                            break;
                        }
                    }
                    ++i;
                    if (z) {
                        break;
                    }
                }
            }
            selected = (n & 0x40);
        }
        int n2 = 0;
        if (selected != 64 && t.portCount() > 0) {
            final Iterator ports = t.ports();
            while (ports.hasNext()) {
                if (this.isSelected(bu, ports.next())) {
                    n2 = (n | 0x40);
                    if (!z) {
                        n = n2;
                        break;
                    }
                    break;
                }
            }
        }
        return n2;
    }
    
    protected void selectTypes(final bu bu, final int n, final Rectangle rectangle, final boolean b) {
        final boolean z = fj.z;
        final x o = bu.o();
        while (o.f()) {
            this.selectNodeTypes(bu, o.e(), n, rectangle, b);
            o.g();
            if (z) {
                break;
            }
        }
        final e p4 = bu.p();
        while (p4.f()) {
            this.selectEdgeTypes(bu, p4.a(), n, rectangle, b);
            p4.g();
            if (z) {
                break;
            }
        }
    }
    
    protected void selectEdgeTypes(final bu bu, final y.c.d d, final int n, final Rectangle rectangle, final boolean b) {
        final boolean z = fj.z;
        final boolean b2 = !b;
        final boolean b3 = (n & 0x2) == 0x2;
        final boolean b4 = (n & 0x20) == 0x20;
        final boolean b5 = (n & 0x8) == 0x8;
        Label_0102: {
            if (b3) {
                if (this.belongsToSelection(d, rectangle)) {
                    this.setSelected(bu, d, true);
                    if (!z) {
                        break Label_0102;
                    }
                }
                if (b2) {
                    this.setSelected(bu, d, false);
                }
            }
        }
        final aB i = bu.i(d);
        boolean belongsToSelection = false;
        if (b4 && i.labelCount() > 0) {
            int j = 0;
            while (j < i.labelCount()) {
                final aA label = i.getLabel(j);
                belongsToSelection = this.belongsToSelection(label, rectangle);
                if (z) {
                    break;
                }
                Label_0190: {
                    if (belongsToSelection) {
                        this.setSelected(bu, label, true);
                        if (!z) {
                            break Label_0190;
                        }
                    }
                    if (b2) {
                        this.setSelected(bu, label, false);
                    }
                }
                ++j;
                if (z) {
                    break;
                }
            }
        }
        if (belongsToSelection && i.bendCount() > 0) {
            final y bends = i.bends();
            while (bends.f()) {
                final y.h.x a = bends.a();
                Label_0274: {
                    if (this.belongsToSelection(a, rectangle)) {
                        this.setSelected(bu, a, true);
                        if (!z) {
                            break Label_0274;
                        }
                    }
                    if (b2) {
                        this.setSelected(bu, a, false);
                    }
                }
                bends.g();
                if (z) {
                    break;
                }
            }
        }
    }
    
    protected void selectNodeTypes(final bu bu, final q q, final int n, final Rectangle rectangle, final boolean b) {
        final boolean z = fj.z;
        final boolean b2 = !b;
        final boolean b3 = (n & 0x1) == 0x1;
        final boolean b4 = (n & 0x10) == 0x10;
        final boolean b5 = (n & 0x40) == 0x40;
        Label_0102: {
            if (b3) {
                if (this.belongsToSelection(q, rectangle)) {
                    this.setSelected(bu, q, true);
                    if (!z) {
                        break Label_0102;
                    }
                }
                if (b2) {
                    this.setSelected(bu, q, false);
                }
            }
        }
        final fj t = bu.t(q);
        boolean belongsToSelection = false;
        if (b4 && t.labelCount() > 0) {
            int i = 0;
            while (i < t.labelCount()) {
                final eR label = t.getLabel(i);
                belongsToSelection = this.belongsToSelection(label, rectangle);
                if (z) {
                    break;
                }
                Label_0190: {
                    if (belongsToSelection) {
                        this.setSelected(bu, label, true);
                        if (!z) {
                            break Label_0190;
                        }
                    }
                    if (b2) {
                        this.setSelected(bu, label, false);
                    }
                }
                ++i;
                if (z) {
                    break;
                }
            }
        }
        if (belongsToSelection && t.portCount() > 0) {
            final Iterator ports = t.ports();
            while (ports.hasNext()) {
                final eU eu = ports.next();
                if (this.belongsToSelection(eu, rectangle)) {
                    this.setSelected(bu, eu, true);
                    if (!z) {
                        continue;
                    }
                }
                if (b2) {
                    this.setSelected(bu, eu, false);
                    if (z) {
                        break;
                    }
                    continue;
                }
            }
        }
    }
    
    protected void unselectAll(final bu bu) {
        bu.N();
    }
    
    protected void setSelected(final bu bu, final q q, final boolean b) {
        if (b) {
            gg.a(bu, q);
            if (!fj.z) {
                return;
            }
        }
        gg.b(bu, q);
    }
    
    protected void setSelected(final bu bu, final y.h.x x, final boolean b) {
        bu.a(x, b);
    }
    
    protected void setSelected(final bu bu, final y.c.d d, final boolean b) {
        bu.a(d, b);
    }
    
    protected void setSelected(final bu bu, final gZ gz, final boolean b) {
        bu.a(gz, b);
    }
    
    protected void setSelected(final bu bu, final eU eu, final boolean b) {
        bu.a(eu, b);
    }
    
    protected boolean isSelected(final bu bu, final y.h.x x) {
        return bu.a(x);
    }
    
    protected boolean isSelected(final bu bu, final gZ gz) {
        return bu.a(gz);
    }
    
    protected boolean isSelected(final bu bu, final y.c.d d) {
        return bu.r(d);
    }
    
    protected boolean isSelected(final bu bu, final q q) {
        return bu.v(q);
    }
    
    protected boolean isSelected(final bu bu, final eU eu) {
        return bu.a(eu);
    }
}
