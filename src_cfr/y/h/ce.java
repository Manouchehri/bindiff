/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.AbstractAction;
import y.c.d;
import y.c.e;
import y.c.q;
import y.h.a.a;
import y.h.a.v;
import y.h.aA;
import y.h.aB;
import y.h.b.c;
import y.h.b.f;
import y.h.b.i;
import y.h.bu;
import y.h.ch;
import y.h.cm;
import y.h.cp;
import y.h.eR;
import y.h.eU;
import y.h.fj;
import y.h.x;
import y.h.y;

public class cE
extends AbstractAction {
    private final ch a;
    private int b;
    private boolean c;
    private boolean d;
    private Map e;
    private Map f;
    private Map g;
    private Set h;
    private boolean i;

    public cE() {
        this(null);
    }

    public cE(ch ch2) {
        super(cm.u.toString());
        this.a = ch2;
        this.b = 639;
    }

    public int a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    public boolean c() {
        return this.i;
    }

    protected boolean a(d d2, aA aA2) {
        if ((this.a() & 4) != 4) return false;
        if (!aA2.isSelected()) return false;
        return true;
    }

    protected boolean a(d d2, x x2) {
        if ((this.a() & 1) != 1) return false;
        if (!x2.d()) return false;
        return true;
    }

    protected boolean a(bu bu2, d d2) {
        if ((this.a() & 2) == 2) {
            if (bu2.r(d2)) return true;
        }
        if (this.a(bu2, d2, true)) return true;
        if (this.a(bu2, d2, false)) return true;
        return false;
    }

    private boolean a(bu bu2, d d2, boolean bl2) {
        eU eU2 = eU.a(bu2, d2, bl2);
        if (eU2 == null) return false;
        if (!this.a(bl2 ? d2.c() : d2.d(), eU2)) return false;
        return true;
    }

    protected boolean a(q q2, eR eR2) {
        if ((this.a() & 64) != 64) return false;
        if (eR2.isSelected()) return true;
        if (this.e.containsKey(eR2)) {
            if (this.a(q2, (c)this.e.get(eR2))) return true;
        }
        if (this.f.containsKey(eR2)) {
            if (this.a(q2, (f)this.f.get(eR2))) return true;
        }
        if (!this.g.containsKey(eR2)) return false;
        if (!this.a(q2, (eU)this.g.get(eR2))) return false;
        return true;
    }

    protected boolean a(q q2, c c2) {
        boolean bl2 = (this.a() & 128) == 128 && c2.e();
        this.d |= bl2;
        return bl2;
    }

    protected boolean a(q q2, f f2) {
        boolean bl2 = (this.a() & 256) == 256 && f2.e();
        this.d |= bl2;
        return bl2;
    }

    protected boolean a(bu bu2, q q2) {
        int n2 = this.a();
        if (!bu2.v(q2)) return false;
        if (cm.a(bu2, q2) instanceof y.h.b.a) {
            if ((n2 & 32) != 32) return false;
            if (!this.b()) return true;
            if (this.d) return false;
            return true;
        }
        v v2 = v.a(bu2);
        if (v2 != null && v2.k(q2)) {
            if ((n2 & 16) != 16) return false;
            return true;
        }
        if ((n2 & 8) != 8) return false;
        return true;
    }

    protected boolean a(q q2, eU eU2) {
        if ((this.a() & 512) != 512) return false;
        if (!eU2.f()) return false;
        return true;
    }

    protected void b(bu bu2, q q2) {
        this.e(bu2, q2);
        this.d(bu2, q2);
        this.f(bu2, q2);
    }

    /*
     * Unable to fully structure code
     */
    private void d(bu var1_1, q var2_2) {
        block26 : {
            block25 : {
                block24 : {
                    block23 : {
                        var10_3 = fj.z;
                        var3_4 = null;
                        var4_5 = cm.a(var1_1, var2_2);
                        var5_6 = this.a(var4_5, var2_2);
                        var6_7 = this.a(var1_1, var2_2);
                        if ((var5_6 || var6_7) && this.c() && var1_1.C() != null && (var7_8 = var1_1.C().n(var2_2)) != null) {
                            if (this.h.add(var7_8)) {
                                var1_1.a(new y.c.y((q)var7_8).a());
                            }
                            if ((var8_10 = var1_1.t((q)var7_8).getAutoBoundsFeature()) != null && var8_10.isAutoBoundsEnabled()) {
                                var8_10.setAutoBoundsEnabled(false);
                                var3_4 = var8_10;
                            }
                        }
                        if (var5_6) {
                            if (this.h.add(var2_2)) {
                                var1_1.a(new y.c.y(var2_2).a());
                            }
                            if (var2_2.a() > 0) {
                                var1_1.a(var2_2.j());
                            }
                        }
                        if (!(var4_5 instanceof y.h.b.a)) ** GOTO lbl56
                        var7_8 = ((y.h.b.a)var4_5).l();
                        var8_11 = var7_8.k();
                        while (var8_11-- > 1) {
                            this.b(var2_2, var7_8.b(var8_11));
                            if (!var10_3) {
                                if (!var10_3) continue;
                            }
                            ** GOTO lbl-1000
                        }
                        if (var7_8.k() <= 1) ** GOTO lbl-1000
                        this.b(var2_2, var7_8.b(0));
                        if (var10_3) lbl-1000: // 3 sources:
                        {
                            var8_12 = var7_8.b(0);
                            var9_14 = var8_12.k();
                            while (var9_14-- > 0) {
                                this.b(var2_2, var8_12.b(var9_14));
                                if (!var10_3) {
                                    if (!var10_3) continue;
                                }
                                break block23;
                            }
                            if (this.a(var2_2, var8_12) && var8_12.k() > 0) {
                                this.c(var2_2, var8_12);
                            }
                        }
                    }
                    var8_10 = var7_8.n();
                    while (var8_10-- > true) {
                        this.b(var2_2, var7_8.c((int)var8_10));
                        if (!var10_3) {
                            if (!var10_3) continue;
                        }
                        ** GOTO lbl-1000
                    }
                    if (var7_8.n() <= 1) ** GOTO lbl-1000
                    this.b(var2_2, var7_8.c(0));
                    if (var10_3) lbl-1000: // 3 sources:
                    {
                        var8_13 = var7_8.c(0);
                        var9_14 = var8_13.n();
                        while (var9_14-- > 0) {
                            this.b(var2_2, var8_13.c(var9_14));
                            if (!var10_3) {
                                if (!var10_3) continue;
                            }
                            break block24;
                        }
                        if (this.a(var2_2, var8_13) && var8_13.n() > 0) {
                            this.c(var2_2, var8_13);
                        }
                    }
                }
                var7_9 = var4_5.portCount();
                while (var7_9-- > 0) {
                    var8_10 = var4_5.getPort(var7_9);
                    if (!this.a(var2_2, (eU)var8_10)) continue;
                    this.a(var4_5, (eU)var8_10, var7_9);
                    if (!var10_3) {
                        if (!var10_3) continue;
                    }
                    break block25;
                }
                var7_9 = var4_5.labelCount();
            }
            while (var7_9-- > 0) {
                var8_10 = var4_5.getLabel(var7_9);
                if (!this.a(var2_2, (eR)var8_10)) continue;
                this.a(var4_5, (eR)var8_10, var7_9);
                if (!var10_3) {
                    if (!var10_3) continue;
                }
                break block26;
            }
            if (var6_7) {
                this.c(var1_1, var2_2);
            }
        }
        if (var3_4 == null) return;
        var3_4.setAutoBoundsEnabled(true);
    }

    /*
     * Exception decompiling
     */
    private void e(bu var1_1, q var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.markFirstStatementInBlock(Op03SimpleStatement.java:420)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.markWholeBlock(Misc.java:219)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.considerAsSimpleIf(ConditionalRewriter.java:619)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.identifyNonjumpingConditionals(ConditionalRewriter.java:45)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:681)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    private void f(bu bu2, q q2) {
        this.g = null;
        this.f = null;
        this.e = null;
        this.d = false;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ch ch2 = this.a(actionEvent);
        if (ch2 == null) return;
        this.a(ch2);
        ch2.getGraph2D().T();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public void a(ch var1_1) {
        var7_2 = fj.z;
        var2_3 = var1_1.getGraph2D();
        var2_3.r();
        try {
            block7 : {
                var3_4 = var2_3.p();
                while (var3_4.f()) {
                    this.b(var2_3, var3_4.a());
                    var3_4.g();
                    if (!var7_2) {
                        if (!var7_2) continue;
                    }
                    break block7;
                }
                this.h = new HashSet<E>();
            }
            if ((var3_4 = var2_3.C()) != null) ** GOTO lbl21
            var4_5 = var2_3.o();
            while (var4_5.f()) {
                this.b(var2_3, var4_5.e());
                var4_5.g();
                if (var7_2 != false) return;
                if (!var7_2) continue;
lbl21: // 2 sources:
                var4_5 = new ArrayList<E>(var2_3.f());
                var3_4.a(var3_4.e(var2_3), new cp(this, (ArrayList)var4_5));
                var5_6 = var4_5.iterator();
                while (var5_6.hasNext()) {
                    this.b(var2_3, (q)var5_6.next());
                    if (var7_2 != false) return;
                    if (!var7_2) continue;
                }
                break block4;
            }
            this.h = null;
            return;
        }
        finally {
            var2_3.s();
        }
    }

    protected void b(bu bu2, d d2) {
        boolean bl2;
        int n2;
        aB aB2;
        block5 : {
            int n3;
            bl2 = fj.z;
            aB2 = bu2.i(d2);
            if (this.a(aB2, d2)) {
                bu2.a(new y.c.f(d2).a());
                aB2 = bu2.i(d2);
            }
            y y2 = aB2.bends();
            while (y2.f()) {
                n3 = (int)this.a(d2, y2.a()) ? 1 : 0;
                if (!bl2) {
                    if (n3 != 0) {
                        this.a(aB2, y2.a());
                    }
                    y2.g();
                    if (!bl2) continue;
                }
                break block5;
            }
            n3 = n2 = aB2.labelCount();
        }
        while (n2-- > 0) {
            aA aA2 = aB2.getLabel(n2);
            if (!this.a(d2, aA2)) continue;
            this.a(aB2, aA2, n2);
            if (bl2) return;
            if (!bl2) continue;
        }
        if (!this.a(bu2, d2)) return;
        this.c(bu2, d2);
    }

    protected ch a(ActionEvent actionEvent) {
        return cm.a(actionEvent, this.a);
    }

    boolean a(aB aB2, d d2) {
        boolean bl2;
        int n2;
        block5 : {
            bl2 = fj.z;
            y y2 = aB2.bends();
            while (y2.f()) {
                n2 = (int)this.a(d2, y2.a()) ? 1 : 0;
                if (!bl2) {
                    if (n2 != 0) {
                        return true;
                    }
                    y2.g();
                    if (!bl2) continue;
                }
                break block5;
            }
            n2 = aB2.labelCount();
        }
        if (n2 <= 0) return false;
        int n3 = 0;
        do {
            if (n3 >= aB2.labelCount()) return false;
            boolean bl3 = this.a(d2, aB2.getLabel(n3));
            if (bl2) return bl3;
            if (bl3) {
                return true;
            }
            ++n3;
        } while (!bl2);
        return false;
    }

    boolean a(fj fj2, q q2) {
        boolean bl2;
        boolean bl3;
        Object object;
        int n2;
        block14 : {
            bl3 = fj.z;
            if (fj2 instanceof y.h.b.a) {
                Object object2;
                ArrayList arrayList;
                block13 : {
                    boolean bl4;
                    object = ((y.h.b.a)fj2).l();
                    arrayList = new ArrayList();
                    arrayList.addAll(object.l());
                    while (!arrayList.isEmpty()) {
                        object2 = (c)arrayList.remove(arrayList.size() - 1);
                        bl4 = this.a(q2, (c)object2);
                        if (!bl3) {
                            if (bl4) {
                                return true;
                            }
                            arrayList.addAll(object2.l());
                            if (!bl3) continue;
                        }
                        break block13;
                    }
                    arrayList.clear();
                    bl4 = arrayList.addAll(object.o());
                }
                while (!arrayList.isEmpty()) {
                    object2 = (f)arrayList.remove(arrayList.size() - 1);
                    n2 = (int)this.a(q2, (f)object2) ? 1 : 0;
                    if (!bl3) {
                        if (n2 != 0) {
                            return true;
                        }
                        arrayList.addAll(object2.o());
                        if (!bl3) continue;
                    }
                    break block14;
                }
            }
            n2 = fj2.portCount();
        }
        if (n2 > 0) {
            object = fj2.ports();
            while (object.hasNext()) {
                if (!this.a(q2, (eU)object.next())) continue;
                bl2 = true;
                if (!bl3) {
                    return bl2;
                }
                break;
            }
        } else {
            bl2 = fj2.labelCount();
        }
        if (bl2 <= false) return false;
        int n3 = 0;
        do {
            if (n3 >= fj2.labelCount()) return false;
            boolean bl5 = this.a(q2, fj2.getLabel(n3));
            if (bl3) return bl5;
            if (bl5) {
                return true;
            }
            ++n3;
        } while (!bl3);
        return false;
    }

    boolean b(q q2, c c2) {
        boolean bl2 = fj.z;
        boolean bl3 = false;
        int n2 = c2.k();
        while (n2-- > 0) {
            bl3 |= this.b(q2, c2.b(n2));
            if (bl2) return bl3;
            if (!bl2) continue;
        }
        if (!this.a(q2, c2)) return bl3;
        this.c(q2, c2);
        return true;
    }

    boolean b(q q2, f f2) {
        boolean bl2 = fj.z;
        boolean bl3 = false;
        int n2 = f2.n();
        while (n2-- > 0) {
            bl3 |= this.b(q2, f2.c(n2));
            if (bl2) return bl3;
            if (!bl2) continue;
        }
        if (!this.a(q2, f2)) return bl3;
        this.c(q2, f2);
        return true;
    }

    protected void c(bu bu2, d d2) {
        bu2.a(d2);
    }

    protected void a(aB aB2, aA aA2, int n2) {
        aB2.removeLabel(aA2);
    }

    protected void a(aB aB2, x x2) {
        aB2.removeBend(x2);
    }

    protected void c(bu bu2, q q2) {
        bu2.a(q2);
    }

    protected void a(fj fj2, eR eR2, int n2) {
        fj2.removeLabel(eR2);
    }

    protected void a(fj fj2, eU eU2, int n2) {
        fj2.removePort(n2);
    }

    protected void c(q q2, c c2) {
        c2.c();
    }

    protected void c(q q2, f f2) {
        f2.c();
    }
}

