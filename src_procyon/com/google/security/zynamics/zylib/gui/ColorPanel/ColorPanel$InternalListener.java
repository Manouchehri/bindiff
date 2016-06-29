package com.google.security.zynamics.zylib.gui.ColorPanel;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.resources.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.zylib.general.*;
import java.util.*;

class ColorPanel$InternalListener extends MouseAdapter
{
    final /* synthetic */ ColorPanel this$0;
    
    private ColorPanel$InternalListener(final ColorPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void mouseClicked(final MouseEvent mouseEvent) {
        if (this.this$0.m_editable && mouseEvent.getButton() == 1 && mouseEvent.getClickCount() == 1) {
            this.this$0.chooseColor();
        }
    }
}
