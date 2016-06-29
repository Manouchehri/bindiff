package com.google.security.zynamics.zylib.gui.scripting.console;

import com.google.security.zynamics.zylib.gui.scripting.CodeDocumentPython;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsoleHelpers;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ConsoleCodeDocument extends CodeDocumentPython {
   private static final long serialVersionUID = -4854242616532427400L;
   private final SimpleAttributeSet pythonPromptAttr = new SimpleAttributeSet();
   private KeyListener inputKeyListener;
   private String remainingTextString = null;
   private AttributeSet remainingTextAttr = null;
   private final ConsoleHelpers helpers;

   public ConsoleCodeDocument() {
      super(false);
      this.helpers = new ConsoleHelpers(this, this.normal);
      this.putProperty("__EndOfLine__", "\n");
      StyleConstants.setForeground(this.pythonPromptAttr, Color.LIGHT_GRAY);
      StyleConstants.setBold(this.pythonPromptAttr, true);
      StyleConstants.setFontSize(this.pythonPromptAttr, 13);
   }

   public void flushRemainingText(int var1) {
      if(this.remainingTextString != null) {
         try {
            this.insertString(var1, this.remainingTextString, this.remainingTextAttr);
         } catch (Exception var3) {
            var3.printStackTrace();
         }

         this.remainingTextString = null;
         this.remainingTextAttr = null;
      }
   }

   public int getCaretOffsetInLine(int var1) {
      return this.helpers.getCaretOffsetInLine(var1);
   }

   public String getCurrentLine(int var1) {
      return this.helpers.getCurrentLine(var1);
   }

   public int getLineStartOffset(int var1) {
      return this.helpers.getLineStartOffset(var1);
   }

   public String getWord(int var1) {
      return this.helpers.getWord(var1);
   }

   public void insertChar(int var1, String var2) {
      if(var1 >= 0) {
         try {
            super.insertString(var1, var2, this.normal);
         } catch (Exception var4) {
            var4.printStackTrace();
         }

      }
   }

   public void insertPrompt(int var1, String var2) {
      try {
         super.insertString(var1, var2, this.pythonPromptAttr);
      } catch (Exception var4) {
         var4.printStackTrace();
      }

   }

   public void insertString(int var1, String var2, AttributeSet var3) {
      if(var1 >= 0) {
         if(var2.length() > 1) {
            for(int var4 = 0; var4 < var2.length(); ++var4) {
               if(var2.charAt(var4) == 10) {
                  this.remainingTextString = var2.substring(var4 + 1);
                  this.remainingTextAttr = var3;
                  this.inputKeyListener.keyPressed(new KeyEvent(new Container(), 401, 0L, 0, 10, '\n'));
                  break;
               }

               int var10001 = var1 + var4;
               char var5 = var2.charAt(var4);
               this.insertChar(var10001, (new StringBuilder(1)).append(var5).toString());
            }
         } else if(var2.length() == 1) {
            this.insertChar(var1, var2);
         }

      }
   }

   public void setCurrentLine(int var1, int var2, String var3) {
      Element var4 = this.getParagraphElement(var1);
      int var5 = var4.getStartOffset();
      int var6 = var4.getEndOffset();

      try {
         this.remove(var5 + var2, var6 - (var5 + var2 + 1));
         super.insertString(var5 + var2, var3, this.normal);
      } catch (BadLocationException var8) {
         System.out.println("Bad location!");
         var8.printStackTrace();
      }

   }

   public void setInputKeyListener(KeyListener var1) {
      this.inputKeyListener = var1;
   }
}
