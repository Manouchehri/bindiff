/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.editor;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.editor.ChartEditor;
import org.jfree.chart.editor.ChartEditorFactory;
import org.jfree.chart.editor.DefaultChartEditorFactory;

public class ChartEditorManager {
    static ChartEditorFactory factory = new DefaultChartEditorFactory();

    private ChartEditorManager() {
    }

    public static ChartEditorFactory getChartEditorFactory() {
        return factory;
    }

    public static void setChartEditorFactory(ChartEditorFactory chartEditorFactory) {
        if (chartEditorFactory == null) {
            throw new IllegalArgumentException("Null 'f' argument.");
        }
        factory = chartEditorFactory;
    }

    public static ChartEditor getChartEditor(JFreeChart jFreeChart) {
        return factory.createEditor(jFreeChart);
    }
}

