package com.google.security.zynamics.zylib.gui;

import java.awt.*;
import java.awt.event.*;

class CColorChooser$SelectedColorActionListener implements ActionListener
{
    Color m_color;
    final /* synthetic */ CColorChooser this$0;
    
    CColorChooser$SelectedColorActionListener(final CColorChooser this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.m_color = this.this$0.getColor();
    }
    
    public Color getColor() {
        return this.m_color;
    }
}
