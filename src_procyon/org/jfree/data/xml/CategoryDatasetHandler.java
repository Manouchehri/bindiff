package org.jfree.data.xml;

import org.jfree.data.category.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class CategoryDatasetHandler extends RootHandler implements DatasetTags
{
    private DefaultCategoryDataset dataset;
    
    public CategoryDatasetHandler() {
        this.dataset = null;
    }
    
    public CategoryDataset getDataset() {
        return this.dataset;
    }
    
    public void addItem(final Comparable comparable, final Comparable comparable2, final Number n) {
        this.dataset.addValue(n, comparable, comparable2);
    }
    
    public void startElement(final String s, final String s2, final String s3, final Attributes attributes) {
        final DefaultHandler currentHandler = this.getCurrentHandler();
        if (currentHandler != this) {
            currentHandler.startElement(s, s2, s3, attributes);
        }
        else if (s3.equals("CategoryDataset")) {
            this.dataset = new DefaultCategoryDataset();
        }
        else {
            if (!s3.equals("Series")) {
                throw new SAXException("Element not recognised: " + s3);
            }
            final CategorySeriesHandler categorySeriesHandler = new CategorySeriesHandler(this);
            this.getSubHandlers().push(categorySeriesHandler);
            categorySeriesHandler.startElement(s, s2, s3, attributes);
        }
    }
    
    public void endElement(final String s, final String s2, final String s3) {
        final DefaultHandler currentHandler = this.getCurrentHandler();
        if (currentHandler != this) {
            currentHandler.endElement(s, s2, s3);
        }
    }
}
