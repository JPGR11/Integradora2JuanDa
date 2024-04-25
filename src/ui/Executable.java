package ui;
import model.Controller;
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;


public class Executable{
	
	private Scanner entrada;
	private Controller cont;
	private static boolean flag;
	
	public Executable(){
		entrada = new Scanner(System.in);
		cont = new Controller();
	}
	
	public static void main(String[] args) {
		Executable mainApp = new Executable();
		mainApp.run(flag);
	}
	
	public void run(boolean flag){
		flag = false;
		while(!flag){
			switch(typeMenu()){
				case 1: 
				erase();
				funcionesAdminstrador();
				break;
				
				case 2:
				erase();
				menuConsultor();
				break;
				
				case 3:
				flag = true;
				break;
				
				default:
				System.out.println("Opción no válida.");
				break;
			}
		}
	}
	//-------------------------------------------------------------Menú--------------------------------------------------------------------------
	
	/**
	*Descripción: Permite escoger la opción a la que se desea ingresar.
	*@return int entrada para escoger que tipo de menú se desea acceder.
	*/
	
	public int typeMenu(){
		linea();
		System.out.println("---------------Bienvenido al sistema de la COP16--------------------");
		linea();
		System.out.println("¿A cuál menú deseas ingresar?");
		linea();
		System.out.println("[1] Administrador.");
		System.out.println("[2] Consultor.");
		System.out.println("[3] Salir.");
		linea();
		return entrada.nextInt();
	}
	
	/**
	*Descripción: Muestra el menu principal.
	*@return entrada.
	*/
	
	public int menu(){
		linea();
		System.out.println("-----------------------Menú administrador---------------------------");
		linea();
		System.out.println("¿Qué deseas hacer?");
		linea();
		System.out.println("[1] Registrar un lugar.\n" + "[2] Registrar comunidad.\n" + "[3] Registrar producto en una comunidad.\n" +  "[4] Registrar especie.\n" + "[5] Eliminar un producto.\n" + "[6] Salir.");
		linea();
		return entrada.nextInt();
	}
	
	public int menuConsultor(){
		linea();
		System.out.println("---------------------------Menú consultor---------------------------");
		linea();
		System.out.println("¿Qué deseas hacer?");
		linea();
		System.out.println("[1] Consultar un lugar.\n" + "[2] Consultar información de las comunidades de un departamento.\n" + "[3] Consultar información de las comunidades con problemas con escuelas u hospitales\n" + "[4] Consultar nombre del lugar con mayor cantidad de especies.\n" + "[5] Consultar los tres lugares más grandes por kilometro cuadrado.\n" + "[6] Modificar los datos de una especie.\n" + "[7] Salir.");
		return entrada.nextInt();
	}

	/**
	*Descripción: Tiene las funciones del menú de administrador.
	*/
	
	public void funcionesAdminstrador(){
		boolean sw =  false;
		do{
			switch(menu()){
				case 1: 
				erase();
				registerPlace();
				break;
				
				case 2:
				erase();
				registerCommunity();
				break;
				
				case 3:
				erase();
				registerProduct();
				break;

				case 4:
				erase();
				registerSpecie();
				break;

				case 5:
				erase();
				deleteProduct();
				break;

				case 6:
				erase();
				
				break;
				
				case 7:
				erase();
				sw = true;
				break;
				
				default:
				System.out.println("Opción no válida.");
				break;
			}
		}while(sw == false);
	}
	
	public void erase(){
		System.out.print("\033[H\033[2J");  
		System.out.flush(); 
	}

	//----------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------Menú admin--------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------------------

	//Registrar lugar

	public void registerPlace(){
		linea();
		System.out.println("--------------------------Ingresar Lugar----------------------------");
		linea();
		System.out.println("Introduzca el nombre del lugar: ");
		entrada.nextLine();
		String namePlace = entrada.nextLine();

		//Verificación de que el nombre del lugar sea unico.

		while(cont.chequeoNombreDeLugar(namePlace)){
			System.out.println("Introduzca otro nombre del lugar que no esté registrado: ");
			entrada.nextLine();
			namePlace = entrada.nextLine();
		}

		System.out.println("Ingrese el departamento al que pertenece: \n" + "[1] Choco.\n" + "[2] Valle.\n" + "[3] Cauca.\n" + "[4] Nariño.");
		int nameDepartment = entrada.nextInt();
		System.out.println("Introduzca el área en Km^2: ");
		double areaPlace = entrada.nextDouble();
		entrada.nextLine();
		System.out.println("Ingrese el tipo de área: \n" + "[1] Área protegida.\n" + "[2] Parque nacional.\n" + "[3] Área privada.");
		int typeArea = entrada.nextInt();
		entrada.nextLine();
		System.out.println("Introduzca la cantidad de recursos económicos necesarios (USD): ");
		double moneyNeeded = entrada.nextDouble();
		entrada.nextLine();
		System.out.println("Introduzca la URL de la imagen del lugar: ");
		String pictureUrl = entrada.nextLine();
		Calendar inaugurationDate = ingresarFechaInauguracion();

		// Verificar si la fecha de inauguración es válida
		if (inaugurationDate != null) {
			// Verificar si el lugar ya existe
			if (cont.searchPlace(namePlace) == null) {
				// Si no existe, agregar el nuevo lugar con la fecha de inauguración
				cont.addPlace(cont.createPlace(namePlace, cont.nameDepartment(nameDepartment), areaPlace, cont.typeArea(typeArea), inaugurationDate, pictureUrl, moneyNeeded));
				System.out.println("¡Lugar registrado con éxito!");
			}
		}

	}

	//Registrar comunidad

	public void registerCommunity(){
		linea();
		System.out.println("--------------------------Ingresar Comunidad------------------------");
		linea();
		System.out.println("Introduzca el nombre de la comunidad: ");
		entrada.nextLine();
		String nameCommunity = entrada.nextLine();
		System.out.println("¿Qué tipo de comunidad es?\n" + "[1]Afrocolombiana.\n" + "[2]Raizal.\n" + "[3]Indigena\n");
		int typeCommunity = entrada.nextInt();
		entrada.nextLine();
		System.out.println("Introduzca el nombre del representante: ");
		String nameRepresentative = entrada.nextLine();
		System.out.println("Introduzca el telefono del representante: ");
		String phoneRepresentative = entrada.nextLine();
		System.out.println("Introduzca la cantidad de habitantes: ");
		double quantityHabitants = entrada.nextDouble();
		entrada.nextLine();
		System.out.println("¿Qué tipo de problema tiene la comunidad? \n" + "[1] Problemas de hospital. \n" + "[2] Problemas de colegios. \n" + "[3] Problemas de agua potable. \n" + "[4] Problemas de comida.");
		int typeProblem = entrada.nextInt();

		if(cont.uniqueCommunity(nameCommunity) == true){
			cont.addCommunity(cont.createCommunity(nameCommunity, cont.tipoComunidad(typeCommunity), nameRepresentative, phoneRepresentative, quantityHabitants, cont.problemEnum(typeProblem)));
			System.out.println("¡Comunidad registrada con exito!");
		} else if(cont.uniqueCommunity(nameCommunity)== false){
			System.out.println("La comunidad ya existe en este lugar, por favor intentelo otra vez.");
		}
	}

	//Registrar producto

	public void registerProduct(){
		linea();
		System.out.println("------------------------Ingresar Producto---------------------------");
		linea();
		System.out.println("Introduzca el nombre del producto: ");
		entrada.nextLine();
		String nameProduct = entrada.nextLine();
		System.out.println("Introduzca el porcentaje de productos naturales: ");
		double percentage = entrada.nextDouble();
		entrada.nextLine();
		System.out.println("¿Qué tipo de producto es?\n" + "[1] Comida.\n" + "[2] Artesanias.");
		int tipoProductoDecision = entrada.nextInt();
		System.out.println("¿Es hecho a mano? \n" + "[1] Si.\n" + "[2] No.\n");
		int handmadeDecision = entrada.nextInt();
		entrada.nextLine();

		for(int i = 0; i <= cont.obtenerCantidadComunidades(); i++) {
			String impresionComunidad = cont.listarComunidad(i);
			if(impresionComunidad != "") {
				linea();
				System.out.println("Comunidad " + (i+1) + ": "); 
				System.out.println(impresionComunidad);
				linea();
			} else {
				break;
			}
			
		}

		System.out.println("Introduzca la comunidad a la que quiere asociar este producto: ");
		String comunidad = entrada.nextLine();

		/*Verification for already registered community.
		* In case it exists it is going to register the product.
		*/

		if(cont.searchCommunity(comunidad) != null){
			cont.asociarProductoConComunidad(nameProduct, percentage, cont.tipoProducto(tipoProductoDecision), cont.handmade(handmadeDecision), cont.searchCommunity(comunidad));
			System.out.println("¡Producto registrado con exito!");
		} else if(cont.searchCommunity(comunidad) == null){
			System.out.println("No existe comunidad con aquel nombre, por favor intentelo de nuevo.");
		}
	}

	//Registrar especie

	public void registerSpecie(){
		linea();
		System.out.println("------------------------Ingresar Especie---------------------------");
		linea();
		System.out.println("Introduzca el nombre de la especie: ");
		entrada.nextLine(); // Limpiar buffer
		String nameSpecie = entrada.nextLine();
		System.out.println("Introduzca el tipo de especie: \n" + "[1] Flora.\n" + "[2] Fauna.");
		int typeSpecie = entrada.nextInt();
		entrada.nextLine();
		System.out.println("Introduzca la ruta de acceso a la foto de la especie: ");
		String pictureSpecie = entrada.nextLine();
		System.out.println("Introduzca la cantidad de ejemplares en el lugar: ");
		int quantitySpecie = entrada.nextInt();
		System.out.println("Introduzca el lugar al que pertenece: ");
		System.out.println("--------------------------------------------------------------------" + cont.showPlace() + "--------------------------------------------------------------------");
		String namePlace = entrada.nextLine();
		if(cont.searchPlace(namePlace) != null){
		cont.asociateSpecieToPlace(nameSpecie, cont.tipoEspecie(typeSpecie) , pictureSpecie ,quantitySpecie, cont.searchPlace(namePlace));
		} else if(cont.searchPlace(namePlace) == null){
			System.out.println("El lugar deseado no ha sido registrado.");
		}
	}

	//Borrar producto

	public void deleteProduct(){
		linea();
		System.out.println("-------------------------Borrar producto-----------------------------");
		linea();
		entrada.nextLine();
		System.out.println("Ingrese el nombre de la comunidad de la cual desea borrar un producto: ");
		String nameCommunity = entrada.nextLine();
		cont.showProduct(cont.searchCommunity(nameCommunity));
		System.out.println("Ingrese el producto que desea borrar: ");
		String nameProduct = entrada.nextLine();

		if(cont.searchCommunity(nameCommunity) != null){
			cont.deleteProduct(nameProduct, cont.searchCommunity(nameCommunity));
		} else if(cont.searchCommunity(nameCommunity) != null){
			System.out.println("No existe comunidad con aquel nombre, por favor intentelo de nuevo.");
		}
		
	}

	//Fecha

	public Calendar ingresarFechaInauguracion() {
		System.out.println("Introduzca la fecha de inauguración (dd-MM-yyyy): ");
		String fechaInauguracionString = entrada.nextLine();
	
		// Crear un objeto SimpleDateFormat para analizar la fecha
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Calendar calendar = Calendar.getInstance();
	
		try {
			// Analizar la cadena de fecha y establecerla en el Calendar
			calendar.setTime(dateFormat.parse(fechaInauguracionString));
		} catch (Exception e) {
			System.out.println("Formato de fecha incorrecto. Inténtalo de nuevo.");
			// Si hay un error al analizar la fecha, devolver null
			return null;
		}
	
		return calendar;
	}

	//Linea decoración

	public void linea(){
		System.out.println("--------------------------------------------------------------------");
	}

}