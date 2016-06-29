/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.general;

import java.util.EventObject;
import org.jfree.data.general.Dataset;

public class DatasetChangeEvent
extends EventObject {
    private Dataset dataset;

    public DatasetChangeEvent(Object object, Dataset dataset) {
        super(object);
        this.dataset = dataset;
    }

    public Dataset getDataset() {
        return this.dataset;
    }
}

