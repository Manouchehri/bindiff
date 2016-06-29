/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpSessionBindingEvent
 *  javax.servlet.http.HttpSessionBindingListener
 */
package org.jfree.chart.servlet;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class ChartDeleter
implements Serializable,
HttpSessionBindingListener {
    private List chartNames = new ArrayList();

    public void addChart(String string) {
        this.chartNames.add(string);
    }

    public boolean isChartAvailable(String string) {
        return this.chartNames.contains(string);
    }

    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
    }

    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        ListIterator listIterator = this.chartNames.listIterator();
        while (listIterator.hasNext()) {
            String string = (String)listIterator.next();
            File file = new File(System.getProperty("java.io.tmpdir"), string);
            if (!file.exists()) continue;
            file.delete();
        }
    }
}

