package org.jfree.data.xml;

import org.xml.sax.helpers.*;
import org.jfree.data.*;
import org.xml.sax.*;
import java.util.*;

public class CategorySeriesHandler extends DefaultHandler implements DatasetTags
{
    private RootHandler root;
    private Comparable seriesKey;
    private DefaultKeyedValues values;
    
    public CategorySeriesHandler(final RootHandler root) {
        this.root = root;
        this.values = new DefaultKeyedValues();
    }
    
    public void setSeriesKey(final Comparable seriesKey) {
        this.seriesKey = seriesKey;
    }
    
    public void addItem(final Comparable comparable, final Number n) {
        this.values.addValue(comparable, n);
    }
    
    public void startElement(final String s, final String s2, final String s3, final Attributes attributes) {
        if (s3.equals("Series")) {
            this.setSeriesKey(attributes.getValue("name"));
            this.root.pushSubHandler(new ItemHandler(this.root, this));
        }
        else {
            if (!s3.equals("Item")) {
                throw new SAXException("Expecting <Series> or <Item> tag...found " + s3);
            }
            final ItemHandler itemHandler = new ItemHandler(this.root, this);
            this.root.pushSubHandler(itemHandler);
            itemHandler.startElement(s, s2, s3, attributes);
        }
    }
    
    public void endElement(final String s, final String s2, final String s3) {
        if (this.root instanceof CategoryDatasetHandler) {
            final CategoryDatasetHandler categoryDatasetHandler = (CategoryDatasetHandler)this.root;
            for (final Comparable comparable : this.values.getKeys()) {
                categoryDatasetHandler.addItem(this.seriesKey, comparable, this.values.getValue(comparable));
            }
            this.root.popSubHandler();
        }
    }
}
