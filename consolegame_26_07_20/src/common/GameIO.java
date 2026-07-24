package common;

import java.util.Objects;

/**
 * 게임 입출력 객체 모음
 */
public record GameIO(InputReader reader, OutputWriter writer) {
	public GameIO {
		Objects.requireNonNull(reader);
		Objects.requireNonNull(writer);
	}
}
