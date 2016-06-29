package com.google.security.zynamics.zylib.gui.JCaret;

import java.awt.event.*;
import javax.swing.*;
import com.google.common.base.*;
import java.util.*;
import java.awt.*;

class JCaret$InternalListener implements ActionListener
{
    final /* synthetic */ JCaret this$0;
    
    private JCaret$InternalListener(final JCaret this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.m_isCaretVisible = !this.this$0.m_isCaretVisible;
        this.this$0.notifyListeners();
    }
}
