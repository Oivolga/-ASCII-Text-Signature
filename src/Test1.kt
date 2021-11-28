import java.io.File

fun main() {
    val alfa = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    //variables for Roman
    val catRom = mutableMapOf<String, String>()
    val codRom = mutableListOf<String>()
    val rom =  mutableListOf("", "", "", "", "", "", "", "", "", "")
    var count1 = 0
    val fileName1 = "src/roman.txt"
    val roman = File(fileName1).readLines()
    //variables for Medium
    val catMed = mutableMapOf<String, String>()
    val codMed = mutableListOf<String>()
    val med = mutableListOf("", "", "", "", "", "")
    var count2 = 0
    val fileName2 = "src/medium.txt"
    val medium = File(fileName2).readLines()

    print("Enter name and surname: ")
    val name = readLine()!!
    print("Enter person's status: ")
    val status = readLine()!!.lowercase()

    for (i in 1 until roman.size step 11) {
        codRom.add(roman[i])
    }
    for (i in 1 until medium.size step 4) {
        codMed.add(medium[i])
    }
    for (i in alfa.indices) {
        catRom[alfa[i].toString()] = codRom[i]
        catMed[alfa[i].toString()] = codMed[i]
    }
    //convert type to Roman
    for (item in name) {
        count1 += if (item.toString() != " ") {
            (catRom[item.toString()])?.substringAfter(" ")?.toInt()!!
        } else {
            10
        }
        for (i in 0..9) {
            if (item.toString() != " ") {
                rom[i] += roman[roman.indexOf(catRom[item.toString()]) + i + 1]
            } else {
                repeat(10) { rom[i] += " " }
            }
        }
    }
    //convert type to Medium
    for (item in status) {
        count2 += if (item.toString() != " ") {
            (catMed[item.toString()])?.substringAfter(" ")?.toInt()!!
        } else {
            6
        }
        for (i in 0..2) {
            if (item.toString() != " ") {
                med[i] += medium[medium.indexOf(catMed[item.toString()]) + i + 1]
            } else {
                repeat(6) {med[i] += " "}
            }
        }
    }
    // variables for output format
    val count = if (count1 > count2) {
        count1 + 8
    } else {
        count2 + 8
    }
    var center = ""
    val center1: String
    if (count1 > count2) {
        repeat((count - count2) / 2 - 2) { center += " "}
        center1 = if ((count - count2) % 2 == 0) {
            center
        } else {
            "$center "
        }
    } else {
        repeat((count - count1) / 2 - 2) { center += " "}
        center1 = if ((count - count1) % 2 == 0) {
            center
        } else {
            "$center "
        }
    }

    var border = ""
    repeat(count) { border += "8"}

    println(border)
    for (let in rom) {
        if (count1 > count2) {
            println("88  $let  88")
        } else {
            println("88${center}${let}${center1}88")
        }
    }
    for (x in 0..2) {
        if (count1 > count2) {
            println("88${center}${med[x]}${center1}88")
        } else{
            println("88  ${med[x]}  88")
        }
    }
    println(border)
}

