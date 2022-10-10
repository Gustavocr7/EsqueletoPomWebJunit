package PagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import MapsObjects.MapsObjectsAlerts;
import utilidadesExcel.ReadExcelFile;

public class PagesObjectsAlerts extends MapsObjectsAlerts
{

	public PagesObjectsAlerts(WebDriver driver) {
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
		public void busquedainicial(ReadExcelFile leer,Properties propiedades, File rutaCarpeta) throws Exception 
		{
					
			try {
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
			    // REALIZAR SROLL 
			    js.executeScript("window.scrollBy(0,200)");
				//SELECCIONAR EL BOTON ALERT, FRAME  
				click(btnAlertsWindows, rutaCarpeta);
				// REALIZAR SROLL
				js.executeScript("window.scrollBy(0,200)");
				//SELECCIONAR EL BOTON ALERTS
				click(btnAlerts, rutaCarpeta);
				// REALIZAR SROLL 
			    js.executeScript("window.scrollBy(0,200)");
				//SELECCIONAR EL PRIMER BOTON 
				click(btn1Alert, rutaCarpeta);
				//SELECCIONAR ACEPTAR
				driver.switchTo().alert().dismiss();
				//SELECCIONAR EL SEGUNDO BOTON 
				click(btn2Alert, rutaCarpeta);
				//TIEMPO DE ESPERA
				tiempoEspera(6000);
				//SELECCIONAR ACEPTAR
				driver.switchTo().alert().dismiss();
				//SELECCIONAR EL TERCER BOTON
				click(btn3Alert, rutaCarpeta);
				//SELECCIONAR ACEPTAR
				driver.switchTo().alert().accept();
				//SELECCIONAR EL TERCER BOTON 
				click(btn3Alert, rutaCarpeta);
				//SELECCIONAR CANCELAR
				driver.switchTo().alert().dismiss();
				//SELECCIONAR EL CUARTO BOTON
				click(btn4Alert, rutaCarpeta);
				//SELECCIONAR EL CAMPO INPUT
				driver.switchTo().alert().sendKeys("Gustavo");
				//SELECCIONAR ACEPTAR
				driver.switchTo().alert().accept();
				//REALIZAR SCREENSHOT
				captureScreen(rutaCarpeta);
				//TIEMPO DE ESPERA
				tiempoEspera(3000);
			}catch(InterruptedException e){
				
				System.out.println(e);
				
			}
		}
}
