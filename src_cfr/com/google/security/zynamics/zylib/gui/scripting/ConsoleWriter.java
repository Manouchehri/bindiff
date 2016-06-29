/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.scripting.IScriptConsole;
import com.google.security.zynamics.zylib.gui.scripting.IScriptConsoleListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;

public class ConsoleWriter
extends PrintWriter
implements IScriptConsole {
    private final StringWriter m_writer;
    private final ListenerProvider m_listeners = new ListenerProvider();
    public boolean softspace = false;

    public ConsoleWriter(StringWriter stringWriter) {
        super(stringWriter);
        this.m_writer = stringWriter;
    }

    @Override
    public void addListener(IScriptConsoleListener iScriptConsoleListener) {
        this.m_listeners.addListener(iScriptConsoleListener);
    }

    @Override
    public String getOutput() {
        return this.m_writer.toString();
    }

    public String getOutputAndClearBuffer() {
        String string = this.getOutput();
        this.m_writer.getBuffer().delete(0, this.m_writer.getBuffer().length());
        return string;
    }

    @Override
    public Writer getWriter() {
        return this;
    }

    @Override
    public void removeListener(IScriptConsoleListener iScriptConsoleListener) {
        this.m_listeners.removeListener(iScriptConsoleListener);
    }

    @Override
    public void write(String string) {
        super.write(string);
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IScriptConsoleListener iScriptConsoleListener = (IScriptConsoleListener)iterator.next();
            try {
                iScriptConsoleListener.changedOutput(this);
            }
            catch (Exception var4_4) {
                var4_4.printStackTrace();
                continue;
            }
        }
    }
}

