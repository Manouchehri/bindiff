package com.google.common.io;

import com.google.common.annotations.Beta;

@Beta
public interface LineProcessor {
   boolean processLine(String var1);

   Object getResult();
}
