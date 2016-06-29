package y.f.e.a;

import y.f.*;

public class as extends d
{
    public static final Object a;
    static Class b;
    
    public void a(final ay ay) {
        super.a(ay);
        this.a(ay, (as.b == null) ? (as.b = a("y.f.e.a.e")) : as.b);
        ay.a(new n());
        final t t = new t(ay);
        ay.e(t);
        ay.b(new at(this, t));
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
        a = "y.layout.organic.generic.FixedGroupingFeature.FIXED_GROUP_NODE_DP_KEY";
    }
}
