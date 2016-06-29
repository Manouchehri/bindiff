package y.h;

import y.g.*;
import java.beans.*;
import java.awt.event.*;
import java.awt.*;
import y.c.*;
import y.h.a.*;
import java.util.*;

public class aC extends gX
{
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
    private Cursor cg;
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
    boolean fg;
    boolean rg;
    boolean jg;
    boolean xe;
    boolean me;
    boolean ne;
    boolean qe;
    boolean re;
    boolean qf;
    boolean yf;
    boolean ag;
    boolean we;
    boolean ze;
    boolean vf;
    boolean lf;
    boolean cf;
    public static final Object ORTHOGONAL_ROUTING_DPKEY;
    private p eg;
    private boolean nf;
    private PropertyChangeListener og;
    private boolean sg;
    private boolean hf;
    private int pe;
    private boolean uf;
    private boolean mg;
    private boolean wf;
    private boolean gg;
    private cW of;
    private int lg;
    private static final int xf = 1;
    private static final int kg = 2;
    private static final int ff = 4;
    private static final int mf = 8;
    private static final int se = 16;
    private static final int ue = 32;
    private static final int hg = 64;
    private gX tf;
    
    public aC(final gU gu) {
        super(gu);
        this.cg = Cursor.getPredefinedCursor(0);
        this.fg = true;
        this.rg = true;
        this.jg = true;
        this.xe = true;
        this.me = true;
        this.ne = true;
        this.qe = true;
        this.re = false;
        this.qf = true;
        this.yf = true;
        this.ag = true;
        this.we = true;
        this.sg = true;
        this.hf = true;
        this.pe = 10;
        this.uf = true;
        this.wf = true;
        this.lg = 2;
        this.setName("EDIT_MODE");
        this.q();
    }
    
    public aC() {
        this.cg = Cursor.getPredefinedCursor(0);
        this.fg = true;
        this.rg = true;
        this.jg = true;
        this.xe = true;
        this.me = true;
        this.ne = true;
        this.qe = true;
        this.re = false;
        this.qf = true;
        this.yf = true;
        this.ag = true;
        this.we = true;
        this.sg = true;
        this.hf = true;
        this.pe = 10;
        this.uf = true;
        this.wf = true;
        this.lg = 2;
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
    
    public void setAdjustScrollBarPolicy(final boolean hf) {
        this.hf = hf;
    }
    
    public void setSnappingEnabled(final boolean b) {
        if (this.getHotSpotMode() instanceof da) {
            ((da)this.getHotSpotMode()).a(b);
        }
        if (this.getMoveSelectionMode() instanceof dP) {
            final dP dp = (dP)this.getMoveSelectionMode();
            dp.a(b);
            dp.c().f(b);
            dp.c().c(b);
        }
        if (this.getOrthogonalMoveBendsMode() instanceof fu) {
            final fu fu = (fu)this.getOrthogonalMoveBendsMode();
            fu.a(b);
            fu.c().a(b);
        }
        if (this.getCreateEdgeMode() instanceof F) {
            final F f = (F)this.getCreateEdgeMode();
            f.a(b ? 5.0 : 0.0);
            f.a(b);
        }
        if (this.getMovePortMode() instanceof dI) {
            ((dI)this.getMovePortMode()).a(b);
        }
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
    
    public void activate(final boolean b) {
        final boolean z = fj.z;
        Label_0088: {
            if (!b) {
                gX gx = this.getChild();
                while (true) {
                    while (gx != null) {
                        gx.activate(b);
                        gx = gx.getChild();
                        if (!z) {
                            if (z) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (this.og != null) {
                                this.view.removePropertyChangeListener("Graph2D", this.og);
                                this.og = null;
                            }
                            break Label_0088;
                        }
                    }
                    if (this.getGraph2D().c(aC.ORTHOGONAL_ROUTING_DPKEY) == this.eg) {
                        this.getGraph2D().d_(aC.ORTHOGONAL_ROUTING_DPKEY);
                    }
                    continue;
                }
            }
        }
        super.activate(b);
        if (b) {
            this.prepareView(this.view);
            if (c(this.getGraph2D()) == null) {
                this.og = new aD(this);
                this.view.addPropertyChangeListener("Graph2D", this.og);
                this.getGraph2D().a(aC.ORTHOGONAL_ROUTING_DPKEY, this.eg = new aE(this));
            }
        }
    }
    
    public void cancelEditing() {
        final boolean z = fj.z;
        gX gx = this.getChild();
        while (gx != null) {
            if (gx.isEditing()) {
                gx.cancelEditing();
            }
            gx = gx.getChild();
            if (z) {
                break;
            }
        }
        super.cancelEditing();
    }
    
    public void setChild(final gX gx, final MouseEvent mouseEvent, final MouseEvent mouseEvent2, final MouseEvent mouseEvent3) {
        final gX child = this.getChild();
        super.setChild(gx, mouseEvent, mouseEvent2, mouseEvent3);
        if (child != null && gx == null && !this.gg) {
            this.gg = true;
            try {
                final MouseEvent p4 = this.view.p();
                if (p4 != null && p4.getID() != 505) {
                    this.mouseMoved(new MouseEvent(this.view.getCanvasComponent(), 503, p4.getWhen() + 1L, 0, p4.getX(), p4.getY(), 0, false));
                }
            }
            finally {
                this.gg = false;
            }
        }
    }
    
    protected void prepareView(final ch ch) {
        if (this.hf) {
            ch.setScrollBarPolicy(20, 30);
        }
        ch.setViewCursor(this.getDefaultCursor());
        ch.updateView();
    }
    
    public void setMixedSelectionEnabled(final boolean lf) {
        this.lf = lf;
    }
    
    public boolean isMixedSelectionEnabled() {
        return this.lf;
    }
    
    public void setOrthogonalEdgeRouting(final boolean nf) {
        this.nf = nf;
    }
    
    public boolean isOrthogonalEdgeRouting() {
        return this.nf;
    }
    
    public void assignNodeLabel(final boolean yf) {
        this.yf = yf;
    }
    
    public void allowNodeCreation(final boolean fg) {
        this.fg = fg;
    }
    
    public void allowNodeEditing(final boolean ag) {
        this.ag = ag;
    }
    
    public void allowEdgeCreation(final boolean rg) {
        this.rg = rg;
    }
    
    public void allowBendCreation(final boolean jg) {
        this.jg = jg;
        if (this.createEdgeMode instanceof F) {
            ((F)this.createEdgeMode).b(jg);
        }
    }
    
    public void allowMoveSelection(final boolean me) {
        this.me = me;
    }
    
    public void allowMoveLabels(final boolean xe) {
        this.xe = xe;
    }
    
    public void allowMovePorts(final boolean qf) {
        this.qf = qf;
    }
    
    public void allowLabelSelection(final boolean sg) {
        this.sg = sg;
    }
    
    public void allowMoving(final boolean qe) {
        this.qe = qe;
    }
    
    public void allowMovingWithPopup(final boolean re) {
        this.re = re;
    }
    
    public void allowResizeNodes(final boolean ne) {
        this.ne = ne;
    }
    
    public void allowMouseInput(final boolean we) {
        this.we = we;
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
        return this.qe && this.popupMode == null;
    }
    
    public boolean doAllowMovingWithPopup() {
        return this.re;
    }
    
    public boolean doAllowResizeNodes() {
        return this.ne;
    }
    
    public void showNodeTips(final boolean ze) {
        this.ze = ze;
        if (!this.ze && this.view != null) {
            this.view.setToolTipText(null);
        }
    }
    
    public boolean doShowNodeTips() {
        return this.ze;
    }
    
    public void showEdgeTips(final boolean vf) {
        this.vf = vf;
        if (!this.vf && this.view != null) {
            this.view.setToolTipText(null);
        }
    }
    
    public boolean doShowEdgeTips() {
        return this.vf;
    }
    
    public void setCyclicSelectionEnabled(final boolean cf) {
        if (!(this.cf = cf)) {
            this.of = null;
        }
    }
    
    public boolean isCyclicSelectionEnabled() {
        return this.cf;
    }
    
    public void setCyclicSelectionModifierMask(final int lg) {
        this.lg = lg;
    }
    
    public int getCyclicSelectionModifierMask() {
        return this.lg;
    }
    
    public gX getEditNodeMode() {
        return this.editNodeMode;
    }
    
    public void setEditNodeMode(final gX editNodeMode) {
        this.editNodeMode = editNodeMode;
    }
    
    public gX getPopupMode() {
        return this.popupMode;
    }
    
    public void setPopupMode(final gX popupMode) {
        this.popupMode = popupMode;
    }
    
    public gX getMoveSelectionMode() {
        return this.moveSelectionMode;
    }
    
    public void setMoveSelectionMode(final gX moveSelectionMode) {
        this.moveSelectionMode = moveSelectionMode;
    }
    
    public dz getMouseInputMode() {
        return this.mouseInputMode;
    }
    
    public void setMouseInputMode(final dz mouseInputMode) {
        this.mouseInputMode = mouseInputMode;
    }
    
    public gX getCreateEdgeMode() {
        return this.createEdgeMode;
    }
    
    public void setCreateEdgeMode(final gX createEdgeMode) {
        this.createEdgeMode = createEdgeMode;
    }
    
    public gX getSelectionBoxMode() {
        return this.selectionBoxMode;
    }
    
    public void setSelectionBoxMode(final gX selectionBoxMode) {
        this.selectionBoxMode = selectionBoxMode;
    }
    
    public void mousePressedLeft(final double n, final double n2) {
        this.j(n, n2);
    }
    
    public void mouseShiftPressedLeft(final double n, final double n2) {
        this.j(n, n2);
    }
    
    public void mouseReleasedLeft(final double n, final double n2) {
        final boolean z = fj.z;
        final bu graph2D = this.getGraph2D();
        if (!this.af) {
            Label_0352: {
                switch (this.zf) {
                    case 7: {
                        this.labelClicked(graph2D, this.getLastHitInfo().l(), false, n, n2, false);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 8: {
                        this.labelClicked(graph2D, this.getLastHitInfo().m(), false, n, n2, false);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 9: {
                        this.labelClicked(graph2D, this.getLastHitInfo().l(), true, n, n2, false);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 10: {
                        this.labelClicked(graph2D, this.getLastHitInfo().m(), true, n, n2, false);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 0: {
                        this.paperClicked(graph2D, n, n2, false);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 1: {
                        this.nodeClicked(graph2D, this.getLastHitInfo().i(), false, n, n2, false);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 3: {
                        this.bendClicked(graph2D, this.getLastHitInfo().j(), false, n, n2, false);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 5: {
                        this.edgeClicked(graph2D, this.getLastHitInfo().k(), false, n, n2, false);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 2: {
                        this.nodeClicked(graph2D, this.getLastHitInfo().i(), true, n, n2, false);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 6: {
                        this.edgeClicked(graph2D, this.getLastHitInfo().k(), true, n, n2, false);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 4: {
                        this.bendClicked(graph2D, this.getLastHitInfo().j(), true, n, n2, false);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 13: {
                        this.nodePortClicked(graph2D, this.getLastHitInfo().o(), false, n, n2, false);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 14: {
                        this.nodePortClicked(graph2D, this.getLastHitInfo().o(), true, n, n2, false);
                        break;
                    }
                }
            }
        }
    }
    
    private void p() {
        if (this.isCyclicSelectionEnabled() && this.isCyclicSelectionModifierPressed()) {
            this.beforeSelectionCycling(this.of.d());
        }
    }
    
    protected void labelClicked(final bu bu, final gZ gz, final boolean b, final double n, final double n2, final boolean b2) {
        final boolean z = fj.z;
        final boolean doAllowLabelSelection = this.doAllowLabelSelection();
        if (b2 && doAllowLabelSelection) {
            this.p();
            Label_0068: {
                if (b) {
                    this.setSelected(bu, gz, false);
                    if (!z) {
                        break Label_0068;
                    }
                }
                if (this.isMixedSelectionEnabled() || !this.b(bu, -49)) {
                    this.setSelected(bu, gz, true);
                }
            }
            bu.T();
            if (!z) {
                return;
            }
        }
        this.labelClicked(gz);
        if (!b && doAllowLabelSelection) {
            this.unselectAll(bu);
            this.setSelected(bu, gz, true);
            bu.T();
        }
    }
    
    protected void labelClicked(final gZ gz) {
    }
    
    public void mouseShiftReleasedLeft(final double n, final double n2) {
        final boolean z = fj.z;
        final bu graph2D = this.getGraph2D();
        if (!this.af) {
            Label_0352: {
                switch (this.zf) {
                    case 7: {
                        this.labelClicked(graph2D, this.getLastHitInfo().l(), false, n, n2, true);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 8: {
                        this.labelClicked(graph2D, this.getLastHitInfo().m(), false, n, n2, true);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 9: {
                        this.labelClicked(graph2D, this.getLastHitInfo().l(), true, n, n2, true);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 10: {
                        this.labelClicked(graph2D, this.getLastHitInfo().m(), true, n, n2, true);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 0: {
                        this.paperClicked(graph2D, n, n2, true);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 1: {
                        this.nodeClicked(graph2D, this.getLastHitInfo().i(), false, n, n2, true);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 3: {
                        this.bendClicked(graph2D, this.getLastHitInfo().j(), false, n, n2, true);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 5: {
                        this.edgeClicked(graph2D, this.getLastHitInfo().k(), false, n, n2, true);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 6: {
                        this.edgeClicked(graph2D, this.getLastHitInfo().k(), true, n, n2, true);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 4: {
                        this.bendClicked(graph2D, this.getLastHitInfo().j(), true, n, n2, true);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 2: {
                        this.nodeClicked(graph2D, this.getLastHitInfo().i(), true, n, n2, true);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 13: {
                        this.nodePortClicked(graph2D, this.getLastHitInfo().o(), false, n, n2, true);
                        if (z) {
                            break Label_0352;
                        }
                        break;
                    }
                    case 14: {
                        this.nodePortClicked(graph2D, this.getLastHitInfo().o(), true, n, n2, true);
                        break;
                    }
                }
            }
        }
    }
    
    protected void nodePortClicked(final bu bu, final eU eu, final boolean b, final double n, final double n2, final boolean b2) {
        final boolean z = fj.z;
        if (b2) {
            Label_0053: {
                if (b) {
                    this.setSelected(bu, eu, false);
                    if (!z) {
                        break Label_0053;
                    }
                }
                if (this.isMixedSelectionEnabled() || !this.b(bu, -65)) {
                    this.setSelected(bu, eu, true);
                }
            }
            bu.T();
            if (!z) {
                return;
            }
        }
        if (!b) {
            this.unselectAll(bu);
            this.setSelected(bu, eu, true);
            bu.T();
        }
    }
    
    private boolean b(final bu bu, final int n) {
        final boolean z = fj.z;
        final boolean b = (n & 0x1) == 0x1;
        final boolean b2 = (n & 0x10) == 0x10;
        final boolean b3 = (n & 0x40) == 0x40;
        int n2 = 0;
        Label_0256: {
            if (b || b2 || b3) {
                final x o = bu.o();
                do {
                    Label_0070: {
                        o.f();
                    }
                    boolean b4 = false;
                    Label_0077:
                    while (b4) {
                        final q e = o.e();
                        final boolean b5 = (n2 = (b ? 1 : 0)) != 0;
                        if (z) {
                            break Label_0256;
                        }
                        if (b5 && this.isSelected(bu, e)) {
                            return true;
                        }
                        boolean selected = false;
                        if (b2) {
                            final fj t = bu.t(e);
                            if (t.labelCount() > 0) {
                                int i = 0;
                                while (i < t.labelCount()) {
                                    selected = this.isSelected(bu, t.getLabel(i));
                                    if (z) {
                                        break;
                                    }
                                    if (selected) {
                                        return true;
                                    }
                                    ++i;
                                    if (z) {
                                        break;
                                    }
                                }
                            }
                        }
                        if (selected) {
                            final fj t2 = bu.t(e);
                            if (t2.portCount() > 0) {
                                final Iterator ports = t2.ports();
                                while (ports.hasNext()) {
                                    if (this.isSelected(bu, ports.next())) {
                                        b4 = true;
                                        if (!z) {
                                            return b4;
                                        }
                                        continue Label_0077;
                                    }
                                }
                            }
                        }
                        o.g();
                        continue Label_0070;
                    }
                    break;
                } while (!z);
            }
            n2 = (n & 0x2);
        }
        final boolean b6 = n2 == 2 || (n & 0x4) == 0x4;
        final boolean b7 = (n & 0x20) == 0x20;
        final boolean b8 = (n & 0x8) == 0x8;
        boolean b9 = false;
        if (b6 || b7 || b8) {
            final e p2 = bu.p();
            do {
                Label_0327: {
                    p2.f();
                }
                boolean selected2 = false;
                Label_0334:
                while (selected2) {
                    final d a = p2.a();
                    b9 = b6;
                    if (z) {
                        break;
                    }
                    if (b9 && this.isSelected(bu, a)) {
                        return true;
                    }
                    boolean selected3 = false;
                    if (b7) {
                        final aB j = bu.i(a);
                        if (j.labelCount() > 0) {
                            int k = 0;
                            while (k < j.labelCount()) {
                                selected3 = this.isSelected(bu, j.getLabel(k));
                                if (z) {
                                    break;
                                }
                                if (selected3) {
                                    return true;
                                }
                                ++k;
                                if (z) {
                                    break;
                                }
                            }
                        }
                    }
                    if (selected3) {
                        final aB l = bu.i(a);
                        if (l.bendCount() > 0) {
                            final y bends = l.bends();
                            while (bends.f()) {
                                selected2 = this.isSelected(bu, bends.a());
                                if (z) {
                                    continue Label_0334;
                                }
                                if (selected2) {
                                    return true;
                                }
                                bends.g();
                                if (z) {
                                    break;
                                }
                            }
                        }
                    }
                    p2.g();
                    continue Label_0327;
                }
                break;
            } while (!z);
        }
        return b9;
    }
    
    protected void nodeClicked(final bu bu, final q q, final boolean b, final double n, final double n2, final boolean b2) {
        final boolean z = fj.z;
        if (!this.isChildNodeCreationEnabled() || !this.b(bu, q) || this.isGroupNodeBorderHit(bu, q, n, n2, this.isSelectOnGroupNodeLabelEnabled())) {
            this.p();
            if (b2) {
                Label_0090: {
                    if (b) {
                        this.setSelected(bu, q, false);
                        if (!z) {
                            break Label_0090;
                        }
                    }
                    if (this.isMixedSelectionEnabled() || !this.b(bu, -10)) {
                        this.setSelected(bu, q, true);
                    }
                }
                bu.T();
                if (!z) {
                    return;
                }
            }
            this.nodeClicked(q);
            if (b) {
                return;
            }
            this.unselectAll(bu);
            this.setSelected(bu, q, true);
            bu.T();
            if (!z) {
                return;
            }
        }
        this.nodeClicked(q);
    }
    
    protected void beforeSelectionCycling(final C c) {
        final boolean z = fj.z;
        if (c != null && c.f()) {
            final bu graph2D = this.getGraph2D();
            c.g();
            while (c.f()) {
                this.b(graph2D, c.d(), false);
                c.g();
                if (z) {
                    return;
                }
                if (z) {
                    break;
                }
            }
            graph2D.T();
        }
    }
    
    protected boolean isGroupNodeBorderHit(final bu bu, final q q, final double n, final double n2, final boolean b) {
        final boolean z = fj.z;
        if (this.b(bu, q)) {
            final fj t = bu.t(q);
            if (b) {
                final C g = this.createLabelHitInfo(n, n2).g();
                while (g.f()) {
                    final eR er = (eR)g.d();
                    if (z) {
                        return false;
                    }
                    if (er.f() == q && t.getLabel(0) == er) {
                        return true;
                    }
                    g.g();
                    if (z) {
                        break;
                    }
                }
            }
            final int groupBorderWidth = this.getGroupBorderWidth();
            if (n < t.getX() + groupBorderWidth || n > t.getX() + t.getWidth() - groupBorderWidth || n2 < t.getY() + groupBorderWidth || n2 > t.getY() + t.getHeight() - groupBorderWidth) {
                return true;
            }
        }
        return false;
    }
    
    private boolean b(final bu bu, final q q) {
        final v a = v.a(bu);
        return a != null && a.k(q);
    }
    
    protected void bendClicked(final bu bu, final y.h.x x, final boolean b, final double n, final double n2, final boolean b2) {
        final boolean z = fj.z;
        this.p();
        if (b2) {
            Label_0101: {
                if (b) {
                    this.setSelected(bu, x, false);
                    if (!z) {
                        break Label_0101;
                    }
                }
                if (!this.isMixedSelectionEnabled() && this.b(bu, 2)) {
                    this.setSelected(bu, x.a(), !this.isSelected(bu, x.a()));
                    if (!z) {
                        break Label_0101;
                    }
                }
                if (this.isMixedSelectionEnabled() || !this.b(bu, -10)) {
                    this.setSelected(bu, x, true);
                }
            }
            bu.T();
            if (!z) {
                return;
            }
        }
        if (!b) {
            this.unselectAll(bu);
            this.setSelected(bu, x, true);
            bu.T();
        }
    }
    
    protected void edgeClicked(final bu bu, final d d, final boolean b, final double n, final double n2, final boolean b2) {
        final boolean z = fj.z;
        this.p();
        if (b2) {
            Label_0249: {
                Label_0245: {
                    if (b) {
                        this.setSelected(bu, d, false);
                        if (!z) {
                            break Label_0245;
                        }
                    }
                    Label_0221: {
                        if (!this.isMixedSelectionEnabled() && this.b(bu, 9)) {
                            final aB i = bu.i(d);
                            if (i.bendCount() > 0) {
                                int n3 = 0;
                                final y bends = i.bends();
                                while (true) {
                                    while (bends.f()) {
                                        final int selected;
                                        final boolean b3 = (selected = (this.isSelected(bu, bends.a()) ? 1 : 0)) != 0;
                                        if (z) {
                                            Label_0174: {
                                                if (selected == i.bendCount()) {
                                                    final y bends2 = i.bends();
                                                    while (bends2.f()) {
                                                        this.setSelected(bu, bends2.a(), false);
                                                        bends2.g();
                                                        if (z) {
                                                            break Label_0249;
                                                        }
                                                        if (z) {
                                                            break Label_0174;
                                                        }
                                                    }
                                                    break Label_0245;
                                                }
                                            }
                                            final y bends3 = i.bends();
                                            while (bends3.f()) {
                                                this.setSelected(bu, bends3.a(), true);
                                                bends3.g();
                                                if (z) {
                                                    break Label_0249;
                                                }
                                                if (z) {
                                                    break Label_0221;
                                                }
                                            }
                                            break Label_0245;
                                        }
                                        if (b3) {
                                            ++n3;
                                        }
                                        bends.g();
                                        if (z) {
                                            break;
                                        }
                                    }
                                    int selected = n3;
                                    continue;
                                }
                            }
                            break Label_0245;
                        }
                    }
                    if (this.isMixedSelectionEnabled() || !this.b(bu, -7)) {
                        this.setSelected(bu, d, true);
                    }
                }
                bu.T();
            }
            if (!z) {
                return;
            }
        }
        if (!b) {
            this.unselectAll(bu);
            this.setSelected(bu, d, true);
            bu.T();
        }
    }
    
    protected void paperClicked(final bu bu, final double n, final double n2, final boolean b) {
        if (!b) {
            if (!this.isCyclicSelectionEnabled() || !this.isCyclicSelectionModifierPressed()) {
                if (!this.isSelectionEmpty(bu)) {
                    this.unselectAll(bu);
                    bu.T();
                    if (!fj.z) {
                        return;
                    }
                }
                if (this.doAllowNodeCreation()) {
                    this.setEditing(true);
                    final q node = this.createNode(bu, n, n2);
                    if (node != null) {
                        bu.T();
                        this.nodeCreated(node);
                    }
                    this.setEditing(false);
                }
            }
        }
    }
    
    public void mousePressed(final MouseEvent mouseEvent) {
        if (this.getChild() != null) {
            this.zf = -1;
        }
        super.mousePressed(mouseEvent);
    }
    
    public void mouseDraggedLeft(final double n, final double n2) {
        final boolean z = fj.z;
        final bu graph2D = this.getGraph2D();
        this.getHitInfo(n, n2);
        final boolean b = !this.af;
        this.af = true;
        Label_0430: {
            switch (this.zf) {
                default: {
                    if (z) {
                        break Label_0430;
                    }
                    break;
                }
                case 0: {
                    this.paperDragged(graph2D, n, n2, b);
                    if (z) {
                        break Label_0430;
                    }
                    break;
                }
                case 1: {
                    this.nodeDragged(graph2D, this.te.i(), false, n, n2, b);
                    if (z) {
                        break Label_0430;
                    }
                    break;
                }
                case 2: {
                    this.nodeDragged(graph2D, this.te.i(), true, n, n2, b);
                    if (z) {
                        break Label_0430;
                    }
                    break;
                }
                case 3: {
                    this.bendDragged(graph2D, this.te.j(), false, n, n2, b);
                    if (z) {
                        break Label_0430;
                    }
                    break;
                }
                case 4: {
                    this.bendDragged(graph2D, this.te.j(), true, n, n2, b);
                    if (z) {
                        break Label_0430;
                    }
                    break;
                }
                case 7: {
                    this.labelDragged(graph2D, this.te.l(), false, n, n2, b);
                    if (z) {
                        break Label_0430;
                    }
                    break;
                }
                case 9: {
                    this.labelDragged(graph2D, this.te.l(), true, n, n2, b);
                    if (z) {
                        break Label_0430;
                    }
                    break;
                }
                case 8: {
                    this.labelDragged(graph2D, this.te.m(), false, n, n2, b);
                    if (z) {
                        break Label_0430;
                    }
                    break;
                }
                case 10: {
                    this.labelDragged(graph2D, this.te.m(), true, n, n2, b);
                    if (z) {
                        break Label_0430;
                    }
                    break;
                }
                case 5: {
                    this.edgeDragged(graph2D, this.te.k(), false, n, n2, b);
                    if (z) {
                        break Label_0430;
                    }
                    break;
                }
                case 6: {
                    this.edgeDragged(graph2D, this.te.k(), true, n, n2, b);
                    if (z) {
                        break Label_0430;
                    }
                    break;
                }
                case 11: {
                    this.hotSpotDragged(graph2D, n, n2, b);
                    if (z) {
                        break Label_0430;
                    }
                    break;
                }
                case 12: {
                    this.portDragged(graph2D, this.te.n(), n, n2, b);
                    if (z) {
                        break Label_0430;
                    }
                    break;
                }
                case 13: {
                    this.nodePortDragged(graph2D, this.te.o(), false, n, n2, b);
                    if (z) {
                        break Label_0430;
                    }
                    break;
                }
                case 14: {
                    this.nodePortDragged(graph2D, this.te.o(), true, n, n2, b);
                    break;
                }
            }
        }
    }
    
    protected void bendDragged(final bu bu, final y.h.x x, final boolean b, final double n, final double n2, final boolean b2) {
        final boolean z = fj.z;
        if (b) {
            if (!b2) {
                return;
            }
            final gX moveSelectionMode = this.getMoveSelectionMode();
            if (this.isSelectionEmpty(bu) || !this.doAllowMoveSelection() || moveSelectionMode == null) {
                return;
            }
            this.setChild(moveSelectionMode, this.lastPressEvent, this.lastDragEvent);
            if (!z) {
                return;
            }
        }
        if (b2) {
            Label_0091: {
                if (this.isMixedSelectionEnabled()) {
                    this.unselectNodes(bu);
                    this.unselectBends(bu);
                    if (!z) {
                        break Label_0091;
                    }
                }
                this.unselectAll(bu);
            }
            this.setSelected(bu, x, true);
            final gX moveSelectionMode2 = this.getMoveSelectionMode();
            if (this.doAllowMoveSelection() && moveSelectionMode2 != null) {
                this.setChild(moveSelectionMode2, this.lastPressEvent, this.lastDragEvent);
            }
        }
    }
    
    protected void edgeDragged(final bu bu, final d d, final boolean b, final double n, final double n2, final boolean b2) {
        if (b2 && d != null && this.isOrthogonalRouting(d) && this.doAllowMoveSelection()) {
            this.setChild(this.getOrthogonalMoveBendsMode(), this.lastPressEvent, this.lastDragEvent);
            return;
        }
        if (b2 && this.doAllowBendCreation()) {
            this.unselectAll(bu);
            bu.T();
            bu.a(new f(d).a());
            final y.h.x bend = this.createBend(bu, d, this.ve, this.ef);
            if (bend != null) {
                this.setSelected(bu, bend, true);
                this.bendCreated(bu, d, bend, this.ve, this.ef);
                if (this.doAllowMoveSelection()) {
                    this.setChild(this.getMoveSelectionMode(), this.lastPressEvent, this.lastDragEvent);
                }
            }
        }
    }
    
    protected void hotSpotDragged(final bu bu, final double n, final double n2, final boolean b) {
        final gX hotSpotMode = this.getHotSpotMode();
        if (hotSpotMode != null) {
            this.setChild(hotSpotMode, this.lastPressEvent, this.lastDragEvent);
        }
    }
    
    protected void labelDragged(final bu bu, final aA aa, final boolean b, final double n, final double n2, final boolean b2) {
        final gX moveLabelMode = this.getMoveLabelMode();
        if (b2 && this.doAllowMoveLabels() && moveLabelMode != null) {
            this.setChild(moveLabelMode, this.lastPressEvent, this.lastDragEvent);
        }
    }
    
    protected void labelDragged(final bu bu, final eR er, final boolean b, final double n, final double n2, final boolean b2) {
        final gX moveLabelMode = this.getMoveLabelMode();
        if (b2 && this.doAllowMoveLabels() && moveLabelMode != null) {
            this.setChild(moveLabelMode, this.lastPressEvent, this.lastDragEvent);
        }
    }
    
    protected void nodeDragged(final bu bu, final q q, final boolean b, final double n, final double n2, final boolean b2) {
        final boolean z = fj.z;
        if (b) {
            if (!b2) {
                return;
            }
            final gX moveSelectionMode = this.getMoveSelectionMode();
            if (this.isSelectionEmpty(bu) || !this.doAllowMoveSelection() || moveSelectionMode == null) {
                return;
            }
            this.setChild(moveSelectionMode, this.lastPressEvent, this.lastDragEvent);
            if (!z) {
                return;
            }
        }
        final gX selectionBoxMode = this.getSelectionBoxMode();
        if (!this.isCreateEdgeGesture(this.lastPressEvent, this.lastDragEvent) && selectionBoxMode != null) {
            this.setChild(selectionBoxMode, this.lastPressEvent, this.lastDragEvent);
            if (!z) {
                return;
            }
        }
        final gX createEdgeMode = this.getCreateEdgeMode();
        if (this.doAllowEdgeCreation() && createEdgeMode != null) {
            this.setChild(createEdgeMode, this.lastPressEvent, this.lastDragEvent);
            if (!z) {
                return;
            }
        }
        if (!this.doAllowEdgeCreation() && b2) {
            final gX moveSelectionMode2 = this.getMoveSelectionMode();
            if (this.doAllowMoveSelection() && moveSelectionMode2 != null) {
                this.unselectAll(bu);
                this.setSelected(bu, q, true);
                this.setChild(moveSelectionMode2, this.lastPressEvent, this.lastDragEvent);
            }
        }
    }
    
    protected void nodePortDragged(final bu bu, final eU eu, final boolean b, final double n, final double n2, final boolean b2) {
        final boolean z = fj.z;
        if (b) {
            if (!b2) {
                return;
            }
            final gX moveNodePortMode = this.getMoveNodePortMode();
            if (moveNodePortMode == null) {
                return;
            }
            this.setChild(moveNodePortMode, this.lastPressEvent, this.lastDragEvent);
            if (!z) {
                return;
            }
        }
        final gX selectionBoxMode = this.getSelectionBoxMode();
        if (!this.isCreateEdgeGesture(this.lastPressEvent, this.lastDragEvent) && selectionBoxMode != null) {
            this.setChild(selectionBoxMode, this.lastPressEvent, this.lastDragEvent);
            if (!z) {
                return;
            }
        }
        final gX createEdgeMode = this.getCreateEdgeMode();
        if (this.doAllowEdgeCreation() && createEdgeMode != null) {
            this.setChild(createEdgeMode, this.lastPressEvent, this.lastDragEvent);
            if (!z) {
                return;
            }
        }
        if (!this.doAllowEdgeCreation() && b2) {
            final gX moveNodePortMode2 = this.getMoveNodePortMode();
            if (moveNodePortMode2 != null) {
                this.unselectAll(bu);
                this.setSelected(bu, eu, true);
                this.setChild(moveNodePortMode2, this.lastPressEvent, this.lastDragEvent);
            }
        }
    }
    
    protected void paperDragged(final bu bu, final double n, final double n2, final boolean b) {
        final gX selectionBoxMode = this.getSelectionBoxMode();
        if (selectionBoxMode != null) {
            this.setChild(selectionBoxMode, this.lastPressEvent, this.lastDragEvent);
        }
    }
    
    protected void portDragged(final bu bu, final fL fl, final double n, final double n2, final boolean b) {
        final gX movePortMode = this.getMovePortMode();
        if (this.doAllowMovePorts() && movePortMode != null) {
            this.setChild(movePortMode, this.lastPressEvent, this.lastDragEvent);
        }
    }
    
    protected void setSelected(final bu bu, final eU eu, final boolean b) {
        bu.a(eu, b);
    }
    
    protected void setSelected(final bu bu, final q q, final boolean b) {
        if (b) {
            y.h.gg.a(bu, q);
            if (!fj.z) {
                return;
            }
        }
        y.h.gg.b(bu, q);
    }
    
    protected void setSelected(final bu bu, final gZ gz, final boolean b) {
        bu.a(gz, b);
    }
    
    protected void setSelected(final bu bu, final d d, final boolean b) {
        bu.a(d, b);
    }
    
    protected void setSelected(final bu bu, final y.h.x x, final boolean b) {
        bu.a(x, b);
    }
    
    private void b(final bu bu, final Object o, final boolean b) {
        final boolean z = fj.z;
        if (o instanceof q) {
            this.setSelected(bu, (q)o, b);
            if (!z) {
                return;
            }
        }
        if (o instanceof d) {
            this.setSelected(bu, (d)o, b);
            if (!z) {
                return;
            }
        }
        if (o instanceof y.h.x) {
            this.setSelected(bu, (y.h.x)o, b);
            if (!z) {
                return;
            }
        }
        if (o instanceof gZ) {
            this.setSelected(bu, (gZ)o, b);
            if (!z) {
                return;
            }
        }
        if (o instanceof eU) {
            this.setSelected(bu, (eU)o, b);
        }
    }
    
    protected void unselectNodes(final bu bu) {
        bu.O();
    }
    
    protected void unselectBends(final bu bu) {
        bu.Q();
    }
    
    protected void unselectAll(final bu bu) {
        bu.N();
    }
    
    protected boolean isSelectionEmpty(final bu bu) {
        return bu.H();
    }
    
    protected boolean isSelected(final bu bu, final y.h.x x) {
        return bu.a(x);
    }
    
    protected boolean isSelected(final bu bu, final d d) {
        return bu.r(d);
    }
    
    protected boolean isSelected(final bu bu, final gZ gz) {
        return bu.a(gz);
    }
    
    protected boolean isSelected(final bu bu, final q q) {
        return bu.v(q);
    }
    
    protected boolean isSelected(final bu bu, final eU eu) {
        return bu.a(eu);
    }
    
    private boolean b(final bu bu, final Object o) {
        if (o instanceof q) {
            return this.isSelected(bu, (q)o);
        }
        if (o instanceof d) {
            return this.isSelected(bu, (d)o);
        }
        if (o instanceof y.h.x) {
            return this.isSelected(bu, (y.h.x)o);
        }
        if (o instanceof gZ) {
            return this.isSelected(bu, (gZ)o);
        }
        return o instanceof eU && this.isSelected(bu, (eU)o);
    }
    
    protected boolean isOrthogonalRouting(final d d) {
        final c c = c(this.getGraph2D());
        if (c != null && c != this.eg) {
            return c.d(d);
        }
        return this.nf;
    }
    
    private static c c(final bu bu) {
        c c = bu.c(aC.ORTHOGONAL_ROUTING_DPKEY);
        if (c == null && bu.C() != null && bu.C().g() != bu) {
            c = bu.C().g().c(aC.ORTHOGONAL_ROUTING_DPKEY);
        }
        return c;
    }
    
    protected y.h.x createBend(final bu bu, final d d, final double n, final double n2) {
        return bu.i(d).insertBend(n, n2);
    }
    
    protected q createNode(final bu bu, final double n, final double n2) {
        return this.createNode(bu, n, n2, null);
    }
    
    protected q createNode(final bu bu, final double n, final double n2, final q q) {
        final q a = bu.a(this.getGridX(n), this.getGridY(n2));
        this.configureNode(bu, a);
        if (q != null) {
            final v a2 = v.a(bu);
            if (a2 != null) {
                final a autoBoundsFeature = bu.t(q).getAutoBoundsFeature();
                final boolean b = autoBoundsFeature != null && autoBoundsFeature.isAutoBoundsEnabled();
                if (b) {
                    bu.a(new y.c.y(q).a());
                    autoBoundsFeature.setAutoBoundsEnabled(false);
                }
                try {
                    a2.c(a, q);
                }
                finally {
                    if (b) {
                        autoBoundsFeature.setAutoBoundsEnabled(true);
                    }
                }
            }
        }
        bu.T();
        return a;
    }
    
    protected void configureNode(final bu bu, final q q) {
        if (this.doAssignNodeLabel() && bu.t(q).labelCount() > 0 && "".equals(bu.u(q))) {
            bu.a(q, Integer.toString(bu.f()));
        }
    }
    
    public void mousePressedRight(final double n, final double n2) {
        final boolean z = fj.z;
        if (this.doAllowMovingWithPopup()) {
            this.df = false;
            if (!z) {
                return;
            }
        }
        if (this.doAllowMoving()) {
            final gX moveViewPortMode = this.getMoveViewPortMode();
            if (moveViewPortMode == null) {
                return;
            }
            this.setChild(moveViewPortMode, this.lastPressEvent, null);
            if (!z) {
                return;
            }
        }
        final gX popupMode = this.getPopupMode();
        if (popupMode != null) {
            this.setChild(popupMode, this.lastPressEvent, null);
        }
    }
    
    public void mouseDraggedRight(final double n, final double n2) {
        if (this.doAllowMovingWithPopup()) {
            final gX moveViewPortMode = this.getMoveViewPortMode();
            if (moveViewPortMode != null) {
                this.df = true;
                this.setChild(moveViewPortMode, this.lastPressEvent, this.lastDragEvent);
            }
        }
    }
    
    public void mouseReleasedRight(final double n, final double n2) {
        if (this.doAllowMovingWithPopup()) {
            if (this.df) {
                this.df = false;
                if (!fj.z) {
                    return;
                }
            }
            final gX popupMode = this.getPopupMode();
            if (popupMode != null) {
                this.setChild(popupMode, this.lastPressEvent, null, this.lastReleaseEvent);
            }
        }
    }
    
    public void mouseMoved(final double n, final double n2) {
        final bu graph2D = this.getGraph2D();
        final cW hitInfo = this.getHitInfo(n, n2);
        final dz mouseInputMode = this.getMouseInputMode();
        if (this.doAllowMouseInput() && mouseInputMode != null) {
            final dx a = mouseInputMode.a(this.view, n, n2, hitInfo);
            if (a != null) {
                mouseInputMode.a(a);
                this.view.setToolTipText(null);
                this.view.setViewCursor(this.getDefaultCursor());
                this.setChild(mouseInputMode, null, null, null);
                mouseInputMode.mouseMoved(this.lastMoveEvent);
                return;
            }
        }
        if (this.doShowEdgeTips() || this.doShowNodeTips()) {
            String toolTipText = null;
            if (hitInfo.i() != null) {
                if (this.doShowNodeTips()) {
                    toolTipText = this.getNodeTip(hitInfo.i());
                }
            }
            else if (hitInfo.k() != null && this.doShowEdgeTips()) {
                toolTipText = this.getEdgeTip(hitInfo.k());
            }
            if (toolTipText != null && toolTipText.length() < 1) {
                toolTipText = null;
            }
            this.view.setToolTipText(toolTipText);
        }
        if (this.doAllowResizeNodes()) {
            final byte b = this.b(this.view, graph2D, n, n2);
            if (b != 8) {
                this.view.setViewCursor(da.a(b));
                return;
            }
        }
        if (this.doAllowMoveSelection()) {
            final q i = hitInfo.i();
            if (i != null && this.isSelected(graph2D, i)) {
                this.view.setViewCursor(Cursor.getPredefinedCursor(13));
                return;
            }
        }
        if (this.doAllowBendCreation() && hitInfo.k() != null) {
            this.view.setViewCursor(Cursor.getPredefinedCursor(12));
            return;
        }
        if (this.doAllowMovePorts() && hitInfo.n() != null && this.getMovePortMode() instanceof dI) {
            this.view.setViewCursor(((dI)this.getMovePortMode()).h());
            return;
        }
        this.view.setViewCursor(this.getDefaultCursor());
    }
    
    private byte b(final ch ch, final bu bu, final double n, final double n2) {
        final boolean z = fj.z;
        final x o = bu.o();
        while (o.f()) {
            final q e = o.e();
            final int selected;
            final boolean b = (selected = (this.isSelected(bu, e) ? 1 : 0)) != 0;
            if (z) {
                return (byte)selected;
            }
            if (b) {
                final byte hotSpotHit = bu.t(e).hotSpotHit(n, n2);
                if (hotSpotHit != 8) {
                    return hotSpotHit;
                }
            }
            o.g();
            if (z) {
                break;
            }
        }
        int selected = 8;
        return (byte)selected;
    }
    
    public void mouseClicked(final double n, final double n2) {
        final gX editNodeMode = this.getEditNodeMode();
        if (this.doAllowNodeEditing() && editNodeMode != null && !editNodeMode.isActive()) {
            final q i = this.getHitInfo(n, n2).i();
            if (i != null && this.isEditNodeGesture(i, this.lastPressEvent, this.lastReleaseEvent, this.lastClickEvent)) {
                this.editNode(i, this.lastClickEvent);
            }
        }
    }
    
    public void mouseEntered(final MouseEvent mouseEvent) {
        this.zf = -1;
        super.mouseEntered(mouseEvent);
    }
    
    public boolean startEditor(final dx dx) {
        final dz mouseInputMode = this.getMouseInputMode();
        if (dx != null && this.doAllowMouseInput() && mouseInputMode != null) {
            final boolean a = mouseInputMode.a(dx);
            if (a) {
                this.setChild(mouseInputMode, null, null);
            }
            return a;
        }
        return false;
    }
    
    private void j(final double ve, final double ef) {
        final boolean z = fj.z;
        Label_0095: {
            if (this.isCyclicSelectionEnabled() && this.isCyclicSelectionModifierPressed()) {
                final cW cyclicHitInfo = this.createCyclicHitInfo(ve, ef);
                Label_0064: {
                    if (this.b(cyclicHitInfo)) {
                        this.of = cyclicHitInfo;
                        if (!z) {
                            break Label_0064;
                        }
                    }
                    this.of = this.of.a(this.getGraph2D(), ve, ef);
                }
                this.setLastHitInfo(this.of);
                this.te = this.of;
                if (!z) {
                    break Label_0095;
                }
            }
            this.te = this.getHitInfo(ve, ef);
        }
        this.af = false;
        this.ve = ve;
        this.ef = ef;
        final bu graph2D = this.getGraph2D();
        if (this.doAllowResizeNodes() && this.b(this.view, graph2D, ve, ef) != 8) {
            this.zf = 11;
            return;
        }
        if (this.te.a()) {
            final Object h = this.te.h();
            if (h instanceof fL) {
                this.zf = 12;
                return;
            }
            if (h instanceof q) {
                this.pressedNode = (q)h;
                if (this.isSelected(graph2D, this.pressedNode)) {
                    this.zf = 2;
                    if (!z) {
                        return;
                    }
                }
                this.zf = 1;
                return;
            }
            if (h instanceof eU) {
                this.pressedNode = ((eU)h).b().getNode();
                if (this.isSelected(graph2D, (eU)h)) {
                    this.zf = 14;
                    if (!z) {
                        return;
                    }
                }
                this.zf = 13;
                return;
            }
            if (h instanceof y.h.x) {
                if (this.isSelected(graph2D, (y.h.x)h)) {
                    this.zf = 4;
                    if (!z) {
                        return;
                    }
                }
                this.zf = 3;
                return;
            }
            if (h instanceof d) {
                if (this.isSelected(graph2D, (d)h)) {
                    this.zf = 6;
                    if (!z) {
                        return;
                    }
                }
                this.zf = 5;
                return;
            }
            if (h instanceof eR) {
                if (this.isSelected(graph2D, (gZ)h)) {
                    this.zf = 9;
                    if (!z) {
                        return;
                    }
                }
                this.zf = 7;
                return;
            }
            if (h instanceof aA) {
                if (this.isSelected(graph2D, (gZ)h)) {
                    this.zf = 10;
                    if (!z) {
                        return;
                    }
                }
                this.zf = 8;
                return;
            }
        }
        this.zf = 0;
    }
    
    private boolean b(final cW cw) {
        final boolean z = fj.z;
        if (this.of == null || !cw.a(this.of)) {
            return true;
        }
        if (!this.of.a()) {
            return false;
        }
        if (!y.h.gg.a(this.getGraph2D(), this.of.h())) {
            return true;
        }
        final C d = this.of.d();
        d.g();
        boolean a = false;
        while (d.f()) {
            a = y.h.gg.a(this.getGraph2D(), d.d());
            if (z) {
                return a;
            }
            if (a) {
                return true;
            }
            d.g();
            if (z) {
                break;
            }
        }
        return a;
    }
    
    protected boolean isCyclicSelectionModifierPressed() {
        return this.lastPressEvent != null && (this.lastPressEvent.getModifiers() & this.getCyclicSelectionModifierMask()) != 0x0;
    }
    
    protected cW createCyclicHitInfo(final double n, final double n2) {
        final int b = this.b(this.getGraph2D());
        int n3 = -1;
        if (!this.isMixedSelectionEnabled() && this.isModifierPressed(this.lastPressEvent) && b != 0) {
            n3 = b;
            if (!fj.z) {
                return this.j(this.view.getHitInfoFactory().a(n, n2, n3, false), n, n2);
            }
        }
        if (!this.doAllowLabelSelection()) {
            n3 ^= 0x30;
        }
        return this.j(this.view.getHitInfoFactory().a(n, n2, n3, false), n, n2);
    }
    
    private int b(final bu bu) {
        int n = 0;
        if (this.b(bu, 9)) {
            n |= 0x9;
        }
        if (this.b(bu, 2)) {
            n |= 0x2;
        }
        if (this.b(bu, 48)) {
            n |= 0x30;
        }
        if (this.b(bu, 64)) {
            n |= 0x40;
        }
        return n;
    }
    
    private cW j(cW cw, final double n, final double n2) {
        final boolean z = fj.z;
        if (!cw.b()) {
            return cw;
        }
        final bu graph2D = this.getGraph2D();
        final HashSet set = new HashSet<Object>();
        final C d = cw.d();
        while (true) {
            while (d.f()) {
                final Object d2 = d.d();
                final int n3;
                final boolean b = (n3 = (this.b(this.getGraph2D(), d2) ? 1 : 0)) != 0;
                if (z) {
                    if (n3 == 1) {
                        while (cw.h() != set.iterator().next()) {
                            cw = cw.a(graph2D, n, n2);
                            if (z) {
                                return cw;
                            }
                            if (z) {
                                break;
                            }
                        }
                        cw = cw.a(graph2D, n, n2);
                    }
                    return cw;
                }
                if (b) {
                    set.add(d2);
                    if (set.size() > 1) {
                        return cw;
                    }
                }
                d.g();
                if (z) {
                    break;
                }
            }
            int n3 = set.size();
            continue;
        }
    }
    
    protected String getNodeTip(final q q) {
        final fj t = this.getGraph2D().t(q);
        if (t.labelCount() > 0) {
            return t.getLabel(0).getText();
        }
        return null;
    }
    
    protected String getEdgeTip(final d d) {
        final aB i = this.getGraph2D().i(d);
        if (i.labelCount() > 0) {
            return i.getLabel(0).getText();
        }
        return null;
    }
    
    protected void nodeCreated(final q q) {
    }
    
    protected void bendCreated(final bu bu, final d d, final y.h.x x, final double n, final double n2) {
    }
    
    protected void nodeClicked(final q q) {
        if (this.b(this.getGraph2D(), q)) {
            this.groupNodeClicked(q);
        }
    }
    
    protected void groupNodeClicked(final q q) {
        final boolean z = fj.z;
        if (this.doAllowNodeCreation() && this.isChildNodeCreationEnabled()) {
            final bu graph2D = this.getGraph2D();
            if (!this.isSelected(graph2D, q)) {
                double n = 0.0;
                double n2 = 0.0;
                Label_0127: {
                    if (this.lastReleaseEvent != null) {
                        n = this.translateX(this.lastReleaseEvent.getX());
                        n2 = this.translateY(this.lastReleaseEvent.getY());
                        if (!z) {
                            break Label_0127;
                        }
                    }
                    if (this.lastClickEvent != null) {
                        n = this.translateX(this.lastClickEvent.getX());
                        n2 = this.translateY(this.lastClickEvent.getY());
                        if (!z) {
                            break Label_0127;
                        }
                    }
                    final fj t = graph2D.t(q);
                    n = t.getCenterX();
                    n2 = t.getCenterX();
                }
                if (!this.isGroupNodeBorderHit(graph2D, q, n, n2, this.isSelectOnGroupNodeLabelEnabled())) {
                    if (this.isSelectionEmpty(graph2D)) {
                        this.setEditing(true);
                        final q node = this.createNode(graph2D, n, n2, q);
                        if (node != null) {
                            graph2D.T();
                            this.nodeCreated(node);
                        }
                        this.setEditing(false);
                        if (!z) {
                            return;
                        }
                    }
                    this.unselectAll(graph2D);
                    graph2D.T();
                }
            }
        }
    }
    
    public gX getMoveViewPortMode() {
        return this.moveViewPortMode;
    }
    
    public gX getMoveLabelMode() {
        return this.moveLabelMode;
    }
    
    public void setMoveViewPortMode(final gX moveViewPortMode) {
        this.moveViewPortMode = moveViewPortMode;
    }
    
    public void setMoveLabelMode(final gX moveLabelMode) {
        this.moveLabelMode = moveLabelMode;
    }
    
    public gX getMovePortMode() {
        return this.movePortMode;
    }
    
    public void setMovePortMode(final gX movePortMode) {
        this.movePortMode = movePortMode;
    }
    
    public gX getHotSpotMode() {
        return this.hotSpotMode;
    }
    
    public void setHotSpotMode(final gX hotSpotMode) {
        this.hotSpotMode = hotSpotMode;
    }
    
    public gX getMoveNodePortMode() {
        return this.moveNodePortMode;
    }
    
    public void setMoveNodePortMode(final gX moveNodePortMode) {
        this.moveNodePortMode = moveNodePortMode;
    }
    
    protected boolean isCreateEdgeGesture(final MouseEvent mouseEvent, final MouseEvent mouseEvent2) {
        if (this.pressedNode == null || mouseEvent == null) {
            return false;
        }
        final bu graph2D = this.getGraph2D();
        return !this.isSelected(graph2D, this.pressedNode) && (!this.b(graph2D, this.pressedNode) || this.isGroupNodeBorderHit(graph2D, this.pressedNode, this.translateX(mouseEvent.getX()), this.translateY(mouseEvent.getY()), this.isCreateEdgeOnGroupNodeLabelEnabled()));
    }
    
    protected boolean isEditNodeGesture(final q q, final MouseEvent mouseEvent, final MouseEvent mouseEvent2, final MouseEvent mouseEvent3) {
        return mouseEvent3.getClickCount() == 2;
    }
    
    public Cursor getDefaultCursor() {
        return this.cg;
    }
    
    public void setDefaultCursor(final Cursor cg) {
        this.cg = cg;
    }
    
    protected boolean editNode(final q q, final EventObject eventObject) {
        final gX editNodeMode = this.getEditNodeMode();
        if (!this.doAllowNodeEditing() || editNodeMode == null) {
            return false;
        }
        if (!(editNodeMode instanceof D)) {
            this.setChild(editNodeMode, null, null);
            return true;
        }
        final D d = (D)editNodeMode;
        if (!d.a(q)) {
            return false;
        }
        this.setChild(d, null, null);
        if (!d.a(q, eventObject)) {
            d.reactivateParent();
            return false;
        }
        return true;
    }
    
    public gX getOrthogonalMoveBendsMode() {
        if (this.tf == null) {
            this.tf = this.createOrthogonalMoveBendsMode();
        }
        return this.tf;
    }
    
    public void setOrthogonalMoveBendsMode(final gX tf) {
        this.tf = tf;
    }
    
    protected gX createOrthogonalMoveBendsMode() {
        return new fu();
    }
    
    protected cW createLabelHitInfo(final double n, final double n2) {
        return new cW(this.view, n, n2, false, 5);
    }
    
    public void setGroupBorderWidth(final int pe) {
        this.pe = pe;
    }
    
    public int getGroupBorderWidth() {
        return this.pe;
    }
    
    public boolean isCreateEdgeOnGroupNodeLabelEnabled() {
        return this.uf;
    }
    
    public void setCreateEdgeOnGroupNodeLabelEnabled(final boolean uf) {
        this.uf = uf;
    }
    
    public boolean isChildNodeCreationEnabled() {
        return this.mg;
    }
    
    public void setChildNodeCreationEnabled(final boolean mg) {
        this.mg = mg;
    }
    
    public boolean isSelectOnGroupNodeLabelEnabled() {
        return this.wf;
    }
    
    public void setSelectOnGroupNodeLabelEnabled(final boolean wf) {
        this.wf = wf;
    }
    
    static boolean b(final d d, final bu bu) {
        final c c = c(bu);
        return c != null && c.d(d);
    }
    
    static p access$000(final aC ac) {
        return ac.eg;
    }
    
    static c access$100(final bu bu) {
        return c(bu);
    }
    
    static {
        ORTHOGONAL_ROUTING_DPKEY = "y.view.EditMode.ORTHOGONAL_ROUTING_DPKEY";
    }
}
