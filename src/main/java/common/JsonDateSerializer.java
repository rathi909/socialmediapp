package common;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author sunny This class is use to serialize the date while sending date
 *         outside or writing in json response.
 */
public class JsonDateSerializer extends JsonSerializer<Instant> {

	private static final String ZULU_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

	@Override
	public void serialize(final Instant instant, final JsonGenerator gen, final SerializerProvider provider)
			throws IOException {
		final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(ZULU_FORMAT);
		gen.writeString(dateFormat.format(LocalDateTime.ofInstant(instant, ZoneOffset.UTC)));
	}
}
