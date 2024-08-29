package com.example.godsviking.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.godsviking.R

object DataSource {

    /*
    List of all topics
    */
    data class Topic(
        val name: String,
        @StringRes val description: Int,
        @DrawableRes val imageResId: Int
    )

    enum class TopicName(val topicName: String) {
        DIOSES("Dioses"),
        HISTORIA("Historia"),
        LEYENDAS("Leyendas"),
        MAPA("Mapa")
    }

    val topics = listOf(
        Topic(TopicName.DIOSES.name, R.string.button_to_gods_information, R.drawable.vikingcardgods),
        Topic(TopicName.HISTORIA.name, R.string.button_to_history_information, R.drawable.historyviking),
        Topic(TopicName.LEYENDAS.name, R.string.button_to_legends_information, R.drawable.legendviking),
        Topic(TopicName.MAPA.name, R.string.button_to_map_information, R.drawable.mapviking)
    )


    /*
    List of all gods Info
     */
    data class GodInfo(
        val name: String,
        @DrawableRes val picture: Int,
        @StringRes val history: Int,
        @StringRes val power: Int,
        @StringRes val myth: Int,
        @StringRes val relation: Int
    )

    val godsInfo = mapOf(
        "Odin" to GodInfo("Odin", picture = R.drawable.odin,
            history = R.string.Odin_History,
            power = R.string.Odin_Power,
            myth = R.string.Odin_Myth,
            relation = R.string.Odin_Relation
        ),"Thor" to GodInfo("Thor", picture = R.drawable.thor,
            history = R.string.Thor_History,
            power = R.string.Thor_Power,
            myth = R.string.Thor_Myth,
            relation = R.string.Thor_Relation
        ),"Loki" to GodInfo("Loki", picture = R.drawable.loki,
            history = R.string.Loki_History,
            power = R.string.Loki_Power,
            myth = R.string.Loki_Myth,
            relation = R.string.Loki_Relation
        ),"Freya" to GodInfo("Freya", picture = R.drawable.freya,
            history = R.string.Freya_History,
            power = R.string.Freya_Power,
            myth = R.string.Freya_Myth,
            relation = R.string.Freya_Relation
        ),"Balder" to GodInfo("Balder", picture = R.drawable.balder,
            history = R.string.Balder_History,
            power = R.string.Balder_Power,
            myth = R.string.Balder_Myth,
            relation = R.string.Balder_Relation
        ),"Frigg" to GodInfo("Frigg", picture = R.drawable.frigg,
            history = R.string.Frigg_History,
            power = R.string.Frigg_Power,
            myth = R.string.Frigg_Myth,
            relation = R.string.Frigg_Relation
        ),"Freyr" to GodInfo("Freyr", picture = R.drawable.freyr,
            history = R.string.Freyr_History,
            power = R.string.Freyr_Power,
            myth = R.string.Freyr_Myth,
            relation = R.string.Freyr_Relation
        ),"Tyr" to GodInfo("Tyr", picture = R.drawable.tyr,
            history = R.string.Tyr_History,
            power = R.string.Tyr_Power,
            myth = R.string.Tyr_Myth,
            relation = R.string.Tyr_Relation
        ),"Heimdall" to GodInfo("Heimdall", picture = R.drawable.heimdall,
            history = R.string.Heimdall_History,
            power = R.string.Heimdall_Power,
            myth = R.string.Heimdall_Myth,
            relation = R.string.Heimdall_Relation
        ),"Njord" to GodInfo("Njord", picture = R.drawable.njord,
            history = R.string.Njord_History,
            power = R.string.Njord_Power,
            myth = R.string.Njord_Myth,
            relation = R.string.Njord_Relation
        ),"Hel" to GodInfo("Hel", picture = R.drawable.hel,
            history = R.string.Hel_History,
            power = R.string.Hel_Power,
            myth = R.string.Hel_Myth,
            relation = R.string.Hel_Relation
        ),"Skadi" to GodInfo("Skadi", picture = R.drawable.skadi,
            history = R.string.Skadi_History,
            power = R.string.Skadi_Power,
            myth = R.string.Skadi_Myth,
            relation = R.string.Skadi_Relation
        )
    )


    /*
    List of all gods Card Info
     */
    data class CardGodInfoGrid(
        val name: String,
        @DrawableRes val picture: Int
    )

    val godsCardInfoGrid = listOf(
        CardGodInfoGrid("Odin", R.drawable.stone_odin),
        CardGodInfoGrid("Thor", R.drawable.stone_thor),
        CardGodInfoGrid("Loki", R.drawable.stone_loki),
        CardGodInfoGrid("Freya", R.drawable.stone_freya),
        CardGodInfoGrid("Balder", R.drawable.stone_balder),
        CardGodInfoGrid("Frigg", R.drawable.stone_frigg),
        CardGodInfoGrid("Freyr", R.drawable.stone_freyr),
        CardGodInfoGrid("Tyr", R.drawable.stone_tyr),
        CardGodInfoGrid("Heimdall", R.drawable.stone_heimdall),
        CardGodInfoGrid("Njord", R.drawable.stone_njord),
        CardGodInfoGrid("Hel", R.drawable.stone_hel),
        CardGodInfoGrid("Skadi", R.drawable.stone_skadi)
    )

    /*
    List of all myths
     */
    data class Myth(
        @StringRes val mythName: Int,
        @StringRes val mythInfo: Int
    )

    val mythsInfo = listOf(
        Myth(R.string.myth_Yggdrasil,R.string.m_Yggdrasil),
        Myth(R.string.myth_firstMan,R.string.m_firstMan),
        Myth(R.string.myth_asgard,R.string.m_Asgard),
        Myth(R.string.myth_aegir,R.string.m_aegir),
        Myth(R.string.myth_utgard,R.string.m_utgard),
        Myth(R.string.myth_hammerThor,R.string.m_ThorHarmer),
        Myth(R.string.myth_judgment,R.string.m_godJudgment),
        Myth(R.string.myth_Brísingamen,R.string.m_freyaNecklace),
        Myth(R.string.myth_fenrir,R.string.m_fenrir),
        Myth(R.string.myth_balder,R.string.m_Balder),
        Myth(R.string.myth_loki,R.string.m_loki),
        Myth(R.string.myth_ragnarok,R.string.m_ragnarok)
    )


}