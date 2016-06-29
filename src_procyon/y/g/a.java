package y.g;

public abstract class a implements ag
{
    protected Class a;
    
    protected a(final Class a) {
        this.a = a;
    }
    
    public Object a(final String s, final Class clazz) {
        if (s == null) {
            return null;
        }
        if (clazz == null) {
            throw new NullPointerException("Must provide asClass argument!");
        }
        if (!this.a.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException(this + " cannot parse " + s + " as " + clazz);
        }
        return this.a(s);
    }
    
    public String a(final Object o, final Class clazz) {
        if (o == null) {
            return null;
        }
        if (clazz == null) {
            throw new NullPointerException("Must provide asClass argument!");
        }
        if (!this.a.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException(this + " cannot serializer " + o + " as " + clazz);
        }
        return this.a(o);
    }
    
    protected abstract Object a(final String p0);
    
    protected abstract String a(final Object p0);
}
