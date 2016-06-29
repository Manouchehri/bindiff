package y.h;

import java.beans.*;

public class bH extends PropertyChangeEvent
{
    private Object a;
    
    public bH(final bu bu, final Object a, final String s, final Object o, final Object o2) {
        super(bu, s, o, o2);
        this.a = a;
    }
    
    public String getPropertyName() {
        return super.getPropertyName();
    }
}
