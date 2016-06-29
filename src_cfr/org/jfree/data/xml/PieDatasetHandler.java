/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xml;

import java.util.Stack;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xml.DatasetTags;
import org.jfree.data.xml.ItemHandler;
import org.jfree.data.xml.RootHandler;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class PieDatasetHandler
extends RootHandler
implements DatasetTags {
    private DefaultPieDataset dataset = null;

    public PieDataset getDataset() {
        return this.dataset;
    }

    public void addItem(Comparable comparable, Number number) {
        this.dataset.setValue(comparable, number);
    }

    @Override
    public void startElement(String string, String string2, String string3, Attributes attributes) {
        DefaultHandler defaultHandler = this.getCurrentHandler();
        if (defaultHandler != this) {
            defaultHandler.startElement(string, string2, string3, attributes);
            return;
        }
        if (string3.equals("PieDataset")) {
            this.dataset = new DefaultPieDataset();
            return;
        }
        if (!string3.equals("Item")) return;
        ItemHandler itemHandler = new ItemHandler(this, this);
        this.getSubHandlers().push(itemHandler);
        itemHandler.startElement(string, string2, string3, attributes);
    }

    @Override
    public void endElement(String string, String string2, String string3) {
        DefaultHandler defaultHandler = this.getCurrentHandler();
        if (defaultHandler == this) return;
        defaultHandler.endElement(string, string2, string3);
    }
}

