package com.google.security.zynamics.zylib.gui;

import java.awt.datatransfer.*;
import javax.swing.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.io.*;
import java.awt.*;

class CPathLabel$1 implements ActionListener
{
    final /* synthetic */ CPathLabel this$0;
    
    CPathLabel$1(final CPathLabel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final StringSelection stringSelection = new StringSelection(this.this$0.getText());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
    }
}
