import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CardFactory {

    private final HashMap<String, ArrayList<Card>> cards = new HashMap<>();
    private final ArrayList<String> locations = new ArrayList<>();
    private String lastLocation = "";
    private final Random rand = new Random();
    private final Card spyCard;

    public CardFactory() throws IOException, ParseException {
        spyCard = new Card();
        JSONParser parser = new JSONParser();
        try {
            JSONArray jsonCards = (JSONArray) parser.parse(new FileReader("src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+ "cards.json"));
            for (Object k : jsonCards) {
                JSONObject cardObject = (JSONObject)k;
                String location = (String)cardObject.get("location");
                JSONArray JSORoles = (JSONArray)cardObject.get("roles");
                ArrayList<String> roles = new ArrayList<>(JSORoles.size());
                for(Object JSORole : JSORoles) {
                    roles.add((String)JSORole);
                }
                addCustomLocation(location, roles);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void addCustomLocation(String name, ArrayList<String> roles) {
        locations.add(name);
        cards.put(name, new ArrayList<Card>());
        for (String role : roles) {
            cards.get(name).add(new Card(name, role));
        }
    }

    public ArrayList<Card> getCards(int number) {
        String newLocation = lastLocation;
        while (newLocation == lastLocation) {
            newLocation = locations.get(rand.nextInt(locations.size()));
        }
        lastLocation = newLocation;
        ArrayList<Card> cardsToReturn = new ArrayList<>(number);
        cardsToReturn.add(spyCard);
        for (int i = 1; i < number; i++) {
            if (i < cards.get(newLocation).size()) {
                cardsToReturn.add(cards.get(newLocation).get(i));
            } else {
                cardsToReturn.add(cards.get(newLocation).get(cards.get(newLocation).size() - 1));
            }
        }
        Collections.shuffle(cardsToReturn);
        return cardsToReturn;
    }
}
