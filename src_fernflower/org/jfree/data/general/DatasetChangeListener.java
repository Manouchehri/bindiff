package org.jfree.data.general;

import java.util.EventListener;
import org.jfree.data.general.DatasetChangeEvent;

public interface DatasetChangeListener extends EventListener {
   void datasetChanged(DatasetChangeEvent var1);
}
