package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.resources.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

class ScriptingMenuBar$ExecuteAction extends AbstractAction
{
    final /* synthetic */ ScriptingMenuBar this$0;
    
    public ScriptingMenuBar$ExecuteAction(final ScriptingMenuBar this$0) {
        this.this$0 = this$0;
        super(Constants.MENU_EXECUTE_SCRIPT);
        this.putValue("AcceleratorKey", KeyStroke.getKeyStroke(69, ScriptingMenuBar.CTRL_MASK));
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.executeMenuClicked();
    }
}
