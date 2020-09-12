package realmon;

class Combat {
    public void initiateCombat(String act) {
        System.out.println("Preparing for Battle " + act);
    }

    public void setPlayer(String name) {
        System.out.println("Setting player...");
        // TODO: Read file with character name
    }

    public void setEnemy(String currentAct) {
        System.out.println("Setting enemy...");
        // TODO: Read Enemy with Current Act 
    }

    public void heal() {
        // TODO: Handle Heal Calculations
    }

    public void attack() {
        // TODO: Handle Attack Calculations
    }

    public void defend() {
        // TODO: Handle defend Calculations
    }

    public void startCombat() {
        System.out.println("Starting combat...");
        // TODO: Logic that carries out until combat is over!
    }
}