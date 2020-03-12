[ ![Download](https://api.bintray.com/packages/scala-cash/io/zio-secp256k1/images/download.svg) ](https://bintray.com/scala-cash/io/zio-secp256k1/_latestVersion)

# zio-secp256k1
ZIO wrapper around Java JNI bindings for secp256k1 library used in BCH

Add this to your build.sbt file
```
resolvers ++= Seq(
  Resolver.bintrayRepo("scala-cash", "io")
)

libraryDependencies += "org.scash" %% "zio-secp256k1" % <latestVersion>
```

The latest version matches the badge above

## Usage

The calls are done directly on the package object. The library also comes with two helper functions to convert
to and from hex `hexToBytes` and `bytesToHex`

```scala 
  val res: Task[Boolean] = secp256k1.verifyLibrary
  
  val data: Array[Byte] = hexToBytes("CF80CD8AED482D5D1527D7DC72FCEFF84E6326592848447D2DC0B0E87DFC9A90")
  val privKey: Array[Byte] = hexToBytes("67E56582298859DDAE725F972992A07C6C4FB9F62A8FFF58CE3CA926A1063530")
  val signed: Task[Array[Byte]] = secp256k1.signECDSA(data, privKey)
  
```

## Api
The Task object is a `ZIO[Any, Throwable, A]` type alias. It means that the effect could throw an exception if something
goes wrong (i.e invalid input data, fail to connect to native library)
```scala
  type Bytes = Array[Byte]
  
  def verifyLibrary: Task[Boolean]
  
  def verifyECDSA(data: Bytes, signature: Bytes, pubkey: Bytes): Task[Boolean]

  def signECDSA(data: Bytes, privkey: Bytes): Task[Bytes]

  def verifySchnorr(data: Bytes, signature: Bytes, pubkey: Bytes): Task[Boolean]

  def signSchnorr(data: Bytes, privkey: Bytes): Task[Bytes]

  def computePubKey(secKey: Bytes): Task[Bytes]

  def isValidPrivKey(privkey: Bytes): Task[Boolean]

  def pubKeyTweakAdd(pubkey: Bytes, tweak: Bytes): Task[Bytes]

  def privKeyTweakAdd(privkey: Bytes, tweak: Bytes): Task[Bytes]

```
