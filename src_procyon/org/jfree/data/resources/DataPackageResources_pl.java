package org.jfree.data.resources;

import java.util.*;

public class DataPackageResources_pl extends ListResourceBundle
{
    private static final Object[][] CONTENTS;
    
    public Object[][] getContents() {
        return DataPackageResources_pl.CONTENTS;
    }
    
    static {
        CONTENTS = new Object[][] { { "series.default-prefix", "Serie" }, { "categories.default-prefix", "Kategorie" } };
    }
}
