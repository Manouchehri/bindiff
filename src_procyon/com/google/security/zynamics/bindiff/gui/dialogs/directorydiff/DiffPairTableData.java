package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import javax.swing.*;
import com.google.common.base.*;

public class DiffPairTableData
{
    private final JCheckBox selectionCheckbox;
    private final String idbName;
    private final String idbLocation;
    private String destinationDirectory;
    
    public DiffPairTableData(final String s, final String s2, final String s3) {
        this.selectionCheckbox = new JCheckBox();
        this.idbName = (String)Preconditions.checkNotNull(s);
        this.idbLocation = (String)Preconditions.checkNotNull(s2);
        this.destinationDirectory = (String)Preconditions.checkNotNull(s3);
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
    
    public void setDestinationDirectory(final String destinationDirectory) {
        this.destinationDirectory = destinationDirectory;
    }
}
