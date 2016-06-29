package org.jfree.ui.about;

import java.awt.event.*;
import java.awt.*;

class SystemPropertiesPanel$PopupListener extends MouseAdapter
{
    private final SystemPropertiesPanel this$0;
    
    public SystemPropertiesPanel$PopupListener(final SystemPropertiesPanel this$0) {
        this.this$0 = this$0;
    }
    
    public void mousePressed(final MouseEvent mouseEvent) {
        this.maybeShowPopup(mouseEvent);
    }
    
    public void mouseReleased(final MouseEvent mouseEvent) {
        this.maybeShowPopup(mouseEvent);
    }
    
    private void maybeShowPopup(final MouseEvent mouseEvent) {
        if (mouseEvent.isPopupTrigger()) {
            this.this$0.getCopyPopupMenu().show(this.this$0.getTable(), mouseEvent.getX(), mouseEvent.getY());
        }
    }
}
