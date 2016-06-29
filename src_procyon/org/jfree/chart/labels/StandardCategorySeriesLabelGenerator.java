package org.jfree.chart.labels;

import java.io.*;
import org.jfree.util.*;
import org.jfree.data.category.*;
import java.text.*;

public class StandardCategorySeriesLabelGenerator implements Serializable, Cloneable, CategorySeriesLabelGenerator, PublicCloneable
{
    private static final long serialVersionUID = 4630760091523940820L;
    public static final String DEFAULT_LABEL_FORMAT = "{0}";
    private String formatPattern;
    
    public StandardCategorySeriesLabelGenerator() {
        this("{0}");
    }
    
    public StandardCategorySeriesLabelGenerator(final String formatPattern) {
        if (formatPattern == null) {
            throw new IllegalArgumentException("Null 'format' argument.");
        }
        this.formatPattern = formatPattern;
    }
    
    public String generateLabel(final CategoryDataset categoryDataset, final int n) {
        if (categoryDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        return MessageFormat.format(this.formatPattern, this.createItemArray(categoryDataset, n));
    }
    
    protected Object[] createItemArray(final CategoryDataset categoryDataset, final int n) {
        return new Object[] { categoryDataset.getRowKey(n).toString() };
    }
    
    public Object clone() {
        return super.clone();
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof StandardCategorySeriesLabelGenerator && this.formatPattern.equals(((StandardCategorySeriesLabelGenerator)o).formatPattern));
    }
}
