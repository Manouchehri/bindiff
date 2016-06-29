/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import y.c.D;
import y.d.n;
import y.d.q;
import y.d.t;
import y.d.y;
import y.f.ai;
import y.f.aj;
import y.f.al;
import y.f.am;
import y.h.eR;
import y.h.eU;
import y.h.fN;
import y.h.fj;

public class fM
implements al {
    private static final byte[] a = new byte[]{0, 1, 2, 3, 4};
    private final double b;
    private final boolean c;

    public boolean a() {
        return this.c;
    }

    @Override
    public Object a(n n2, am am2) {
        if (fM.a(n2)) {
            throw new IllegalArgumentException(new StringBuffer().append("Invalid label bounds: ").append(n2).toString());
        }
        t t2 = n2.k();
        q q2 = n2.d();
        return this.a(new y(t2.a() - q2.a() * 0.5, t2.b() - q2.b() * 0.5, q2.a(), q2.b()), am2);
    }

    private Object a(y y2, am am2) {
        boolean bl2 = fj.z;
        fN fN2 = null;
        if (!(am2 instanceof fj)) return this.c();
        fj fj2 = (fj)am2;
        if (fj2.portCount() > 0) {
            double d2 = Double.POSITIVE_INFINITY;
            t t2 = y2.e();
            Iterator iterator = fj2.ports();
            block0 : do {
                int n2 = iterator.hasNext();
                block1 : while (n2 != 0) {
                    eU eU2 = (eU)iterator.next();
                    int n3 = 0;
                    do {
                        if (n3 >= a.length) continue block0;
                        byte by2 = a[n3];
                        t t3 = this.a((q)y2, eU2, by2);
                        double d3 = t.a(t2, t3);
                        if (bl2) return fN2;
                        n2 = d2 DCMPL d3;
                        if (bl2) continue block1;
                        if (n2 > 0) {
                            d2 = d3;
                            fN2 = new fN(fj2.c(eU2), by2);
                        }
                        ++n3;
                    } while (!bl2);
                }
                break block0;
                break;
            } while (true);
        }
        if (fN2 != null) return fN2;
        return this.c();
    }

    @Override
    public Object c() {
        return new fN(null, 0);
    }

    @Override
    public n a(q q2, am am2, Object object) {
        t t2 = this.b(q2, am2, object);
        return new n(new t(t2.a(), t2.b() + q2.b()), q2);
    }

    private t b(q q2, am am2, Object object) {
        if (!(am2 instanceof fj)) return this.a(q2, am2);
        fN fN2 = fM.c(object);
        eU eU2 = fM.a((fj)am2, object);
        if (eU2 == null) return this.a(q2, am2);
        return this.a(q2, eU2, fN2.b);
    }

    private t a(q q2, am am2) {
        return new t(am2.getX() + (am2.getWidth() - q2.a) * 0.5, am2.getY() + (am2.getHeight() - q2.b) * 0.5);
    }

    @Override
    public D a(aj aj2, am am2) {
        Iterator iterator;
        Object object;
        boolean bl2 = fj.z;
        D d2 = new D();
        if (am2 instanceof fj && (iterator = this.a(aj2, (fj)(object = (fj)am2))).hasNext()) {
            y y2 = aj2.getBox();
            block0 : while (iterator.hasNext()) {
                eU eU2 = (eU)iterator.next();
                Object object2 = object.c(eU2);
                for (int i2 = 0; i2 < a.length; ++i2) {
                    d2.add(new ai(this.a((q)y2, eU2, a[i2]), y2, new fN(object2, a[i2]), aj2, true));
                    if (bl2) break block0;
                    if (bl2) return d2;
                    if (!bl2) continue;
                }
            }
        }
        if (!d2.isEmpty()) return d2;
        object = aj2.getBox();
        d2.add(new ai(this.a((q)object, am2), (q)object, this.c(), aj2, true));
        return d2;
    }

    private Iterator a(aj aj2, fj fj2) {
        if (fj2.portCount() <= 0) return Collections.EMPTY_LIST.iterator();
        if (!this.a()) return fj2.ports();
        if (!fM.a(aj2.getModelParameter())) return Collections.EMPTY_LIST.iterator();
        eU eU2 = fM.a(fj2, aj2.getModelParameter());
        if (eU2 == null) return Collections.EMPTY_LIST.iterator();
        ArrayList<eU> arrayList = new ArrayList<eU>(1);
        arrayList.add(eU2);
        return arrayList.iterator();
    }

    private t a(q q2, eU eU2, byte by2) {
        y y2 = eU2.k();
        double d2 = y2.a();
        double d3 = y2.b();
        double d4 = y2.c() + 0.5 * d2;
        double d5 = y2.d() + 0.5 * d3;
        switch (by2) {
            case 0: {
                return new t(d4 - q2.a() * 0.5, d5 - d3 * 0.5 - this.b - q2.b());
            }
            case 1: {
                return new t(d4 - q2.a() * 0.5, d5 + d3 * 0.5 + this.b);
            }
            case 2: {
                return new t(d4 + d2 * 0.5 + this.b, d5 - q2.b() * 0.5);
            }
            case 3: {
                return new t(d4 - d2 * 0.5 - this.b - q2.a(), d5 - q2.b() * 0.5);
            }
            case 4: {
                return new t(d4 - q2.a() * 0.5, d5 - q2.b() * 0.5);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Invalid position: ").append(by2).toString());
    }

    static boolean a(Object object) {
        return object instanceof fN;
    }

    public static byte b(Object object) {
        return fM.c((Object)object).b;
    }

    public static eU a(eR eR2) {
        if (!fM.a(eR2.getModelParameter())) return null;
        fj fj2 = eR2.g();
        if (fj2 == null) return null;
        return fM.a(fj2, eR2.getModelParameter());
    }

    public static eU a(fj fj2, Object object) {
        return fj2.b(fM.c((Object)object).a);
    }

    public static Collection a(eU eU2) {
        ArrayList<eR> arrayList = new ArrayList<eR>(1);
        fj fj2 = eU2.b();
        if (fj2 == null) return arrayList;
        if (fj2.labelCount() <= 0) return arrayList;
        Object object = fj2.c(eU2);
        int n2 = 0;
        int n3 = fj2.labelCount();
        while (n2 < n3) {
            eR eR2 = fj2.getLabel(n2);
            if (fM.a(eR2.getModelParameter()) && object == fM.c((Object)eR2.getModelParameter()).a) {
                arrayList.add(eR2);
            }
            ++n2;
        }
        return arrayList;
    }

    static boolean a(n n2) {
        if (Double.isNaN(n2.b())) return true;
        if (Double.isNaN(n2.c())) return true;
        if (Double.isNaN(n2.e())) return true;
        if (Double.isNaN(n2.f())) return true;
        if (Double.isNaN(n2.g())) return true;
        if (Double.isNaN(n2.i())) return true;
        return false;
    }

    static fN c(Object object) {
        try {
            return (fN)object;
        }
        catch (ClassCastException var1_1) {
            throw new IllegalArgumentException("Invalid model parameter type.");
        }
    }
}

