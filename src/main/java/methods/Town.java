package methods;

public class Town {

    private String townName, townCode;

    public Town(String townName, String townCode) {
        this.townName = townName;
        this.townCode = townCode;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String newName) {
        townName = newName;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String newCode) {
        townCode = newCode;
    }

    public String toString() {
        return getTownName() + " " + getTownCode();
    }
}
