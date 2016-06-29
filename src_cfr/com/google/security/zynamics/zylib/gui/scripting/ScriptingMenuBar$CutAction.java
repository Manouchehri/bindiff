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
import javax.swing.KeyStroke;

class ScriptingMenuBar$CutAction
extends AbstractAction {
    final /* synthetic */ ScriptingMenuBar this$0;

    public ScriptingMenuBar$CutAction(ScriptingMenuBar scriptingMenuBar) {
        this.this$0 = scriptingMenuBar;
        super(Constants.MENU_EDIT_CUT);
        this.putValue("AcceleratorKey", KeyStroke.getKeyStroke(88, ScriptingMenuBar.access$000()));
        this.putValue("SmallIcon", new ImageIcon(Constants.class.getResource("cut.png")));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.this$0.cutMenuClicked();
    }
}

