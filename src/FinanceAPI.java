public class FinanceAPI {

    private FinanceNetworking networker;

    public FinanceAPI() {
        this.networker = new FinanceNetworking();
    }

    public void quotes(String region, String language, String symbol)
    {
        String response = networker.makeAPICallForQuote(region, language, symbol);
        networker.parseQuote(response);
    }

}