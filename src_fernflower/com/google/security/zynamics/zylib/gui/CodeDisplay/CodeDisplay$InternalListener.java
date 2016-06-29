package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplay;
import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplay$1;
import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplayCoordinate;
import com.google.security.zynamics.zylib.gui.JCaret.ICaretListener;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

class CodeDisplay$InternalListener extends MouseAdapter implements ICaretListener, AdjustmentListener, ComponentListener, FocusListener, KeyListener {
   // $FF: synthetic field
   final CodeDisplay this$0;

   private CodeDisplay$InternalListener(CodeDisplay var1) {
      this.this$0 = var1;
   }

   public void adjustmentValueChanged(AdjustmentEvent var1) {
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
      this.this$0.updateVisibleLinesAndColumns();
      CodeDisplay.access$100(this.this$0);
      CodeDisplay.access$200(this.this$0);
   }

   public void componentShown(ComponentEvent var1) {
   }

   public void focusGained(FocusEvent var1) {
      this.this$0.repaint();
   }

   public void focusLost(FocusEvent var1) {
      this.this$0.repaint();
   }

   public void keyPressed(KeyEvent var1) {
      if(var1.isActionKey()) {
         CodeDisplayCoordinate var2 = new CodeDisplayCoordinate(CodeDisplay.access$300(this.this$0));
         int var3 = var2.getLine();
         int var4 = var2.getRow();
         int var5 = var2.getFieldIndex();
         int var6 = var2.getColumn();
         int var7;
         int var8;
         switch(var1.getKeyCode()) {
         case 8:
            CodeDisplay.access$400(this.this$0).keyPressedOrTyped(var2, var1);
            break;
         case 9:
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         case 16:
         case 17:
         case 18:
         case 19:
         case 20:
         case 21:
         case 22:
         case 23:
         case 24:
         case 25:
         case 26:
         case 27:
         case 28:
         case 29:
         case 30:
         case 31:
         case 32:
         default:
            throw new IllegalArgumentException();
         case 33:
            for(var7 = 0; var7 < CodeDisplay.access$500(this.this$0) - 2; ++var7) {
               if(var2.getLine() == 0) {
                  var8 = Math.max(var2.getRow() - 1, 0);
                  var2.setRow(Math.max(var8, 0));
                  var2.setLine(CodeDisplay.access$400(this.this$0).getMaximumLinesForRow(var8) - 1);
               } else {
                  var2.setLine(Math.max(var2.getLine() - 1, 0));
               }
            }

            CodeDisplay.access$600(this.this$0).setValue(var2.getRow());
            break;
         case 34:
            for(var7 = 0; var7 < CodeDisplay.access$500(this.this$0) - 2; ++var7) {
               if(var2.getLine() >= CodeDisplay.access$400(this.this$0).getMaximumLinesForRow(var4) - 1) {
                  var2.setRow(Math.min(var2.getRow() + 1, CodeDisplay.access$400(this.this$0).getNumberOfRows()));
                  var2.setLine(0);
               } else {
                  var2.setLine(var2.getLine() + 1);
               }
            }

            CodeDisplay.access$600(this.this$0).setValue(var2.getRow());
            break;
         case 35:
            CodeDisplay.access$400(this.this$0).keyPressedOrTyped(var2, var1);
            break;
         case 36:
            CodeDisplay.access$400(this.this$0).keyPressedOrTyped(var2, var1);
            break;
         case 37:
            if(var5 == 0) {
               var2.setColumn(var6 - 1);
               var2.setFieldIndex(CodeDisplay.access$400(this.this$0).getColumnWidthInCharacters(var6 - 1) - 1);
            } else {
               var2.setFieldIndex(var5 - 1);
            }
            break;
         case 38:
            if(var3 == 0) {
               var7 = var4 - 1;
               var2.setRow(Math.max(var7, 0));
               var8 = CodeDisplay.access$400(this.this$0).getMaximumLinesForRow(var7);
               if(var8 > 0) {
                  var2.setLine(CodeDisplay.access$400(this.this$0).getMaximumLinesForRow(var7) - 1);
               }
            } else {
               var2.setLine(var3 - 1);
            }
            break;
         case 39:
            var5 = var2.getFieldIndex();
            if(var5 == CodeDisplay.access$400(this.this$0).getColumnWidthInCharacters(var6) - 1) {
               var2.setColumn(var6 + 1);
               var2.setFieldIndex(0);
            } else {
               var2.setFieldIndex(var5 + 1);
            }
            break;
         case 40:
            if(var3 == CodeDisplay.access$400(this.this$0).getMaximumLinesForRow(var4) - 1) {
               var2.setRow(Math.min(var4 + 1, CodeDisplay.access$400(this.this$0).getNumberOfRows()));
               var2.setLine(0);
            } else {
               var2.setLine(var3 + 1);
            }
         }

         if(CodeDisplay.access$400(this.this$0).canHaveCaret(var2)) {
            this.this$0.setCaretPosition(var2);
            CodeDisplay.access$100(this.this$0);
            CodeDisplay.access$700(this.this$0);
            this.this$0.repaint();
         }

      }
   }

   public void keyReleased(KeyEvent var1) {
   }

   public void keyTyped(KeyEvent var1) {
      if(CodeDisplay.access$400(this.this$0).isEditable(CodeDisplay.access$300(this.this$0))) {
         CodeDisplayCoordinate var2 = new CodeDisplayCoordinate(CodeDisplay.access$300(this.this$0));
         CodeDisplay.access$400(this.this$0).keyPressedOrTyped(CodeDisplay.access$300(this.this$0), var1);
         if(!var2.equals(CodeDisplay.access$300(this.this$0))) {
            CodeDisplay.access$700(this.this$0);
         }

         CodeDisplay.access$100(this.this$0);
         this.this$0.repaint();
      }

   }

   public void mouseClicked(MouseEvent var1) {
      this.this$0.requestFocusInWindow();
   }

   public void mouseDragged(MouseEvent var1) {
   }

   public void mouseEntered(MouseEvent var1) {
   }

   public void mouseExited(MouseEvent var1) {
   }

   public void mouseMoved(MouseEvent var1) {
   }

   public void mousePressed(MouseEvent var1) {
      CodeDisplayCoordinate var2 = new CodeDisplayCoordinate(0, 0, 0, 0);
      if(CodeDisplay.access$800(this.this$0, var1.getX(), var1.getY(), var2)) {
         if(CodeDisplay.access$400(this.this$0).canHaveCaret(var2)) {
            this.this$0.setCaretPosition(var2);
            CodeDisplay.access$100(this.this$0);
            CodeDisplay.access$700(this.this$0);
            this.this$0.repaint();
         }

      }
   }

   public void mouseReleased(MouseEvent var1) {
   }

   public void mouseWheelMoved(MouseWheelEvent var1) {
      int var2 = var1.getWheelRotation();
      CodeDisplay.access$600(this.this$0).setValue(CodeDisplay.access$600(this.this$0).getValue() + var2);
   }

   // $FF: synthetic method
   CodeDisplay$InternalListener(CodeDisplay var1, CodeDisplay$1 var2) {
      this(var1);
   }
}
