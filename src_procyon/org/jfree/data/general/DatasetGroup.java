package org.jfree.data.general;

import java.io.*;

public class DatasetGroup implements Serializable, Cloneable
{
    private static final long serialVersionUID = -3640642179674185688L;
    private String id;
    
    public DatasetGroup() {
        this.id = "NOID";
    }
    
    public DatasetGroup(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Null 'id' argument.");
        }
        this.id = id;
    }
    
    public String getID() {
        return this.id;
    }
    
    public Object clone() {
        return super.clone();
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof DatasetGroup && this.id.equals(((DatasetGroup)o).id));
    }
}
