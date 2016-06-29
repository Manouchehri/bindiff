package y.h;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.dnd.Autoscroll;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JToolTip;
import javax.swing.KeyStroke;
import javax.swing.ToolTipManager;
import y.h.M;
import y.h.O;
import y.h.az;
import y.h.bA;
import y.h.bB;
import y.h.bu;
import y.h.bx;
import y.h.by;
import y.h.bz;
import y.h.cV;
import y.h.cd;
import y.h.ch;
import y.h.fj;
import y.h.gF;
import y.h.gX;
import y.h.gZ;
import y.h.hG;
import y.h.hk;
import y.h.ig;
import y.h.il;
import y.h.im;
import y.h.w;
import y.h.y;

public class bw extends JComponent implements Autoscroll {
   private double f = 1.0D;
   AffineTransform a = new AffineTransform();
   private Double g;
   java.awt.geom.Point2D.Double b = new java.awt.geom.Point2D.Double();
   private Rectangle h;
   private Double i = new Double();
   private Double j;
   private int k = 0;
   private int l = 0;
   private ch m;
   private boolean n;
   private boolean o;
   private double p;
   private double q;
   private Color r;
   private int s;
   private boolean t;
   private bB u;
   im c;
   im d;
   private w v;
   private String w;
   private cd x;
   private double y = 0.3D;
   private boolean z;
   private boolean A = true;
   private List B = new ArrayList(5);
   private boolean C;
   private JTextArea D;
   Insets e = new Insets(10, 10, 10, 10);

   protected void processMouseEvent(MouseEvent var1) {
      if(!this.t) {
         super.processMouseEvent(var1);
      }
   }

   boolean a() {
      return this.t;
   }

   void a(boolean var1) {
      this.t = var1;
   }

   protected boolean processKeyBinding(KeyStroke var1, KeyEvent var2, int var3, boolean var4) {
      return this.t?false:super.processKeyBinding(var1, var2, var3, var4);
   }

   protected void processKeyEvent(KeyEvent var1) {
      if(!this.t) {
         super.processKeyEvent(var1);
      }
   }

   protected void processMouseMotionEvent(MouseEvent var1) {
      if(!this.t) {
         super.processMouseMotionEvent(var1);
      }
   }

   protected void processMouseWheelEvent(MouseWheelEvent var1) {
      if(!this.t) {
         super.processMouseWheelEvent(var1);
      }
   }

   bw(ch var1) {
      this.setOpaque(true);
      this.m = var1;
      this.setLayout(new ig());
      this.c = new im();
      this.d = new im();
      this.q = 25.0D;
      this.p = 25.0D;
      this.r = Color.gray;
      this.s = 3;
      this.v = new M(this.m);
      this.x = new O();
      ToolTipManager.sharedInstance().registerComponent(this);
   }

   JComponent b() {
      if(this.u == null) {
         this.u = new bB();
         this.add(this.u);
      }

      return this.u;
   }

   public Image c() {
      int var1 = this.y();
      int var2 = this.z();
      BufferedImage var3 = new BufferedImage(var1, var2, 1);
      Graphics2D var4 = (Graphics2D)var3.getGraphics();
      var4.setClip(0, 0, var1, var2);
      this.paintComponent(var4);
      return var3;
   }

   private bu F() {
      return this.m.getGraph2D();
   }

   public void d() {
      if(this.k == 666) {
         this.d(true);
      }

      this.b(0, 0, this.getWidth(), this.getHeight());
   }

   public void a(double var1, double var3, double var5, double var7) {
      int var9 = (int)Math.floor((var1 - this.b.x) * this.f);
      int var10 = (int)Math.floor((var3 - this.b.y) * this.f);
      int var11 = (int)Math.ceil(var5 * this.f);
      int var12 = (int)Math.ceil(var7 * this.f);
      if(this.k != 0) {
         this.repaint(var9, var10, var11, var12);
         if(!fj.z) {
            return;
         }
      }

      this.b(var9, var10, var11, var12);
   }

   private void b(int var1, int var2, int var3, int var4) {
      boolean var10;
      label52: {
         var10 = fj.z;
         Rectangle var6;
         if(this.k == 1) {
            Rectangle var7;
            Rectangle var8;
            label49: {
               Rectangle var5 = this.F().a((byte)0);
               var6 = this.c.getBounds();
               var7 = this.d.getBounds();
               if(var6.getWidth() > 0.0D) {
                  if(var5.getWidth() >= 0.0D) {
                     var8 = var5.union(var6);
                     if(!var10) {
                        break label49;
                     }
                  }

                  var8 = var6;
                  if(!var10) {
                     break label49;
                  }
               }

               var8 = var5;
            }

            if(var7.getWidth() > 0.0D) {
               var8 = var8.union(var7);
            }

            if(var8.getWidth() > 0.0D && this.x instanceof O) {
               O var9 = (O)this.x;
               var8 = a(var8, var9.getClipEnlargementValue());
            }

            if(this.h != null) {
               Rectangle var12 = a(var8, this.h);
               var12 = a(var12, 8 + (int)((double)var12.width * 0.05D));
               this.h = var8;
               var8 = var12;
            }

            var1 = (int)Math.round((var8.getX() - this.b.getX()) * this.f);
            var2 = (int)Math.round((var8.getY() - this.b.getY()) * this.f);
            var3 = (int)Math.round(var8.getWidth() * this.f);
            var4 = (int)Math.round(var8.getHeight() * this.f);
            if(!var10) {
               break label52;
            }
         }

         if(this.k == 2) {
            Double var11 = b(this.i);
            if(this.j != null) {
               Rectangle2D.union(this.i, this.j, var11);
            }

            var6 = new Rectangle();
            this.a(var11, var6);
            var1 = var6.x - 2;
            var2 = var6.y - 2;
            var3 = var6.width + 4;
            var4 = var6.height + 4;
            this.j = b(this.i);
         }
      }

      if(this.n) {
         this.paintImmediately(var1, var2, var3, var4);
         if(!var10) {
            return;
         }
      }

      this.repaint(var1, var2, var3, var4);
   }

   public void setBounds(int var1, int var2, int var3, int var4) {
      if(!this.getBounds().equals(new Rectangle(var1, var2, var3, var4))) {
         if(this.k == 666) {
            this.d(false);
         }

         super.setBounds(var1, var2, var3, var4);
         this.m();
      }

   }

   public void reshape(int var1, int var2, int var3, int var4) {
      if(!this.getBounds().equals(new Rectangle(var1, var2, var3, var4))) {
         if(this.k == 666) {
            this.d(false);
         }

         super.reshape(var1, var2, var3, var4);
         this.m();
      }

   }

   public void setBounds(Rectangle var1) {
      Rectangle var2 = this.getBounds();
      super.setBounds(var1);
      this.firePropertyChange("Bounds", var2, var1);
   }

   public Point e() {
      return new Point((int)this.b.x, (int)this.b.y);
   }

   public java.awt.geom.Point2D.Double f() {
      return new java.awt.geom.Point2D.Double(this.b.x, this.b.y);
   }

   public void a(double var1, double var3) {
      if(this.G()) {
         java.awt.geom.Point2D.Double var5 = this.f();
         if(this.j != null) {
            this.j.setFrame(this.b.x, this.b.y, (double)this.y() / this.f, (double)this.z() / this.f);
         }

         this.b.x = var1;
         this.b.y = var3;
         this.m();
         this.firePropertyChange("ViewPoint", var5, this.f());
      }
   }

   public void b(double var1, double var3) {
      if(this.G()) {
         this.a(var1 - (double)this.H() / (2.0D * this.f), var3 - (double)this.I() / (2.0D * this.f));
      }
   }

   public Point2D g() {
      java.awt.geom.Point2D.Double var1 = new java.awt.geom.Point2D.Double();
      var1.setLocation(this.b.getX() + (double)this.H() / (2.0D * this.f), this.b.getY() + (double)this.I() / (2.0D * this.f));
      return var1;
   }

   public double h() {
      return this.f;
   }

   public void a(double var1) {
      if(var1 <= 0.0D) {
         throw new IllegalArgumentException("Zoom must be positive! was " + var1);
      } else {
         var1 = Math.max(9.0E-5D, var1);
         var1 = Math.min(100001.0D, var1);
         if(this.G()) {
            this.a(this.b.x + (double)this.H() * (1.0D / this.f - 1.0D / var1) / 2.0D, this.b.y + (double)this.I() * (1.0D / this.f - 1.0D / var1) / 2.0D);
            double var3 = this.f;
            this.f = var1;
            this.firePropertyChange("Zoom", var3, this.f);
            this.m();
         }
      }
   }

   public void b(double var1, double var3, double var5, double var7) {
      this.a(var1, var3, var5, var7, this.m.getParent() != null);
   }

   private void a(double var1, double var3, double var5, double var7, boolean var9) {
      double var10 = this.h();
      this.a(var1, var3, var5, var7, this.H(), this.I());
      if(var9) {
         this.m.adjustScrollBarVisibility();
         if(this.getWidth() > 0 && this.getHeight() > 0) {
            this.a(var1, var3, var5, var7, this.y(), this.z());
         }

         this.m.q();
      }

      double var12 = this.h();
      if(var12 != var10) {
         this.firePropertyChange("Zoom", var10, var12);
      }

   }

   private void a(double var1, double var3, double var5, double var7, int var9, int var10) {
      double var11 = (double)var9 / this.h();
      double var13 = (double)var10 / this.h();
      if(var11 / var13 > var5 / var7) {
         this.f = this.f * var13 / var7;
         this.a(var1 - ((double)var9 / this.f - var5) / 2.0D, var3);
         if(!fj.z) {
            return;
         }
      }

      this.f = this.f * var11 / var5;
      this.a(var1, var3 - ((double)var10 / this.f - var7) / 2.0D);
   }

   public void i() {
      this.a(this.m.calculateContentBounds());
   }

   public void a(Rectangle var1) {
      boolean var2 = fj.z;
      if(var1.getWidth() <= (double)this.H() && var1.getHeight() <= (double)this.I()) {
         label27: {
            this.a(1.0D);
            if(var1.getWidth() <= 0.0D || var1.getHeight() <= 0.0D) {
               this.a(0.0D, 0.0D);
               if(!var2) {
                  break label27;
               }
            }

            this.b(var1.getX() + var1.getWidth() / 2.0D, var1.getY() + var1.getHeight() / 2.0D);
         }

         this.l();
         if(!var2) {
            return;
         }
      }

      this.a(var1.getX() - 10.0D, var1.getY() - 10.0D, var1.getWidth() + 20.0D, var1.getHeight() + 20.0D, false);
      this.l();
   }

   public void a(int var1, int var2, int var3, int var4) {
      this.g = new Double((double)var1, (double)var2, (double)var3, (double)var4);
      this.m();
   }

   public void c(double var1, double var3, double var5, double var7) {
      this.g = new Double(var1, var3, var5, var7);
      this.m();
   }

   public Rectangle j() {
      if(this.g == null) {
         this.k();
      }

      return a(this.g);
   }

   public Double k() {
      if(this.g == null) {
         Dimension var1 = this.getPreferredSize();
         this.g = new Double(0.0D, 0.0D, (double)var1.width, (double)var1.height);
      }

      return this.g;
   }

   public void l() {
      this.g.setRect(this.b.x, this.b.y, (double)this.y() / this.h(), (double)this.z() / this.h());
   }

   public void m() {
      double var1 = (double)this.y() / this.f;
      double var3 = (double)this.z() / this.f;
      double var5 = this.b.x;
      double var7 = this.b.y;
      Double var9 = this.k();
      if(var9.x > var5) {
         var9.width += var9.x - var5;
         var9.x = var5;
      }

      if(var9.x + var9.width < var5 + var1) {
         var9.width = var5 + var1 - var9.x;
      }

      if(var9.y > var7) {
         var9.height += var9.y - var7;
         var9.y = var7;
      }

      if(var9.y + var9.height < var7 + var3) {
         var9.height = var7 + var3 - var9.y;
      }

   }

   public void n() {
      label11: {
         Rectangle var1 = this.m.calculateContentBounds();
         if(this.g == null) {
            this.g = c(var1);
            if(!fj.z) {
               break label11;
            }
         }

         this.g = a(this.g, c(var1));
      }

      this.m();
   }

   public void print(Graphics var1) {
      boolean var2 = this.C;
      this.C = true;

      try {
         super.print(var1);
      } finally {
         this.C = var2;
      }

   }

   public void paintComponent(Graphics var1) {
      Graphics2D var2 = (Graphics2D)((Graphics2D)var1).create();
      var2.addRenderingHints(this.m.getRenderingHints());
      var2.setRenderingHint(hk.y, new java.lang.Double(this.q()));
      if(var2.getRenderingHint(hk.z) == null) {
         cV var3 = this.m.createGraphicsContext();
         if(var3.a() == null) {
            var3.a(var2.getTransform());
         }

         if(!var3.b()) {
            var3.a(this.C);
         }

         var2.setRenderingHint(hk.z, var3);
      }

      double var11 = -this.b.getX();
      double var5 = -this.b.getY();
      AffineTransform var7 = var2.getTransform();
      var2.scale(this.f, this.f);
      var2.translate(var11, var5);
      if(this.A) {
         gF.a(var2);
      }

      this.d(var2);
      AffineTransform var8 = var2.getTransform();
      var2.setTransform(var7);
      this.e(var2);
      var2.setTransform(var8);
      this.b(var2);
      this.c(var2);
      this.a(var2);
      if(this.k == 2) {
         AffineTransform var9 = var2.getTransform();
         var2.setTransform(var7);
         Double var10 = new Double((this.i.getX() - this.b.getX()) * this.f, (this.i.getY() - this.b.getY()) * this.f, this.i.getWidth() * this.f, this.i.getHeight() * this.f);
         this.m.paintSelectionBox(var2, var10);
         var2.setTransform(var9);
      }

      var2.dispose();
   }

   private void d(Graphics2D var1) {
      Rectangle var2 = var1.getClipBounds();
      int var3 = var2.x;
      int var4 = var2.y;
      int var5 = var2.width;
      int var6 = var2.height;
      this.a(var1, var3, var4, var5, var6);
   }

   private void e(Graphics2D var1) {
      boolean var31 = fj.z;
      if(this.z && this.f >= this.y) {
         Color var2;
         label101: {
            Stroke var3;
            label106: {
               var2 = var1.getColor();
               var3 = var1.getStroke();
               var1.setColor(this.r);
               var1.setStroke(new BasicStroke(1.0F));
               Rectangle var4 = var1.getClipBounds();
               double var5 = Math.floor(this.b.x / this.p) * this.p - this.b.x;
               double var7 = Math.floor(this.b.y / this.q) * this.q - this.b.y;
               double var9 = var5 * this.f + Math.floor(-1.0D + (double)var4.x / (this.p * this.f)) * this.p * this.f;
               double var11 = var7 * this.f + Math.floor(-1.0D + (double)var4.y / (this.q * this.f)) * this.q * this.f;
               double var13 = (double)(var4.x + var4.width) + this.p * this.f;
               double var15 = (double)(var4.y + var4.height) + this.q * this.f;
               double var17 = this.p * this.f;
               double var19 = this.q * this.f;
               double var25;
               int var27;
               double var28;
               int var30;
               switch(this.s) {
               case 1:
                  int var21 = var4.y;
                  int var22 = var4.y + var4.height;
                  int var23 = var4.x;
                  int var24 = var4.x + var4.width;
                  var25 = var9;

                  label92: {
                     while(var25 <= var13) {
                        var27 = (int)var25;
                        var1.drawLine(var27, var21, var27, var22);
                        var25 += var17;
                        if(var31) {
                           break label92;
                        }

                        if(var31) {
                           break;
                        }
                     }

                     var25 = var11;
                  }

                  do {
                     if(var25 > var15) {
                        break label106;
                     }

                     var27 = (int)var25;
                     var1.drawLine(var23, var27, var24, var27);
                     var25 += var19;
                     if(var31) {
                        break label101;
                     }
                  } while(!var31);
               case 3:
                  var25 = var9;

                  label77:
                  do {
                     if(var25 > var13) {
                        break label106;
                     }

                     var27 = (int)var25;
                     if(var31) {
                        break label101;
                     }

                     var28 = var11;

                     while(var28 <= var15) {
                        var30 = (int)var28;
                        var1.drawLine(var27, var30 - 3, var27, var30 + 3);
                        var1.drawLine(var27 - 3, var30, var27 + 3, var30);
                        var28 += var19;
                        if(var31) {
                           continue label77;
                        }

                        if(var31) {
                           break;
                        }
                     }

                     var25 += var17;
                  } while(!var31);
               case 2:
                  break;
               default:
                  break label106;
               }

               var25 = var9;

               while(var25 <= var13) {
                  var27 = (int)var25;
                  if(var31) {
                     break label101;
                  }

                  var28 = var11;

                  label54: {
                     while(var28 <= var15) {
                        var30 = (int)var28;
                        var1.drawLine(var27, var30 - 1, var27, var30 + 1);
                        var1.drawLine(var27 - 1, var30, var27 + 1, var30);
                        var28 += var19;
                        if(var31) {
                           break label54;
                        }

                        if(var31) {
                           break;
                        }
                     }

                     var25 += var17;
                  }

                  if(var31) {
                     break;
                  }
               }
            }

            var1.setStroke(var3);
         }

         var1.setColor(var2);
      }

   }

   private void a(Graphics2D var1, int var2, int var3, int var4, int var5) {
      Color var6 = var1.getColor();
      Stroke var7 = var1.getStroke();
      AffineTransform var8 = var1.getTransform();
      if(this.v != null) {
         this.v.paint(var1, var2, var3, var4, var5);
      }

      var1.setStroke(var7);
      var1.setColor(var6);
      var1.setTransform(var8);
   }

   void a(Graphics2D var1) {
      boolean var3 = fj.z;
      y.c.C var2;
      if(this.h() >= this.y) {
         this.c.a(var1);
         var2 = this.F().R();

         do {
            if(!var2.f()) {
               return;
            }

            ((az)var2.d()).a(var1);
            var2.g();
         } while(!var3);
      }

      var2 = this.c.m();

      while(true) {
         if(var2.f()) {
            boolean var10000 = var2.d() instanceof hG;
            if(var3) {
               if(!var10000) {
                  return;
               }
               break;
            }

            label51: {
               if(var10000) {
                  ((hG)var2.d()).b(var1);
                  if(!var3) {
                     break label51;
                  }
               }

               ((az)var2.d()).a(var1);
            }

            var2.g();
            if(!var3) {
               continue;
            }
         }

         var2 = this.F().R();
         if(!var2.f()) {
            return;
         }
         break;
      }

      do {
         label43: {
            if(var2.d() instanceof hG) {
               ((hG)var2.d()).b(var1);
               if(!var3) {
                  break label43;
               }
            }

            ((az)var2.d()).a(var1);
         }

         var2.g();
      } while(!var3 && var2.f());

   }

   Collection o() {
      return new ArrayList(this.c);
   }

   Collection p() {
      return new ArrayList(this.d);
   }

   void b(Graphics2D var1) {
      boolean var3 = fj.z;
      if(this.h() >= this.y) {
         this.d.a(var1);
         if(!var3) {
            return;
         }
      }

      y.c.C var2 = this.d.m();

      while(var2.f()) {
         label19: {
            if(var2.d() instanceof hG) {
               ((hG)var2.d()).b(var1);
               if(!var3) {
                  break label19;
               }
            }

            ((az)var2.d()).a(var1);
         }

         var2.g();
         if(var3) {
            break;
         }
      }

   }

   public void c(Graphics2D var1) {
      if(this.h() >= this.y) {
         this.x.paint(var1, this.F());
         if(!fj.z) {
            return;
         }
      }

      this.x.paintSloppy(var1, this.F());
   }

   public void b(double var1) {
      this.y = var1;
   }

   public double q() {
      return this.y;
   }

   public void b(boolean var1) {
      if(var1) {
         this.k = 1;
         this.h = this.F().a((byte)0);
         if(!fj.z) {
            return;
         }
      }

      this.k = 0;
      this.h = null;
   }

   public void a(int var1) {
      boolean var2 = fj.z;
      switch(var1) {
      case 0:
         if(this.l == 2) {
            this.c(false);
            if(!var2) {
               break;
            }
         }

         if(this.l == 0) {
            break;
         }

         this.b(false);
         if(!var2) {
            break;
         }
      case 1:
         if(this.l == 2) {
            this.c(false);
         }

         this.F().b((byte)1);
         this.a((byte)0);
         this.b(true);
         if(!var2) {
            break;
         }
      case 2:
         this.c(true);
         if(!var2) {
            break;
         }
      case 3:
         if(this.l == 2) {
            this.c(false);
         }

         this.b(true);
         if(!var2) {
            break;
         }
      case 4:
         if(this.l == 2) {
            this.c(false);
         }

         this.k = 555;
      }

      this.l = var1;
   }

   private void a(byte var1) {
      boolean var4 = fj.z;
      bu var2 = this.F();
      y.c.x var3 = var2.J();

      bu var10000;
      while(true) {
         if(var3.f()) {
            var10000 = var2;
            if(var4) {
               break;
            }

            var2.t(var3.e()).setLayer(var1, true);
            var3.g();
            if(!var4) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      y.c.e var5 = var10000.K();

      while(true) {
         if(var5.f()) {
            var10000 = var2;
            if(var4) {
               break;
            }

            var2.i(var5.a()).setLayer(var1);
            var5.g();
            if(!var4) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      y var6 = var10000.M();

      while(var6.f()) {
         var2.i(var6.a().a()).setLayer(var1);
         var6.g();
         if(var4) {
            break;
         }
      }

   }

   public double c(double var1) {
      return var1 / this.f + this.b.x;
   }

   public double d(double var1) {
      return var1 / this.f + this.b.y;
   }

   public int e(double var1) {
      return (int)((var1 - this.b.x) * this.f);
   }

   public int f(double var1) {
      return (int)((var1 - this.b.y) * this.f);
   }

   Rectangle a(Double var1, Rectangle var2) {
      if(var2 == null) {
         var2 = new Rectangle();
      }

      var2.setFrame((var1.getX() - this.b.getX()) * this.f, (var1.getY() - this.b.getY()) * this.f, var1.getWidth() * this.f, var1.getHeight() * this.f);
      return var2;
   }

   Point a(java.awt.geom.Point2D.Double var1, Point var2) {
      if(var2 == null) {
         var2 = new Point();
      }

      var2.setLocation((var1.x - this.b.x) * this.f, (var1.y - this.b.y) * this.f);
      return var2;
   }

   public void c(boolean var1) {
      if(this.k == 666) {
         this.d(false);
      }

      label14: {
         if(var1) {
            this.k = 2;
            if(!fj.z) {
               break label14;
            }
         }

         this.k = 0;
      }

      this.i.setRect(0.0D, 0.0D, 0.0D, 0.0D);
      this.j = null;
   }

   public void b(Rectangle var1) {
      this.i.setRect(var1);
   }

   public void a(Rectangle2D var1) {
      this.i.setRect(var1);
   }

   public void a(gZ var1, double var2, double var4, PropertyChangeListener var6, boolean var7) {
      this.a(var1, var2, var4, var6, var7, false, true);
   }

   public void a(gZ var1, double var2, double var4, PropertyChangeListener var6, boolean var7, boolean var8) {
      this.a(var1, var2, var4, var6, var7, var8, true);
   }

   public void a(gZ var1, double var2, double var4, PropertyChangeListener var6, boolean var7, boolean var8, boolean var9) {
      boolean var18 = fj.z;
      if(this.k != 666) {
         String var10 = var1.getText();
         bx var11 = new bx(this, var10);
         var11.setFont(var1.getFont());
         var11.setEditable(true);
         var11.setBorder(BorderFactory.createLineBorder(Color.red));
         this.a.setTransform(this.f, 0.0D, 0.0D, this.f, 0.0D, 0.0D);
         var11.setFont(var11.getFont().deriveFont(this.a));

         try {
            String var12 = System.getProperty("os.name").toLowerCase();
            if(var12.startsWith("mac")) {
               Font var13 = var1.getFont();
               var13 = new Font(var13.getFontName(), var13.getStyle(), (int)Math.ceil(this.f * (double)var13.getSize()));
               var11.setFont(var13);
            }
         } catch (SecurityException var19) {
            ;
         }

         var11.setCaretPosition(var11.getText().length());
         var11.selectAll();
         var11.putClientProperty("ylabel", var1);
         var11.putClientProperty("pcl", var6);
         var11.putClientProperty("oldLabelText", var10);
         var11.putClientProperty("commitValue", var9?Boolean.TRUE:Boolean.FALSE);
         by var20 = new by(this, var7, var11);
         var11.addKeyListener(var20);
         var11.addCaretListener(new bz(this, var11));
         bA var21 = new bA(this, this.m);
         ArrayList var14 = new ArrayList(this.B);
         ArrayList var15 = new ArrayList();
         var11.putClientProperty("disabledViewModes", var15);
         Iterator var16 = var14.iterator();

         while(true) {
            if(var16.hasNext()) {
               gX var17 = (gX)var16.next();
               this.b(var17);
               var15.add(var17);
               if(var18) {
                  break;
               }

               if(!var18) {
                  continue;
               }
            }

            this.a((gX)var21);
            var11.putClientProperty("activeViewMode", var21);
            var11.putClientProperty("yvl", var21);
            break;
         }

         Point var22 = this.a((java.awt.geom.Point2D.Double)(new java.awt.geom.Point2D.Double(var2, var4)), (Point)null);
         var11.putClientProperty(ig.a, var8?Boolean.TRUE:Boolean.FALSE);
         var11.putClientProperty(ig.b, var8?var22:new Point(var22.x, var22.y - 2));
         var11.putClientProperty(ig.c, (Object)null);
         this.k = 666;
         this.add(this.D = var11);
         this.validate();
         var11.requestFocus();
      }
   }

   void d(boolean var1) {
      boolean var12 = fj.z;
      if(this.k == 666) {
         this.k = 0;
         JTextArea var2 = this.D;
         if(var2 != null) {
            gZ var3 = (gZ)var2.getClientProperty("ylabel");
            PropertyChangeListener var4 = (PropertyChangeListener)var2.getClientProperty("pcl");
            Object var5 = var2.getClientProperty("commitValue");
            boolean var6 = var5 instanceof Boolean?((Boolean)var5).booleanValue():true;
            this.remove(var2);
            this.D = null;
            gX var7 = (gX)var2.getClientProperty("activeViewMode");
            List var8 = (List)var2.getClientProperty("disabledViewModes");
            if(var7 != null) {
               this.b(var7);
            }

            label68: {
               if(var8 != null) {
                  Iterator var9 = var8.iterator();

                  while(var9.hasNext()) {
                     this.a((gX)var9.next());
                     if(var12) {
                        break label68;
                     }

                     if(var12) {
                        break;
                     }
                  }
               }

               if(var1) {
                  String var13 = (String)var2.getClientProperty("oldLabelText");
                  String var10 = var3.getText();
                  String var11 = var2.getText();
                  if(var10.equals(var13) && !var11.equals(var10)) {
                     label66: {
                        if(var6) {
                           var3.setText(var11);
                           a(var4, var3, var10, var3.getText());
                           if(!var12) {
                              break label66;
                           }
                        }

                        a(var4, var3, var10, var11);
                     }
                  }
               }

               this.validate();
            }

            this.d();
         }

         this.m.requestFocus();
      }

   }

   private static void a(PropertyChangeListener var0, gZ var1, String var2, String var3) {
      if(var0 != null) {
         var0.propertyChange(new PropertyChangeEvent(var1, "text", var2, var3));
      }

   }

   public void a(az var1) {
      this.c.b(var1);
   }

   public void b(az var1) {
      this.c.remove(var1);
   }

   public void c(az var1) {
      this.d.add(var1);
   }

   public void d(az var1) {
      this.d.remove(var1);
   }

   public void a(Color var1) {
      Color var2 = this.r;
      this.r = var1;
      this.firePropertyChange("GridColor", var2, this.r);
   }

   public Color r() {
      return this.r;
   }

   public void e(boolean var1) {
      boolean var2 = this.o;
      this.o = var1;
      this.firePropertyChange("GridMode", var2, this.o);
   }

   public boolean s() {
      return this.o;
   }

   public void b(int var1) {
      int var2 = this.s;
      this.s = var1;
      this.firePropertyChange("GridType", var2, this.s);
   }

   public int t() {
      return this.s;
   }

   public void g(double var1) {
      double var3 = this.p;
      this.p = var1;
      this.q = var1;
      this.firePropertyChange("GridResolution", var3, this.p);
   }

   public double u() {
      return this.p;
   }

   private static Rectangle a(Rectangle var0, int var1) {
      var0.x -= var1;
      var0.y -= var1;
      var1 *= 2;
      var0.width += var1;
      var0.height += var1;
      return var0;
   }

   private static Rectangle a(Double var0) {
      return new Rectangle((int)var0.x, (int)var0.y, (int)var0.width, (int)var0.height);
   }

   private static Double b(Double var0) {
      return new Double(var0.x, var0.y, var0.width, var0.height);
   }

   private static Double c(Rectangle var0) {
      return new Double((double)var0.x, (double)var0.y, (double)var0.width, (double)var0.height);
   }

   private static Double a(Double var0, Double var1) {
      Rectangle2D.union(var0, var1, var0);
      return var0;
   }

   private static Rectangle a(Rectangle var0, Rectangle var1) {
      return var0.union(var1);
   }

   public Rectangle getVisibleRect() {
      return new Rectangle((int)this.b.x, (int)this.b.y, (int)((double)this.y() / this.h()), (int)((double)this.z() / this.h()));
   }

   public Double v() {
      return new Double(this.b.x, this.b.y, (double)this.y() / this.h(), (double)this.z() / this.h());
   }

   public cd w() {
      return this.x;
   }

   public void a(cd var1) {
      this.x = var1;
   }

   private boolean G() {
      if(this.k == 2) {
         return true;
      } else {
         if(this.k == 1) {
            this.b(false);
            if(!fj.z) {
               return true;
            }
         }

         if(this.k != 0) {
            return false;
         } else {
            return true;
         }
      }
   }

   public void a(w var1) {
      this.v = var1;
   }

   public w x() {
      return this.v;
   }

   public void setToolTipText(String var1) {
      this.w = var1;
   }

   public String getToolTipText() {
      return this.w;
   }

   public JToolTip createToolTip() {
      if(this.m != null) {
         JToolTip var2 = this.m.createToolTip();
         var2.setComponent(this);
         return var2;
      } else {
         il var1 = new il();
         var1.setComponent(this);
         return var1;
      }
   }

   private int H() {
      return this.m.getWidth() > 0?this.m.getWidth():this.m.getPreferredSize().width;
   }

   private int I() {
      return this.m.getHeight() > 0?this.m.getHeight():this.m.getPreferredSize().height;
   }

   int y() {
      return this.getWidth() > 0?this.getWidth():this.H();
   }

   int z() {
      return this.getHeight() > 0?this.getHeight():this.I();
   }

   boolean A() {
      return this.k != 666;
   }

   void f(boolean var1) {
      this.n = var1;
   }

   boolean B() {
      return this.n;
   }

   public boolean C() {
      return this.z;
   }

   public void g(boolean var1) {
      boolean var2 = this.z;
      this.z = var1;
      this.firePropertyChange("GridVisible", var2, this.z);
   }

   public boolean D() {
      return this.A;
   }

   public void h(boolean var1) {
      this.A = var1;
   }

   public void autoscroll(Point var1) {
      if(this.getParent() instanceof ch) {
         int var2 = this.getWidth();
         int var3 = this.getHeight();
         int var4 = var1.x < this.e.left?var1.x - this.e.left:(var1.x > var2 - this.e.right?var1.x - (var2 - this.e.right):0);
         int var5 = var1.y < this.e.top?var1.y - this.e.top:(var1.y > var3 - this.e.bottom?var1.y - (var3 - this.e.bottom):0);
         if(var4 != 0 || var5 != 0) {
            ((ch)this.getParent()).setViewPoint2D(this.b.x + (double)var4 * 3.0D / this.f, this.b.y + (double)var5 * 3.0D / this.f);
            ((ch)this.getParent()).updateView();
         }
      }

   }

   public Insets getAutoscrollInsets() {
      return this.e;
   }

   public List E() {
      return this.B;
   }

   public void a(gX var1) {
      if(var1 != null) {
         var1.setActiveView(this.m);
         this.addMouseListener(var1);
         this.addMouseMotionListener(var1);
         this.B.add(var1);
         var1.activate(true);
      }

   }

   public void b(gX var1) {
      if(var1 != null) {
         if(this.B.remove(var1)) {
            if(var1.isEditing()) {
               var1.cancelEditing();
            }

            var1.activate(false);
         }

         this.removeMouseListener(var1);
         this.removeMouseMotionListener(var1);
      }

   }
}
