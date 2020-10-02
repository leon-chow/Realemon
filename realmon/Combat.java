package realmon;

import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

class Combat {

    public void save(Character player) {
        try {
            int currentAct = Integer.parseInt(player.storyACT.replaceAll("\\D+",""));
            System.out.println("Saving game...");
            FileWriter characterWriter = new FileWriter("Saves/" + player.name + ".txt", false);
            if (currentAct >= 10) {
                player.storyACT = "END";
            } else {
                player.storyACT = "ACT " + (currentAct + 1);
            }
    
            characterWriter.write(player.jobID + "," + player.level + "," + player.HP + "," + player.MP 
                + "," + player.attack + "," + player.defence + "," + player.magicAttack + "," + player.magicDefence + "," +
                player.exp + "," + player.storyACT);
            characterWriter.close();
            System.out.println("Successfully saved game!"); 
        } catch (IOException e) {
            System.out.println("File not found!");
            System.exit(1);
        } 
    }

    public void heal(Character player, int pMaxHP, int pMaxMP, Character ememy) {
        int damage = (int)((player.magicAttack + pMaxHP) * 0.1);
        // check if player is full HP, or prevents overhealing if player heals more than full HP
        if (player.HP <= pMaxHP && (player.HP + damage) > pMaxHP) {
            damage = pMaxHP - player.HP; 
        }
        System.out.println("You heal for " + damage + " hitpoints!");
        player.HP += damage;
    }

    public void attack(Character player, Character enemy) {
        // TODO: Handle Attack Calculations
        int damage = player.attack - enemy.defence;
        if (damage < 0) {
            damage = 0;
        }
        System.out.println("You deal " + damage + " damage to " + enemy.name);
        enemy.HP -= damage;
    }

    public void defend(Character player, Character enemy, int block) {
        int damage = enemy.attack - player.defence - block;
        if (damage < 0) {
            damage = 0;
        }
        System.out.println("\n" + enemy.name + "'s turn.\n" + enemy.name + " deals " + damage + " damage!");
        player.HP -= damage;
    }

    public void statusCheck(Character player, Character enemy) {
        if (player.HP > 0 && enemy.HP <= 0) {
            System.out.println(enemy.name + " has fainted. ");
            accumulateEXP(player, enemy);
        } else {
            System.out.println("You have died.");
            System.exit(1);
        }
    }

    public void accumulateEXP(Character player, Character enemy) {
        System.out.println("Victory Fanfare! Congratulations! You've earned " + enemy.exp + " EXP!");
        player.exp += enemy.exp;
        System.out.println("Your current EXP points are " + player.exp + "\n");
        if (player.exp >= (player.level * 100)) {
            player.levelUp();
        }
        save(player);
    }

    public void startCombat(Character player, Character enemy, String act) {
        System.out.println("Preparing for Battle " + act);
        System.out.println("Starting combat...");
        int turnOrder = (int)(Math.random() * (2 - 1 + 1)) + 1; 
        int turnCounter = 1;
        int block = 0;
        int pMaxHP = player.HP;
        int pMaxMP = player.MP;

        while (player.HP > 0 && enemy.HP > 0) {      
            if (turnOrder == 1) {
                System.out.println("Turn " + turnCounter);
                System.out.println("Player HP: " + player.HP);
                System.out.println(enemy.name + " HP: " + enemy.HP);
                System.out.println("Player's turn! Enter a number for the corresponding action!");
                System.out.println("Player's moves: \n1.Attack\n2.Defend\n3.Heal");
                
                Scanner pScanner = new Scanner(System.in);
                int choice = pScanner.nextInt();
                
                if (choice > 0 && choice < 4) {
                    if (choice == 1) {
                        // ATTACK
                        attack(player, enemy);
                    } else if (choice == 2) {
                        // DEFENDING
                        System.out.println("You get ready to block!");
                        block = 10;
                    } else if (choice == 3) {
                        // HEALING
                        heal(player, pMaxHP, pMaxMP, enemy);
                    }
                    turnOrder = 0;
                } else {
                    // INVALID CHOICE
                    System.out.println("Please try again!");
                }
            } else {
                // ENEMY TURN
                defend(player, enemy, block);
                block = 0;
                turnOrder = 1;
                turnCounter++;
            }
        }
        statusCheck(player, enemy);
    }
}