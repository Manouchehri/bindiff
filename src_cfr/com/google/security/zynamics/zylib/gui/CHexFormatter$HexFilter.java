/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CHexFormatter;
import com.google.security.zynamics.zylib.gui.CHexFormatter$1;
import javax.swing.text.AttributeSet;
import javax.swing.text.DocumentFilter;

class CHexFormatter$HexFilter
extends DocumentFilter {
    final /* synthetic */ CHexFormatter this$0;

    private CHexFormatter$HexFilter(CHexFormatter cHexFormatter) {
        this.this$0 = cHexFormatter;
    }

    @Override
    public void insertString(DocumentFilter.FilterBypass filterBypass, int n2, String string, AttributeSet attributeSet) {
        if (!CHexFormatter.access$100(this.this$0, string, 0)) return;
        super.insertString(filterBypass, n2, string, attributeSet);
    }

    @Override
    public void replace(DocumentFilter.FilterBypass filterBypass, int n2, int n3, String string, AttributeSet attributeSet) {
        if (!CHexFormatter.access$100(this.this$0, string, n3)) return;
        super.replace(filterBypass, n2, n3, string, attributeSet);
    }

    /* synthetic */ CHexFormatter$HexFilter(CHexFormatter cHexFormatter, CHexFormatter$1 cHexFormatter$1) {
        this(cHexFormatter);
    }
}

