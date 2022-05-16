import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FinanceNetworking {

    private String baseUrl;
    private String apiKey;

    public FinanceNetworking()
    {
        baseUrl = "https://yfapi.net";
        apiKey = "vlaum1Zc2k1m7j5sRP53M6ePLqyuOix94Nzwycgu";
    }

    public String makeAPICallForQuote(String region, String language, String symbol)
    {
        String endPoint = "/v6/finance/quote";
        String url = baseUrl + endPoint + "?region=" + region + "&lang=" + language + "&symbols=" + symbol;

        try {
            URI myUri = URI.create(url); // creates a URI object from the url string
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void parseQuote(String json)
    {
        JSONObject jsonObj = new JSONObject(json);
        JSONObject quoteResponseObj = jsonObj.getJSONObject("quoteResponse");
        JSONArray resultArr = quoteResponseObj.getJSONArray("result");

        for (int i = 0; i < resultArr.length(); i++) {
            JSONObject quoteObj = resultArr.getJSONObject(i);

            String longName = quoteObj.getString("longName");
            double bid = quoteObj.getDouble("bid");
            double ask = quoteObj.getDouble("ask");
            String fiftyTwoWeekLow = quoteObj.getString("fiftyTwoWeekLow");
            String fiftyTwoWeekHigh = quoteObj.getString("fiftyTwoWeekHigh");

            System.out.println("Full name: " + longName);
            System.out.println("Bid: " + bid);
            System.out.println("Ask: " + ask);
            System.out.println("52-week low: " + fiftyTwoWeekLow);
            System.out.println("52-week high: " + fiftyTwoWeekHigh);
        }
    }

}