package realmon;

class Character {
    public String name;
    public String jobID;    
    public int HP;
    public int MP;
    public int attack;
    public int defence;
    public int magicDefence;
    public int magicAttack;

    public Character() {
        this.name = "";
        this.jobID = "";
        this.HP = 50;
        this.MP = 25;
        this.attack = 0;
        this.defence = 0;
        this.magicAttack = 0;
        this.magicDefence = 0;
    }

    public Character(String name, String job, int HP, int MP, int attack, int defence, int magicAttack, int magicDefence) {
        this.name = name;
        this.jobID = job;
        this.HP = HP;
        this.MP = MP;
        this.attack = attack;
        this.defence = defence;
        this.magicAttack = magicAttack;
        this.magicDefence = magicDefence;
    }

    public void jobChange(String oldJob, String newJob) {
        System.out.println("Congratulations, you successfully changed from " + oldJob + " to " + newJob);
    }
}