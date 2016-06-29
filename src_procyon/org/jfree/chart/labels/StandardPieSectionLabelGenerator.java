package org.jfree.chart.labels;

import java.io.*;
import org.jfree.util.*;
import java.text.*;
import org.jfree.data.general.*;

public class StandardPieSectionLabelGenerator extends AbstractPieItemLabelGenerator implements Serializable, Cloneable, PieSectionLabelGenerator
{
    private static final long serialVersionUID = 3064190563760203668L;
    public static final String DEFAULT_SECTION_LABEL_FORMAT = "{0}";
    private ObjectList attributedLabels;
    
    public StandardPieSectionLabelGenerator() {
        this("{0}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance());
    }
    
    public StandardPieSectionLabelGenerator(final String s) {
        this(s, NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance());
    }
    
    public StandardPieSectionLabelGenerator(final String s, final NumberFormat numberFormat, final NumberFormat numberFormat2) {
        super(s, numberFormat, numberFormat2);
        this.attributedLabels = new ObjectList();
    }
    
    public AttributedString getAttributedLabel(final int n) {
        return (AttributedString)this.attributedLabels.get(n);
    }
    
    public void setAttributedLabel(final int n, final AttributedString attributedString) {
        this.attributedLabels.set(n, attributedString);
    }
    
    public String generateSectionLabel(final PieDataset pieDataset, final Comparable comparable) {
        return super.generateSectionLabel(pieDataset, comparable);
    }
    
    public AttributedString generateAttributedSectionLabel(final PieDataset pieDataset, final Comparable comparable) {
        return this.getAttributedLabel(pieDataset.getIndex(comparable));
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof StandardPieSectionLabelGenerator && this.attributedLabels.equals(((StandardPieSectionLabelGenerator)o).attributedLabels) && super.equals(o));
    }
    
    public Object clone() {
        return super.clone();
    }
}
