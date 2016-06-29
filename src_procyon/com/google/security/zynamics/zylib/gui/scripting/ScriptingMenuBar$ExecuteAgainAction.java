package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.resources.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class ScriptingMenuBar$ExecuteAgainAction extends AbstractAction
{
    final /* synthetic */ ScriptingMenuBar this$0;
    
    public ScriptingMenuBar$ExecuteAgainAction(final ScriptingMenuBar this$0) {
        this.this$0 = this$0;
        super(String.format(Constants.MENU_EXECUTE_AGAIN_SCRIPT, "-"));
        this.putValue("AcceleratorKey", KeyStroke.getKeyStroke(69, ScriptingMenuBar.CTRL_MASK | 0x1));
        this.setFile(null);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.executeAgainMenuClicked();
    }
    
    public void setFile(final File file) {
        if (file != null) {
            this.putValue("Name", String.format(Constants.MENU_EXECUTE_AGAIN_SCRIPT, file.getAbsolutePath()));
        }
        else {
            this.putValue("Name", String.format(Constants.MENU_EXECUTE_AGAIN_SCRIPT, "-"));
        }
        this.setEnabled(file != null);
    }
}
