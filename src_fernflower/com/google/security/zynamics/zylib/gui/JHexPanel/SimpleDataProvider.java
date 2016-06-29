package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.JHexPanel.IDataChangedListener;
import com.google.security.zynamics.zylib.gui.JHexPanel.IDataProvider;
import java.util.Arrays;

public class SimpleDataProvider implements IDataProvider {
   private final byte[] m_data;

   public SimpleDataProvider(byte[] var1) {
      this.m_data = var1;
   }

   public void addListener(IDataChangedListener var1) {
   }

   public byte[] getData() {
      return this.getData(0L, this.getDataLength());
   }

   public byte[] getData(long var1, int var3) {
      return Arrays.copyOfRange(this.m_data, (int)var1, (int)(var1 + (long)var3));
   }

   public int getDataLength() {
      return this.m_data.length;
   }

   public long getOffset() {
      return 0L;
   }

   public boolean hasData(long var1, int var3) {
      return true;
   }

   public boolean isEditable() {
      return true;
   }

   public boolean keepTrying() {
      return true;
   }

   public void removeListener(IDataChangedListener var1) {
   }

   public void setData(long var1, byte[] var3) {
      System.arraycopy(var3, 0, this.m_data, (int)var1, var3.length);
   }
}
