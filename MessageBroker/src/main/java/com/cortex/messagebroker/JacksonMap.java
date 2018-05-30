package com.cortex.messagebroker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonMap extends LinkedHashMap<String, Object> {

    private static final ObjectMapper MAPPER = ObjectMapperFactory.get();

    public JacksonMap() {
    }

    public JacksonMap(Object... parameters) {
        super();

        for (int i = 0; i < parameters.length; i += 2) {
            String key = (String) parameters[i];
            this.put(key, parameters[i + 1]);
        }
    }

    public JacksonMap(Map<String, Object> map) {
        if (map != null) {
            putAll(map);
        }
    }

    public String getString(String key, String defaultValue) {
        return containsKey(key) ? (String) get(key) : defaultValue;
    }

    public String getString(String key) {
        return getString(key, null);
    }

    public Number getNumber(String key, Number defaultValue) {
        return containsKey(key) ? (Number) get(key) : defaultValue;
    }

    public Number getNumber(String key) {
        return getNumber(key, null);
    }

    public Boolean getBoolean(String key, Boolean defaultValue) {
        return containsKey(key) ? (Boolean) get(key) : defaultValue;
    }

    public Boolean getBoolean(String key) {
        return getBoolean(key, null);
    }

    public <T> List<T> getList(String key, Class<T> clazz) {
        return getList(key, clazz, MAPPER);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getList(String key, Class<T> clazz, ObjectMapper mapper) {
        if (!containsKey(key) || get(key) == null) {
            return new ArrayList<>();
        }

        Object value = get(key);
        List<T> list = new ArrayList<>();
        if (Collection.class.isAssignableFrom(value.getClass())) {
            for (Object o : (Collection<Object>) value) {
                list.add(mapper.convertValue(o, clazz));
            }
        }
        else {
            list.add(mapper.convertValue(value, clazz));
        }

        return list;
    }

    public <T> Set<T> getSet(String key, Class<T> clazz) {
        return new HashSet<>(getList(key, clazz));
    }

    public <T> T getObject(String key, Class<T> clazz) {
        return getObject(key, clazz, MAPPER);
    }

    public <T> T getObject(String key, Class<T> clazz, ObjectMapper mapper) {
        return mapper.convertValue(get(key), clazz);
    }

    @SuppressWarnings("unchecked")
    public JacksonMap getMap(String key) {
        if (!containsKey(key) || get(key) == null) {
            return null;
        }

        return new JacksonMap((Map<String, Object>) get(key));
    }

    @SuppressWarnings("unchecked")
    public List<JacksonMap> getMapList(String key) {
        if (!containsKey(key) || get(key) == null) {
            return new ArrayList<>();
        }

        Object value = get(key);
        List<JacksonMap> list = new ArrayList<>();
        if (Collection.class.isAssignableFrom(value.getClass())) {
            for (Object o : (Collection<Object>) value) {
                list.add(new JacksonMap((Map<String, Object>) o));
            }
        }
        else {
            list.add(new JacksonMap((Map<String, Object>) value));
        }

        return list;
    }

}