/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting.console;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressModel;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$1;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$InterpreterKeyListener;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$InterpreterKeyListener$InternalScriptRunner$1;
import java.util.Iterator;

class ConsolePane$InterpreterKeyListener$InternalScriptRunner
implements IEndlessProgressModel {
    private final ListenerProvider listeners;
    private Thread m_thread;
    private boolean quitProperly;
    final /* synthetic */ ConsolePane$InterpreterKeyListener this$1;

    private ConsolePane$InterpreterKeyListener$InternalScriptRunner(ConsolePane$InterpreterKeyListener consolePane$InterpreterKeyListener) {
        this.this$1 = consolePane$InterpreterKeyListener;
        this.listeners = new ListenerProvider();
        this.quitProperly = true;
    }

    @Override
    public void addProgressListener(IEndlessProgressListener iEndlessProgressListener) {
        this.listeners.addListener(iEndlessProgressListener);
    }

    @Override
    public void closeRequested() {
        this.m_thread.stop();
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            IEndlessProgressListener iEndlessProgressListener = (IEndlessProgressListener)iterator.next();
            iEndlessProgressListener.finished();
        }
    }

    public boolean quitProperly() {
        return this.quitProperly;
    }

    @Override
    public void removeProgressListener(IEndlessProgressListener iEndlessProgressListener) {
        this.listeners.removeListener(iEndlessProgressListener);
    }

    public void run() {
        this.m_thread = new ConsolePane$InterpreterKeyListener$InternalScriptRunner$1(this);
        this.m_thread.start();
    }

    /* synthetic */ ConsolePane$InterpreterKeyListener$InternalScriptRunner(ConsolePane$InterpreterKeyListener consolePane$InterpreterKeyListener, ConsolePane$1 consolePane$1) {
        this(consolePane$InterpreterKeyListener);
    }

    static /* synthetic */ boolean access$3202(ConsolePane$InterpreterKeyListener$InternalScriptRunner consolePane$InterpreterKeyListener$InternalScriptRunner, boolean bl2) {
        consolePane$InterpreterKeyListener$InternalScriptRunner.quitProperly = bl2;
        return consolePane$InterpreterKeyListener$InternalScriptRunner.quitProperly;
    }

    static /* synthetic */ ListenerProvider access$3300(ConsolePane$InterpreterKeyListener$InternalScriptRunner consolePane$InterpreterKeyListener$InternalScriptRunner) {
        return consolePane$InterpreterKeyListener$InternalScriptRunner.listeners;
    }
}

