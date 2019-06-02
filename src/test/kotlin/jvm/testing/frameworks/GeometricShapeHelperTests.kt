package jvm.testing.frameworks

import io.kotlintest.properties.assertAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.FeatureSpec
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.forAll
import io.kotlintest.tables.headers
import io.kotlintest.tables.row
import io.kotlintest.tables.table

class GeometricShapeHelperTests : StringSpec({
    val geometricShapeHelper = GeometricShapeHelper()

    "calculate shape´s area" {
        table(
                headers("shape", "expected result"),
                row(Square(5), 25),
                row(Rectangle(3, 4), 12),
                row(Rectangle(5, 1), 5)
        ).forAll { s, r ->
            geometricShapeHelper.calculateArea(s) shouldBe r
        }
    }
})

class GeometricShapeHelperUnrolledTest : FeatureSpec({
    feature("calculate shape´s area") {
        val geometricShapeHelper = GeometricShapeHelper()

        val shapes = mapOf(
                Square(5) to 25,
                Rectangle(3, 4) to 12,
                Rectangle(5, 1) to 5
        )

        shapes.forEach { (shape, expectedResult) ->
            scenario("shape should have area $expectedResult") {
                geometricShapeHelper.calculateArea(shape) shouldBe expectedResult
            }
        }
    }
})

class GeometricShapeHelperPropertyTest: StringSpec() {
    val geometricShapeHelper = GeometricShapeHelper()

    init {
        "Shape areas" {
            assertAll { a: Int, b: Int ->
                geometricShapeHelper.calculateArea(Square(a)) shouldBe a * a
                geometricShapeHelper.calculateArea(Rectangle(a,b)) shouldBe a * b
            }
        }
    }
}

