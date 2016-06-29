package com.google.security.zynamics.zylib.gui.scripting;

import java.io.*;

public interface IScriptConsole
{
    void addListener(final IScriptConsoleListener p0);
    
    String getOutput();
    
    Writer getWriter();
    
    void removeListener(final IScriptConsoleListener p0);
}
