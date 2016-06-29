package com.google.security.zynamics.zylib.gui;

import java.awt.event.*;

class CPathLabel$3 extends MouseAdapter
{
    final /* synthetic */ CPathLabel this$0;
    
    CPathLabel$3(final CPathLabel this$0) {
        this.this$0 = this$0;
    }
    
    private void handlePopupEvent(final MouseEvent mouseEvent) {
        if (mouseEvent.isPopupTrigger()) {
            this.this$0.m_popup.show(mouseEvent.getComponent(), mouseEvent.getX(), mouseEvent.getY());
        }
    }
    
    @Override
    public void mousePressed(final MouseEvent mouseEvent) {
        this.handlePopupEvent(mouseEvent);
    }
    
    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {
        this.handlePopupEvent(mouseEvent);
    }
}
