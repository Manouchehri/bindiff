package com.google.security.zynamics.bindiff.gui.tabpanels;

import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.common.base.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.util.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.userview.*;

class TabPanelManager$InternalDiffListener extends DiffListenerAdapter
{
    final /* synthetic */ TabPanelManager this$0;
    
    private TabPanelManager$InternalDiffListener(final TabPanelManager this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void closedView(final Diff diff) {
        this.this$0.unregisterTabColor(diff);
    }
}
