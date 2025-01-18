package com.apique.PowerThrottling;
import com.sun.jna.platform.win32.WinNT;

/**
 * Utility class used to set the Power Throttle mode 
 */
public class PowerThrottling {
	/**
	 * Enable or disable thottle mode
	 * @param i_iValue if 0, disable (best performances), if 1, enable (eco mode)
	 */
	public static void setThrottle(int i_iValue) {
        Kernel32.PROCESS_POWER_THROTTLING_STATE throttlingState = new Kernel32.PROCESS_POWER_THROTTLING_STATE();
        throttlingState.ControlMask = Kernel32.PROCESS_POWER_THROTTLING_EXECUTION_SPEED;
        throttlingState.StateMask = i_iValue;

        WinNT.HANDLE currentProcess = Kernel32.INSTANCE.GetCurrentProcess();

        boolean success = Kernel32.INSTANCE.SetProcessInformation(
                currentProcess,
                Kernel32.POWERTHROTTLING, // ProcessPowerThrottling @see https://learn.microsoft.com/en-us/windows/win32/api/processthreadsapi/ne-processthreadsapi-process_information_class
                throttlingState,
                throttlingState.size()
        );

        if (success) {
            Activator.logInfo("Powerthrottling set to this value : " + i_iValue);
        } else {
            Activator.logError("Unable to set power throttling to this value : " + i_iValue, null);
        }
	}
}
