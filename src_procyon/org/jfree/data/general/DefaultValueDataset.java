package org.jfree.data.general;

import java.io.*;
import org.jfree.util.*;

public class DefaultValueDataset extends AbstractDataset implements Serializable, Cloneable, ValueDataset, PublicCloneable
{
    private static final long serialVersionUID = 8137521217249294891L;
    private Number value;
    
    public DefaultValueDataset() {
        this(null);
    }
    
    public DefaultValueDataset(final double n) {
        this(new Double(n));
    }
    
    public DefaultValueDataset(final Number value) {
        this.value = value;
    }
    
    public Number getValue() {
        return this.value;
    }
    
    public void setValue(final Number value) {
        this.value = value;
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof ValueDataset && ObjectUtilities.equal(this.value, ((ValueDataset)o).getValue()));
    }
    
    public int hashCode() {
        return (this.value != null) ? this.value.hashCode() : 0;
    }
}
