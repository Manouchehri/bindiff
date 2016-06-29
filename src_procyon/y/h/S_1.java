package y.h;

import java.awt.*;

final class S extends Key
{
    public static final Key a;
    
    protected S() {
        super(1764);
    }
    
    public boolean isCompatibleValue(final Object o) {
        return o instanceof T || o == null;
    }
    
    public static Object a(final bu bu, final C c) {
        return new T(bu, c);
    }
    
    static {
        a = new S();
    }
}
