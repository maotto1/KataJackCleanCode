
class GildedRose(
    /**
     * Type of current rose
     */
    private val name: String,
    /**
     * Current quality
     */
    var quality: Int,
    sellIn: Int
) {
    /**
     * Return current quality
     */
    /**
     * Return days remaining till sell date
     */
    /**
     * Remaining days till sell date
     */
    var daysRemaining: Int
        private set

    /**
     * main.java.GildedRose constructor
     */
    init {
        quality = quality
        daysRemaining = sellIn
    }

    /**
     * Executes a day tick
     */
    fun tick() {
        if (name !== "Aged Brie" && name !== "Backstage passes to a TAFKAL80ETC concert") {
            if (quality > 0) {
                if (name !== "Sulfuras, Hand of Ragnaros") {
                    quality -= 1
                }
            }
        } else {
            if (quality < 50) {
                quality += 1
                if (name === "Backstage passes to a TAFKAL80ETC concert") {
                    if (daysRemaining < 11) {
                        if (quality < 50) {
                            quality += 1
                        }
                    }
                    if (daysRemaining < 6) {
                        if (quality < 50) {
                            quality += 1
                        }
                    }
                }
            }
        }
        if (name !== "Sulfuras, Hand of Ragnaros") {
            daysRemaining -= 1
        }
        if (daysRemaining < 0) {
            if (name !== "Aged Brie") {
                if (name !== "Backstage passes to a TAFKAL80ETC concert") {
                    if (quality > 0) {
                        if (name !== "Sulfuras, Hand of Ragnaros") {
                            quality -= 1
                        }
                    }
                } else {
                    quality = quality - quality
                }
            } else {
                if (quality < 50) {
                    quality += 1
                }
            }
        }
    }
}
