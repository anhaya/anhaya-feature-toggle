package br.com.anhaya.anhayafeaturetoggle.controller;

import br.com.anhaya.anhayafeaturetoggle.config.AvailableFeatures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/toggle")
public class ToggleController {

    @Autowired
    private FeatureManager featureManager;

    @GetMapping("/")
    public List<Map<String, Object>> toggleFeature() {

        List<Map<String, Object>> features = new ArrayList<>();

        for (AvailableFeatures feature : AvailableFeatures.values()) {
            features.add(new HashMap<String, Object>() {{
                put(feature.name(), featureManager.isActive(feature));
            }});
        }

        return features;
    }
}
