package y.a;

import y.c.*;

class o
{
    private int a;
    
    private o() {
    }
    
    private void a(final i i, final int[] array) {
        final boolean a = h.a;
        int j = i.e() - 1;
        while (j >= 0) {
            array[j] = -1;
            --j;
            if (a) {
                break;
            }
        }
        final d[] array2 = new d[i.e()];
        this.a = 0;
        x x = i.o();
        while (true) {
            while (x.f()) {
                final q e = x.e();
                final int b = e.b();
                if (a) {
                    while (true) {
                        if (b != 0) {
                            final q e2 = x.e();
                            if (array[e2.d()] == -1) {
                                this.a(e2, array2, array);
                            }
                            x.g();
                            if (!a) {
                                x.f();
                                continue;
                            }
                        }
                        break;
                    }
                    return;
                }
                if (b == 0) {
                    this.a(e, array2, array);
                    if (!a) {
                        break;
                    }
                }
                x.g();
                if (a) {
                    break;
                }
            }
            x = i.o();
            continue;
        }
    }
    
    private y a(final i i) {
        final boolean a = h.a;
        final y y = new y();
        final byte[] array = new byte[i.e()];
        final d[] array2 = new d[i.e()];
        x x = i.o();
        while (true) {
            while (x.f()) {
                final q e = x.e();
                final int b = e.b();
                if (a) {
                    while (true) {
                        if (b != 0) {
                            final q e2 = x.e();
                            if (array[e2.d()] == 0) {
                                this.a(e2, array2, array, y);
                            }
                            x.g();
                            if (!a) {
                                x.f();
                                continue;
                            }
                        }
                        break;
                    }
                    return y;
                }
                if (b == 0) {
                    this.a(e, array2, array, y);
                    if (!a) {
                        break;
                    }
                }
                x.g();
                if (a) {
                    break;
                }
            }
            x = i.o();
            continue;
        }
    }
    
    private void a(final q q, final d[] array, final int[] array2) {
        final boolean a = h.a;
        if (q.c() == 0) {
            array2[q.d()] = this.a++;
            if (!a) {
                return;
            }
        }
        int i = 0;
        array2[q.d()] = -2;
        array[i] = q.f();
        while (i >= 0) {
            final d d = array[i];
            final q d2 = d.d();
            final int d3 = d2.d();
            if (array2[d3] == -1) {
                if (d2.c() == 0) {
                    array2[d3] = this.a++;
                    if (!a) {
                        continue;
                    }
                }
                array2[d3] = -2;
                array[++i] = d2.f();
                if (!a) {
                    continue;
                }
            }
            final d g = d.g();
            if (g == null) {
                array2[d.c().d()] = this.a++;
                --i;
                if (!a) {
                    continue;
                }
            }
            array[i] = g;
            if (a) {
                break;
            }
        }
    }
    
    private void a(final q q, final d[] array, final byte[] array2, final y y) {
        final boolean a = h.a;
        if (q.c() == 0) {
            array2[q.d()] = -2;
            y.add(q);
            if (!a) {
                return;
            }
        }
        int i = 0;
        array2[q.d()] = -1;
        array[i] = q.f();
        while (i >= 0) {
            final d d = array[i];
            final q d2 = d.d();
            final int d3 = d2.d();
            if (array2[d3] == 0) {
                if (d2.c() == 0) {
                    array2[d3] = -2;
                    y.add(d2);
                    if (!a) {
                        continue;
                    }
                }
                array2[d3] = -1;
                array[++i] = d2.f();
                if (!a) {
                    continue;
                }
            }
            final d g = d.g();
            if (g == null) {
                array2[d.c().d()] = -2;
                y.add(d.c());
                --i;
                if (!a) {
                    continue;
                }
            }
            array[i] = g;
            if (a) {
                break;
            }
        }
    }
    
    o(final n n) {
        this();
    }
    
    static void a(final o o, final i i, final int[] array) {
        o.a(i, array);
    }
    
    static y a(final o o, final i i) {
        return o.a(i);
    }
}
