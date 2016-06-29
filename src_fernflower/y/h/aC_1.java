package y.h;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.util.EventObject;
import java.util.HashSet;
import java.util.Iterator;
import y.h.D;
import y.h.F;
import y.h.aA;
import y.h.aB;
import y.h.aD;
import y.h.aE;
import y.h.bu;
import y.h.cW;
import y.h.ch;
import y.h.dB;
import y.h.dH;
import y.h.dI;
import y.h.dP;
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

public class aC extends gX {
   private cW te;
   private boolean af;
   private boolean df;
   private int zf;
   protected y.c.q pressedNode;
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
   private y.g.p eg;
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

   public aC(gU var1) {
      super(var1);
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

   public void setAdjustScrollBarPolicy(boolean var1) {
      this.hf = var1;
   }

   public void setSnappingEnabled(boolean var1) {
      if(this.getHotSpotMode() instanceof da) {
         ((da)this.getHotSpotMode()).a(var1);
      }

      if(this.getMoveSelectionMode() instanceof dP) {
         dP var2 = (dP)this.getMoveSelectionMode();
         var2.a(var1);
         var2.c().f(var1);
         var2.c().c(var1);
      }

      if(this.getOrthogonalMoveBendsMode() instanceof fu) {
         fu var3 = (fu)this.getOrthogonalMoveBendsMode();
         var3.a(var1);
         var3.c().a(var1);
      }

      if(this.getCreateEdgeMode() instanceof F) {
         F var4 = (F)this.getCreateEdgeMode();
         var4.a(var1?5.0D:0.0D);
         var4.a(var1);
      }

      if(this.getMovePortMode() instanceof dI) {
         dI var5 = (dI)this.getMovePortMode();
         var5.a(var1);
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

   public void activate(boolean var1) {
      boolean var3 = fj.z;
      if(!var1) {
         gX var2 = this.getChild();

         label30: {
            while(var2 != null) {
               var2.activate(var1);
               var2 = var2.getChild();
               if(var3) {
                  break label30;
               }

               if(var3) {
                  break;
               }
            }

            if(this.getGraph2D().c(ORTHOGONAL_ROUTING_DPKEY) == this.eg) {
               this.getGraph2D().d_(ORTHOGONAL_ROUTING_DPKEY);
            }
         }

         if(this.og != null) {
            this.view.removePropertyChangeListener("Graph2D", this.og);
            this.og = null;
         }
      }

      super.activate(var1);
      if(var1) {
         this.prepareView(this.view);
         if(c(this.getGraph2D()) == null) {
            this.og = new aD(this);
            this.view.addPropertyChangeListener("Graph2D", this.og);
            this.getGraph2D().a((Object)ORTHOGONAL_ROUTING_DPKEY, (y.c.c)(this.eg = new aE(this)));
         }
      }

   }

   public void cancelEditing() {
      boolean var2 = fj.z;
      gX var1 = this.getChild();

      while(var1 != null) {
         if(var1.isEditing()) {
            var1.cancelEditing();
         }

         var1 = var1.getChild();
         if(var2) {
            break;
         }
      }

      super.cancelEditing();
   }

   public void setChild(gX var1, MouseEvent var2, MouseEvent var3, MouseEvent var4) {
      gX var5 = this.getChild();
      super.setChild(var1, var2, var3, var4);
      if(var5 != null && var1 == null && !this.gg) {
         this.gg = true;

         try {
            MouseEvent var6 = this.view.p();
            if(var6 != null && var6.getID() != 505) {
               this.mouseMoved(new MouseEvent(this.view.getCanvasComponent(), 503, var6.getWhen() + 1L, 0, var6.getX(), var6.getY(), 0, false));
            }
         } finally {
            this.gg = false;
         }
      }

   }

   protected void prepareView(ch var1) {
      if(this.hf) {
         var1.setScrollBarPolicy(20, 30);
      }

      var1.setViewCursor(this.getDefaultCursor());
      var1.updateView();
   }

   public void setMixedSelectionEnabled(boolean var1) {
      this.lf = var1;
   }

   public boolean isMixedSelectionEnabled() {
      return this.lf;
   }

   public void setOrthogonalEdgeRouting(boolean var1) {
      this.nf = var1;
   }

   public boolean isOrthogonalEdgeRouting() {
      return this.nf;
   }

   public void assignNodeLabel(boolean var1) {
      this.yf = var1;
   }

   public void allowNodeCreation(boolean var1) {
      this.fg = var1;
   }

   public void allowNodeEditing(boolean var1) {
      this.ag = var1;
   }

   public void allowEdgeCreation(boolean var1) {
      this.rg = var1;
   }

   public void allowBendCreation(boolean var1) {
      this.jg = var1;
      if(this.createEdgeMode instanceof F) {
         ((F)this.createEdgeMode).b(var1);
      }

   }

   public void allowMoveSelection(boolean var1) {
      this.me = var1;
   }

   public void allowMoveLabels(boolean var1) {
      this.xe = var1;
   }

   public void allowMovePorts(boolean var1) {
      this.qf = var1;
   }

   public void allowLabelSelection(boolean var1) {
      this.sg = var1;
   }

   public void allowMoving(boolean var1) {
      this.qe = var1;
   }

   public void allowMovingWithPopup(boolean var1) {
      this.re = var1;
   }

   public void allowResizeNodes(boolean var1) {
      this.ne = var1;
   }

   public void allowMouseInput(boolean var1) {
      this.we = var1;
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

   public void showNodeTips(boolean var1) {
      this.ze = var1;
      if(!this.ze && this.view != null) {
         this.view.setToolTipText((String)null);
      }

   }

   public boolean doShowNodeTips() {
      return this.ze;
   }

   public void showEdgeTips(boolean var1) {
      this.vf = var1;
      if(!this.vf && this.view != null) {
         this.view.setToolTipText((String)null);
      }

   }

   public boolean doShowEdgeTips() {
      return this.vf;
   }

   public void setCyclicSelectionEnabled(boolean var1) {
      this.cf = var1;
      if(!var1) {
         this.of = null;
      }

   }

   public boolean isCyclicSelectionEnabled() {
      return this.cf;
   }

   public void setCyclicSelectionModifierMask(int var1) {
      this.lg = var1;
   }

   public int getCyclicSelectionModifierMask() {
      return this.lg;
   }

   public gX getEditNodeMode() {
      return this.editNodeMode;
   }

   public void setEditNodeMode(gX var1) {
      this.editNodeMode = var1;
   }

   public gX getPopupMode() {
      return this.popupMode;
   }

   public void setPopupMode(gX var1) {
      this.popupMode = var1;
   }

   public gX getMoveSelectionMode() {
      return this.moveSelectionMode;
   }

   public void setMoveSelectionMode(gX var1) {
      this.moveSelectionMode = var1;
   }

   public dz getMouseInputMode() {
      return this.mouseInputMode;
   }

   public void setMouseInputMode(dz var1) {
      this.mouseInputMode = var1;
   }

   public gX getCreateEdgeMode() {
      return this.createEdgeMode;
   }

   public void setCreateEdgeMode(gX var1) {
      this.createEdgeMode = var1;
   }

   public gX getSelectionBoxMode() {
      return this.selectionBoxMode;
   }

   public void setSelectionBoxMode(gX var1) {
      this.selectionBoxMode = var1;
   }

   public void mousePressedLeft(double var1, double var3) {
      this.j(var1, var3);
   }

   public void mouseShiftPressedLeft(double var1, double var3) {
      this.j(var1, var3);
   }

   public void mouseReleasedLeft(double var1, double var3) {
      boolean var6 = fj.z;
      bu var5 = this.getGraph2D();
      if(!this.af) {
         switch(this.zf) {
         case 7:
            this.labelClicked(var5, this.getLastHitInfo().l(), false, var1, var3, false);
            if(!var6) {
               break;
            }
         case 8:
            this.labelClicked(var5, this.getLastHitInfo().m(), false, var1, var3, false);
            if(!var6) {
               break;
            }
         case 9:
            this.labelClicked(var5, this.getLastHitInfo().l(), true, var1, var3, false);
            if(!var6) {
               break;
            }
         case 10:
            this.labelClicked(var5, this.getLastHitInfo().m(), true, var1, var3, false);
            if(!var6) {
               break;
            }
         case 0:
            this.paperClicked(var5, var1, var3, false);
            if(!var6) {
               break;
            }
         case 1:
            this.nodeClicked(var5, this.getLastHitInfo().i(), false, var1, var3, false);
            if(!var6) {
               break;
            }
         case 3:
            this.bendClicked(var5, this.getLastHitInfo().j(), false, var1, var3, false);
            if(!var6) {
               break;
            }
         case 5:
            this.edgeClicked(var5, this.getLastHitInfo().k(), false, var1, var3, false);
            if(!var6) {
               break;
            }
         case 2:
            this.nodeClicked(var5, this.getLastHitInfo().i(), true, var1, var3, false);
            if(!var6) {
               break;
            }
         case 6:
            this.edgeClicked(var5, this.getLastHitInfo().k(), true, var1, var3, false);
            if(!var6) {
               break;
            }
         case 4:
            this.bendClicked(var5, this.getLastHitInfo().j(), true, var1, var3, false);
            if(!var6) {
               break;
            }
         case 13:
            this.nodePortClicked(var5, this.getLastHitInfo().o(), false, var1, var3, false);
            if(!var6) {
               break;
            }
         case 14:
            this.nodePortClicked(var5, this.getLastHitInfo().o(), true, var1, var3, false);
         case 11:
         case 12:
         }
      }

   }

   private void p() {
      if(this.isCyclicSelectionEnabled() && this.isCyclicSelectionModifierPressed()) {
         this.beforeSelectionCycling(this.of.d());
      }

   }

   protected void labelClicked(bu var1, gZ var2, boolean var3, double var4, double var6, boolean var8) {
      boolean var10 = fj.z;
      boolean var9 = this.doAllowLabelSelection();
      if(var8 && var9) {
         label33: {
            this.p();
            if(var3) {
               this.setSelected(var1, var2, false);
               if(!var10) {
                  break label33;
               }
            }

            if(this.isMixedSelectionEnabled() || !this.b(var1, -49)) {
               this.setSelected(var1, var2, true);
            }
         }

         var1.T();
         if(!var10) {
            return;
         }
      }

      this.labelClicked(var2);
      if(!var3 && var9) {
         this.unselectAll(var1);
         this.setSelected(var1, var2, true);
         var1.T();
      }

   }

   protected void labelClicked(gZ var1) {
   }

   public void mouseShiftReleasedLeft(double var1, double var3) {
      boolean var6 = fj.z;
      bu var5 = this.getGraph2D();
      if(!this.af) {
         switch(this.zf) {
         case 7:
            this.labelClicked(var5, this.getLastHitInfo().l(), false, var1, var3, true);
            if(!var6) {
               break;
            }
         case 8:
            this.labelClicked(var5, this.getLastHitInfo().m(), false, var1, var3, true);
            if(!var6) {
               break;
            }
         case 9:
            this.labelClicked(var5, this.getLastHitInfo().l(), true, var1, var3, true);
            if(!var6) {
               break;
            }
         case 10:
            this.labelClicked(var5, this.getLastHitInfo().m(), true, var1, var3, true);
            if(!var6) {
               break;
            }
         case 0:
            this.paperClicked(var5, var1, var3, true);
            if(!var6) {
               break;
            }
         case 1:
            this.nodeClicked(var5, this.getLastHitInfo().i(), false, var1, var3, true);
            if(!var6) {
               break;
            }
         case 3:
            this.bendClicked(var5, this.getLastHitInfo().j(), false, var1, var3, true);
            if(!var6) {
               break;
            }
         case 5:
            this.edgeClicked(var5, this.getLastHitInfo().k(), false, var1, var3, true);
            if(!var6) {
               break;
            }
         case 6:
            this.edgeClicked(var5, this.getLastHitInfo().k(), true, var1, var3, true);
            if(!var6) {
               break;
            }
         case 4:
            this.bendClicked(var5, this.getLastHitInfo().j(), true, var1, var3, true);
            if(!var6) {
               break;
            }
         case 2:
            this.nodeClicked(var5, this.getLastHitInfo().i(), true, var1, var3, true);
            if(!var6) {
               break;
            }
         case 13:
            this.nodePortClicked(var5, this.getLastHitInfo().o(), false, var1, var3, true);
            if(!var6) {
               break;
            }
         case 14:
            this.nodePortClicked(var5, this.getLastHitInfo().o(), true, var1, var3, true);
         case 11:
         case 12:
         }
      }

   }

   protected void nodePortClicked(bu var1, eU var2, boolean var3, double var4, double var6, boolean var8) {
      boolean var9 = fj.z;
      if(var8) {
         label29: {
            if(var3) {
               this.setSelected(var1, var2, false);
               if(!var9) {
                  break label29;
               }
            }

            if(this.isMixedSelectionEnabled() || !this.b(var1, -65)) {
               this.setSelected(var1, var2, true);
            }
         }

         var1.T();
         if(!var9) {
            return;
         }
      }

      if(!var3) {
         this.unselectAll(var1);
         this.setSelected(var1, var2, true);
         var1.T();
      }

   }

   private boolean b(bu var1, int var2) {
      boolean var14;
      boolean var10000;
      int var22;
      label221: {
         var14 = fj.z;
         int var3 = (var2 & 1) == 1?1:0;
         boolean var4 = (var2 & 16) == 16;
         boolean var5 = (var2 & 64) == 64;
         if(var3 != 0 || var4 || var5) {
            y.c.x var6 = var1.o();

            label188:
            do {
               var10000 = var6.f();

               label185:
               while(true) {
                  if(!var10000) {
                     break label188;
                  }

                  y.c.q var7 = var6.e();
                  var22 = var3;
                  if(var14) {
                     break label221;
                  }

                  if(var3 != 0 && this.isSelected(var1, var7)) {
                     return true;
                  }

                  fj var8;
                  label176: {
                     if(var4) {
                        var8 = var1.t(var7);
                        if(var8.labelCount() > 0) {
                           int var9 = 0;
                           int var10 = var8.labelCount();

                           while(var9 < var10) {
                              var10000 = this.isSelected(var1, (gZ)var8.getLabel(var9));
                              if(var14) {
                                 break label176;
                              }

                              if(var10000) {
                                 return true;
                              }

                              ++var9;
                              if(var14) {
                                 break;
                              }
                           }
                        }
                     }

                     var10000 = var5;
                  }

                  if(!var10000) {
                     break;
                  }

                  var8 = var1.t(var7);
                  if(var8.portCount() <= 0) {
                     break;
                  }

                  Iterator var18 = var8.ports();

                  do {
                     if(!var18.hasNext()) {
                        break label185;
                     }
                  } while(!this.isSelected(var1, (eU)var18.next()));

                  var10000 = true;
                  if(!var14) {
                     return true;
                  }
               }

               var6.g();
            } while(!var14);
         }

         var22 = var2 & 2;
      }

      boolean var15 = var22 == 2 || (var2 & 4) == 4;
      boolean var16 = (var2 & 32) == 32;
      boolean var17 = (var2 & 8) == 8;
      if(var15 || var16 || var17) {
         y.c.e var19 = var1.p();

         label136:
         do {
            var10000 = var19.f();

            label133:
            while(true) {
               if(!var10000) {
                  break label136;
               }

               y.c.d var20 = var19.a();
               var10000 = var15;
               if(var14) {
                  return var10000;
               }

               if(var15 && this.isSelected(var1, var20)) {
                  return true;
               }

               aB var11;
               label124: {
                  if(var16) {
                     var11 = var1.i(var20);
                     if(var11.labelCount() > 0) {
                        int var12 = 0;
                        int var13 = var11.labelCount();

                        while(var12 < var13) {
                           var10000 = this.isSelected(var1, (gZ)var11.getLabel(var12));
                           if(var14) {
                              break label124;
                           }

                           if(var10000) {
                              return true;
                           }

                           ++var12;
                           if(var14) {
                              break;
                           }
                        }
                     }
                  }

                  var10000 = var17;
               }

               if(!var10000) {
                  break;
               }

               var11 = var1.i(var20);
               if(var11.bendCount() <= 0) {
                  break;
               }

               y var21 = var11.bends();

               while(true) {
                  if(!var21.f()) {
                     break label133;
                  }

                  var10000 = this.isSelected(var1, var21.a());
                  if(var14) {
                     break;
                  }

                  if(var10000) {
                     return true;
                  }

                  var21.g();
                  if(var14) {
                     break label133;
                  }
               }
            }

            var19.g();
         } while(!var14);
      }

      var10000 = false;
      return var10000;
   }

   protected void nodeClicked(bu var1, y.c.q var2, boolean var3, double var4, double var6, boolean var8) {
      boolean var9 = fj.z;
      if(!this.isChildNodeCreationEnabled() || !this.b(var1, var2) || this.isGroupNodeBorderHit(var1, var2, var4, var6, this.isSelectOnGroupNodeLabelEnabled())) {
         this.p();
         if(var8) {
            label46: {
               if(var3) {
                  this.setSelected(var1, var2, false);
                  if(!var9) {
                     break label46;
                  }
               }

               if(this.isMixedSelectionEnabled() || !this.b(var1, -10)) {
                  this.setSelected(var1, var2, true);
               }
            }

            var1.T();
            if(!var9) {
               return;
            }
         }

         this.nodeClicked(var2);
         if(var3) {
            return;
         }

         this.unselectAll(var1);
         this.setSelected(var1, var2, true);
         var1.T();
         if(!var9) {
            return;
         }
      }

      this.nodeClicked(var2);
   }

   protected void beforeSelectionCycling(y.c.C var1) {
      boolean var3 = fj.z;
      if(var1 != null && var1.f()) {
         bu var2 = this.getGraph2D();
         var1.g();

         while(var1.f()) {
            this.b(var2, var1.d(), false);
            var1.g();
            if(var3) {
               return;
            }

            if(var3) {
               break;
            }
         }

         var2.T();
      }

   }

   protected boolean isGroupNodeBorderHit(bu var1, y.c.q var2, double var3, double var5, boolean var7) {
      boolean var12 = fj.z;
      if(this.b(var1, var2)) {
         fj var8 = var1.t(var2);
         if(var7) {
            cW var9 = this.createLabelHitInfo(var3, var5);
            y.c.C var10 = var9.g();

            while(var10.f()) {
               eR var11 = (eR)var10.d();
               if(var12) {
                  return false;
               }

               if(var11.f() == var2 && var8.getLabel(0) == var11) {
                  return true;
               }

               var10.g();
               if(var12) {
                  break;
               }
            }
         }

         int var13 = this.getGroupBorderWidth();
         if(var3 < var8.getX() + (double)var13 || var3 > var8.getX() + var8.getWidth() - (double)var13 || var5 < var8.getY() + (double)var13 || var5 > var8.getY() + var8.getHeight() - (double)var13) {
            return true;
         }
      }

      return false;
   }

   private boolean b(bu var1, y.c.q var2) {
      y.h.a.v var3 = y.h.a.v.a((y.c.i)var1);
      return var3 != null && var3.k(var2);
   }

   protected void bendClicked(bu var1, x var2, boolean var3, double var4, double var6, boolean var8) {
      boolean var9 = fj.z;
      this.p();
      if(var8) {
         label41: {
            if(var3) {
               this.setSelected(var1, var2, false);
               if(!var9) {
                  break label41;
               }
            }

            if(!this.isMixedSelectionEnabled() && this.b(var1, 2)) {
               this.setSelected(var1, var2.a(), !this.isSelected(var1, var2.a()));
               if(!var9) {
                  break label41;
               }
            }

            if(this.isMixedSelectionEnabled() || !this.b(var1, -10)) {
               this.setSelected(var1, var2, true);
            }
         }

         var1.T();
         if(!var9) {
            return;
         }
      }

      if(!var3) {
         this.unselectAll(var1);
         this.setSelected(var1, var2, true);
         var1.T();
      }

   }

   protected void edgeClicked(bu var1, y.c.d var2, boolean var3, double var4, double var6, boolean var8) {
      boolean var12 = fj.z;
      this.p();
      if(var8) {
         label85: {
            label90: {
               if(var3) {
                  this.setSelected(var1, var2, false);
                  if(!var12) {
                     break label90;
                  }
               }

               if(!this.isMixedSelectionEnabled() && this.b(var1, 9)) {
                  aB var9 = var1.i(var2);
                  if(var9.bendCount() <= 0) {
                     break label90;
                  }

                  int var10 = 0;
                  y var11 = var9.bends();

                  int var10000;
                  label75: {
                     while(var11.f()) {
                        var10000 = this.isSelected(var1, var11.a());
                        if(var12) {
                           break label75;
                        }

                        if(var10000 != 0) {
                           ++var10;
                        }

                        var11.g();
                        if(var12) {
                           break;
                        }
                     }

                     var10000 = var10;
                  }

                  if(var10000 == var9.bendCount()) {
                     var11 = var9.bends();

                     do {
                        if(!var11.f()) {
                           break label90;
                        }

                        this.setSelected(var1, var11.a(), false);
                        var11.g();
                        if(var12) {
                           break label85;
                        }
                     } while(!var12);
                  }

                  var11 = var9.bends();

                  do {
                     if(!var11.f()) {
                        break label90;
                     }

                     this.setSelected(var1, var11.a(), true);
                     var11.g();
                     if(var12) {
                        break label85;
                     }
                  } while(!var12);
               }

               if(this.isMixedSelectionEnabled() || !this.b(var1, -7)) {
                  this.setSelected(var1, var2, true);
               }
            }

            var1.T();
         }

         if(!var12) {
            return;
         }
      }

      if(!var3) {
         this.unselectAll(var1);
         this.setSelected(var1, var2, true);
         var1.T();
      }

   }

   protected void paperClicked(bu var1, double var2, double var4, boolean var6) {
      if(!var6 && (!this.isCyclicSelectionEnabled() || !this.isCyclicSelectionModifierPressed())) {
         if(!this.isSelectionEmpty(var1)) {
            this.unselectAll(var1);
            var1.T();
            if(!fj.z) {
               return;
            }
         }

         if(this.doAllowNodeCreation()) {
            this.setEditing(true);
            y.c.q var7 = this.createNode(var1, var2, var4);
            if(var7 != null) {
               var1.T();
               this.nodeCreated(var7);
            }

            this.setEditing(false);
         }
      }

   }

   public void mousePressed(MouseEvent var1) {
      if(this.getChild() != null) {
         this.zf = -1;
      }

      super.mousePressed(var1);
   }

   public void mouseDraggedLeft(double var1, double var3) {
      boolean var7 = fj.z;
      bu var5 = this.getGraph2D();
      this.getHitInfo(var1, var3);
      boolean var6 = !this.af;
      this.af = true;
      switch(this.zf) {
      case -1:
      default:
         if(!var7) {
            break;
         }
      case 0:
         this.paperDragged(var5, var1, var3, var6);
         if(!var7) {
            break;
         }
      case 1:
         this.nodeDragged(var5, this.te.i(), false, var1, var3, var6);
         if(!var7) {
            break;
         }
      case 2:
         this.nodeDragged(var5, this.te.i(), true, var1, var3, var6);
         if(!var7) {
            break;
         }
      case 3:
         this.bendDragged(var5, this.te.j(), false, var1, var3, var6);
         if(!var7) {
            break;
         }
      case 4:
         this.bendDragged(var5, this.te.j(), true, var1, var3, var6);
         if(!var7) {
            break;
         }
      case 7:
         this.labelDragged(var5, this.te.l(), false, var1, var3, var6);
         if(!var7) {
            break;
         }
      case 9:
         this.labelDragged(var5, this.te.l(), true, var1, var3, var6);
         if(!var7) {
            break;
         }
      case 8:
         this.labelDragged(var5, this.te.m(), false, var1, var3, var6);
         if(!var7) {
            break;
         }
      case 10:
         this.labelDragged(var5, this.te.m(), true, var1, var3, var6);
         if(!var7) {
            break;
         }
      case 5:
         this.edgeDragged(var5, this.te.k(), false, var1, var3, var6);
         if(!var7) {
            break;
         }
      case 6:
         this.edgeDragged(var5, this.te.k(), true, var1, var3, var6);
         if(!var7) {
            break;
         }
      case 11:
         this.hotSpotDragged(var5, var1, var3, var6);
         if(!var7) {
            break;
         }
      case 12:
         this.portDragged(var5, this.te.n(), var1, var3, var6);
         if(!var7) {
            break;
         }
      case 13:
         this.nodePortDragged(var5, this.te.o(), false, var1, var3, var6);
         if(!var7) {
            break;
         }
      case 14:
         this.nodePortDragged(var5, this.te.o(), true, var1, var3, var6);
      }

   }

   protected void bendDragged(bu var1, x var2, boolean var3, double var4, double var6, boolean var8) {
      boolean var10 = fj.z;
      gX var9;
      if(var3) {
         if(!var8) {
            return;
         }

         var9 = this.getMoveSelectionMode();
         if(this.isSelectionEmpty(var1) || !this.doAllowMoveSelection() || var9 == null) {
            return;
         }

         this.setChild(var9, this.lastPressEvent, this.lastDragEvent);
         if(!var10) {
            return;
         }
      }

      if(var8) {
         label23: {
            if(this.isMixedSelectionEnabled()) {
               this.unselectNodes(var1);
               this.unselectBends(var1);
               if(!var10) {
                  break label23;
               }
            }

            this.unselectAll(var1);
         }

         this.setSelected(var1, var2, true);
         var9 = this.getMoveSelectionMode();
         if(this.doAllowMoveSelection() && var9 != null) {
            this.setChild(var9, this.lastPressEvent, this.lastDragEvent);
         }
      }

   }

   protected void edgeDragged(bu var1, y.c.d var2, boolean var3, double var4, double var6, boolean var8) {
      if(var8 && var2 != null && this.isOrthogonalRouting(var2) && this.doAllowMoveSelection()) {
         this.setChild(this.getOrthogonalMoveBendsMode(), this.lastPressEvent, this.lastDragEvent);
      } else {
         if(var8 && this.doAllowBendCreation()) {
            this.unselectAll(var1);
            var1.T();
            var1.a((new y.c.f(var2)).a());
            x var9 = this.createBend(var1, var2, this.ve, this.ef);
            if(var9 != null) {
               this.setSelected(var1, var9, true);
               this.bendCreated(var1, var2, var9, this.ve, this.ef);
               if(this.doAllowMoveSelection()) {
                  this.setChild(this.getMoveSelectionMode(), this.lastPressEvent, this.lastDragEvent);
               }
            }
         }

      }
   }

   protected void hotSpotDragged(bu var1, double var2, double var4, boolean var6) {
      gX var7 = this.getHotSpotMode();
      if(var7 != null) {
         this.setChild(var7, this.lastPressEvent, this.lastDragEvent);
      }

   }

   protected void labelDragged(bu var1, aA var2, boolean var3, double var4, double var6, boolean var8) {
      gX var9 = this.getMoveLabelMode();
      if(var8 && this.doAllowMoveLabels() && var9 != null) {
         this.setChild(var9, this.lastPressEvent, this.lastDragEvent);
      }

   }

   protected void labelDragged(bu var1, eR var2, boolean var3, double var4, double var6, boolean var8) {
      gX var9 = this.getMoveLabelMode();
      if(var8 && this.doAllowMoveLabels() && var9 != null) {
         this.setChild(var9, this.lastPressEvent, this.lastDragEvent);
      }

   }

   protected void nodeDragged(bu var1, y.c.q var2, boolean var3, double var4, double var6, boolean var8) {
      boolean var12 = fj.z;
      gX var9;
      if(var3) {
         if(!var8) {
            return;
         }

         var9 = this.getMoveSelectionMode();
         if(this.isSelectionEmpty(var1) || !this.doAllowMoveSelection() || var9 == null) {
            return;
         }

         this.setChild(var9, this.lastPressEvent, this.lastDragEvent);
         if(!var12) {
            return;
         }
      }

      var9 = this.getSelectionBoxMode();
      if(!this.isCreateEdgeGesture(this.lastPressEvent, this.lastDragEvent) && var9 != null) {
         this.setChild(var9, this.lastPressEvent, this.lastDragEvent);
         if(!var12) {
            return;
         }
      }

      gX var10 = this.getCreateEdgeMode();
      if(this.doAllowEdgeCreation() && var10 != null) {
         this.setChild(var10, this.lastPressEvent, this.lastDragEvent);
         if(!var12) {
            return;
         }
      }

      if(!this.doAllowEdgeCreation() && var8) {
         gX var11 = this.getMoveSelectionMode();
         if(this.doAllowMoveSelection() && var11 != null) {
            this.unselectAll(var1);
            this.setSelected(var1, var2, true);
            this.setChild(var11, this.lastPressEvent, this.lastDragEvent);
         }
      }

   }

   protected void nodePortDragged(bu var1, eU var2, boolean var3, double var4, double var6, boolean var8) {
      boolean var12 = fj.z;
      gX var9;
      if(var3) {
         if(!var8) {
            return;
         }

         var9 = this.getMoveNodePortMode();
         if(var9 == null) {
            return;
         }

         this.setChild(var9, this.lastPressEvent, this.lastDragEvent);
         if(!var12) {
            return;
         }
      }

      var9 = this.getSelectionBoxMode();
      if(!this.isCreateEdgeGesture(this.lastPressEvent, this.lastDragEvent) && var9 != null) {
         this.setChild(var9, this.lastPressEvent, this.lastDragEvent);
         if(!var12) {
            return;
         }
      }

      gX var10 = this.getCreateEdgeMode();
      if(this.doAllowEdgeCreation() && var10 != null) {
         this.setChild(var10, this.lastPressEvent, this.lastDragEvent);
         if(!var12) {
            return;
         }
      }

      if(!this.doAllowEdgeCreation() && var8) {
         gX var11 = this.getMoveNodePortMode();
         if(var11 != null) {
            this.unselectAll(var1);
            this.setSelected(var1, var2, true);
            this.setChild(var11, this.lastPressEvent, this.lastDragEvent);
         }
      }

   }

   protected void paperDragged(bu var1, double var2, double var4, boolean var6) {
      gX var7 = this.getSelectionBoxMode();
      if(var7 != null) {
         this.setChild(var7, this.lastPressEvent, this.lastDragEvent);
      }

   }

   protected void portDragged(bu var1, fL var2, double var3, double var5, boolean var7) {
      gX var8 = this.getMovePortMode();
      if(this.doAllowMovePorts() && var8 != null) {
         this.setChild(var8, this.lastPressEvent, this.lastDragEvent);
      }

   }

   protected void setSelected(bu var1, eU var2, boolean var3) {
      var1.a(var2, var3);
   }

   protected void setSelected(bu var1, y.c.q var2, boolean var3) {
      if(var3) {
         gg.a(var1, var2);
         if(!fj.z) {
            return;
         }
      }

      gg.b(var1, var2);
   }

   protected void setSelected(bu var1, gZ var2, boolean var3) {
      var1.a(var2, var3);
   }

   protected void setSelected(bu var1, y.c.d var2, boolean var3) {
      var1.a(var2, var3);
   }

   protected void setSelected(bu var1, x var2, boolean var3) {
      var1.a(var2, var3);
   }

   private void b(bu var1, Object var2, boolean var3) {
      boolean var4 = fj.z;
      if(var2 instanceof y.c.q) {
         this.setSelected(var1, (y.c.q)var2, var3);
         if(!var4) {
            return;
         }
      }

      if(var2 instanceof y.c.d) {
         this.setSelected(var1, (y.c.d)var2, var3);
         if(!var4) {
            return;
         }
      }

      if(var2 instanceof x) {
         this.setSelected(var1, (x)var2, var3);
         if(!var4) {
            return;
         }
      }

      if(var2 instanceof gZ) {
         this.setSelected(var1, (gZ)var2, var3);
         if(!var4) {
            return;
         }
      }

      if(var2 instanceof eU) {
         this.setSelected(var1, (eU)var2, var3);
      }

   }

   protected void unselectNodes(bu var1) {
      var1.O();
   }

   protected void unselectBends(bu var1) {
      var1.Q();
   }

   protected void unselectAll(bu var1) {
      var1.N();
   }

   protected boolean isSelectionEmpty(bu var1) {
      return var1.H();
   }

   protected boolean isSelected(bu var1, x var2) {
      return var1.a(var2);
   }

   protected boolean isSelected(bu var1, y.c.d var2) {
      return var1.r(var2);
   }

   protected boolean isSelected(bu var1, gZ var2) {
      return var1.a(var2);
   }

   protected boolean isSelected(bu var1, y.c.q var2) {
      return var1.v(var2);
   }

   protected boolean isSelected(bu var1, eU var2) {
      return var1.a(var2);
   }

   private boolean b(bu var1, Object var2) {
      return var2 instanceof y.c.q?this.isSelected(var1, (y.c.q)var2):(var2 instanceof y.c.d?this.isSelected(var1, (y.c.d)var2):(var2 instanceof x?this.isSelected(var1, (x)var2):(var2 instanceof gZ?this.isSelected(var1, (gZ)var2):(var2 instanceof eU?this.isSelected(var1, (eU)var2):false))));
   }

   protected boolean isOrthogonalRouting(y.c.d var1) {
      y.c.c var2 = c(this.getGraph2D());
      return var2 != null && var2 != this.eg?var2.d(var1):this.nf;
   }

   private static y.c.c c(bu var0) {
      y.c.c var1 = var0.c(ORTHOGONAL_ROUTING_DPKEY);
      if(var1 == null && var0.C() != null && var0.C().g() != var0) {
         var1 = var0.C().g().c(ORTHOGONAL_ROUTING_DPKEY);
      }

      return var1;
   }

   protected x createBend(bu var1, y.c.d var2, double var3, double var5) {
      return var1.i(var2).insertBend(var3, var5);
   }

   protected y.c.q createNode(bu var1, double var2, double var4) {
      return this.createNode(var1, var2, var4, (y.c.q)null);
   }

   protected y.c.q createNode(bu var1, double var2, double var4, y.c.q var6) {
      y.c.q var7 = var1.a(this.getGridX(var2), this.getGridY(var4));
      this.configureNode(var1, var7);
      if(var6 != null) {
         y.h.a.v var8 = y.h.a.v.a((y.c.i)var1);
         if(var8 != null) {
            y.h.a.a var9 = var1.t(var6).getAutoBoundsFeature();
            boolean var10 = var9 != null && var9.isAutoBoundsEnabled();
            if(var10) {
               var1.a((new y.c.y(var6)).a());
               var9.setAutoBoundsEnabled(false);
            }

            try {
               var8.c(var7, var6);
            } finally {
               if(var10) {
                  var9.setAutoBoundsEnabled(true);
               }

            }
         }
      }

      var1.T();
      return var7;
   }

   protected void configureNode(bu var1, y.c.q var2) {
      if(this.doAssignNodeLabel() && var1.t(var2).labelCount() > 0 && "".equals(var1.u(var2))) {
         var1.a(var2, Integer.toString(var1.f()));
      }

   }

   public void mousePressedRight(double var1, double var3) {
      boolean var6 = fj.z;
      if(this.doAllowMovingWithPopup()) {
         this.df = false;
         if(!var6) {
            return;
         }
      }

      gX var5;
      if(this.doAllowMoving()) {
         var5 = this.getMoveViewPortMode();
         if(var5 == null) {
            return;
         }

         this.setChild(var5, this.lastPressEvent, (MouseEvent)null);
         if(!var6) {
            return;
         }
      }

      var5 = this.getPopupMode();
      if(var5 != null) {
         this.setChild(var5, this.lastPressEvent, (MouseEvent)null);
      }

   }

   public void mouseDraggedRight(double var1, double var3) {
      if(this.doAllowMovingWithPopup()) {
         gX var5 = this.getMoveViewPortMode();
         if(var5 != null) {
            this.df = true;
            this.setChild(var5, this.lastPressEvent, this.lastDragEvent);
         }
      }

   }

   public void mouseReleasedRight(double var1, double var3) {
      if(this.doAllowMovingWithPopup()) {
         if(this.df) {
            this.df = false;
            if(!fj.z) {
               return;
            }
         }

         gX var5 = this.getPopupMode();
         if(var5 != null) {
            this.setChild(var5, this.lastPressEvent, (MouseEvent)null, this.lastReleaseEvent);
         }
      }

   }

   public void mouseMoved(double var1, double var3) {
      bu var5 = this.getGraph2D();
      cW var6 = this.getHitInfo(var1, var3);
      dz var7 = this.getMouseInputMode();
      if(this.doAllowMouseInput() && var7 != null) {
         dx var8 = var7.a(this.view, var1, var3, var6);
         if(var8 != null) {
            var7.a(var8);
            this.view.setToolTipText((String)null);
            this.view.setViewCursor(this.getDefaultCursor());
            this.setChild(var7, (MouseEvent)null, (MouseEvent)null, (MouseEvent)null);
            var7.mouseMoved(this.lastMoveEvent);
            return;
         }
      }

      if(this.doShowEdgeTips() || this.doShowNodeTips()) {
         String var9 = null;
         if(var6.i() != null) {
            if(this.doShowNodeTips()) {
               var9 = this.getNodeTip(var6.i());
            }
         } else if(var6.k() != null && this.doShowEdgeTips()) {
            var9 = this.getEdgeTip(var6.k());
         }

         if(var9 != null && var9.length() < 1) {
            var9 = null;
         }

         this.view.setToolTipText(var9);
      }

      if(this.doAllowResizeNodes()) {
         byte var10 = this.b(this.view, var5, var1, var3);
         if(var10 != 8) {
            this.view.setViewCursor(da.a(var10));
            return;
         }
      }

      if(this.doAllowMoveSelection()) {
         y.c.q var11 = var6.i();
         if(var11 != null && this.isSelected(var5, var11)) {
            this.view.setViewCursor(Cursor.getPredefinedCursor(13));
            return;
         }
      }

      if(this.doAllowBendCreation() && var6.k() != null) {
         this.view.setViewCursor(Cursor.getPredefinedCursor(12));
      } else if(this.doAllowMovePorts() && var6.n() != null && this.getMovePortMode() instanceof dI) {
         this.view.setViewCursor(((dI)this.getMovePortMode()).h());
      } else {
         this.view.setViewCursor(this.getDefaultCursor());
      }
   }

   private byte b(ch var1, bu var2, double var3, double var5) {
      boolean var10 = fj.z;
      y.c.x var7 = var2.o();

      byte var10000;
      while(true) {
         if(var7.f()) {
            y.c.q var8 = var7.e();
            var10000 = this.isSelected(var2, var8);
            if(var10) {
               break;
            }

            if(var10000 != 0) {
               byte var9 = var2.t(var8).hotSpotHit(var3, var5);
               if(var9 != 8) {
                  return var9;
               }
            }

            var7.g();
            if(!var10) {
               continue;
            }
         }

         var10000 = 8;
         break;
      }

      return var10000;
   }

   public void mouseClicked(double var1, double var3) {
      gX var5 = this.getEditNodeMode();
      if(this.doAllowNodeEditing() && var5 != null && !var5.isActive()) {
         y.c.q var6 = this.getHitInfo(var1, var3).i();
         if(var6 != null && this.isEditNodeGesture(var6, this.lastPressEvent, this.lastReleaseEvent, this.lastClickEvent)) {
            this.editNode(var6, this.lastClickEvent);
         }
      }

   }

   public void mouseEntered(MouseEvent var1) {
      this.zf = -1;
      super.mouseEntered(var1);
   }

   public boolean startEditor(dx var1) {
      dz var2 = this.getMouseInputMode();
      if(var1 != null && this.doAllowMouseInput() && var2 != null) {
         boolean var3 = var2.a(var1);
         if(var3) {
            this.setChild(var2, (MouseEvent)null, (MouseEvent)null);
         }

         return var3;
      } else {
         return false;
      }
   }

   private void j(double var1, double var3) {
      boolean var7;
      label105: {
         var7 = fj.z;
         if(this.isCyclicSelectionEnabled() && this.isCyclicSelectionModifierPressed()) {
            label101: {
               cW var5 = this.createCyclicHitInfo(var1, var3);
               if(this.b(var5)) {
                  this.of = var5;
                  if(!var7) {
                     break label101;
                  }
               }

               this.of = this.of.a(this.getGraph2D(), var1, var3);
            }

            this.setLastHitInfo(this.of);
            this.te = this.of;
            if(!var7) {
               break label105;
            }
         }

         this.te = this.getHitInfo(var1, var3);
      }

      this.af = false;
      this.ve = var1;
      this.ef = var3;
      bu var8 = this.getGraph2D();
      if(this.doAllowResizeNodes()) {
         byte var6 = this.b(this.view, var8, var1, var3);
         if(var6 != 8) {
            this.zf = 11;
            return;
         }
      }

      if(this.te.a()) {
         Object var9 = this.te.h();
         if(var9 instanceof fL) {
            this.zf = 12;
            return;
         }

         if(var9 instanceof y.c.q) {
            this.pressedNode = (y.c.q)var9;
            if(this.isSelected(var8, this.pressedNode)) {
               this.zf = 2;
               if(!var7) {
                  return;
               }
            }

            this.zf = 1;
            return;
         }

         if(var9 instanceof eU) {
            this.pressedNode = ((eU)var9).b().getNode();
            if(this.isSelected(var8, (eU)var9)) {
               this.zf = 14;
               if(!var7) {
                  return;
               }
            }

            this.zf = 13;
            return;
         }

         if(var9 instanceof x) {
            if(this.isSelected(var8, (x)var9)) {
               this.zf = 4;
               if(!var7) {
                  return;
               }
            }

            this.zf = 3;
            return;
         }

         if(var9 instanceof y.c.d) {
            if(this.isSelected(var8, (y.c.d)var9)) {
               this.zf = 6;
               if(!var7) {
                  return;
               }
            }

            this.zf = 5;
            return;
         }

         if(var9 instanceof eR) {
            if(this.isSelected(var8, (gZ)((eR)var9))) {
               this.zf = 9;
               if(!var7) {
                  return;
               }
            }

            this.zf = 7;
            return;
         }

         if(var9 instanceof aA) {
            if(this.isSelected(var8, (gZ)((aA)var9))) {
               this.zf = 10;
               if(!var7) {
                  return;
               }
            }

            this.zf = 8;
            return;
         }
      }

      this.zf = 0;
   }

   private boolean b(cW var1) {
      boolean var4 = fj.z;
      if(this.of != null && var1.a(this.of)) {
         if(!this.of.a()) {
            return false;
         } else if(!gg.a(this.getGraph2D(), this.of.h())) {
            return true;
         } else {
            y.c.C var2 = this.of.d();
            var2.g();

            boolean var10000;
            while(true) {
               if(var2.f()) {
                  Object var3 = var2.d();
                  var10000 = gg.a(this.getGraph2D(), var3);
                  if(var4) {
                     break;
                  }

                  if(var10000) {
                     return true;
                  }

                  var2.g();
                  if(!var4) {
                     continue;
                  }
               }

               var10000 = false;
               break;
            }

            return var10000;
         }
      } else {
         return true;
      }
   }

   protected boolean isCyclicSelectionModifierPressed() {
      return this.lastPressEvent != null && (this.lastPressEvent.getModifiers() & this.getCyclicSelectionModifierMask()) != 0;
   }

   protected cW createCyclicHitInfo(double var1, double var3) {
      int var7;
      label17: {
         bu var5 = this.getGraph2D();
         int var6 = this.b(var5);
         var7 = -1;
         if(!this.isMixedSelectionEnabled() && this.isModifierPressed(this.lastPressEvent) && var6 != 0) {
            var7 = var6;
            if(!fj.z) {
               break label17;
            }
         }

         if(!this.doAllowLabelSelection()) {
            var7 ^= 48;
         }
      }

      cW var8 = this.view.getHitInfoFactory().a(var1, var3, var7, false);
      var8 = this.j(var8, var1, var3);
      return var8;
   }

   private int b(bu var1) {
      int var2 = 0;
      if(this.b(var1, 9)) {
         var2 |= 9;
      }

      if(this.b(var1, 2)) {
         var2 |= 2;
      }

      if(this.b(var1, 48)) {
         var2 |= 48;
      }

      if(this.b(var1, 64)) {
         var2 |= 64;
      }

      return var2;
   }

   private cW j(cW var1, double var2, double var4) {
      boolean var10 = fj.z;
      if(!var1.b()) {
         return var1;
      } else {
         bu var6 = this.getGraph2D();
         HashSet var7 = new HashSet();
         y.c.C var8 = var1.d();

         int var10000;
         while(true) {
            if(var8.f()) {
               Object var9 = var8.d();
               var10000 = this.b(this.getGraph2D(), var9);
               if(var10) {
                  break;
               }

               if(var10000 != 0) {
                  var7.add(var9);
                  if(var7.size() > 1) {
                     return var1;
                  }
               }

               var8.g();
               if(!var10) {
                  continue;
               }
            }

            var10000 = var7.size();
            break;
         }

         if(var10000 == 1) {
            Object var11 = var7.iterator().next();

            while(var1.h() != var11) {
               var1 = var1.a(var6, var2, var4);
               if(var10) {
                  return var1;
               }

               if(var10) {
                  break;
               }
            }

            var1 = var1.a(var6, var2, var4);
         }

         return var1;
      }
   }

   protected String getNodeTip(y.c.q var1) {
      fj var2 = this.getGraph2D().t(var1);
      return var2.labelCount() > 0?var2.getLabel(0).getText():null;
   }

   protected String getEdgeTip(y.c.d var1) {
      aB var2 = this.getGraph2D().i(var1);
      return var2.labelCount() > 0?var2.getLabel(0).getText():null;
   }

   protected void nodeCreated(y.c.q var1) {
   }

   protected void bendCreated(bu var1, y.c.d var2, x var3, double var4, double var6) {
   }

   protected void nodeClicked(y.c.q var1) {
      if(this.b(this.getGraph2D(), var1)) {
         this.groupNodeClicked(var1);
      }

   }

   protected void groupNodeClicked(y.c.q var1) {
      boolean var8 = fj.z;
      if(this.doAllowNodeCreation() && this.isChildNodeCreationEnabled()) {
         bu var2 = this.getGraph2D();
         if(!this.isSelected(var2, var1)) {
            double var3;
            double var5;
            label38: {
               if(this.lastReleaseEvent != null) {
                  var3 = this.translateX(this.lastReleaseEvent.getX());
                  var5 = this.translateY(this.lastReleaseEvent.getY());
                  if(!var8) {
                     break label38;
                  }
               }

               if(this.lastClickEvent != null) {
                  var3 = this.translateX(this.lastClickEvent.getX());
                  var5 = this.translateY(this.lastClickEvent.getY());
                  if(!var8) {
                     break label38;
                  }
               }

               fj var7 = var2.t(var1);
               var3 = var7.getCenterX();
               var5 = var7.getCenterX();
            }

            if(!this.isGroupNodeBorderHit(var2, var1, var3, var5, this.isSelectOnGroupNodeLabelEnabled())) {
               if(this.isSelectionEmpty(var2)) {
                  this.setEditing(true);
                  y.c.q var9 = this.createNode(var2, var3, var5, var1);
                  if(var9 != null) {
                     var2.T();
                     this.nodeCreated(var9);
                  }

                  this.setEditing(false);
                  if(!var8) {
                     return;
                  }
               }

               this.unselectAll(var2);
               var2.T();
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

   public void setMoveViewPortMode(gX var1) {
      this.moveViewPortMode = var1;
   }

   public void setMoveLabelMode(gX var1) {
      this.moveLabelMode = var1;
   }

   public gX getMovePortMode() {
      return this.movePortMode;
   }

   public void setMovePortMode(gX var1) {
      this.movePortMode = var1;
   }

   public gX getHotSpotMode() {
      return this.hotSpotMode;
   }

   public void setHotSpotMode(gX var1) {
      this.hotSpotMode = var1;
   }

   public gX getMoveNodePortMode() {
      return this.moveNodePortMode;
   }

   public void setMoveNodePortMode(gX var1) {
      this.moveNodePortMode = var1;
   }

   protected boolean isCreateEdgeGesture(MouseEvent var1, MouseEvent var2) {
      if(this.pressedNode != null && var1 != null) {
         bu var3 = this.getGraph2D();
         return !this.isSelected(var3, this.pressedNode) && (!this.b(var3, this.pressedNode) || this.isGroupNodeBorderHit(var3, this.pressedNode, this.translateX(var1.getX()), this.translateY(var1.getY()), this.isCreateEdgeOnGroupNodeLabelEnabled()));
      } else {
         return false;
      }
   }

   protected boolean isEditNodeGesture(y.c.q var1, MouseEvent var2, MouseEvent var3, MouseEvent var4) {
      return var4.getClickCount() == 2;
   }

   public Cursor getDefaultCursor() {
      return this.cg;
   }

   public void setDefaultCursor(Cursor var1) {
      this.cg = var1;
   }

   protected boolean editNode(y.c.q var1, EventObject var2) {
      gX var3 = this.getEditNodeMode();
      if(this.doAllowNodeEditing() && var3 != null) {
         if(var3 instanceof D) {
            D var4 = (D)var3;
            if(var4.a(var1)) {
               this.setChild(var4, (MouseEvent)null, (MouseEvent)null);
               if(!var4.a(var1, var2)) {
                  var4.reactivateParent();
                  return false;
               } else {
                  return true;
               }
            } else {
               return false;
            }
         } else {
            this.setChild(var3, (MouseEvent)null, (MouseEvent)null);
            return true;
         }
      } else {
         return false;
      }
   }

   public gX getOrthogonalMoveBendsMode() {
      if(this.tf == null) {
         this.tf = this.createOrthogonalMoveBendsMode();
      }

      return this.tf;
   }

   public void setOrthogonalMoveBendsMode(gX var1) {
      this.tf = var1;
   }

   protected gX createOrthogonalMoveBendsMode() {
      return new fu();
   }

   protected cW createLabelHitInfo(double var1, double var3) {
      return new cW(this.view, var1, var3, false, 5);
   }

   public void setGroupBorderWidth(int var1) {
      this.pe = var1;
   }

   public int getGroupBorderWidth() {
      return this.pe;
   }

   public boolean isCreateEdgeOnGroupNodeLabelEnabled() {
      return this.uf;
   }

   public void setCreateEdgeOnGroupNodeLabelEnabled(boolean var1) {
      this.uf = var1;
   }

   public boolean isChildNodeCreationEnabled() {
      return this.mg;
   }

   public void setChildNodeCreationEnabled(boolean var1) {
      this.mg = var1;
   }

   public boolean isSelectOnGroupNodeLabelEnabled() {
      return this.wf;
   }

   public void setSelectOnGroupNodeLabelEnabled(boolean var1) {
      this.wf = var1;
   }

   static boolean b(y.c.d var0, bu var1) {
      y.c.c var2 = c(var1);
      return var2 != null && var2.d(var0);
   }

   static y.g.p access$000(aC var0) {
      return var0.eg;
   }

   static y.c.c access$100(bu var0) {
      return c(var0);
   }
}
