import java.util.*;
public class sort_exercise {
	public static void main(String[] args) {
		//array_sort();
		//arrayList_sort();
		Comparable_sort();
		
	}



	//First Method: Sort an array
	//Use Arrays.sort()
	//the order is 	Apple Pineapple banana orange

	public static void array_sort(){
		String[] fruits = new String[]{"Pineapple","Apple","orange","banana"};
		Arrays.sort(fruits);

		int i = 0;
		for(String tmp : fruits) {
			System.out.println(tmp);
		}
	}


	//Second Method: Sort an ArrayList
	//By use Collections.sort()
	public static void arrayList_sort(){
		List<String> fruits = new ArrayList<String>();

		fruits.add("Pineapple");
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Banana");

		Collections.sort(fruits);

		for(String tmp : fruits){
			System.out.println(tmp);
		}
	}

	//Thrid Method: Sort an Object with Comparable

	public static void Comparable_sort(){
		Fruit[] fruits = new Fruit[4];
 
		Fruit pineappale = new Fruit("Pineapple", "Pineapple description",70); 
		Fruit apple = new Fruit("Apple", "Apple description",20); 
		Fruit orange = new Fruit("Orange", "Orange description",80); 
		Fruit banana = new Fruit("Banana", "Banana description",90); 
 
		fruits[0]=pineappale;
		fruits[1]=apple;
		fruits[2]=orange;
		fruits[3]=banana;
 
		Arrays.sort(fruits);
		
 
		int i=0;
		for(Fruit temp: fruits){
		   System.out.println("fruits " + ++i + " : " + temp.getFruitName() + 
			", Quantity : " + temp.getQuantity());
		}

		Arrays.sort(fruits,Fruit.FruitNameComparator);

		i=0;
		for(Fruit temp: fruits){
		   System.out.println("fruits " + ++i + " : " + temp.getFruitName() + 
			", Quantity : " + temp.getQuantity());
		}
	}
}

//Sort an Object with Comparable. Implement Comparable and override compareTo
class Fruit implements Comparable<Fruit>{
	private String fruitName;
	private String fruitDesc;
	private int quantity;

	public Fruit(String fruitName, String fruitDesc, int quantity) {
		super();
		this.fruitName = fruitName;
		this.fruitDesc = fruitDesc;
		this.quantity = quantity;
	}

	public String getFruitName(){
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	public String getFruitDesc() {
		return fruitDesc;
	}
	public void setFruitDesc(String fruitDesc) {
		this.fruitDesc = fruitDesc;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int compareTo(Fruit compareFruit) {
		int compareQuantity = compareFruit.getQuantity();

		//ascending order
		return this.getQuantity() - compareQuantity;

		//descending order
		//return compareQuantity - this.quantity;
	}

	public static Comparator<Fruit> FruitNameComparator = new Comparator<Fruit>() {
		public int compare(Fruit fruit1, Fruit fruit2){
			String fruitName1 = fruit1.getFruitName().toUpperCase();
			String fruitName2 = fruit2.getFruitName().toUpperCase();

			//ascending order
			return fruitName1.compareTo(fruitName2);
		}
	};
}