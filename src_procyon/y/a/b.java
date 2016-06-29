package y.a;

import y.g.*;
import y.c.*;

public class b
{
    public static y[] a(final i i, final y y) {
        return a(i, y, M.a(new int[i.e()]));
    }
    
    public static y[] a(final i i, final c c, final A a) {
        return a(i, new y(i.o(), c), a);
    }
    
    public static y[] a(final i i, final y y, final A a) {
        return a(i, y, false, a);
    }
    
    public static y[] a(final i i, final y y, final boolean b, final A a) {
        return a(i, y, b, a, 0);
    }
    
    public static y[] a(final i i, final y y, final boolean b, final A a, final int n) {
        return a(i, y, (byte)(b ? 2 : 3), a, n);
    }
    
    public static y[] a(final i i, final y y, final byte b, final A a, final int n) {
        final boolean a2 = h.a;
        switch (b) {
            case 1:
            case 2:
            case 3: {
                if (a2) {
                    break;
                }
                final D d = new D();
                if (i.i()) {
                    return new y[0];
                }
                y y2 = new y();
                int n2 = 0;
                x x = i.o();
                while (true) {
                Label_0436_Outer:
                    while (x.f()) {
                        a.a(x.e(), -1);
                        x.g();
                        if (a2) {
                        Label_0436:
                            while (true) {
                                while (x.f()) {
                                    final q e = x.e();
                                    a.a(e, n2);
                                    y2.b(e);
                                    x.g();
                                    if (a2) {
                                        return (y[])d.toArray(new y[d.size()]);
                                    }
                                    if (a2) {
                                        break;
                                    }
                                }
                            Label_0423_Outer:
                                while (!y2.isEmpty()) {
                                    final y y3 = y2;
                                    d.b(y3);
                                    y2 = new y();
                                    ++n2;
                                    final x a3 = y3.a();
                                    while (true) {
                                        while (a3.f()) {
                                            final q e2 = a3.e();
                                            final int n3 = b;
                                            int a4 = 0;
                                            int n4 = 0;
                                            Label_0430: {
                                                if (!a2) {
                                                    while (true) {
                                                        Label_0336: {
                                                            x x2 = null;
                                                            Label_0324: {
                                                                switch (b) {
                                                                    case 1: {
                                                                        x2 = e2.n();
                                                                        if (a2) {
                                                                            break Label_0324;
                                                                        }
                                                                        break;
                                                                    }
                                                                    case 2: {
                                                                        x2 = e2.o();
                                                                        if (a2) {
                                                                            break Label_0324;
                                                                        }
                                                                        break;
                                                                    }
                                                                    case 3: {
                                                                        x2 = e2.m();
                                                                        if (a2) {
                                                                            break Label_0336;
                                                                        }
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            while (x2.f()) {
                                                                final q e3 = x2.e();
                                                                a4 = a.a(e3);
                                                                n4 = -1;
                                                                if (a2) {
                                                                    break Label_0430;
                                                                }
                                                                if (a4 == n4) {
                                                                    a.a(e3, n2);
                                                                    y2.b(e3);
                                                                }
                                                                x2.g();
                                                                if (a2) {
                                                                    break;
                                                                }
                                                            }
                                                            a3.g();
                                                            if (a2) {
                                                                break;
                                                            }
                                                            continue Label_0436_Outer;
                                                        }
                                                        x x2 = e2.m();
                                                        continue Label_0423_Outer;
                                                    }
                                                }
                                                if (n3 <= 0) {
                                                    continue Label_0423_Outer;
                                                }
                                            }
                                            if (a4 == n4) {
                                                continue Label_0436;
                                            }
                                            continue Label_0423_Outer;
                                        }
                                        final int n3 = n;
                                        continue;
                                    }
                                }
                                break;
                            }
                            return (y[])d.toArray(new y[d.size()]);
                        }
                        if (a2) {
                            break;
                        }
                    }
                    x = y.a();
                    continue;
                }
            }
        }
        throw new IllegalArgumentException("Unsupported direction: " + b);
    }
}
