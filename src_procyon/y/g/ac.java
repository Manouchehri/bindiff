package y.g;

final class ac extends a
{
    ac() {
        super((X.p == null) ? (X.p = X.a("java.lang.Class")) : X.p);
    }
    
    protected Object a(final String s) {
        try {
            return Class.forName(s, false, this.getClass().getClassLoader());
        }
        catch (ClassNotFoundException ex) {
            throw new IllegalArgumentException("Did not find class " + s);
        }
        catch (Exception ex2) {
            throw new IllegalArgumentException("Could not load class" + s);
        }
    }
    
    protected String a(final Object o) {
        return ((Class)o).getName();
    }
}
