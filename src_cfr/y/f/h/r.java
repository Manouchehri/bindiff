/*
 * Decompiled with CFR 0_115.
 */
package y.f.h;

import java.util.ArrayList;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.h.N;
import y.g.ar;

public class R {
    protected i a;
    protected boolean b;
    protected int[] c;
    protected boolean[] d;
    protected ArrayList e;
    protected ArrayList f;
    protected ArrayList g;
    protected ar h;
    protected long i = 1306737;

    public void a(i i2) {
        this.a = i2;
        this.c = new int[i2.f()];
        this.d = new boolean[i2.f()];
        this.e = new ArrayList(i2.f());
        this.f = new ArrayList(i2.f());
        this.g = new ArrayList(i2.f());
        this.h = new ar(this.i);
    }

    public void a(boolean bl2) {
        this.b = bl2;
    }

    public void a(y y2) {
        boolean bl2;
        block6 : {
            bl2 = N.d;
            this.a();
            y2.clear();
            this.e.clear();
            x x2 = this.a.o();
            while (x2.f()) {
                this.e.add(x2.e());
                x2.g();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block6;
            }
            this.a(this.e, this.g);
        }
        if (this.g.isEmpty()) {
            throw new RuntimeException("Graph consists only of directed circles");
        }
        this.a(this.e, this.g, this.f, y2);
        do {
            if (this.e.isEmpty()) return;
            this.a(this.f, this.g);
            if (this.g.isEmpty()) {
                this.a(this.e, this.g);
            }
            if (this.g.isEmpty()) {
                throw new RuntimeException("Graph contains a directed circle");
            }
            this.a(this.e, this.g, this.f, y2);
        } while (!bl2);
    }

    protected void a() {
        boolean bl2;
        block3 : {
            R r2;
            bl2 = N.d;
            for (int i2 = 0; i2 < this.a.e(); ++i2) {
                this.c[i2] = 0;
                r2 = this;
                if (!bl2) {
                    r2.d[i2] = false;
                    if (!bl2) continue;
                }
                break block3;
            }
            r2 = this;
        }
        e e2 = r2.a.p();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            int[] arrn = this.c;
            int n2 = d2.d().d();
            arrn[n2] = arrn[n2] + 1;
            int[] arrn2 = this.c;
            int n3 = d2.c().d();
            arrn2[n3] = arrn2[n3] + 1;
            e2.g();
        } while (!bl2);
    }

    protected void a(ArrayList arrayList, ArrayList arrayList2) {
        boolean bl2 = N.d;
        arrayList2.clear();
        int n2 = Integer.MAX_VALUE;
        int n3 = 0;
        do {
            if (n3 >= arrayList.size()) return;
            q q2 = (q)arrayList.get(n3);
            int n4 = this.c[q2.d()];
            if (n4 < n2) {
                n2 = n4;
                arrayList2.clear();
            }
            if (n4 == n2) {
                arrayList2.add(q2);
            }
            ++n3;
        } while (!bl2);
    }

    public void a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, y y2) {
        boolean bl2 = N.d;
        q q2 = this.b ? this.a(arrayList2) : (q)arrayList2.get(0);
        int n2 = arrayList.indexOf(q2);
        if (n2 >= 0) {
            arrayList.remove(n2);
        }
        y2.add(q2);
        arrayList3.clear();
        this.d[q2.d()] = true;
        e e2 = q2.j();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            q q3 = d2.a(q2);
            int n3 = q3.d();
            if (!this.d[n3]) {
                int[] arrn = this.c;
                int n4 = n3;
                arrn[n4] = arrn[n4] - 1;
                arrayList3.add(q3);
            }
            e2.g();
        } while (!bl2);
    }

    protected q a(ArrayList arrayList) {
        if (arrayList.size() == 0) {
            throw new RuntimeException("Given an empty list!");
        }
        int n2 = this.h.nextInt(arrayList.size());
        return (q)arrayList.get(n2);
    }
}

