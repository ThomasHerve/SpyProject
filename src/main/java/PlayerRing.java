import java.util.LinkedList;
import java.util.List;

public class PlayerRing {

    private LinkedList<Player> players;
    private CardFactory cardFactory = null;

    public PlayerRing(){
        try {
            this.cardFactory = new CardFactory();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public PlayerRing(CardFactory cardFactory){
        this.cardFactory = cardFactory;
    }

    public void addPlayer(Player player) {
        players.addLast(player);
    }

    public Player getNextPlayerToPlay() {
        players.addLast(players.getFirst());
        players.removeFirst();
        return players.getLast();
    }

    public void attributeRoles() {
        List<Card> cardsToDispatch = cardFactory.getCards(players.size());

    }

}
