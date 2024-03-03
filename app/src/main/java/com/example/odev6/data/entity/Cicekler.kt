package com.example.odev6.data.entity

data class Cicekler(
    var cicekId:Int,
    var cicekResim:String,
    var cicekIsim:String,
    var cicekYildiz:Float,
    var degerlendirmeSayisi:Int,
    var cicekIndirimFiyat: Int,
    var cicekFiyat:Int,
    var CicekIndirimYuzde:Int ) {
}