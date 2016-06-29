package com.google.security.zynamics.bindiff.project.diff;

import com.google.security.zynamics.bindiff.project.diff.Diff;

public interface IDiffListener {
   void closedView(Diff var1);

   void loadedDiff(Diff var1);

   void loadedView(Diff var1);

   void removedDiff(Diff var1);

   void unloadedDiff(Diff var1);

   void willOverwriteDiff(String var1);
}
