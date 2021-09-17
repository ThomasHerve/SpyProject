public class Card {

    private final Boolean isSpy;
    private String location = null;
    private String role = null;

    public Card() {
        this.isSpy = true;
    }

    public Card(String location, String role){
        this.isSpy = false;
        this.location = location;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public Boolean getSpy() {
        return isSpy;
    }

    public String getLocation() {
        return location;
    }


}
