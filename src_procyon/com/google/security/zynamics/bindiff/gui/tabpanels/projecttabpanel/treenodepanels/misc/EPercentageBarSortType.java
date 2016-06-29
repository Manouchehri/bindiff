package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc;

public enum EPercentageBarSortType
{
    SORT_BY_TOTAL_SUM("SORT_BY_TOTAL_SUM", 0), 
    SORT_BY_LEFT_AND_CENTER_SUM("SORT_BY_LEFT_AND_CENTER_SUM", 1), 
    SORT_BY_RIGHT_AND_CENTER_SUM("SORT_BY_RIGHT_AND_CENTER_SUM", 2), 
    SORT_BY_LEFT_VALUE("SORT_BY_LEFT_VALUE", 3), 
    SORT_BY_CENTER_VALUE("SORT_BY_CENTER_VALUE", 4), 
    SORT_BY_RIGHT_VALUE("SORT_BY_RIGHT_VALUE", 5), 
    SORT_BY_INNERCENTER("SORT_BY_INNERCENTER", 6), 
    SORT_BY_INNERRIGHT("SORT_BY_INNERRIGHT", 7);
    
    private EPercentageBarSortType(final String s, final int n) {
    }
}
