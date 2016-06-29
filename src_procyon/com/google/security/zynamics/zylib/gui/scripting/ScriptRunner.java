package com.google.security.zynamics.zylib.gui.scripting;

import java.io.*;
import com.google.security.zynamics.zylib.io.*;
import com.google.common.base.*;
import javax.script.*;
import com.google.security.zynamics.zylib.general.*;
import java.util.*;

public class ScriptRunner
{
    private static final ScriptEngineManager manager;
    
    public static boolean canRun(final File file) {
        return ScriptRunner.manager.getEngineByExtension(FileUtils.getFileExtension(file)) != null;
    }
    
    public static void runPythonScript(final String s, final List list) {
        runScript(ScriptRunner.manager.getEngineByName("python"), s, list);
    }
    
    public static void runScript(final File file, final List list) {
        final ScriptEngine engineByExtension = ScriptRunner.manager.getEngineByExtension(FileUtils.getFileExtension(file));
        Preconditions.checkNotNull(engineByExtension, "Error: Script %s has an unknown extension.", file.getAbsolutePath());
        runScript(engineByExtension, FileUtils.readTextfile(file), list);
    }
    
    public static void runScript(final ScriptEngine scriptEngine, final File file, final List list) {
        Preconditions.checkNotNull(scriptEngine, "Error: Script %s has an unknown extension.", file.getAbsolutePath());
        runScript(scriptEngine, FileUtils.readTextfile(file), list);
    }
    
    public static Object runScript(final ScriptEngine scriptEngine, final String s, final List list) {
        for (final Pair pair : list) {
            scriptEngine.put((String)pair.first(), pair.second());
        }
        return scriptEngine.eval(s);
    }
    
    public static void runScript(final String s, final String s2, final List list, final IScriptConsole scriptConsole) {
        final ScriptEngine engineByName = ScriptRunner.manager.getEngineByName(s);
        Preconditions.checkNotNull(engineByName, (Object)"Error: Unknown scripting language");
        engineByName.getContext().setWriter(scriptConsole.getWriter());
        runScript(engineByName, s2, list);
    }
    
    static {
        manager = new ScriptEngineManager();
    }
}
