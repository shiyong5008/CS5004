public class Main {
    public static void main(String[] args) {
        DonationsStrategy JustG = new JustGivingStrategyImpl();
        JustG.donaStr("$100");

        DonationsStrategy AppleP = new ApplePayStrategyImpl();
        AppleP.donaStr("$200");


    }
}
