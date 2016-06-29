package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.general.Convert;
import com.google.security.zynamics.zylib.gui.JCaret.ICaretListener;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret;
import com.google.security.zynamics.zylib.gui.JHexPanel.IDataChangedListener;
import com.google.security.zynamics.zylib.gui.JHexPanel.IHexPanelListener;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$1;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$Views;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import javax.swing.JPopupMenu;

class JHexView$InternalListener implements ICaretListener, IDataChangedListener, AdjustmentListener, ComponentListener, FocusListener, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
   // $FF: synthetic field
   final JHexView this$0;

   private JHexView$InternalListener(JHexView var1) {
      this.this$0 = var1;
   }

   private void keyPressedInAsciiView(KeyEvent var1) {
      byte[] var2 = JHexView.access$1100(this.this$0).getData(this.this$0.getCurrentOffset(), 1);
      if(JHexView.access$1200(this.this$0) < (long)(JHexView.access$1100(this.this$0).getDataLength() * 2)) {
         var2[0] = (byte)var1.getKeyChar();
         JHexView.access$1100(this.this$0).setData(this.this$0.getCurrentOffset(), var2);
         JHexView.access$1300(this.this$0, JHexView.access$1200(this.this$0) + 2L);
      }
   }

   private void keyPressedInHexView(KeyEvent var1) {
      byte[] var2 = JHexView.access$1100(this.this$0).getData(this.this$0.getCurrentOffset(), 1);
      long var3 = JHexView.access$1400(this.this$0) + JHexView.access$1200(this.this$0);
      if(JHexView.access$1200(this.this$0) < (long)(JHexView.access$1100(this.this$0).getDataLength() * 2)) {
         int var5 = Character.digit(var1.getKeyChar(), 16);
         if(var5 != -1) {
            if(var3 % 2L == 0L) {
               var2[0] = (byte)(var2[0] & 15 | var5 << 4);
            } else {
               var2[0] = (byte)(var2[0] & 240 | var5);
            }

            JHexView.access$1100(this.this$0).setData(this.this$0.getCurrentOffset(), var2);
            JHexView.access$1300(this.this$0, JHexView.access$1200(this.this$0) + 1L);
         }
      }
   }

   public void adjustmentValueChanged(AdjustmentEvent var1) {
      if(var1.getSource() == JHexView.access$1500(this.this$0)) {
         JHexView.access$1602(this.this$0, var1.getValue());
      } else {
         JHexView.access$1702(this.this$0, var1.getValue());
      }

      this.this$0.repaint();
   }

   public void caretStatusChanged(JCaret var1) {
      this.this$0.repaint();
   }

   public void componentHidden(ComponentEvent var1) {
   }

   public void componentMoved(ComponentEvent var1) {
   }

   public void componentResized(ComponentEvent var1) {
      JHexView.access$1800(this.this$0);
      int var2 = this.this$0.getWidth() + 1 - JHexView.access$1500(this.this$0).getWidth();
      int var3 = this.this$0.getHeight() + 1 - JHexView.access$1900(this.this$0).getHeight();
      var2 = Math.max(1, var2);
      var3 = Math.max(1, var3);
      JHexView.access$2002(this.this$0, new BufferedImage(var2, var3, 1));
      JHexView.access$2102(this.this$0, JHexView.access$2000(this.this$0).getGraphics());
   }

   public void componentShown(ComponentEvent var1) {
   }

   public void dataChanged() {
      JHexView.access$1800(this.this$0);
      this.this$0.repaint();
   }

   public void focusGained(FocusEvent var1) {
      JHexView.access$2200(this.this$0).setVisible(true);
      this.this$0.repaint();
   }

   public void focusLost(FocusEvent var1) {
      this.this$0.repaint();
   }

   public void keyPressed(KeyEvent var1) {
      if(this.this$0.isEnabled()) {
         if(JHexView.access$2300(this.this$0) == JHexView$Views.HEX_VIEW) {
            if(JHexView.access$1100(this.this$0).isEditable() && Convert.isHexCharacter(var1.getKeyChar())) {
               this.keyPressedInHexView(var1);
            }
         } else if(JHexView.access$1100(this.this$0).isEditable() && Convert.isPrintableCharacter(var1.getKeyChar())) {
            this.keyPressedInAsciiView(var1);
         }

         this.this$0.repaint();
      }
   }

   public void keyReleased(KeyEvent var1) {
   }

   public void keyTyped(KeyEvent var1) {
   }

   public void mouseClicked(MouseEvent var1) {
   }

   public void mouseDragged(MouseEvent var1) {
      if(this.this$0.isEnabled()) {
         int var2 = var1.getX();
         int var3 = var1.getY();
         if(var3 < 16 - (JHexView.access$2400(this.this$0) - JHexView.access$2500(this.this$0))) {
            JHexView.access$2700(this.this$0, (long)(2 * JHexView.access$2600(this.this$0) - 2 * JHexView.access$900(this.this$0)));
            if(this.this$0.getSelectionLength() - (long)(2 * JHexView.access$900(this.this$0)) < 0L) {
               return;
            }

            this.this$0.setSelectionLength(this.this$0.getSelectionLength() - (long)(2 * JHexView.access$900(this.this$0)));
         } else if(var3 >= JHexView.access$2400(this.this$0) * JHexView.access$2800(this.this$0)) {
            JHexView.access$2700(this.this$0, (long)(2 * JHexView.access$2600(this.this$0) + 2 * JHexView.access$900(this.this$0)));
            if(this.this$0.getSelectionLength() + (long)(2 * JHexView.access$900(this.this$0)) > 2L * ((long)JHexView.access$1100(this.this$0).getDataLength() - JHexView.access$1200(this.this$0))) {
               return;
            }

            this.this$0.setSelectionLength(this.this$0.getSelectionLength() + (long)(2 * JHexView.access$900(this.this$0)));
         } else {
            int var4 = JHexView.access$2900(this.this$0, var2, var3);
            if(var4 != -1) {
               this.this$0.setSelectionLength((long)var4 - JHexView.access$1200(this.this$0));
               this.this$0.repaint();
            }
         }

      }
   }

   public void mouseEntered(MouseEvent var1) {
   }

   public void mouseExited(MouseEvent var1) {
   }

   public void mouseMoved(MouseEvent var1) {
      JHexView.access$3002(this.this$0, var1.getX());
      JHexView.access$3102(this.this$0, var1.getY());
      this.this$0.repaint();
   }

   public void mousePressed(MouseEvent var1) {
      if(this.this$0.isEnabled()) {
         int var2;
         int var3;
         int var4;
         if(var1.getButton() == 1 || var1.getButton() == 3) {
            JHexView.access$3202(this.this$0, 0L);
            this.this$0.requestFocusInWindow();
            var2 = var1.getX();
            var3 = var1.getY();
            var4 = JHexView.access$2900(this.this$0, var2, var3);
            if(var4 != -1) {
               JHexView.access$2200(this.this$0).setVisible(true);
               JHexView.access$3300(this.this$0, (long)var4);
               if(JHexView.access$3400(this.this$0, var2, var3)) {
                  JHexView.access$2302(this.this$0, JHexView$Views.HEX_VIEW);
               } else if(JHexView.access$3500(this.this$0, var2, var3)) {
                  JHexView.access$2302(this.this$0, JHexView$Views.ASCII_VIEW);
               }

               this.this$0.repaint();
            } else {
               Iterator var5 = JHexView.access$3600(this.this$0).iterator();

               while(var5.hasNext()) {
                  IHexPanelListener var6 = (IHexPanelListener)var5.next();
                  var6.selectionChanged(JHexView.access$3700(this.this$0), JHexView.access$3200(this.this$0));
               }

               this.this$0.repaint();
            }
         }

         if(var1.getButton() == 3) {
            var2 = var1.getX();
            var3 = var1.getY();
            var4 = JHexView.access$2900(this.this$0, var2, var3);
            if(var4 != -1) {
               JHexView.access$2200(this.this$0).setVisible(true);
               if(JHexView.access$3800(this.this$0) != null) {
                  JPopupMenu var7 = JHexView.access$3800(this.this$0).createMenu(this.this$0.getCurrentOffset());
                  if(var7 != null) {
                     var7.show(this.this$0, var2, var3);
                  }
               }

               this.this$0.repaint();
            }
         }

      }
   }

   public void mouseReleased(MouseEvent var1) {
   }

   public void mouseWheelMoved(MouseWheelEvent var1) {
      if(this.this$0.isEnabled()) {
         int var2 = var1.getWheelRotation();
         JHexView.access$1500(this.this$0).setValue(JHexView.access$1500(this.this$0).getValue() + var2);
      }
   }

   // $FF: synthetic method
   JHexView$InternalListener(JHexView var1, JHexView$1 var2) {
      this(var1);
   }
}
