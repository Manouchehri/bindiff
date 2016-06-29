package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;
import com.google.security.zynamics.bindiff.resources.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.database.*;
import com.google.security.zynamics.bindiff.log.*;
import java.sql.*;
import java.util.*;

final class DiffTreeNodeContextPanel$InternalTimerListener implements ActionListener
{
    final /* synthetic */ DiffTreeNodeContextPanel this$0;
    
    private DiffTreeNodeContextPanel$InternalTimerListener(final DiffTreeNodeContextPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.descriptionBorder.setTitleColor(Color.BLACK);
        this.this$0.descriptionBorder.setTitle("Description");
        this.this$0.updateUI();
        this.this$0.timer.stop();
    }
}
