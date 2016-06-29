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

final class DiffTreeNodeContextPanel$InternalKeyListener implements KeyListener
{
    private final int KEY_TYPED_SAVE_THRESHOLD = 50;
    private int typedCount;
    final /* synthetic */ DiffTreeNodeContextPanel this$0;
    
    private DiffTreeNodeContextPanel$InternalKeyListener(final DiffTreeNodeContextPanel this$0) {
        this.this$0 = this$0;
        this.typedCount = 0;
    }
    
    @Override
    public void keyPressed(final KeyEvent keyEvent) {
    }
    
    @Override
    public void keyReleased(final KeyEvent keyEvent) {
    }
    
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        ++this.typedCount;
        if (this.typedCount > 50) {
            this.this$0.saveDescription();
            this.typedCount = 0;
        }
    }
}
