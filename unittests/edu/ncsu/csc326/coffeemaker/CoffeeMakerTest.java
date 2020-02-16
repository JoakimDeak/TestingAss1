package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import junit.framework.TestCase;

/**
 * 
 * @author Sarah Heckman
 *
 * Unit tests for CoffeeMaker class.
 */
public class CoffeeMakerTest extends TestCase {
	
	private CoffeeMaker cm;
	private Inventory inv;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;

	protected void setUp() throws Exception {
		cm = new CoffeeMaker();
		inv = new Inventory();

		//Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("3");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");
		
		//Set up for r2
		r2 = new Recipe();
		r2.setName("Mocha");
		r2.setAmtChocolate("20");
		r2.setAmtCoffee("3");
		r2.setAmtMilk("1");
		r2.setAmtSugar("1");
		r2.setPrice("75");
		
		//Set up for r3
		r3 = new Recipe();
		r3.setName("Latte");
		r3.setAmtChocolate("0");
		r3.setAmtCoffee("3");
		r3.setAmtMilk("3");
		r3.setAmtSugar("1");
		r3.setPrice("100");
		
		//Set up for r4
		r4 = new Recipe();
		r4.setName("Hot Chocolate");
		r4.setAmtChocolate("4");
		r4.setAmtCoffee("0");
		r4.setAmtMilk("1");
		r4.setAmtSugar("1");
		r4.setPrice("65");
		
		super.setUp();
	}
	/*	commented out due to being one of the example tests
	public void testAddInventory() {
		try {
			cm.addInventory("4","7","0","9");
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
	}
	
	public void testAddInventoryException() {
		try {
			cm.addInventory("4", "-1", "asdf", "3");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			//success if thrown
		}
	}*/

	public void testDeleteRecipe() {
		cm.addRecipe(r1);
		assertEquals("Coffee", cm.deleteRecipe(0));
	}

	public void testAddRecipe(){
		assertEquals(true, cm.addRecipe(r3));
	}

	public void testEditRecipe(){
		cm.addRecipe(r1);
		cm.addRecipe(r4);
		assertEquals("Hot Chocolate", cm.editRecipe(1,r4));
	}

	public void testCheckInventory(){
		assertEquals("Coffee: " + 15 + "\n" +
				"Milk: " + 15 + "\n" +
				"Sugar: " + 15 + "\n" +
				"Chocolate: " + 15 + "\n" , cm.checkInventory());
	}
	/*	commented out due to being one of the example tests
	public void testMakeCoffee() {
		cm.addRecipe(r1);
		assertEquals(25, cm.makeCoffee(0, 75));
	}*/

	public void testAddChocolate(){
		try{
			inv.addChocolate("-42");
			fail("Inventory Exception should be thrown when entering negative integer");
		} catch(InventoryException e){

		}

		try{
			inv.addChocolate("E");
			fail("Inventory Exception should be thrown when entering non integer value");
		} catch(InventoryException e ){

		}

	}

	public void testAddCoffee(){
		try{
			inv.addCoffee("-42");
			fail("Inventory Exception should be thrown when entering negative integer");
		} catch(InventoryException e){

		}

		try{
			inv.addCoffee("E");
			fail("Inventory Exception should be thrown when entering non integer value");
		} catch(InventoryException e ){

		}
	}

	public void testAddMilk(){
		try{
			inv.addMilk("-42");
			fail("Inventory Exception should be thrown when entering negative integer");
		} catch(InventoryException e){

		}

		try{
			inv.addMilk("E");
			fail("Inventory Exception should be thrown when entering a non integer value");
		} catch(InventoryException e ){

		}
	}

	public void testAddSugar(){
		try{
			inv.addSugar("-42");
			fail("Inventory Exception should be thrown when entering negative integer");
		} catch(InventoryException e){

		}

		try{
			inv.addSugar("E");
			fail("Inventory Exception should be thrown when entering non integer value");
		} catch(InventoryException e ){

		}
	}

	public void testSetAmtChocolate(){
		try{
			r1.setAmtChocolate("-42");
			fail("Inventory Exception should be thrown when entering negative integer");

		}catch(RecipeException e){

		}try{
			r1.setAmtChocolate("E");
			fail("Inventory Exception should be thrown when entering non integer value");
		} catch(RecipeException e){

		}
	}

	public void testSetAmtCoffee(){
		try{
			r1.setAmtCoffee("-42");
			fail("Inventory Exception should be thrown when entering negative integer");

		}catch(RecipeException e){

		}try{
			r1.setAmtCoffee("E");
			fail("Inventory Exception should be thrown when entering non integer value");
		} catch(RecipeException e){

		}

	}

	public void testSetAmtMilk(){
		try{
			r1.setAmtMilk("-42");
			fail("Inventory Exception should be thrown when entering negative integer");

		}catch(RecipeException e){

		}try{
			r1.setAmtMilk("E");
			fail("Inventory Exception should be thrown when entering non integer value");
		} catch(RecipeException e){

		}
	}

	public void testSetAmtSugar(){
		try{
			r1.setAmtSugar("-42");
			fail("Inventory Exception should be thrown when entering negative integer");

		}catch(RecipeException e){

		}try{
			r1.setAmtSugar("E");
			fail("Inventory Exception should be thrown when entering non integer value");
		} catch(RecipeException e){

		}
	}

	public void testSetPrice(){
		try{
			r1.setPrice("-42");
			fail("Inventory Exception should be thrown when entering negative integer");

		}catch(RecipeException e){

		}try{
			r1.setPrice("E");
			fail("Inventory Exception should be thrown when entering non integer value");
		} catch(RecipeException e){

		}
	}

	public void testEnoughIngredients(){
			boolean ans1 = true;
			boolean val1;
			boolean val2;
			val1 = inv.enoughIngredients(r1);
			assertEquals(ans1,val1);
			val2 = inv.enoughIngredients(r4);
			assertEquals(ans1, val2);
	}

	public void testUseIngredients(){
			boolean ans = false;
			boolean val;
			inv.useIngredients(r1);
			inv.useIngredients(r1);
			inv.useIngredients(r1);
			inv.useIngredients(r1);
			inv.useIngredients(r1);
			inv.useIngredients(r1);
			val = inv.useIngredients(r1);
			assertEquals(ans, val);
	}

}
