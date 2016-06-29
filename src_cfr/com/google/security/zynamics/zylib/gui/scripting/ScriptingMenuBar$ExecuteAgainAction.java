/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.gui.scripting.ScriptingMenuBar;
import com.google.security.zynamics.zylib.resources.Constants;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

class ScriptingMenuBar$ExecuteAgainAction
extends AbstractAction {
    final /* synthetic */ ScriptingMenuBar this$0;

    public ScriptingMenuBar$ExecuteAgainAction(ScriptingMenuBar scriptingMenuBar) {
        this.this$0 = scriptingMenuBar;
        super(String.format(Constants.MENU_EXECUTE_AGAIN_SCRIPT, "-"));
        this.putValue("AcceleratorKey", KeyStroke.getKeyStroke(69, ScriptingMenuBar.access$000() | 1));
        this.setFile(null);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.this$0.executeAgainMenuClicked();
    }

    public void setFile(File file) {
        if (file != null) {
            this.putValue("Name", String.format(Constants.MENU_EXECUTE_AGAIN_SCRIPT, file.getAbsolutePath()));
        } else {
            this.putValue("Name", String.format(Constants.MENU_EXECUTE_AGAIN_SCRIPT, "-"));
        }
        this.setEnabled(file != null);
    }
}

