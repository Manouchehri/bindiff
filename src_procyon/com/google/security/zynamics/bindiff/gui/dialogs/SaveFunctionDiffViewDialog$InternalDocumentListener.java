package com.google.security.zynamics.bindiff.gui.dialogs;

import javax.swing.event.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.io.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.system.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.io.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.gui.components.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.utils.*;
import java.util.*;
import com.google.security.zynamics.zylib.gui.*;

class SaveFunctionDiffViewDialog$InternalDocumentListener implements DocumentListener
{
    final /* synthetic */ SaveFunctionDiffViewDialog this$0;
    
    private SaveFunctionDiffViewDialog$InternalDocumentListener(final SaveFunctionDiffViewDialog this$0) {
        this.this$0 = this$0;
    }
    
    private void update() {
        try {
            this.this$0.updateOnExistanceChanged();
        }
        catch (IOException ex) {}
    }
    
    @Override
    public void changedUpdate(final DocumentEvent documentEvent) {
        this.update();
    }
    
    @Override
    public void insertUpdate(final DocumentEvent documentEvent) {
        this.update();
    }
    
    @Override
    public void removeUpdate(final DocumentEvent documentEvent) {
        this.update();
    }
}
