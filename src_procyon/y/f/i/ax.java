package y.f.i;

import y.c.*;
import y.g.*;

class ax
{
    private az a;
    private int b;
    private ay c;
    private final av d;
    
    public ax(final av d, final ay c) {
        this.d = d;
        this.c = c;
        this.a = null;
        this.b = 0;
    }
    
    public boolean a(final double n, final Object o) {
        final int f = v.f;
        boolean b = false;
        if (this.b == 0) {
            this.a = new az(this.d, n, o);
            if (this.a != null) {
                b = true;
                ++this.b;
            }
            return b;
        }
        az a = this.a;
        az az = this.a;
        while (true) {
            while (az != null) {
                final az az2 = az;
                if (f != 0) {
                    final az az3 = az2;
                    Label_0169: {
                        if (az3 != null) {
                            b = true;
                            if (n < y.f.i.az.a(a)) {
                                y.f.i.az.a(a, az3);
                                if (f == 0) {
                                    break Label_0169;
                                }
                            }
                            y.f.i.az.b(a, az3);
                        }
                    }
                    ++this.b;
                    return b;
                }
                a = az2;
                if (n < y.f.i.az.a(az)) {
                    az = y.f.i.az.b(az);
                    if (f == 0) {
                        continue;
                    }
                }
                az = y.f.i.az.c(az);
                if (f != 0) {
                    break;
                }
            }
            final az az4 = new az(this.d, n, o);
            continue;
        }
    }
    
    private az[] a(final az az, final double n) {
        final int f = v.f;
        final az[] array = new az[2];
        az az2 = az;
        az az3 = az;
        int n2 = 0;
        int n3 = 0;
        Label_0093: {
            while (az3 != null) {
                n3 = n2;
                if (f != 0 || n3 != 0) {
                    break Label_0093;
                }
                if (n == az.a(az3)) {
                    n2 = 1;
                    if (f == 0) {
                        continue;
                    }
                }
                az2 = az3;
                if (n < az.a(az3)) {
                    az3 = az.b(az3);
                    if (f == 0) {
                        continue;
                    }
                }
                az3 = az.c(az3);
                if (f != 0) {
                    goto Label_0091;
                }
            }
            goto Label_0091;
        }
        if (n3 == 0) {
            array[1] = (array[0] = null);
            if (f == 0) {
                return array;
            }
        }
        array[0] = az2;
        array[1] = az3;
        return array;
    }
    
    public Object b(final double n, final Object o) {
        final int f = v.f;
        if (this.b == 0) {
            return null;
        }
        int n2 = 0;
        az a = this.a;
        az a2 = this.a;
        int n3 = 0;
        Label_0135: {
            Block_6: {
                while (a2 != null) {
                    n3 = n2;
                    if (f != 0 || n3 != 0) {
                        break Label_0135;
                    }
                    final az[] a3 = this.a(a2, n);
                    if (a3[0] == null && a3[1] == null) {
                        break Block_6;
                    }
                    if (a3[0] != a3[1]) {
                        a = a3[0];
                    }
                    a2 = a3[1];
                    if (this.c.a(o, az.d(a2))) {
                        n2 = 1;
                        if (f == 0) {
                            continue;
                        }
                    }
                    a = a2;
                    a2 = az.c(a2);
                    if (f != 0) {
                        goto Label_0133;
                    }
                }
                goto Label_0133;
            }
            goto Label_0133;
        }
        if (n3 != 0) {
            final az az = a2;
            Label_0271: {
                if (y.f.i.az.c(az) == null) {
                    a2 = y.f.i.az.b(a2);
                    if (f == 0) {
                        break Label_0271;
                    }
                }
                if (y.f.i.az.b(y.f.i.az.c(az)) == null) {
                    a2 = y.f.i.az.c(a2);
                    y.f.i.az.a(a2, y.f.i.az.b(az));
                    if (f == 0) {
                        break Label_0271;
                    }
                }
                az az2 = y.f.i.az.c(a2);
                while (true) {
                    while (y.f.i.az.b(y.f.i.az.b(az2)) != null) {
                        az2 = y.f.i.az.b(az2);
                        if (f != 0) {
                            y.f.i.az.b(a2, y.f.i.az.c(az));
                            break Label_0271;
                        }
                        if (f != 0) {
                            break;
                        }
                    }
                    a2 = y.f.i.az.b(az2);
                    y.f.i.az.a(az2, y.f.i.az.c(a2));
                    y.f.i.az.a(a2, y.f.i.az.b(az));
                    continue;
                }
            }
            Label_0324: {
                if (a == az) {
                    this.a = a2;
                    if (f == 0) {
                        break Label_0324;
                    }
                }
                if (y.f.i.az.a(az) < y.f.i.az.a(a)) {
                    y.f.i.az.a(a, a2);
                    if (f == 0) {
                        break Label_0324;
                    }
                }
                y.f.i.az.b(a, a2);
            }
            --this.b;
            return y.f.i.az.d(az);
        }
        return null;
    }
    
    public D a() {
        final int f = v.f;
        final D d = new D();
        final d d2 = new d(this.b);
        az az = this.a;
        while (true) {
            Label_0086: {
                if (az != null) {
                    d2.a(az);
                    az = y.f.i.az.b(az);
                    if (f != 0) {
                        break Label_0086;
                    }
                    if (f == 0) {
                        continue;
                    }
                }
                if (d2.c()) {
                    break;
                }
                final az az2 = (az)d2.b();
                d.add(y.f.i.az.d(az2));
                az = y.f.i.az.c(az2);
            }
            if (f != 0) {
                break;
            }
        }
        return d;
    }
}
