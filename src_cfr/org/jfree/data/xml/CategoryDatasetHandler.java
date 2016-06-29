/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xml;

import java.util.Stack;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xml.CategorySeriesHandler;
import org.jfree.data.xml.DatasetTags;
import org.jfree.data.xml.RootHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CategoryDatasetHandler
extends RootHandler
implements DatasetTags {
    private DefaultCategoryDataset dataset = null;

    public CategoryDataset getDataset() {
        return this.dataset;
    }

    public void addItem(Comparable comparable, Comparable comparable2, Number number) {
        this.dataset.addValue(number, comparable, comparable2);
    }

    @Override
    public void startElement(String string, String string2, String string3, Attributes attributes) {
        DefaultHandler defaultHandler = this.getCurrentHandler();
        if (defaultHandler != this) {
            defaultHandler.startElement(string, string2, string3, attributes);
            return;
        }
        if (string3.equals("CategoryDataset")) {
            this.dataset = new DefaultCategoryDataset();
            return;
        }
        if (!string3.equals("Series")) throw new SAXException(new StringBuffer().append("Element not recognised: ").append(string3).toString());
        CategorySeriesHandler categorySeriesHandler = new CategorySeriesHandler(this);
        this.getSubHandlers().push(categorySeriesHandler);
        categorySeriesHandler.startElement(string, string2, string3, attributes);
    }

    @Override
    public void endElement(String string, String string2, String string3) {
        DefaultHandler defaultHandler = this.getCurrentHandler();
        if (defaultHandler == this) return;
        defaultHandler.endElement(string, string2, string3);
    }
}

