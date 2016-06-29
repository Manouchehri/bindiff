package y.f.i.a;

import y.c.*;
import java.text.*;
import java.util.*;

public class U
{
    private final List a;
    private final double b;
    private final d c;
    
    public U(final d c, final List list, final double b) {
        this.c = c;
        this.a = new ArrayList(list);
        this.b = b;
    }
    
    public d a() {
        return this.c;
    }
    
    public f a(final int n) {
        return this.a.get(n);
    }
    
    public void a(final int n, final f f) {
        this.a.set(n, f);
    }
    
    public int a(final f f) {
        return this.a.indexOf(f);
    }
    
    public int b() {
        return this.a.size();
    }
    
    public String toString() {
        final int a = ab.a;
        final NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMaximumFractionDigits(2);
        final StringBuffer sb = new StringBuffer();
        sb.append(this.c);
        sb.append(": ");
        for (final f f : this.a) {
            final StringBuffer append = sb.append(" << ").append(f.a().e());
            if (a != 0) {
                return append.toString();
            }
            final P c = f.c();
            if (c != null) {
                sb.append(" [").append(c.b()).append(" ").append(c.c()).append("]");
            }
            sb.append(" (cost ").append(numberInstance.format(f.f())).append(")");
            if (a != 0) {
                break;
            }
        }
        final StringBuffer append = sb;
        return append.toString();
    }
}
