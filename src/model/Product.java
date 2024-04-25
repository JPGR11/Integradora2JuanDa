package model;

public class Product{
	private String nameProduct;
	
	private double porcentageNaturalProducts;
	
	private TypeProduct typeProduct;
	
	private boolean handmade;

	//----------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------Getters---------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------------------

	public String getNameProduct(){
		return nameProduct;
	}

	public double getPorcentageNaturalProducts(){
		return porcentageNaturalProducts;
	}

	public TypeProduct getTypeProduct(){
		return typeProduct;
	}

	public boolean getHandmade(){
		return handmade;
	}
	
	public Product(String nameProduct, double porcentageNaturalProducts, TypeProduct typeProduct, boolean handmade){
		this.nameProduct = nameProduct;
		this.porcentageNaturalProducts = porcentageNaturalProducts;
		this.typeProduct = typeProduct;
		this.handmade = handmade;
	}
	
	public Product createProduct(String nameProduct, double porcentageNaturalProducts, TypeProduct typeProduct, boolean handmade){
		Product product = new Product(nameProduct, porcentageNaturalProducts, typeProduct, handmade);
		return product;
	}
}