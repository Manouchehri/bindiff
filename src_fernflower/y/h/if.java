package y.h;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import y.h.bw;
import y.h.ch;
import y.h.fj;

class if implements LayoutManager, ScrollPaneConstants {
   protected bw a;
   protected JScrollBar b;
   protected JScrollBar c;
   protected JComponent d;
   Dimension e = new Dimension(-1, -1);
   private JPanel f;

   protected Component a(Component var1, Component var2) {
      if(var1 != null && var1 != var2) {
         var1.getParent().remove(var1);
      }

      return var2;
   }

   public void addLayoutComponent(String var1, Component var2) {
      boolean var3 = fj.z;
      if(var1.equals("CANVAS")) {
         this.a = (bw)this.a(this.a, var2);
         if(!var3) {
            return;
         }
      }

      if(var1.equals("VERTICAL_SCROLLBAR")) {
         this.b = (JScrollBar)this.a(this.b, var2);
         if(!var3) {
            return;
         }
      }

      if(var1.equals("HORIZONTAL_SCROLLBAR")) {
         this.c = (JScrollBar)this.a(this.c, var2);
         if(!var3) {
            return;
         }
      }

      if(var1.equals("CORNER_COMPONENT")) {
         this.d = (JComponent)this.a(this.d, var2);
         if(!var3) {
            return;
         }
      }

      if("GLASS_PANE".equals(var1)) {
         this.f = (JPanel)var2;
      }

   }

   public void removeLayoutComponent(Component var1) {
      boolean var2 = fj.z;
      if(var1 == this.a) {
         this.a = null;
         if(!var2) {
            return;
         }
      }

      if(var1 == this.b) {
         this.b = null;
         if(!var2) {
            return;
         }
      }

      if(var1 == this.c) {
         this.c = null;
         if(!var2) {
            return;
         }
      }

      if(var1 == this.d) {
         this.d = null;
         if(!var2) {
            return;
         }
      }

      if(var1 == this.f) {
         this.f = null;
      }

   }

   public Dimension preferredLayoutSize(Container var1) {
      boolean var10 = fj.z;
      ch var2 = (ch)var1;
      int var3 = var2.getVerticalScrollBarPolicy();
      int var4 = var2.getHorizontalScrollBarPolicy();
      Insets var5 = var2.getInsets();
      int var6 = var5.left + var5.right;
      int var7 = var5.top + var5.bottom;
      Rectangle var8 = null;
      Dimension var9 = null;
      if(this.a != null) {
         var8 = var2.getWorldRect();
         var9 = this.a.getPreferredSize();
      }

      if(this.f != null) {
         label55: {
            if(var9 != null) {
               var9.setSize(Math.max(var9.getWidth(), this.f.getPreferredSize().getWidth()), Math.max(var9.getHeight(), this.f.getPreferredSize().getHeight()));
               if(!var10) {
                  break label55;
               }
            }

            var9 = this.f.getPreferredSize();
         }
      }

      if(var9 != null) {
         var6 += var9.width;
         var7 += var9.height;
      }

      if(this.b != null && var3 != 21) {
         label47: {
            if(var3 == 22) {
               var6 += this.b.getPreferredSize().width;
               if(!var10) {
                  break label47;
               }
            }

            if(var9 != null && var8 != null && (double)var8.height > (double)var9.height / var2.getZoom()) {
               var6 += this.b.getPreferredSize().width;
            }
         }
      }

      if(this.c != null && var4 != 31) {
         if(var4 == 32) {
            var7 += this.c.getPreferredSize().height;
            if(!var10) {
               return new Dimension(var6, var7);
            }
         }

         if(var9 != null && var8 != null && (double)var8.width > (double)var9.width / var2.getZoom()) {
            var7 += this.c.getPreferredSize().height;
         }
      }

      return new Dimension(var6, var7);
   }

   public Dimension minimumLayoutSize(Container var1) {
      ch var2 = (ch)var1;
      int var3 = var2.getVerticalScrollBarPolicy();
      int var4 = var2.getHorizontalScrollBarPolicy();
      Insets var5 = var2.getInsets();
      int var6 = var5.left + var5.right;
      int var7 = var5.top + var5.bottom;
      Dimension var8;
      if(this.a != null) {
         var8 = this.a.getMinimumSize();
         var6 += var8.width;
         var7 += var8.height;
      }

      if(this.b != null && var3 != 21) {
         var8 = this.b.getMinimumSize();
         var6 += var8.width;
         var7 = Math.max(var7, var8.height);
      }

      if(this.c != null && var4 != 21) {
         var8 = this.c.getMinimumSize();
         var6 = Math.max(var6, var8.width);
         var7 += var8.height;
      }

      if(this.f != null) {
         var6 = Math.max(var6, this.f.getMinimumSize().width);
         var7 = Math.max(var7, this.f.getMinimumSize().height);
      }

      return new Dimension(var6, var7);
   }

   public void layoutContainer(Container var1) {
      boolean var21 = fj.z;
      ch var2 = (ch)var1;
      Rectangle var3 = new Rectangle(var2.getSize());
      boolean var4 = false;
      if(this.e.width != var3.width || this.e.height != var3.height) {
         var4 = true;
         this.e.setSize(var3.width, var3.height);
      }

      int var5 = var2.getVerticalScrollBarPolicy();
      int var6 = var2.getHorizontalScrollBarPolicy();
      Insets var7 = var2.getInsets();
      var3.x = var7.left;
      var3.y = var7.top;
      var3.width -= var7.left + var7.right;
      var3.height -= var7.top + var7.bottom;
      Rectangle var8;
      if(var4 && var2.getFitContentOnResize()) {
         var8 = new Rectangle(var3);
         if(var6 == 32) {
            var8.height -= this.c.getPreferredSize().height;
         }

         if(var5 == 22) {
            var8.width -= this.b.getPreferredSize().width;
         }

         this.a.setBounds(var8);
         this.a.i();
      }

      Dimension var9;
      double var10;
      double var12;
      Rectangle var14;
      Point var15;
      boolean var16;
      label168: {
         var8 = var2.getWorldRect();
         var9 = var2.getSize();
         var10 = var2.getZoom();
         var12 = 1.0D;
         var14 = new Rectangle(0, var3.y, 0, 0);
         var15 = var2.getViewPoint();
         if(var5 == 22) {
            var16 = true;
            if(!var21) {
               break label168;
            }
         }

         if(var5 == 21) {
            var16 = false;
            if(!var21) {
               break label168;
            }
         }

         var16 = (double)var8.y + var12 < var15.getY() || (double)(var8.y + var8.height) - var12 > var15.getY() + (double)var9.height / var10;
      }

      if(this.b != null && var16) {
         int var17 = this.b.getPreferredSize().width;
         var3.width -= var17;
         var14.x = var3.x + var3.width;
         var14.width = var17;
      }

      boolean var18;
      Rectangle var22;
      label169: {
         var22 = new Rectangle(var3.x, 0, 0, 0);
         if(var6 == 32) {
            var18 = true;
            if(!var21) {
               break label169;
            }
         }

         if(var6 == 31) {
            var18 = false;
            if(!var21) {
               break label169;
            }
         }

         if(var16) {
            var18 = (double)var8.x + var12 < var15.getX() || (double)(var8.x + var8.width) - var12 > var15.getX() + (double)(var9.width - var14.width) / var10;
            if(!var21) {
               break label169;
            }
         }

         var18 = (double)var8.x + var12 < var15.getX() || (double)(var8.x + var8.width) - var12 > var15.getX() + (double)var9.width / var10;
      }

      if(this.c != null && var18) {
         int var19 = this.c.getPreferredSize().height;
         var3.height -= var19;
         var22.y = var3.y + var3.height;
         var22.height = var19;
         if(this.b != null && !var16 && var5 != 21) {
            var16 = (double)var8.y + var12 < var15.getY() || (double)(var8.y + var8.height) - var12 > var15.getY() + (double)var3.height / var10;
            if(var16) {
               int var20 = this.b.getPreferredSize().width;
               var3.width -= var20;
               var14.x = var3.x + var3.width;
               var14.width = var20;
            }
         }
      }

      var14.height = var3.height;
      var22.width = var3.width;
      if(this.a != null) {
         this.a.setBounds(var3);
      }

      if(this.d != null && this.b != null && var16 && this.c != null && var18) {
         this.d.setBounds(var3.width, var3.height, var14.width, var22.height);
      }

      if(this.f != null) {
         this.f.setBounds(var3);
      }

      var2.q();
      if(this.b != null) {
         label95: {
            if(var16) {
               this.b.setBounds(var14);
               this.b.setVisible(true);
               if(!var21) {
                  break label95;
               }
            }

            this.b.setVisible(false);
         }
      }

      if(this.c != null) {
         if(var18) {
            this.c.setBounds(var22);
            this.c.setVisible(true);
            if(!var21) {
               return;
            }
         }

         this.c.setVisible(false);
      }

   }

   public boolean a(Container var1) {
      ch var2;
      int var3;
      int var4;
      Rectangle var5;
      Rectangle var7;
      Dimension var8;
      double var9;
      Rectangle var11;
      boolean var12;
      boolean var16;
      label87: {
         var16 = fj.z;
         var2 = (ch)var1;
         var3 = var2.getVerticalScrollBarPolicy();
         var4 = var2.getHorizontalScrollBarPolicy();
         var5 = new Rectangle(var2.getSize());
         Insets var6 = var2.getInsets();
         var5.x = var6.left;
         var5.y = var6.top;
         var5.width -= var6.left + var6.right;
         var5.height -= var6.top + var6.bottom;
         var7 = var2.getWorldRect();
         var8 = var2.getSize();
         var9 = var2.getZoom();
         var11 = new Rectangle(0, var5.y, 0, 0);
         if(var3 == 22) {
            var12 = true;
            if(!var16) {
               break label87;
            }
         }

         if(var3 == 21) {
            var12 = false;
            if(!var16) {
               break label87;
            }
         }

         var12 = (double)var7.height > (double)var8.height / var9;
      }

      if(this.b != null && var12) {
         int var13 = this.b.getPreferredSize().width;
         var5.width -= var13;
         var11.x = var5.x + var5.width;
         var11.width = var13;
      }

      boolean var14;
      Rectangle var17;
      label88: {
         var17 = new Rectangle(var5.x, 0, 0, 0);
         var14 = false;
         if(var4 == 32) {
            var14 = true;
            if(!var16) {
               break label88;
            }
         }

         if(var4 == 31) {
            var14 = false;
            if(!var16) {
               break label88;
            }
         }

         if(var12) {
            var14 = (double)var7.width > (double)(var8.width - var11.width) / var9;
            if(!var16) {
               break label88;
            }
         }

         var14 = (double)var7.width > (double)var8.width / var9;
      }

      if(this.c != null && var14) {
         int var15 = this.c.getPreferredSize().height;
         var5.height -= var15;
         var17.y = var5.y + var5.height;
         var17.height = var15;
         if(this.b != null && !var12 && var3 != 21) {
            var12 = (double)var7.height > (double)var5.height / var2.getZoom();
         }
      }

      return var12 != this.b.isVisible() || var14 != this.c.isVisible();
   }
}
