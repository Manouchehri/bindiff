package y.h;

import java.awt.*;

public class hk
{
    public static final RenderingHints.Key a;
    public static final Object b;
    public static final RenderingHints.Key c;
    public static final Object d;
    public static final Object e;
    public static final Object f;
    public static final RenderingHints.Key g;
    public static final Object h;
    public static final Object i;
    public static final Object j;
    public static final RenderingHints.Key k;
    public static final Object l;
    public static final Object m;
    public static final Object n;
    public static final RenderingHints.Key o;
    public static final Object p;
    public static final Object q;
    public static final Object r;
    public static final RenderingHints.Key s;
    public static final Object t;
    public static final RenderingHints.Key u;
    public static final Object v;
    public static final RenderingHints.Key w;
    public static final Object x;
    public static final RenderingHints.Key y;
    public static final RenderingHints.Key z;
    static Class A;
    static Class B;
    static Class C;
    static Class D;
    static Class E;
    static Class F;
    static Class G;
    static Class H;
    
    public static cV a(final Graphics2D graphics2D) {
        return (cV)graphics2D.getRenderingHint(hk.z);
    }
    
    public static boolean b(final Graphics2D graphics2D) {
        return graphics2D.getRenderingHint(hk.a) != hk.b;
    }
    
    public static boolean c(final Graphics2D graphics2D) {
        return graphics2D.getRenderingHint(hk.s) != hk.t;
    }
    
    public static boolean d(final Graphics2D graphics2D) {
        return graphics2D.getRenderingHint(hk.u) != hk.v;
    }
    
    public static boolean e(final Graphics2D graphics2D) {
        return graphics2D.getRenderingHint(hk.w) != hk.x;
    }
    
    static Class a(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        a = new hv(6003, (hk.A == null) ? (hk.A = a("y.h.hl")) : hk.A, "Selection painting enable key");
        b = new hl("selection painting off");
        c = new hv(6004, (hk.B == null) ? (hk.B = a("y.h.hu")) : hk.B, "Edge label painting enable key");
        d = new hu("edge label painting default");
        e = new hu("edge label painting on");
        f = new hu("edge label painting off");
        g = new hv(6005, (hk.C == null) ? (hk.C = a("y.h.hm")) : hk.C, "Node label painting enable key");
        h = new hm("node label painting default");
        i = new hm("node label painting on");
        j = new hm("node label painting off");
        k = new hv(6006, (hk.D == null) ? (hk.D = a("y.h.ho")) : hk.D, "Node port painting enable key");
        l = new ho("node port painting default");
        m = new ho("node port painting on");
        n = new ho("node port painting off");
        o = new hv(6007, (hk.E == null) ? (hk.E = a("y.h.hp")) : hk.E, "Group state painting enable key");
        p = new hp("group state painting default");
        q = new hp("group state painting on");
        r = new hp("group state painting off");
        s = new hv(6008, (hk.F == null) ? (hk.F = a("y.h.ht")) : hk.F, "Gradient painting enable key");
        t = new ht("gradient painting off");
        u = new hv(6009, (hk.G == null) ? (hk.G = a("y.h.hr")) : hk.G, "Shadow painting enable key");
        v = new hr("shadow painting off");
        w = new hv(6010, (hk.H == null) ? (hk.H = a("y.h.hq")) : hk.H, "Sloppy polyline painting key");
        x = new hq("sloppy polyline painting off");
        y = new hs();
        z = new hn();
    }
}
