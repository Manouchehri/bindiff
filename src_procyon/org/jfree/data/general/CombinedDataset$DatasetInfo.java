package org.jfree.data.general;

class CombinedDataset$DatasetInfo
{
    private SeriesDataset data;
    private int series;
    private final CombinedDataset this$0;
    
    CombinedDataset$DatasetInfo(final CombinedDataset this$0, final SeriesDataset data, final int series) {
        this.this$0 = this$0;
        this.data = data;
        this.series = series;
    }
    
    static int access$000(final CombinedDataset$DatasetInfo combinedDataset$DatasetInfo) {
        return combinedDataset$DatasetInfo.series;
    }
    
    static SeriesDataset access$100(final CombinedDataset$DatasetInfo combinedDataset$DatasetInfo) {
        return combinedDataset$DatasetInfo.data;
    }
}
