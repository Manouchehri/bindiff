package y.f;

import java.util.*;
import y.c.*;

final class aD implements az
{
    D a;
    private final ay b;
    
    aD(final ay b, final Collection collection) {
        final boolean j = X.j;
        this.b = b;
        this.a = new D();
        final Iterator<aB> iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.a.add(new aB(iterator.next()));
            if (j) {
                return;
            }
            if (j) {
                break;
            }
        }
        this.a.sort(ay.b);
    }
    
    public aA a(final d d, final boolean b, final int n) {
        final boolean j = X.j;
        if (this.a.isEmpty()) {
            throw new IllegalStateException("No candidates left");
        }
        p p3 = null;
        double n2 = -1.7976931348623157E308;
        p p4 = this.a.k();
        while (true) {
            while (p4 != null) {
                final aB ab = (aB)p4.c();
                final Object o;
                final ax ax = (ax)(o = ab.a);
                if (j) {
                    final aB ab3;
                    final aB ab2 = ab3 = (aB)o;
                    --ab3.c;
                    if (ab2.c <= 0) {
                        this.a.h(p3);
                    }
                    return ab2;
                }
                if (ax.a(n)) {
                    final double a = this.b.a(ab, d, b);
                    if (a > n2) {
                        n2 = a;
                        p3 = p4;
                    }
                }
                p4 = p4.a();
                if (j) {
                    break;
                }
            }
            if (p3 == null) {
                throw new IllegalStateException("No candidates left");
            }
            Object o = p3.c();
            continue;
        }
    }
}
