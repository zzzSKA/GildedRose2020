package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
	@Test
	public void exampleTest() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by one
		assertEquals("Failed quality for Dexterity Vest", 19, quality);
	}
	
	@Test
	public void test_nameNotNull() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("testi123", 10, 20));
		
		List<Item> items = inn.getItems();
		String name = items.get(0).getName();
		
		assertNotNull(name);
	}
	
	@Test
	public void test_sellInNotNull() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("testi123", 10, 20));
		
		List<Item> items = inn.getItems();
		int sellIn = items.get(0).getSellIn();
		
		assertNotNull(sellIn);
	}
	
	@Test
	public void test_qualityNotNull() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("testi123", 10, 20));
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertNotNull(quality);
	}
	
	@Test
	public void test_SellInDecreases() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int sellIn = items.get(0).getSellIn();
		
		//assert quality has decreased by one
		assertEquals("Failed sellIn for Dexterity Vest", 9, sellIn);
	}
	
	@Test
	public void test_SellInPassed_QualityDegradesDouble() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("testi123", 1, 10));
		
		inn.oneDay();
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals("testi123", 7, quality);
	}
	
	@Test
	public void test_QualityNeverNegative() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("testi123", 1, 5));
		
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		//Trying to make quality negative
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals("testi123", 0, quality);
	}
	
	@Test
	public void test_AgedBrieQuality() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", -1, 50));
		
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals("testi123", 50, quality);
	}
	
	@Test
	public void test_AgedBrie() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", -5, 5));
		
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals("testi123", 7, quality);
	}
	
	@Test
	public void test_QualityNeverMoreThan50() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", 5, 50));
		
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals("testi123", 50, quality);
	}
	
	@Test
	public void test_LegendaryNeverHasToBeSold() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int sellIn = items.get(0).getSellIn();
		
		assertEquals("testi123", 0, sellIn);
	}
	
	@Test
	public void test_LegendaryNeverDropsQuality() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals("testi123", 80, quality);
	}
	
	@Test
	public void test_BackstagePassesQualityIncreasesBy1() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals("testi123", 21, quality);
	}
	
	@Test
	public void test_BackstagePassesQualityIncreasesBy2() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
		
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals("testi123", 22, quality);
	}
	
	@Test
	public void test_BackstagePassesQualityIncreasesBy3() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
		
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals("testi123", 23, quality);
	}
	
	@Test
	public void test_BackstagePassesQualityDrops0() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
		
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals("testi123", 0, quality);
	}
	
	@Test
	public void test_BackstagePassesQualityNotOver50By2() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49));
		
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals("testi123", 50, quality);
	}
	
	@Test
	public void test_BackstagePassesQualityNotOver50By3() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48));
		
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals("testi123", 50, quality);
	}
	
	@Test
	public void test_LegendaryQuality() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
		
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals("testi123", 80, quality);
	}
}
