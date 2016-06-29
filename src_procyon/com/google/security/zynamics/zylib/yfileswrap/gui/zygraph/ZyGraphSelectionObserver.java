package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import java.util.*;
import y.h.*;
import y.c.*;

public class ZyGraphSelectionObserver extends gj
{
    private final ListenerProvider m_selectionListeners;
    private int sequenceCounter;
    private boolean fireFlag;
    
    public ZyGraphSelectionObserver() {
        this.m_selectionListeners = new ListenerProvider();
        this.sequenceCounter = 0;
        this.fireFlag = false;
    }
    
    private void notifySelectionListeners() {
        for (final IZyGraphSelectionListener zyGraphSelectionListener : this.m_selectionListeners) {
            try {
                zyGraphSelectionListener.selectionChanged();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    protected void updateSelectionState(final bu bu) {
        this.notifySelectionListeners();
    }
    
    public void addListener(final IZyGraphSelectionListener zyGraphSelectionListener) {
        this.m_selectionListeners.addListener(zyGraphSelectionListener);
    }
    
    @Override
    public void onGraph2DSelectionEvent(final ce ce) {
        if (ce.c() || ce.b()) {
            return;
        }
        if (this.sequenceCounter == 0 && this.fireFlag) {
            this.updateSelectionState(ce.e());
            this.fireFlag = false;
        }
    }
    
    @Override
    public void onGraphEvent(final l l) {
        if (l.a() == 12) {
            ++this.sequenceCounter;
        }
        else if (l.a() == 13) {
            --this.sequenceCounter;
            if (this.sequenceCounter == 0) {
                this.updateSelectionState((bu)l.c());
                this.fireFlag = true;
            }
        }
    }
    
    public void removeListener(final IZyGraphSelectionListener zyGraphSelectionListener) {
        this.m_selectionListeners.removeListener(zyGraphSelectionListener);
    }
}
