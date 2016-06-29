package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.resources.*;
import javax.swing.*;
import java.awt.event.*;

class ScriptingMenuBar$NewConsoleTabAction extends AbstractAction
{
    final /* synthetic */ ScriptingMenuBar this$0;
    
    public ScriptingMenuBar$NewConsoleTabAction(final ScriptingMenuBar this$0) {
        this.this$0 = this$0;
        super(Constants.MENU_SCRIPTING_CONSOLE);
        this.putValue("SmallIcon", new ImageIcon(Constants.class.getResource("application_xp_terminal.png")));
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.newConsoleTabMenuClicked();
    }
}
