/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import com.google.common.base.Preconditions;
import javax.swing.JCheckBox;

public class DiffPairTableData {
    private final JCheckBox selectionCheckbox = new JCheckBox();
    private final String idbName;
    private final String idbLocation;
    private String destinationDirectory;

    public DiffPairTableData(String string, String string2, String string3) {
        this.idbName = (String)Preconditions.checkNotNull(string);
        this.idbLocation = (String)Preconditions.checkNotNull(string2);
        this.destinationDirectory = (String)Preconditions.checkNotNull(string3);
        this.selectionCheckbox.setSelected(true);
    }

    public String getDestinationDirectory() {
        return this.destinationDirectory;
    }

    public String getIDBLocation() {
        return this.idbLocation;
    }

    public String getIDBName() {
        return this.idbName;
    }

    public JCheckBox getSelectionCheckBox() {
        return this.selectionCheckbox;
    }

    public void setDestinationDirectory(String string) {
        this.destinationDirectory = string;
    }
}

