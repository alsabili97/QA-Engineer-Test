import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class CheckoutSteps {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	String expectedAmount = ''
	String ActualAmount = ''

	@Given("I visit URL jam tangan.com")
	def visitURL() {
		WebUI.openBrowser('https://www.jamtangan.com/')
		WebUI.click(findTestObject('Object Repository/Login/Button/button_OKE'))
		WebUI.click(findTestObject('Object Repository/Login/Button/button_Nanti Saja'))
	}
	@And("I login my account")
	def loginAccount() {
		WebUI.click(findTestObject('Object Repository/Login/Button/button_Masuk'))
		WebUI.setText(findTestObject('Object Repository/Login/Set Text/input_EmailNo.Handphone_username'), 'alsabili7697@gmail.com')
		WebUI.setText(findTestObject('Object Repository/Login/Set Text/input_Password_password'), 'Papan123*')
		WebUI.click(findTestObject('Object Repository/Login/Button/button_Masuk_1'))
	}
	@When("I see dashboard jamtangan and click product add to cart")
	def selectProduct() {
		WebUI.click(findTestObject('Object Repository/Checkout Order/Pilih Jam/setText/p_Seiko Prospex SPB101J1 Sumo Baselworld 2019 Automatic 200M Water Resistance Stainless Steel Strap (1)'))
		WebUI.click(findTestObject('Object Repository/Checkout Order/Pilih Jam/Button/button_Beli sekarang'))
		WebUI.click(findTestObject('Object Repository/Checkout Order/Pilih Jam/Button/button_Lanjutkan'))
	}
	@And("I check out Order")
	def checkOutOrder() {
		WebUI.click(findTestObject('Object Repository/Checkout Order/Pilih Pengiriman/Button/button_Pilih Pengiriman'))
		WebUI.click(findTestObject('Object Repository/Checkout Order/Pilih Voucher/setText/li_JNE YES   1 HariRp18.000'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Checkout Order/Pilih Pengiriman/Button/button_Pilih Pembayaran'))
		WebUI.click(findTestObject('Object Repository/Checkout Order/Pilih Voucher/Button/button_Pilih Voucher'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Checkout Order/Pilih Voucher/Button/button_OKE'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Checkout Order/Pilih Voucher/setText/div_Khusus Pengguna BaruMin. Transaksi Rp750.000'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Checkout Order/Pilih Voucher/Button/button_Gunakan'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Checkout Order/Pilih Voucher/Button/button_Pakai Voucher (1)'), FailureHandling.CONTINUE_ON_FAILURE)

		if(WebUI.verifyElementPresent(findTestObject('Object Repository/Batalkan Voucher/setText/p_Virtual Account'), 0)) {

			WebUI.click(findTestObject('Object Repository/Checkout Order/Pilih Voucher/Button/button_Pilih Voucher'))
			WebUI.click(findTestObject('Object Repository/Batalkan Voucher/setText/div_Hingga 23 Apr 2023Batalkan'))
			WebUI.click(findTestObject('Object Repository/Batalkan Voucher/Button/button_Batalkan'))
			WebUI.click(findTestObject('Object Repository/Batalkan Voucher/Button/button_Lanjut Tanpa Voucher'))
		}

		WebUI.click(findTestObject('Object Repository/Checkout Order/Payment/div_Virtual Account'))
		WebUI.click(findTestObject('Object Repository/Checkout Order/Payment/input_Pilih Bank_bank-VABCA'))
		WebUI.click(findTestObject('Object Repository/Checkout Order/Payment/button_order sekarang'))



		//expectedAmount = WebUI.getText(findTestObject('Object Repository/Page_Machtwatch - No.1 Online Watch Store in Indonesia/Previeus Price Rp8.896.712'))
		String totalTagihan = WebUI.getText(findTestObject('Object Repository/Validasi/Previous Price Rp8.896.712'))
		String expectedAmount = totalTagihan.substring(totalTagihan.indexOf("Rp") + 2);
		println expectedAmount
	}

	@Then("Success checkout order")
	def successCheckout() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Validasi/Final Price Rp8.896.712'), 0)

		//ActualAmount = WebUI.getText(findTestObject('Object Repository/Login/Page_Machtwatch - No.1 Online Watch Store in Indonesia/div_Total TagihanRp33.941.113salinPastikan transfer hingga 3 digit terakhir ya'))
		String totalTagihan =  WebUI.getText(findTestObject('Object Repository/Validasi/Final Price Rp8.896.712'))
		String ActualAmount = totalTagihan.substring(totalTagihan.indexOf("Rp") + 2);
		println ActualAmount
	}
	@And("I see amount is same with previous page")
	def compareAmount() {
		WebUI.verifyMatch(ActualAmount, expectedAmount, false)
	}
}