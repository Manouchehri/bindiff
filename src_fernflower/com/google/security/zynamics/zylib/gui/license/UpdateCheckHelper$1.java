package com.google.security.zynamics.zylib.gui.license;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import com.google.security.zynamics.zylib.io.StreamUtils;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;
import java.util.List;

final class UpdateCheckHelper$1 extends CEndlessHelperThread {
   // $FF: synthetic field
   final List val$lines;
   // $FF: synthetic field
   final URL val$checkUrl;

   UpdateCheckHelper$1(List var1, URL var2) {
      this.val$lines = var1;
      this.val$checkUrl = var2;
   }

   protected void runExpensiveCommand() {
      long var1 = (new Date()).getTime();
      this.val$lines.addAll(StreamUtils.readLinesFromReader(new InputStreamReader(this.val$checkUrl.openStream())));
      long var3 = (new Date()).getTime() - var1;
      if(var3 < 400L) {
         Thread.sleep(400L - var3);
      }

   }
}
