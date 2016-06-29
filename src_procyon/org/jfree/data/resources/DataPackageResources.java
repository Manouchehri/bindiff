package org.jfree.data.resources;

import java.util.*;

public class DataPackageResources extends ListResourceBundle
{
    private static final Object[][] CONTENTS;
    
    public Object[][] getContents() {
        return DataPackageResources.CONTENTS;
    }
    
    static {
        CONTENTS = new Object[][] { { "series.default-prefix", "Series" }, { "categories.default-prefix", "Category" } };
    }
}
