package org.jfree.data.xml;

import org.jfree.data.general.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class PieDatasetHandler extends RootHandler implements DatasetTags
{
    private DefaultPieDataset dataset;
    
    public PieDatasetHandler() {
        this.dataset = null;
    }
    
    public PieDataset getDataset() {
        return this.dataset;
    }
    
    public void addItem(final Comparable comparable, final Number n) {
        this.dataset.setValue(comparable, n);
    }
    
    public void startElement(final String s, final String s2, final String s3, final Attributes attributes) {
        final DefaultHandler currentHandler = this.getCurrentHandler();
        if (currentHandler != this) {
            currentHandler.startElement(s, s2, s3, attributes);
        }
        else if (s3.equals("PieDataset")) {
            this.dataset = new DefaultPieDataset();
        }
        else if (s3.equals("Item")) {
            final ItemHandler itemHandler = new ItemHandler(this, this);
            this.getSubHandlers().push(itemHandler);
            itemHandler.startElement(s, s2, s3, attributes);
        }
    }
    
    public void endElement(final String s, final String s2, final String s3) {
        final DefaultHandler currentHandler = this.getCurrentHandler();
        if (currentHandler != this) {
            currentHandler.endElement(s, s2, s3);
        }
    }
}
