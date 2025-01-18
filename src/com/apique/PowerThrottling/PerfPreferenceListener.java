package com.apique.PowerThrottling;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

import com.apique.PowerThrottling.preferences.PreferenceConstants;
import com.apique.PowerThrottling.preferences.PreferenceConstants.PerfMode;

/**
 * Preference listener used to change performance mode
 * after changing preferences
 */
public class PerfPreferenceListener implements IPropertyChangeListener {

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (PreferenceConstants.POWER_THROTTLE.equals(event.getProperty())) {
			String sValue = (String) event.getNewValue();
			PreferenceConstants.PerfMode mode = PerfMode.getPerfMode(sValue);
			PowerThrottling.setThrottle(mode.getFlag());
		}
	}

}
