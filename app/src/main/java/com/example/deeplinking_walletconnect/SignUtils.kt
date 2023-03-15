package com.example.deeplinking_walletconnect

class SignUtils {

    // Companion objects is how you define static methods in kotlin
    // To learn more visit here: https://kotlinlang.org/docs/object-declarations.html#companion-objects
    companion object {
        fun getPersonalSignBody(account: String): String {
            val msg = "My email is john@doe.com - ${System.currentTimeMillis()}".encodeToByteArray()
                .joinToString(separator = "", prefix = "0x") { eachByte -> "%02x".format(eachByte) }
            return "[\"$msg\", \"$account\"]"
        }

        fun getEthSignBody(account: String): String {
            val msg = "My email is john@doe.com - ${System.currentTimeMillis()}".encodeToByteArray()
                .joinToString(separator = "", prefix = "0x") { eachByte -> "%02x".format(eachByte) }
            return "[\"$account\", \"$msg\"]"
        }

        fun getEthSendTransaction(account: String): String {
            return "[{\"from\":\"$account\",\"to\":\"0x70012948c348CBF00806A3C79E3c5DAdFaAa347B\",\"data\":\"0x\",\"gasLimit\":\"0x5208\",\"gasPrice\":\"0x0649534e00\",\"value\":\"0x01\",\"nonce\":\"0x07\"}]"
        }

        fun getEthSignTypedData(account: String): String {
            return "[\"$account\",[\"0xCD2a3d9F938E13CD947Ec05AbC7FE734Df8DD826\",{\"types\":{\"EIP712Domain\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"version\",\"type\":\"string\"},{\"name\":\"chainId\",\"type\":\"uint256\"},{\"name\":\"verifyingContract\",\"type\":\"address\"}],\"Person\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"wallet\",\"type\":\"address\"}],\"Mail\":[{\"name\":\"from\",\"type\":\"Person\"},{\"name\": \"to\",\"type\":\"Person\"},{\"name\":\"contents\",\"type\":\"string\"}]},\"primaryType\":\"Mail\",\"domain\":{\"name\":\"Ether Mail\",\"version\":\"1\",\"chainId\":\"1\",\"verifyingContract\":\"0xCcCCccccCCCCcCCCCCCcCcCccCcCCCcCcccccccC\"},\"message\":{\"from\": {\"name\":\"Cow\",\"wallet\":\"0xCD2a3d9F938E13CD947Ec05AbC7FE734Df8DD826\"},\"to\":{\"name\":\"Bob\",\"wallet\":\"0xbBbBBBBbbBBBbbbBbbBbbbbBBbBbbbbBbBbbBBbB\"},\"contents\":\"Hello, Bob!\"}}]]"
        }
    }
}