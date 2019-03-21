package com.github.vincentbostoen.nivoses

enum class Massif(
    val massif: String,
    val nivoseCodeList: ArrayList<String>,
    val idBra: String
) {
    CHARTREUSE("Chartreuse", arrayListOf("PORTE", "STHIL"), "idBra"),
    VERCORS("Vercors", arrayListOf("GUA"), "idBra"),
    BELLEDONNE("Belledonne", arrayListOf("AIGUE"), "idBra")
}
