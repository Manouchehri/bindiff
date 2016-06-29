/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.general;

import java.io.Serializable;

public class DatasetGroup
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -3640642179674185688L;
    private String id;

    public DatasetGroup() {
        this.id = "NOID";
    }

    public DatasetGroup(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'id' argument.");
        }
        this.id = string;
    }

    public String getID() {
        return this.id;
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof DatasetGroup)) {
            return false;
        }
        DatasetGroup datasetGroup = (DatasetGroup)object;
        if (this.id.equals(datasetGroup.id)) return true;
        return false;
    }
}

