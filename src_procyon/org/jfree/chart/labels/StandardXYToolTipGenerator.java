package org.jfree.chart.labels;

import java.io.*;
import org.jfree.util.*;
import java.text.*;
import org.jfree.data.xy.*;

public class StandardXYToolTipGenerator extends AbstractXYItemLabelGenerator implements Serializable, Cloneable, XYToolTipGenerator, PublicCloneable
{
    private static final long serialVersionUID = -3564164459039540784L;
    public static final String DEFAULT_TOOL_TIP_FORMAT = "{0}: ({1}, {2})";
    
    public static StandardXYToolTipGenerator getTimeSeriesInstance() {
        return new StandardXYToolTipGenerator("{0}: ({1}, {2})", DateFormat.getInstance(), NumberFormat.getInstance());
    }
    
    public StandardXYToolTipGenerator() {
        this("{0}: ({1}, {2})", NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance());
    }
    
    public StandardXYToolTipGenerator(final String s, final NumberFormat numberFormat, final NumberFormat numberFormat2) {
        super(s, numberFormat, numberFormat2);
    }
    
    public StandardXYToolTipGenerator(final String s, final DateFormat dateFormat, final NumberFormat numberFormat) {
        super(s, dateFormat, numberFormat);
    }
    
    public StandardXYToolTipGenerator(final String s, final NumberFormat numberFormat, final DateFormat dateFormat) {
        super(s, numberFormat, dateFormat);
    }
    
    public StandardXYToolTipGenerator(final String s, final DateFormat dateFormat, final DateFormat dateFormat2) {
        super(s, dateFormat, dateFormat2);
    }
    
    public String generateToolTip(final XYDataset xyDataset, final int n, final int n2) {
        return this.generateLabelString(xyDataset, n, n2);
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof StandardXYToolTipGenerator && super.equals(o));
    }
    
    public Object clone() {
        return super.clone();
    }
}
