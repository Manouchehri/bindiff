package y.f.c.a;

import y.f.*;
import y.c.*;

public class x implements aS
{
    private byte a;
    
    public x() {
        this((byte)18);
    }
    
    public x(final byte a) {
        this.a = a;
    }
    
    public byte a() {
        return this.a;
    }
    
    public void a(final X x, final aV av, final aU au, final aU au2) {
        final boolean x2 = N.x;
        final boolean b = (this.a() & 0x3) != 0x3;
        Label_0187: {
            switch (this.a()) {
                default: {
                    this.a(au, au2, au2.b(), true);
                    if (x2) {
                        break Label_0187;
                    }
                    break;
                }
                case 1: {
                    this.a(au, au2, -au.b(), true);
                    if (x2) {
                        break Label_0187;
                    }
                    break;
                }
                case 18:
                case 19: {
                    this.a(au, au2, 0, b);
                    if (x2) {
                        break Label_0187;
                    }
                    break;
                }
                case 34:
                case 35: {
                    this.a(au, au2, au2.b() - au.b(), b);
                    if (x2) {
                        break Label_0187;
                    }
                    break;
                }
                case 66:
                case 67: {
                    this.a(au, au2, (au2.b() - au.b()) / 2, b);
                    break;
                }
            }
        }
    }
    
    private void a(final aU au, final aU au2, int i, final boolean b) {
        final boolean x = N.x;
        int n = 0;
        while (i < 0) {
            au2.a(au.a(n).e(), 0);
            ++n;
            ++i;
            if (x) {
                break;
            }
        }
        int j = 0;
    Label_0047:
        while (j < au.b()) {
            final aQ a = au.a(j);
            final int n2 = j + i;
            while (au2.b() <= n2) {
                au2.a(a.e(), au2.b());
                if (x) {
                    continue Label_0047;
                }
                if (x) {
                    break;
                }
            }
            final aQ a2 = au2.a(n2);
            Label_0270: {
                Label_0267: {
                    Label_0183: {
                        if (b) {
                            p p4 = a.d().k();
                            while (p4 != null) {
                                a2.a((q)p4.c());
                                p4 = p4.a();
                                if (x) {
                                    break Label_0270;
                                }
                                if (x) {
                                    break Label_0183;
                                }
                            }
                            break Label_0267;
                        }
                    }
                    final y d = a2.d();
                    p p5 = a.d().l();
                    while (p5 != null) {
                        a2.a((q)p5.c());
                        final p l = d.l();
                        d.h(l);
                        d.b(l);
                        p5 = p5.b();
                        if (x) {
                            break Label_0270;
                        }
                        if (x) {
                            break;
                        }
                    }
                }
                ++j;
            }
            if (x) {
                break;
            }
        }
    }
}
