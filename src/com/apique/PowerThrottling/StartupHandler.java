package com.apique.PowerThrottling;

import org.eclipse.ui.IStartup;

public class StartupHandler implements IStartup {

	@Override
	public void earlyStartup() {
        Activator.logInfo("Powerthrottling plugin is starting");
	}

}
