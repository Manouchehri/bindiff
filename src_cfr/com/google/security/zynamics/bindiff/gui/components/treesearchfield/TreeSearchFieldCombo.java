/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.treesearchfield;

import com.google.security.zynamics.bindiff.gui.components.treesearchfield.ITreeSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.components.treesearchfield.TreeSearchFieldCombo$1;
import com.google.security.zynamics.bindiff.gui.components.treesearchfield.TreeSearchFieldCombo$InternalKeyListener;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.comboboxes.memorybox.JMemoryBox;
import java.awt.Component;
import java.awt.event.KeyListener;
import javax.swing.ComboBoxEditor;
import javax.swing.JTextField;

public class TreeSearchFieldCombo
extends JMemoryBox {
    private static int SEARCH_STRING_HISTORY_MAX = 25;
    private final ListenerProvider listeners = new ListenerProvider();
    private final TreeSearchFieldCombo$InternalKeyListener listener;
    private String lastSearchString;

    public TreeSearchFieldCombo() {
        super(SEARCH_STRING_HISTORY_MAX);
        this.listener = new TreeSearchFieldCombo$InternalKeyListener(this, null);
        this.lastSearchString = "";
        this.getEditor().getEditorComponent().addKeyListener(this.listener);
    }

    private String getText() {
        return ((JTextField)this.getEditor().getEditorComponent()).getText();
    }

    public void addListener(ITreeSearchFieldListener iTreeSearchFieldListener) {
        this.listeners.addListener(iTreeSearchFieldListener);
    }

    public void clear() {
        this.setSelectedItem("");
        this.lastSearchString = "";
    }

    public void dispose() {
        this.getEditor().getEditorComponent().removeKeyListener(this.listener);
    }

    public void removeListener(ITreeSearchFieldListener iTreeSearchFieldListener) {
        this.listeners.removeListener(iTreeSearchFieldListener);
    }

    static /* synthetic */ String access$100(TreeSearchFieldCombo treeSearchFieldCombo) {
        return treeSearchFieldCombo.lastSearchString;
    }

    static /* synthetic */ String access$200(TreeSearchFieldCombo treeSearchFieldCombo) {
        return treeSearchFieldCombo.getText();
    }

    static /* synthetic */ ListenerProvider access$300(TreeSearchFieldCombo treeSearchFieldCombo) {
        return treeSearchFieldCombo.listeners;
    }

    static /* synthetic */ String access$102(TreeSearchFieldCombo treeSearchFieldCombo, String string) {
        treeSearchFieldCombo.lastSearchString = string;
        return treeSearchFieldCombo.lastSearchString;
    }
}

