package br.com.dextra.common.json;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONObject {

	protected static final Gson GSON_BUILDER_INSTANCE = new GsonBuilder().create();

	@SuppressWarnings("rawtypes")
	protected Map map;
	protected String content;
	protected Object object;

	public JSONObject(String content) {
		this.content = content;
	}

	public JSONObject(Object object) {
		this.object = object;
	}

	@SuppressWarnings("rawtypes")
	public JSONObject(Map map) {
		this.map = map;
		this.content = map.toString();
	}

	public String toJson() {
		if (this.object == null) {
			throw new RuntimeException("The object can not be null!");
		}

		return GSON_BUILDER_INSTANCE.toJson(object);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> T toObject(Class clazz) {
		if (content == null) {
			content = this.toJson();
		}

		return (T) GSON_BUILDER_INSTANCE.fromJson(content, clazz);
	}

	@Override
	public String toString() {
		return toJson();
	}

}
