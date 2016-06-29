package org.jfree.chart.labels;

import org.jfree.data.category.CategoryDataset;

public interface CategoryItemLabelGenerator {
   String generateRowLabel(CategoryDataset var1, int var2);

   String generateColumnLabel(CategoryDataset var1, int var2);

   String generateLabel(CategoryDataset var1, int var2, int var3);
}
