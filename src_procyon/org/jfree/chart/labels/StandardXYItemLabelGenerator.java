package org.jfree.chart.labels;

import java.io.*;
import org.jfree.util.*;
import java.text.*;
import org.jfree.data.xy.*;

public class StandardXYItemLabelGenerator extends AbstractXYItemLabelGenerator implements Serializable, Cloneable, XYItemLabelGenerator, PublicCloneable
{
    private static final long serialVersionUID = 7807668053171837925L;
    public static final String DEFAULT_ITEM_LABEL_FORMAT = "{2}";
    
    public StandardXYItemLabelGenerator() {
        this("{2}", NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance());
    }
    
    public StandardXYItemLabelGenerator(final String s, final NumberFormat numberFormat, final NumberFormat numberFormat2) {
        super(s, numberFormat, numberFormat2);
    }
    
    public StandardXYItemLabelGenerator(final String s, final DateFormat dateFormat, final NumberFormat numberFormat) {
        super(s, dateFormat, numberFormat);
    }
    
    public StandardXYItemLabelGenerator(final String s, final NumberFormat numberFormat, final DateFormat dateFormat) {
        super(s, numberFormat, dateFormat);
    }
    
    public StandardXYItemLabelGenerator(final String s, final DateFormat dateFormat, final DateFormat dateFormat2) {
        super(s, dateFormat, dateFormat2);
    }
    
    public String generateLabel(final XYDataset xyDataset, final int n, final int n2) {
        return this.generateLabelString(xyDataset, n, n2);
    }
    
    public Object clone() {
        return super.clone();
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof StandardXYItemLabelGenerator && super.equals(o));
    }
}
