package y.f.i.a;

import y.d.*;

class aL implements g
{
    private aK a;
    private boolean b;
    
    private aL() {
        this.a = null;
        this.b = false;
    }
    
    public void a(final Object o, final Object o2) {
        final aJ aj = (aJ)o;
        final aJ aj2 = (aJ)o2;
        final t a = m.a(aj, aj2);
        if (a != null) {
            final int abs = Math.abs(aj2.a - aj.a);
            if (this.a != null) {
                this.b = true;
            }
            if (this.a == null || abs > this.a.d) {
                this.a = new aK(aj, aj2, a, abs, null);
            }
        }
    }
    
    aL(final aI ai) {
        this();
    }
    
    static aK a(final aL al) {
        return al.a;
    }
    
    static boolean b(final aL al) {
        return al.b;
    }
}
