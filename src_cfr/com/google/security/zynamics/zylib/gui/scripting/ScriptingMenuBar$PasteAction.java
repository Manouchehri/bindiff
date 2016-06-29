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

class ScriptingMenuBar$PasteAction
extends AbstractAction {
    final /* synthetic */ ScriptingMenuBar this$0;

    public ScriptingMenuBar$PasteAction(ScriptingMenuBar scriptingMenuBar) {
        this.this$0 = scriptingMenuBar;
        super(Constants.MENU_EDIT_PASTE);
        this.putValue("AcceleratorKey", KeyStroke.getKeyStroke(86, ScriptingMenuBar.access$000()));
        this.putValue("SmallIcon", new ImageIcon(Constants.class.getResource("page_white_paste.png")));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.this$0.pasteMenuClicked();
    }
}

