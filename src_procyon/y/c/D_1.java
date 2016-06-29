package y.c;

import java.lang.reflect.*;
import java.util.*;
import y.g.*;

public class D implements Collection, List
{
    int a;
    p b;
    p c;
    int d;
    public static boolean e;
    
    public D() {
        this.d = Integer.MIN_VALUE;
    }
    
    public D(final Collection collection) {
        this(collection.iterator());
    }
    
    public D(final Iterator iterator) {
        final boolean e = D.e;
        while (iterator.hasNext()) {
            this.b(iterator.next());
            if (e) {
                return;
            }
            if (e) {
                break;
            }
        }
        this.d = Integer.MIN_VALUE;
    }
    
    public D(final C c) {
        final boolean e = D.e;
        c.i();
        while (c.f()) {
            this.b(c.d());
            c.g();
            if (e) {
                return;
            }
            if (e) {
                break;
            }
        }
        this.d = Integer.MIN_VALUE;
    }
    
    public D(final C c, final c c2) {
        final boolean e = D.e;
        c.i();
        while (c.f()) {
            if (c2.d(c.d())) {
                this.b(c.d());
            }
            c.g();
            if (e) {
                break;
            }
        }
        this.d = Integer.MIN_VALUE;
    }
    
    public D(final Object[] array) {
        final boolean e = D.e;
        int i = array.length - 1;
        while (i >= 0) {
            this.a(array[i]);
            --i;
            if (e) {
                return;
            }
            if (e) {
                break;
            }
        }
        this.d = Integer.MIN_VALUE;
    }
    
    public p a(final Object o) {
        final p e = this.e(o);
        Label_0050: {
            if (this.b == null) {
                final p p = e;
                this.c = p;
                this.b = p;
                if (!D.e) {
                    break Label_0050;
                }
            }
            this.b.b = e;
            e.a = this.b;
            this.b = e;
        }
        ++this.a;
        ++this.d;
        return e;
    }
    
    public p b(final Object o) {
        final p e = this.e(o);
        if (this.c == null) {
            final p p = e;
            this.c = p;
            this.b = p;
        }
        else {
            this.c.a = e;
            e.b = this.c;
            this.c = e;
        }
        ++this.a;
        ++this.d;
        return e;
    }
    
    public void a(final p p) {
        p.b = null;
        p.a = null;
        Label_0054: {
            if (this.c == null) {
                this.c = p;
                this.b = p;
                if (!D.e) {
                    break Label_0054;
                }
            }
            this.c.a = p;
            p.b = this.c;
            this.c = p;
        }
        ++this.d;
        ++this.a;
    }
    
    public void b(final p p) {
        p.b = null;
        p.a = null;
        Label_0054: {
            if (this.b == null) {
                this.c = p;
                this.b = p;
                if (!D.e) {
                    break Label_0054;
                }
            }
            this.b.b = p;
            p.a = this.b;
            this.b = p;
        }
        ++this.d;
        ++this.a;
    }
    
    public boolean add(final Object o) {
        this.b(o);
        return true;
    }
    
    public boolean addAll(final Collection collection) {
        final boolean e = D.e;
        boolean add = false;
        Label_0054: {
            if (collection instanceof D) {
                p p = ((D)collection).k();
                while (p != null) {
                    add = this.add(p.c());
                    if (e) {
                        break;
                    }
                    if (add) {}
                    p = p.a();
                    if (e) {
                        break Label_0054;
                    }
                }
                return add;
            }
        }
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (this.add(iterator.next())) {
                if (e) {
                    break;
                }
                if (e) {
                    break;
                }
                continue;
            }
        }
        return add;
    }
    
    public void a(final C c) {
        final boolean e = D.e;
        while (c.f()) {
            this.b(c.d());
            c.g();
            if (e) {
                break;
            }
        }
    }
    
    public p a(final Object o, final p p2) {
        if (p2 == this.b) {
            return this.a(o);
        }
        if (p2 == null) {
            return this.b(o);
        }
        final p e = this.e(o);
        this.a(e, p2);
        return e;
    }
    
    public void a(final p p2, final p a) {
        final boolean e = D.e;
        if (a == null) {
            this.b(p2);
            if (!e) {
                return;
            }
        }
        if (a == this.b) {
            this.b(p2);
            if (!e) {
                return;
            }
        }
        Label_0094: {
            if (this.c == null) {
                p2.b = null;
                p2.a = null;
                this.c = p2;
                this.b = p2;
                if (!e) {
                    break Label_0094;
                }
            }
            final p b = a.b;
            a.b = p2;
            p2.a = a;
            b.a = p2;
            p2.b = b;
        }
        ++this.a;
        ++this.d;
    }
    
    public void b(final p p2, final p b) {
        final boolean e = D.e;
        if (b == null) {
            this.a(p2);
            if (!e) {
                return;
            }
        }
        if (b == this.c) {
            this.a(p2);
            if (!e) {
                return;
            }
        }
        Label_0094: {
            if (this.b == null) {
                p2.b = null;
                p2.a = null;
                this.c = p2;
                this.b = p2;
                if (!e) {
                    break Label_0094;
                }
            }
            final p a = b.a;
            b.a = p2;
            p2.a = a;
            a.b = p2;
            p2.b = b;
        }
        ++this.a;
        ++this.d;
    }
    
    public p b(final Object o, final p p2) {
        if (p2 == this.c) {
            return this.b(o);
        }
        if (p2 == null) {
            return this.a(o);
        }
        final p e = this.e(o);
        this.b(e, p2);
        return e;
    }
    
    public int size() {
        return this.a;
    }
    
    public boolean isEmpty() {
        return this.a == 0;
    }
    
    public void clear() {
        if (this.a > 0) {
            final p p = null;
            this.c = p;
            this.b = p;
            this.a = 0;
            ++this.d;
        }
    }
    
    public Object f() {
        return this.b.c;
    }
    
    public Object g() {
        final Object f = this.f();
        this.h(this.k());
        return f;
    }
    
    public p c(final Object o) {
        return this.a(o);
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
    
    public Object a(final int n) {
        final boolean e = D.e;
        if (n < 0 || n >= this.size()) {
            return null;
        }
        int n2 = 0;
        p p = this.b;
        while (p != null) {
            if (n == n2) {
                return p.c;
            }
            p = p.a;
            ++n2;
            if (e) {
                break;
            }
        }
        return null;
    }
    
    public int indexOf(final Object o) {
        final boolean e = D.e;
        int n = 0;
        p p = this.b;
        while (p != null) {
            if (p.c == o || (p.c != null && p.c.equals(o))) {
                return n;
            }
            p = p.a;
            ++n;
            if (e) {
                break;
            }
        }
        return -1;
    }
    
    public p k() {
        return this.b;
    }
    
    public p l() {
        return this.c;
    }
    
    public p c(final p p) {
        return p.a;
    }
    
    public p d(final p p) {
        return p.b;
    }
    
    public p e(final p p) {
        if (p.a == null) {
            return this.b;
        }
        return p.a;
    }
    
    public p f(final p p) {
        if (p.b == null) {
            return this.c;
        }
        return p.b;
    }
    
    public Object g(final p p) {
        return p.c;
    }
    
    public void a(final p p2, final Object c) {
        p2.c = c;
    }
    
    public boolean remove(final Object o) {
        final p d = this.d(o);
        if (d != null) {
            this.h(d);
            return true;
        }
        return false;
    }
    
    public boolean removeAll(final Collection collection) {
        final boolean e = D.e;
        final int size = this.size();
        final Set set = (collection instanceof Set) ? ((Set)collection) : new HashSet(collection);
        p p = this.k();
        while (p != null) {
            final int contains;
            final boolean b = (contains = (set.contains(p.c()) ? 1 : 0)) != 0;
            if (e) {
                return contains != this.size();
            }
            if (b) {
                this.h(p);
            }
            p = p.a();
            if (e) {
                break;
            }
        }
        int contains = size;
        return contains != this.size();
    }
    
    public boolean retainAll(final Collection collection) {
        final boolean e = D.e;
        final int size = this.size();
        final Set set = (collection instanceof Set) ? ((Set)collection) : new HashSet(collection);
        p p = this.k();
        while (p != null) {
            final int contains;
            final boolean b = (contains = (set.contains(p.c()) ? 1 : 0)) != 0;
            if (e) {
                return contains != this.size();
            }
            if (!b) {
                this.h(p);
            }
            p = p.a();
            if (e) {
                break;
            }
        }
        int contains = size;
        return contains != this.size();
    }
    
    public Object h(final p p) {
        final boolean e = D.e;
        Label_0035: {
            if (p != this.b) {
                p.b.a = p.a;
                if (!e) {
                    break Label_0035;
                }
            }
            this.b = p.a;
        }
        Label_0066: {
            if (p != this.c) {
                p.a.b = p.b;
                if (!e) {
                    break Label_0066;
                }
            }
            this.c = p.b;
        }
        ++this.d;
        --this.a;
        return p.c;
    }
    
    public Object b(final C c) {
        return this.h(((E)c).a);
    }
    
    public C m() {
        return new E(this);
    }
    
    public Iterator iterator() {
        return new F(this, this.b);
    }
    
    public ListIterator listIterator() {
        return new G(this, 0, this.b);
    }
    
    public boolean contains(final Object o) {
        return this.d(o) != null;
    }
    
    public boolean containsAll(final Collection collection) {
        final boolean e = D.e;
        final Iterator<Object> iterator = collection.iterator();
        boolean b = false;
        while (iterator.hasNext()) {
            if (!this.contains(iterator.next())) {
                b = false;
                if (!e) {
                    return b;
                }
                return b;
            }
        }
        return b;
    }
    
    public p d(final Object o) {
        final boolean e = D.e;
        p p = this.b;
        while (p != null) {
            if (p.c == o || (p.c != null && p.c.equals(o))) {
                return p;
            }
            p = p.a;
            if (e) {
                break;
            }
        }
        return null;
    }
    
    public String toString() {
        final boolean e = D.e;
        final StringBuffer sb = new StringBuffer(80);
        sb.append('[');
        p p = this.b;
        while (p != this.c) {
            sb.append(p.c);
            sb.append(',');
            p = p.a;
            if (e) {
                return sb.toString();
            }
            if (e) {
                break;
            }
        }
        if (this.c != null) {
            sb.append(this.c.c);
        }
        sb.append(']');
        return sb.toString();
    }
    
    public Object[] toArray() {
        final boolean e = D.e;
        final Object[] array = new Object[this.size()];
        int n = 0;
        p p = this.b;
        Object[] array2 = null;
        while (p != null) {
            array2 = array;
            if (e) {
                return array2;
            }
            array2[n] = p.c;
            p = p.a;
            ++n;
            if (e) {
                break;
            }
        }
        return array2;
    }
    
    public Object[] toArray(Object[] array) {
        final boolean e = D.e;
        if (array.length < this.a) {
            array = (Object[])Array.newInstance(array.getClass().getComponentType(), this.a);
        }
        int n = 0;
        p p = this.b;
        while (p != null) {
            array[n++] = p.c;
            p = p.a;
            if (e) {
                return array;
            }
            if (e) {
                break;
            }
        }
        if (array.length > n) {
            array[n] = null;
            return array;
        }
        return array;
    }
    
    public void n() {
        final boolean e = D.e;
        p p = this.b;
        while (p != null) {
            final p a = p.a;
            p.a = p.b;
            p.b = a;
            p = p.b;
            if (e) {
                return;
            }
            if (e) {
                break;
            }
        }
        final p b = this.b;
        this.b = this.c;
        this.c = b;
        ++this.d;
    }
    
    public void sort(final Comparator comparator) {
        final boolean e = D.e;
        if (this.a > 1) {
            if (this.a == 2 && comparator != null) {
                if (comparator.compare(this.b.c, this.c.c) <= 0) {
                    return;
                }
                final Object c = this.b.c;
                this.b.c = this.c.c;
                this.c.c = c;
                if (!e) {
                    return;
                }
            }
            final Object[] array = this.toArray();
            y.g.e.a(array, comparator);
            int n = 0;
            p p = this.b;
            while (p != null) {
                p.c = array[n];
                p = p.a;
                ++n;
                if (e) {
                    break;
                }
            }
        }
    }
    
    public void o() {
        final boolean e = D.e;
        if (this.a > 1) {
            final Object[] array = this.toArray();
            y.g.e.a(array, null);
            int n = 0;
            p p = this.b;
            while (p != null) {
                p.c = array[n];
                p = p.a;
                ++n;
                if (e) {
                    break;
                }
            }
        }
    }
    
    public void a(final D d) {
        if (d.a > 0) {
            Label_0073: {
                if (this.b == null) {
                    this.b = d.b;
                    this.c = d.c;
                    if (!D.e) {
                        break Label_0073;
                    }
                }
                if (d.b != null) {
                    this.c.a = d.b;
                    d.b.b = this.c;
                    this.c = d.c;
                }
            }
            this.a += d.a;
            final p p = null;
            d.c = p;
            d.b = p;
            d.a = 0;
            ++d.d;
            ++this.d;
        }
    }
    
    private p e(final Object o) {
        return new p(o);
    }
    
    public boolean addAll(final int n, final Collection collection) {
        final boolean e = D.e;
        p p2 = this.b(n);
        Label_0099: {
            Label_0058: {
                if (p2.a == null) {
                    final Iterator<Object> iterator = collection.iterator();
                    while (iterator.hasNext()) {
                        this.add(iterator.next());
                        if (e) {
                            return false;
                        }
                        if (e) {
                            break Label_0058;
                        }
                    }
                    break Label_0099;
                }
            }
            final Iterator<Object> iterator2 = collection.iterator();
            while (iterator2.hasNext()) {
                p2 = this.b(iterator2.next(), p2);
                if (e) {
                    return false;
                }
                if (e) {
                    break;
                }
            }
        }
        if (!collection.isEmpty()) {
            return true;
        }
        return false;
    }
    
    public final p b(int i) {
        final boolean e = D.e;
        if (i < 0 || i >= this.a) {
            throw new IndexOutOfBoundsException(Integer.toString(i));
        }
        if (i > this.a / 2) {
            int j = this.a - 1;
            p c = this.c;
            p b = null;
            while (j > i) {
                --j;
                b = c.b;
                if (e) {
                    return b;
                }
                c = b;
                if (e) {
                    break;
                }
            }
            return b;
        }
        p b2 = this.b;
        p a = null;
        while (i > 0) {
            --i;
            a = b2.a;
            if (e) {
                return a;
            }
            b2 = a;
            if (e) {
                break;
            }
        }
        return a;
    }
    
    public int lastIndexOf(final Object o) {
        final boolean e = D.e;
        int n = this.a - 1;
        p p = this.c;
        while (p != null) {
            if (p.c == o || (p.c != null && p.c.equals(o))) {
                return n;
            }
            p = p.b;
            --n;
            if (e) {
                break;
            }
        }
        return -1;
    }
    
    public Object set(final int n, final Object c) {
        final p b = this.b(n);
        final Object c2 = b.c;
        b.c = c;
        return c2;
    }
    
    public Object remove(final int n) {
        return this.h(this.b(n));
    }
    
    public ListIterator listIterator(final int n) {
        if (n == this.a) {
            final G g = new G(this, n - 1, this.c);
            g.next();
            return g;
        }
        return new G(this, n, this.b(n));
    }
    
    public Object get(final int n) {
        return this.b(n).c;
    }
    
    public void add(final int n, final Object o) {
        if (n == this.a) {
            this.b(o);
            if (!D.e) {
                return;
            }
        }
        this.a(o, this.b(n));
    }
    
    public List subList(final int n, final int n2) {
        throw new UnsupportedOperationException();
    }
    
    public boolean equals(final Object o) {
        final boolean e = D.e;
        if (!(o instanceof List)) {
            return false;
        }
        if (o == this) {
            return true;
        }
        final List list = (List)o;
        if (list.size() != this.a) {
            return false;
        }
        p p = this.b;
        for (final Object next : list) {
            if (p.c != next && (next == null || !next.equals(p.c))) {
                return false;
            }
            p = p.a;
            if (e) {
                break;
            }
        }
        return true;
    }
    
    public int hashCode() {
        final boolean e = D.e;
        int n = 1;
        p p = this.b;
        while (p != null) {
            final Object c = p.c;
            Label_0045: {
                if (c == null) {
                    n *= 31;
                    if (!e) {
                        break Label_0045;
                    }
                }
                n = n * 31 + c.hashCode();
            }
            p = p.a();
            if (e) {
                break;
            }
        }
        return n;
    }
    
    static {
        new o();
    }
}
