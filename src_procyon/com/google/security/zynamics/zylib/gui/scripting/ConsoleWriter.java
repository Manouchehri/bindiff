package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.general.*;
import java.io.*;
import java.util.*;

public class ConsoleWriter extends PrintWriter implements IScriptConsole
{
    private final StringWriter m_writer;
    private final ListenerProvider m_listeners;
    public boolean softspace;
    
    public ConsoleWriter(final StringWriter writer) {
        super(writer);
        this.m_listeners = new ListenerProvider();
        this.softspace = false;
        this.m_writer = writer;
    }
    
    @Override
    public void addListener(final IScriptConsoleListener scriptConsoleListener) {
        this.m_listeners.addListener(scriptConsoleListener);
    }
    
    @Override
    public String getOutput() {
        return this.m_writer.toString();
    }
    
    public String getOutputAndClearBuffer() {
        final String output = this.getOutput();
        this.m_writer.getBuffer().delete(0, this.m_writer.getBuffer().length());
        return output;
    }
    
    @Override
    public Writer getWriter() {
        return this;
    }
    
    @Override
    public void removeListener(final IScriptConsoleListener scriptConsoleListener) {
        this.m_listeners.removeListener(scriptConsoleListener);
    }
    
    @Override
    public void write(final String s) {
        super.write(s);
        for (final IScriptConsoleListener scriptConsoleListener : this.m_listeners) {
            try {
                scriptConsoleListener.changedOutput(this);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
