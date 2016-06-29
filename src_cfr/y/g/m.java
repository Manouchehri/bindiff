/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.util.HashMap;
import java.util.Map;
import y.c.A;
import y.c.b;
import y.c.h;
import y.g.R;
import y.g.S;
import y.g.T;

public class M {
    public static A a(double[] arrd) {
        return new S(arrd, null, null, null);
    }

    public static A a(int[] arrn) {
        return new S(null, arrn, null, null);
    }

    public static A a(boolean[] arrbl) {
        return new S(null, null, arrbl, null);
    }

    public static A a(Object[] arrobject) {
        return new S(null, null, null, arrobject);
    }

    public static h b(double[] arrd) {
        return new T(arrd, null, null, null);
    }

    public static h b(int[] arrn) {
        return new T(null, arrn, null, null);
    }

    public static h b(boolean[] arrbl) {
        return new T(null, null, arrbl, null);
    }

    public static h b(Object[] arrobject) {
        return new T(null, null, null, arrobject);
    }

    public static A a() {
        return new R(new HashMap());
    }

    public static A a(Map map) {
        return new R(map);
    }

    public static h b() {
        return new R(new HashMap());
    }

    public static b c() {
        return M.b(new HashMap());
    }

    public static b b(Map map) {
        return new R(map);
    }
}

