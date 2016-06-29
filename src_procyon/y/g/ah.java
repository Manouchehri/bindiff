package y.g;

public class ah extends a
{
    private Class c;
    static Class b;
    
    public ah(final Class c) {
        super(c);
        this.c = c;
    }
    
    public ah(final Class c, final Class clazz) {
        super(clazz);
        this.c = c;
    }
    
    protected Object a(final String s) {
        try {
            return this.c.getConstructor((ah.b == null) ? (ah.b = b("java.lang.String")) : ah.b).newInstance(s);
        }
        catch (Exception ex) {
            throw new IllegalArgumentException("Could not deserialize " + s + " " + ex);
        }
    }
    
    protected String a(final Object o) {
        return o.toString();
    }
    
    static Class b(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
}
