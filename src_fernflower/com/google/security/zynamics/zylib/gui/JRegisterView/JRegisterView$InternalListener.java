package com.google.security.zynamics.zylib.gui.JRegisterView;

import com.google.security.zynamics.zylib.gui.JCaret.ICaretListener;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret;
import com.google.security.zynamics.zylib.gui.JRegisterView.IRegistersChangedListener;
import com.google.security.zynamics.zylib.gui.JRegisterView.JRegisterView;
import com.google.security.zynamics.zylib.gui.JRegisterView.JRegisterView$1;
import com.google.security.zynamics.zylib.gui.JRegisterView.RegisterInformationInternal;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.math.BigInteger;
import javax.swing.JPopupMenu;

class JRegisterView$InternalListener implements ICaretListener, IRegistersChangedListener, FocusListener, KeyListener, MouseListener, MouseMotionListener {
   // $FF: synthetic field
   final JRegisterView this$0;

   private JRegisterView$InternalListener(JRegisterView var1) {
      this.this$0 = var1;
   }

   private int hexToValue(char var1) {
      return var1 >= 65 && var1 <= 70?var1 - 65 + 10:(var1 >= 97 && var1 <= 102?var1 - 97 + 10:var1 - 48);
   }

   private boolean isHexChar(char var1) {
      return var1 >= 97 && var1 <= 102 || var1 >= 65 && var1 <= 70 || var1 >= 48 && var1 <= 57;
   }

   public void caretStatusChanged(JCaret var1) {
      this.this$0.repaint();
   }

   public void focusGained(FocusEvent var1) {
   }

   public void focusLost(FocusEvent var1) {
      if(JRegisterView.access$100(this.this$0) != 1) {
         JRegisterView.access$200(this.this$0, false);
      }

   }

   public void keyPressed(KeyEvent var1) {
      if(var1.getKeyCode() == 39) {
         if(JRegisterView.access$300(this.this$0) != 2 * JRegisterView.access$400(this.this$0).getRegisterInformation(JRegisterView.access$100(this.this$0)).getRegisterSize()) {
            JRegisterView.access$308(this.this$0);
         }

         var1.consume();
         JRegisterView.access$500(this.this$0).setVisible(true);
         this.this$0.repaint();
      } else if(var1.getKeyCode() == 37) {
         if(JRegisterView.access$300(this.this$0) != 0) {
            JRegisterView.access$310(this.this$0);
         }

         var1.consume();
         JRegisterView.access$500(this.this$0).setVisible(true);
         this.this$0.repaint();
      } else if(var1.getKeyCode() == 10) {
         if(JRegisterView.access$100(this.this$0) == -1) {
            if(JRegisterView.access$600(this.this$0) != -1) {
               JRegisterView.access$700(this.this$0, JRegisterView.access$600(this.this$0));
            }
         } else {
            JRegisterView.access$200(this.this$0, true);
         }

         this.this$0.repaint();
      } else if(this.isHexChar(var1.getKeyChar())) {
         int var2 = JRegisterView.access$400(this.this$0).getRegisterInformation(JRegisterView.access$100(this.this$0)).getRegisterSize();
         if(JRegisterView.access$300(this.this$0) == 2 * var2) {
            return;
         }

         long var3 = (long)this.hexToValue(var1.getKeyChar());
         long var5 = (long)(var2 * 8 - 4 - JRegisterView.access$300(this.this$0) * 4);
         long var7 = 15L << (int)var5;
         long var9 = var3 << (int)var5;
         JRegisterView.access$802(this.this$0, JRegisterView.access$800(this.this$0).and(BigInteger.valueOf(~var7)).or(BigInteger.valueOf(var9)));
         JRegisterView.access$308(this.this$0);
         JRegisterView.access$500(this.this$0).setVisible(true);
         this.this$0.repaint();
      }

   }

   public void keyReleased(KeyEvent var1) {
   }

   public void keyTyped(KeyEvent var1) {
   }

   public void mouseClicked(MouseEvent var1) {
      int var2 = JRegisterView.access$900(this.this$0, var1.getX(), var1.getY());
      if(var1.getButton() == 1) {
         if(var1.getClickCount() == 1) {
            if(JRegisterView.access$100(this.this$0) != -1 && var2 != JRegisterView.access$100(this.this$0)) {
               JRegisterView.access$200(this.this$0, false);
            }
         } else if(var1.getClickCount() == 2 && var2 != -1 && JRegisterView.access$100(this.this$0) == -1) {
            RegisterInformationInternal var3 = JRegisterView.access$400(this.this$0).getRegisterInformation(var2);
            if(var3.getRegisterSize() == 0) {
               JRegisterView.access$400(this.this$0).setValue(var3.getRegisterName(), var3.getValue().xor(BigInteger.ONE));
            } else {
               JRegisterView.access$700(this.this$0, JRegisterView.access$600(this.this$0));
            }
         }
      } else if(var1.getButton() == 3 && var1.getClickCount() == 1) {
         if(JRegisterView.access$100(this.this$0) != -1 && var2 != JRegisterView.access$100(this.this$0)) {
            JRegisterView.access$200(this.this$0, false);
         }

         JPopupMenu var4 = JRegisterView.access$1000(this.this$0).getRegisterMenu(var2);
         if(var4 != null) {
            var4.show(this.this$0, var1.getX(), var1.getY());
         }
      }

   }

   public void mouseDragged(MouseEvent var1) {
   }

   public void mouseEntered(MouseEvent var1) {
   }

   public void mouseExited(MouseEvent var1) {
      if(JRegisterView.access$100(this.this$0) == -1) {
         JRegisterView.access$602(this.this$0, -1);
         this.this$0.repaint();
      }

   }

   public void mouseMoved(MouseEvent var1) {
      JRegisterView.access$602(this.this$0, JRegisterView.access$900(this.this$0, var1.getX(), var1.getY()));
      this.this$0.repaint();
   }

   public void mousePressed(MouseEvent var1) {
   }

   public void mouseReleased(MouseEvent var1) {
   }

   public void registerDataChanged() {
      JRegisterView.access$1100(this.this$0);
      JRegisterView.access$1200(this.this$0);
      this.this$0.repaint();
   }

   // $FF: synthetic method
   JRegisterView$InternalListener(JRegisterView var1, JRegisterView$1 var2) {
      this(var1);
   }
}
