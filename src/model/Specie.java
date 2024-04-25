package model;

public class Specie {

    //Atributos

    private String nameSpecie;

    private TypeSpecie typeSpecie;

    private String pictureSpecie;

    private int quantity;

    public Specie(String nameSpecie, TypeSpecie typeSpecie, String pictureSpecie, int quantity){
        this.nameSpecie = nameSpecie;
        this.typeSpecie = typeSpecie;
        this.pictureSpecie = pictureSpecie;
        this.quantity = quantity;
    }

    //----------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------Getters and Setters-----------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------------------
	

    public String getNameSpecie(){
        return nameSpecie;
    }

    public TypeSpecie getTypeSpecie(){
        return typeSpecie;
    }

    public String getPictureSpecie(){
        return pictureSpecie;
    }

    public int quantity(){
        return quantity;
    }

}
