/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import y.c.d;
import y.f.aA;
import y.f.aB;
import y.f.aC;
import y.f.aD;
import y.f.ax;
import y.f.az;

public class ay {
    public static final Object a = "y.layout.PortCandidateSet.DP_KEY";
    static final Comparator b = new aC();
    private List c = new ArrayList();
    private long d;

    public void a(ax ax2) {
        this.a(ax2, 1);
    }

    public void a(ax ax2, int n2) {
        if (n2 <= 0) return;
        this.d += (long)n2;
        this.c.add(new aB(ax2, n2));
    }

    public Iterator a() {
        return this.c.iterator();
    }

    public az b() {
        return new aD(this, this.c);
    }

    protected double a(aA aA2, d d2, boolean bl2) {
        return - aA2.a().f();
    }
}

