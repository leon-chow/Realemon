package realmon;

class Character {
    public String name;
    public String jobID;
    public int level;    
    public int HP;
    public int MP;
    public int attack;
    public int defence;
    public int magicDefence;
    public int magicAttack;
    public int exp;
    public String storyACT;

    public Character() {
        this.name = "";
        this.jobID = "000";
        this.level = 1;
        this.HP = 50;
        this.MP = 25;
        this.attack = 0;
        this.defence = 0;
        this.magicAttack = 0;
        this.magicDefence = 0;
        this.exp = 0;
    }

    public Character(String name, String jobID, int level, int HP, int MP, int attack, int defence, int magicAttack, int magicDefence, int exp, String storyACT) {
        this.name = name;
        this.level = level;
        this.jobID = jobID;
        this.HP = HP;
        this.MP = MP;
        this.attack = attack;
        this.defence = defence;
        this.magicAttack = magicAttack;
        this.magicDefence = magicDefence;
        this.exp = exp;
        this.storyACT = storyACT;
    }

    public Character(String name, int level, int HP, int MP, int attack, int defence, int magicAttack, int magicDefence, int exp) {
        this.name = name;
        this.level = level;
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

    public void levelUp() {
        System.out.println("Level Up Fanfare! Congratulations! You have leveled up!");
        this.exp -= this.level * 100;
        this.HP += 10;
        this.MP += 5;
        this.level += 1;
        this.attack += (int)(Math.random() * (5 - 1 + 1)) + 1;
        this.defence += (int)(Math.random() * (5 - 1 + 1)) + 1;
        this.magicAttack += (int)(Math.random() * (5 - 1 + 1)) + 1;
        this.magicDefence += (int)(Math.random() * (5 - 1 + 1)) + 1;
    }
}