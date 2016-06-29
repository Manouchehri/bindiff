package com.google.security.zynamics.zylib.gui;

import java.awt.*;
import java.awt.event.*;

class CColorChooser$RecentColorsColorChooserPanel$1 extends MouseAdapter
{
    final /* synthetic */ Color val$col;
    final /* synthetic */ CColorChooser$RecentColorsColorChooserPanel this$1;
    
    CColorChooser$RecentColorsColorChooserPanel$1(final CColorChooser$RecentColorsColorChooserPanel this$1, final Color val$col) {
        this.this$1 = this$1;
        this.val$col = val$col;
    }
    
    @Override
    public void mouseClicked(final MouseEvent mouseEvent) {
        if (mouseEvent.getButton() != 1) {
            return;
        }
        this.this$1.getColorSelectionModel().setSelectedColor(this.val$col);
    }
}
