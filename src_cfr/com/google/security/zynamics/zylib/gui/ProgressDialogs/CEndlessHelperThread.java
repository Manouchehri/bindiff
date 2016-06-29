/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessDescriptionUpdater;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressModel;
import java.util.Iterator;

public abstract class CEndlessHelperThread
extends Thread
implements IEndlessDescriptionUpdater,
IEndlessProgressModel {
    private final ListenerProvider m_listeners = new ListenerProvider();
    private Exception m_exception;

    private void notifyListeners() {
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IEndlessProgressListener iEndlessProgressListener = (IEndlessProgressListener)iterator.next();
            iEndlessProgressListener.finished();
        }
    }

    protected void finish() {
        this.notifyListeners();
        this.stop();
    }

    protected abstract void runExpensiveCommand();

    @Override
    public final void addProgressListener(IEndlessProgressListener iEndlessProgressListener) {
        this.m_listeners.addListener(iEndlessProgressListener);
    }

    @Override
    public void closeRequested() {
    }

    public Exception getException() {
        return this.m_exception;
    }

    @Override
    public final void removeProgressListener(IEndlessProgressListener iEndlessProgressListener) {
        this.m_listeners.removeListener(iEndlessProgressListener);
    }

    @Override
    public final void run() {
        try {
            this.runExpensiveCommand();
            return;
        }
        catch (Exception var1_1) {
            this.m_exception = var1_1;
            return;
        }
        finally {
            this.notifyListeners();
        }
    }

    @Override
    public void setDescription(String string) {
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IEndlessProgressListener iEndlessProgressListener = (IEndlessProgressListener)iterator.next();
            iEndlessProgressListener.changedDescription(string);
        }
    }

    public void setGeneralDescription(String string) {
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IEndlessProgressListener iEndlessProgressListener = (IEndlessProgressListener)iterator.next();
            iEndlessProgressListener.changedGeneralDescription(string);
        }
    }
}

