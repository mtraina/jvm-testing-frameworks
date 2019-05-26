package jvm.testing.frameworks

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class GeometricShapeHelperSpec extends Specification {
    def geometricShapeHelper = new GeometricShapeHelper()

    def "calculate area, expected result #expectedResult"() {
        expect:
        geometricShapeHelper.calculateArea(shape) == expectedResult

        where:
        shape               | expectedResult
        new Square(5)       | 25
        new Rectangle(3, 4) | 12
        new Rectangle(5, 1) | 5
    }
}
