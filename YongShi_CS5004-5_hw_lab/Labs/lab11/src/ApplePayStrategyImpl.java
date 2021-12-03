public class ApplePayStrategyImpl implements DonationsStrategy {
    @Override
    public void donaStr(String para) {
        System.out.println("Processing " + para + " donation through ApplePay.");
    }
}
