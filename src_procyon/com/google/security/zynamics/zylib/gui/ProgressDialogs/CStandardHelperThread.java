package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.general.*;
import java.util.*;

public abstract class CStandardHelperThread extends Thread implements IStandardDescriptionUpdater, IStandardProgressModel
{
    private final ListenerProvider m_listeners;
    private Exception m_exception;
    
    public CStandardHelperThread() {
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
    public final void addProgressListener(final IStandardProgressListener standardProgressListener) {
        this.m_listeners.addListener(standardProgressListener);
    }
    
    @Override
    public void closeRequested() {
    }
    
    public Exception getException() {
        return this.m_exception;
    }
    
    @Override
    public void next() {
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().next();
        }
    }
    
    @Override
    public final void removeProgressListener(final IStandardProgressListener standardProgressListener) {
        this.m_listeners.removeListener(standardProgressListener);
    }
    
    @Override
    public void reset() {
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().reset();
        }
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
    
    @Override
    public void setMaximum(final int n) {
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedMaximum(n);
        }
    }
}
