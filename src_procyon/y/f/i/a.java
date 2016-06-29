package y.f.i;

import y.g.*;
import y.f.b.*;
import y.c.*;
import java.util.*;
import y.f.*;

public class a extends y.f.a
{
    public static final Object a;
    private ah b;
    private ah c;
    
    public a() {
        final E b = new E();
        b.a(y.f.i.a.a);
        this.b = b;
        final K c = new K();
        c.a(y.f.i.a.a);
        this.c = c;
    }
    
    public void c(final X x) {
        boolean b = false;
        if (x.c("y.layout.router.CHANNEL_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY") == null) {
            this.b(x);
            x.a("y.layout.router.CHANNEL_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY", q.a(Boolean.TRUE));
            b = true;
        }
        this.a(x);
        if (x.h() > 0) {
            Label_0090: {
                if (this.b != null) {
                    if (this.b instanceof v) {
                        new n(this.b).c(x);
                        if (v.f == 0) {
                            break Label_0090;
                        }
                    }
                    this.b.c(x);
                }
            }
            if (this.c != null) {
                this.c.c(x);
            }
        }
        if (b) {
            x.d_("y.layout.router.CHANNEL_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY");
        }
    }
    
    private void b(final X x) {
        this.a(x, x);
    }
    
    private void a(final y.c.n n, final O o) {
        final int f = v.f;
        c c = n.c(y.f.b.f.d);
        if (c == null) {
            c = q.a(Boolean.FALSE);
        }
        final Iterator x = n.x();
        while (x.hasNext()) {
            final Object next = x.next();
            if (!c.d(next)) {
                this.a(o, next);
                if (f == 0) {
                    continue;
                }
            }
            this.b(o, next);
            if (f != 0) {
                break;
            }
        }
    }
    
    protected void a(final O o, final Object o2) {
        final am a = o.a(o2);
        if (a.getWidth() == 0.0 || a.getHeight() == 0.0) {
            throw new IllegalArgumentException("Graph contains nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
        }
    }
    
    protected void b(final O o, final Object o2) {
        final am a = o.a(o2);
        if (a.getWidth() == 0.0 || a.getHeight() == 0.0) {
            throw new IllegalArgumentException("Graph contains group nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
        }
    }
    
    public void b(final ah b) {
        this.b = b;
    }
    
    static {
        a = "y.layout.router.ChannelEdgeRouter.AFFECTED_EDGES";
    }
}
