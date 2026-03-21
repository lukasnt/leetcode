package validate_ip_address

class Solution {
    fun validIPAddress(queryIP: String): String {
        val ipv4 = queryIP.split(".").let { parts ->
            parts.size == 4 && parts.all {
                (!it.startsWith('0') || it.length == 1) && it.toIntOrNull() in 0..255
            }
        }
        val ipv6 = queryIP.split(":").let { parts ->
            parts.size == 8 && parts.all {
                it.length in 1..4 && it.toIntOrNull(16) != null
            }
        }
        return if (ipv4) "IPv4" else if (ipv6) "IPv6" else "Neither"
    }
}

fun main() {
    val sol = Solution()
    println(sol.validIPAddress("192.168.1.1"))
    println(sol.validIPAddress("192.168.1.0"))
    println(sol.validIPAddress("192.168.01.1"))
    println(sol.validIPAddress("192.168.1.00"))
    println(sol.validIPAddress("192.168@1.1"))
    println(sol.validIPAddress("192.168@1.1"))
    println(sol.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"))
    println(sol.validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"))
    println(sol.validIPAddress("2001:0db8:85a3::8A2E:037j:7334"))
    println(sol.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"))
}