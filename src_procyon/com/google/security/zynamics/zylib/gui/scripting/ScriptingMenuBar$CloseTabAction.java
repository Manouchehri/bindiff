package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.resources.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

class ScriptingMenuBar$CloseTabAction extends AbstractAction
{
    final /* synthetic */ ScriptingMenuBar this$0;
    
    public ScriptingMenuBar$CloseTabAction(final ScriptingMenuBar this$0) {
        this.this$0 = this$0;
        super(Constants.MENU_CLOSE_ACTIVE_TAB);
        this.putValue("AcceleratorKey", KeyStroke.getKeyStroke(81, ScriptingMenuBar.CTRL_MASK));
        this.putValue("SmallIcon", new ImageIcon(Constants.class.getResource("folder_delete.png")));
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.closeTabMenuClicked();
    }
}
