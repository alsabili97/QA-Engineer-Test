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

WebUI.openBrowser('https://www.jamtangan.com/')

WebUI.click(findTestObject('Object Repository/Login/Button/button_OKE'))

WebUI.click(findTestObject('Object Repository/Login/Button/button_Nanti Saja'))

WebUI.click(findTestObject('Object Repository/Login/Button/button_Masuk'))

WebUI.setText(findTestObject('Object Repository/Login/Set Text/input_EmailNo.Handphone_username'), 'alsabili7697@gmail.com')

WebUI.click(findTestObject('Object Repository/Login/Set Text/input_EmailNo.Handphone_username'))

WebUI.click(findTestObject('null'))

WebUI.setText(findTestObject('Object Repository/Login/Set Text/input_Password_password'), 'Papan123*')

WebUI.click(findTestObject('Login/Button/button_Masuk_1'))

WebUI.click(findTestObject('Checkout Order/Pilih Jam/setText/p_Seiko Prospex SPB101J1 Sumo Baselworld 2019 Automatic 200M Water Resistance Stainless Steel Strap'))

WebUI.click(findTestObject('Checkout Order/Pilih Jam/Button/button_Beli sekarang'))

WebUI.click(findTestObject('Page_Machtwatch - No.1 Online Watch Store in Indonesia/button_Lanjutkan'))

WebUI.click(findTestObject('Page_Machtwatch - No.1 Online Watch Store in Indonesia/button_Pilih Pengiriman'))

WebUI.click(findTestObject('Page_Machtwatch - No.1 Online Watch Store in Indonesia/li_JNE YES   1 HariRp18.000'))

WebUI.click(findTestObject('Page_Machtwatch - No.1 Online Watch Store in Indonesia/button_Pilih Pembayaran'))

WebUI.click(findTestObject('Checkout Order/Pilih Voucher/Button/button_Pilih Voucher'))

WebUI.click(findTestObject('Checkout Order/Pilih Voucher/Button/button_OKE'))

WebUI.click(findTestObject('Checkout Order/Pilih Voucher/setText/div_Ekstra Diskon Rp100 RibuMin. Transaksi Rp1.500.000'))

WebUI.click(findTestObject('Checkout Order/Pilih Voucher/Button/button_Gunakan'))

WebUI.click(findTestObject('Checkout Order/Pilih Voucher/Button/button_Pakai Voucher (1)'))

WebUI.click(findTestObject('Checkout Order/Payment/div_Virtual Account'))

WebUI.click(findTestObject('Checkout Order/Payment/input_Pilih Bank_bank-VABCA'))

WebUI.click(findTestObject('Page_Machtwatch - No.1 Online Watch Store in Indonesia/button_order sekarang'))

WebUI.closeBrowser()

