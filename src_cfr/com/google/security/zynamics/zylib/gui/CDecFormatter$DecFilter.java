/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CDecFormatter;
import com.google.security.zynamics.zylib.gui.CDecFormatter$1;
import javax.swing.text.AttributeSet;
import javax.swing.text.DocumentFilter;

class CDecFormatter$DecFilter
extends DocumentFilter {
    final /* synthetic */ CDecFormatter this$0;

    private CDecFormatter$DecFilter(CDecFormatter cDecFormatter) {
        this.this$0 = cDecFormatter;
    }

    @Override
    public void insertString(DocumentFilter.FilterBypass filterBypass, int n2, String string, AttributeSet attributeSet) {
        if (!CDecFormatter.access$100(this.this$0, string, 0)) return;
        super.insertString(filterBypass, n2, string, attributeSet);
    }

    @Override
    public void replace(DocumentFilter.FilterBypass filterBypass, int n2, int n3, String string, AttributeSet attributeSet) {
        if (!CDecFormatter.access$100(this.this$0, string, n3)) return;
        super.replace(filterBypass, n2, n3, string, attributeSet);
    }

    /* synthetic */ CDecFormatter$DecFilter(CDecFormatter cDecFormatter, CDecFormatter$1 cDecFormatter$1) {
        this(cDecFormatter);
    }
}

