/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.f.ad;
import y.f.e.a.am;
import y.f.e.a.at;
import y.f.e.a.ay;
import y.f.e.a.d;
import y.f.e.a.n;
import y.f.e.a.t;

public class as
extends d {
    public static final Object a = "y.layout.organic.generic.FixedGroupingFeature.FIXED_GROUP_NODE_DP_KEY";
    static Class b;

    @Override
    public void a(ay ay2) {
        super.a(ay2);
        Class class_ = b == null ? (as.b = as.a("y.f.e.a.e")) : b;
        this.a(ay2, class_);
        ay2.a(new n());
        t t2 = new t(ay2);
        ay2.e(t2);
        ay2.b(new at(this, t2));
    }

    static Class a(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

