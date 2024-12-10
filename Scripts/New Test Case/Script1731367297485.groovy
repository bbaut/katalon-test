import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.BodyContent as HttpTextBodyContent
import com.kms.katalon.core.testobject.HttpHeader as HttpHeader

WebUI.openBrowser(null)

WebUI.navigateToUrl('https://dashboard.develop-integration.itire.mx/')
WebUI.setText(findTestObject('Object Repository/Page_Itire - Gestor de Neumticos/input_Correo Electrnico_email'), 'test@itire.com')
WebUI.setText(findTestObject('Object Repository/Page_Itire - Gestor de Neumticos/input_Contrasea_password'), 'test123')

String username = WebUI.getAttribute(findTestObject('Object Repository/Page_Itire - Gestor de Neumticos/input_Correo Electrnico_email'), 'value')
String password = WebUI.getAttribute(findTestObject('Object Repository/Page_Itire - Gestor de Neumticos/input_Contrasea_password'), 'value')

WebUI.click(findTestObject('Object Repository/Page_Itire - Gestor de Neumticos/div_Continuar'))
WebUI.delay(5)

RequestObject request = new RequestObject()
request.setRestUrl("https://sandbox.api.itire.mx/api/auth/user-auth/login")

HttpHeader contentTypeHeader = new HttpHeader('Content-Type', 'application/json')
HttpHeader apiKeyHeader = new HttpHeader('api-key', '2e24ca2a0fd68b2a66da3fdc9bf0ce1f')

request.setHttpHeaderProperties([contentTypeHeader, apiKeyHeader])

String requestBody = """
{
    "username": "${username}",
    "password": "${password}"
}
"""

request.setBodyContent(new HttpTextBodyContent(requestBody, "UTF-8", "application/json"))

def response = WS.sendRequest(request)

if (response.getStatusCode() == 200) {
	println("Autenticación exitosa.")
} else {
	println("Error en la autenticación. Código de estado: " + response.getStatusCode())
}

// REQUEST YA CREARA EN OBJECT REPOSITORY

//def response = WS.sendRequestAndVerify(findTestObject('Object Repository/Authentication'))
//if (response.getStatusCode() == 201) {
//	println("La respuesta del servidor fue exitosa con código de estado 201.")
//} else {
//	println("Error: El código de estado fue " + response.getStatusCode())
//}

// URL ESPERADA: VERIFICACIÓN DESDE UI

// URL esperada
// String expectedUrl = 'https://dashboard.develop-integration.itire.mx/#/dashboard'

// Obtener la URL actual
// String currentUrl = WebUI.getUrl()

// Verificar si la URL actual coincide con la URL esperada
//if (currentUrl != expectedUrl) {
	// Si no coincide, se genera un error de test
//	WebUI.comment("Error: La URL actual ('${currentUrl}') no coincide con la esperada ('${expectedUrl}')")
//	WebUI.verifyMatch(currentUrl, expectedUrl, false)  // Esto generará un error en el test
//} else {
	// Si la URL coincide, no pasa nada
//	WebUI.comment("La URL actual coincide con la URL esperada.")
//}
// Cerrar el navegador al final del test
WebUI.closeBrowser()