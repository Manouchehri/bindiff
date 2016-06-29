/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.JCheckedListbox$1;
import com.google.security.zynamics.zylib.gui.JCheckedListbox$CheckedListboxRenderer;
import com.google.security.zynamics.zylib.gui.JCheckedListbox$InternalListener;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;

public class JCheckedListbox
extends JList {
    private final boolean[] m_selected;
    private boolean m_selectCompleteLine = true;

    public JCheckedListbox(ListModel listModel) {
        super(listModel);
        this.m_selected = new boolean[listModel.getSize()];
        this.setCellRenderer(new JCheckedListbox$CheckedListboxRenderer(this));
        this.addMouseListener(new JCheckedListbox$InternalListener(this, null));
    }

    public JCheckedListbox(Object[] arrobject) {
        super(arrobject);
        this.m_selected = new boolean[arrobject.length];
        this.setCellRenderer(new JCheckedListbox$CheckedListboxRenderer(this));
        this.addMouseListener(new JCheckedListbox$InternalListener(this, null));
    }

    public JCheckedListbox(Vector vector) {
        super(vector);
        this.m_selected = new boolean[vector.size()];
        this.setCellRenderer(new JCheckedListbox$CheckedListboxRenderer(this));
        this.addMouseListener(new JCheckedListbox$InternalListener(this, null));
    }

    public JCheckedListbox(Vector vector, boolean bl2) {
        super(vector);
        this.m_selectCompleteLine = bl2;
        this.m_selected = new boolean[vector.size()];
        this.setCellRenderer(new JCheckedListbox$CheckedListboxRenderer(this));
        this.addMouseListener(new JCheckedListbox$InternalListener(this, null));
    }

    public boolean isChecked(int n2) {
        return this.m_selected[n2];
    }

    public void setChecked(int n2, boolean bl2) {
        this.m_selected[n2] = bl2;
        this.updateUI();
        this.fireSelectionValueChanged(n2, n2, false);
    }

    @Override
    public void updateUI() {
        super.updateUI();
    }

    static /* synthetic */ boolean access$100(JCheckedListbox jCheckedListbox) {
        return jCheckedListbox.m_selectCompleteLine;
    }

    static /* synthetic */ boolean[] access$200(JCheckedListbox jCheckedListbox) {
        return jCheckedListbox.m_selected;
    }

    static /* synthetic */ void access$300(JCheckedListbox jCheckedListbox, int n2, int n3, boolean bl2) {
        jCheckedListbox.fireSelectionValueChanged(n2, n3, bl2);
    }
}

