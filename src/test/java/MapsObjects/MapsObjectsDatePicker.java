package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClaseBase.ClaseBase;

public class MapsObjectsDatePicker extends ClaseBase
{

	public MapsObjectsDatePicker(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//ELEMENTOS PAGINA ALERTS
		protected By btnWidgets = By.xpath("//div/h5[text()='Widgets']");
		protected By btnDatePicker = By.xpath("//*[@id='item-2']/span[text()='Date Picker']");
		protected By btnSelectDate = By.id("datePickerMonthYearInput");
		protected By selectCampoFecha = By.xpath("//select[@class='react-datepicker__month-select']");
		protected By selectFecha = By.xpath("//select[@class='react-datepicker__month-select']/option[8]");
		protected By selectDia = By.xpath("//div[@class='react-datepicker__week']/div[@aria-label='Choose Sunday, August 7th, 2022']");
		protected By btnSelectDateAndTime = By.id("dateAndTimePickerInput");
		protected By selectCampoFecha2 = By.xpath("//div[@class='react-datepicker__month-read-view']");
		protected By selectFecha2 = By.xpath("//div[@class=\"react-datepicker__month-dropdown\"]/div[@class='react-datepicker__month-option'][8]");
		protected By selectDia2 = By.xpath("//div[@class='react-datepicker__week']/div[@aria-label='Choose Sunday, August 7th, 2022']");
		protected By selectHora = By.xpath("//ul[@class='react-datepicker__time-list']/li[text()='14:00']");
		
		//protected By botones = By.xpath("//button[text()='Click me']");
		
}
