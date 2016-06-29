package com.google.security.zynamics.zylib.general.undo;

public interface IUndoable {
   String getDescription();

   String getSubCommandDescription(int var1);

   int getSubCommands();

   void revertToSnapshot();

   void undo();
}
