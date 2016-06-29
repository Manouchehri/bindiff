package com.google.security.zynamics.zylib.gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class JCheckedListbox$InternalListener extends MouseAdapter
{
    final /* synthetic */ JCheckedListbox this$0;
    
    private JCheckedListbox$InternalListener(final JCheckedListbox this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void mouseClicked(final MouseEvent mouseEvent) {
        if (!this.this$0.isEnabled()) {
            return;
        }
        if (mouseEvent.getPoint().x > 20) {
            return;
        }
        final int locationToIndex = this.this$0.locationToIndex(mouseEvent.getPoint());
        this.this$0.m_selected[locationToIndex] = !this.this$0.m_selected[locationToIndex];
        this.this$0.updateUI();
        this.this$0.fireSelectionValueChanged(locationToIndex, locationToIndex, false);
    }
}
