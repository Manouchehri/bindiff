package org.jfree.data.general;

import java.util.EventListener;
import org.jfree.data.general.SeriesChangeEvent;

public interface SeriesChangeListener extends EventListener {
   void seriesChanged(SeriesChangeEvent var1);
}
