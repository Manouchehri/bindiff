package org.jfree.chart.labels;

import java.io.*;
import java.text.*;
import org.jfree.data.category.*;

public class StandardCategoryToolTipGenerator extends AbstractCategoryItemLabelGenerator implements Serializable, CategoryToolTipGenerator
{
    private static final long serialVersionUID = -6768806592218710764L;
    public static final String DEFAULT_TOOL_TIP_FORMAT_STRING = "({0}, {1}) = {2}";
    
    public StandardCategoryToolTipGenerator() {
        super("({0}, {1}) = {2}", NumberFormat.getInstance());
    }
    
    public StandardCategoryToolTipGenerator(final String s, final NumberFormat numberFormat) {
        super(s, numberFormat);
    }
    
    public StandardCategoryToolTipGenerator(final String s, final DateFormat dateFormat) {
        super(s, dateFormat);
    }
    
    public String generateToolTip(final CategoryDataset categoryDataset, final int n, final int n2) {
        return this.generateLabelString(categoryDataset, n, n2);
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof StandardCategoryToolTipGenerator && super.equals(o));
    }
}
