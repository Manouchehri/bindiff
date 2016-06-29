package y.f;

import java.util.*;
import y.g.*;
import y.c.*;

public class w extends X
{
    private A k;
    private h l;
    protected A a;
    protected h b;
    protected Map h;
    protected Map i;
    
    public w() {
        this.h = new HashMap();
        this.i = new HashMap();
        this.k = this.t();
        this.a = this.t();
        this.l = this.u();
        this.b = this.u();
    }
    
    protected C b() {
        return new Z();
    }
    
    public am h(final q q) {
        am d = (am)this.k.b(q);
        if (d == null) {
            d = this.D();
            this.k.a(q, d);
        }
        return d;
    }
    
    public void a(final q q, final am am) {
        this.k.a(q, am);
    }
    
    public void a(final d d, final I i) {
        this.l.a(d, i);
    }
    
    public I g(final d d) {
        I c = (I)this.l.b(d);
        if (c == null) {
            c = this.C();
            this.l.a(d, c);
        }
        return c;
    }
    
    public aj[] i(final q q) {
        aj[] array = (aj[])this.a.b(q);
        if (array == null) {
            array = new aj[0];
            this.a.a(q, array);
        }
        return array;
    }
    
    public void a(final q q, final aj[] array) {
        final boolean j = X.j;
        final Object b = this.a.b(q);
        Label_0083: {
            if (b instanceof aj[]) {
                final aj[] array2 = (aj[])b;
                int i = 0;
                while (i < array2.length) {
                    this.h.remove(array2[i]);
                    ++i;
                    if (j) {
                        break Label_0083;
                    }
                    if (j) {
                        break;
                    }
                }
            }
            this.a.a(q, array);
        }
        int k = 0;
        while (k < array.length) {
            this.h.put(array[k], q);
            ++k;
            if (j) {
                break;
            }
        }
    }
    
    public void a(final d d, final y.f.C[] array) {
        final boolean j = X.j;
        final Object b = this.b.b(d);
        Label_0083: {
            if (b instanceof y.f.C[]) {
                final y.f.C[] array2 = (y.f.C[])b;
                int i = 0;
                while (i < array2.length) {
                    this.i.remove(array2[i]);
                    ++i;
                    if (j) {
                        break Label_0083;
                    }
                    if (j) {
                        break;
                    }
                }
            }
            this.b.a(d, array);
        }
        int k = 0;
        while (k < array.length) {
            this.i.put(array[k], d);
            ++k;
            if (j) {
                break;
            }
        }
    }
    
    public y.f.C[] h(final d d) {
        y.f.C[] array = (y.f.C[])this.b.b(d);
        if (array == null) {
            array = new y.f.C[0];
            this.b.a(d, array);
        }
        return array;
    }
    
    public q a(final aj aj) {
        return this.h.get(aj);
    }
    
    public d a(final y.f.C c) {
        return this.i.get(c);
    }
    
    protected I C() {
        return new u();
    }
    
    protected am D() {
        return new x();
    }
}
