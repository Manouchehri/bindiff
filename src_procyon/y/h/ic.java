package y.h;

class ic
{
    static void a(final ch ch, final aB ab, final boolean b) {
        a(ch, ab, b, (byte)3);
    }
    
    static byte a(final ch ch, final aB ab, final boolean b, final byte b2) {
        final fL fl = b ? ab.getSourcePort() : ab.getTargetPort();
        final fj fj = b ? ab.getSourceRealizer() : ab.getTargetRealizer();
        return a(ch, ab, fl.a(fj), fl.b(fj), b, b2);
    }
    
    static void a(final ch ch, final aB ab, final double n, final double n2, final boolean b) {
        a(ch, ab, n, n2, b, (byte)3);
    }
    
    static byte a(final ch ch, final aB ab, final double n, final double n2, final boolean b, final byte b2) {
        if (ab.bendCount() > 0) {
            final x x = b ? ab.firstBend() : ab.lastBend();
            double n3 = 0.0;
            double n4 = 0.0;
            Label_0128: {
                if (ab.bendCount() > 1) {
                    final x bend = ab.getBend(b ? 1 : (ab.bendCount() - 2));
                    n3 = bend.b();
                    n4 = bend.c();
                    if (!fj.z) {
                        break Label_0128;
                    }
                }
                final fL fl = b ? ab.getTargetPort() : ab.getSourcePort();
                final fj fj = b ? ab.getTargetRealizer() : ab.getSourceRealizer();
                n3 = fl.a(fj);
                n4 = fl.b(fj);
            }
            final double b3 = x.b();
            final double c = x.c();
            if (1 == b2 || (2 != b2 && Math.abs(b3 - n3) > Math.abs(c - n4))) {
                if (0 != b2) {
                    x.a(n, n4);
                }
                return 1;
            }
            if (0 != b2) {
                x.a(n3, n2);
            }
            return 2;
        }
        else {
            final fL fl2 = b ? ab.getTargetPort() : ab.getSourcePort();
            final fj fj2 = b ? ab.getTargetRealizer() : ab.getSourceRealizer();
            final double a = fl2.a(fj2);
            final double b4 = fl2.b(fj2);
            final double n5 = a - n;
            final double n6 = b4 - n2;
            if (1 == b2 || (2 != b2 && Math.abs(n5) > Math.abs(n6))) {
                if (0 != b2 && n2 != b4) {
                    final double a2 = a(ch, n + n5 * 0.5);
                    ab.addPoint(a2, b ? n2 : b4);
                    ab.addPoint(a2, b ? b4 : n2);
                }
                return 1;
            }
            if (0 != b2 && n != a) {
                final double b5 = b(ch, n2 + n6 * 0.5);
                ab.addPoint(b ? n : a, b5);
                ab.addPoint(b ? a : n, b5);
            }
            return 2;
        }
    }
    
    protected static double a(final ch ch, final double n) {
        if (ch == null || !ch.getGridMode()) {
            return n;
        }
        final double gridResolution = ch.getGridResolution();
        return Math.floor(n / gridResolution + 0.5) * gridResolution;
    }
    
    protected static double b(final ch ch, final double n) {
        if (ch == null || !ch.getGridMode()) {
            return n;
        }
        final double gridResolution = ch.getGridResolution();
        return Math.floor(n / gridResolution + 0.5) * gridResolution;
    }
}
