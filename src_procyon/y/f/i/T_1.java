package y.f.i;

class T implements Cloneable
{
    final boolean a;
    final double b;
    double c;
    final double d;
    final double e;
    
    T(final double b, final double c, final double d, final double e, final boolean a) {
        this.e = e;
        this.b = b;
        this.d = d;
        this.c = c;
        this.a = a;
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException ex) {
            throw new InternalError();
        }
    }
}
