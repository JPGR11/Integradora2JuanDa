package model;

public class Community{
	
	//Atributos:
	
	private String nameCommunity;
	
	private TypeCommunity typeCommunity;
	
	private String nameRepresentative;
	
	private String phoneRepresentative;
	
	private double quantityHabitants;
	
	private TypeProblem problemsCommunity;
	
	private static Product[] productArray = new Product[20];

	//----------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------Métodos útiles--------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------------------


	//Constructor
	
	public Community(String nameCommunity, TypeCommunity typeCommunity, String nameRepresentative, String phoneRepresentative,double quantityHabitants, TypeProblem problemsCommunity){
		this.nameCommunity = nameCommunity;
		this.typeCommunity = typeCommunity;
		this.nameRepresentative = nameRepresentative;
		this.phoneRepresentative = phoneRepresentative;
		this.quantityHabitants = quantityHabitants;
		this.problemsCommunity = problemsCommunity;
	}

	//Productos:

	public Product createProduct(String nameProduct, double porcentageNaturalProducts, TypeProduct typeProduct, boolean handmade){
		Product product = new Product( nameProduct, porcentageNaturalProducts, typeProduct, handmade);
		return product;
	}

	public void addProduct(Product producto){
		for (int i = 0; i < productArray.length; i++) {
            if (productArray[i] == null) {
                productArray[i] = producto;
                break;
            }
        }
	}

	public String showProduct(){
		for (int i = 0; i < productArray.length; i++) {
            if (productArray[i] != null) {
                return productArray[i].getNameProduct();
            }
        }return "";
	}

	public void searchProduct(String nameProduct){
		for (int i = 0; i < productArray.length; i++) {
            if (productArray[i].getNameProduct().equalsIgnoreCase(nameProduct)) {
                productArray[i] = null;
            }
        }
	}

	//----------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------Getters---------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------------------
	
	
	public String getCommunityName(){
		return nameCommunity;
	}

	public TypeCommunity getTypeCommunity(){

		return typeCommunity;
	}

	public String getNameRepresentative(){

		return nameRepresentative;
	}

	public String getPhoneRepresentative(){
		return phoneRepresentative;
	}

	public double getQuantityHabitants(){
		return quantityHabitants;
	}

	public TypeProblem getProblemsCommunity(){
		return problemsCommunity;
	}
	
}