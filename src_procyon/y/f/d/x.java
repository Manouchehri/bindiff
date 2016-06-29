package y.f.d;

import y.d.*;

final class x
{
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    private B g;
    private int h;
    private int i;
    private int j;
    
    x(final int c, final int d, final int a, final int b) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.e = 0;
        this.d = d;
        this.f = 0;
        this.g = new B(a * b);
    }
    
    int a() {
        return this.e;
    }
    
    int b() {
        return this.f;
    }
    
    void a(final int n, final int n2, final int n3, final int n4) {
        final int f = y.f.d.a.f;
        int i = n2;
        while (i < n4) {
            this.a(n, n3, i, true);
            ++i;
            if (f != 0) {
                break;
            }
        }
    }
    
    void c() {
        final int i = y.f.d.a.f;
        final int[] array = new int[this.b];
        final int[] array2 = new int[this.b];
        final int[] array3 = new int[this.a];
        final int[] array4 = new int[this.a];
        int j = 0;
        while (true) {
            while (j < array.length) {
                array[j] = this.a;
                array2[j] = -1;
                ++j;
                if (i != 0) {
                    while (true) {
                        while (j < array3.length) {
                            array3[j] = this.b;
                            array4[j] = -1;
                            ++j;
                            if (i != 0) {
                                while (true) {
                                    while (j >= 0) {
                                        final int n = j % this.a;
                                        final int n2 = j / this.a;
                                        array[n2] = Math.min(array[n2], n);
                                        array3[n] = Math.min(array3[n], n2);
                                        array2[n2] = Math.max(array2[n2], n);
                                        array4[n] = Math.max(array4[n], n2);
                                        j = this.g.nextSetBit(j + 1);
                                        if (i != 0) {
                                            int k = 0;
                                        Label_0351:
                                            while (k < this.b) {
                                                int n3 = array[k];
                                                while (true) {
                                                    do {
                                                        Label_0238: {
                                                            final int n4 = array2[k];
                                                        }
                                                        int l = 0;
                                                        int n5 = 0;
                                                        Label_0244:
                                                        while (l < n5) {
                                                            final int n6 = array3[n3];
                                                            final int n7 = k;
                                                            if (i == 0) {
                                                                if (n6 <= n7 && array4[n3] >= k) {
                                                                    int n8 = n3 + 1;
                                                                    while (array3[n8] <= k) {
                                                                        l = array4[n8];
                                                                        n5 = k;
                                                                        if (i != 0) {
                                                                            continue Label_0244;
                                                                        }
                                                                        if (l < n5) {
                                                                            break;
                                                                        }
                                                                        ++n8;
                                                                        if (i != 0) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    this.g.set(j + n3, j + n8);
                                                                }
                                                                ++n3;
                                                                continue Label_0238;
                                                            }
                                                            j = n6 + n7;
                                                            ++k;
                                                            if (i != 0) {
                                                                break Label_0351;
                                                            }
                                                            continue Label_0351;
                                                        }
                                                        break;
                                                    } while (i == 0);
                                                    final int a = this.a;
                                                    continue;
                                                }
                                            }
                                            return;
                                        }
                                        if (i != 0) {
                                            break;
                                        }
                                    }
                                    j = 0;
                                    continue;
                                }
                            }
                            if (i != 0) {
                                break;
                            }
                        }
                        j = this.g.nextSetBit(0);
                        continue;
                    }
                }
                if (i != 0) {
                    break;
                }
            }
            j = 0;
            continue;
        }
    }
    
    boolean a(final x x, final int n, final int n2, final int n3, final int n4, final n n5, final boolean b) {
        final int f = y.f.d.a.f;
        this.h = Integer.MAX_VALUE;
        this.i = 0;
        this.j = 0;
        this.b(n - (this.c + this.a / 2), n2 - (this.d + this.b / 2));
        int i = 0;
        while (true) {
            while (i < n4) {
                final boolean a = this.a(x, 0, 0, i, n5, b);
                if (f == 0) {
                    if (a) {
                        return i != 0;
                    }
                    i += n3;
                    if (f != 0) {
                        break;
                    }
                    continue;
                }
                else {
                    if (a && (this.i > 0 || this.j > 0)) {
                        this.c += this.i;
                        this.d += this.j;
                        this.e += this.i;
                        this.f += this.j;
                        return true;
                    }
                    return false;
                }
            }
            continue;
        }
    }
    
    boolean a(final x x, final int n, final int n2, final int n3, final n n4, final boolean b) {
        final int f = y.f.d.a.f;
        if (n3 == 0) {
            return this.a(x, n, n2, n4, b);
        }
        int i = n3;
        int n5 = 0;
        int n7;
        final int n6 = n7 = n3 * n3;
        boolean a = false;
        while (i >= n5) {
            a = this.a(x, n + i, n2 + n5, n4, b);
            if (f != 0) {
                return a;
            }
            if (a) {
                return true;
            }
            if (this.a(x, n + i, n2 - n5, n4, b)) {
                return true;
            }
            if (this.a(x, n - i, n2 + n5, n4, b)) {
                return true;
            }
            if (this.a(x, n - i, n2 - n5, n4, b)) {
                return true;
            }
            if (this.a(x, n + n5, n2 + i, n4, b)) {
                return true;
            }
            if (this.a(x, n + n5, n2 - i, n4, b)) {
                return true;
            }
            if (this.a(x, n - n5, n2 + i, n4, b)) {
                return true;
            }
            if (this.a(x, n - n5, n2 - i, n4, b)) {
                return true;
            }
            if (n7 < n6) {
                n7 += 1 + 2 * n5;
                ++n5;
                if (f == 0) {
                    continue;
                }
            }
            n7 += 2 - 2 * i + 2 * n5;
            --i;
            ++n5;
            if (f != 0) {
                break;
            }
        }
        return a;
    }
    
    private final boolean a(final x x, final int i, final int j, final n n, final boolean b) {
        final t t = new t(i + this.c + this.a * 0.5, j + this.d + this.b * 0.5);
        if (n != null && !n.a(n, t, 1.0)) {
            return false;
        }
        if (!b) {
            return this.a(x, i, j);
        }
        this.c += i;
        this.d += j;
        final int c = this.c(x);
        if (c < this.h) {
            this.h = c;
            this.i = i;
            this.j = j;
        }
        if (c == 0) {
            this.e += i;
            this.f += j;
            return true;
        }
        this.c -= i;
        this.d -= j;
        return false;
    }
    
    private final boolean a(final x x, final int n, final int n2) {
        this.c += n;
        this.d += n2;
        if (!this.b(x)) {
            this.e += n;
            this.f += n2;
            return true;
        }
        this.c -= n;
        this.d -= n2;
        return false;
    }
    
    private int c(final x x) {
        final int i = y.f.d.a.f;
        final int max = Math.max(this.c, x.c);
        final int min = Math.min(this.c + this.a, x.c + x.a);
        final int max2 = Math.max(this.d, x.d);
        final int min2 = Math.min(this.d + this.b, x.d + x.b);
        int n = 0;
        int n2 = max;
        int n3 = 0;
        do {
            int j = 0;
        Label_0083:
            while (j < min) {
                n3 = max2;
                if (i != 0) {
                    return n3;
                }
                int k = n3;
                while (k < min2) {
                    j = (this.a(n2, k) ? 1 : 0);
                    if (i != 0) {
                        continue Label_0083;
                    }
                    if (j != 0 && x.a(n2, k)) {
                        ++n;
                    }
                    ++k;
                    if (i != 0) {
                        break;
                    }
                }
                ++n2;
            }
            break;
        } while (i == 0);
        return n3;
    }
    
    public boolean a(final int n, final int n2) {
        return n >= this.c && n < this.c + this.a && n2 >= this.d && n2 < this.d + this.b && this.g.get((n2 - this.d) * this.a + n - this.c);
    }
    
    public void a(final int n, final int n2, final boolean b) {
        if (n < this.c || n >= this.c + this.a || n2 < this.d || n2 >= this.d + this.b) {
            throw new IndexOutOfBoundsException();
        }
        final int n3 = (n2 - this.d) * this.a + n - this.c;
        if (b) {
            this.g.set(n3);
            if (y.f.d.a.f == 0) {
                return;
            }
        }
        this.g.clear(n3);
    }
    
    public void a(final int n, final int n2, final int n3, final boolean b) {
        if (n < this.c || n2 >= this.c + this.a || n3 < this.d || n3 >= this.d + this.b) {
            throw new IndexOutOfBoundsException();
        }
        final int n4 = (n3 - this.d) * this.a + n - this.c;
        final int n5 = (n3 - this.d) * this.a + n2 - this.c;
        if (b) {
            this.g.set(n4, n5);
            if (y.f.d.a.f == 0) {
                return;
            }
        }
        this.g.clear(n4, n5);
    }
    
    public void b(final int n, final int n2) {
        this.c += n;
        this.d += n2;
        this.e += n;
        this.f += n2;
    }
    
    public void a(final x x) {
        final int f = y.f.d.a.f;
        if (x.c < this.c || x.c >= this.c + this.a || x.d < this.d || x.d >= this.d + this.b || x.c + x.a > this.c + this.a || x.d + x.b > this.d + this.b) {
            this.b(Math.min(x.c, this.c), Math.min(x.d, this.d), Math.max(x.c + x.a, this.c + this.a), Math.max(x.d + x.b, this.d + this.b));
        }
        int i = x.g.nextSetBit(0);
        while (i >= 0) {
            this.g.set(i % x.a + x.c - this.c + (i / x.a + x.d - this.d) * this.a);
            i = x.g.nextSetBit(i + 1);
            if (f != 0) {
                break;
            }
        }
    }
    
    void b(final int c, final int d, final int n, final int n2) {
        final int f = y.f.d.a.f;
        final int a = n - c;
        final B g = new B(a * (n2 - d));
        int i = this.g.nextSetBit(0);
        while (i >= 0) {
            g.set(i % this.a + this.c - c + (i / this.a + this.d - d) * a);
            i = this.g.nextSetBit(i + 1);
            if (f != 0) {
                return;
            }
            if (f != 0) {
                break;
            }
        }
        this.g = g;
        this.c = c;
        this.d = d;
        this.a = a;
        this.b = n2 - d;
    }
    
    public boolean b(final x x) {
        final int f = y.f.d.a.f;
        if (x.c >= this.c + this.a || x.d >= this.d + this.b || x.c + x.a <= this.c || x.d + x.b <= this.d) {
            return false;
        }
        final int max = Math.max(this.c, x.c);
        final int min = Math.min(this.c + this.a, x.c + x.a);
        final int max2 = Math.max(this.d, x.d);
        final int max3 = Math.max(this.d + this.b, x.d + x.b);
        if (max < min && max2 < max3) {
            int i = this.a(max, max2, max, max2, min, max3);
            int n = x.a(max, max2, max, max2, min, max3);
            while (i >= 0) {
                final int n2 = n;
                if (f != 0 || n2 < 0) {
                    return n2 != 0;
                }
                final int n3 = i % this.a + this.c;
                final int n4 = n % x.a + x.c;
                final int n5 = i / this.a + this.d;
                final int n6 = n / x.a + x.d;
                if (n5 == n6) {
                    if (n3 == n4) {
                        return true;
                    }
                    if (n3 < n4) {
                        i = this.a(n4, n6, max, max2, min, max3);
                        if (f == 0) {
                            continue;
                        }
                    }
                    n = x.a(n3, n5, max, max2, min, max3);
                    if (f == 0) {
                        continue;
                    }
                }
                if (n5 < n6) {
                    i = this.a(n4, n6, max, max2, min, max3);
                    if (f == 0) {
                        continue;
                    }
                }
                n = x.a(n3, n5, max, max2, min, max3);
                if (f != 0) {
                    goto Label_0390;
                }
            }
            goto Label_0390;
        }
        return false;
    }
    
    public final int a(final int n, final int n2, int n3, int n4, int n5, int n6) {
        final int f = y.f.d.a.f;
        int n7 = n - this.c + (n2 - this.d) * this.a;
        n3 -= this.c;
        n5 -= this.c;
        n4 -= this.d;
        n6 -= this.d;
        boolean b = n7 >= 0 && n7 % this.a >= n3 && n7 % this.a < n5 && n7 / this.a >= n4 && n7 / this.a < n6;
    Label_0118:
        while (true) {
            Label_0170: {
                if (!b) {
                    if (n7 % this.a < n3) {
                        n7 += n3 - n7 % this.a;
                        if (f == 0) {
                            break Label_0170;
                        }
                    }
                    n7 += this.a - n7 % this.a;
                }
            }
            final int nextSetBit;
            n7 = (nextSetBit = this.g.nextSetBit(n7));
            int i = 0;
            while (i >= 0) {
                b = (n7 % this.a >= n3 && n7 % this.a < n5 && n7 / this.a >= n4 && n7 / this.a < n6);
                if (!b) {
                    continue Label_0118;
                }
                i = n7;
                if (f == 0) {
                    return i;
                }
            }
            return -1;
        }
    }
    
    public String toString() {
        final int i = y.f.d.a.f;
        final StringBuffer sb = new StringBuffer(this.a * this.b + this.b + 1);
        int n = 0;
        int n2 = 0;
        do {
            int j = 0;
        Label_0034:
            while (j < this.b) {
                int k = 0;
                while (k < this.a) {
                    j = (this.g.get(n) ? 1 : 0);
                    if (i != 0) {
                        continue Label_0034;
                    }
                    Label_0088: {
                        if (j != 0) {
                            sb.append('#');
                            if (i == 0) {
                                break Label_0088;
                            }
                        }
                        sb.append('.');
                    }
                    ++n;
                    ++k;
                    if (i != 0) {
                        break;
                    }
                }
                sb.append('\n');
                ++n2;
            }
            break;
        } while (i == 0);
        return "x: " + this.c + " y: " + this.d + "\n" + sb.toString();
    }
}
