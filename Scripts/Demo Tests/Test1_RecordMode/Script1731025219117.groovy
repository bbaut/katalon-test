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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://dashboard.develop-integration.itire.mx/#/auth/login')

WebUI.setText(findTestObject('null'), 
    'test@itire.com')

WebUI.setEncryptedText(findTestObject('null'), 
    '5xx1bkCcAlw=')

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.selectOptionByValue(findTestObject('null'), 
    '6612bb2e7d57aee387f344e5', true)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.selectOptionByValue(findTestObject('null'), 
    '6612c9fa7d57aee387f34685', true)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.selectOptionByValue(findTestObject('null'), 
    '6612ee114c82e9694aeef259', true)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.closeBrowser()

