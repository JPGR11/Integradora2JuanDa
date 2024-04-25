package model;

import java.util.Calendar;
import java.text.SimpleDateFormat;


public class Place{
	
	//Atributos Place
	
	private String namePlace;
	
	private NameDepartment nameDepartment;
	
	private double sizeSquareKilometers;

	private TypeArea typeArea;

	private Calendar inagurationDate;
	
	private String placePicture;
	
	private double economicResources;

	private Calendar inaugurationDate;


	private Specie[] specieArray;
	
	public Place(String name, NameDepartment nameDepartment, double size, TypeArea typeArea, Calendar inaugurationDate, String picture, double money) {
        namePlace = name;
        this.nameDepartment = nameDepartment;
        this.typeArea = typeArea;
        this.inaugurationDate = inaugurationDate;
        sizeSquareKilometers = size;
        placePicture = picture;
        economicResources = money;
    }

	public Specie createSpecie(String nameSpecie, TypeSpecie typeSpecie, String pictureSpecie, int quantity){
		Specie specie = new Specie(nameSpecie, typeSpecie, pictureSpecie, quantity);
		return specie;
	}

	//Metodos de especie

	public void addSpecie(Specie specie){
		for(int i = 0; i < specieArray.length; i++ ){
			if(specieArray[i] == null){
				specieArray[i] = specie;
				break;
			}
		}
	}

	//----------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------Getters---------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------------------
	
	public String getName(){
		return namePlace;
	}

	public NameDepartment getNombreDepartment(){
		return nameDepartment;
	}

	public TypeArea typeArea(){
		return typeArea;
	}
	
	public double getArea(){
		return sizeSquareKilometers;
	}

	public String getInaugurationDate() {
        // Formatear la fecha utilizando SimpleDateFormat
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(inaugurationDate.getTime());
    }

	public void setInaugurationDate(Calendar inaugurationDate) {
        this.inaugurationDate = inaugurationDate;
    }

    public Calendar getInaugurationDateCalendar() {
        return inaugurationDate;
    }

	public double geteconomicResourcesNeeded(){
		return economicResources;
	}

	public String getPicture(){
		return placePicture;
	}

	public Calendar getInagurationDate(){
		return inagurationDate;
	}

	//----------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------Setters-------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------------------
	
	public void setName(String namePlace){
		this.namePlace = namePlace;
	}
	
	public void setArea(double sizeSquareKilometers){
		this.sizeSquareKilometers = sizeSquareKilometers;
	}
	
	public void setPicture(String placePicture){
		this.placePicture = placePicture;
	}
	
	public void setEconomicResourcesNeeded(double economicResources){
		this.economicResources = economicResources;
	}
	
}