/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CFilenameFormatter;
import com.google.security.zynamics.zylib.gui.CFilenameFormatter$1;
import javax.swing.text.AttributeSet;
import javax.swing.text.DocumentFilter;

class CFilenameFormatter$FilenameFilter
extends DocumentFilter {
    final /* synthetic */ CFilenameFormatter this$0;

    private CFilenameFormatter$FilenameFilter(CFilenameFormatter cFilenameFormatter) {
        this.this$0 = cFilenameFormatter;
    }

    @Override
    public void insertString(DocumentFilter.FilterBypass filterBypass, int n2, String string, AttributeSet attributeSet) {
        if (!CFilenameFormatter.access$100(this.this$0, string, 0)) return;
        super.insertString(filterBypass, n2, string, attributeSet);
    }

    @Override
    public void replace(DocumentFilter.FilterBypass filterBypass, int n2, int n3, String string, AttributeSet attributeSet) {
        if (!CFilenameFormatter.access$100(this.this$0, string, n3)) return;
        super.replace(filterBypass, n2, n3, string, attributeSet);
    }

    /* synthetic */ CFilenameFormatter$FilenameFilter(CFilenameFormatter cFilenameFormatter, CFilenameFormatter$1 cFilenameFormatter$1) {
        this(cFilenameFormatter);
    }
}

