package org.jfree.chart.editor;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.editor.ChartEditor;
import org.jfree.chart.editor.ChartEditorFactory;
import org.jfree.chart.editor.DefaultChartEditor;

public class DefaultChartEditorFactory implements ChartEditorFactory {
   public ChartEditor createEditor(JFreeChart var1) {
      return new DefaultChartEditor(var1);
   }
}
