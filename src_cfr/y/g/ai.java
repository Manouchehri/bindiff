/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.util.Comparator;
import java.util.Iterator;
import y.c.i;
import y.g.aj;
import y.g.ak;
import y.g.ar;
import y.g.e;
import y.g.p;

public class ai {
    private final aj a;
    private final aj b;
    private aj c;
    private aj d;
    private int e;
    private Comparator f;
    private int g;
    private ar h = new ar(42);

    public ai(Comparator comparator) {
        this.a = this.c = new aj();
        this.a.a = this.b = (this.d = new aj());
        this.b.b = this.a;
        this.f = comparator;
        this.g = 0;
        this.e = 1;
    }

    public ai() {
        this(e.a());
    }

    /*
     * Unable to fully structure code
     */
    public aj a(Object var1_1) {
        var10_2 = p.c;
        var2_3 = this.e();
        var3_4 = this.c;
        while (this.a(var1_1, var3_4.a) > 0) {
            var3_4 = var3_4.a;
            if (!var10_2) continue;
        }
        var4_5 = this.e;
        var5_6 = null;
        var6_7 = null;
        while (this.e < var2_3) {
            var7_8 = new aj();
            var7_8.e = var1_1;
            var8_9 = new aj();
            var9_10 = new aj();
            var8_9.d = this.c;
            this.c.c = var8_9;
            this.c = var8_9;
            var9_10.d = this.d;
            this.d.c = var9_10;
            this.d = var9_10;
            var8_9.a = var9_10.b = var7_8;
            var7_8.b = var8_9;
            var7_8.a = var9_10;
            v0 = var6_7;
            if (!var10_2) {
                block15 : {
                    if (v0 != null) {
                        var7_8.d = var6_7;
                        var6_7.c = var7_8;
                        if (!var10_2) break block15;
                    }
                    var5_6 = var7_8;
                }
                var6_7 = var7_8;
                ++this.e;
                if (!var10_2) continue;
            }
            ** GOTO lbl56
        }
        while (var4_5 > var2_3) {
            var3_4 = var3_4.d;
            --var4_5;
            while (this.a(var1_1, var3_4.a) > 0) {
                v1 = var3_4.a;
                if (!var10_2) {
                    var3_4 = v1;
                    if (!var10_2 && !var10_2) continue;
                }
                ** GOTO lbl48
            }
        }
        block4 : do {
            v1 = new aj();
lbl48: // 2 sources:
            var7_8 = v1;
            var7_8.e = var1_1;
            var7_8.b = var3_4;
            var7_8.a = var3_4.a;
            var3_4.a.b = var7_8;
            var3_4.a = var7_8;
            block5 : do {
                v0 = var5_6;
lbl56: // 2 sources:
                if (v0 != null) {
                    var7_8.c = var5_6;
                    var5_6.d = var7_8;
                }
                var5_6 = var7_8;
                var3_4 = var3_4.d;
                block6 : do {
                    if (var3_4 == null) {
                        ++this.g;
                        if (i.g == false) return var7_8;
                        if (var10_2) {
                            v2 = false;
                            break block4;
                        }
                        v2 = true;
                        break block4;
                    }
                    do {
                        if (this.a(var1_1, var3_4.a) <= 0) continue block4;
                        var3_4 = var3_4.a;
                        if (var10_2) continue block6;
                        if (var10_2) continue block5;
                    } while (true);
                    break;
                } while (true);
                break;
            } while (true);
            break;
        } while (true);
        p.c = v2;
        return var7_8;
    }

    private int e() {
        int n2 = 1;
        if (!this.h.nextBoolean()) return ++n2;
        if (!this.h.nextBoolean()) return ++n2;
        ++n2;
        if (!this.h.nextBoolean()) return ++n2;
        ++n2;
        if (!this.h.nextBoolean()) return ++n2;
        ++n2;
        if (!this.h.nextBoolean()) return ++n2;
        ++n2;
        if (!this.h.nextBoolean()) return ++n2;
        ++n2;
        if (!this.h.nextBoolean()) return ++n2;
        ++n2;
        if (!this.h.nextBoolean()) return ++n2;
        ++n2;
        if (!this.h.nextBoolean()) return ++n2;
        ++n2;
        if (!this.h.nextBoolean()) return ++n2;
        ++n2;
        if (!this.h.nextBoolean()) return ++n2;
        ++n2;
        return ++n2;
    }

    public void a(aj aj2, aj aj3) {
        boolean bl2;
        block8 : {
            bl2 = p.c;
            if (aj2 == aj3) {
                this.a(aj2);
                if (!bl2) return;
            }
            aj aj4 = aj2.b;
            aj aj5 = aj3.a();
            int n2 = 0;
            while (n2 < this.e) {
                block10 : {
                    aj4.a = aj5;
                    aj5.b = aj4;
                    if (bl2) break block8;
                    if (n2 != this.e - 1) {
                        block9 : {
                            while (aj4.c == null) {
                                aj4 = aj4.b;
                                if (!bl2) {
                                    if (!bl2) continue;
                                }
                                break block9;
                            }
                            aj4 = aj4.c;
                        }
                        while (aj5.c == null) {
                            aj5 = aj5.a;
                            if (!bl2) {
                                if (!bl2) continue;
                            }
                            break block10;
                        }
                        aj5 = aj5.c;
                    }
                    ++n2;
                }
                if (!bl2) continue;
            }
            this.f();
        }
        while (aj2 != aj3) {
            aj2 = aj2.a;
            --this.g;
            if (bl2) return;
            if (!bl2) continue;
        }
        --this.g;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public aj a(aj aj2, Object object) {
        if (aj2 != null) {
            return this.a(object, aj2, aj2.a);
        }
        if (this.g != 0) return this.b(this.b(), object);
        return this.a(object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public aj b(aj aj2, Object object) {
        if (aj2 != null) {
            return this.a(object, aj2.b, aj2);
        }
        if (this.g != 0) return this.a(this.c(), object);
        return this.a(object);
    }

    /*
     * Exception decompiling
     */
    private aj a(Object var1_1, aj var2_2, aj var3_3) {
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

    public int a() {
        return this.g;
    }

    public void a(aj aj2) {
        boolean bl2 = p.c;
        do {
            aj aj3 = aj2.b;
            aj aj4 = aj2.a;
            aj aj5 = aj2.c;
            aj2.c = null;
            aj2.d = null;
            aj2.a = null;
            aj2.b = null;
            aj3.a = aj4;
            aj4.b = aj3;
            if (aj5 == null) break;
            aj2 = aj5;
        } while (!bl2);
        this.f();
        --this.g;
    }

    private void f() {
        boolean bl2 = p.c;
        do {
            if (this.e <= 1) return;
            if (this.c.a != this.d) return;
            this.d = this.d.d;
            this.c = this.c.d;
            this.c.c = null;
            this.d.c = null;
            --this.e;
        } while (!bl2);
    }

    public aj b(aj aj2) {
        aj aj3 = aj2.a;
        if (aj3.a != null) return aj3;
        return null;
    }

    public aj c(aj aj2) {
        aj aj3 = aj2.b;
        if (aj3.b != null) return aj3;
        return null;
    }

    public aj b() {
        return this.b(this.a);
    }

    public aj c() {
        return this.c(this.b);
    }

    public Iterator d() {
        return new ak(this, this.a);
    }

    public aj b(Object object) {
        boolean bl2 = p.c;
        aj aj2 = this.c;
        do {
            if (this.a(object, aj2.a) > 0) {
                aj2 = aj2.a;
                if (bl2 || !bl2) continue;
            }
            if (aj2.d == null) {
                if (aj2.a == null) return null;
                if (aj2.b == null) return null;
                aj aj3 = aj2;
                return aj3;
            }
            aj2 = aj2.d;
        } while (true);
    }

    public aj c(Object object) {
        boolean bl2 = p.c;
        aj aj2 = this.d;
        do {
            if (this.a(object, aj2.b) < 0) {
                aj2 = aj2.b;
                if (bl2 || !bl2) continue;
            }
            if (aj2.d == null) {
                if (aj2.a == null) return null;
                if (aj2.b == null) return null;
                aj aj3 = aj2;
                return aj3;
            }
            aj2 = aj2.d;
        } while (true);
    }

    private int a(Object object, aj aj2) {
        if (aj2.b == null) {
            return 1;
        }
        if (aj2.a != null) return this.f.compare(object, aj2.e);
        return -1;
    }

    public String toString() {
        boolean bl2 = p.c;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SkipList{ size: ");
        stringBuffer.append(this.a());
        stringBuffer.append("; ");
        Iterator iterator = this.d();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            stringBuffer.append(e2).append(", ");
            if (bl2) return stringBuffer.toString();
            if (!bl2) continue;
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}

