package y.f.i;

import y.c.*;
import y.d.*;
import java.util.*;

class h
{
    d a;
    int b;
    List c;
    
    public h(final d a, final int b) {
        this.c = new ArrayList();
        this.a = a;
        this.b = b;
    }
    
    public boolean a() {
        return this.c.isEmpty();
    }
    
    public void a(final t t, final t t2) {
        final int f = v.f;
        final double a = t.a(t2);
        if (a > 0.0) {
            final ArrayList<Double> c = new ArrayList<Double>();
            final Iterator<Double> iterator = this.c.iterator();
            while (iterator.hasNext()) {
                c.add(new Double(iterator.next() / a));
                if (f != 0) {
                    return;
                }
                if (f != 0) {
                    break;
                }
            }
            this.c = c;
        }
    }
}
