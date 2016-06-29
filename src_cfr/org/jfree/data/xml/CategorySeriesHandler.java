/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xml;

import java.util.Iterator;
import java.util.List;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.xml.CategoryDatasetHandler;
import org.jfree.data.xml.DatasetTags;
import org.jfree.data.xml.ItemHandler;
import org.jfree.data.xml.RootHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CategorySeriesHandler
extends DefaultHandler
implements DatasetTags {
    private RootHandler root;
    private Comparable seriesKey;
    private DefaultKeyedValues values;

    public CategorySeriesHandler(RootHandler rootHandler) {
        this.root = rootHandler;
        this.values = new DefaultKeyedValues();
    }

    public void setSeriesKey(Comparable comparable) {
        this.seriesKey = comparable;
    }

    public void addItem(Comparable comparable, Number number) {
        this.values.addValue(comparable, number);
    }

    @Override
    public void startElement(String string, String string2, String string3, Attributes attributes) {
        if (string3.equals("Series")) {
            this.setSeriesKey((Comparable)((Object)attributes.getValue("name")));
            ItemHandler itemHandler = new ItemHandler(this.root, this);
            this.root.pushSubHandler(itemHandler);
            return;
        }
        if (!string3.equals("Item")) throw new SAXException(new StringBuffer().append("Expecting <Series> or <Item> tag...found ").append(string3).toString());
        ItemHandler itemHandler = new ItemHandler(this.root, this);
        this.root.pushSubHandler(itemHandler);
        itemHandler.startElement(string, string2, string3, attributes);
    }

    @Override
    public void endElement(String string, String string2, String string3) {
        if (!(this.root instanceof CategoryDatasetHandler)) return;
        CategoryDatasetHandler categoryDatasetHandler = (CategoryDatasetHandler)this.root;
        Iterator iterator = this.values.getKeys().iterator();
        do {
            if (!iterator.hasNext()) {
                this.root.popSubHandler();
                return;
            }
            Comparable comparable = (Comparable)iterator.next();
            Number number = this.values.getValue(comparable);
            categoryDatasetHandler.addItem(this.seriesKey, comparable, number);
        } while (true);
    }
}

