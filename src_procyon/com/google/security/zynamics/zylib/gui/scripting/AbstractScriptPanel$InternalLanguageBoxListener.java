package com.google.security.zynamics.zylib.gui.scripting;

import java.awt.event.*;

class AbstractScriptPanel$InternalLanguageBoxListener implements ActionListener
{
    final /* synthetic */ AbstractScriptPanel this$0;
    
    private AbstractScriptPanel$InternalLanguageBoxListener(final AbstractScriptPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.initConsole();
        this.this$0.updateDocument();
    }
}
