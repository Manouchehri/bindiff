package y.h;

import java.util.*;
import java.beans.*;

final class cP extends ArrayList implements PropertyChangeListener
{
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        final boolean z = fj.z;
        int i = 0;
        while (i < this.size()) {
            ((PropertyChangeListener)this.get(i)).propertyChange(propertyChangeEvent);
            ++i;
            if (z) {
                break;
            }
        }
    }
}
