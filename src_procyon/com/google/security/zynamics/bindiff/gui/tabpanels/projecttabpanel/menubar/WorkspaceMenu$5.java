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

class WorkspaceMenu$5 extends AbstractAction
{
    final /* synthetic */ WorkspaceMenu this$0;
    
    WorkspaceMenu$5(final WorkspaceMenu this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.controller.exitBinDiff();
    }
}
