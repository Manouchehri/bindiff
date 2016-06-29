package y.f.e.a;

import java.util.*;

abstract class d implements p
{
    public void a(final ay ay) {
        this.c(ay);
        this.b(ay);
    }
    
    protected void b(final ay ay) {
    }
    
    protected void c(final ay ay) {
        final boolean b = af.b;
        final List o = ay.o();
        int i = 0;
        while (i < o.size()) {
            if (o.get(i).getClass() == this.getClass()) {
                throw new IllegalStateException("This feature has already been added: " + this.getClass().getName());
            }
            ++i;
            if (b) {
                break;
            }
        }
    }
    
    protected void a(final ay ay, final Class clazz) {
        final boolean b = af.b;
        final List o = ay.o();
        int i = 0;
        while (i < o.size()) {
            if (o.get(i).getClass() == clazz) {
                return;
            }
            ++i;
            if (b) {
                break;
            }
        }
        throw new IllegalStateException("The feature " + clazz.getName() + " must be added to the layouter before adding " + this.getClass().getName());
    }
}
