package y.f.h.a;

import y.f.h.*;
import y.c.*;
import java.util.*;

public class c extends j
{
    q[] a;
    
    public c() {
        this.a = null;
    }
    
    public c(final D d) {
        final boolean g = y.f.h.a.b.g;
        super(d.g());
        this.a = null;
        final int[] array = new int[this.b.f()];
        final y.f.h.q h = d.h();
    Label_0033:
        while (true) {
        Label_0141_Outer:
            while (h.f()) {
                final p a = h.a();
                final int k = a.a().k();
                if (!g) {
                    final e a2 = a.a();
                    while (true) {
                        while (a2.f()) {
                            final d a3 = a2.a();
                            array[a3.c().d()] = Math.max(array[a3.c().d()], k);
                            a2.g();
                            if (!g) {
                                if (g) {
                                    break;
                                }
                                continue Label_0141_Outer;
                            }
                            else {
                                if (g) {
                                    break Label_0141_Outer;
                                }
                                continue Label_0033;
                            }
                        }
                        h.g();
                        continue;
                    }
                }
                final y.c.D[] array2 = new y.c.D[this.b.h() * 2];
                int i = 0;
                while (i < array.length) {
                    if (array2[array[i]] == null) {
                        array2[array[i]] = new y.c.D();
                    }
                    array2[array[i]].add(this.a[i]);
                    ++i;
                    if (g) {
                        break;
                    }
                }
                int n = this.a.length - 1;
                int j = 0;
                while (j < array2.length) {
                    Label_0305: {
                        if (array2[j] != null) {
                            final Iterator iterator = array2[j].iterator();
                            while (iterator.hasNext()) {
                                this.a[n] = iterator.next();
                                --n;
                                if (g) {
                                    break Label_0305;
                                }
                                if (g) {
                                    break;
                                }
                            }
                        }
                        ++j;
                    }
                    if (g) {
                        break;
                    }
                }
                if (y.c.i.g) {
                    y.f.h.a.b.g = !g;
                }
                return;
            }
            this.a = this.b.m();
            continue;
        }
    }
    
    protected void a() {
    }
    
    Iterator b() {
        if (this.a == null) {
            return super.b();
        }
        return new y.f.h.a.d(this);
    }
}
