package jvm.testing.frameworks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GeometricShapeHelperTest {
    GeometricShapeHelper geometricShapeHelper = new GeometricShapeHelper();

    @ParameterizedTest
    @MethodSource("shapes")
    @DisplayName("Calculate area by shape")
    void calculateArea(Shape shape, int expectedResult) {
        assertThat(geometricShapeHelper.calculateArea(shape)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> shapes() {
        return Stream.of(
                arguments(new Square(5), 25),
                arguments(new Rectangle(3, 4), 12),
                arguments(new Rectangle(5, 1), 5)
        );
    }
}

