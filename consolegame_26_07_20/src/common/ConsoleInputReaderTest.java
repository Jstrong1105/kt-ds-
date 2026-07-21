package common;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.StringReader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ConsoleInputReaderTest {
	
	private FakeOutputWriter writer;
	
	private ConsoleInputReader of(String test) {
		var br = new BufferedReader(new StringReader(test));
		return new ConsoleInputReader(writer, br);
	}
	
	@BeforeEach
	void init() {
		writer = new FakeOutputWriter();
	}
	
	// ---------------- readString -----------------------
	
	@Test
	@DisplayName("readString : 프롬프트를 출력하고 입력한 문자열을 반환")
	void readString_정상입력() {
		String test = "hello\n";
		var reader = of(test);
		
		assertEquals("hello", reader.readString("안녕?"));
		assertEquals("안녕?", writer.output());
	}
	
	@Test
	@DisplayName("readString : null 입력 시 IllegalStateException 발생")
	void readString_입력소진() {
		String test = "";
		var reader = of(test);
		
		IllegalStateException e = assertThrows(IllegalStateException.class, ()->reader.readString("입력 소진"));
		assertEquals("입력 소진", writer.output());
		assertEquals(ConsoleInputReader.NULL_STREAM, e.getMessage());
	}
	
	
	// --------------------- readInt --------------------------
	
	@Test
	@DisplayName("readInt : 프롬프트를 출력하고 사용자로부터 숫자를 입력받음")
	void readInt_정상입력() {
		String test = "5\n";
		var reader = of(test);
		
		assertEquals(5, reader.readInt("숫자입력"));
		assertEquals("숫자입력",writer.output());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"abcd","1.5","a23",""})
	@DisplayName("readInt : 숫자가 아닌 문자열을 입력할 경우 다시 입력 받음")
	void readInt_잘못된입력이후정상입력(String test) {
		var reader = of(test + "\n47\n");
		
		assertEquals(47,reader.readInt("숫자입력"));
		assertTrue(writer.output().contains(ConsoleInputReader.NUMBER_FORMAT_ERROR));
	}
	
	
	// ---------------------- readIntRange --------------------------------
	
	@Test
	@DisplayName("readIntRange : 사용자에게 안내 메시지를 출력하고 제한 범위내에서 숫자를 입력 받는다.")
	void readIntRange_정상입력() {
		String test = "5\n";
		int min = 3;
		int max = 10;
		var reader = of(test);
		
		assertEquals(5, reader.readIntRange("숫자입력", min, max));
		assertEquals(String.format("숫자입력 (%d~%d)", min, max), writer.output());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {5, 10})
	@DisplayName("readIntRange : 경계값 입력은 유효하다.")
	void readIntRange_경곗값입력(int test) {
		int min = 5;
		int max = 10;
		var reader = of( (test + "\n") );
		
		assertEquals(test, reader.readIntRange("숫자입력", min, max));
		assertEquals(String.format("숫자입력 (%d~%d)", min,max),writer.output());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {17, 4, 11, -1})
	@DisplayName("readIntRange : 범위를 벗어난 입력 시 다시 입력")
	void readIntRange_범위밖입력이후유효입력(int test) {
		int min = 5;
		int max = 10;
		var reader = of( (test + "\n5\n") );
		
		assertEquals(5, reader.readIntRange("숫자입력", min, max));
		assertTrue(writer.output().contains(String.format(ConsoleInputReader.NUMBER_RANGE_ERROR, min, max)));
	}
	
	@Test
	@DisplayName("readIntRange : 입력 소진 시 IllegalStateException")
	void readIntRange_입력소진() {
		String test = "";
		int min = 5;
		int max = 10;
		var reader = of(test);
		
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> reader.readIntRange("숫자입력", min, max));
		assertEquals(ConsoleInputReader.NULL_STREAM, e.getMessage());
	}
	
	@Test
	@DisplayName("readIntRange : min > max 시 IllegalArgumentException")
	void readIntRange_최소값보다작은최댓값() {
		String test = "";
		int min = 10;
		int max = 5;
		var reader = of(test);
		
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> reader.readIntRange("숫자입력", min, max));
		assertEquals(String.format(ConsoleInputReader.NOT_VALID_RANGE,min,max), e.getMessage());
	}
	
	
	// ------------------- readBoolean --------------------------
	
	@Test
	@DisplayName("readBoolean : 안내메시지 출력 이후 boolean 입력")
	void readBoolean_정상입력() {
		String test = "y\n";
		String trueAnswer = "y";
		String falseAnswer = "n";
		var reader = of(test);
		
		assertTrue(reader.readBoolean("답변입력", trueAnswer, falseAnswer));
	}
	
	@Test
	@DisplayName("readBoolean : 대소문자를 구분하지 않는다.")
	void readBoolean_대소문자다른입력() {
		String test = "Y\n";
		String trueAnswer = "y";
		String falseAnswer = "n";
		var reader = of(test);
		
		assertTrue(reader.readBoolean("답변입력", trueAnswer, falseAnswer));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"asd","dfgd","bggbf"})
	@DisplayName("readBoolean : 유효한 입력을 받을 때 까지 반복")
	void readBoolean_잘못된입력이후_재시도(String test) {
		String trueAnswer = "y";
		String falseAnswer = "n";
		var reader = of( (test + "\nN\n") );
		
		assertFalse(reader.readBoolean("답변입력", trueAnswer, falseAnswer));
		assertTrue(writer.output().contains(String.format(ConsoleInputReader.BOOLEAN_ANSWER_ERROR, trueAnswer, falseAnswer)));
	}
	
	// ------------------------ pause ------------------------------
	
	@Test
	@DisplayName("pause : 안내 메시지 출력 이후 엔터 입력 대기")
	void pause_정상입력() {
		String test = "\n";
		var reader = of(test);
		
		assertDoesNotThrow(() -> reader.pause("입력"));
		assertTrue(writer.output().contains("입력"));
	}
}
