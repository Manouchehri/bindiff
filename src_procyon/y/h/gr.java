package y.h;

public class gr implements aI
{
    public int a(final aB ab) {
        return 0;
    }
    
    public x a(final aB ab, final z z, final double n, final double n2, final x x, final int n3) {
        final x x2 = new x(ab, n, n2);
        this.a(ab, z, x2, x, n3);
        return x2;
    }
    
    public void a(final aB ab, final z z, final x x, final x x2, final int n) {
        final boolean z2 = fj.z;
        Label_0101: {
            if (n == 0) {
                if (z.size() > 0 && x2 == z.i()) {
                    z.b(x, z.l());
                    if (!z2) {
                        break Label_0101;
                    }
                }
                z.b(x, z.d(x2));
                if (!z2) {
                    break Label_0101;
                }
            }
            if (z.size() > 0 && x2 == z.f()) {
                z.a(x, z.k());
                if (!z2) {
                    break Label_0101;
                }
            }
            z.a(x, z.d(x2));
        }
        ab.setDirty();
    }
    
    public x a(final aB ab, final z z, final double n, final double n2) {
        final int containsSeg = ab.containsSeg(n, n2);
        if (containsSeg > 0 && containsSeg <= z.size()) {
            return this.a(ab, z, n, n2, (x)z.a(containsSeg - 1), 1);
        }
        return ab.appendBend(n, n2);
    }
    
    public void a(final aB ab, final z z, final x x, final double n, final double n2) {
    }
    
    public x a(final aB ab, final z z, final x x) {
        z.remove(x);
        ab.setDirty();
        return x;
    }
}
