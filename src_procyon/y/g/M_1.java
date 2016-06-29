package y.g;

import java.util.*;
import y.c.*;

public class M
{
    public static A a(final double[] array) {
        return new S(array, null, null, null);
    }
    
    public static A a(final int[] array) {
        return new S(null, array, null, null);
    }
    
    public static A a(final boolean[] array) {
        return new S(null, null, array, null);
    }
    
    public static A a(final Object[] array) {
        return new S(null, null, null, array);
    }
    
    public static h b(final double[] array) {
        return new T(array, null, null, null);
    }
    
    public static h b(final int[] array) {
        return new T(null, array, null, null);
    }
    
    public static h b(final boolean[] array) {
        return new T(null, null, array, null);
    }
    
    public static h b(final Object[] array) {
        return new T(null, null, null, array);
    }
    
    public static A a() {
        return new R(new HashMap());
    }
    
    public static A a(final Map map) {
        return new R(map);
    }
    
    public static h b() {
        return new R(new HashMap());
    }
    
    public static b c() {
        return b(new HashMap());
    }
    
    public static b b(final Map map) {
        return new R(map);
    }
}
