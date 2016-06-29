/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.gui.scripting.ScriptingMenuBar;
import com.google.security.zynamics.zylib.resources.Constants;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

class ScriptingMenuBar$ExecuteAction
extends AbstractAction {
    final /* synthetic */ ScriptingMenuBar this$0;

    public ScriptingMenuBar$ExecuteAction(ScriptingMenuBar scriptingMenuBar) {
        this.this$0 = scriptingMenuBar;
        super(Constants.MENU_EXECUTE_SCRIPT);
        this.putValue("AcceleratorKey", KeyStroke.getKeyStroke(69, ScriptingMenuBar.access$000()));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.this$0.executeMenuClicked();
    }
}

