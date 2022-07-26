import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test

class GildedRoseTest {
    @Test
    fun testNormalBeforeSellDate() {
        val rose = GildedRose("normal", 10, 5)
        rose.tick()
        assertEquals(9, rose.quality)
        assertEquals(4, rose.daysRemaining)
    }

    @Test
    fun testNormalOnSellDate() {
        val rose = GildedRose("normal", 10, 0)
        rose.tick()
        assertEquals(8, rose.quality)
        assertEquals(-1, rose.daysRemaining)
    }

    @Test
    fun testNormalAfterSellDate() {
        val rose = GildedRose("normal", 10, -1)
        rose.tick()
        assertEquals(8, rose.quality)
        assertEquals(-2, rose.daysRemaining)
    }

    @Test
    fun testNormalOfZeroQuality() {
        val rose = GildedRose("normal", 0, 5)
        rose.tick()
        assertEquals(0, rose.quality)
        assertEquals(4, rose.daysRemaining)
    }

    @Test
    fun testBrieBeforeSellDate() {
        val rose = GildedRose("Aged Brie", 10, 5)
        rose.tick()
        assertEquals(11, rose.quality)
        assertEquals(4, rose.daysRemaining)
    }

    @Test
    fun testBrieBeforeSellDateWithMaxQuality() {
        val rose = GildedRose("Aged Brie", 50, 5)
        rose.tick()
        assertEquals(50, rose.quality)
        assertEquals(4, rose.daysRemaining)
    }

    @Test
    fun testBrieOnSellDate() {
        val rose = GildedRose("Aged Brie", 10, 0)
        rose.tick()
        assertEquals(12, rose.quality)
        assertEquals(-1, rose.daysRemaining)
    }

    @Test
    fun testBrieOnSellDateNearMaxQuality() {
        val rose = GildedRose("Aged Brie", 49, 0)
        rose.tick()
        assertEquals(50, rose.quality)
        assertEquals(-1, rose.daysRemaining)
    }

    @Test
    fun testBrieOnSellDateWithMaxQuality() {
        val rose = GildedRose("Aged Brie", 50, 0)
        rose.tick()
        assertEquals(50, rose.quality)
        assertEquals(-1, rose.daysRemaining)
    }

    @Test
    fun testBrieAfterSellDate() {
        val rose = GildedRose("Aged Brie", 40, -1)
        rose.tick()
        assertEquals(42, rose.quality)
        assertEquals(-2, rose.daysRemaining)
    }

    @Test
    fun testBrieAfterSellDateWithMaxQuality() {
        val rose = GildedRose("Aged Brie", 50, -1)
        rose.tick()
        assertEquals(50, rose.quality)
        assertEquals(-2, rose.daysRemaining)
    }

    @Test
    fun testSulfurasBeforeSellDate() {
        val rose = GildedRose("Sulfuras, Hand of Ragnaros", 10, 5)
        rose.tick()
        assertEquals(10, rose.quality)
        assertEquals(5, rose.daysRemaining)
    }

    @Test
    fun testSulfurasOnSellDate() {
        val rose = GildedRose("Sulfuras, Hand of Ragnaros", 10, 0)
        rose.tick()
        assertEquals(10, rose.quality)
        assertEquals(0, rose.daysRemaining)
    }

    @Test
    fun testSulfurasAfterSellDate() {
        val rose = GildedRose("Sulfuras, Hand of Ragnaros", 10, -1)
        rose.tick()
        assertEquals(10, rose.quality)
        assertEquals(-1, rose.daysRemaining)
    }

    @Test
    fun testBackstageLongBeforeSellDate() {
        val rose = GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 20)
        rose.tick()
        assertEquals(11, rose.quality)
        assertEquals(19, rose.daysRemaining)
    }

    @Test
    fun testBackstageMediumCloseToSellDateUpperBound() {
        val rose = GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 10)
        rose.tick()
        assertEquals(12, rose.quality)
        assertEquals(9, rose.daysRemaining)
    }

    @Test
    fun testBackstageMediumCloseToSellDateUpperBoundAtMaxQuality() {
        val rose = GildedRose("Backstage passes to a TAFKAL80ETC concert", 50, 10)
        rose.tick()
        assertEquals(50, rose.quality)
        assertEquals(9, rose.daysRemaining)
    }

    @Test
    fun testBackstageMediumCloseToSellDateLowerBound() {
        val rose = GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 6)
        rose.tick()
        assertEquals(12, rose.quality)
        assertEquals(5, rose.daysRemaining)
    }

    @Test
    fun testBackstageMediumCloseToSellDateLowerBoundAtMaxQuality() {
        val rose = GildedRose("Backstage passes to a TAFKAL80ETC concert", 50, 6)
        rose.tick()
        assertEquals(50, rose.quality)
        assertEquals(5, rose.daysRemaining)
    }

    @Test
    fun testBackstageVeryCloseToSellDateUpperBound() {
        val rose = GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 5)
        rose.tick()
        assertEquals(13, rose.quality)
        assertEquals(4, rose.daysRemaining)
    }

    @Test
    fun testBackstageVeryCloseToSellDateUpperBoundAtMaxQuality() {
        val rose = GildedRose("Backstage passes to a TAFKAL80ETC concert", 50, 5)
        rose.tick()
        assertEquals(50, rose.quality)
        assertEquals(4, rose.daysRemaining)
    }

    @Test
    fun testBackstageVeryCloseToSellDateLowerBound() {
        val rose = GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 1)
        rose.tick()
        assertEquals(13, rose.quality)
        assertEquals(0, rose.daysRemaining)
    }

    @Test
    fun testBackstageVeryCloseToSellDateLowerBoundAtMaxQuality() {
        val rose = GildedRose("Backstage passes to a TAFKAL80ETC concert", 50, 1)
        rose.tick()
        assertEquals(50, rose.quality)
        assertEquals(0, rose.daysRemaining)
    }

    @Test
    fun testBackstageOnSellDate() {
        val rose = GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 0)
        rose.tick()
        assertEquals(0, rose.quality)
        assertEquals(-1, rose.daysRemaining)
    }

    @Test
    fun testBackstageAfterSellDate() {
        val rose = GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, -1)
        rose.tick()
        assertEquals(0, rose.quality)
        assertEquals(-2, rose.daysRemaining)
    }

    @Test
    @Ignore
    fun testConjuredBeforeSellDate() {
        val rose = GildedRose("Conjured", 10, 10)
        rose.tick()
        assertEquals(8, rose.quality)
        assertEquals(9, rose.daysRemaining)
    }

    @Test
    @Ignore
    fun testConjuredOnSellDate() {
        val rose = GildedRose("Conjured", 10, 0)
        rose.tick()
        assertEquals(6, rose.quality)
        assertEquals(-1, rose.daysRemaining)
    }

    @Test
    @Ignore
    fun testConjuredAfterSellDate() {
        val rose = GildedRose("Conjured", 10, -1)
        rose.tick()
        assertEquals(6, rose.quality)
        assertEquals(-2, rose.daysRemaining)
    }

    @Test
    @Ignore
    fun testConjuredOfZeroQuality() {
        val rose = GildedRose("Conjured", 0, 5)
        rose.tick()
        assertEquals(0, rose.quality)
        assertEquals(4, rose.daysRemaining)
    }
}
