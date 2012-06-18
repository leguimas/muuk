package br.com.dextra.common.json;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class JSONUTF8EncodingObject extends JSONObject {

	private String content;

	private Object object;

	private final GsonBuilder GSON_BUILDER_INSTANCE = new GsonBuilder();

	private static final JsonDeserializer<String> STRING_UTF8_DESERIALIZER = new JsonDeserializer<String>() {

		@Override
		public String deserialize(JsonElement json, Type arg1, JsonDeserializationContext context)
				throws JsonParseException {
			try {
				// we have to escape % char
				String string = json.getAsString();
				string = string.replaceAll("\\%", "%25");
				string = string.replaceAll("\\+", "%2B");

				return URLDecoder.decode(string, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException("Invalid encoding.", e);

			}
		}

	};

	private static final JsonSerializer<String> STRING_UTF8_SERIALIZER = new JsonSerializer<String>() {

		@Override
		public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {
			return new JsonPrimitive(src);
		}

	};

	public JSONUTF8EncodingObject(@SuppressWarnings("rawtypes") Map map) {
		super(map);
	}

	public JSONUTF8EncodingObject(Object pObject, String dateFormatPattern) {
		super(pObject);
		object = pObject;
		init(dateFormatPattern);
	}

	public JSONUTF8EncodingObject(Object pObject) {
		this(pObject, null);
	}

	public JSONUTF8EncodingObject(final String pContent) {
		super(pContent);
		content = pContent;
		init(null);
	}

	private void init(String dateFormatPattern) {
		GSON_BUILDER_INSTANCE.registerTypeAdapter(String.class, STRING_UTF8_SERIALIZER);
		GSON_BUILDER_INSTANCE.registerTypeAdapter(String.class, STRING_UTF8_DESERIALIZER);

		if (dateFormatPattern == null) {
			GSON_BUILDER_INSTANCE.setDateFormat("dd/MM/yyyy");
		} else {
			GSON_BUILDER_INSTANCE.setDateFormat(dateFormatPattern);
		}
	}

	public JSONUTF8EncodingObject setNewDateFormat(String pDateFormat) {
		GSON_BUILDER_INSTANCE.setDateFormat(pDateFormat);
		return this;
	}

	@Override
	public String toJson() {
		if (object == null) {
			throw new RuntimeException("The object can't be null");
		}
		Gson gSon = GSON_BUILDER_INSTANCE.create();
		return gSon.toJson(this.object);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public <T> T toObject(Class clazz) {
		if (this.content == null) {
			this.content = toJson();
		}

		Gson gSon = GSON_BUILDER_INSTANCE.create();
		return (T) gSon.fromJson(this.content, clazz);
	}

}
