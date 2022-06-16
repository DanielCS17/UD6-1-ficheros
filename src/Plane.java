import java.io.Serializable;

public class Plane implements Serializable {
    private float fuelLevel;
    private String pilotCallSign;
    private String squadNumber;

    private boolean flaps = false;
    private String showFlaps = "Arriba";
    private boolean landingGear = true;
    private String showLandingGear = "Abajo";
    private boolean ejectionSystem = false;
    private String showEjectionSystem = "Desarmado";

    private boolean seatOccupation = true;
    private String showSeatOccupation = "Verdadero";

    public Plane(float fuelLevel, String pilotCallSign, String squadNumber) {
        this.fuelLevel = fuelLevel;
        this.pilotCallSign = pilotCallSign;
        this.squadNumber = squadNumber;

        // Completa el código para cumplir con los requisitos.
    }

    public void toggleFlaps() {

        flaps = !flaps;

        if (flaps){
            showFlaps = "Abajo";
        }else {
            showFlaps = "Arriba";
        }
    }

    public void toggleLandingGear() {

        landingGear = !landingGear;

        if (landingGear){
            showLandingGear = "Abajo";
        }else {
            showLandingGear = "Arriba";
        }
    }

    public void ejectionSystem() {

        ejectionSystem = !ejectionSystem;

        if (ejectionSystem){
            showEjectionSystem = "Armado";
        }else {
            showEjectionSystem = "Desarmado";
        }
    }

    public void setSeatOccupation() {

        if (ejectionSystem){
            seatOccupation = false;

            showSeatOccupation = "Falso";
        }else {
            System.out.println("\nERROR! El sistema de eyección está desactivado");
        }
    }

    @Override
    public String toString() {
        return "\nPlane{" +
                "\n fuelLevel = " + fuelLevel +
                ",\n pilotCallSign = '" + pilotCallSign + '\'' +
                ",\n squadNumber = '" + squadNumber + '\'' +
                ",\n flaps = " + showFlaps +
                ",\n landingGear = " + showLandingGear +
                ",\n ejectionSystem = " + showEjectionSystem +
                ",\n seatOccupation = " + showSeatOccupation +
                "\n}";
    }
}
