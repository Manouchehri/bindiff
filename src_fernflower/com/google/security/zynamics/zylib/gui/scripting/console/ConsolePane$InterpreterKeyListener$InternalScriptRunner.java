package com.google.security.zynamics.zylib.gui.scripting.console;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressModel;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$1;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$InterpreterKeyListener;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$InterpreterKeyListener$InternalScriptRunner$1;
import java.util.Iterator;

class ConsolePane$InterpreterKeyListener$InternalScriptRunner implements IEndlessProgressModel {
   private final ListenerProvider listeners;
   private Thread m_thread;
   private boolean quitProperly;
   // $FF: synthetic field
   final ConsolePane$InterpreterKeyListener this$1;

   private ConsolePane$InterpreterKeyListener$InternalScriptRunner(ConsolePane$InterpreterKeyListener var1) {
      this.this$1 = var1;
      this.listeners = new ListenerProvider();
      this.quitProperly = true;
   }

   public void addProgressListener(IEndlessProgressListener var1) {
      this.listeners.addListener(var1);
   }

   public void closeRequested() {
      this.m_thread.stop();
      Iterator var1 = this.listeners.iterator();

      while(var1.hasNext()) {
         IEndlessProgressListener var2 = (IEndlessProgressListener)var1.next();
         var2.finished();
      }

   }

   public boolean quitProperly() {
      return this.quitProperly;
   }

   public void removeProgressListener(IEndlessProgressListener var1) {
      this.listeners.removeListener(var1);
   }

   public void run() {
      this.m_thread = new ConsolePane$InterpreterKeyListener$InternalScriptRunner$1(this);
      this.m_thread.start();
   }

   // $FF: synthetic method
   ConsolePane$InterpreterKeyListener$InternalScriptRunner(ConsolePane$InterpreterKeyListener var1, ConsolePane$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static boolean access$3202(ConsolePane$InterpreterKeyListener$InternalScriptRunner var0, boolean var1) {
      return var0.quitProperly = var1;
   }

   // $FF: synthetic method
   static ListenerProvider access$3300(ConsolePane$InterpreterKeyListener$InternalScriptRunner var0) {
      return var0.listeners;
   }
}
