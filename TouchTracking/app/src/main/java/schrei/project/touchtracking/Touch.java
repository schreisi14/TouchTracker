package schrei.project.touchtracking;

/**
 * Created by simonschrei on 23.04.17.
 */

public class Touch {

    // Variables
    private int id;
    private int posX;
    private int posY;
    private String touchDate;

    // Constructor
    public Touch(int id, int posX, int posY, String touchDate) {
        setId(id);
        setPosX(posX);
        setPosY(posY);
        setTouchDate(touchDate);
    }

    // Getter & Setter
    public int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }

    public String getPosistion (){return "X " + this.posX + " Y " +this.posY;}
    private void setPosX(int posX) {
        this.posX = posX;
    }
    private void setPosY(int posY) {
        this.posY = posY;
    }

    public String getTouchDate() {
        return touchDate;
    }
    private void setTouchDate(String touchDate) {
        this.touchDate = touchDate;
    }

    // To string method
    @Override
    public String toString() {
        return "Touch = " + id +
                " posX = " + posX +
                " posY = " + posY;
    }

}
