package y.h;

import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;
import y.h.bu;
import y.h.bw;
import y.h.cW;
import y.h.ch;
import y.h.fj;
import y.h.gI;
import y.h.gU;

public class gX implements MouseInputListener {
   public static final String ACTIVE_PROPERTY = "active";
   public static final String CHILD_MODE_PROPERTY = "child";
   public static final String ACTIVE_VIEW_PROPERTY = "activeView";
   public static final String GRAB_FOCUS_ENABLED_PROPERTY = "grabFocusEnabled";
   public static final String PARENT_MODE_PROPERTY = "parent";
   public static final String NAME_PROPERTY = "name";
   public static final String MODIFIER_MASK_PROPERTY = "modifierMask";
   public static final String EDITING_PROPERTY = "editing";
   protected ch view;
   protected int originalX;
   protected int originalY;
   private int k;
   private int m;
   private boolean g;
   private boolean b;
   private boolean n;
   private int j;
   protected MouseEvent lastPressEvent;
   protected MouseEvent lastDragEvent;
   protected MouseEvent lastMoveEvent;
   protected MouseEvent lastReleaseEvent;
   protected MouseEvent lastClickEvent;
   private cW c;
   private String o;
   private gX d;
   private gX f;
   private boolean l;
   private boolean e;
   private boolean i;
   private PropertyChangeSupport h;

   public gX() {
      this.j = 1;
      this.e = true;
      this.d = null;
      this.l = false;
   }

   public gX(gU var1) {
      this();
      if(var1 != null) {
         gI var2 = var1.getCurrentView();
         this.view = null;
         if(var2 != null && var2 instanceof ch) {
            this.view = (ch)var2;
         }
      }

   }

   public void addPropertyChangeListener(PropertyChangeListener var1) {
      if(this.h == null) {
         this.h = new PropertyChangeSupport(this);
      }

      this.h.addPropertyChangeListener(var1);
   }

   public void addPropertyChangeListener(String var1, PropertyChangeListener var2) {
      if(this.h == null) {
         this.h = new PropertyChangeSupport(this);
      }

      this.h.addPropertyChangeListener(var1, var2);
   }

   public void removePropertyChangeListener(PropertyChangeListener var1) {
      if(this.h != null) {
         this.h.removePropertyChangeListener(var1);
      }

   }

   public void removePropertyChangeListener(String var1, PropertyChangeListener var2) {
      if(this.h != null) {
         this.h.removePropertyChangeListener(var1, var2);
      }

   }

   protected void firePropertyChange(String var1, Object var2, Object var3) {
      if(this.h != null) {
         this.h.firePropertyChange(var1, var2, var3);
      }

   }

   protected void firePropertyChange(String var1, boolean var2, boolean var3) {
      if(this.h != null) {
         this.h.firePropertyChange(var1, var2, var3);
      }

   }

   protected void firePropertyChange(String var1, int var2, int var3) {
      if(this.h != null) {
         this.h.firePropertyChange(var1, var2, var3);
      }

   }

   public boolean isEditing() {
      return this.b;
   }

   protected void setEditing(boolean var1) {
      if(this.b != var1) {
         this.b = var1;
         this.firePropertyChange("editing", !var1, var1);
      }

   }

   public void cancelEditing() {
      if(this.isEditing()) {
         this.setEditing(false);
      }

   }

   public void setActiveView(ch var1) {
      ch var2 = this.view;
      if(var2 != var1) {
         this.view = var1;
         this.firePropertyChange("activeView", var2, var1);
      }

   }

   public void activate(boolean var1) {
      if(this.i != var1) {
         this.i = var1;
         this.firePropertyChange("active", !var1, var1);
      }

   }

   public boolean isActive() {
      return this.i;
   }

   public void setGridMode(boolean var1) {
      this.d().e(var1);
   }

   public boolean isGridMode() {
      return this.d().s();
   }

   public void setGrabFocusEnabled(boolean var1) {
      if(this.e != var1) {
         this.e = var1;
         this.firePropertyChange("grabFocusEnabled", !var1, var1);
      }

   }

   public boolean isGrabFocusEnabled() {
      return this.e;
   }

   public void setChild(gX var1, MouseEvent var2, MouseEvent var3) {
      this.setChild(var1, var2, var3, (MouseEvent)null);
   }

   public void setChild(gX var1, MouseEvent var2, MouseEvent var3, MouseEvent var4) {
      gX var5 = this.d;
      if(var1 != null) {
         if(var5 != var1 && var5 != null) {
            this.deactivateChild(var5);
         }

         var1.setActiveView(this.view);
         var1.setParent(this);
         var1.setLastHitInfo(this.getLastHitInfo());
         this.d = var1;
         if(var5 != var1) {
            this.firePropertyChange("child", var5, var1);
         }

         var1.init();
         var1.activate(true);
         if(var2 != null) {
            var1.mousePressed(var2);
         }

         if(var3 != null) {
            var1.mouseDragged(var3);
         }

         if(var4 == null) {
            return;
         }

         var1.mouseReleased(var4);
         if(!fj.z) {
            return;
         }
      }

      if(var5 != null) {
         this.deactivateChild(var5);
      }

      this.d = null;
      if(var5 != var1) {
         this.firePropertyChange("child", var5, var1);
      }

   }

   protected void deactivateChild(gX var1) {
      if(var1 != null) {
         if(var1.isEditing()) {
            var1.cancelEditing();
         }

         var1.activate(false);
         var1.setParent((gX)null);
      }

   }

   public void init() {
   }

   public void reactivateParent() {
      if(this.isEditing()) {
         this.cancelEditing();
      }

      if(this.b()) {
         this.c(false);
         this.view.getViewControl().b();
         if(!fj.z) {
            return;
         }
      }

      if(this.f != null) {
         this.f.setChild((gX)null, (MouseEvent)null, (MouseEvent)null);
      }
   }

   public void setParent(gX var1) {
      if(this.f != var1) {
         gX var2 = this.f;
         this.f = var1;
         this.firePropertyChange("parent", var2, this.f);
      }

   }

   public gX getParent() {
      return this.f;
   }

   public gX getChild() {
      return this.d;
   }

   public void mousePressed(MouseEvent var1) {
      boolean var7 = fj.z;
      if(this.d != null) {
         this.d.mousePressed(var1);
         if(!var7) {
            return;
         }
      }

      if(this.isGrabFocusEnabled()) {
         this.view.requestFocus();
      }

      this.lastPressEvent = var1;
      this.k = this.originalX = var1.getX();
      this.m = this.originalY = var1.getY();
      this.g = true;
      bw var2 = this.d();
      double var3 = var2.c((double)var1.getX());
      double var5 = var2.d((double)var1.getY());
      this.b(false);
      if(var1.isPopupTrigger() || SwingUtilities.isRightMouseButton(var1)) {
         this.b(true);
         if(this.isModifierPressed(var1)) {
            this.mouseShiftPressedRight(var3, var5);
            if(!var7) {
               return;
            }
         }

         this.mousePressedRight(var3, var5);
         if(!var7) {
            return;
         }
      }

      if(SwingUtilities.isLeftMouseButton(var1)) {
         if(this.isModifierPressed(var1)) {
            this.mouseShiftPressedLeft(var3, var5);
            if(!var7) {
               return;
            }
         }

         this.mousePressedLeft(var3, var5);
         if(!var7) {
            return;
         }
      }

      if(SwingUtilities.isMiddleMouseButton(var1)) {
         if(this.isModifierPressed(var1)) {
            this.mouseShiftPressedMiddle(var3, var5);
            if(!var7) {
               return;
            }
         }

         this.mousePressedMiddle(var3, var5);
      }

   }

   public void mouseReleased(MouseEvent var1) {
      boolean var7 = fj.z;
      this.lastReleaseEvent = var1;
      if(this.d != null) {
         this.d.mouseReleased(var1);
         if(!var7) {
            return;
         }
      }

      this.originalX = var1.getX();
      this.originalY = var1.getY();
      bw var2 = this.d();
      double var3 = var2.c((double)var1.getX());
      double var5 = var2.d((double)var1.getY());
      this.mouseReleased(var3, var5);
      if(var1.isPopupTrigger() || SwingUtilities.isRightMouseButton(var1) || this.c()) {
         label39: {
            if(this.isModifierPressed(var1)) {
               this.mouseShiftReleasedRight(var3, var5);
               if(!var7) {
                  break label39;
               }
            }

            this.mouseReleasedRight(var3, var5);
         }

         this.b(false);
         if(!var7) {
            return;
         }
      }

      if(SwingUtilities.isLeftMouseButton(var1)) {
         if(this.isModifierPressed(var1)) {
            this.mouseShiftReleasedLeft(var3, var5);
            if(!var7) {
               return;
            }
         }

         this.mouseReleasedLeft(var3, var5);
         if(!var7) {
            return;
         }
      }

      if(SwingUtilities.isMiddleMouseButton(var1)) {
         if(this.isModifierPressed(var1)) {
            this.mouseShiftReleasedMiddle(var3, var5);
            if(!var7) {
               return;
            }
         }

         this.mouseReleasedMiddle(var3, var5);
      }

   }

   public void mouseClicked(MouseEvent var1) {
      if(this.d != null) {
         this.d.mouseClicked(var1);
         if(!fj.z) {
            return;
         }
      }

      this.originalX = var1.getX();
      this.originalY = var1.getY();
      bw var2 = this.d();
      double var3 = var2.c((double)var1.getX());
      double var5 = var2.d((double)var1.getY());
      this.lastClickEvent = var1;
      this.mouseClicked(var3, var5);
   }

   public void mouseDragged(MouseEvent var1) {
      boolean var7 = fj.z;
      this.lastDragEvent = var1;
      if(this.d != null) {
         this.d.mouseDragged(var1);
         if(!var7) {
            return;
         }
      }

      if(!this.b(var1.getX(), var1.getY())) {
         this.g = false;
         this.originalX = var1.getX();
         this.originalY = var1.getY();
         bw var2 = this.d();
         double var3 = var2.c((double)var1.getX());
         double var5 = var2.d((double)var1.getY());
         if(SwingUtilities.isRightMouseButton(var1)) {
            this.mouseDraggedRight(var3, var5);
            if(!var7) {
               return;
            }
         }

         if(SwingUtilities.isLeftMouseButton(var1)) {
            this.mouseDraggedLeft(var3, var5);
            if(!var7) {
               return;
            }
         }

         if(SwingUtilities.isMiddleMouseButton(var1)) {
            this.mouseDraggedMiddle(var3, var5);
         }
      }

   }

   public void mouseMoved(MouseEvent var1) {
      if(this.d != null) {
         this.d.mouseMoved(var1);
         if(!fj.z) {
            return;
         }
      }

      this.originalX = var1.getX();
      this.originalY = var1.getY();
      bw var2 = this.d();
      double var3 = var2.c((double)var1.getX());
      double var5 = var2.d((double)var1.getY());
      this.lastMoveEvent = var1;
      this.mouseMoved(var3, var5);
   }

   public void mouseEntered(MouseEvent var1) {
      if(this.d != null) {
         this.d.mouseEntered(var1);
      }

   }

   public void mouseExited(MouseEvent var1) {
      if(this.d != null) {
         this.d.mouseExited(var1);
      }

   }

   protected double getGridX(double var1) {
      if(!this.isGridMode()) {
         return var1;
      } else {
         double var3 = this.d().u();
         return Math.floor(var1 / var3 + 0.5D) * var3;
      }
   }

   protected double getGridY(double var1) {
      if(!this.isGridMode()) {
         return var1;
      } else {
         double var3 = this.d().u();
         return Math.floor(var1 / var3 + 0.5D) * var3;
      }
   }

   bw d() {
      return this.view.r();
   }

   protected bu getGraph2D() {
      return this.view.getGraph2D();
   }

   protected double translateX(int var1) {
      return this.d().c((double)var1);
   }

   protected double translateY(int var1) {
      return this.d().d((double)var1);
   }

   public void setName(String var1) {
      if(var1 != this.o && (this.o == null || !this.o.equals(var1))) {
         String var2 = this.o;
         this.o = var1;
         this.firePropertyChange("name", var2, this.o);
      }

   }

   public String getName() {
      return this.o;
   }

   cW b(double var1, double var3, boolean var5) {
      return this.view.getHitInfoFactory().a(var1, var3, -1, var5);
   }

   cW b(double var1, double var3, int var5, boolean var6) {
      boolean var8 = fj.z;
      byte var7;
      switch(var5) {
      case 0:
         var7 = 4;
         if(!var8) {
            break;
         }
      case 1:
         var7 = 8;
         if(!var8) {
            break;
         }
      case 2:
         var7 = 32;
         if(!var8) {
            break;
         }
      case 3:
         var7 = 2;
         if(!var8) {
            break;
         }
      case 4:
         var7 = 1;
         if(!var8) {
            break;
         }
      case 5:
         var7 = 16;
         if(!var8) {
            break;
         }
      case 6:
         var7 = 64;
         if(var8) {
            throw new IllegalArgumentException("unknown type: " + var5);
         }
         break;
      default:
         throw new IllegalArgumentException("unknown type: " + var5);
      }

      return this.view.getHitInfoFactory().a(var1, var3, var7, var6);
   }

   protected cW getHitInfo(MouseEvent var1) {
      return this.getHitInfo(this.translateX(var1.getX()), this.translateY(var1.getY()));
   }

   protected cW getHitInfo(double var1, double var3) {
      this.c = this.b(var1, var3, true);
      return this.c;
   }

   protected cW getLastHitInfo() {
      return this.c;
   }

   public void setLastHitInfo(cW var1) {
      this.c = var1;
   }

   public void mousePressedLeft(double var1, double var3) {
   }

   public void mouseShiftPressedLeft(double var1, double var3) {
      this.mousePressedLeft(var1, var3);
   }

   public void mouseShiftPressedRight(double var1, double var3) {
      this.mousePressedRight(var1, var3);
   }

   public void mouseShiftPressedMiddle(double var1, double var3) {
      this.mousePressedMiddle(var1, var3);
   }

   public void mousePressedMiddle(double var1, double var3) {
   }

   public void mousePressedRight(double var1, double var3) {
   }

   public void mouseReleased(double var1, double var3) {
   }

   public void mouseReleasedLeft(double var1, double var3) {
   }

   public void mouseShiftReleasedLeft(double var1, double var3) {
      this.mouseReleasedLeft(var1, var3);
   }

   public void mouseShiftReleasedRight(double var1, double var3) {
      this.mouseReleasedRight(var1, var3);
   }

   public void mouseReleasedMiddle(double var1, double var3) {
   }

   public void mouseShiftReleasedMiddle(double var1, double var3) {
      this.mouseReleasedMiddle(var1, var3);
   }

   public void mouseReleasedRight(double var1, double var3) {
   }

   public void mouseDraggedLeft(double var1, double var3) {
   }

   public void mouseDraggedMiddle(double var1, double var3) {
   }

   public void mouseDraggedRight(double var1, double var3) {
   }

   public void mouseClicked(double var1, double var3) {
   }

   public void mouseMoved(double var1, double var3) {
   }

   private boolean b(int var1, int var2) {
      int var3 = var1 - this.k;
      int var4 = var2 - this.m;
      return this.g && var3 * var3 + var4 * var4 < 9;
   }

   protected boolean isModifierPressed(MouseEvent var1) {
      return (var1.getModifiers() & this.j) != 0;
   }

   void c(boolean var1) {
      this.l = var1;
   }

   boolean b() {
      return this.l;
   }

   public int getModifierMask() {
      return this.j;
   }

   public void setModifierMask(int var1) {
      int var2 = this.j;
      if(var2 != var1) {
         this.j = var1;
         this.firePropertyChange("modifierMask", var2, var1);
      }

   }

   private void b(boolean var1) {
      this.n = var1;
   }

   private boolean c() {
      return this.n;
   }

   public MouseEvent getLastPressEvent() {
      return this.lastPressEvent;
   }

   public MouseEvent getLastDragEvent() {
      return this.lastDragEvent;
   }

   public MouseEvent getLastMoveEvent() {
      return this.lastMoveEvent;
   }

   public MouseEvent getLastReleaseEvent() {
      return this.lastReleaseEvent;
   }

   public MouseEvent getLastClickEvent() {
      return this.lastClickEvent;
   }
}
