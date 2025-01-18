package com.apique.PowerThrottling;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.*;
import com.sun.jna.platform.win32.WinNT;
/**
 * Kernel32 interface used to change process information
 * @see https://learn.microsoft.com/en-us/windows/win32/api/processthreadsapi/nf-processthreadsapi-setprocessinformation 
 * @see https://github.com/tpn/winsdk-10/blob/master/Include/10.0.10240.0/um/processthreadsapi.h
 */
public interface Kernel32 extends Library {
	/** The KERNEL32 instance */
    Kernel32 INSTANCE = Native.load("kernel32", Kernel32.class);

    int PROCESS_POWER_THROTTLING_CURRENT_VERSION = 1;
    /** @see https://learn.microsoft.com/en-us/windows/win32/api/processthreadsapi/ns-processthreadsapi-process_power_throttling_state */
    int PROCESS_POWER_THROTTLING_EXECUTION_SPEED = 0x1;
    /** ProcessPowerThrottling : @see https://learn.microsoft.com/en-us/windows/win32/api/processthreadsapi/ne-processthreadsapi-process_information_class */
    int POWERTHROTTLING = 4;

    /**
     * Structur for JNA call
     */
    class PROCESS_POWER_THROTTLING_STATE extends Structure {
        public int Version = PROCESS_POWER_THROTTLING_CURRENT_VERSION;
        public int ControlMask;
        public int StateMask;

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("Version", "ControlMask", "StateMask");
        }
    }

    /**
     * Sets the process information jna call
     * @see https://learn.microsoft.com/en-us/windows/win32/api/processthreadsapi/nf-processthreadsapi-setprocessinformation
     * @param hProcess
     * @param processInformationClass
     * @param processInformation
     * @param processInformationSize
     * @return
     */
    boolean SetProcessInformation(WinNT.HANDLE hProcess, int processInformationClass, Structure processInformation, int processInformationSize);

    /**
     * Get current process JNA call
     * @see https://learn.microsoft.com/fr-fr/windows/win32/api/processthreadsapi/nf-processthreadsapi-getcurrentprocess
     * @return the process handle
     */
    WinNT.HANDLE GetCurrentProcess();
}