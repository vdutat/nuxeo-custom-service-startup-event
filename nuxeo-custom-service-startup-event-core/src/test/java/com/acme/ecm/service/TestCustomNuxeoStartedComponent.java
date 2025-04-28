package com.acme.ecm.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.platform.test.PlatformFeature;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;

import javax.inject.Inject;

@RunWith(FeaturesRunner.class)
@Features({ PlatformFeature.class })
@Deploy("com.acme.ecm.service.nuxeo-custom-service-startup-event-core")
public class TestCustomNuxeoStartedComponent {

    @Inject
    protected CustomNuxeoStartedComponent customnuxeostartedcomponent;

    @Test
    public void testService() {
        assertNotNull(customnuxeostartedcomponent);
    }
}
