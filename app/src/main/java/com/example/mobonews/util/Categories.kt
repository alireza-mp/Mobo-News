package com.example.mobonews.util

enum class Categories(val title: String) {
    All("همه"),
    Technology("تکنولوژی"),
    Sport("ورزشی"),
    Science("علم و دانش"),
    Political("سیاسی"),
    Cultural("فرهنگی"),
    Defensive("دفاعی");


    companion object {
        fun getCategoriesAsList(): List<Categories> {
            return listOf(
                All,
                Technology,
                Sport,
                Science,
                Political,
                Cultural,
                Defensive
            )
        }
    }

}
