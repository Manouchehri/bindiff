package org.jfree.chart.labels;

import java.io.*;
import org.jfree.util.*;
import org.jfree.data.xy.*;
import java.text.*;
import java.util.*;

public class MultipleXYSeriesLabelGenerator implements Serializable, Cloneable, XYSeriesLabelGenerator, PublicCloneable
{
    private static final long serialVersionUID = 138976236941898560L;
    public static final String DEFAULT_LABEL_FORMAT = "{0}";
    private String formatPattern;
    private String additionalFormatPattern;
    private Map seriesLabelLists;
    
    public MultipleXYSeriesLabelGenerator() {
        this("{0}");
    }
    
    public MultipleXYSeriesLabelGenerator(final String formatPattern) {
        if (formatPattern == null) {
            throw new IllegalArgumentException("Null 'format' argument.");
        }
        this.formatPattern = formatPattern;
        this.additionalFormatPattern = "\n{0}";
        this.seriesLabelLists = new HashMap();
    }
    
    public void addSeriesLabel(final int n, final String s) {
        final Integer n2 = new Integer(n);
        List<String> list = this.seriesLabelLists.get(n2);
        if (list == null) {
            list = new ArrayList<String>();
            this.seriesLabelLists.put(n2, list);
        }
        list.add(s);
    }
    
    public void clearSeriesLabels(final int n) {
        this.seriesLabelLists.put(new Integer(n), null);
    }
    
    public String generateLabel(final XYDataset xyDataset, final int n) {
        if (xyDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        final StringBuffer sb = new StringBuffer();
        sb.append(MessageFormat.format(this.formatPattern, this.createItemArray(xyDataset, n)));
        final List<Object> list = this.seriesLabelLists.get(new Integer(n));
        if (list != null) {
            final Object[] array = { null };
            for (int i = 0; i < list.size(); ++i) {
                array[0] = list.get(i);
                sb.append(MessageFormat.format(this.additionalFormatPattern, array));
            }
        }
        return sb.toString();
    }
    
    protected Object[] createItemArray(final XYDataset xyDataset, final int n) {
        return new Object[] { xyDataset.getSeriesKey(n).toString() };
    }
    
    public Object clone() {
        final MultipleXYSeriesLabelGenerator multipleXYSeriesLabelGenerator = (MultipleXYSeriesLabelGenerator)super.clone();
        multipleXYSeriesLabelGenerator.seriesLabelLists = new HashMap();
        for (final Object next : this.seriesLabelLists.keySet()) {
            Object o2;
            final Object o = o2 = this.seriesLabelLists.get(next);
            if (o instanceof PublicCloneable) {
                o2 = ((PublicCloneable)o).clone();
            }
            multipleXYSeriesLabelGenerator.seriesLabelLists.put(next, o2);
        }
        return multipleXYSeriesLabelGenerator;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MultipleXYSeriesLabelGenerator)) {
            return false;
        }
        final MultipleXYSeriesLabelGenerator multipleXYSeriesLabelGenerator = (MultipleXYSeriesLabelGenerator)o;
        return this.formatPattern.equals(multipleXYSeriesLabelGenerator.formatPattern) && this.additionalFormatPattern.equals(multipleXYSeriesLabelGenerator.additionalFormatPattern) && this.seriesLabelLists.equals(multipleXYSeriesLabelGenerator.seriesLabelLists);
    }
}
