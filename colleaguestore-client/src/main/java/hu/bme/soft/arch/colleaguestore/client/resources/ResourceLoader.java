package hu.bme.soft.arch.colleaguestore.client.resources;

import com.google.inject.Inject;

public class ResourceLoader {

	@Inject
	ResourceLoader(Resources resources) {
		resources.style().ensureInjected();
	}
}
