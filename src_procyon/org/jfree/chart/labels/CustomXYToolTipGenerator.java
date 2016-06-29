package org.jfree.chart.labels;

import java.io.*;
import org.jfree.util.*;
import org.jfree.data.xy.*;
import java.util.*;

public class CustomXYToolTipGenerator implements Serializable, Cloneable, XYToolTipGenerator, PublicCloneable
{
    private static final long serialVersionUID = 8636030004670141362L;
    private List toolTipSeries;
    
    public CustomXYToolTipGenerator() {
        this.toolTipSeries = new ArrayList();
    }
    
    public int getListCount() {
        return this.toolTipSeries.size();
    }
    
    public int getToolTipCount(final int n) {
        int size = 0;
        final List list = this.toolTipSeries.get(n);
        if (list != null) {
            size = list.size();
        }
        return size;
    }
    
    public String getToolTipText(final int n, final int n2) {
        String s = null;
        if (n < this.getListCount()) {
            final List<String> list = this.toolTipSeries.get(n);
            if (list != null && n2 < list.size()) {
                s = list.get(n2);
            }
        }
        return s;
    }
    
    public void addToolTipSeries(final List list) {
        this.toolTipSeries.add(list);
    }
    
    public String generateToolTip(final XYDataset xyDataset, final int n, final int n2) {
        return this.getToolTipText(n, n2);
    }
    
    public Object clone() {
        final CustomXYToolTipGenerator customXYToolTipGenerator = (CustomXYToolTipGenerator)super.clone();
        if (this.toolTipSeries != null) {
            customXYToolTipGenerator.toolTipSeries = new ArrayList(this.toolTipSeries);
        }
        return customXYToolTipGenerator;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof CustomXYToolTipGenerator) {
            final CustomXYToolTipGenerator customXYToolTipGenerator = (CustomXYToolTipGenerator)o;
            boolean b = true;
            for (int i = 0; i < this.getListCount(); ++i) {
                for (int j = 0; j < this.getToolTipCount(i); ++j) {
                    final String toolTipText = this.getToolTipText(i, j);
                    final String toolTipText2 = customXYToolTipGenerator.getToolTipText(i, j);
                    if (toolTipText != null) {
                        b = (b && toolTipText.equals(toolTipText2));
                    }
                    else {
                        b = (b && toolTipText2 == null);
                    }
                }
            }
            return b;
        }
        return false;
    }
}
