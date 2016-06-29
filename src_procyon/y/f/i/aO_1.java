package y.f.i;

import y.f.*;
import y.d.*;
import y.c.*;

class aO
{
    private f[] a;
    private int[] b;
    private int c;
    private q d;
    private X e;
    private final aK f;
    
    public aO(final aK f, final q d, final c c) {
        final int f2 = v.f;
        this.f = f;
        this.a = new f[4];
        this.b = new int[4];
        this.c = 0;
        int i = 0;
        while (true) {
            while (i < 4) {
                this.a[i] = new f();
                ++i;
                if (f2 != 0) {
                    Label_0107: {
                        if (c != null) {
                            this.a(c);
                            if (f2 == 0) {
                                break Label_0107;
                            }
                        }
                        this.e();
                    }
                    this.f();
                    return;
                }
                if (f2 != 0) {
                    break;
                }
            }
            this.d = d;
            this.e = (X)this.d.e();
            continue;
        }
    }
    
    private void a(final c c) {
        final int f = v.f;
        final boolean[] array = new boolean[4];
        final e j = this.d.j();
        while (true) {
            while (j.f()) {
                final d a = j.a();
                final int d;
                final int n = d = (aK.a(this.f).d(a) ? 1 : 0);
                if (f != 0) {
                    int i = d;
                    while (i < 4) {
                        if (!array[i]) {
                            this.a[i].clear();
                        }
                        ++i;
                        if (f != 0) {
                            break;
                        }
                    }
                    return;
                }
                if (n == 0) {
                    final boolean b = this.d == a.c();
                    final D m = this.e.m(a);
                    final int size = m.size();
                    t t = null;
                    t t2 = null;
                    Label_0156: {
                        if (b) {
                            t = (t)m.a(0);
                            t2 = (t)m.a(1);
                            if (f == 0) {
                                break Label_0156;
                            }
                        }
                        t = (t)m.a(size - 1);
                        t2 = (t)m.a(size - 2);
                    }
                    final int a2 = this.a(t, t2);
                    if (a2 != -9) {
                        this.a[a2].add(a);
                        if (c.d(a)) {
                            array[a2] = true;
                        }
                    }
                }
                j.g();
                if (f != 0) {
                    break;
                }
            }
            int d = 0;
            continue;
        }
    }
    
    private void e() {
        final int f = v.f;
        final e j = this.d.j();
        while (j.f()) {
            final d a = j.a();
            final boolean b = this.d == a.c();
            final D m = this.e.m(a);
            final int size = m.size();
            t t = null;
            t t2 = null;
            Label_0122: {
                if (b) {
                    t = (t)m.a(0);
                    t2 = (t)m.a(1);
                    if (f == 0) {
                        break Label_0122;
                    }
                }
                t = (t)m.a(size - 1);
                t2 = (t)m.a(size - 2);
            }
            final int a2 = this.a(t, t2);
            if (a2 != -9) {
                this.a[a2].add(a);
            }
            j.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    private int a(final t t, final t t2) {
        final int f = v.f;
        if (Math.abs(t.a - t2.a) < 0.01) {
            final int n = (t2.b > this.e.n(this.d) + this.e.q(this.d) / 2.0) ? 1 : 0;
            if (f == 0) {
                return n;
            }
        }
        if (Math.abs(t.b - t2.b) < 0.01) {
            final int n = (t2.a <= this.e.m(this.d) + this.e.p(this.d) / 2.0) ? 2 : 3;
            if (f == 0) {
                return n;
            }
        }
        return -9;
    }
    
    private void f() {
        final int f = v.f;
        int size = Integer.MIN_VALUE;
        int n = -1;
        int size2 = Integer.MAX_VALUE;
        int n2 = -1;
        int i = 0;
        while (true) {
            while (i < 4) {
                final int size3 = this.a[i].size();
                if (f != 0) {
                    final int[] array = new int[size3];
                    array[1] = (array[0] = 0);
                    final int[] array2 = array;
                    int j = 0;
                    while (true) {
                        while (j < 4) {
                            final int n3 = j;
                            final int n4 = n2;
                            if (f != 0) {
                                if (n3 > n4) {
                                    this.b[1] = array2[0];
                                    this.b[2] = array2[1];
                                    if (f == 0) {
                                        return;
                                    }
                                }
                                this.b[1] = array2[1];
                                this.b[2] = array2[0];
                                return;
                            }
                            if (n3 != n4 && j != n) {
                                array2[1] = array2[0];
                                array2[0] = j;
                            }
                            ++j;
                            if (f != 0) {
                                break;
                            }
                        }
                        this.a[array2[0]].size();
                        this.a[array2[1]].size();
                        continue;
                    }
                }
                if (size3 > size) {
                    n = i;
                    size = this.a[i].size();
                }
                if (this.a[i].size() <= size2) {
                    n2 = i;
                    size2 = this.a[i].size();
                }
                ++i;
                if (f != 0) {
                    break;
                }
            }
            this.b[0] = n;
            this.b[3] = n2;
            continue;
        }
    }
    
    public void a() {
        this.c = 0;
    }
    
    public boolean b() {
        ++this.c;
        return this.c >= 0 && this.c < 4;
    }
    
    public f c() {
        return this.a[this.b[this.c]];
    }
    
    public int d() {
        return this.b[this.c];
    }
    
    public String toString() {
        final int f = v.f;
        final StringBuffer sb = new StringBuffer();
        sb.append("[n: ").append(this.d);
        sb.append("; sequence = (");
        int i = 0;
        while (i < 3) {
            sb.append(this.b[i]).append(", ");
            ++i;
            if (f != 0) {
                return sb.toString();
            }
            if (f != 0) {
                break;
            }
        }
        sb.append(this.b[3]).append(")");
        sb.append("; currIndex = ").append(this.c).append("]");
        return sb.toString();
    }
}
