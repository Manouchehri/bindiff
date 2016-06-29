/*
 * Decompiled with CFR 0_115.
 */
package y.c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import y.c.C;
import y.c.E;
import y.c.F;
import y.c.G;
import y.c.c;
import y.c.p;
import y.g.e;
import y.g.o;

public class D
implements Collection,
List {
    int a;
    p b;
    p c;
    int d;
    public static boolean e;

    public D() {
        this.d = Integer.MIN_VALUE;
    }

    public D(Collection collection) {
        this(collection.iterator());
    }

    public D(Iterator iterator) {
        boolean bl2 = e;
        while (iterator.hasNext()) {
            this.b(iterator.next());
            if (bl2) return;
            if (!bl2) continue;
        }
        this.d = Integer.MIN_VALUE;
    }

    public D(C c2) {
        boolean bl2 = e;
        c2.i();
        while (c2.f()) {
            this.b(c2.d());
            c2.g();
            if (bl2) return;
            if (!bl2) continue;
        }
        this.d = Integer.MIN_VALUE;
    }

    public D(C c2, c c3) {
        boolean bl2 = e;
        c2.i();
        while (c2.f()) {
            if (c3.d(c2.d())) {
                this.b(c2.d());
            }
            c2.g();
            if (!bl2) continue;
        }
        this.d = Integer.MIN_VALUE;
    }

    public D(Object[] arrobject) {
        boolean bl2 = e;
        for (int i2 = arrobject.length - 1; i2 >= 0; --i2) {
            this.a(arrobject[i2]);
            if (bl2) return;
            if (!bl2) continue;
        }
        this.d = Integer.MIN_VALUE;
    }

    /*
     * Unable to fully structure code
     */
    public p a(Object var1_1) {
        var2_2 = this.e(var1_1);
        if (this.b != null) ** GOTO lbl-1000
        this.b = this.c = var2_2;
        if (D.e) lbl-1000: // 2 sources:
        {
            this.b.b = var2_2;
            var2_2.a = this.b;
            this.b = var2_2;
        }
        ++this.a;
        ++this.d;
        return var2_2;
    }

    public p b(Object object) {
        p p2 = this.e(object);
        if (this.c == null) {
            this.b = this.c = p2;
        } else {
            this.c.a = p2;
            p2.b = this.c;
            this.c = p2;
        }
        ++this.a;
        ++this.d;
        return p2;
    }

    /*
     * Unable to fully structure code
     */
    public void a(p var1_1) {
        var1_1.b = null;
        var1_1.a = null;
        if (this.c != null) ** GOTO lbl-1000
        this.b = this.c = var1_1;
        if (D.e) lbl-1000: // 2 sources:
        {
            this.c.a = var1_1;
            var1_1.b = this.c;
            this.c = var1_1;
        }
        ++this.d;
        ++this.a;
    }

    /*
     * Unable to fully structure code
     */
    public void b(p var1_1) {
        var1_1.b = null;
        var1_1.a = null;
        if (this.b != null) ** GOTO lbl-1000
        this.b = this.c = var1_1;
        if (D.e) lbl-1000: // 2 sources:
        {
            this.b.b = var1_1;
            var1_1.a = this.b;
            this.b = var1_1;
        }
        ++this.d;
        ++this.a;
    }

    @Override
    public boolean add(Object object) {
        this.b(object);
        return true;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean addAll(Collection var1_1) {
        var4_2 = D.e;
        var2_3 = false;
        if (!(var1_1 instanceof D)) ** GOTO lbl10
        for (var3_4 = ((D)var1_1).k(); var3_4 != null; var3_4 = var3_4.a()) {
            v0 = this.add(var3_4.c());
            if (var4_2 != false) return v0;
            if (!v0) continue;
            var2_3 = true;
            if (!var4_2) continue;
lbl10: // 2 sources:
            var3_4 = var1_1.iterator();
            while (var3_4.hasNext()) {
                if (!this.add(var3_4.next())) continue;
                v0 = true;
                if (var4_2 != false) return v0;
                var2_3 = v0;
                if (!var4_2) continue;
            }
            break block0;
        }
        v0 = var2_3;
        return v0;
    }

    public void a(C c2) {
        boolean bl2 = e;
        do {
            if (!c2.f()) return;
            this.b(c2.d());
            c2.g();
        } while (!bl2);
    }

    public p a(Object object, p p2) {
        if (p2 == this.b) {
            return this.a(object);
        }
        if (p2 == null) {
            return this.b(object);
        }
        p p3 = this.e(object);
        this.a(p3, p2);
        return p3;
    }

    /*
     * Unable to fully structure code
     */
    public void a(p var1_1, p var2_2) {
        var4_3 = D.e;
        if (var2_2 == null) {
            this.b(var1_1);
            if (var4_3 == false) return;
        }
        if (var2_2 == this.b) {
            this.b(var1_1);
            if (var4_3 == false) return;
        }
        if (this.c != null) ** GOTO lbl-1000
        var1_1.b = null;
        var1_1.a = null;
        this.b = this.c = var1_1;
        if (var4_3) lbl-1000: // 2 sources:
        {
            var3_4 = var2_2.b;
            var2_2.b = var1_1;
            var1_1.a = var2_2;
            var3_4.a = var1_1;
            var1_1.b = var3_4;
        }
        ++this.a;
        ++this.d;
    }

    /*
     * Unable to fully structure code
     */
    public void b(p var1_1, p var2_2) {
        var4_3 = D.e;
        if (var2_2 == null) {
            this.a(var1_1);
            if (var4_3 == false) return;
        }
        if (var2_2 == this.c) {
            this.a(var1_1);
            if (var4_3 == false) return;
        }
        if (this.b != null) ** GOTO lbl-1000
        var1_1.b = null;
        var1_1.a = null;
        this.b = this.c = var1_1;
        if (var4_3) lbl-1000: // 2 sources:
        {
            var3_4 = var2_2.a;
            var2_2.a = var1_1;
            var1_1.a = var3_4;
            var3_4.b = var1_1;
            var1_1.b = var2_2;
        }
        ++this.a;
        ++this.d;
    }

    public p b(Object object, p p2) {
        if (p2 == this.c) {
            return this.b(object);
        }
        if (p2 == null) {
            return this.a(object);
        }
        p p3 = this.e(object);
        this.b(p3, p2);
        return p3;
    }

    @Override
    public int size() {
        return this.a;
    }

    @Override
    public boolean isEmpty() {
        if (this.a != 0) return false;
        return true;
    }

    @Override
    public void clear() {
        if (this.a <= 0) return;
        this.c = null;
        this.b = null;
        this.a = 0;
        ++this.d;
    }

    public Object f() {
        return this.b.c;
    }

    public Object g() {
        Object object = this.f();
        this.h(this.k());
        return object;
    }

    public p c(Object object) {
        return this.a(object);
    }

    public Object h() {
        return this.f();
    }

    public Object i() {
        return this.c.c;
    }

    public Object j() {
        return this.h(this.c);
    }

    public Object a(int n2) {
        boolean bl2 = e;
        if (n2 < 0) return null;
        if (n2 >= this.size()) {
            return null;
        }
        int n3 = 0;
        p p2 = this.b;
        do {
            if (p2 == null) return null;
            if (n2 == n3) {
                return p2.c;
            }
            p2 = p2.a;
            ++n3;
        } while (!bl2);
        return null;
    }

    @Override
    public int indexOf(Object object) {
        boolean bl2 = e;
        int n2 = 0;
        p p2 = this.b;
        do {
            if (p2 == null) return -1;
            if (p2.c == object) return n2;
            if (p2.c != null && p2.c.equals(object)) {
                return n2;
            }
            p2 = p2.a;
            ++n2;
        } while (!bl2);
        return -1;
    }

    public p k() {
        return this.b;
    }

    public p l() {
        return this.c;
    }

    public p c(p p2) {
        return p2.a;
    }

    public p d(p p2) {
        return p2.b;
    }

    public p e(p p2) {
        if (p2.a != null) return p2.a;
        return this.b;
    }

    public p f(p p2) {
        if (p2.b != null) return p2.b;
        return this.c;
    }

    public Object g(p p2) {
        return p2.c;
    }

    public void a(p p2, Object object) {
        p2.c = object;
    }

    @Override
    public boolean remove(Object object) {
        p p2 = this.d(object);
        if (p2 == null) return false;
        this.h(p2);
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        int n2;
        block2 : {
            boolean bl2 = e;
            int n3 = this.size();
            Set set = collection instanceof Set ? (Set)collection : new HashSet(collection);
            for (p p2 = this.k(); p2 != null; p2 = p2.a()) {
                n2 = (int)set.contains(p2.c()) ? 1 : 0;
                if (!bl2) {
                    if (n2 == 0) continue;
                    this.h(p2);
                    if (!bl2) continue;
                }
                break block2;
            }
            n2 = n3;
        }
        if (n2 == this.size()) return false;
        return true;
    }

    @Override
    public boolean retainAll(Collection collection) {
        int n2;
        block2 : {
            boolean bl2 = e;
            int n3 = this.size();
            Set set = collection instanceof Set ? (Set)collection : new HashSet(collection);
            for (p p2 = this.k(); p2 != null; p2 = p2.a()) {
                n2 = (int)set.contains(p2.c()) ? 1 : 0;
                if (!bl2) {
                    if (n2 != 0) continue;
                    this.h(p2);
                    if (!bl2) continue;
                }
                break block2;
            }
            n2 = n3;
        }
        if (n2 == this.size()) return false;
        return true;
    }

    public Object h(p p2) {
        block5 : {
            boolean bl2;
            block4 : {
                bl2 = e;
                if (p2 != this.b) {
                    p2.b.a = p2.a;
                    if (!bl2) break block4;
                }
                this.b = p2.a;
            }
            if (p2 != this.c) {
                p2.a.b = p2.b;
                if (!bl2) break block5;
            }
            this.c = p2.b;
        }
        ++this.d;
        --this.a;
        return p2.c;
    }

    public Object b(C c2) {
        return this.h(((E)c2).a);
    }

    public C m() {
        return new E(this);
    }

    @Override
    public Iterator iterator() {
        return new F(this, this.b);
    }

    public ListIterator listIterator() {
        return new G(this, 0, this.b);
    }

    @Override
    public boolean contains(Object object) {
        if (this.d(object) == null) return false;
        return true;
    }

    @Override
    public boolean containsAll(Collection collection) {
        Object e2;
        boolean bl2 = e;
        Iterator iterator = collection.iterator();
        do {
            if (iterator.hasNext()) continue;
            return true;
        } while (this.contains(e2 = iterator.next()));
        boolean bl3 = false;
        if (bl2) return bl3;
        return bl3;
    }

    public p d(Object object) {
        boolean bl2 = e;
        p p2 = this.b;
        do {
            if (p2 == null) return null;
            if (p2.c == object) return p2;
            if (p2.c != null && p2.c.equals(object)) {
                return p2;
            }
            p2 = p2.a;
        } while (!bl2);
        return null;
    }

    public String toString() {
        boolean bl2 = e;
        StringBuffer stringBuffer = new StringBuffer(80);
        stringBuffer.append('[');
        p p2 = this.b;
        while (p2 != this.c) {
            stringBuffer.append(p2.c);
            stringBuffer.append(',');
            p2 = p2.a;
            if (bl2) return stringBuffer.toString();
            if (!bl2) continue;
        }
        if (this.c != null) {
            stringBuffer.append(this.c.c);
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    @Override
    public Object[] toArray() {
        Object[] arrobject;
        boolean bl2 = e;
        Object[] arrobject2 = new Object[this.size()];
        int n2 = 0;
        p p2 = this.b;
        while (p2 != null) {
            arrobject = arrobject2;
            if (bl2) return arrobject;
            arrobject[n2] = p2.c;
            p2 = p2.a;
            ++n2;
            if (!bl2) continue;
        }
        arrobject = arrobject2;
        return arrobject;
    }

    @Override
    public Object[] toArray(Object[] arrobject) {
        boolean bl2 = e;
        if (arrobject.length < this.a) {
            arrobject = (Object[])Array.newInstance(arrobject.getClass().getComponentType(), this.a);
        }
        int n2 = 0;
        p p2 = this.b;
        while (p2 != null) {
            arrobject[n2++] = p2.c;
            p2 = p2.a;
            if (bl2) return arrobject;
            if (!bl2) continue;
        }
        if (arrobject.length <= n2) return arrobject;
        arrobject[n2] = null;
        return arrobject;
    }

    public void n() {
        p p2;
        boolean bl2 = e;
        p p3 = this.b;
        while (p3 != null) {
            p2 = p3.a;
            p3.a = p3.b;
            p3 = p3.b = p2;
            if (bl2) return;
            if (!bl2) continue;
        }
        p2 = this.b;
        this.b = this.c;
        this.c = p2;
        ++this.d;
    }

    public void sort(Comparator comparator) {
        Object object;
        boolean bl2 = e;
        if (this.a <= 1) return;
        if (this.a == 2 && comparator != null) {
            if (comparator.compare(this.b.c, this.c.c) <= 0) return;
            object = this.b.c;
            this.b.c = this.c.c;
            this.c.c = object;
            if (!bl2) return;
        }
        object = this.toArray();
        e.a((Object[])object, comparator);
        int n2 = 0;
        p p2 = this.b;
        do {
            if (p2 == null) return;
            p2.c = object[n2];
            p2 = p2.a;
            ++n2;
        } while (!bl2);
    }

    public void o() {
        boolean bl2 = e;
        if (this.a <= 1) return;
        Object[] arrobject = this.toArray();
        e.a(arrobject, null);
        int n2 = 0;
        p p2 = this.b;
        do {
            if (p2 == null) return;
            p2.c = arrobject[n2];
            p2 = p2.a;
            ++n2;
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    public void a(D var1_1) {
        if (var1_1.a <= 0) return;
        if (this.b != null) ** GOTO lbl-1000
        this.b = var1_1.b;
        this.c = var1_1.c;
        if (D.e) lbl-1000: // 2 sources:
        {
            if (var1_1.b != null) {
                this.c.a = var1_1.b;
                var1_1.b.b = this.c;
                this.c = var1_1.c;
            }
        }
        this.a += var1_1.a;
        var1_1.c = null;
        var1_1.b = null;
        var1_1.a = 0;
        ++var1_1.d;
        ++this.d;
    }

    private p e(Object object) {
        return new p(object);
    }

    /*
     * Unable to fully structure code
     */
    public boolean addAll(int var1_1, Collection var2_2) {
        var5_3 = D.e;
        var3_4 = this.b(var1_1);
        if (var3_4.a != null) ** GOTO lbl9
        var4_5 = var2_2.iterator();
        while (var4_5.hasNext()) {
            this.add(var4_5.next());
            if (var5_3 != false) return false;
            if (!var5_3) continue;
lbl9: // 2 sources:
            var4_5 = var2_2.iterator();
            while (var4_5.hasNext()) {
                var3_4 = this.b(var4_5.next(), var3_4);
                if (var5_3 != false) return false;
                if (!var5_3) continue;
            }
            break block0;
        }
        if (var2_2.isEmpty() != false) return false;
        return true;
    }

    public final p b(int n2) {
        p p2;
        boolean bl2 = e;
        if (n2 < 0) throw new IndexOutOfBoundsException(Integer.toString(n2));
        if (n2 >= this.a) {
            throw new IndexOutOfBoundsException(Integer.toString(n2));
        }
        if (n2 > this.a / 2) {
            p p3;
            p p4 = this.c;
            for (int i2 = this.a - 1; i2 > n2; --i2) {
                p3 = p4.b;
                if (bl2) return p3;
                p4 = p3;
                if (!bl2) continue;
            }
            p3 = p4;
            return p3;
        }
        p p5 = this.b;
        while (n2 > 0) {
            --n2;
            p2 = p5.a;
            if (bl2) return p2;
            p5 = p2;
            if (!bl2) continue;
        }
        p2 = p5;
        return p2;
    }

    @Override
    public int lastIndexOf(Object object) {
        boolean bl2 = e;
        int n2 = this.a - 1;
        p p2 = this.c;
        do {
            if (p2 == null) return -1;
            if (p2.c == object) return n2;
            if (p2.c != null && p2.c.equals(object)) {
                return n2;
            }
            p2 = p2.b;
            --n2;
        } while (!bl2);
        return -1;
    }

    public Object set(int n2, Object object) {
        p p2 = this.b(n2);
        Object object2 = p2.c;
        p2.c = object;
        return object2;
    }

    public Object remove(int n2) {
        return this.h(this.b(n2));
    }

    public ListIterator listIterator(int n2) {
        if (n2 != this.a) return new G(this, n2, this.b(n2));
        G g2 = new G(this, n2 - 1, this.c);
        g2.next();
        return g2;
    }

    public Object get(int n2) {
        return this.b((int)n2).c;
    }

    public void add(int n2, Object object) {
        if (n2 == this.a) {
            this.b(object);
            if (!e) return;
        }
        this.a(object, this.b(n2));
    }

    public List subList(int n2, int n3) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object object) {
        boolean bl2 = e;
        if (!(object instanceof List)) {
            return false;
        }
        if (object == this) {
            return true;
        }
        List list = (List)object;
        if (list.size() != this.a) {
            return false;
        }
        p p2 = this.b;
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) return true;
            Object e2 = iterator.next();
            if (p2.c != e2) {
                if (e2 == null) return false;
                if (!e2.equals(p2.c)) return false;
            }
            p2 = p2.a;
        } while (!bl2);
        return true;
    }

    @Override
    public int hashCode() {
        boolean bl2 = e;
        int n2 = 1;
        p p2 = this.b;
        do {
            block3 : {
                if (p2 == null) return n2;
                Object object = p2.c;
                if (object == null) {
                    n2 *= 31;
                    if (!bl2) break block3;
                }
                n2 = n2 * 31 + object.hashCode();
            }
            p2 = p2.a();
        } while (!bl2);
        return n2;
    }

    static {
        new o();
    }
}

