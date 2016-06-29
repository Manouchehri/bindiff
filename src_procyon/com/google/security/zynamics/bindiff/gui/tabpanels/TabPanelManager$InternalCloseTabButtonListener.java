package com.google.security.zynamics.bindiff.gui.tabpanels;

import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.common.base.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.util.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.enums.*;

class TabPanelManager$InternalCloseTabButtonListener implements ICloseTabButtonListener
{
    final /* synthetic */ TabPanelManager this$0;
    
    private TabPanelManager$InternalCloseTabButtonListener(final TabPanelManager this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public boolean closing(final TabButtonComponent tabButtonComponent) {
        final ViewTabPanel viewTabPanel = (ViewTabPanel)tabButtonComponent.getTabPanel();
        final ViewData view = viewTabPanel.getView();
        if (viewTabPanel.getController().hasChanged()) {
            viewTabPanel.getTabPanelManager().selectTab(viewTabPanel);
            final int showYesNoCancelQuestion = CMessageBox.showYesNoCancelQuestion(this.this$0.window, String.format("'%s' has been modified. Save?", view.getViewName()));
            if (showYesNoCancelQuestion == 2) {
                return false;
            }
            viewTabPanel.getController().closeView(showYesNoCancelQuestion == 0);
        }
        else {
            viewTabPanel.getController().closeView(false);
        }
        return true;
    }
}
