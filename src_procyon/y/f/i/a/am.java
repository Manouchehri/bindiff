package y.f.i.a;

import y.c.*;
import y.f.*;

class am
{
    private final int a;
    private final byte[] b;
    
    am(final i i) {
        this.a = 2 * i.h();
        this.b = new byte[this.a * (this.a - 1) / 2];
    }
    
    int a() {
        return this.a;
    }
    
    void a(final ai ai, final ai ai2, final int n) {
        final boolean b = y.a == ai.h() || y.b == ai.h();
        final boolean b2 = y.a == ai2.h() || y.b == ai2.h();
        this.a(ai.i().b() + (b ? 0 : (this.a / 2)), ai2.i().b() + (b2 ? 0 : (this.a / 2)), n);
        this.a(ai.i().b() + (b ? (this.a / 2) : 0), ai2.i().b() + (b2 ? (this.a / 2) : 0), -n);
    }
    
    void a(int n, int n2, int n3) {
        if (n < n2) {
            final int n4 = n2;
            n2 = n;
            n = n4;
            n3 = -n3;
        }
        final int n5 = n * (n - 1) / 2 + n2;
        final byte b = this.b[n5];
        if (n3 > 0) {
            this.b[n5] = (byte)Math.min(b + n3, 127);
            if (ab.a == 0) {
                return;
            }
        }
        this.b[n5] = (byte)Math.max(b + n3, -128);
    }
    
    byte a(final int n, final int n2) {
        if (n < n2) {
            return (byte)(-this.b[n2 * (n2 - 1) / 2 + n]);
        }
        if (n > n2) {
            return this.b[n * (n - 1) / 2 + n2];
        }
        return 0;
    }
    
    public String toString() {
        final int i = ab.a;
        final StringBuffer sb = new StringBuffer();
        sb.append("Edge Order Matrix:\n");
        int n = 0;
        do {
            Label_0022: {
                final int a = this.a;
            }
            int j = 0;
            int n2 = 0;
            Label_0027:
            while (j < n2) {
                Label_0077: {
                    if (n == this.a / 2) {
                        int k = 0;
                        while (k < this.a) {
                            sb.append("----");
                            ++k;
                            if (i != 0) {
                                break Label_0077;
                            }
                            if (i != 0) {
                                break;
                            }
                        }
                        sb.append("\n");
                    }
                }
                int l = 0;
                while (l < this.a) {
                    j = l;
                    n2 = this.a / 2;
                    if (i != 0) {
                        continue Label_0027;
                    }
                    if (j == n2) {
                        sb.append("| ");
                    }
                    final byte a2 = this.a(l, n);
                    Label_0141: {
                        if (a2 >= 0) {
                            sb.append("+");
                            if (i == 0) {
                                break Label_0141;
                            }
                        }
                        sb.append("-");
                    }
                    if (Math.abs(a2) < 10) {
                        sb.append(0);
                    }
                    sb.append(Math.abs(a2));
                    sb.append(" ");
                    ++l;
                    if (i != 0) {
                        break;
                    }
                }
                sb.append("\n");
                ++n;
                continue Label_0022;
            }
            break;
        } while (i == 0);
        return sb.toString();
    }
}
