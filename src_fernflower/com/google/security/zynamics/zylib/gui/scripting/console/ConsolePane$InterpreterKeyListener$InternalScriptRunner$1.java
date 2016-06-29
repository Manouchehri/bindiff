package com.google.security.zynamics.zylib.gui.scripting.console;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressListener;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$InterpreterKeyListener$InternalScriptRunner;
import java.util.Iterator;
import javax.script.ScriptException;

class ConsolePane$InterpreterKeyListener$InternalScriptRunner$1 extends Thread {
   // $FF: synthetic field
   final ConsolePane$InterpreterKeyListener$InternalScriptRunner this$2;

   ConsolePane$InterpreterKeyListener$InternalScriptRunner$1(ConsolePane$InterpreterKeyListener$InternalScriptRunner var1) {
      this.this$2 = var1;
   }

   public void run() {
      try {
         ConsolePane.access$3000(this.this$2.this$1.this$0).eval(ConsolePane.access$1700(this.this$2.this$1.this$0));
      } catch (ScriptException var3) {
         ConsolePane.access$3100(this.this$2.this$1.this$0).setText(var3.getLocalizedMessage());
         ConsolePane$InterpreterKeyListener$InternalScriptRunner.access$3202(this.this$2, false);
      }

      Iterator var1 = ConsolePane$InterpreterKeyListener$InternalScriptRunner.access$3300(this.this$2).iterator();

      while(var1.hasNext()) {
         IEndlessProgressListener var2 = (IEndlessProgressListener)var1.next();
         var2.finished();
      }

   }
}
