package org.jfree.chart.servlet;

import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ChartDeleter implements Serializable, HttpSessionBindingListener
{
    private List chartNames;
    
    public ChartDeleter() {
        this.chartNames = new ArrayList();
    }
    
    public void addChart(final String s) {
        this.chartNames.add(s);
    }
    
    public boolean isChartAvailable(final String s) {
        return this.chartNames.contains(s);
    }
    
    public void valueBound(final HttpSessionBindingEvent httpSessionBindingEvent) {
    }
    
    public void valueUnbound(final HttpSessionBindingEvent httpSessionBindingEvent) {
        final ListIterator<String> listIterator = (ListIterator<String>)this.chartNames.listIterator();
        while (listIterator.hasNext()) {
            final File file = new File(System.getProperty("java.io.tmpdir"), listIterator.next());
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
