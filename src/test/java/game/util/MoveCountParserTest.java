package game.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveCountParserTest {

    @Test
    void Given_InputLineWithPositiveInteger_When_parseCount_Then_ReturnPositiveInteger() {
        // given
        String inputLine = "1";

        // when
        int result = MoveCountParser.parseMoveCount(inputLine);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void Given_InputLineWithNoneInteger_When_parseCount_Then_RuntimeExceptionThrown() {
        // given
        String inputLine = "가";

        //when then
        assertThatThrownBy(() ->
                MoveCountParser.parseMoveCount(inputLine))
                .isInstanceOf(RuntimeException.class);
        ;
    }

    @Test
    void Given_InputLineWithNegativeInteger_When_parseCount_Then_RuntimeExceptionThrown() {
        // given
        String inputLine = "-1";

        //when then
        assertThatThrownBy(() ->
                MoveCountParser.parseMoveCount(inputLine))
                .isInstanceOf(RuntimeException.class);
        ;
    }
}
