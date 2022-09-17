//> using scala "3.2.0"
//> using lib "org.scalameta::munit:0.7.29"
package test_kata

class tests extends munit.FunSuite:

  test("shall pass") {
    munit.Assertions.assert(kata())
  }

end tests
