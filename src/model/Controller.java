package model;
import model.*;

import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;


public class Controller{
	
	private Place[] placesArray = new Place[200];
	
	private Community[] communityArray = new Community[200];

	public String showCommunities() {
        String comunidadPrueba = "";
        for (int i = 0; i < communityArray.length; i++) {
            if (communityArray[i] != null) {
                comunidadPrueba = communityArray[i].getCommunityName();
				return comunidadPrueba;
            }
        }return "";
    }

	//Mostrar comunidades

	public int obtenerCantidadComunidades() {
		int contadorComunidadesVerdaderas = 0;
		for (int i = 0; i < communityArray.length; i++) {
            if (communityArray[i] != null) {
                contadorComunidadesVerdaderas++;
            }
        }
		return contadorComunidadesVerdaderas;
	}

	public String listarComunidad(int indice) {
        if (indice >= 0 && indice < communityArray.length && communityArray[indice] != null) {
            Community community = communityArray[indice];
            return "Nombre de la comunidad: " + community.getCommunityName() + "\n" +
                   "Cantidad de habitantes: " + community.getQuantityHabitants();
        } else {
            return "";
        }
    }

	public void deleteProduct(String nameProduct, Community community){
		community.searchProduct(nameProduct);
	}

	public void showProduct(Community community){
		System.out.println(community.showProduct());
	}

	public Place searchPlace(String name) {
    for (int i = 0; i < placesArray.length; i++) {
        if (placesArray[i] != null && placesArray[i].getName().equals(name)) {
            return placesArray[i];
        }
    }
    return null;
	}

	public String showPlace(){
		for(int i = 0; i < placesArray.length; i++){
			if(placesArray[i] != null){
				return "Nombre del lugar: " + placesArray[i].getName();
			}
		}
		return "";
	}

	public void asociarProductoConComunidad(String nameProduct, double porcentageNaturalProducts, TypeProduct typeProduct, boolean handmade, Community community){
		community.addProduct(community.createProduct(nameProduct, porcentageNaturalProducts, typeProduct, handmade));
	}

	//Asocia/ envia la especie al lugar.

	public void asociateSpecieToPlace(String nameSpecie, TypeSpecie typeSpecie, String pictureSpecie , int quantitySpecie, Place place){
		place.addSpecie(place.createSpecie(nameSpecie, typeSpecie, pictureSpecie, quantitySpecie));
	}

	public boolean chequeoNombreDeLugar(String nombrePosible) {
		boolean existe = false;
		for (int i = 0; i < placesArray.length; i++) {
            if (placesArray[i] != null) {
				existe = placesArray[i].getName().equalsIgnoreCase(nombrePosible);
            }
        }
		return existe;
	}
	
	public boolean uniqueCommunity(String community) {
        for (int i = 0; i < communityArray.length; i++) {
            if (communityArray[i] != null && communityArray[i].getCommunityName().equalsIgnoreCase(community)) {
                return false;
            } else if(communityArray[0] == null){
				return true;
			}
        }
        return true;
    }

	public Community searchCommunity(String community) {
        for (int i = 0; i < communityArray.length; i++) {
            if (communityArray[i] != null && communityArray[i].getCommunityName().equalsIgnoreCase(community)) {
                return communityArray[i];
            }
        }
        return null;
    }

	//----------------------------------------------------------------------------------------------------------------------------
	//---------------------------------------------Creación de objetos------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------------------
	
	public Place createPlace(String name, NameDepartment nameDepartment, double size, TypeArea typeArea, Calendar inagurationDate, String picturePlace, double economicR){
		Place place = new Place(name, nameDepartment, size, typeArea, inagurationDate, picturePlace, economicR);
		return place;
	}
	
	public Community createCommunity(String nameCommunity, TypeCommunity typeCommunity, String nameRepresentative, String phoneRepresentative,double quantityHabitants, TypeProblem problemsCommunity){
		Community community = new Community(nameCommunity, typeCommunity, nameRepresentative, phoneRepresentative, quantityHabitants, problemsCommunity);
		return community;
	}
	
	//----------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------Getters y setters---------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------------------
	
	public Community[] getCommunityArray() {
        return communityArray;
    }

	public Place[] getPlacesArray() {
        return placesArray;
    }
	
	//----------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------Agregar datos a los arreglos------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------------------
	
	public void addPlace(Place place) {
        for (int i = 0; i < placesArray.length; i++) {
            if (placesArray[i] == null) {
                placesArray[i] = place;
                break;
            }
        }
    }
	
	public void addCommunity(Community community) {
        for (int i = 0; i < communityArray.length; i++) {
            if (communityArray[i] == null) {
                communityArray[i] = community;
                break;
            }
        }
    }
	
	//----------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------Enumeraciones-----------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------------------

	public TypeSpecie tipoEspecie(int decision){
		TypeSpecie tipoEspecie = TypeSpecie.FLORA;
		switch(decision){
			case 1:
			tipoEspecie = TypeSpecie.FLORA;
			break;

			case 2:
			tipoEspecie = TypeSpecie.FAUNA;
			break;

			default:
			System.out.println("Opción no válida, vuelve a intentarlo.");
			break;
		}
		return tipoEspecie;
	}
	
	public TypeCommunity tipoComunidad(int decision){
		TypeCommunity tipoComunidad = TypeCommunity.AFROCOLOMBIANA;
		switch(decision){
			case 1:
				tipoComunidad = TypeCommunity.AFROCOLOMBIANA;
			break;
						 
			case 2:
				tipoComunidad = TypeCommunity.RAIZAL;				
			break;
						
			case 3:
				tipoComunidad = TypeCommunity.INDIGENA;
			break;
						
			default:
				System.out.println("Opción no válida.");
			break;
						
		}
		return tipoComunidad;
	}
	
	public TypeProblem problemEnum(int decision){
    TypeProblem problemChose = TypeProblem.HOSPITAL;
    switch(decision){
        case 1:
            problemChose = TypeProblem.HOSPITAL;
            break;
            
        case 2:
            problemChose = TypeProblem.SCHOOL;
            break;
            
        case 3:
            problemChose = TypeProblem.WATER;
            break;
        
        case 4:
            problemChose = TypeProblem.FOOD;
            break;
            
        default:
            System.out.println("Opción no válida.");
            break;
    }
    return problemChose;
	}

	
	public TypeProduct tipoProducto(int decision){
		TypeProduct typeProduct = TypeProduct.FOOD;
		switch(decision){
			case 1:
			typeProduct = TypeProduct.FOOD;
			break;
						 
			case 2:
			typeProduct = TypeProduct.CRAFTS;
			break;
						
			default:
			System.out.println("Opción no válida.");
			break;
		}
		return typeProduct;
	}

	public TypeArea typeArea(int decision){
		TypeArea typeAreaM = TypeArea.PROTEGIDA;
		switch(decision){
			case 1:
			typeAreaM = TypeArea.PROTEGIDA;
			break;

			case 2:
			typeAreaM = TypeArea.PARQUE_NACIONAL;
			break;

			case 3:
			typeAreaM = TypeArea.PRIVADA;
			break;

			default:
			System.out.println("Opción no válida, por favor intentar otra vez.");
			break;
		}
		return typeAreaM;

	}

	public NameDepartment nameDepartment(int decision){
		NameDepartment nameDepartment = NameDepartment.CHOCO;
		switch(decision){
			case 1:
			nameDepartment = NameDepartment.CHOCO;
			break;

			case 2:
			nameDepartment = NameDepartment.VALLE;
			break;

			case 3:
			nameDepartment = NameDepartment.CAUCA;
			break;

			case 4:
			nameDepartment = NameDepartment.NARIÑO;
			break;

			default:
			System.out.println("Opción no válida, por favor intentar otra vez.");
			break;
		}
		return nameDepartment;

	}
	
	public boolean handmade(int decision){
		boolean handmade = false;
		switch(decision){
		case 1:
		handmade = true;
		break;
						 
		case 2:
		handmade = false;
		break;
				
		default:
		System.out.println("Opción no válida.");
		break;
		}
		return handmade;
	}

	
}