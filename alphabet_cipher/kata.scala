//> using scala "3.2.0"
package alphabet_chiper

import scala.util.chaining

case class Alphabet(value: String = "abcdefghijklmnopqrstuvwxyz") extends AnyVal:

  def startingAt(c: Char): Alphabet =
    val (l, r) = value.splitAt(value.indexOf(c))
    Alphabet((r ++ l).mkString)

  def indexOf(c: Char): Int = value.indexOf(c)

  def charAt(i: Int): Char = value.charAt(i)

  override def toString(): String = value

end Alphabet

case class Codec(alphabet: Alphabet):

  def encode(msg: String, keyword: String): String =
    zip(msg, keyword)
      .foldRight(List.empty[Char]) { case ((c, k), acc) =>
        alphabet.startingAt(k).charAt(alphabet.indexOf(c)) :: acc
      }
      .mkString

  def decode(message: String, keyword: String): String =
    zip(message, keyword)
      .foldRight(List.empty[Char]) { case ((c, k), acc) =>
        alphabet.charAt(
          alphabet.startingAt(c).indexOf(k)
        ) :: acc
      }
      .mkString
end Codec

def crack(alphabet: Alphabet, msg: String, encodedMsg: String): String = ???

def zip(message: String, keyword: String): List[(Char, Char)] = {

  def go(msg: List[Char], key: List[Char], acc: List[(Char, Char)]): List[(Char, Char)] =
    (msg, key) match
      case (Nil, _)           => acc
      case (c :: cs, k :: ks) => go(cs, ks, acc :+ (k, c))
      case (_ :: _, Nil)      => go(msg, keyword.toLowerCase().toList, acc)

  go(message.toLowerCase().toList, keyword.toLowerCase().toList, List.empty)
}
