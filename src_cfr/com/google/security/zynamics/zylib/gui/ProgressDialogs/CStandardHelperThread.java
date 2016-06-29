/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IStandardDescriptionUpdater;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IStandardProgressListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IStandardProgressModel;
import java.util.Iterator;

public abstract class CStandardHelperThread
extends Thread
implements IStandardDescriptionUpdater,
IStandardProgressModel {
    private final ListenerProvider m_listeners = new ListenerProvider();
    private Exception m_exception;

    private void notifyListeners() {
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IStandardProgressListener iStandardProgressListener = (IStandardProgressListener)iterator.next();
            iStandardProgressListener.finished();
        }
    }

    protected void finish() {
        this.notifyListeners();
        this.stop();
    }

    protected abstract void runExpensiveCommand();

    @Override
    public final void addProgressListener(IStandardProgressListener iStandardProgressListener) {
        this.m_listeners.addListener(iStandardProgressListener);
    }

    @Override
    public void closeRequested() {
    }

    public Exception getException() {
        return this.m_exception;
    }

    @Override
    public void next() {
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IStandardProgressListener iStandardProgressListener = (IStandardProgressListener)iterator.next();
            iStandardProgressListener.next();
        }
    }

    @Override
    public final void removeProgressListener(IStandardProgressListener iStandardProgressListener) {
        this.m_listeners.removeListener(iStandardProgressListener);
    }

    @Override
    public void reset() {
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IStandardProgressListener iStandardProgressListener = (IStandardProgressListener)iterator.next();
            iStandardProgressListener.reset();
        }
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
            IStandardProgressListener iStandardProgressListener = (IStandardProgressListener)iterator.next();
            iStandardProgressListener.changedDescription(string);
        }
    }

    @Override
    public void setMaximum(int n2) {
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IStandardProgressListener iStandardProgressListener = (IStandardProgressListener)iterator.next();
            iStandardProgressListener.changedMaximum(n2);
        }
    }
}

