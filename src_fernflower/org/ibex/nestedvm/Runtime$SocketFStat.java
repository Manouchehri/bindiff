package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$FStat;

public class Runtime$SocketFStat extends Runtime$FStat {
   public int dev() {
      return -1;
   }

   public int type() {
      return '쀀';
   }

   public int inode() {
      return this.hashCode() & 32767;
   }
}
