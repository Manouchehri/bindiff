package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.zylib.general.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.gui.JCaret.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import com.google.common.base.*;

class JHexView$TabAction extends AbstractAction
{
    private static final long serialVersionUID = -3265020583339369531L;
    final /* synthetic */ JHexView this$0;
    
    private JHexView$TabAction(final JHexView this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.this$0.m_activeView == JHexView$Views.HEX_VIEW) {
            this.this$0.m_activeView = JHexView$Views.ASCII_VIEW;
            this.this$0.setSelectionStart(this.this$0.getSelectionStart() - this.this$0.getSelectionStart() % 2L);
        }
        else {
            this.this$0.m_activeView = JHexView$Views.HEX_VIEW;
        }
        this.this$0.m_caret.setVisible(true);
        this.this$0.repaint();
    }
}
