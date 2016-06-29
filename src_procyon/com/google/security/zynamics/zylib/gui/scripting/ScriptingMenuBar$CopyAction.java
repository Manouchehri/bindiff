package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.resources.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

class ScriptingMenuBar$CopyAction extends AbstractAction
{
    final /* synthetic */ ScriptingMenuBar this$0;
    
    public ScriptingMenuBar$CopyAction(final ScriptingMenuBar this$0) {
        this.this$0 = this$0;
        super(Constants.MENU_EDIT_COPY);
        this.putValue("AcceleratorKey", KeyStroke.getKeyStroke(67, ScriptingMenuBar.CTRL_MASK));
        this.putValue("SmallIcon", new ImageIcon(Constants.class.getResource("page_white_copy.png")));
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.copyMenuClicked();
    }
}
