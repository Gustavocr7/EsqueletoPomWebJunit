package ClaseBase;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClaseBase 
{
	protected static WebDriver driver;
	
	//CONSTRUCTOR DE CLASE
	public ClaseBase(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//METODO DE NAVEGADOR
	public static WebDriver chromeDriverConnection() 
	{
		//SETEAR LAS OPCIONES DEL NAVEGADOR
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//SETEAR LAS PROPIEDADES DEL NAVEGADOR
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver1.exe");
		driver = new ChromeDriver();
		
		//MAXIMIZAR EL NAVEGADOR 
		driver.manage().window().maximize();
		return driver;
	}
	
	//METODO DEL CLICK
	public void click(By locator, File rutaCarpeta) throws Exception
	{
		captureScreen(rutaCarpeta);
		driver.findElement(locator).click();
		tiempoEspera(2000);
	}
	//METODO BORRAR
	public void borrar(By locator, File rutaCarpeta) throws Exception 
	{   
		driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		//driver.findElement(locator).clear();
		captureScreen(rutaCarpeta);
	}
	//METODO ENVIAR TEXTO
	public void sendkey(String inputText, By locator, File rutaCarpeta) throws Exception
	{
		driver.findElement(locator).sendKeys(inputText);
		captureScreen(rutaCarpeta);
	}
	//METODO ENTER SUBMIN
	public void submit(By locator, File rutaCarpeta) throws Exception
	{
		driver.findElement(locator).submit();
		captureScreen(rutaCarpeta);
	}
	//METODO TIEMPO DE ESPERA
	public void tiempoEspera(long tiempo) throws InterruptedException
	{
		Thread.sleep(tiempo);
	}
	
	//METODO PARA REALIZAR UN SCROLL
	public void scroll(int y,int numMovimientos){
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    for (int i=0; i<=numMovimientos; i++) {
	        js.executeScript("window.scrollBy(0," + y + ")");
	    }
	}
	
	//METODO LISTA
	public List<WebElement> listaElementos(By locator) throws Exception
    {
      
        List<WebElement> elemento=driver.findElements(locator);
        return elemento;
        
    }
	
	
	//METODO DE FECHA MENOS TIEMPO 
	public static String fechaDateWidgets()
	{
		String[] fechaVector=fechaHora().split("-");
		int year=Integer.parseInt(fechaVector[0]);
		int mes=Integer.parseInt(fechaVector[1]);
		int dia=Integer.parseInt(fechaVector[2]);
				
		dia=dia-1;
		mes=mes-1;
		year=year-1;		
				
		String fechaMenor=mes+"/"+dia+"/"+year;
		return fechaMenor;
	}
	
	//METODO CAPTURAR SCREENSHOT
	public void captureScreen(File rutaCarpeta) throws  Exception
	{
		String hora = HoraSistema();
		File ScrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ScrFile, new File(rutaCarpeta+"\\"+hora+".png"));
	}
	
	//CREAMOS LA CARPETA PARA ALMACENAR LOS SCREENSHOT
	public static File crearCarpeta(Properties propiedades, String nomTest)
	{
		//ALMACENAMOS LA FECHA DEL SITEMA
		String fecha = fechaHora();
		//CREAMOS EL NOMBRE DE LA CARPETA
		String nomCarpeta = nomTest+"-"+fecha;
		//OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
		File directorio = new File("./output/"+nomCarpeta);
		//CREAMOS LA CARPETA
		directorio.mkdir();
		return directorio;
	}
	
	//METODO FECHA
	public static String fechaHora()
	{
		//TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		//DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmss");
		//DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}
	
	//METODO HORA
	public String HoraSistema()
	{
		//TOMAMOS LA HORA DEL SISTEMA
		LocalTime horaSistema = LocalTime.now();
		//DEFINIR FORMATO HORA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
		//DAR FORMATO A LA HORA DEL SISTEMA
		String hora = fecha.format(horaSistema);
		return hora;
	}

}