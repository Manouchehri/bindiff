package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.general.*;
import java.util.*;

public abstract class CEndlessHelperThread extends Thread implements IEndlessDescriptionUpdater, IEndlessProgressModel
{
    private final ListenerProvider m_listeners;
    private Exception m_exception;
    
    public CEndlessHelperThread() {
        this.m_listeners = new ListenerProvider();
    }
    
    private void notifyListeners() {
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().finished();
        }
    }
    
    protected void finish() {
        this.notifyListeners();
        this.stop();
    }
    
    protected abstract void runExpensiveCommand();
    
    @Override
    public final void addProgressListener(final IEndlessProgressListener endlessProgressListener) {
        this.m_listeners.addListener(endlessProgressListener);
    }
    
    @Override
    public void closeRequested() {
    }
    
    public Exception getException() {
        return this.m_exception;
    }
    
    @Override
    public final void removeProgressListener(final IEndlessProgressListener endlessProgressListener) {
        this.m_listeners.removeListener(endlessProgressListener);
    }
    
    @Override
    public final void run() {
        try {
            this.runExpensiveCommand();
        }
        catch (Exception exception) {
            this.m_exception = exception;
        }
        finally {
            this.notifyListeners();
        }
    }
    
    @Override
    public void setDescription(final String s) {
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedDescription(s);
        }
    }
    
    public void setGeneralDescription(final String s) {
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedGeneralDescription(s);
        }
    }
}
