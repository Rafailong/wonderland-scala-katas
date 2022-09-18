//> using scala "3.2.0"
package alphabet_chiper

case class Alphabet(value: String = "abcdefghijklmnopqrstuvwxyz") extends AnyVal:

  def startingAt(c: Char): Alphabet =
    val (l, r) = value.splitAt(value.indexOf(c))
    Alphabet((r ++ l).mkString)

end Alphabet

case class Codec(alphabet: Alphabet):

  def encode(msg: String, keyword: String): String = ???

  def decode(msg: String, keyword: String): String = ???
end Codec

def crack(alphabet: Alphabet, msg: String, encodedMsg: String): String = ???
