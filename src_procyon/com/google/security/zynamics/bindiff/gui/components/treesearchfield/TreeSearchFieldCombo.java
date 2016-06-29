package com.google.security.zynamics.bindiff.gui.components.treesearchfield;

import com.google.security.zynamics.zylib.gui.comboboxes.memorybox.*;
import com.google.security.zynamics.zylib.general.*;
import java.awt.event.*;
import javax.swing.*;

public class TreeSearchFieldCombo extends JMemoryBox
{
    private static int SEARCH_STRING_HISTORY_MAX;
    private final ListenerProvider listeners;
    private final TreeSearchFieldCombo$InternalKeyListener listener;
    private String lastSearchString;
    
    public TreeSearchFieldCombo() {
        super(TreeSearchFieldCombo.SEARCH_STRING_HISTORY_MAX);
        this.listeners = new ListenerProvider();
        this.listener = new TreeSearchFieldCombo$InternalKeyListener(this, null);
        this.lastSearchString = "";
        this.getEditor().getEditorComponent().addKeyListener(this.listener);
    }
    
    private String getText() {
        return ((JTextField)this.getEditor().getEditorComponent()).getText();
    }
    
    public void addListener(final ITreeSearchFieldListener treeSearchFieldListener) {
        this.listeners.addListener(treeSearchFieldListener);
    }
    
    public void clear() {
        this.setSelectedItem("");
        this.lastSearchString = "";
    }
    
    public void dispose() {
        this.getEditor().getEditorComponent().removeKeyListener(this.listener);
    }
    
    public void removeListener(final ITreeSearchFieldListener treeSearchFieldListener) {
        this.listeners.removeListener(treeSearchFieldListener);
    }
    
    static {
        TreeSearchFieldCombo.SEARCH_STRING_HISTORY_MAX = 25;
    }
}
