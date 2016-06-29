/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.util.EventObject;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.JComponent;
import y.c.C;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.q;
import y.g.p;
import y.h.D;
import y.h.F;
import y.h.a.a;
import y.h.a.v;
import y.h.aA;
import y.h.aB;
import y.h.aD;
import y.h.aE;
import y.h.bu;
import y.h.cW;
import y.h.cZ;
import y.h.ch;
import y.h.dB;
import y.h.dH;
import y.h.dI;
import y.h.dP;
import y.h.dU;
import y.h.da;
import y.h.dx;
import y.h.dz;
import y.h.eC;
import y.h.eR;
import y.h.eU;
import y.h.fL;
import y.h.fj;
import y.h.fu;
import y.h.gU;
import y.h.gX;
import y.h.gZ;
import y.h.gf;
import y.h.gg;
import y.h.x;
import y.h.y;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class aC
extends gX {
    private cW te;
    private boolean af;
    private boolean df;
    private int zf;
    protected q pressedNode;
    static final int ye = -1;
    static final int ig = 0;
    static final int sf = 1;
    static final int ng = 2;
    static final int gf = 3;
    static final int dg = 4;
    static final int oe = 5;
    static final int if = 6;
    static final int kf = 7;
    static final int bg = 8;
    static final int qg = 9;
    static final int bf = 10;
    static final int pg = 11;
    static final int pf = 12;
    static final int jf = 13;
    static final int rf = 14;
    private double ve;
    private double ef;
    private Cursor cg = Cursor.getPredefinedCursor(0);
    protected gX popupMode;
    protected gX hotSpotMode;
    protected gX selectionBoxMode;
    protected gX createEdgeMode;
    protected gX moveSelectionMode;
    protected gX moveLabelMode;
    protected gX movePortMode;
    protected gX editNodeMode;
    protected gX moveViewPortMode;
    protected dz mouseInputMode;
    protected gX moveNodePortMode;
    boolean fg = true;
    boolean rg = true;
    boolean jg = true;
    boolean xe = true;
    boolean me = true;
    boolean ne = true;
    boolean qe = true;
    boolean re = false;
    boolean qf = true;
    boolean yf = true;
    boolean ag = true;
    boolean we = true;
    boolean ze;
    boolean vf;
    boolean lf;
    boolean cf;
    public static final Object ORTHOGONAL_ROUTING_DPKEY = "y.view.EditMode.ORTHOGONAL_ROUTING_DPKEY";
    private p eg;
    private boolean nf;
    private PropertyChangeListener og;
    private boolean sg = true;
    private boolean hf = true;
    private int pe = 10;
    private boolean uf = true;
    private boolean mg;
    private boolean wf = true;
    private boolean gg;
    private cW of;
    private int lg = 2;
    private static final int xf = 1;
    private static final int kg = 2;
    private static final int ff = 4;
    private static final int mf = 8;
    private static final int se = 16;
    private static final int ue = 32;
    private static final int hg = 64;
    private gX tf;

    public aC(gU gU2) {
        super(gU2);
        this.setName("EDIT_MODE");
        this.q();
    }

    public aC() {
        this.setName("EDIT_MODE");
        this.q();
    }

    private void q() {
        this.hotSpotMode = this.createHotSpotMode();
        this.selectionBoxMode = this.createSelectionBoxMode();
        this.createEdgeMode = this.createCreateEdgeMode();
        this.moveSelectionMode = this.createMoveSelectionMode();
        this.moveLabelMode = this.createMoveLabelMode();
        this.movePortMode = this.createMovePortMode();
        this.popupMode = this.createPopupMode();
        this.editNodeMode = this.createEditNodeMode();
        this.moveViewPortMode = this.createMoveViewPortMode();
        this.mouseInputMode = this.createMouseInputMode();
        this.moveNodePortMode = this.createMoveNodePortMode();
    }

    public boolean isAdjustScrollBarPolicy() {
        return this.hf;
    }

    public void setAdjustScrollBarPolicy(boolean bl2) {
        this.hf = bl2;
    }

    public void setSnappingEnabled(boolean bl2) {
        if (this.getHotSpotMode() instanceof da) {
            ((da)this.getHotSpotMode()).a(bl2);
        }
        if (this.getMoveSelectionMode() instanceof dP) {
            dP dP2 = (dP)this.getMoveSelectionMode();
            dP2.a(bl2);
            dP2.c().f(bl2);
            dP2.c().c(bl2);
        }
        if (this.getOrthogonalMoveBendsMode() instanceof fu) {
            fu fu2 = (fu)this.getOrthogonalMoveBendsMode();
            fu2.a(bl2);
            fu2.c().a(bl2);
        }
        if (this.getCreateEdgeMode() instanceof F) {
            F f2 = (F)this.getCreateEdgeMode();
            f2.a(bl2 ? 5.0 : 0.0);
            f2.a(bl2);
        }
        if (!(this.getMovePortMode() instanceof dI)) return;
        dI dI2 = (dI)this.getMovePortMode();
        dI2.a(bl2);
    }

    protected gX createHotSpotMode() {
        return new da();
    }

    protected dz createMouseInputMode() {
        return new dz();
    }

    protected gX createMovePortMode() {
        return new dI();
    }

    protected gX createMoveViewPortMode() {
        return new eC();
    }

    protected gX createMoveLabelMode() {
        return new dB();
    }

    protected gX createMoveSelectionMode() {
        return new dP();
    }

    protected gX createCreateEdgeMode() {
        return new F();
    }

    protected gX createSelectionBoxMode() {
        return new gf();
    }

    protected gX createPopupMode() {
        return null;
    }

    protected gX createEditNodeMode() {
        return null;
    }

    protected gX createMoveNodePortMode() {
        return new dH();
    }

    @Override
    public void activate(boolean bl2) {
        boolean bl3 = fj.z;
        if (!bl2) {
            block5 : {
                for (gX gX2 = this.getChild(); gX2 != null; gX2 = gX2.getChild()) {
                    gX2.activate(bl2);
                    if (!bl3) {
                        if (!bl3) continue;
                    }
                    break block5;
                }
                if (this.getGraph2D().c(ORTHOGONAL_ROUTING_DPKEY) == this.eg) {
                    this.getGraph2D().d_(ORTHOGONAL_ROUTING_DPKEY);
                }
            }
            if (this.og != null) {
                this.view.removePropertyChangeListener("Graph2D", this.og);
                this.og = null;
            }
        }
        super.activate(bl2);
        if (!bl2) return;
        this.prepareView(this.view);
        if (aC.c(this.getGraph2D()) != null) return;
        this.og = new aD(this);
        this.view.addPropertyChangeListener("Graph2D", this.og);
        this.eg = new aE(this);
        this.getGraph2D().a(ORTHOGONAL_ROUTING_DPKEY, this.eg);
    }

    @Override
    public void cancelEditing() {
        boolean bl2 = fj.z;
        for (gX gX2 = this.getChild(); gX2 != null; gX2 = gX2.getChild()) {
            if (!gX2.isEditing()) continue;
            gX2.cancelEditing();
            if (!bl2) continue;
        }
        super.cancelEditing();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setChild(gX gX2, MouseEvent mouseEvent, MouseEvent mouseEvent2, MouseEvent mouseEvent3) {
        gX gX3 = this.getChild();
        super.setChild(gX2, mouseEvent, mouseEvent2, mouseEvent3);
        if (gX3 == null) return;
        if (gX2 != null) return;
        if (this.gg) return;
        this.gg = true;
        try {
            MouseEvent mouseEvent4 = this.view.p();
            if (mouseEvent4 == null) return;
            if (mouseEvent4.getID() == 505) return;
            this.mouseMoved(new MouseEvent(this.view.getCanvasComponent(), 503, mouseEvent4.getWhen() + 1, 0, mouseEvent4.getX(), mouseEvent4.getY(), 0, false));
            return;
        }
        finally {
            this.gg = false;
        }
    }

    protected void prepareView(ch ch2) {
        if (this.hf) {
            ch2.setScrollBarPolicy(20, 30);
        }
        ch2.setViewCursor(this.getDefaultCursor());
        ch2.updateView();
    }

    public void setMixedSelectionEnabled(boolean bl2) {
        this.lf = bl2;
    }

    public boolean isMixedSelectionEnabled() {
        return this.lf;
    }

    public void setOrthogonalEdgeRouting(boolean bl2) {
        this.nf = bl2;
    }

    public boolean isOrthogonalEdgeRouting() {
        return this.nf;
    }

    public void assignNodeLabel(boolean bl2) {
        this.yf = bl2;
    }

    public void allowNodeCreation(boolean bl2) {
        this.fg = bl2;
    }

    public void allowNodeEditing(boolean bl2) {
        this.ag = bl2;
    }

    public void allowEdgeCreation(boolean bl2) {
        this.rg = bl2;
    }

    public void allowBendCreation(boolean bl2) {
        this.jg = bl2;
        if (!(this.createEdgeMode instanceof F)) return;
        ((F)this.createEdgeMode).b(bl2);
    }

    public void allowMoveSelection(boolean bl2) {
        this.me = bl2;
    }

    public void allowMoveLabels(boolean bl2) {
        this.xe = bl2;
    }

    public void allowMovePorts(boolean bl2) {
        this.qf = bl2;
    }

    public void allowLabelSelection(boolean bl2) {
        this.sg = bl2;
    }

    public void allowMoving(boolean bl2) {
        this.qe = bl2;
    }

    public void allowMovingWithPopup(boolean bl2) {
        this.re = bl2;
    }

    public void allowResizeNodes(boolean bl2) {
        this.ne = bl2;
    }

    public void allowMouseInput(boolean bl2) {
        this.we = bl2;
    }

    public boolean doAssignNodeLabel() {
        return this.yf;
    }

    public boolean doAllowNodeCreation() {
        return this.fg;
    }

    public boolean doAllowNodeEditing() {
        return this.ag;
    }

    public boolean doAllowEdgeCreation() {
        return this.rg;
    }

    public boolean doAllowBendCreation() {
        return this.jg;
    }

    public boolean doAllowLabelSelection() {
        return this.sg;
    }

    public boolean doAllowMoveLabels() {
        return this.xe;
    }

    public boolean doAllowMovePorts() {
        return this.qf;
    }

    public boolean doAllowMouseInput() {
        return this.we;
    }

    public boolean doAllowMoveSelection() {
        return this.me;
    }

    public boolean doAllowMoving() {
        if (!this.qe) return false;
        if (this.popupMode != null) return false;
        return true;
    }

    public boolean doAllowMovingWithPopup() {
        return this.re;
    }

    public boolean doAllowResizeNodes() {
        return this.ne;
    }

    public void showNodeTips(boolean bl2) {
        this.ze = bl2;
        if (this.ze) return;
        if (this.view == null) return;
        this.view.setToolTipText(null);
    }

    public boolean doShowNodeTips() {
        return this.ze;
    }

    public void showEdgeTips(boolean bl2) {
        this.vf = bl2;
        if (this.vf) return;
        if (this.view == null) return;
        this.view.setToolTipText(null);
    }

    public boolean doShowEdgeTips() {
        return this.vf;
    }

    public void setCyclicSelectionEnabled(boolean bl2) {
        this.cf = bl2;
        if (bl2) return;
        this.of = null;
    }

    public boolean isCyclicSelectionEnabled() {
        return this.cf;
    }

    public void setCyclicSelectionModifierMask(int n2) {
        this.lg = n2;
    }

    public int getCyclicSelectionModifierMask() {
        return this.lg;
    }

    public gX getEditNodeMode() {
        return this.editNodeMode;
    }

    public void setEditNodeMode(gX gX2) {
        this.editNodeMode = gX2;
    }

    public gX getPopupMode() {
        return this.popupMode;
    }

    public void setPopupMode(gX gX2) {
        this.popupMode = gX2;
    }

    public gX getMoveSelectionMode() {
        return this.moveSelectionMode;
    }

    public void setMoveSelectionMode(gX gX2) {
        this.moveSelectionMode = gX2;
    }

    public dz getMouseInputMode() {
        return this.mouseInputMode;
    }

    public void setMouseInputMode(dz dz2) {
        this.mouseInputMode = dz2;
    }

    public gX getCreateEdgeMode() {
        return this.createEdgeMode;
    }

    public void setCreateEdgeMode(gX gX2) {
        this.createEdgeMode = gX2;
    }

    public gX getSelectionBoxMode() {
        return this.selectionBoxMode;
    }

    public void setSelectionBoxMode(gX gX2) {
        this.selectionBoxMode = gX2;
    }

    @Override
    public void mousePressedLeft(double d2, double d3) {
        this.j(d2, d3);
    }

    @Override
    public void mouseShiftPressedLeft(double d2, double d3) {
        this.j(d2, d3);
    }

    @Override
    public void mouseReleasedLeft(double d2, double d3) {
        boolean bl2 = fj.z;
        bu bu2 = this.getGraph2D();
        if (this.af) return;
        switch (this.zf) {
            case 7: {
                this.labelClicked(bu2, this.getLastHitInfo().l(), false, d2, d3, false);
                if (!bl2) return;
            }
            case 8: {
                this.labelClicked(bu2, this.getLastHitInfo().m(), false, d2, d3, false);
                if (!bl2) return;
            }
            case 9: {
                this.labelClicked(bu2, this.getLastHitInfo().l(), true, d2, d3, false);
                if (!bl2) return;
            }
            case 10: {
                this.labelClicked(bu2, this.getLastHitInfo().m(), true, d2, d3, false);
                if (!bl2) return;
            }
            case 0: {
                this.paperClicked(bu2, d2, d3, false);
                if (!bl2) return;
            }
            case 1: {
                this.nodeClicked(bu2, this.getLastHitInfo().i(), false, d2, d3, false);
                if (!bl2) return;
            }
            case 3: {
                this.bendClicked(bu2, this.getLastHitInfo().j(), false, d2, d3, false);
                if (!bl2) return;
            }
            case 5: {
                this.edgeClicked(bu2, this.getLastHitInfo().k(), false, d2, d3, false);
                if (!bl2) return;
            }
            case 2: {
                this.nodeClicked(bu2, this.getLastHitInfo().i(), true, d2, d3, false);
                if (!bl2) return;
            }
            case 6: {
                this.edgeClicked(bu2, this.getLastHitInfo().k(), true, d2, d3, false);
                if (!bl2) return;
            }
            case 4: {
                this.bendClicked(bu2, this.getLastHitInfo().j(), true, d2, d3, false);
                if (!bl2) return;
            }
            case 13: {
                this.nodePortClicked(bu2, this.getLastHitInfo().o(), false, d2, d3, false);
                if (!bl2) return;
            }
            case 14: {
                this.nodePortClicked(bu2, this.getLastHitInfo().o(), true, d2, d3, false);
                break;
            }
        }
    }

    private void p() {
        if (!this.isCyclicSelectionEnabled()) return;
        if (!this.isCyclicSelectionModifierPressed()) return;
        this.beforeSelectionCycling(this.of.d());
    }

    /*
     * Unable to fully structure code
     */
    protected void labelClicked(bu var1_1, gZ var2_2, boolean var3_3, double var4_4, double var6_5, boolean var8_6) {
        var10_7 = fj.z;
        var9_8 = this.doAllowLabelSelection();
        if (!var8_6 || !var9_8) ** GOTO lbl12
        this.p();
        if (!var3_3) ** GOTO lbl-1000
        this.setSelected(var1_1, var2_2, false);
        if (var10_7) lbl-1000: // 2 sources:
        {
            if (this.isMixedSelectionEnabled() || !this.b(var1_1, -49)) {
                this.setSelected(var1_1, var2_2, true);
            }
        }
        var1_1.T();
        if (var10_7 == false) return;
lbl12: // 2 sources:
        this.labelClicked(var2_2);
        if (var3_3 != false) return;
        if (var9_8 == false) return;
        this.unselectAll(var1_1);
        this.setSelected(var1_1, var2_2, true);
        var1_1.T();
    }

    protected void labelClicked(gZ gZ2) {
    }

    @Override
    public void mouseShiftReleasedLeft(double d2, double d3) {
        boolean bl2 = fj.z;
        bu bu2 = this.getGraph2D();
        if (this.af) return;
        switch (this.zf) {
            case 7: {
                this.labelClicked(bu2, this.getLastHitInfo().l(), false, d2, d3, true);
                if (!bl2) return;
            }
            case 8: {
                this.labelClicked(bu2, this.getLastHitInfo().m(), false, d2, d3, true);
                if (!bl2) return;
            }
            case 9: {
                this.labelClicked(bu2, this.getLastHitInfo().l(), true, d2, d3, true);
                if (!bl2) return;
            }
            case 10: {
                this.labelClicked(bu2, this.getLastHitInfo().m(), true, d2, d3, true);
                if (!bl2) return;
            }
            case 0: {
                this.paperClicked(bu2, d2, d3, true);
                if (!bl2) return;
            }
            case 1: {
                this.nodeClicked(bu2, this.getLastHitInfo().i(), false, d2, d3, true);
                if (!bl2) return;
            }
            case 3: {
                this.bendClicked(bu2, this.getLastHitInfo().j(), false, d2, d3, true);
                if (!bl2) return;
            }
            case 5: {
                this.edgeClicked(bu2, this.getLastHitInfo().k(), false, d2, d3, true);
                if (!bl2) return;
            }
            case 6: {
                this.edgeClicked(bu2, this.getLastHitInfo().k(), true, d2, d3, true);
                if (!bl2) return;
            }
            case 4: {
                this.bendClicked(bu2, this.getLastHitInfo().j(), true, d2, d3, true);
                if (!bl2) return;
            }
            case 2: {
                this.nodeClicked(bu2, this.getLastHitInfo().i(), true, d2, d3, true);
                if (!bl2) return;
            }
            case 13: {
                this.nodePortClicked(bu2, this.getLastHitInfo().o(), false, d2, d3, true);
                if (!bl2) return;
            }
            case 14: {
                this.nodePortClicked(bu2, this.getLastHitInfo().o(), true, d2, d3, true);
                break;
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    protected void nodePortClicked(bu var1_1, eU var2_2, boolean var3_3, double var4_4, double var6_5, boolean var8_6) {
        var9_7 = fj.z;
        if (!var8_6) ** GOTO lbl10
        if (!var3_3) ** GOTO lbl-1000
        this.setSelected(var1_1, var2_2, false);
        if (var9_7) lbl-1000: // 2 sources:
        {
            if (this.isMixedSelectionEnabled() || !this.b(var1_1, -65)) {
                this.setSelected(var1_1, var2_2, true);
            }
        }
        var1_1.T();
        if (var9_7 == false) return;
lbl10: // 2 sources:
        if (var3_3 != false) return;
        this.unselectAll(var1_1);
        this.setSelected(var1_1, var2_2, true);
        var1_1.T();
    }

    /*
     * Exception decompiling
     */
    private boolean b(bu var1_1, int var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[DOLOOP]], but top level block is 3[WHILELOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
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

    /*
     * Unable to fully structure code
     */
    protected void nodeClicked(bu var1_1, q var2_2, boolean var3_3, double var4_4, double var6_5, boolean var8_6) {
        var9_7 = fj.z;
        if (this.isChildNodeCreationEnabled() && this.b(var1_1, var2_2) && !this.isGroupNodeBorderHit(var1_1, var2_2, var4_4, var6_5, this.isSelectOnGroupNodeLabelEnabled())) ** GOTO lbl18
        this.p();
        if (!var8_6) ** GOTO lbl12
        if (!var3_3) ** GOTO lbl-1000
        this.setSelected(var1_1, var2_2, false);
        if (var9_7) lbl-1000: // 2 sources:
        {
            if (this.isMixedSelectionEnabled() || !this.b(var1_1, -10)) {
                this.setSelected(var1_1, var2_2, true);
            }
        }
        var1_1.T();
        if (var9_7 == false) return;
lbl12: // 2 sources:
        this.nodeClicked(var2_2);
        if (var3_3 != false) return;
        this.unselectAll(var1_1);
        this.setSelected(var1_1, var2_2, true);
        var1_1.T();
        if (var9_7 == false) return;
lbl18: // 2 sources:
        this.nodeClicked(var2_2);
    }

    protected void beforeSelectionCycling(C c2) {
        boolean bl2 = fj.z;
        if (c2 == null) return;
        if (!c2.f()) return;
        bu bu2 = this.getGraph2D();
        c2.g();
        while (c2.f()) {
            this.b(bu2, c2.d(), false);
            c2.g();
            if (bl2) return;
            if (!bl2) continue;
        }
        bu2.T();
    }

    protected boolean isGroupNodeBorderHit(bu bu2, q q2, double d2, double d3, boolean bl2) {
        boolean bl3 = fj.z;
        if (!this.b(bu2, q2)) return false;
        fj fj2 = bu2.t(q2);
        if (bl2) {
            cW cW2 = this.createLabelHitInfo(d2, d3);
            C c2 = cW2.g();
            while (c2.f()) {
                eR eR2 = (eR)c2.d();
                if (bl3) return false;
                if (eR2.f() == q2 && fj2.getLabel(0) == eR2) {
                    return true;
                }
                c2.g();
                if (!bl3) continue;
            }
        }
        int n2 = this.getGroupBorderWidth();
        if (d2 < fj2.getX() + (double)n2) return true;
        if (d2 > fj2.getX() + fj2.getWidth() - (double)n2) return true;
        if (d3 < fj2.getY() + (double)n2) return true;
        if (d3 <= fj2.getY() + fj2.getHeight() - (double)n2) return false;
        return true;
    }

    private boolean b(bu bu2, q q2) {
        v v2 = v.a(bu2);
        if (v2 == null) return false;
        if (!v2.k(q2)) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    protected void bendClicked(bu var1_1, x var2_2, boolean var3_3, double var4_4, double var6_5, boolean var8_6) {
        var9_7 = fj.z;
        this.p();
        if (!var8_6) ** GOTO lbl14
        if (!var3_3) ** GOTO lbl7
        this.setSelected(var1_1, var2_2, false);
        if (!var9_7) ** GOTO lbl12
lbl7: // 2 sources:
        if (this.isMixedSelectionEnabled() || !this.b(var1_1, 2)) ** GOTO lbl-1000
        this.setSelected(var1_1, var2_2.a(), this.isSelected(var1_1, var2_2.a()) == false);
        if (var9_7) lbl-1000: // 2 sources:
        {
            if (this.isMixedSelectionEnabled() || !this.b(var1_1, -10)) {
                this.setSelected(var1_1, var2_2, true);
            }
        }
lbl12: // 6 sources:
        var1_1.T();
        if (var9_7 == false) return;
lbl14: // 2 sources:
        if (var3_3) {
            return;
        }
        this.unselectAll(var1_1);
        this.setSelected(var1_1, var2_2, true);
        var1_1.T();
    }

    /*
     * Unable to fully structure code
     */
    protected void edgeClicked(bu var1_1, d var2_2, boolean var3_3, double var4_4, double var6_5, boolean var8_6) {
        block9 : {
            block8 : {
                var12_7 = fj.z;
                this.p();
                if (!var8_6) ** GOTO lbl44
                if (!var3_3) ** GOTO lbl7
                this.setSelected(var1_1, var2_2, false);
                if (!var12_7) ** GOTO lbl41
lbl7: // 2 sources:
                if (this.isMixedSelectionEnabled() || !this.b(var1_1, 9)) ** GOTO lbl37
                var9_8 = var1_1.i(var2_2);
                if (var9_8.bendCount() <= 0) ** GOTO lbl41
                var10_9 = 0;
                var11_10 = var9_8.bends();
                while (var11_10.f()) {
                    v0 = (int)this.isSelected(var1_1, var11_10.a()) ? 1 : 0;
                    if (!var12_7) {
                        if (v0 != 0) {
                            ++var10_9;
                        }
                        var11_10.g();
                        if (!var12_7) continue;
                    }
                    break block8;
                }
                v0 = var10_9;
            }
            if (v0 != var9_8.bendCount()) ** GOTO lbl30
            var11_10 = var9_8.bends();
            block1 : while (var11_10.f()) {
                this.setSelected(var1_1, var11_10.a(), false);
                var11_10.g();
                if (!var12_7) {
                    if (!var12_7) continue;
                }
                break block9;
lbl30: // 2 sources:
                var11_10 = var9_8.bends();
                while (var11_10.f()) {
                    this.setSelected(var1_1, var11_10.a(), true);
                    var11_10.g();
                    if (!var12_7) {
                        if (!var12_7) continue;
                    }
                    break block9;
lbl37: // 2 sources:
                    if (!this.isMixedSelectionEnabled() && this.b(var1_1, -7)) break block1;
                    this.setSelected(var1_1, var2_2, true);
                    break;
                }
                break block1;
                break;
            }
lbl41: // 6 sources:
            var1_1.T();
        }
        if (var12_7 == false) return;
lbl44: // 2 sources:
        if (var3_3) {
            return;
        }
        this.unselectAll(var1_1);
        this.setSelected(var1_1, var2_2, true);
        var1_1.T();
    }

    protected void paperClicked(bu bu2, double d2, double d3, boolean bl2) {
        if (bl2) return;
        if (this.isCyclicSelectionEnabled() && this.isCyclicSelectionModifierPressed()) {
            return;
        }
        if (!this.isSelectionEmpty(bu2)) {
            this.unselectAll(bu2);
            bu2.T();
            if (!fj.z) return;
        }
        if (!this.doAllowNodeCreation()) return;
        this.setEditing(true);
        q q2 = this.createNode(bu2, d2, d3);
        if (q2 != null) {
            bu2.T();
            this.nodeCreated(q2);
        }
        this.setEditing(false);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (this.getChild() != null) {
            this.zf = -1;
        }
        super.mousePressed(mouseEvent);
    }

    @Override
    public void mouseDraggedLeft(double d2, double d3) {
        boolean bl2 = fj.z;
        bu bu2 = this.getGraph2D();
        this.getHitInfo(d2, d3);
        boolean bl3 = !this.af;
        this.af = true;
        switch (this.zf) {
            default: {
                if (!bl2) return;
            }
            case 0: {
                this.paperDragged(bu2, d2, d3, bl3);
                if (!bl2) return;
            }
            case 1: {
                this.nodeDragged(bu2, this.te.i(), false, d2, d3, bl3);
                if (!bl2) return;
            }
            case 2: {
                this.nodeDragged(bu2, this.te.i(), true, d2, d3, bl3);
                if (!bl2) return;
            }
            case 3: {
                this.bendDragged(bu2, this.te.j(), false, d2, d3, bl3);
                if (!bl2) return;
            }
            case 4: {
                this.bendDragged(bu2, this.te.j(), true, d2, d3, bl3);
                if (!bl2) return;
            }
            case 7: {
                this.labelDragged(bu2, this.te.l(), false, d2, d3, bl3);
                if (!bl2) return;
            }
            case 9: {
                this.labelDragged(bu2, this.te.l(), true, d2, d3, bl3);
                if (!bl2) return;
            }
            case 8: {
                this.labelDragged(bu2, this.te.m(), false, d2, d3, bl3);
                if (!bl2) return;
            }
            case 10: {
                this.labelDragged(bu2, this.te.m(), true, d2, d3, bl3);
                if (!bl2) return;
            }
            case 5: {
                this.edgeDragged(bu2, this.te.k(), false, d2, d3, bl3);
                if (!bl2) return;
            }
            case 6: {
                this.edgeDragged(bu2, this.te.k(), true, d2, d3, bl3);
                if (!bl2) return;
            }
            case 11: {
                this.hotSpotDragged(bu2, d2, d3, bl3);
                if (!bl2) return;
            }
            case 12: {
                this.portDragged(bu2, this.te.n(), d2, d3, bl3);
                if (!bl2) return;
            }
            case 13: {
                this.nodePortDragged(bu2, this.te.o(), false, d2, d3, bl3);
                if (!bl2) return;
            }
            case 14: 
        }
        this.nodePortDragged(bu2, this.te.o(), true, d2, d3, bl3);
    }

    protected void bendDragged(bu bu2, x x2, boolean bl2, double d2, double d3, boolean bl3) {
        gX gX2;
        block3 : {
            boolean bl4 = fj.z;
            if (bl2) {
                if (!bl3) return;
                gX2 = this.getMoveSelectionMode();
                if (this.isSelectionEmpty(bu2)) return;
                if (!this.doAllowMoveSelection()) return;
                if (gX2 == null) return;
                this.setChild(gX2, this.lastPressEvent, this.lastDragEvent);
                if (!bl4) return;
            }
            if (!bl3) return;
            if (this.isMixedSelectionEnabled()) {
                this.unselectNodes(bu2);
                this.unselectBends(bu2);
                if (!bl4) break block3;
            }
            this.unselectAll(bu2);
        }
        this.setSelected(bu2, x2, true);
        gX2 = this.getMoveSelectionMode();
        if (!this.doAllowMoveSelection()) return;
        if (gX2 == null) return;
        this.setChild(gX2, this.lastPressEvent, this.lastDragEvent);
    }

    protected void edgeDragged(bu bu2, d d2, boolean bl2, double d3, double d4, boolean bl3) {
        if (bl3 && d2 != null && this.isOrthogonalRouting(d2) && this.doAllowMoveSelection()) {
            this.setChild(this.getOrthogonalMoveBendsMode(), this.lastPressEvent, this.lastDragEvent);
            return;
        }
        if (!bl3) return;
        if (!this.doAllowBendCreation()) return;
        this.unselectAll(bu2);
        bu2.T();
        bu2.a(new f(d2).a());
        x x2 = this.createBend(bu2, d2, this.ve, this.ef);
        if (x2 == null) return;
        this.setSelected(bu2, x2, true);
        this.bendCreated(bu2, d2, x2, this.ve, this.ef);
        if (!this.doAllowMoveSelection()) return;
        this.setChild(this.getMoveSelectionMode(), this.lastPressEvent, this.lastDragEvent);
    }

    protected void hotSpotDragged(bu bu2, double d2, double d3, boolean bl2) {
        gX gX2 = this.getHotSpotMode();
        if (gX2 == null) return;
        this.setChild(gX2, this.lastPressEvent, this.lastDragEvent);
    }

    protected void labelDragged(bu bu2, aA aA2, boolean bl2, double d2, double d3, boolean bl3) {
        gX gX2 = this.getMoveLabelMode();
        if (!bl3) return;
        if (!this.doAllowMoveLabels()) return;
        if (gX2 == null) return;
        this.setChild(gX2, this.lastPressEvent, this.lastDragEvent);
    }

    protected void labelDragged(bu bu2, eR eR2, boolean bl2, double d2, double d3, boolean bl3) {
        gX gX2 = this.getMoveLabelMode();
        if (!bl3) return;
        if (!this.doAllowMoveLabels()) return;
        if (gX2 == null) return;
        this.setChild(gX2, this.lastPressEvent, this.lastDragEvent);
    }

    protected void nodeDragged(bu bu2, q q2, boolean bl2, double d2, double d3, boolean bl3) {
        gX gX2;
        boolean bl4 = fj.z;
        if (bl2) {
            if (!bl3) return;
            gX2 = this.getMoveSelectionMode();
            if (this.isSelectionEmpty(bu2)) return;
            if (!this.doAllowMoveSelection()) return;
            if (gX2 == null) return;
            this.setChild(gX2, this.lastPressEvent, this.lastDragEvent);
            if (!bl4) return;
        }
        gX2 = this.getSelectionBoxMode();
        if (!this.isCreateEdgeGesture(this.lastPressEvent, this.lastDragEvent) && gX2 != null) {
            this.setChild(gX2, this.lastPressEvent, this.lastDragEvent);
            if (!bl4) return;
        }
        gX gX3 = this.getCreateEdgeMode();
        if (this.doAllowEdgeCreation() && gX3 != null) {
            this.setChild(gX3, this.lastPressEvent, this.lastDragEvent);
            if (!bl4) return;
        }
        if (this.doAllowEdgeCreation()) return;
        if (!bl3) return;
        gX gX4 = this.getMoveSelectionMode();
        if (!this.doAllowMoveSelection()) return;
        if (gX4 == null) return;
        this.unselectAll(bu2);
        this.setSelected(bu2, q2, true);
        this.setChild(gX4, this.lastPressEvent, this.lastDragEvent);
    }

    protected void nodePortDragged(bu bu2, eU eU2, boolean bl2, double d2, double d3, boolean bl3) {
        gX gX2;
        boolean bl4 = fj.z;
        if (bl2) {
            if (!bl3) return;
            gX2 = this.getMoveNodePortMode();
            if (gX2 == null) return;
            this.setChild(gX2, this.lastPressEvent, this.lastDragEvent);
            if (!bl4) return;
        }
        gX2 = this.getSelectionBoxMode();
        if (!this.isCreateEdgeGesture(this.lastPressEvent, this.lastDragEvent) && gX2 != null) {
            this.setChild(gX2, this.lastPressEvent, this.lastDragEvent);
            if (!bl4) return;
        }
        gX gX3 = this.getCreateEdgeMode();
        if (this.doAllowEdgeCreation() && gX3 != null) {
            this.setChild(gX3, this.lastPressEvent, this.lastDragEvent);
            if (!bl4) return;
        }
        if (this.doAllowEdgeCreation()) return;
        if (!bl3) return;
        gX gX4 = this.getMoveNodePortMode();
        if (gX4 == null) return;
        this.unselectAll(bu2);
        this.setSelected(bu2, eU2, true);
        this.setChild(gX4, this.lastPressEvent, this.lastDragEvent);
    }

    protected void paperDragged(bu bu2, double d2, double d3, boolean bl2) {
        gX gX2 = this.getSelectionBoxMode();
        if (gX2 == null) return;
        this.setChild(gX2, this.lastPressEvent, this.lastDragEvent);
    }

    protected void portDragged(bu bu2, fL fL2, double d2, double d3, boolean bl2) {
        gX gX2 = this.getMovePortMode();
        if (!this.doAllowMovePorts()) return;
        if (gX2 == null) return;
        this.setChild(gX2, this.lastPressEvent, this.lastDragEvent);
    }

    protected void setSelected(bu bu2, eU eU2, boolean bl2) {
        bu2.a(eU2, bl2);
    }

    protected void setSelected(bu bu2, q q2, boolean bl2) {
        if (bl2) {
            gg.a(bu2, q2);
            if (!fj.z) return;
        }
        gg.b(bu2, q2);
    }

    protected void setSelected(bu bu2, gZ gZ2, boolean bl2) {
        bu2.a(gZ2, bl2);
    }

    protected void setSelected(bu bu2, d d2, boolean bl2) {
        bu2.a(d2, bl2);
    }

    protected void setSelected(bu bu2, x x2, boolean bl2) {
        bu2.a(x2, bl2);
    }

    private void b(bu bu2, Object object, boolean bl2) {
        boolean bl3 = fj.z;
        if (object instanceof q) {
            this.setSelected(bu2, (q)object, bl2);
            if (!bl3) return;
        }
        if (object instanceof d) {
            this.setSelected(bu2, (d)object, bl2);
            if (!bl3) return;
        }
        if (object instanceof x) {
            this.setSelected(bu2, (x)object, bl2);
            if (!bl3) return;
        }
        if (object instanceof gZ) {
            this.setSelected(bu2, (gZ)object, bl2);
            if (!bl3) return;
        }
        if (!(object instanceof eU)) return;
        this.setSelected(bu2, (eU)object, bl2);
    }

    protected void unselectNodes(bu bu2) {
        bu2.O();
    }

    protected void unselectBends(bu bu2) {
        bu2.Q();
    }

    protected void unselectAll(bu bu2) {
        bu2.N();
    }

    protected boolean isSelectionEmpty(bu bu2) {
        return bu2.H();
    }

    protected boolean isSelected(bu bu2, x x2) {
        return bu2.a(x2);
    }

    protected boolean isSelected(bu bu2, d d2) {
        return bu2.r(d2);
    }

    protected boolean isSelected(bu bu2, gZ gZ2) {
        return bu2.a(gZ2);
    }

    protected boolean isSelected(bu bu2, q q2) {
        return bu2.v(q2);
    }

    protected boolean isSelected(bu bu2, eU eU2) {
        return bu2.a(eU2);
    }

    private boolean b(bu bu2, Object object) {
        if (object instanceof q) {
            return this.isSelected(bu2, (q)object);
        }
        if (object instanceof d) {
            return this.isSelected(bu2, (d)object);
        }
        if (object instanceof x) {
            return this.isSelected(bu2, (x)object);
        }
        if (object instanceof gZ) {
            return this.isSelected(bu2, (gZ)object);
        }
        if (!(object instanceof eU)) return false;
        return this.isSelected(bu2, (eU)object);
    }

    protected boolean isOrthogonalRouting(d d2) {
        c c2 = aC.c(this.getGraph2D());
        if (c2 == null) return this.nf;
        if (c2 == this.eg) return this.nf;
        return c2.d(d2);
    }

    private static c c(bu bu2) {
        c c2 = bu2.c(ORTHOGONAL_ROUTING_DPKEY);
        if (c2 != null) return c2;
        if (bu2.C() == null) return c2;
        if (bu2.C().g() == bu2) return c2;
        return bu2.C().g().c(ORTHOGONAL_ROUTING_DPKEY);
    }

    protected x createBend(bu bu2, d d2, double d3, double d4) {
        return bu2.i(d2).insertBend(d3, d4);
    }

    protected q createNode(bu bu2, double d2, double d3) {
        return this.createNode(bu2, d2, d3, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected q createNode(bu bu2, double d2, double d3, q q2) {
        q q3;
        v v2;
        q3 = bu2.a(this.getGridX(d2), this.getGridY(d3));
        this.configureNode(bu2, q3);
        if (q2 != null && (v2 = v.a(bu2)) != null) {
            boolean bl2;
            a a2 = bu2.t(q2).getAutoBoundsFeature();
            boolean bl3 = bl2 = a2 != null && a2.isAutoBoundsEnabled();
            if (bl2) {
                bu2.a(new y.c.y(q2).a());
                a2.setAutoBoundsEnabled(false);
            }
            try {
                v2.c(q3, q2);
            }
            finally {
                if (bl2) {
                    a2.setAutoBoundsEnabled(true);
                }
            }
        }
        bu2.T();
        return q3;
    }

    protected void configureNode(bu bu2, q q2) {
        if (!this.doAssignNodeLabel()) return;
        if (bu2.t(q2).labelCount() <= 0) return;
        if (!"".equals(bu2.u(q2))) return;
        bu2.a(q2, Integer.toString(bu2.f()));
    }

    @Override
    public void mousePressedRight(double d2, double d3) {
        gX gX2;
        boolean bl2 = fj.z;
        if (this.doAllowMovingWithPopup()) {
            this.df = false;
            if (!bl2) return;
        }
        if (this.doAllowMoving()) {
            gX2 = this.getMoveViewPortMode();
            if (gX2 == null) return;
            this.setChild(gX2, this.lastPressEvent, null);
            if (!bl2) return;
        }
        if ((gX2 = this.getPopupMode()) == null) return;
        this.setChild(gX2, this.lastPressEvent, null);
    }

    @Override
    public void mouseDraggedRight(double d2, double d3) {
        if (!this.doAllowMovingWithPopup()) return;
        gX gX2 = this.getMoveViewPortMode();
        if (gX2 == null) return;
        this.df = true;
        this.setChild(gX2, this.lastPressEvent, this.lastDragEvent);
    }

    @Override
    public void mouseReleasedRight(double d2, double d3) {
        gX gX2;
        if (!this.doAllowMovingWithPopup()) return;
        if (this.df) {
            this.df = false;
            if (!fj.z) return;
        }
        if ((gX2 = this.getPopupMode()) == null) return;
        this.setChild(gX2, this.lastPressEvent, null, this.lastReleaseEvent);
    }

    @Override
    public void mouseMoved(double d2, double d3) {
        Object object;
        byte by2;
        bu bu2 = this.getGraph2D();
        cW cW2 = this.getHitInfo(d2, d3);
        dz dz2 = this.getMouseInputMode();
        if (this.doAllowMouseInput() && dz2 != null && (object = dz2.a(this.view, d2, d3, cW2)) != null) {
            dz2.a((dx)object);
            this.view.setToolTipText(null);
            this.view.setViewCursor(this.getDefaultCursor());
            this.setChild(dz2, null, null, null);
            dz2.mouseMoved(this.lastMoveEvent);
            return;
        }
        if (this.doShowEdgeTips() || this.doShowNodeTips()) {
            object = null;
            if (cW2.i() != null) {
                if (this.doShowNodeTips()) {
                    object = this.getNodeTip(cW2.i());
                }
            } else if (cW2.k() != null && this.doShowEdgeTips()) {
                object = this.getEdgeTip(cW2.k());
            }
            if (object != null && object.length() < 1) {
                object = null;
            }
            this.view.setToolTipText((String)object);
        }
        if (this.doAllowResizeNodes() && (by2 = this.b(this.view, bu2, d2, d3)) != 8) {
            this.view.setViewCursor(da.a(by2));
            return;
        }
        if (this.doAllowMoveSelection() && (object = cW2.i()) != null && this.isSelected(bu2, (q)object)) {
            this.view.setViewCursor(Cursor.getPredefinedCursor(13));
            return;
        }
        if (this.doAllowBendCreation() && cW2.k() != null) {
            this.view.setViewCursor(Cursor.getPredefinedCursor(12));
            return;
        }
        if (this.doAllowMovePorts() && cW2.n() != null && this.getMovePortMode() instanceof dI) {
            this.view.setViewCursor(((dI)this.getMovePortMode()).h());
            return;
        }
        this.view.setViewCursor(this.getDefaultCursor());
    }

    private byte b(ch ch2, bu bu2, double d2, double d3) {
        boolean bl2 = fj.z;
        y.c.x x2 = bu2.o();
        do {
            byte by2;
            if (!x2.f()) return 8;
            q q2 = x2.e();
            byte by3 = (byte)this.isSelected(bu2, q2) ? 1 : 0;
            if (bl2) return by3;
            if (by3 != 0 && (by2 = bu2.t(q2).hotSpotHit(d2, d3)) != 8) {
                return by2;
            }
            x2.g();
        } while (!bl2);
        return 8;
    }

    @Override
    public void mouseClicked(double d2, double d3) {
        gX gX2 = this.getEditNodeMode();
        if (!this.doAllowNodeEditing()) return;
        if (gX2 == null) return;
        if (gX2.isActive()) return;
        q q2 = this.getHitInfo(d2, d3).i();
        if (q2 == null) return;
        if (!this.isEditNodeGesture(q2, this.lastPressEvent, this.lastReleaseEvent, this.lastClickEvent)) return;
        this.editNode(q2, this.lastClickEvent);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        this.zf = -1;
        super.mouseEntered(mouseEvent);
    }

    public boolean startEditor(dx dx2) {
        dz dz2 = this.getMouseInputMode();
        if (dx2 == null) return false;
        if (!this.doAllowMouseInput()) return false;
        if (dz2 == null) return false;
        boolean bl2 = dz2.a(dx2);
        if (!bl2) return bl2;
        this.setChild(dz2, null, null);
        return bl2;
    }

    private void j(double d2, double d3) {
        Object object;
        byte by2;
        boolean bl2;
        block20 : {
            bl2 = fj.z;
            if (this.isCyclicSelectionEnabled() && this.isCyclicSelectionModifierPressed()) {
                block19 : {
                    object = this.createCyclicHitInfo(d2, d3);
                    if (this.b((cW)object)) {
                        this.of = object;
                        if (!bl2) break block19;
                    }
                    this.of = this.of.a(this.getGraph2D(), d2, d3);
                }
                this.setLastHitInfo(this.of);
                this.te = this.of;
                if (!bl2) break block20;
            }
            this.te = this.getHitInfo(d2, d3);
        }
        this.af = false;
        this.ve = d2;
        this.ef = d3;
        object = this.getGraph2D();
        if (this.doAllowResizeNodes() && (by2 = this.b(this.view, (bu)object, d2, d3)) != 8) {
            this.zf = 11;
            return;
        }
        if (this.te.a()) {
            Object object2 = this.te.h();
            if (object2 instanceof fL) {
                this.zf = 12;
                return;
            }
            if (object2 instanceof q) {
                this.pressedNode = (q)object2;
                if (this.isSelected((bu)object, this.pressedNode)) {
                    this.zf = 2;
                    if (!bl2) return;
                }
                this.zf = 1;
                return;
            }
            if (object2 instanceof eU) {
                this.pressedNode = ((eU)object2).b().getNode();
                if (this.isSelected((bu)object, (eU)object2)) {
                    this.zf = 14;
                    if (!bl2) return;
                }
                this.zf = 13;
                return;
            }
            if (object2 instanceof x) {
                if (this.isSelected((bu)object, (x)object2)) {
                    this.zf = 4;
                    if (!bl2) return;
                }
                this.zf = 3;
                return;
            }
            if (object2 instanceof d) {
                if (this.isSelected((bu)object, (d)object2)) {
                    this.zf = 6;
                    if (!bl2) return;
                }
                this.zf = 5;
                return;
            }
            if (object2 instanceof eR) {
                if (this.isSelected((bu)object, (eR)object2)) {
                    this.zf = 9;
                    if (!bl2) return;
                }
                this.zf = 7;
                return;
            }
            if (object2 instanceof aA) {
                if (this.isSelected((bu)object, (aA)object2)) {
                    this.zf = 10;
                    if (!bl2) return;
                }
                this.zf = 8;
                return;
            }
        }
        this.zf = 0;
    }

    private boolean b(cW cW2) {
        boolean bl2 = fj.z;
        if (this.of == null) return true;
        if (!cW2.a(this.of)) {
            return true;
        }
        if (!this.of.a()) return false;
        if (!gg.a(this.getGraph2D(), this.of.h())) {
            return true;
        }
        C c2 = this.of.d();
        c2.g();
        do {
            if (!c2.f()) return false;
            Object object = c2.d();
            boolean bl3 = gg.a(this.getGraph2D(), object);
            if (bl2) return bl3;
            if (bl3) {
                return true;
            }
            c2.g();
        } while (!bl2);
        return false;
    }

    protected boolean isCyclicSelectionModifierPressed() {
        if (this.lastPressEvent == null) return false;
        if ((this.lastPressEvent.getModifiers() & this.getCyclicSelectionModifierMask()) == 0) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    protected cW createCyclicHitInfo(double var1_1, double var3_2) {
        var5_3 = this.getGraph2D();
        var6_4 = this.b(var5_3);
        var7_5 = -1;
        if (this.isMixedSelectionEnabled() || !this.isModifierPressed(this.lastPressEvent) || var6_4 == 0) ** GOTO lbl-1000
        var7_5 = var6_4;
        if (fj.z) lbl-1000: // 2 sources:
        {
            if (!this.doAllowLabelSelection()) {
                var7_5 ^= 48;
            }
        }
        var8_6 = this.view.getHitInfoFactory().a(var1_1, var3_2, var7_5, false);
        return this.j(var8_6, var1_1, var3_2);
    }

    private int b(bu bu2) {
        int n2 = 0;
        if (this.b(bu2, 9)) {
            n2 |= 9;
        }
        if (this.b(bu2, 2)) {
            n2 |= 2;
        }
        if (this.b(bu2, 48)) {
            n2 |= 48;
        }
        if (!this.b(bu2, 64)) return n2;
        n2 |= 64;
        return n2;
    }

    private cW j(cW cW2, double d2, double d3) {
        boolean bl2;
        HashSet<Object> hashSet;
        C c2;
        int n2;
        bu bu2;
        block6 : {
            bl2 = fj.z;
            if (!cW2.b()) {
                return cW2;
            }
            bu2 = this.getGraph2D();
            hashSet = new HashSet<Object>();
            c2 = cW2.d();
            while (c2.f()) {
                Object object = c2.d();
                n2 = (int)this.b(this.getGraph2D(), object) ? 1 : 0;
                if (!bl2) {
                    if (n2 != 0) {
                        hashSet.add(object);
                        if (hashSet.size() > 1) {
                            return cW2;
                        }
                    }
                    c2.g();
                    if (!bl2) continue;
                }
                break block6;
            }
            n2 = hashSet.size();
        }
        if (n2 != 1) return cW2;
        c2 = hashSet.iterator().next();
        do {
            if (cW2.h() == c2) return cW2.a(bu2, d2, d3);
            cW2 = cW2.a(bu2, d2, d3);
            if (bl2) return cW2;
        } while (!bl2);
        return cW2.a(bu2, d2, d3);
    }

    protected String getNodeTip(q q2) {
        fj fj2 = this.getGraph2D().t(q2);
        if (fj2.labelCount() <= 0) return null;
        return fj2.getLabel(0).getText();
    }

    protected String getEdgeTip(d d2) {
        aB aB2 = this.getGraph2D().i(d2);
        if (aB2.labelCount() <= 0) return null;
        return aB2.getLabel(0).getText();
    }

    protected void nodeCreated(q q2) {
    }

    protected void bendCreated(bu bu2, d d2, x x2, double d3, double d4) {
    }

    protected void nodeClicked(q q2) {
        if (!this.b(this.getGraph2D(), q2)) return;
        this.groupNodeClicked(q2);
    }

    /*
     * Unable to fully structure code
     */
    protected void groupNodeClicked(q var1_1) {
        var8_2 = fj.z;
        if (this.doAllowNodeCreation() == false) return;
        if (this.isChildNodeCreationEnabled() == false) return;
        var2_3 = this.getGraph2D();
        if (this.isSelected(var2_3, var1_1) != false) return;
        if (this.lastReleaseEvent == null) ** GOTO lbl10
        var3_4 = this.translateX(this.lastReleaseEvent.getX());
        var5_5 = this.translateY(this.lastReleaseEvent.getY());
        if (!var8_2) ** GOTO lbl17
lbl10: // 2 sources:
        if (this.lastClickEvent == null) ** GOTO lbl-1000
        var3_4 = this.translateX(this.lastClickEvent.getX());
        var5_5 = this.translateY(this.lastClickEvent.getY());
        if (var8_2) lbl-1000: // 2 sources:
        {
            var7_6 = var2_3.t(var1_1);
            var3_4 = var7_6.getCenterX();
            var5_5 = var7_6.getCenterX();
        }
lbl17: // 4 sources:
        if (this.isGroupNodeBorderHit(var2_3, var1_1, var3_4, var5_5, this.isSelectOnGroupNodeLabelEnabled()) != false) return;
        if (this.isSelectionEmpty(var2_3)) {
            this.setEditing(true);
            var7_6 = this.createNode(var2_3, var3_4, var5_5, var1_1);
            if (var7_6 != null) {
                var2_3.T();
                this.nodeCreated((q)var7_6);
            }
            this.setEditing(false);
            if (var8_2 == false) return;
        }
        this.unselectAll(var2_3);
        var2_3.T();
    }

    public gX getMoveViewPortMode() {
        return this.moveViewPortMode;
    }

    public gX getMoveLabelMode() {
        return this.moveLabelMode;
    }

    public void setMoveViewPortMode(gX gX2) {
        this.moveViewPortMode = gX2;
    }

    public void setMoveLabelMode(gX gX2) {
        this.moveLabelMode = gX2;
    }

    public gX getMovePortMode() {
        return this.movePortMode;
    }

    public void setMovePortMode(gX gX2) {
        this.movePortMode = gX2;
    }

    public gX getHotSpotMode() {
        return this.hotSpotMode;
    }

    public void setHotSpotMode(gX gX2) {
        this.hotSpotMode = gX2;
    }

    public gX getMoveNodePortMode() {
        return this.moveNodePortMode;
    }

    public void setMoveNodePortMode(gX gX2) {
        this.moveNodePortMode = gX2;
    }

    protected boolean isCreateEdgeGesture(MouseEvent mouseEvent, MouseEvent mouseEvent2) {
        if (this.pressedNode == null) return false;
        if (mouseEvent == null) {
            return false;
        }
        bu bu2 = this.getGraph2D();
        if (this.isSelected(bu2, this.pressedNode)) return false;
        if (!this.b(bu2, this.pressedNode)) return true;
        if (!this.isGroupNodeBorderHit(bu2, this.pressedNode, this.translateX(mouseEvent.getX()), this.translateY(mouseEvent.getY()), this.isCreateEdgeOnGroupNodeLabelEnabled())) return false;
        return true;
    }

    protected boolean isEditNodeGesture(q q2, MouseEvent mouseEvent, MouseEvent mouseEvent2, MouseEvent mouseEvent3) {
        if (mouseEvent3.getClickCount() != 2) return false;
        return true;
    }

    public Cursor getDefaultCursor() {
        return this.cg;
    }

    public void setDefaultCursor(Cursor cursor) {
        this.cg = cursor;
    }

    protected boolean editNode(q q2, EventObject eventObject) {
        gX gX2 = this.getEditNodeMode();
        if (!this.doAllowNodeEditing()) return false;
        if (gX2 == null) return false;
        if (gX2 instanceof D) {
            D d2 = (D)gX2;
            if (!d2.a(q2)) return false;
            this.setChild(d2, null, null);
            if (d2.a(q2, eventObject)) return true;
            d2.reactivateParent();
            return false;
        }
        this.setChild(gX2, null, null);
        return true;
    }

    public gX getOrthogonalMoveBendsMode() {
        if (this.tf != null) return this.tf;
        this.tf = this.createOrthogonalMoveBendsMode();
        return this.tf;
    }

    public void setOrthogonalMoveBendsMode(gX gX2) {
        this.tf = gX2;
    }

    protected gX createOrthogonalMoveBendsMode() {
        return new fu();
    }

    protected cW createLabelHitInfo(double d2, double d3) {
        return new cW(this.view, d2, d3, false, 5);
    }

    public void setGroupBorderWidth(int n2) {
        this.pe = n2;
    }

    public int getGroupBorderWidth() {
        return this.pe;
    }

    public boolean isCreateEdgeOnGroupNodeLabelEnabled() {
        return this.uf;
    }

    public void setCreateEdgeOnGroupNodeLabelEnabled(boolean bl2) {
        this.uf = bl2;
    }

    public boolean isChildNodeCreationEnabled() {
        return this.mg;
    }

    public void setChildNodeCreationEnabled(boolean bl2) {
        this.mg = bl2;
    }

    public boolean isSelectOnGroupNodeLabelEnabled() {
        return this.wf;
    }

    public void setSelectOnGroupNodeLabelEnabled(boolean bl2) {
        this.wf = bl2;
    }

    static boolean b(d d2, bu bu2) {
        c c2 = aC.c(bu2);
        if (c2 == null) return false;
        if (!c2.d(d2)) return false;
        return true;
    }

    static p access$000(aC aC2) {
        return aC2.eg;
    }

    static c access$100(bu bu2) {
        return aC.c(bu2);
    }
}

