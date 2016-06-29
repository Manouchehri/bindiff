/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.editor;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.editor.ChartEditor;
import org.jfree.chart.editor.ChartEditorFactory;
import org.jfree.chart.editor.DefaultChartEditor;

public class DefaultChartEditorFactory
implements ChartEditorFactory {
    @Override
    public ChartEditor createEditor(JFreeChart jFreeChart) {
        return new DefaultChartEditor(jFreeChart);
    }
}

