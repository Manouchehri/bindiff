package y.f;

public class W implements aH
{
    public double a(final Q q) {
        final boolean j = X.j;
        final R e = q.e();
        if (e instanceof aj) {
            return 1.0;
        }
        final C c = (C)e;
        final byte a = c.getPreferredPlacementDescriptor().a();
        final E labelModel = c.getLabelModel();
        double e2 = 0.0;
        double n = 0.5;
        Label_0100: {
            switch (a) {
                case 1: {
                    n = 0.0;
                    if (j) {
                        break Label_0100;
                    }
                    break;
                }
                case 2: {
                    n = 1.0;
                    if (j) {
                        break Label_0100;
                    }
                    break;
                }
                case 4: {
                    n = 0.5;
                    break;
                }
            }
        }
        if (labelModel instanceof aO) {
            e2 = ((aP)q.l()).e();
        }
        if (labelModel instanceof z) {
            Label_0260: {
                switch ((int)q.l()) {
                    case 1:
                    case 8:
                    case 64: {
                        e2 = 0.05;
                        if (j) {
                            break Label_0260;
                        }
                        break;
                    }
                    case 2:
                    case 16:
                    case 128: {
                        e2 = 0.5;
                        if (j) {
                            break Label_0260;
                        }
                        break;
                    }
                    case 4:
                    case 32:
                    case 256: {
                        e2 = 0.95;
                        break;
                    }
                }
            }
        }
        return 1.0 - Math.abs((n - e2) * 2.0);
    }
}
