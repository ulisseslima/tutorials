package com.baeldung.transientorserializable;

public class PreferenceService {

    public String getPreference(String key) {
        return "default-" + key;
    }
}
