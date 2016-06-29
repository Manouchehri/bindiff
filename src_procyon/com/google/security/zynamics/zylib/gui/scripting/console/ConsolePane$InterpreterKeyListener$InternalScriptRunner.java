package com.google.security.zynamics.zylib.gui.scripting.console;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import java.util.*;

class ConsolePane$InterpreterKeyListener$InternalScriptRunner implements IEndlessProgressModel
{
    private final ListenerProvider listeners;
    private Thread m_thread;
    private boolean quitProperly;
    final /* synthetic */ ConsolePane$InterpreterKeyListener this$1;
    
    private ConsolePane$InterpreterKeyListener$InternalScriptRunner(final ConsolePane$InterpreterKeyListener this$1) {
        this.this$1 = this$1;
        this.listeners = new ListenerProvider();
        this.quitProperly = true;
    }
    
    @Override
    public void addProgressListener(final IEndlessProgressListener endlessProgressListener) {
        this.listeners.addListener(endlessProgressListener);
    }
    
    @Override
    public void closeRequested() {
        this.m_thread.stop();
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().finished();
        }
    }
    
    public boolean quitProperly() {
        return this.quitProperly;
    }
    
    @Override
    public void removeProgressListener(final IEndlessProgressListener endlessProgressListener) {
        this.listeners.removeListener(endlessProgressListener);
    }
    
    public void run() {
        (this.m_thread = new ConsolePane$InterpreterKeyListener$InternalScriptRunner$1(this)).start();
    }
}
