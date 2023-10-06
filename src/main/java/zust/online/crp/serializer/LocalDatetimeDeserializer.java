package zust.online.crp.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import zust.online.crp.utils.TimeFormatterUtils;

import java.io.IOException;
import java.time.LocalDateTime;

public class LocalDatetimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctx)
            throws IOException {
        String str = p.getText();
        return LocalDateTime.parse(str, TimeFormatterUtils.SDF_1);
    }
}
