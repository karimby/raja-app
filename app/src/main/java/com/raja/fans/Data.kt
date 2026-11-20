package com.raja.fans

// ============================================================
// هنا بيانات الفريق. هذه بيانات تجريبية: عدّلها بالمعلومات الحقيقية.
// ============================================================

data class NewsItem(
    val title: String,
    val summary: String,
    val date: String,
)

data class MatchItem(
    val opponent: String,
    val competition: String,
    val date: String,
    val isHome: Boolean,
    val rajaScore: Int? = null,   // اتركها null إذا لم تلعب المباراة بعد
    val opponentScore: Int? = null,
)

data class Player(
    val name: String,
    val number: Int,
    val position: String,
)

val sampleNews = listOf(
    NewsItem(
        title = "عنوان الخبر الأول",
        summary = "ملخص قصير للخبر يظهر هنا. استبدله بخبر حقيقي عن الفريق.",
        date = "2026/11/20",
    ),
    NewsItem(
        title = "عنوان الخبر الثاني",
        summary = "يمكنك إضافة أخبار الانتقالات والتدريبات وتصريحات المدرب.",
        date = "2026/11/18",
    ),
    NewsItem(
        title = "عنوان الخبر الثالث",
        summary = "كل خبر هو عنصر في القائمة، أضف أو احذف كما تشاء.",
        date = "2026/11/15",
    ),
)

val sampleMatches = listOf(
    MatchItem("الفريق الخصم 1", "البطولة الاحترافية", "2026/11/22", isHome = true),
    MatchItem("الفريق الخصم 2", "كأس العرش", "2026/11/10", isHome = false, rajaScore = 2, opponentScore = 1),
    MatchItem("الفريق الخصم 3", "البطولة الاحترافية", "2026/11/03", isHome = true, rajaScore = 1, opponentScore = 1),
)

val samplePlayers = listOf(
    Player("حارس المرمى 1", 1, "حراس المرمى"),
    Player("مدافع 1", 4, "المدافعون"),
    Player("مدافع 2", 5, "المدافعون"),
    Player("لاعب وسط 1", 8, "لاعبو الوسط"),
    Player("لاعب وسط 2", 10, "لاعبو الوسط"),
    Player("مهاجم 1", 9, "المهاجمون"),
    Player("مهاجم 2", 11, "المهاجمون"),
)
