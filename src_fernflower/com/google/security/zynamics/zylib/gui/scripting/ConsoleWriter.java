package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.scripting.IScriptConsole;
import com.google.security.zynamics.zylib.gui.scripting.IScriptConsoleListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;

public class ConsoleWriter extends PrintWriter implements IScriptConsole {
   private final StringWriter m_writer;
   private final ListenerProvider m_listeners = new ListenerProvider();
   public boolean softspace = false;

   public ConsoleWriter(StringWriter var1) {
      super(var1);
      this.m_writer = var1;
   }

   public void addListener(IScriptConsoleListener var1) {
      this.m_listeners.addListener(var1);
   }

   public String getOutput() {
      return this.m_writer.toString();
   }

   public String getOutputAndClearBuffer() {
      String var1 = this.getOutput();
      this.m_writer.getBuffer().delete(0, this.m_writer.getBuffer().length());
      return var1;
   }

   public Writer getWriter() {
      return this;
   }

   public void removeListener(IScriptConsoleListener var1) {
      this.m_listeners.removeListener(var1);
   }

   public void write(String var1) {
      super.write(var1);
      Iterator var2 = this.m_listeners.iterator();

      while(var2.hasNext()) {
         IScriptConsoleListener var3 = (IScriptConsoleListener)var2.next();

         try {
            var3.changedOutput(this);
         } catch (Exception var5) {
            var5.printStackTrace();
         }
      }

   }
}
