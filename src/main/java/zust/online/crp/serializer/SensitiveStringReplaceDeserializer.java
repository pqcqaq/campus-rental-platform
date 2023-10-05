package zust.online.crp.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.github.houbb.sensitive.word.core.SensitiveWordHelper;

import java.io.IOException;

/**
 * @author qcqcqc
 */
public class SensitiveStringReplaceDeserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String valueAsString = p.getValueAsString();
        return SensitiveWordHelper.replace(valueAsString);
    }
}
