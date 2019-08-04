package filereader;

public class CurrencyConverter {
    private CurrencyConverter()
    {
        // to avoid instantiation
    }


    public static double toUSD(double income, String currency) {
        switch (currency.trim())
        {
            case "USD": return income;
            case "INR": return income / 66;
            case "SGP": return income / 1.5;
            case "HKD": return income / 8;
            case "GBP": return income / .67;
            default: throw new UnsupportedOperationException(
                    String.format("Currency %%s not yet supported%s", currency));
        }
    }
}
