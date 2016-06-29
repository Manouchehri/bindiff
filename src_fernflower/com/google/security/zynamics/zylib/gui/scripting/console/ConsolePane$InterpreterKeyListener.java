package com.google.security.zynamics.zylib.gui.scripting.console;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog;
import com.google.security.zynamics.zylib.gui.scripting.InitStringFactory;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$1;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$InterpreterKeyListener$InternalScriptRunner;
import com.google.security.zynamics.zylib.resources.Constants;
import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

class ConsolePane$InterpreterKeyListener extends KeyAdapter {
   // $FF: synthetic field
   final ConsolePane this$0;

   private ConsolePane$InterpreterKeyListener(ConsolePane var1) {
      this.this$0 = var1;
   }

   private void execute() {
      ConsolePane$InterpreterKeyListener$InternalScriptRunner var1 = new ConsolePane$InterpreterKeyListener$InternalScriptRunner(this, (ConsolePane$1)null);
      CEndlessProgressDialog var2 = new CEndlessProgressDialog((Window)null, ConsolePane.access$300(this.this$0), Constants.MESSAGE_RUNNING_SCRIPT, var1);
      var1.run();
      var2.setVisible(true);
      if(var1.quitProperly()) {
         ConsolePane.access$500(this.this$0).setText(ConsolePane.access$400(this.this$0).getOutput());
      }

   }

   private void handleBackspace(KeyEvent var1) {
      if(ConsolePane.access$600(this.this$0).getSelectionStart() == ConsolePane.access$700(this.this$0).getSelectionEnd() && ConsolePane.access$900(this.this$0).getCaretOffsetInLine(ConsolePane.access$800(this.this$0).getCaretPosition()) <= ConsolePane.access$1000(this.this$0).length()) {
         var1.consume();
      }

   }

   private void handleDownKey(KeyEvent var1) {
      if(ConsolePane.access$1100(this.this$0) < ConsolePane.access$1200(this.this$0).size() - 1) {
         ConsolePane.access$1300(this.this$0, (String)ConsolePane.access$1200(this.this$0).get(ConsolePane.access$1104(this.this$0)));
      } else if(ConsolePane.access$1100(this.this$0) == ConsolePane.access$1200(this.this$0).size() - 1) {
         ConsolePane.access$1108(this.this$0);
         ConsolePane.access$1300(this.this$0, ConsolePane.access$1400(this.this$0));
      }

      var1.consume();
   }

   private void handleEnter(KeyEvent var1) {
      ConsolePane.access$1500(this.this$0);
      String var2 = ConsolePane.access$1600(this.this$0);
      ConsolePane var10000 = this.this$0;
      String var3 = ConsolePane.access$1700(this.this$0);
      ConsolePane.access$1702(var10000, (new StringBuilder(1 + String.valueOf(var3).length() + String.valueOf(var2).length())).append(var3).append(var2).append("\n").toString());
      ConsolePane.access$1402(this.this$0, "");
      if(var1.isControlDown()) {
         this.execute();
         ConsolePane.access$1702(this.this$0, InitStringFactory.getInitString(ConsolePane.access$1800(this.this$0), ConsolePane.access$1900(this.this$0), ConsolePane.access$2000(this.this$0)));
         ConsolePane.access$2100(this.this$0).flip();
         if(var2.trim().length() > 0) {
            ConsolePane.access$1200(this.this$0).add(var2);
         }

         ConsolePane.access$1102(this.this$0, ConsolePane.access$1200(this.this$0).size());
         ConsolePane.access$2200(this.this$0, false);
      } else {
         if(var2.trim().length() > 0) {
            ConsolePane.access$1200(this.this$0).add(var2);
         }

         ConsolePane.access$1102(this.this$0, ConsolePane.access$1200(this.this$0).size());
         ConsolePane.access$2200(this.this$0, true);
         ConsolePane.access$2300(this.this$0).flip();
      }

      ConsolePane.access$900(this.this$0).flushRemainingText(ConsolePane.access$2400(this.this$0).getText().length());
      var1.consume();
   }

   private void handleTabKey(KeyEvent var1) {
      int var2 = ConsolePane.access$2500(this.this$0).getCaretPosition() - ConsolePane.access$2600(this.this$0);
      String var3 = ConsolePane.access$900(this.this$0).getWord(var2);
      if(var3.length() > 0) {
         String var4 = ConsolePane.access$2700(this.this$0).getCompletion(var3);
         if(var4 != null) {
            String var5 = var4.substring(var3.length(), var4.length());

            try {
               ConsolePane.access$900(this.this$0).remove(var2, ConsolePane.access$2600(this.this$0));
               ConsolePane.access$900(this.this$0).insertString(var2, var5, (AttributeSet)null);
            } catch (BadLocationException var7) {
               var7.printStackTrace();
            }

            ConsolePane.access$2602(this.this$0, var5.length());
            var1.consume();
         }
      }

   }

   private void handleUpKey(KeyEvent var1) {
      if(ConsolePane.access$1100(this.this$0) > 0) {
         if(ConsolePane.access$1100(this.this$0) == ConsolePane.access$1200(this.this$0).size()) {
            ConsolePane.access$1500(this.this$0);
            ConsolePane.access$1402(this.this$0, ConsolePane.access$1600(this.this$0));
         }

         ConsolePane.access$1300(this.this$0, (String)ConsolePane.access$1200(this.this$0).get(ConsolePane.access$1106(this.this$0)));
      } else {
         ConsolePane.access$1102(this.this$0, 0);
      }

      var1.consume();
   }

   public void keyPressed(KeyEvent var1) {
      int var2 = ConsolePane.access$2800(this.this$0);
      int var3 = ConsolePane.access$2900(this.this$0);
      if(var2 != var3) {
         ConsolePane.access$1500(this.this$0);
      }

      if(var1.getKeyCode() == 10) {
         this.handleEnter(var1);
      } else if(var1.getModifiers() == 0) {
         if(var1.getKeyCode() == 38) {
            this.handleUpKey(var1);
         } else if(var1.getKeyCode() == 40) {
            this.handleDownKey(var1);
         } else if(var1.getKeyCode() == 9) {
            this.handleTabKey(var1);
         } else if(var1.getKeyCode() == 8) {
            this.handleBackspace(var1);
         }

         if(var1.getKeyCode() != 9) {
            ConsolePane.access$2700(this.this$0).reset();
            ConsolePane.access$2602(this.this$0, 0);
         }
      }

   }

   // $FF: synthetic method
   ConsolePane$InterpreterKeyListener(ConsolePane var1, ConsolePane$1 var2) {
      this(var1);
   }
}
