package y.f;

final class j
{
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    private aU g;
    
    j(final int c, final int d, final int a, final int b) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.e = 0;
        this.d = d;
        this.f = 0;
        this.g = new aU(a * b);
    }
    
    int a() {
        return this.e;
    }
    
    int b() {
        return this.f;
    }
    
    void a(final int n, final int n2, final int n3, final int n4) {
        final boolean j = X.j;
        int i = n2;
        while (i < n4) {
            this.a(n, n3, i, true);
            ++i;
            if (j) {
                break;
            }
        }
    }
    
    void c() {
        final boolean j = X.j;
        final int[] array = new int[this.b];
        final int[] array2 = new int[this.b];
        final int[] array3 = new int[this.a];
        final int[] array4 = new int[this.a];
        int i = 0;
        while (true) {
            while (i < array.length) {
                array[i] = this.a;
                array2[i] = -1;
                ++i;
                if (j) {
                    while (true) {
                        while (i < array3.length) {
                            array3[i] = this.b;
                            array4[i] = -1;
                            ++i;
                            if (j) {
                                while (true) {
                                    while (i >= 0) {
                                        final int n = i % this.a;
                                        final int n2 = i / this.a;
                                        array[n2] = Math.min(array[n2], n);
                                        array3[n] = Math.min(array3[n], n2);
                                        array2[n2] = Math.max(array2[n2], n);
                                        array4[n] = Math.max(array4[n], n2);
                                        i = this.g.nextSetBit(i + 1);
                                        if (j) {
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
                                                            if (!j) {
                                                                if (n6 <= n7 && array4[n3] >= k) {
                                                                    int n8 = n3 + 1;
                                                                    while (array3[n8] <= k) {
                                                                        l = array4[n8];
                                                                        n5 = k;
                                                                        if (j) {
                                                                            continue Label_0244;
                                                                        }
                                                                        if (l < n5) {
                                                                            break;
                                                                        }
                                                                        ++n8;
                                                                        if (j) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    this.g.set(i + n3, i + n8);
                                                                }
                                                                ++n3;
                                                                continue Label_0238;
                                                            }
                                                            i = n6 + n7;
                                                            ++k;
                                                            if (j) {
                                                                break Label_0351;
                                                            }
                                                            continue Label_0351;
                                                        }
                                                        break;
                                                    } while (!j);
                                                    final int a = this.a;
                                                    continue;
                                                }
                                            }
                                            return;
                                        }
                                        if (j) {
                                            break;
                                        }
                                    }
                                    i = 0;
                                    continue;
                                }
                            }
                            if (j) {
                                break;
                            }
                        }
                        i = this.g.nextSetBit(0);
                        continue;
                    }
                }
                if (j) {
                    break;
                }
            }
            i = 0;
            continue;
        }
    }
    
    void a(final j j, final int n, final int n2, final double n3, final boolean b) {
        final boolean i = X.j;
        this.a(n - (this.c + this.a / 2), n2 - (this.d + this.b / 2));
        Label_0403: {
            Label_0076: {
                if (b) {
                    int n4 = 0;
                    while (!this.a(j, 0, 0, n4)) {
                        ++n4;
                        if (i) {
                            return;
                        }
                        if (i) {
                            break Label_0076;
                        }
                    }
                    break Label_0403;
                }
            }
            int n5 = 0;
            int n6 = 0;
            if (this.a(j, 0, 0)) {
                j.a(this);
                return;
            }
        Label_0098:
            while (true) {
                while (true) {
                    double n7 = (n5 + 1) / n6 / n3;
                    double n8 = n5 / (n6 + 1) / n3;
                    double a = dcmpg(n7, 1.0);
                Label_0130:
                    while (true) {
                        while (true) {
                            if (a < 0) {
                                n7 = 1.0 / n7;
                            }
                            double a2 = dcmpg(n8, 1.0);
                        Label_0143:
                            while (true) {
                                if (a2 < 0) {
                                    n8 = 1.0 / n8;
                                }
                                Label_0279: {
                                    if (n7 < n8) {
                                        ++n5;
                                        if (this.a(j, -n5, 0)) {
                                            break Label_0403;
                                        }
                                        if (this.a(j, n5, 0)) {
                                            break Label_0403;
                                        }
                                        int k = 1;
                                        while (k <= n6) {
                                            final int n9 = (int)(a = (this.a(j, -n5, -k) ? 1 : 0));
                                            if (i) {
                                                continue Label_0130;
                                            }
                                            if (n9 != 0) {
                                                break Label_0403;
                                            }
                                            if (this.a(j, -n5, k)) {
                                                break Label_0403;
                                            }
                                            if (this.a(j, n5, -k)) {
                                                break Label_0403;
                                            }
                                            if (this.a(j, n5, k)) {
                                                break Label_0403;
                                            }
                                            ++k;
                                            if (i) {
                                                break Label_0279;
                                            }
                                        }
                                        continue Label_0098;
                                    }
                                }
                                ++n6;
                                if (this.a(j, 0, -n6)) {
                                    break Label_0403;
                                }
                                if (this.a(j, 0, n6)) {
                                    break Label_0403;
                                }
                                int l = 1;
                                while (l <= n5) {
                                    final int n10 = (int)(a = (a2 = (this.a(j, l, -n6) ? 1 : 0)));
                                    if (i) {
                                        continue Label_0143;
                                    }
                                    if (i) {
                                        continue Label_0130;
                                    }
                                    if (n10 != 0) {
                                        break Label_0403;
                                    }
                                    if (this.a(j, l, n6)) {
                                        break Label_0403;
                                    }
                                    if (this.a(j, -l, -n6)) {
                                        break Label_0403;
                                    }
                                    if (this.a(j, -l, n6)) {
                                        break Label_0403;
                                    }
                                    ++l;
                                    if (i) {
                                        break Label_0403;
                                    }
                                }
                                continue Label_0098;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        j.a(this);
    }
    
    boolean a(final j j, final int n, final int n2, final int n3) {
        final boolean i = X.j;
        if (n3 == 0) {
            return this.a(j, n, n2);
        }
        int k = n3;
        int n4 = 0;
        int n6;
        final int n5 = n6 = n3 * n3;
        boolean a = false;
        while (k >= n4) {
            a = this.a(j, n + k, n2 + n4);
            if (i) {
                return a;
            }
            if (a) {
                return true;
            }
            if (this.a(j, n + k, n2 - n4)) {
                return true;
            }
            if (this.a(j, n - k, n2 + n4)) {
                return true;
            }
            if (this.a(j, n - k, n2 - n4)) {
                return true;
            }
            if (this.a(j, n + n4, n2 + k)) {
                return true;
            }
            if (this.a(j, n + n4, n2 - k)) {
                return true;
            }
            if (this.a(j, n - n4, n2 + k)) {
                return true;
            }
            if (this.a(j, n - n4, n2 - k)) {
                return true;
            }
            if (n6 < n5) {
                n6 += 1 + 2 * n4;
                ++n4;
                if (!i) {
                    continue;
                }
            }
            n6 += 2 - 2 * k + 2 * n4;
            --k;
            ++n4;
            if (i) {
                break;
            }
        }
        return a;
    }
    
    private final boolean a(final j j, final int n, final int n2) {
        this.c += n;
        this.d += n2;
        if (!this.b(j)) {
            this.e += n;
            this.f += n2;
            return true;
        }
        this.c -= n;
        this.d -= n2;
        return false;
    }
    
    public void a(final int n, final int n2, final boolean b) {
        if (n < this.c || n >= this.c + this.a || n2 < this.d || n2 >= this.d + this.b) {
            throw new IndexOutOfBoundsException();
        }
        final int n3 = (n2 - this.d) * this.a + n - this.c;
        if (b) {
            this.g.set(n3);
            if (!X.j) {
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
            if (!X.j) {
                return;
            }
        }
        this.g.clear(n4, n5);
    }
    
    public void a(final int n, final int n2) {
        this.c += n;
        this.d += n2;
        this.e += n;
        this.f += n2;
    }
    
    public void a(final j j) {
        final boolean i = X.j;
        if (j.c < this.c || j.c >= this.c + this.a || j.d < this.d || j.d >= this.d + this.b || j.c + j.a > this.c + this.a || j.d + j.b > this.d + this.b) {
            this.b(Math.min(j.c, this.c), Math.min(j.d, this.d), Math.max(j.c + j.a, this.c + this.a), Math.max(j.d + j.b, this.d + this.b));
        }
        int k = j.g.nextSetBit(0);
        while (k >= 0) {
            this.g.set(k % j.a + j.c - this.c + (k / j.a + j.d - this.d) * this.a);
            k = j.g.nextSetBit(k + 1);
            if (i) {
                break;
            }
        }
    }
    
    void b(final int c, final int d, final int n, final int n2) {
        final boolean j = X.j;
        final int a = n - c;
        final aU g = new aU(a * (n2 - d));
        int i = this.g.nextSetBit(0);
        while (i >= 0) {
            g.set(i % this.a + this.c - c + (i / this.a + this.d - d) * a);
            i = this.g.nextSetBit(i + 1);
            if (j) {
                return;
            }
            if (j) {
                break;
            }
        }
        this.g = g;
        this.c = c;
        this.d = d;
        this.a = a;
        this.b = n2 - d;
    }
    
    public boolean b(final j j) {
        final boolean i = X.j;
        if (j.c >= this.c + this.a || j.d >= this.d + this.b || j.c + j.a <= this.c || j.d + j.b <= this.d) {
            return false;
        }
        final int max = Math.max(this.c, j.c);
        final int min = Math.min(this.c + this.a, j.c + j.a);
        final int max2 = Math.max(this.d, j.d);
        final int max3 = Math.max(this.d + this.b, j.d + j.b);
        if (max < min && max2 < max3) {
            int k = this.a(max, max2, max, max2, min, max3);
            int n = j.a(max, max2, max, max2, min, max3);
            while (k >= 0) {
                final int n2 = n;
                if (i || n2 < 0) {
                    return n2 != 0;
                }
                final int n3 = k % this.a + this.c;
                final int n4 = n % j.a + j.c;
                final int n5 = k / this.a + this.d;
                final int n6 = n / j.a + j.d;
                if (n5 == n6) {
                    if (n3 == n4) {
                        return true;
                    }
                    if (n3 < n4) {
                        k = this.a(n4, n6, max, max2, min, max3);
                        if (!i) {
                            continue;
                        }
                    }
                    n = j.a(n3, n5, max, max2, min, max3);
                    if (!i) {
                        continue;
                    }
                }
                if (n5 < n6) {
                    k = this.a(n4, n6, max, max2, min, max3);
                    if (!i) {
                        continue;
                    }
                }
                n = j.a(n3, n5, max, max2, min, max3);
                if (i) {
                    goto Label_0390;
                }
            }
            goto Label_0390;
        }
        return false;
    }
    
    public final int a(final int n, final int n2, int n3, int n4, int n5, int n6) {
        final boolean j = X.j;
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
                        if (!j) {
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
                if (!j) {
                    return i;
                }
            }
            return -1;
        }
    }
    
    public String toString() {
        final boolean j = X.j;
        final StringBuffer sb = new StringBuffer(this.a * this.b + this.b + 1);
        int n = 0;
        int n2 = 0;
        do {
            int i = 0;
        Label_0034:
            while (i < this.b) {
                int k = 0;
                while (k < this.a) {
                    i = (this.g.get(n) ? 1 : 0);
                    if (j) {
                        continue Label_0034;
                    }
                    Label_0088: {
                        if (i != 0) {
                            sb.append('#');
                            if (!j) {
                                break Label_0088;
                            }
                        }
                        sb.append('.');
                    }
                    ++n;
                    ++k;
                    if (j) {
                        break;
                    }
                }
                sb.append('\n');
                ++n2;
            }
            break;
        } while (!j);
        return "x: " + this.c + " y: " + this.d + "\n" + sb.toString();
    }
    
    static aU c(final j j) {
        return j.g;
    }
}
