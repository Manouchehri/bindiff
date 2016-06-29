package com.google.security.zynamics.bindiff.project.diff;

public interface ICountsChangeListener {
   void basicblocksCountChanged();

   void callsCountChanged();

   void functionsCountChanged();

   void instructionsCountsChanged();

   void jumpsCountChanged();
}
