package RunPruebas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import ClaseBase.ClaseBase;
import PagesObjects.PagesObjectsAlerts;
import PagesObjects.PagesObjectsDatePicker;
import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class RunPrueba {

	//CREAR OBJECTO TIPO WEBDRIVER
	private WebDriver driver;
	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;
	ClaseBase clasesBase;
	PagesObjectsAlerts paginasAlerts;
	PagesObjectsDatePicker paginaDatePicker;
	
	@Before
	public void setUp() throws Exception {
		//ARCHIVO DE PROPIEDADES
		propiedades = new Properties();
		
		//INSTANCIAR LA CLASE PAGOBJECT
		leer = new ReadExcelFile();
		escribir = new WriteExcelFile();
		clasesBase = new ClaseBase(driver);
		paginasAlerts = new PagesObjectsAlerts(driver);
		paginaDatePicker = new PagesObjectsDatePicker(driver);
		//CREAR VARIABLE TIPO INPUT STREAM
		InputStream entrada=null;
		
		//VALIDAR SI GENERA  ERROR AL NO ENCONTRAR EL ARCHIVO|
	    
		try {
			
			entrada = new FileInputStream ("./Properties/datos.properties");
			propiedades.load(entrada);	
		    }

		catch(FileNotFoundException e){
			
			e.printStackTrace();
			System.out.println(e);
			
		}
	     
	     
	     //ASIGNAR OPCIONES Y LA CONFG DEL NAVEGADOR A LA VARIABLE DRIVER
		driver= ClaseBase.chromeDriverConnection();
	     
		
	}
	
	
	@Test
	public void tools() throws Exception
	{
		//ACCEDER AL METODO DE ABRIR PAGINA
		paginasAlerts.urlAcceso(leer,propiedades);
		
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
						
		//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = ClaseBase.crearCarpeta(propiedades,nomTest);
				
		// CREAR UNA NUEVA CUENTA
		paginasAlerts.busquedainicial(leer, propiedades,rutaCarpeta);

	}
	
	@Test
	public void DatePicker() throws Exception
	{
		//ACCEDER AL METODO DE ABRIR PAGINA
		paginaDatePicker.urlAcceso(leer,propiedades);
		
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
						
		//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = ClaseBase.crearCarpeta(propiedades,nomTest);
				
		// CREAR UNA NUEVA CUENTA
		paginaDatePicker.DatePicker(leer, propiedades,rutaCarpeta);

	}
	
	@After
	public void cerrar()
	{
		driver.quit();
	}
}
