package jvm.testing.frameworks

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.forAll
import io.kotlintest.tables.headers
import io.kotlintest.tables.row
import io.kotlintest.tables.table

class GeometricShapeHelperTest : StringSpec({
    val geometricShapeHelper = GeometricShapeHelper()

    "maximum of two numbers" {
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