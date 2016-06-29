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

class DiffTreeNodeContextPanel$InternalDescriptionFocusListener implements FocusListener
{
    final /* synthetic */ DiffTreeNodeContextPanel this$0;
    
    private DiffTreeNodeContextPanel$InternalDescriptionFocusListener(final DiffTreeNodeContextPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void focusGained(final FocusEvent focusEvent) {
    }
    
    @Override
    public void focusLost(final FocusEvent focusEvent) {
        this.this$0.saveDescription();
    }
}
