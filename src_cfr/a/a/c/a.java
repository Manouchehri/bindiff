/*
 * Decompiled with CFR 0_115.
 */
package a.a.c;

import a.a.c.b;
import a.a.c.c;
import a.a.c.d;
import java.awt.RenderingHints;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import y.c.D;

public class a
implements Cloneable {
    public static final RenderingHints.Key a = new c(null);
    public static final Object b = new d("force vectorization", null);
    public static final Object c = new d("force rasterization", null);
    public static final Object d = new d("default", null);
    private static final Map e = Collections.synchronizedMap(new WeakHashMap(11));
    private static final Map f = Collections.synchronizedMap(new WeakHashMap(11));
    private static final D g = new D();
    private static int h = 10;
    private static int i = 100000;
    private static boolean j = true;
    private static double k = 0.9;
    private static final Map l = new WeakHashMap(11);

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException var1_1) {
            var1_1.printStackTrace();
            return null;
        }
    }
}

