package br.com.money;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.serialization.Deserializer;
import br.com.caelum.vraptor.serialization.Deserializes;

@Deserializes("application/json")
public class JsonConverter implements Deserializer {

	private static Gson gson;

	static {
		JsonDeserializer<BigDecimal> bdDeserializer = new JsonConverter().new BigDecimalAdapter();
		gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").
				registerTypeAdapter(BigDecimal.class, bdDeserializer).
				create();					
	}

	@Override
	public Object[] deserialize(InputStream inputStream, ControllerMethod method) {
		Object[] objects = new Object[method.getMethod().getParameterTypes().length];
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		for (int i = 0; i < method.getMethod().getParameterTypes().length; i++) {
			objects[i] = gson.fromJson(reader, method.getMethod().getParameterTypes()[i]);
		}
		return objects;
	}
	
	class BigDecimalAdapter implements JsonDeserializer<BigDecimal>{

		@Override
		public BigDecimal deserialize(JsonElement elemet, Type arg1, JsonDeserializationContext arg2)	throws JsonParseException {
			String value = elemet.getAsString();
			if(value.contains(",")){
				value = value.replaceAll("\\.", "");
				value = value.replaceAll(",", ".");
			}
			return new BigDecimal(value);
		}
		
	}
}
