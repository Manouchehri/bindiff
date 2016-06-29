package y.h;

import java.awt.geom.*;
import y.c.*;
import java.util.*;
import y.f.*;
import y.g.*;

abstract class ez
{
    public void a(final X x, final Collection collection, final Rectangle2D rectangle2D, final boolean b) {
        final boolean z = fj.z;
        final ArrayList<eA> list = new ArrayList<eA>(collection.size() * 2);
        while (true) {
            for (final q q : collection) {
                final am a = x.a((Object)q);
                if (z) {
                    final ai ai = new ai();
                    ai.a(new eB(-1.7976931348623157E308, null, null));
                    ai.a(new eB(Double.MAX_VALUE, null, null));
                    final Iterator<eA> iterator2 = list.iterator();
                Label_0308:
                    while (true) {
                        double hasNext = iterator2.hasNext() ? 1 : 0;
                    Label_0315:
                        while (hasNext != 0) {
                            final eA ea = iterator2.next();
                            final eB eb = new eB(ea.d, ea.b, null);
                            aj aj2;
                            final aj aj = aj2 = ai.b(eb);
                            Label_0490: {
                                if (ea.c) {
                                    while (aj2 != null) {
                                        final double n = hasNext = dcmpg(((eB)aj2.c()).a, ea.e);
                                        if (z) {
                                            continue Label_0315;
                                        }
                                        if (n >= 0) {
                                            break;
                                        }
                                        final eB eb2 = (eB)aj2.c();
                                        if (eb2.b != null) {
                                            this.a(ea.b, eb2.b, b, Math.max(ea.d, eb2.a), Math.min(ea.e, ((eB)aj2.a().c()).a));
                                        }
                                        aj2 = aj2.a();
                                        if (z) {
                                            break Label_0490;
                                        }
                                    }
                                    continue Label_0308;
                                }
                            }
                            aj b2 = ai.b(new eB(ea.e, ea.b, null));
                            final q b3 = ((eB)b2.c()).b;
                            final aj a2 = ai.a(aj, eb);
                            if (aj == b2) {
                                b2 = a2;
                            }
                            final aj a3 = ai.a(b2, new eB(ea.e, b3, null));
                            if (a2.a() == a3) {
                                continue Label_0308;
                            }
                            ai.a(a2.a(), a3.b());
                            if (z) {
                                break;
                            }
                            continue Label_0308;
                        }
                        break;
                    }
                    return;
                }
                if (rectangle2D != null && !rectangle2D.intersects(a.getX(), a.getY(), a.getWidth(), a.getHeight())) {
                    continue;
                }
                double n2 = 0.0;
                double n3 = 0.0;
                double n4 = 0.0;
                double n5 = 0.0;
                Label_0201: {
                    if (b) {
                        n2 = a.getX();
                        n3 = n2 + a.getWidth();
                        n4 = a.getY();
                        n5 = n4 + a.getHeight();
                        if (!z) {
                            break Label_0201;
                        }
                    }
                    n2 = a.getY();
                    n3 = n2 + a.getHeight();
                    n4 = a.getX();
                    n5 = n4 + a.getWidth();
                }
                list.add(new eA(n2, q, true, n4, n5));
                list.add(new eA(n3, q, false, n4, n5));
                if (z) {
                    break;
                }
            }
            e.a(list, null);
            continue;
        }
    }
    
    protected abstract void a(final q p0, final q p1, final boolean p2, final double p3, final double p4);
}
