package com.google.security.zynamics.zylib.gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class JCheckedListbox extends JList
{
    private final boolean[] m_selected;
    private boolean m_selectCompleteLine;
    
    public JCheckedListbox(final ListModel listModel) {
        super(listModel);
        this.m_selectCompleteLine = true;
        this.m_selected = new boolean[listModel.getSize()];
        this.setCellRenderer(new JCheckedListbox$CheckedListboxRenderer(this));
        this.addMouseListener(new JCheckedListbox$InternalListener(this, null));
    }
    
    public JCheckedListbox(final Object[] array) {
        super(array);
        this.m_selectCompleteLine = true;
        this.m_selected = new boolean[array.length];
        this.setCellRenderer(new JCheckedListbox$CheckedListboxRenderer(this));
        this.addMouseListener(new JCheckedListbox$InternalListener(this, null));
    }
    
    public JCheckedListbox(final Vector vector) {
        super(vector);
        this.m_selectCompleteLine = true;
        this.m_selected = new boolean[vector.size()];
        this.setCellRenderer(new JCheckedListbox$CheckedListboxRenderer(this));
        this.addMouseListener(new JCheckedListbox$InternalListener(this, null));
    }
    
    public JCheckedListbox(final Vector vector, final boolean selectCompleteLine) {
        super(vector);
        this.m_selectCompleteLine = true;
        this.m_selectCompleteLine = selectCompleteLine;
        this.m_selected = new boolean[vector.size()];
        this.setCellRenderer(new JCheckedListbox$CheckedListboxRenderer(this));
        this.addMouseListener(new JCheckedListbox$InternalListener(this, null));
    }
    
    public boolean isChecked(final int n) {
        return this.m_selected[n];
    }
    
    public void setChecked(final int n, final boolean b) {
        this.m_selected[n] = b;
        this.updateUI();
        this.fireSelectionValueChanged(n, n, false);
    }
    
    @Override
    public void updateUI() {
        super.updateUI();
    }
}
