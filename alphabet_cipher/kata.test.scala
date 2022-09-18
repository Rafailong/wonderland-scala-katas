//> using scala "3.2.0"
//> using lib "org.scalameta::munit:0.7.29"
package alphabet_chiper

import munit.FunSuite
import munit.Assertions.*

class tests extends FunSuite:

  val alphabet = Alphabet()

  test("an Alphabet can be started from given a given char") {
    ('a' to 'z').foreach { c =>
      val value = alphabet.startingAt(c).value.head
      assertEquals(value, c, s"expected=$c - actual=$value")
    }
  }

  val codec = Codec(alphabet)

  test("a Codec can encode a message given a secret keyword") {
    assertEquals(
      codec.encode("meetmeontuesdayeveningatseven", "vigilance"),
      "hmkbxebpxpmyllyrxiiqtoltfgzzv"
    )

    assertEquals(
      codec.encode("meetmebythetree", "scones"),
      "egsgqwtahuiljgs"
    )
  }

  test("a Codec can decode a message given an encoded message and a secret keyword") {
    assertEquals(
      codec.decode("hmkbxebpxpmyllyrxiiqtoltfgzzv", "vigilance"),
      "meetmeontuesdayeveningatseven"
    )

    assertEquals(
      codec.decode("egsgqwtahuiljgs", "scones"),
      "meetmebythetree"
    )
  }

  test("crack can extract the secret keyword given an encoded message and the original message") {
    assertEquals(
      crack(alphabet, "thequickbrownfoxjumpsoveralazydog", "opkyfipmfmwcvqoklyhxywgeecpvhelzg"),
      "vigilance"
    )

    assertEquals(
      crack(alphabet, "packmyboxwithfivedozenliquorjugs", "hcqxqqtqljmlzhwiivgbsapaiwcenmyu"),
      "scones"
    )

    assertEquals(
      crack(alphabet, "hellofromrussia", "hfnlphoontutufa"),
      "abcabcx"
    )
  }

end tests
