package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.JHexPanel.IDataChangedListener;

public interface IDataProvider {
   void addListener(IDataChangedListener var1);

   byte[] getData();

   byte[] getData(long var1, int var3);

   int getDataLength();

   boolean hasData(long var1, int var3);

   boolean isEditable();

   boolean keepTrying();

   void removeListener(IDataChangedListener var1);

   void setData(long var1, byte[] var3);
}
