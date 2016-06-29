package a.a.c;

import java.awt.*;
import y.c.*;
import java.util.*;

public class a implements Cloneable
{
    public static final RenderingHints.Key a;
    public static final Object b;
    public static final Object c;
    public static final Object d;
    private static final Map e;
    private static final Map f;
    private static final D g;
    private static int h;
    private static int i;
    private static boolean j;
    private static double k;
    private static final Map l;
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    static {
        a = new c(null);
        b = new d("force vectorization", null);
        c = new d("force rasterization", null);
        d = new d("default", null);
        e = Collections.synchronizedMap(new WeakHashMap<Object, Object>(11));
        f = Collections.synchronizedMap(new WeakHashMap<Object, Object>(11));
        g = new D();
        a.a.c.a.h = 10;
        a.a.c.a.i = 100000;
        a.a.c.a.j = true;
        a.a.c.a.k = 0.9;
        l = new WeakHashMap(11);
    }
}
