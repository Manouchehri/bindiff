package org.jfree.chart.labels;

import java.io.*;
import org.jfree.util.*;
import java.text.*;
import org.jfree.data.general.*;

public class StandardPieToolTipGenerator extends AbstractPieItemLabelGenerator implements Serializable, Cloneable, PieToolTipGenerator, PublicCloneable
{
    private static final long serialVersionUID = 2995304200445733779L;
    public static final String DEFAULT_TOOLTIP_FORMAT = "{0}: ({1}, {2})";
    public static final String DEFAULT_SECTION_LABEL_FORMAT = "{0} = {1}";
    
    public StandardPieToolTipGenerator() {
        this("{0} = {1}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance());
    }
    
    public StandardPieToolTipGenerator(final String s) {
        this(s, NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance());
    }
    
    public StandardPieToolTipGenerator(final String s, final NumberFormat numberFormat, final NumberFormat numberFormat2) {
        super(s, numberFormat, numberFormat2);
    }
    
    public String generateToolTip(final PieDataset pieDataset, final Comparable comparable) {
        return this.generateSectionLabel(pieDataset, comparable);
    }
    
    public Object clone() {
        return super.clone();
    }
}
