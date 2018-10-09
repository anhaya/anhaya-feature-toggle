package br.com.anhaya.anhayafeaturetoggle.config;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum AvailableFeatures implements Feature {

    @Label("Create Client")
    CREATE_CLIENT,

    @Label("Remove Client")
    REMOVE_CLIENT,

    @Label("Update Client")
    UPDATE_CLIENT,

    @Label("Delete Client")
    DELETE_CLIENT;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}
