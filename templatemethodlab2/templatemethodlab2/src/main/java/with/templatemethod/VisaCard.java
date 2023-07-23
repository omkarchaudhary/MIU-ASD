package with.templatemethod;

public class VisaCard extends PaymentProcessor{
	private String creditCardNumber;
	private String customerName;
	private String validDate;
	private int securityCode;

	public VisaCard(String creditCardNumber, String customerName, String validDate, int securityCode) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.customerName = customerName;
		this.validDate = validDate;
		this.securityCode = securityCode;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	@Override
	public boolean validateCard() {
		// logic to validate visa card
		System.out.println("Validate visa card with card number " + getCreditCardNumber());
		return true;
	}



}
