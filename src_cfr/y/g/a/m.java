/*
 * Decompiled with CFR 0_115.
 */
package y.g.a;

import java.util.Comparator;
import y.g.a.d;
import y.g.a.l;
import y.g.a.r;

class m
extends r {
    public m(Comparator comparator) {
        super(comparator);
    }

    /*
     * Unable to fully structure code
     */
    public void a(Object var1_1) {
        block5 : {
            var4_2 = d.a;
            var2_3 = null;
            var3_4 = this.a;
            if (var3_4 != null) ** GOTO lbl7
            this.a = new l(var1_1);
            ** GOTO lbl37
lbl7: // 3 sources:
            while (var3_4 != null) {
                var2_3 = var3_4;
                v0 = this.a(var1_1, var3_4.d);
                if (!var4_2) {
                    if (v0 < 0) {
                        var3_4 = var3_4.b;
                        if (!var4_2) continue;
                    }
                    if (this.a(var1_1, var3_4.d) > 0) {
                        var3_4 = var3_4.c;
                        if (!var4_2) continue;
                    }
                    var3_4.d = var1_1;
                    return;
                }
                break block5;
            }
            var3_4 = new l(var1_1);
            v0 = this.a(var1_1, var2_3.d);
        }
        if (v0 >= 0) ** GOTO lbl31
        var2_3.a(var3_4);
        if (var2_3.e != 1) ** GOTO lbl28
        var2_3.e = 0;
        if (!var4_2) ** GOTO lbl37
lbl28: // 2 sources:
        var2_3.e = -1;
        this.a(var2_3);
        if (!var4_2) ** GOTO lbl37
lbl31: // 2 sources:
        var2_3.b(var3_4);
        if (var2_3.e != -1) ** GOTO lbl-1000
        var2_3.e = 0;
        if (var4_2) lbl-1000: // 2 sources:
        {
            var2_3.e = 1;
            this.a(var2_3);
        }
lbl37: // 6 sources:
        ++this.b;
    }

    void a(l l2) {
        byte by2;
        boolean bl2 = d.a;
        if (l2.a == null) {
            return;
        }
        l l3 = l2.a;
        if (l3.b == l2) {
            block0 : switch (l3.e) {
                case 1: {
                    l3.e = 0;
                    if (!bl2) break;
                }
                case 0: {
                    l3.e = -1;
                    this.a(l3);
                    if (!bl2) break;
                }
                case -1: {
                    switch (l2.e) {
                        case -1: {
                            this.e(l3);
                            l3.e = 0;
                            l3.c.e = 0;
                            if (!bl2) break block0;
                        }
                        case 1: {
                            by2 = l3.b.c.e;
                            this.g(l3);
                            l3.e = 0;
                            switch (by2) {
                                case 0: {
                                    l3.b.e = 0;
                                    l3.c.e = 0;
                                    if (!bl2) break block0;
                                }
                                case 1: {
                                    l3.b.e = -1;
                                    l3.c.e = 0;
                                    if (!bl2) break block0;
                                }
                                case -1: {
                                    l3.b.e = 0;
                                    l3.c.e = 1;
                                }
                            }
                        }
                    }
                }
            }
            if (!bl2) return;
        }
        if (l3.c != l2) return;
        switch (l3.e) {
            case -1: {
                l3.e = 0;
                if (!bl2) return;
            }
            case 0: {
                l3.e = 1;
                this.a(l3);
                if (!bl2) return;
            }
            case 1: {
                switch (l2.e) {
                    case 1: {
                        this.d(l3);
                        l3.e = 0;
                        l3.b.e = 0;
                        if (!bl2) return;
                    }
                    case -1: {
                        by2 = l3.c.b.e;
                        this.f(l3);
                        l3.e = 0;
                        switch (by2) {
                            case 0: {
                                l3.c.e = 0;
                                l3.b.e = 0;
                                if (!bl2) return;
                            }
                            case -1: {
                                l3.c.e = 1;
                                l3.b.e = 0;
                                if (!bl2) return;
                            }
                            case 1: {
                                l3.c.e = 0;
                                l3.b.e = -1;
                            }
                        }
                    }
                }
            }
        }
    }

    public void b(Object object) {
        l l2 = this.d(object);
        if (l2 != null) {
            this.b(l2);
        }
        --this.b;
    }

    void b(l l2) {
        boolean bl2 = d.a;
        l l3 = l2.a;
        if (l2.b == null && l2.c == null) {
            if (l3 == null) {
                this.a = null;
                if (!bl2) return;
            }
            this.c(l2);
            if (l2.a.b == l2) {
                l2.a.b = null;
                if (!bl2) return;
            }
            l2.a.c = null;
            if (!bl2) return;
        }
        if (l2.b == null || l2.c == null) {
            block6 : {
                if (l2.b != null) {
                    l2.d = l2.b.d;
                    if (!bl2) break block6;
                }
                l2.d = l2.c.d;
            }
            l2.c = null;
            l2.b = null;
            l2.e = 0;
            this.c(l2);
            if (!bl2) return;
        }
        l l4 = this.h(l2.c);
        m.a(l2, l4);
        this.b(l4);
    }

    void c(l l2) {
        byte by2;
        boolean bl2 = d.a;
        if (l2.a == null) {
            return;
        }
        l l3 = l2.a;
        if (l3.b == l2) {
            block0 : switch (l3.e) {
                case -1: {
                    l3.e = 0;
                    this.c(l3);
                    if (!bl2) break;
                }
                case 0: {
                    l3.e = 1;
                    if (!bl2) break;
                }
                case 1: {
                    switch (l3.c.e) {
                        case 0: {
                            this.d(l3);
                            l3.e = -1;
                            l3.b.e = 1;
                            if (!bl2) break block0;
                        }
                        case -1: {
                            by2 = l3.c.b.e;
                            this.f(l3);
                            l3.e = 0;
                            switch (by2) {
                                case -1: {
                                    l3.b.e = 0;
                                    l3.c.e = 1;
                                    if (!bl2) break;
                                }
                                case 0: {
                                    l3.c.e = 0;
                                    if (!bl2) break;
                                }
                                case 1: {
                                    l3.b.e = -1;
                                    l3.c.e = 0;
                                }
                            }
                            this.c(l3);
                            if (!bl2) break block0;
                        }
                        case 1: {
                            this.d(l3);
                            l3.e = 0;
                            l3.b.e = 0;
                            this.c(l3);
                        }
                    }
                }
            }
            if (!bl2) return;
        }
        if (l3.c != l2) return;
        switch (l3.e) {
            case 1: {
                l3.e = 0;
                this.c(l3);
                if (!bl2) return;
            }
            case 0: {
                l3.e = -1;
                if (!bl2) return;
            }
            case -1: {
                switch (l3.b.e) {
                    case 0: {
                        this.e(l3);
                        l3.e = 1;
                        l3.c.e = -1;
                        if (!bl2) return;
                    }
                    case 1: {
                        by2 = l3.b.c.e;
                        this.g(l3);
                        l3.e = 0;
                        switch (by2) {
                            case 1: {
                                l3.c.e = 0;
                                l3.b.e = -1;
                                if (!bl2) break;
                            }
                            case 0: {
                                l3.b.e = 0;
                                if (!bl2) break;
                            }
                            case -1: {
                                l3.c.e = 1;
                                l3.b.e = 0;
                            }
                        }
                        this.c(l3);
                        if (!bl2) return;
                    }
                    case -1: {
                        this.e(l3);
                        l3.e = 0;
                        l3.c.e = 0;
                        this.c(l3);
                    }
                }
            }
        }
    }

    void d(l l2) {
        l l3 = l2.c;
        l2.b(l3.c);
        l3.b(l3.b);
        l3.a(l2.b);
        l2.a(l3);
        m.a(l2, l3);
    }

    void e(l l2) {
        l l3 = l2.b;
        l2.a(l3.b);
        l3.a(l3.c);
        l3.b(l2.c);
        l2.b(l3);
        m.a(l2, l3);
    }

    void f(l l2) {
        l l3 = l2.c;
        l l4 = l3.b;
        l3.a(l4.c);
        l4.b(l4.b);
        l4.a(l2.b);
        l2.a(l4);
        m.a(l2, l4);
    }

    void g(l l2) {
        l l3 = l2.b;
        l l4 = l3.c;
        l3.b(l4.b);
        l4.a(l4.c);
        l4.b(l2.c);
        l2.b(l4);
        m.a(l2, l4);
    }
}

