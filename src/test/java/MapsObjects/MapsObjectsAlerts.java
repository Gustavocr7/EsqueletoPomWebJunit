package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClaseBase.ClaseBase;

public class MapsObjectsAlerts extends ClaseBase
{

	public MapsObjectsAlerts(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//ELEMENTOS PAGINA ALERTS
	protected By btnAlertsWindows = By.xpath("//div/h5[text()='Alerts, Frame & Windows']");
	protected By btnAlerts = By.xpath("//*[@id='item-1']/span[text()='Alerts']");
	protected By btn1Alert = By.id("alertButton");
	protected By btn2Alert = By.id("timerAlertButton");
	protected By btn3Alert = By.id("confirmButton");
	protected By btn4Alert = By.id("promtButton");
}
