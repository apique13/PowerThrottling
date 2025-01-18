package com.apique.PowerThrottling;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.apique.PowerThrottling.preferences.PreferenceConstants;
import com.apique.PowerThrottling.preferences.PreferenceConstants.PerfMode;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "EfficientWorkaround";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		IPreferenceStore store = getDefault().getPreferenceStore();
		 // Ajouter le listener aux préférences
        store.addPropertyChangeListener(new PerfPreferenceListener());
		
		String sPerfMode = store.getString(PreferenceConstants.POWER_THROTTLE);
		PreferenceConstants.PerfMode mode = PerfMode.getPerfMode(sPerfMode);
		int iFlag = mode.getFlag();
		PowerThrottling.setThrottle(iFlag);
	
	
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	
    public static void logInfo(String message) {
        log(IStatus.INFO, message, null);
    }

    public static void logError(String message, Throwable throwable) {
        log(IStatus.ERROR, message, throwable);
    }

    private static void log(int severity, String message, Throwable throwable) {
        ILog log = getDefault().getLog();
        Status status = new Status(severity, PLUGIN_ID, message, throwable);
        log.log(status);
    }
}
