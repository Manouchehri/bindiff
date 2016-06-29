package org.jfree.chart.labels;

import java.io.*;
import org.jfree.util.*;
import java.text.*;
import org.jfree.data.category.*;

public class StandardCategoryItemLabelGenerator extends AbstractCategoryItemLabelGenerator implements Serializable, Cloneable, CategoryItemLabelGenerator, PublicCloneable
{
    private static final long serialVersionUID = 3499701401211412882L;
    public static final String DEFAULT_LABEL_FORMAT_STRING = "{2}";
    
    public StandardCategoryItemLabelGenerator() {
        super("{2}", NumberFormat.getInstance());
    }
    
    public StandardCategoryItemLabelGenerator(final String s, final NumberFormat numberFormat) {
        super(s, numberFormat);
    }
    
    public StandardCategoryItemLabelGenerator(final String s, final NumberFormat numberFormat, final NumberFormat numberFormat2) {
        super(s, numberFormat, numberFormat2);
    }
    
    public StandardCategoryItemLabelGenerator(final String s, final DateFormat dateFormat) {
        super(s, dateFormat);
    }
    
    public String generateLabel(final CategoryDataset categoryDataset, final int n, final int n2) {
        return this.generateLabelString(categoryDataset, n, n2);
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof StandardCategoryItemLabelGenerator && super.equals(o));
    }
}
