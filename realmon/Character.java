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
    public int exp;

    public Character() {
        this.name = "";
        this.jobID = "";
        this.HP = 50;
        this.MP = 25;
        this.attack = 0;
        this.defence = 0;
        this.magicAttack = 0;
        this.magicDefence = 0;
        this.exp = 0;
    }

    public Character(String name, String job, int HP, int MP, int attack, int defence, int magicAttack, int magicDefence, int exp) {
        this.name = name;
        this.jobID = job;
        this.HP = HP;
        this.MP = MP;
        this.attack = attack;
        this.defence = defence;
        this.magicAttack = magicAttack;
        this.magicDefence = magicDefence;
        this.exp = exp;
    }

    public Character(String name, int HP, int MP, int attack, int defence, int magicAttack, int magicDefence, int exp) {
        this.name = name;
        this.HP = HP;
        this.MP = MP;
        this.attack = attack;
        this.defence = defence;
        this.magicAttack = magicAttack;
        this.magicDefence = magicDefence;
        this.exp = exp;
    }

    public void jobChange(String oldJob, String newJob) {
        System.out.println("Congratulations, you successfully changed from " + oldJob + " to " + newJob);
    }
}