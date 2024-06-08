package example3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Superclass
abstract class MutualFund {
	protected double investmentAmount;
	protected double rateOfReturn; // Annual rate of return in percentage

	public MutualFund(double investmentAmount, double rateOfReturn) {
		this.investmentAmount = investmentAmount;
		this.rateOfReturn = rateOfReturn;
	}

	// Abstract method to calculate annual return
	public abstract double calculateAnnualReturn();

	public double getInvestmentAmount() {
		return investmentAmount;
	}

	public double getRateOfReturn() {
		return rateOfReturn;
	}
}

//Subclass for Equity Fund
class EquityFund extends MutualFund {

	public EquityFund(double investmentAmount, double rateOfReturn) {
		super(investmentAmount, rateOfReturn);
	}

	@Override
	public double calculateAnnualReturn() {
		// Assuming rate of return is in percentage
		return investmentAmount * rateOfReturn / 100;
	}
}

//Subclass for Bond Fund
class BondFund extends MutualFund {

	public BondFund(double investmentAmount, double rateOfReturn) {
		super(investmentAmount, rateOfReturn);
	}

	@Override
	public double calculateAnnualReturn() {
		// Assuming rate of return is in percentage
		return investmentAmount * rateOfReturn / 100;
	}
}

//Main class to demonstrate polymorphism
public class MutualFundInterest {
	private static final Logger logger = LogManager.getLogger("example3");

	public static void main(String[] args) {
		MutualFund equityFund = new EquityFund(456700.0, 8.0); // 8% annual return
		MutualFund bondFund = new BondFund(67634.0, 5.0); // 5% annual return

		// Polymorphic behavior
		printAnnualReturn(equityFund, "Equity");
		printAnnualReturn(bondFund, "Bond");
	}

	public static void printAnnualReturn(MutualFund fund, String type) {
		logger.info("Annual Return for the " + type + " fund: Rs."+ String.valueOf(fund.calculateAnnualReturn()));
		

	}
}
