package common;

import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * @author sunny
 *
 */
public class CommonUtils {

	public static String getShortUuid() {
		return Long.toString(ByteBuffer.wrap(UUID.randomUUID().toString().getBytes()).getLong(), Character.MAX_RADIX);

	}

}
