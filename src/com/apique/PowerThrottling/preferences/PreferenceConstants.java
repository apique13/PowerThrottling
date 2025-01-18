package com.apique.PowerThrottling.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceConstants {

	/** Power throttle property */
	public static final String POWER_THROTTLE = "PowerThrottle";
	/** Performance mode */
	public static final String PERFMODE = "perf";
	/** Eco mode */
	public static final String ECOMODE = "eco";
	
	/**
	 * Enum used to declare all modes and default mode
	 */
	public enum PerfMode {
		/** Performance mode, disable throttling */
		PERF(PERFMODE, 0),
		/** Eco mode, enable throttling */
		ECO(ECOMODE, 1);
		/** Mode name */
		private String _sCode;
		/** Throttle flag */
		private int _iFlag;

		/**
		 * Constructor
		 * @param i_sCode mode name
		 * @param i_iFlag throttle flag
		 */
		PerfMode(String i_sCode, int i_iFlag) {
			_sCode = i_sCode;
			_iFlag = i_iFlag;
		}
		
		/**
		 * Gets the perf mode from its code
		 * @param i_sCode code of the perf mode
		 * @return
		 */
		public static PerfMode getPerfMode(String i_sCode) {
			switch(i_sCode) {
			case PERFMODE:
				return PERF;
			case ECOMODE:
				return ECO;
			default:
				return PERF;
				
			}
		}
		
		/**
		 * Gets the value to apply to the power throttle function
		 * @return
		 */
		public int getFlag() {
			return _iFlag;
		}

		@Override
		public String toString() {
			return _sCode;
		}

	}


	
}
