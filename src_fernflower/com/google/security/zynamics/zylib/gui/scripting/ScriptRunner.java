package com.google.security.zynamics.zylib.gui.scripting;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.scripting.IScriptConsole;
import com.google.security.zynamics.zylib.io.FileUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptRunner {
   private static final ScriptEngineManager manager = new ScriptEngineManager();

   public static boolean canRun(File var0) {
      return manager.getEngineByExtension(FileUtils.getFileExtension(var0)) != null;
   }

   public static void runPythonScript(String var0, List var1) {
      ScriptEngine var2 = manager.getEngineByName("python");
      runScript(var2, var0, var1);
   }

   public static void runScript(File var0, List var1) {
      ScriptEngine var2 = manager.getEngineByExtension(FileUtils.getFileExtension(var0));
      Preconditions.checkNotNull(var2, "Error: Script %s has an unknown extension.", new Object[]{var0.getAbsolutePath()});
      String var3 = FileUtils.readTextfile(var0);
      runScript(var2, var3, var1);
   }

   public static void runScript(ScriptEngine var0, File var1, List var2) {
      Preconditions.checkNotNull(var0, "Error: Script %s has an unknown extension.", new Object[]{var1.getAbsolutePath()});
      String var3 = FileUtils.readTextfile(var1);
      runScript(var0, var3, var2);
   }

   public static Object runScript(ScriptEngine var0, String var1, List var2) {
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Pair var4 = (Pair)var3.next();
         var0.put((String)var4.first(), var4.second());
      }

      return var0.eval(var1);
   }

   public static void runScript(String var0, String var1, List var2, IScriptConsole var3) {
      ScriptEngine var4 = manager.getEngineByName(var0);
      Preconditions.checkNotNull(var4, "Error: Unknown scripting language");
      var4.getContext().setWriter(var3.getWriter());
      runScript(var4, var1, var2);
   }
}
