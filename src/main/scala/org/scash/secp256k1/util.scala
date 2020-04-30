package org.scash.secp256k1

object util {
  def hexToBytes(s: String) = {
    val len = s.length
    require(len % 2 == 0, "The hex string length should be even !")
    @annotation.tailrec
    def go(i: Int, arr: Array[Byte]): Array[Byte] =
      if (i < len) {
        val b = (Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16)
        go(i + 2, arr.updated(i / 2, b.toByte))
      } else arr

    go(0, new Array[Byte](len / 2))
  }

  def bytesToHex(byteArray: Array[Byte]) = {
    val stringBuilder = new StringBuilder(byteArray.length * 2)
    byteArray.foreach(b => stringBuilder.append(String.format("%02X", Byte.box(b))))
    stringBuilder.toString
  }
}
