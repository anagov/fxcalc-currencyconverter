package com.anz.securities.dataloader.spi;

import java.util.HashMap;
import java.util.Map;

public class LoaderConfig {
	
	private Map<Object,Object> config;
	public LoaderConfig() {
		config = new HashMap<Object,Object>();
	}
	
	public Map<Object, Object> getConfig() {
		return config;
	}
	public void setConfig(Map<Object, Object> config) {
		this.config = config;
	}
	
	public void setConfig(Object key, Object value) {
		this.config.put(key, value);
	}

	public Object getConfigValue(Object key) {
		return this.config.get(key);
	}

}
