/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jfree.chart.labels.XYSeriesLabelGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

public class MultipleXYSeriesLabelGenerator
implements Serializable,
Cloneable,
XYSeriesLabelGenerator,
PublicCloneable {
    private static final long serialVersionUID = 138976236941898560L;
    public static final String DEFAULT_LABEL_FORMAT = "{0}";
    private String formatPattern;
    private String additionalFormatPattern;
    private Map seriesLabelLists;

    public MultipleXYSeriesLabelGenerator() {
        this("{0}");
    }

    public MultipleXYSeriesLabelGenerator(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'format' argument.");
        }
        this.formatPattern = string;
        this.additionalFormatPattern = "\n{0}";
        this.seriesLabelLists = new HashMap();
    }

    public void addSeriesLabel(int n2, String string) {
        Integer n3 = new Integer(n2);
        ArrayList<String> arrayList = (ArrayList<String>)this.seriesLabelLists.get(n3);
        if (arrayList == null) {
            arrayList = new ArrayList<String>();
            this.seriesLabelLists.put(n3, arrayList);
        }
        arrayList.add(string);
    }

    public void clearSeriesLabels(int n2) {
        Integer n3 = new Integer(n2);
        this.seriesLabelLists.put(n3, null);
    }

    @Override
    public String generateLabel(XYDataset xYDataset, int n2) {
        if (xYDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MessageFormat.format(this.formatPattern, this.createItemArray(xYDataset, n2)));
        Integer n3 = new Integer(n2);
        List list = (List)this.seriesLabelLists.get(n3);
        if (list == null) return stringBuffer.toString();
        Object[] arrobject = new Object[1];
        int n4 = 0;
        while (n4 < list.size()) {
            arrobject[0] = list.get(n4);
            String string = MessageFormat.format(this.additionalFormatPattern, arrobject);
            stringBuffer.append(string);
            ++n4;
        }
        return stringBuffer.toString();
    }

    protected Object[] createItemArray(XYDataset xYDataset, int n2) {
        Object[] arrobject = new Object[]{xYDataset.getSeriesKey(n2).toString()};
        return arrobject;
    }

    @Override
    public Object clone() {
        MultipleXYSeriesLabelGenerator multipleXYSeriesLabelGenerator = (MultipleXYSeriesLabelGenerator)super.clone();
        multipleXYSeriesLabelGenerator.seriesLabelLists = new HashMap();
        Set set = this.seriesLabelLists.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object v2;
            Object k2 = iterator.next();
            Object object = v2 = this.seriesLabelLists.get(k2);
            if (v2 instanceof PublicCloneable) {
                PublicCloneable publicCloneable = (PublicCloneable)v2;
                object = publicCloneable.clone();
            }
            multipleXYSeriesLabelGenerator.seriesLabelLists.put(k2, object);
        }
        return multipleXYSeriesLabelGenerator;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MultipleXYSeriesLabelGenerator)) {
            return false;
        }
        MultipleXYSeriesLabelGenerator multipleXYSeriesLabelGenerator = (MultipleXYSeriesLabelGenerator)object;
        if (!this.formatPattern.equals(multipleXYSeriesLabelGenerator.formatPattern)) {
            return false;
        }
        if (!this.additionalFormatPattern.equals(multipleXYSeriesLabelGenerator.additionalFormatPattern)) {
            return false;
        }
        if (this.seriesLabelLists.equals(multipleXYSeriesLabelGenerator.seriesLabelLists)) return true;
        return false;
    }
}

