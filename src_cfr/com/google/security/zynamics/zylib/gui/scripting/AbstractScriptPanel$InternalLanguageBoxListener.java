/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.gui.scripting.AbstractScriptPanel;
import com.google.security.zynamics.zylib.gui.scripting.AbstractScriptPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AbstractScriptPanel$InternalLanguageBoxListener
implements ActionListener {
    final /* synthetic */ AbstractScriptPanel this$0;

    private AbstractScriptPanel$InternalLanguageBoxListener(AbstractScriptPanel abstractScriptPanel) {
        this.this$0 = abstractScriptPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.this$0.initConsole();
        this.this$0.updateDocument();
    }

    /* synthetic */ AbstractScriptPanel$InternalLanguageBoxListener(AbstractScriptPanel abstractScriptPanel, AbstractScriptPanel$1 abstractScriptPanel$1) {
        this(abstractScriptPanel);
    }
}

