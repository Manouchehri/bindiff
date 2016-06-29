package com.google.security.zynamics.zylib.gui.JStackView;

import com.google.security.zynamics.zylib.gui.JStackView.IStackModelListener;

public interface IStackModel {
   void addListener(IStackModelListener var1);

   String getElement(long var1);

   int getNumberOfEntries();

   long getStackPointer();

   long getStartAddress();

   boolean hasData(long var1, long var3);

   boolean keepTrying();
}
