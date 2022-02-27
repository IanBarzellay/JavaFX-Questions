package examsfx.exam2017a93;

public class Converter {
    private static String[] currency = {"USD", "EUR", "GBP", "NIS"};
    private static double[] coinVal = {3.12, 3.6, 5.4, 1};

    public String[] getCurrency() {
        return currency;
    }

    public double convert(String from, String to, double amount){
        double valFrom = 1;
        double valTo = 1;
        for (int i = 0; i < currency.length; i++) {
            if(currency[i].equals(from)){
                valFrom = coinVal[i];
            }
            if(currency[i].equals(to)){
                valTo = coinVal[i];
            }
        }
        return (amount*valFrom)/valTo;
    }

}
