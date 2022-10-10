package PagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import MapsObjects.MapsObjectsDatePicker;
import utilidadesExcel.ReadExcelFile;

public class PagesObjectsDatePicker extends MapsObjectsDatePicker
{

	public PagesObjectsDatePicker(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	//METODO INICIAL
		public void urlAcceso(ReadExcelFile leer, Properties propiedades) throws IOException
		{
			driver.get(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Tools", 1, 2));
			//BusquedaInicial();
		}
		
		//METODO PRIMERA PRUEBA 
		/*public void DatePicker(ReadExcelFile leer,Properties propiedades, File rutaCarpeta) throws Exception 
		{
						
			try {
					
				JavascriptExecutor js = (JavascriptExecutor) driver;
				// REALIZAR SROLL 
				js.executeScript("window.scrollBy(0,300)");
				//SELECCIONAR EL BOTON WIDGETS 
				click(btnWidgets, rutaCarpeta);
				// REALIZAR SROLL
				js.executeScript("window.scrollBy(0,300)");
				//SELECCIONAR EL BOTON DATEPICKER
				click(btnDatePicker, rutaCarpeta);
				//SELECCIONAR EL INPUT SELECT DATE
				click(btnSelectDate, rutaCarpeta);
				//SELECCIONAR EL SELECT DE FECHA
				click(selectCampoFecha, rutaCarpeta);
				//SELECCIONAR LA FECHA 
				click(selectFecha, rutaCarpeta);
				//SELECCIONAR EL DIA
				click(selectDia, rutaCarpeta);
				//SELECCIONAR EL INPUT DATE AND TIME
				click(btnSelectDateAndTime, rutaCarpeta);
				//SELECCIONAR EL SELECT DE FECHA
				click(selectCampoFecha2, rutaCarpeta);
				//SELECCIONAR LA FECHA 
				click(selectFecha2, rutaCarpeta);
				//SELECCIONAR EL DIA 
				click(selectDia2, rutaCarpeta);
				//SELECCIONAR LA HORA 
				click(selectHora, rutaCarpeta);
				//TIEMPO DE ESPERA
				tiempoEspera(3000);
				}catch(InterruptedException e){
					
					System.out.println(e);
					
				}
			}*/
		
		public void DatePicker(ReadExcelFile leer,Properties propiedades, File rutaCarpeta) throws Exception 
		{
						
			try {
					
				JavascriptExecutor js = (JavascriptExecutor) driver;
				// REALIZAR SROLL 
				js.executeScript("window.scrollBy(0,300)");
				//SELECCIONAR EL BOTON WIDGETS 
				click(btnWidgets, rutaCarpeta);
				// REALIZAR SROLL
				js.executeScript("window.scrollBy(0,300)");
				//SELECCIONAR EL BOTON DATEPICKER
				click(btnDatePicker, rutaCarpeta);
				//SELECCIONAR EL INPUT SELECT DATE
				click(btnSelectDate, rutaCarpeta);
				//BORRAR CAMPO
				borrar(btnSelectDate, rutaCarpeta);
				//TIEMPO DE ESPERA
				tiempoEspera(3000);
				//ESCRIBIR EN EL CAMPO SELECT DATE
				sendkey(fechaDateWidgets(), btnSelectDate, rutaCarpeta);
				//BORRAR CAMPO
				borrar(btnSelectDateAndTime, rutaCarpeta);
				//TIEMPO DE ESPERA
				tiempoEspera(3000);
				//ESCRIBIR EN EL CAMPO SELECT DATE AND TIME
				sendkey(fechaDateWidgets(), btnSelectDateAndTime, rutaCarpeta);
				
				
				
				}catch(InterruptedException e){
					
					System.out.println(e);
					
				}
			}

}
