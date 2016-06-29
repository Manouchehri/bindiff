package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.resources.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

class ScriptingMenuBar$PasteAction extends AbstractAction
{
    final /* synthetic */ ScriptingMenuBar this$0;
    
    public ScriptingMenuBar$PasteAction(final ScriptingMenuBar this$0) {
        this.this$0 = this$0;
        super(Constants.MENU_EDIT_PASTE);
        this.putValue("AcceleratorKey", KeyStroke.getKeyStroke(86, ScriptingMenuBar.CTRL_MASK));
        this.putValue("SmallIcon", new ImageIcon(Constants.class.getResource("page_white_paste.png")));
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.pasteMenuClicked();
    }
}
