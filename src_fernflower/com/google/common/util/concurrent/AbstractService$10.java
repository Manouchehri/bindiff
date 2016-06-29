package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service$State;

// $FF: synthetic class
class AbstractService$10 {
   // $FF: synthetic field
   static final int[] $SwitchMap$com$google$common$util$concurrent$Service$State = new int[Service$State.values().length];

   static {
      try {
         $SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.NEW.ordinal()] = 1;
      } catch (NoSuchFieldError var6) {
         ;
      }

      try {
         $SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.STARTING.ordinal()] = 2;
      } catch (NoSuchFieldError var5) {
         ;
      }

      try {
         $SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.RUNNING.ordinal()] = 3;
      } catch (NoSuchFieldError var4) {
         ;
      }

      try {
         $SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.STOPPING.ordinal()] = 4;
      } catch (NoSuchFieldError var3) {
         ;
      }

      try {
         $SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.TERMINATED.ordinal()] = 5;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         $SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.FAILED.ordinal()] = 6;
      } catch (NoSuchFieldError var1) {
         ;
      }

   }
}
