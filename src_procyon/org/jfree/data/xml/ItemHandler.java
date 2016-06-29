package org.jfree.data.xml;

import org.xml.sax.helpers.*;
import org.xml.sax.*;

public class ItemHandler extends DefaultHandler implements DatasetTags
{
    private RootHandler root;
    private DefaultHandler parent;
    private Comparable key;
    private Number value;
    
    public ItemHandler(final RootHandler root, final DefaultHandler parent) {
        this.root = root;
        this.parent = parent;
        this.key = null;
        this.value = null;
    }
    
    public Comparable getKey() {
        return this.key;
    }
    
    public void setKey(final Comparable key) {
        this.key = key;
    }
    
    public Number getValue() {
        return this.value;
    }
    
    public void setValue(final Number value) {
        this.value = value;
    }
    
    public void startElement(final String s, final String s2, final String s3, final Attributes attributes) {
        if (s3.equals("Item")) {
            this.root.pushSubHandler(new KeyHandler(this.root, this));
        }
        else {
            if (!s3.equals("Value")) {
                throw new SAXException("Expected <Item> or <Value>...found " + s3);
            }
            this.root.pushSubHandler(new ValueHandler(this.root, this));
        }
    }
    
    public void endElement(final String s, final String s2, final String s3) {
        if (this.parent instanceof PieDatasetHandler) {
            ((PieDatasetHandler)this.parent).addItem(this.key, this.value);
            this.root.popSubHandler();
        }
        else if (this.parent instanceof CategorySeriesHandler) {
            ((CategorySeriesHandler)this.parent).addItem(this.key, this.value);
            this.root.popSubHandler();
        }
    }
}
