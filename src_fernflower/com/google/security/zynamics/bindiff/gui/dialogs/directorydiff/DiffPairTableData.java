package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import com.google.common.base.Preconditions;
import javax.swing.JCheckBox;

public class DiffPairTableData {
   private final JCheckBox selectionCheckbox = new JCheckBox();
   private final String idbName;
   private final String idbLocation;
   private String destinationDirectory;

   public DiffPairTableData(String var1, String var2, String var3) {
      this.idbName = (String)Preconditions.checkNotNull(var1);
      this.idbLocation = (String)Preconditions.checkNotNull(var2);
      this.destinationDirectory = (String)Preconditions.checkNotNull(var3);
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

   public void setDestinationDirectory(String var1) {
      this.destinationDirectory = var1;
   }
}
