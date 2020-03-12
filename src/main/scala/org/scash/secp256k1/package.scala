package org.scash

import org.bitcoin.{ NativeSecp256k1, Secp256k1Context }
import zio.Task

package object secp256k1 {
  type Bytes = Array[Byte]

  def verifyLibrary: Task[Boolean] =
    Task(Secp256k1Context.isEnabled)

  def verifyECDSA(data: Bytes, signature: Bytes, pubkey: Bytes): Task[Boolean] =
    Task(NativeSecp256k1.verify(data, signature, pubkey))

  def signECDSA(data: Bytes, privkey: Bytes): Task[Bytes] =
    Task(NativeSecp256k1.sign(data, privkey))

  def verifySchnorr(data: Bytes, signature: Bytes, pubkey: Bytes): Task[Boolean] =
    Task(NativeSecp256k1.schnorrVerify(data, signature, pubkey))

  def signSchnorr(data: Bytes, privkey: Bytes): Task[Bytes] =
    Task(NativeSecp256k1.schnorrSign(data, privkey))

  def computePubKey(secKey: Bytes): Task[Bytes] =
    Task(NativeSecp256k1.computePubkey(secKey))

  def isValidPrivKey(privkey: Bytes): Task[Boolean] =
    Task(NativeSecp256k1.secKeyVerify(privkey))

  def pubKeyTweakAdd(pubkey: Bytes, tweak: Bytes): Task[Bytes] =
    Task(NativeSecp256k1.pubKeyTweakAdd(pubkey, tweak))

  def privKeyTweakAdd(privkey: Bytes, tweak: Bytes): Task[Bytes] =
    Task(NativeSecp256k1.privKeyTweakAdd(privkey, tweak))

}
