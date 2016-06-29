package org.jfree.data.general;

import java.util.*;

public class DatasetChangeEvent extends EventObject
{
    private Dataset dataset;
    
    public DatasetChangeEvent(final Object o, final Dataset dataset) {
        super(o);
        this.dataset = dataset;
    }
    
    public Dataset getDataset() {
        return this.dataset;
    }
}
