package com.example.mobonews.util

enum class Categories(val title: String) {
    All("همه"),
    World("جهان"),
    Sport("ورزشی"),
    Science("علم و دانش"),
    Political("سیاسی"),
    Cultural("فرهنگی"),
    Defensive("دفاعی");


    companion object {
        fun getCategoriesAsList(): List<Categories> {
            return listOf(
                All,
                World,
                Sport,
                Science,
                Political,
                Cultural,
                Defensive
            )
        }
    }

}
