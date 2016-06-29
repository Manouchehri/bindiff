/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.gui.scripting.IScriptConsoleListener;
import java.io.Writer;

public interface IScriptConsole {
    public void addListener(IScriptConsoleListener var1);

    public String getOutput();

    public Writer getWriter();

    public void removeListener(IScriptConsoleListener var1);
}

