/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xml;

import org.jfree.data.xml.CategorySeriesHandler;
import org.jfree.data.xml.DatasetTags;
import org.jfree.data.xml.KeyHandler;
import org.jfree.data.xml.PieDatasetHandler;
import org.jfree.data.xml.RootHandler;
import org.jfree.data.xml.ValueHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ItemHandler
extends DefaultHandler
implements DatasetTags {
    private RootHandler root;
    private DefaultHandler parent;
    private Comparable key;
    private Number value;

    public ItemHandler(RootHandler rootHandler, DefaultHandler defaultHandler) {
        this.root = rootHandler;
        this.parent = defaultHandler;
        this.key = null;
        this.value = null;
    }

    public Comparable getKey() {
        return this.key;
    }

    public void setKey(Comparable comparable) {
        this.key = comparable;
    }

    public Number getValue() {
        return this.value;
    }

    public void setValue(Number number) {
        this.value = number;
    }

    @Override
    public void startElement(String string, String string2, String string3, Attributes attributes) {
        if (string3.equals("Item")) {
            KeyHandler keyHandler = new KeyHandler(this.root, this);
            this.root.pushSubHandler(keyHandler);
            return;
        }
        if (!string3.equals("Value")) throw new SAXException(new StringBuffer().append("Expected <Item> or <Value>...found ").append(string3).toString());
        ValueHandler valueHandler = new ValueHandler(this.root, this);
        this.root.pushSubHandler(valueHandler);
    }

    @Override
    public void endElement(String string, String string2, String string3) {
        if (this.parent instanceof PieDatasetHandler) {
            PieDatasetHandler pieDatasetHandler = (PieDatasetHandler)this.parent;
            pieDatasetHandler.addItem(this.key, this.value);
            this.root.popSubHandler();
            return;
        }
        if (!(this.parent instanceof CategorySeriesHandler)) return;
        CategorySeriesHandler categorySeriesHandler = (CategorySeriesHandler)this.parent;
        categorySeriesHandler.addItem(this.key, this.value);
        this.root.popSubHandler();
    }
}

