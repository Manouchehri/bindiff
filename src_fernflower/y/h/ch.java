package y.h;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.Point2D.Double;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.ActionMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JToolTip;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import y.h.az;
import y.h.bI;
import y.h.bu;
import y.h.bw;
import y.h.cV;
import y.h.cY;
import y.h.cZ;
import y.h.cd;
import y.h.ci;
import y.h.cj;
import y.h.ck;
import y.h.cl;
import y.h.cm;
import y.h.fj;
import y.h.gI;
import y.h.gJ;
import y.h.gT;
import y.h.gU;
import y.h.gV;
import y.h.gX;
import y.h.gZ;
import y.h.if;
import y.h.il;
import y.h.w;

public class ch extends JComponent implements ScrollPaneConstants, y.b.c, gI, gU {
   public static final int NORMAL_MODE = 0;
   public static final int MOVE_SELECTION_MODE = 1;
   public static final int SELECTION_BOX_MODE = 2;
   public static final int LAYER_MODE = 3;
   public static final int UNBUFFERED_MODE = 4;
   public static final byte FG_LAYER = 0;
   public static final byte BG_LAYER = 1;
   public static final int CONTENT_POLICY_GRAPH = 0;
   public static final int CONTENT_POLICY_GRAPH_DRAWABLES = 1;
   public static final int CONTENT_POLICY_FOREGROUND_DRAWABLES = 2;
   public static final int CONTENT_POLICY_BACKGROUND_DRAWABLES = 4;
   private gV oc;
   private bw ic;
   private bu fc;
   private cZ nc;
   private JScrollBar mc;
   private JScrollBar qc;
   private int hc;
   private int ec;
   private if pc;
   private boolean sc;
   private boolean lc;
   private JPanel gc;
   private int rc;
   private cl jc;
   private RenderingHints kc;

   public ch() {
      this(new bu());
   }

   public ch(bu var1) {
      this.hc = 20;
      this.ec = 30;
      this.b(var1);
      this.setViewControl(new gV(this));
   }

   public ch(bu var1, gV var2) {
      this.hc = 20;
      this.ec = 30;
      this.b(var1);
      if(var2 != null) {
         this.setViewControl(var2);
      }

   }

   private void b(bu var1) {
      this.putClientProperty("UnitIncrementPixels", new Integer(20));
      this.fc = var1;
      var1.b((gI)this);
      this.nc = new cY(this);
      this.jc = new cl((ci)null);
      this.ic = this.u();
      this.ic.addMouseListener(this.jc);
      this.ic.addMouseMotionListener(this.jc);
      ck var2 = new ck(this);
      this.qc = new JScrollBar(0);
      this.qc.addAdjustmentListener(var2);
      this.mc = new JScrollBar(1);
      this.mc.addAdjustmentListener(var2);
      this.pc = new if();
      this.setLayout(this.pc);
      this.gc = this.createGlassPane();
      if(this.gc != null) {
         this.add(this.gc, "GLASS_PANE");
      }

      this.add(this.ic, "CANVAS");
      this.add(this.mc, "VERTICAL_SCROLLBAR");
      this.add(this.qc, "HORIZONTAL_SCROLLBAR");
      JPanel var3 = new JPanel();
      this.add(var3, "CORNER_COMPONENT");
      if(this.gc != null) {
         this.gc.setPreferredSize(this.pc.preferredLayoutSize(this));
      }

      this.setOpaque(this.mc.isOpaque() && this.qc.isOpaque() && var3.isOpaque() && this.ic.isOpaque());
      this.setPreferredSize(new Dimension(480, 480));
      this.kc = new RenderingHints(new HashMap());
      this.kc.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
      this.registerDefaultViewActions();
   }

   public boolean isOptimizedDrawingEnabled() {
      return this.gc == null || this.gc.getComponentCount() == 0;
   }

   protected void registerDefaultViewActions() {
      boolean var6 = fj.z;
      ActionMap var1 = this.getCanvasComponent().getActionMap();
      if(var1 == null) {
         var1 = new ActionMap();
         this.getCanvasComponent().setActionMap(var1);
      }

      ActionMap var2 = (new cm(this)).v();
      Object[] var3 = var2.keys();
      int var4 = 0;

      while(var4 < var3.length) {
         Object var5 = var3[var4];
         if(var1.get(var5) == null) {
            var1.put(var5, var2.get(var5));
         }

         ++var4;
         if(var6) {
            break;
         }
      }

   }

   bw u() {
      return new bw(this);
   }

   MouseEvent p() {
      return this.jc.a;
   }

   protected JPanel createGlassPane() {
      ci var1 = new ci(this);
      var1.setOpaque(false);
      var1.setBackground((Color)null);
      return var1;
   }

   public JPanel getGlassPane() {
      return this.gc;
   }

   public void fitWorldRect() {
      this.ic.l();
   }

   public void setFitContentOnResize(boolean var1) {
      this.lc = var1;
   }

   public boolean getFitContentOnResize() {
      return this.lc;
   }

   public void setBounds(int var1, int var2, int var3, int var4) {
      y.g.o.a(this, ">>>setBounds");
      super.setBounds(var1, var2, var3, var4);
      y.g.o.a(this, "<<<setBounds");
   }

   public void setViewControl(gV var1) {
      if(this.oc != null) {
         this.oc.a();
      }

      this.oc = var1;
      this.oc.a((gU)this);
   }

   public gV getViewControl() {
      return this.oc;
   }

   public int getHorizontalScrollBarPolicy() {
      return this.ec;
   }

   public int getVerticalScrollBarPolicy() {
      return this.hc;
   }

   public void setHorizontalScrollBarPolicy(int var1) {
      this.ec = var1;
   }

   public void setVerticalScrollBarPolicy(int var1) {
      this.hc = var1;
   }

   public void setScrollBarPolicy(int var1, int var2) {
      this.hc = var1;
      this.ec = var2;
   }

   void q() {
      this.sc = true;
      Rectangle var5 = this.ic.j();
      int var1 = var5.x;
      int var2 = var1 + var5.width;
      int var3 = (int)((double)this.ic.getWidth() / this.getZoom());
      int var4 = (int)this.ic.b.x;
      this.qc.setValues(var4, var3, var1, var2);
      var1 = var5.y;
      var2 = var1 + var5.height;
      var3 = (int)((double)this.ic.getHeight() / this.getZoom());
      var4 = (int)this.ic.b.y;
      this.mc.setValues(var4, var3, var1, var2);
      this.mc.setBlockIncrement(this.mc.getVisibleAmount() / 2);
      this.qc.setBlockIncrement(this.qc.getVisibleAmount() / 2);
      Object var6 = this.getClientProperty("UnitIncrementPixels");
      if(var6 instanceof Number) {
         int var7 = ((Number)var6).intValue();
         int var8 = (int)((double)var7 / this.getZoom());
         if(var8 > 0) {
            this.mc.setUnitIncrement(var8);
            this.qc.setUnitIncrement(var8);
         }
      }

      this.sc = false;
   }

   public boolean adjustScrollBarVisibility() {
      boolean var1 = this.pc.a(this);
      if(var1) {
         this.doLayout();
      }

      return var1;
   }

   void b(int var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      JScrollBar var6 = this.b(var3, var4);
      if(var6.isVisible()) {
         int var7 = var1 * b(var6, var2, var5);
         if(var5) {
            var6.setValue(Math.max(var6.getMinimum(), var6.getValue() + var7));
            if(!fj.z) {
               return;
            }
         }

         var6.setValue(Math.min(var6.getMaximum() - var6.getModel().getExtent(), var6.getValue() + var7));
      }

   }

   private JScrollBar b(boolean var1, boolean var2) {
      if(var2) {
         return var1?this.qc:this.mc;
      } else {
         JScrollBar var3 = this.qc;
         JScrollBar var4 = this.mc;
         return var4.isVisible()?(var3.isVisible()?(var1?var3:var4):var4):(var3.isVisible()?var3:(var1?var3:var4));
      }
   }

   private static int b(JScrollBar var0, boolean var1, boolean var2) {
      return var1?var0.getBlockIncrement(var2?-1:1):var0.getUnitIncrement(var2?-1:1);
   }

   static ch b(Object var0) {
      if(var0 instanceof bw) {
         Container var1 = ((bw)var0).getParent();
         if(var1 instanceof ch) {
            return (ch)var1;
         }
      }

      return null;
   }

   public boolean isValidateRoot() {
      return false;
   }

   protected cV createGraphicsContext() {
      cV var1 = new cV();
      var1.a(this);
      var1.b(SwingUtilities.getRoot(this) == null);
      return var1;
   }

   public void addViewMode(gX var1) {
      if(var1 != null) {
         this.r().a(var1);
         if(!fj.z) {
            return;
         }
      }

      throw new NullPointerException();
   }

   public void removeViewMode(gX var1) {
      if(var1 != null) {
         this.r().b(var1);
         if(!fj.z) {
            return;
         }
      }

      throw new NullPointerException();
   }

   public Iterator getViewModes() {
      return Collections.unmodifiableList(this.r().E()).iterator();
   }

   public boolean isInputSuppressed() {
      return this.ic.a();
   }

   public void setInputSuppressed(boolean var1) {
      this.ic.a(var1);
   }

   public void setGridMode(boolean var1) {
      this.ic.e(var1);
   }

   public void setGridVisible(boolean var1) {
      this.ic.g(var1);
   }

   public boolean getGridMode() {
      return this.ic.s();
   }

   public boolean isGridVisible() {
      return this.ic.C();
   }

   public void setGridResolution(double var1) {
      this.ic.g(var1);
   }

   public double getGridResolution() {
      return this.ic.u();
   }

   public void setGridType(int var1) {
      this.ic.b(var1);
   }

   public int getGridType() {
      return this.ic.t();
   }

   public void setGridColor(Color var1) {
      this.ic.a(var1);
   }

   public Color getGridColor() {
      return this.ic.r();
   }

   public void setWorldRect(int var1, int var2, int var3, int var4) {
      this.ic.a(var1, var2, var3, var4);
   }

   public Rectangle getWorldRect() {
      return this.ic.j();
   }

   public void setWorldRect2D(double var1, double var3, double var5, double var7) {
      this.ic.c(var1, var3, var5, var7);
   }

   public Rectangle2D getWorldRect2D() {
      return this.ic.k();
   }

   public JComponent getCanvasComponent() {
      return this.ic;
   }

   bw r() {
      return this.ic;
   }

   public Image getImage() {
      return this.ic.c();
   }

   public void fitContent() {
      this.fitContent(false);
   }

   public void fitContent(boolean var1) {
      boolean var28 = fj.z;
      if(var1) {
         int var2 = this.getVerticalScrollBarPolicy();
         int var3 = this.getHorizontalScrollBarPolicy();
         if(var2 == 20) {
            this.setVerticalScrollBarPolicy(21);
         }

         if(var3 == 30) {
            this.setHorizontalScrollBarPolicy(31);
         }

         double var4;
         Double var6;
         label54: {
            var4 = 1.0D;
            var6 = new Double(0.0D, 0.0D);
            double var7 = (double)this.getWidth();
            double var9 = (double)this.getHeight();
            Rectangle var11 = this.calculateContentBounds();
            double var12 = var11.getX();
            double var14 = var11.getY();
            double var16 = var11.getWidth();
            double var18 = var11.getHeight();
            if(var16 <= var7 && var18 <= var9) {
               if(var16 <= 0.0D || var18 <= 0.0D) {
                  break label54;
               }

               var6.setLocation(var12 + 0.5D * var16, var14 + 0.5D * var18);
               if(!var28) {
                  break label54;
               }
            }

            double var20;
            double var22;
            double var24;
            double var26;
            label35: {
               var20 = var12 - 10.0D;
               var22 = var14 - 10.0D;
               var24 = var16 + 20.0D;
               var26 = var18 + 20.0D;
               if(var7 / var9 > var24 / var26) {
                  var4 = var9 / var26;
                  if(!var28) {
                     break label35;
                  }
               }

               var4 = var7 / var24;
            }

            var6.setLocation(var20 + 0.5D * var24, var22 + 0.5D * var26);
         }

         this.focusView(var4, var6, true);
         this.fitWorldRect();
         if(var2 == 20) {
            this.setVerticalScrollBarPolicy(20);
         }

         if(var3 != 30) {
            return;
         }

         this.setHorizontalScrollBarPolicy(30);
         if(!var28) {
            return;
         }
      }

      this.ic.i();
   }

   public int getContentPolicy() {
      return this.rc;
   }

   public void setContentPolicy(int var1) {
      this.rc = var1;
   }

   public Rectangle calculateContentBounds() {
      Rectangle var1;
      label27: {
         boolean var3 = fj.z;
         var1 = this.fc.a();
         if((this.rc & 1) != 0) {
            y.c.C var2 = this.fc.R();

            while(var2.f()) {
               y.d.e.a((Rectangle2D)var1, (Rectangle2D)((az)var2.d()).getBounds(), (Rectangle2D)var1);
               var2.g();
               if(var3) {
                  break label27;
               }

               if(var3) {
                  break;
               }
            }
         }

         if((this.rc & 2) != 0) {
            y.d.e.a((Rectangle2D)var1, (Rectangle2D)this.ic.c.getBounds(), (Rectangle2D)var1);
         }
      }

      if((this.rc & 4) != 0) {
         y.d.e.a((Rectangle2D)var1, (Rectangle2D)this.ic.d.getBounds(), (Rectangle2D)var1);
      }

      return var1;
   }

   public void fitRectangle(Rectangle var1) {
      this.ic.a(var1);
   }

   public Dimension getCanvasSize() {
      return new Dimension(this.ic.y(), this.ic.z());
   }

   public void paintVisibleContent(Graphics2D var1) {
      AffineTransform var2 = var1.getTransform();
      Shape var3 = var1.getClip();
      var1.clipRect(0, 0, this.ic.y(), this.ic.z());
      this.ic.paintComponent(var1);
      var1.setTransform(var2);
      var1.setClip(var3);
   }

   public void setCenter(double var1, double var3) {
      this.ic.b(var1, var3);
   }

   public Point2D getCenter() {
      return this.ic.g();
   }

   public Dimension getViewSize() {
      return this.ic.getSize();
   }

   public void updateView() {
      this.q();
      this.adjustScrollBarVisibility();
      this.ic.d();
   }

   public void updateView(Rectangle2D var1) {
      this.updateView(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight());
   }

   public void updateView(double var1, double var3, double var5, double var7) {
      this.q();
      this.adjustScrollBarVisibility();
      this.ic.a(var1, var3, var5, var7);
   }

   void j(Graphics2D var1) {
      this.r().a(var1);
   }

   void k(Graphics2D var1) {
      this.r().b(var1);
   }

   void l(Graphics2D var1) {
      this.r().c(var1);
   }

   protected void paintSelectionBox(Graphics2D var1, Rectangle2D var2) {
      Color var4 = var1.getColor();
      Stroke var5 = var1.getStroke();
      Object var6 = var2;
      Object var3 = this.getClientProperty("selectionbox.rectangularshape");
      if(var3 instanceof RectangularShape) {
         var6 = (RectangularShape)var3;
         ((RectangularShape)var6).setFrame(var2);
      }

      var3 = this.getClientProperty("selectionbox.fillcolor");
      if(var3 instanceof Color) {
         var1.setColor((Color)var3);
         var1.fill((Shape)var6);
      }

      var3 = this.getClientProperty("selectionbox.stroke");
      Object var7 = var3 instanceof Stroke?(Stroke)var3:new BasicStroke();
      var3 = this.getClientProperty("selectionbox.linecolor");
      Color var8 = var3 instanceof Color?(Color)var3:Color.BLACK;
      var1.setStroke((Stroke)var7);
      var1.setColor(var8);
      var1.draw((Shape)var6);
      var1.setColor(var4);
      var1.setStroke(var5);
   }

   public void updateWorldRect() {
      this.ic.n();
   }

   public double getZoom() {
      return this.ic.h();
   }

   public void setZoom(double var1) {
      this.ic.a(var1);
   }

   public void zoomToArea(double var1, double var3, double var5, double var7) {
      this.ic.b(var1, var3, var5, var7);
   }

   public void setViewCursor(Cursor var1) {
      if(this.ic.getCursor() != var1) {
         this.ic.setCursor(var1);
         if(this.gc != null) {
            this.gc.setCursor(var1);
         }
      }

   }

   public Cursor getViewCursor() {
      return this.ic.getCursor();
   }

   public bu getGraph2D() {
      return this.fc;
   }

   public void setGraph2D(bu var1) {
      if(var1 != this.fc) {
         this.fc.c(this);
         bu var2 = this.fc;
         this.fc = var1;
         var1.b((gI)this);
         this.firePropertyChange("Graph2D", var2, var1);
      }

   }

   public cZ getHitInfoFactory() {
      return this.nc;
   }

   public void setHitInfoFactory(cZ var1) {
      this.nc = var1;
   }

   public void setDrawingMode(int var1) {
      this.ic.a(var1);
   }

   public void setSelectionBoxBounds(Rectangle var1) {
      this.ic.b(var1);
   }

   public void setSelectionBoxBounds2D(Rectangle2D var1) {
      this.ic.a(var1);
   }

   public void showPopup(JPopupMenu var1, double var2, double var4) {
      if(var1 != null) {
         if(this.gc != null && this.gc.isVisible()) {
            boolean var6 = this.gc.getMouseListeners().length == 0;
            if(var6) {
               this.gc.addMouseListener(this.jc);
            }

            boolean var7 = this.gc.getMouseMotionListeners().length == 0;
            if(var7) {
               this.gc.addMouseMotionListener(this.jc);
            }

            var1.addPopupMenuListener(new cj(this, var1, var7, var6));
         }

         int var8 = this.ic.e(var2) + 1;
         int var9 = this.ic.f(var4) + 1;
         var1.show(this.ic, var8, var9);
      }
   }

   public Frame getFrame() {
      boolean var2 = fj.z;
      Container var1 = this.getParent();

      while(var1 != null) {
         if(var1 instanceof Frame) {
            return (Frame)var1;
         }

         var1 = var1.getParent();
         if(var2) {
            break;
         }
      }

      return null;
   }

   public void closeLabelEditor(boolean var1) {
      this.ic.d(var1);
   }

   public void openLabelEditor(gZ var1, double var2, double var4) {
      this.ic.a(var1, var2, var4, (PropertyChangeListener)null, false);
   }

   public void openLabelEditor(gZ var1, double var2, double var4, PropertyChangeListener var6) {
      this.ic.a(var1, var2, var4, var6, false);
   }

   public void openLabelEditor(gZ var1, double var2, double var4, PropertyChangeListener var6, boolean var7) {
      this.ic.a(var1, var2, var4, var6, var7);
   }

   public void openLabelEditor(gZ var1, double var2, double var4, PropertyChangeListener var6, boolean var7, boolean var8) {
      this.ic.a(var1, var2, var4, var6, var7, false, var8);
   }

   public void openLabelEditorCentered(gZ var1, double var2, double var4, PropertyChangeListener var6, boolean var7) {
      this.ic.a(var1, var2, var4, var6, var7, true);
   }

   public void openLabelEditorCentered(gZ var1, double var2, double var4, PropertyChangeListener var6, boolean var7, boolean var8) {
      this.ic.a(var1, var2, var4, var6, var7, true, var8);
   }

   public Component getComponent() {
      return this;
   }

   public Rectangle getVisibleRect() {
      return this.ic.getVisibleRect();
   }

   public Rectangle2D getVisibleRect2D() {
      return this.ic.v();
   }

   public void print(Graphics var1) {
      this.ic.print(var1);
   }

   public void setViewPoint(int var1, int var2) {
      this.ic.a((double)var1, (double)var2);
   }

   public void setViewPoint2D(double var1, double var3) {
      this.ic.a(var1, var3);
   }

   public Point getViewPoint() {
      return this.ic.e();
   }

   public Point2D getViewPoint2D() {
      return this.ic.f();
   }

   JComponent s() {
      return this.ic.b();
   }

   public gI getCurrentView() {
      return this;
   }

   public void addViewChangeListener(gT var1) {
   }

   public void addDrawable(az var1) {
      this.r().a(var1);
   }

   public Collection getDrawables() {
      return this.r().o();
   }

   public void removeDrawable(az var1) {
      this.r().b(var1);
   }

   public void addBackgroundDrawable(az var1) {
      this.r().c(var1);
   }

   public Collection getBackgroundDrawables() {
      return this.r().p();
   }

   public void removeBackgroundDrawable(az var1) {
      this.r().d(var1);
   }

   public cd getGraph2DRenderer() {
      return this.ic.w();
   }

   public void setGraph2DRenderer(cd var1) {
      this.ic.a(var1);
   }

   public void setPaintDetailThreshold(double var1) {
      this.ic.b(var1);
   }

   public double getPaintDetailThreshold() {
      return this.ic.q();
   }

   public int toViewCoordX(double var1) {
      return this.ic.e(var1);
   }

   public int toViewCoordY(double var1) {
      return this.ic.f(var1);
   }

   public double toWorldCoordX(int var1) {
      return this.ic.c((double)var1);
   }

   public double toWorldCoordY(int var1) {
      return this.ic.d((double)var1);
   }

   public void setBackgroundRenderer(w var1) {
      this.ic.a(var1);
   }

   public w getBackgroundRenderer() {
      return this.ic.x();
   }

   public void animationPerformed(y.b.a var1) {
      switch(var1.a()) {
      case 0:
         Object var2 = var1.getSource();
         boolean var3 = var2 instanceof y.b.e && ((y.b.e)var2).b() && ((y.b.e)var2).a();
         boolean var4 = this.r().B();
         if(var3) {
            this.r().f(true);
         }

         this.updateView();
         if(var3) {
            this.r().f(var4);
         }
      default:
      }
   }

   public boolean isFocusTraversable() {
      return true;
   }

   public void setToolTipText(String var1) {
      this.ic.setToolTipText(var1);
   }

   public JToolTip createToolTip() {
      il var1 = new il();
      var1.setComponent(this);
      return var1;
   }

   public void focusView(double var1, Point2D var3, boolean var4) {
      if(var4) {
         this.b(this.b(var1, var3));
         if(!fj.z) {
            return;
         }
      }

      this.setCenter(var3.getX(), var3.getY());
      this.setZoom(var1);
   }

   y.b.d b(double var1, Point2D var3) {
      gJ var4 = new gJ(this);
      return y.b.b.a(var4.a(var1, y.g.w.a(var3), 500L));
   }

   void b(y.b.d var1) {
      y.b.e var2 = new y.b.e();
      var2.a((y.b.c)this);
      var2.a(var1);
   }

   boolean t() {
      return this.ic.A();
   }

   public boolean isAntialiasedPainting() {
      return this.ic.D();
   }

   public void setAntialiasedPainting(boolean var1) {
      this.ic.h(var1);
   }

   public void registerKeyboardAction(ActionListener var1, String var2, KeyStroke var3, int var4) {
      this.ic.registerKeyboardAction(var1, var2, var3, var4);
   }

   public void registerKeyboardAction(ActionListener var1, KeyStroke var2, int var3) {
      this.ic.registerKeyboardAction(var1, var2, var3);
   }

   public void unregisterKeyboardAction(KeyStroke var1) {
      this.ic.unregisterKeyboardAction(var1);
   }

   public void requestFocus() {
      this.ic.requestFocus();
   }

   public void setRenderingHints(RenderingHints var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("RenderingHints cannot be null");
      } else {
         this.kc = var1;
      }
   }

   public RenderingHints getRenderingHints() {
      return this.kc;
   }

   public void applyLayout(y.f.ah var1) {
      (new bI((byte)1)).d(this, this.getGraph2D(), var1);
   }

   public void applyLayoutAnimated(y.f.ah var1) {
      bI var2 = new bI((byte)3);
      var2.e().setSmoothViewTransform(true);
      var2.e().setEasedExecution(true);
      var2.d(this, this.getGraph2D(), var1);
   }

   static boolean access$100(ch var0) {
      return var0.sc;
   }

   static JScrollBar access$200(ch var0) {
      return var0.qc;
   }

   static bw access$300(ch var0) {
      return var0.ic;
   }

   static JScrollBar access$400(ch var0) {
      return var0.mc;
   }

   static cl access$500(ch var0) {
      return var0.jc;
   }

   static JPanel access$600(ch var0) {
      return var0.gc;
   }
}
