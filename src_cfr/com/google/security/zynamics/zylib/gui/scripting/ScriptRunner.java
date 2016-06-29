/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.scripting.IScriptConsole;
import com.google.security.zynamics.zylib.io.FileUtils;
import java.io.File;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptRunner {
    private static final ScriptEngineManager manager = new ScriptEngineManager();

    public static boolean canRun(File file) {
        if (manager.getEngineByExtension(FileUtils.getFileExtension(file)) == null) return false;
        return true;
    }

    public static void runPythonScript(String string, List list) {
        ScriptEngine scriptEngine = manager.getEngineByName("python");
        ScriptRunner.runScript(scriptEngine, string, list);
    }

    public static void runScript(File file, List list) {
        ScriptEngine scriptEngine = manager.getEngineByExtension(FileUtils.getFileExtension(file));
        Preconditions.checkNotNull(scriptEngine, "Error: Script %s has an unknown extension.", file.getAbsolutePath());
        String string = FileUtils.readTextfile(file);
        ScriptRunner.runScript(scriptEngine, string, list);
    }

    public static void runScript(ScriptEngine scriptEngine, File file, List list) {
        Preconditions.checkNotNull(scriptEngine, "Error: Script %s has an unknown extension.", file.getAbsolutePath());
        String string = FileUtils.readTextfile(file);
        ScriptRunner.runScript(scriptEngine, string, list);
    }

    public static Object runScript(ScriptEngine scriptEngine, String string, List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Pair pair = (Pair)iterator.next();
            scriptEngine.put((String)pair.first(), pair.second());
        }
        return scriptEngine.eval(string);
    }

    public static void runScript(String string, String string2, List list, IScriptConsole iScriptConsole) {
        ScriptEngine scriptEngine = manager.getEngineByName(string);
        Preconditions.checkNotNull(scriptEngine, "Error: Unknown scripting language");
        scriptEngine.getContext().setWriter(iScriptConsole.getWriter());
        ScriptRunner.runScript(scriptEngine, string2, list);
    }
}

