package realmon;

class Story {
    public String act; 

    public void setActName(String act) {
        this.act = act;
    }

    public void newGame() {
        this.act = "ACT 1";
    }

    public String getActName() {
        return act;
    }

    public void readStory(String act) {
        //TODO: Find place in story, read that file
        System.out.println("Reading story...");
    }
}