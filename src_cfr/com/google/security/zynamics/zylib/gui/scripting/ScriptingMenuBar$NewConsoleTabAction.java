/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.gui.scripting.ScriptingMenuBar;
import com.google.security.zynamics.zylib.resources.Constants;
import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

class ScriptingMenuBar$NewConsoleTabAction
extends AbstractAction {
    final /* synthetic */ ScriptingMenuBar this$0;

    public ScriptingMenuBar$NewConsoleTabAction(ScriptingMenuBar scriptingMenuBar) {
        this.this$0 = scriptingMenuBar;
        super(Constants.MENU_SCRIPTING_CONSOLE);
        this.putValue("SmallIcon", new ImageIcon(Constants.class.getResource("application_xp_terminal.png")));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.this$0.newConsoleTabMenuClicked();
    }
}

