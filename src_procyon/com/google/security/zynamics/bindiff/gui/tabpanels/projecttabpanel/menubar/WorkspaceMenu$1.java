package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.utils.*;
import java.util.*;
import java.awt.*;
import java.io.*;
import com.google.security.zynamics.bindiff.config.*;

class WorkspaceMenu$1 extends AbstractAction
{
    final /* synthetic */ String val$workspace;
    final /* synthetic */ WorkspaceMenu this$0;
    
    WorkspaceMenu$1(final WorkspaceMenu this$0, final String val$workspace) {
        this.this$0 = this$0;
        this.val$workspace = val$workspace;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.controller.closeWorkspace();
        this.this$0.controller.loadWorkspace(this.val$workspace);
    }
}
