package y.h;

import java.beans.*;

class fR implements PropertyChangeListener
{
    private final fQ a;
    
    fR(final fQ a) {
        this.a = a;
    }
    
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        final int intValue = ((Number)propertyChangeEvent.getNewValue()).intValue();
        fQ.access$000(this.a).setSelectedItem(String.valueOf(intValue / 10) + "." + String.valueOf(intValue % 10) + "%");
    }
}
