package y.f.i.a;

import y.c.*;
import y.f.*;
import java.util.*;

class bl
{
    static final Object a;
    private final Map b;
    private ay c;
    
    private bl(final ay c) {
        this.c = c;
        this.b = new HashMap();
    }
    
    public static bl a(final q q) {
        final b b = (b)q.e().c(bl.a);
        bl bl = (b != null) ? ((bl)b.b(q)) : null;
        if (bl == null) {
            final c c = q.e().c(ay.a);
            if (c != null) {
                final ay ay = (ay)c.b(q);
                if (ay != null) {
                    bl = new bl(ay);
                    if (b != null) {
                        b.a(q, bl);
                    }
                }
            }
        }
        return bl;
    }
    
    public List a() {
        final int a = ab.a;
        final ArrayList<ax> list = new ArrayList<ax>();
        if (this.c != null) {
            final Iterator a2 = this.c.a();
            while (a2.hasNext()) {
                final aA aa = a2.next();
                final ax a3 = aa.a();
                final Integer n = this.b.get(a3);
                if (n == null || aa.b() > n) {
                    list.add(a3);
                    if (a != 0) {
                        break;
                    }
                    continue;
                }
            }
        }
        return list;
    }
    
    public List b() {
        final int a = ab.a;
        final ArrayList<ax> list = new ArrayList<ax>();
        if (this.c != null) {
            final Iterator a2 = this.c.a();
            while (a2.hasNext()) {
                final aA aa = a2.next();
                final ax a3 = aa.a();
                final Integer n = this.b.get(a3);
                if (n != null && aa.b() <= n) {
                    list.add(a3);
                    if (a != 0) {
                        break;
                    }
                    continue;
                }
            }
        }
        return list;
    }
    
    public void a(final ax ax) {
        if (this.b.containsKey(ax)) {
            this.b.put(ax, new Integer(this.b.get(ax) + 1));
            if (ab.a == 0) {
                return;
            }
        }
        this.b.put(ax, new Integer(1));
    }
    
    static {
        a = "y.layout.router.polyline.NodePortsInfo.NODE_PORTS_INFO_DPKEY";
    }
}
