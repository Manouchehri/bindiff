package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.gui.scripting.IScriptConsoleListener;
import java.io.Writer;

public interface IScriptConsole {
   void addListener(IScriptConsoleListener var1);

   String getOutput();

   Writer getWriter();

   void removeListener(IScriptConsoleListener var1);
}
