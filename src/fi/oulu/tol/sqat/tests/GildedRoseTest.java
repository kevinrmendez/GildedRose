package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
    
	@Test
	public void testUpdateEndOfDay() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		Item itemBeforeUpdate = new Item("Aged Brie", 2, 10);
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemAfterUpdate = items.get(0);
		
		
		assertTrue(itemBeforeUpdate.getQuality() < itemAfterUpdate.getQuality());
		
	}
	@Test
	public void testGildedRose_SellinValue() {
		Item item = new Item("+5 Dexterity Vest", 10, 20);
		int sellInValue =item.getSellIn();



		assertNotNull(sellInValue);
	}
	@Test
	public void testGildedRose_QualityValue() {
		Item item = new Item("+5 Dexterity Vest", 10, 20);
		int qualityValue =item.getQuality();


		assertNotNull(qualityValue);
	}
	@Test
	public void testGildRose_QuilityValue_NotNegative() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		int qualityValue = item.getQuality();
		
		assertEquals("Quality value never negative", 0, qualityValue);
	}
}
