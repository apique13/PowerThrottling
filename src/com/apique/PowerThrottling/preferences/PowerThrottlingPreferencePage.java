package com.apique.PowerThrottling.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.apique.PowerThrottling.Activator;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */

public class PowerThrottlingPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public PowerThrottlingPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Tweek the process informations");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {

		addField(new RadioGroupFieldEditor(
				PreferenceConstants.POWER_THROTTLE,
			"Power Throttling",
			1,
			new String[][] { 
					{ "&Eco", PreferenceConstants.ECOMODE},
					{ "&Performances", PreferenceConstants.PERFMODE}
					
		}, getFieldEditorParent()));

	}

	@Override
	public void init(IWorkbench workbench) {
	}
	
}