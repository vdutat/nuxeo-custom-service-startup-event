package com.acme.ecm.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.event.EventProducer;
import org.nuxeo.ecm.core.event.impl.UnboundEventContext;
import org.nuxeo.ecm.core.repository.RepositoryInitializationHandler;
import org.nuxeo.runtime.api.Framework;
import org.nuxeo.runtime.model.ComponentContext;
import org.nuxeo.runtime.model.DefaultComponent;
import org.nuxeo.runtime.model.Extension;

public class CustomNuxeoStartedComponentImpl extends DefaultComponent implements CustomNuxeoStartedComponent {

    private static final Logger LOGGER = LogManager.getLogger();
    
    private static final String NXP_STARTED_EVENTNAME = "nuxeoPlatformStarted";

    /**
     * Component activated notification.
     * Called when the component is activated. All component dependencies are resolved at that moment.
     * Use this method to initialize the component.
     *
     * @param context the component context.
     */
    @Override
    public void activate(ComponentContext context) {
        LOGGER.warn(CustomNuxeoStartedComponentImpl.class.getCanonicalName() + " ACTIVATING...");
        super.activate(context);
        LOGGER.warn(CustomNuxeoStartedComponentImpl.class.getCanonicalName() + " ACTIVATED.");
    }

    /**
     * Component deactivated notification.
     * Called before a component is unregistered.
     * Use this method to do cleanup if any and free any resources held by the component.
     *
     * @param context the component context.
     */
    @Override
    public void deactivate(ComponentContext context) {
        super.deactivate(context);
    }

    /**
     * Registers the given extension.
     *
     * @param extension the extension to register
     */
    @Override
    public void registerExtension(Extension extension) {
        super.registerExtension(extension);
    }

     /**
     * Unregisters the given extension.
     *
     * @param extension the extension to unregister
     */
    @Override
    public void unregisterExtension(Extension extension) {
        super.unregisterExtension(extension);
    }

    /**
     * Start the component. This method is called after all the components were resolved and activated
     *
     * @param context the component context. Use it to get the current bundle context
     */
    @Override
    public void start(ComponentContext context) {
        LOGGER.warn(CustomNuxeoStartedComponentImpl.class.getCanonicalName() + " STARTING...");
        new RepositoryInitializationHandler() {
            @Override
            public void doInitializeRepository(CoreSession session) {
                EventProducer evtProducer = Framework.getService(EventProducer.class);
                Map<String, Serializable> props = new HashMap<>();
                evtProducer.fireEvent(new UnboundEventContext(session, session.getPrincipal(), props).newEvent(NXP_STARTED_EVENTNAME));
            }
            
        }.install();
        LOGGER.warn(CustomNuxeoStartedComponentImpl.class.getCanonicalName() + " STARTED.");
    }

    /**
     * Stop the component.
     *
     * @param context the component context. Use it to get the current bundle context
     * @throws InterruptedException
     */
    @Override
    public void stop(ComponentContext context) throws InterruptedException {
        // do nothing by default. You can remove this method if not used.
    }
}
