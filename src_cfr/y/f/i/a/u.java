/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import y.c.d;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.ab;
import y.f.i.a.f;

public class U {
    private final List a;
    private final double b;
    private final d c;

    public U(d d2, List list, double d3) {
        this.c = d2;
        this.a = new ArrayList(list);
        this.b = d3;
    }

    public d a() {
        return this.c;
    }

    public f a(int n2) {
        return (f)this.a.get(n2);
    }

    public void a(int n2, f f2) {
        this.a.set(n2, f2);
    }

    public int a(f f2) {
        return this.a.indexOf(f2);
    }

    public int b() {
        return this.a.size();
    }

    public String toString() {
        StringBuffer stringBuffer;
        int n2 = ab.a;
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(this.c);
        stringBuffer2.append(": ");
        for (f f2 : this.a) {
            stringBuffer = stringBuffer2.append(" << ").append(f2.a().e());
            if (n2 != 0) return stringBuffer.toString();
            P p2 = f2.c();
            if (p2 != null) {
                stringBuffer2.append(" [").append(p2.b()).append(" ").append(p2.c()).append("]");
            }
            stringBuffer2.append(" (cost ").append(numberFormat.format(f2.f())).append(")");
            if (n2 == 0) continue;
        }
        stringBuffer = stringBuffer2;
        return stringBuffer.toString();
    }
}

