/*
 * Decompiled with CFR 0_115.
 */
package y.d.a;

import java.util.ArrayList;
import y.c.D;
import y.c.p;
import y.d.a.b;
import y.d.a.c;
import y.d.a.d;
import y.d.a.e;

class h {
    private D a;
    private d b;
    private final b c;

    private h(b b2) {
        this.c = b2;
        this.a = new D();
        this.b = new d(this.c);
    }

    /*
     * Unable to fully structure code
     */
    void a(Object var1_1, ArrayList var2_2, e[] var3_3) {
        var10_4 = b.b;
        var2_2.clear();
        var4_5 = this.a.k();
        var5_6 = null;
        var6_7 = null;
        var7_8 = false;
        while (var4_5 != null) {
            var8_9 = (e)this.a.g(var4_5);
            var9_10 = b.a(this.c).a(var8_9.g, var1_1);
            if (var10_4 != 0) return;
            if (var9_10 > 0) {
                var5_6 = var4_5;
            }
            if (var9_10 != 0) ** GOTO lbl20
            if (var7_8) {
                throw new RuntimeException("YStruct not correct on get !");
            }
            block1 : do {
                v0 = (int)var2_2.add(var8_9) ? 1 : 0;
                do {
                    if ((var8_9 = var8_9.h) != null) continue block1;
lbl20: // 2 sources:
                    v0 = var9_10;
                } while (var10_4 != 0);
                break;
            } while (true);
            if (v0 < 0) {
                if (!var7_8) {
                    var6_7 = var4_5;
                }
                var7_8 = true;
            }
            var4_5 = this.a.c(var4_5);
            if (var10_4 == 0) continue;
        }
        var3_3[0] = (e)this.a.g(var5_6);
        var3_3[1] = (e)this.a.g(var6_7);
    }

    void a(Object object, e e2) {
        Object object2;
        int n2 = b.b;
        p p2 = this.a.k();
        this.b.a(object);
        int n3 = -1;
        while (p2 != null && n3 < 0) {
            object2 = (e)this.a.g(p2);
            n3 = this.b.compare(e2, object2);
            if (n3 == 0) {
                block4 : {
                    Object object3 = null;
                    while (object2.b() < e2.b()) {
                        object3 = object2;
                        object2 = object2.h;
                        if (object2 != null) continue;
                        if (object3 == null) break;
                        e2.a(object3.h);
                        object3.a(e2);
                        if (n2 == 0) break block4;
                    }
                    object2 = (e)this.a.g(p2);
                    e2.a((e)object2);
                    this.a.a(p2, e2);
                }
                e2.a(p2);
                return;
            }
            if (n3 > 0) {
                p p3 = this.a.a(e2, p2);
                e2.a(p3);
                return;
            }
            p2 = this.a.c(p2);
            if (n2 == 0) continue;
        }
        object2 = this.a.b(e2, null);
        e2.a((p)object2);
    }

    void a(e e2) {
        int n2 = b.b;
        e e3 = (e)this.a.g(e2.b);
        if (e3 == e2) {
            if (e2.h == null) {
                this.a.h(e3.b);
                if (n2 == 0) return;
            }
            this.a.a(e2.b, e2.h);
            if (n2 == 0) return;
        }
        while (e3.h != e2) {
            e3 = e3.h;
            if (n2 != 0) return;
            if (n2 == 0) continue;
        }
        e3.h = e2.h;
    }

    /*
     * Unable to fully structure code
     */
    void a(Object var1_1) {
        block4 : {
            var7_2 = b.b;
            var2_3 = new ArrayList<e>();
            var3_4 = this.a.k();
            var4_5 = null;
            var5_6 = false;
            while (var3_4 != null) {
                var6_7 = (e)this.a.g(var3_4);
                v0 = this;
                if (var7_2 != 0) break block4;
                if (!b.a(v0.c).e(var6_7.g, var1_1)) ** GOTO lbl-1000
                if (var5_6) {
                    throw new RuntimeException("YStruct not correct on swap !");
                }
                var4_5 = var3_4;
                var2_3.add(var6_7);
                if (var7_2 != 0) lbl-1000: // 2 sources:
                {
                    if (var4_5 != null) {
                        var5_6 = true;
                    }
                }
                var3_4 = this.a.c(var3_4);
                if (var7_2 == 0) continue;
            }
            v0 = this;
        }
        v0.a(var2_3);
    }

    void a(ArrayList arrayList) {
        int n2 = b.b;
        if (arrayList.size() == 0) {
            return;
        }
        p p2 = this.a.k();
        Object e2 = arrayList.get(0);
        while (this.a.g(p2) != e2) {
            p2 = this.a.c(p2);
            if (n2 == 0) continue;
        }
        int n3 = arrayList.size() - 1;
        do {
            if (n3 < 0) return;
            if (!this.a.g(p2).equals(arrayList.get(arrayList.size() - 1 - n3))) {
                throw new RuntimeException("Cannot swap segments");
            }
            e e3 = (e)arrayList.get(n3);
            this.a.a(p2, e3);
            block2 : do {
                e3.a(p2);
                e3 = e3.h;
                do {
                    if (e3 != null) continue block2;
                    p2 = this.a.c(p2);
                    --n3;
                } while (n2 != 0);
                break;
            } while (true);
        } while (n2 == 0);
    }

    e b(e e2) {
        p p2 = this.a.c(e2.b);
        if (p2 != null) return (e)this.a.g(p2);
        return null;
    }

    e c(e e2) {
        p p2 = this.a.d(e2.b);
        if (p2 != null) return (e)this.a.g(p2);
        return null;
    }

    h(b b2, c c2) {
        this(b2);
    }
}

