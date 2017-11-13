package com.example.user.yu_gi_ohassistant;
import java.util.*;
import java.io.*;
/**
 * Created by User on 11/6/2017.
 */

public class CardConverter extends Object
{
    public CardConverter()
    {
    }
    public Card convertCard(String cardString) throws IOException
    {
        Scanner scan = new Scanner(cardString).useDelimiter(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        scan.next();
        String name = scan.next();
        String temp = scan.next();
        String effect;
        String type;
        String text;
        if(temp.equals("Spell"))
        {
            scan.next();
            effect = scan.next();
            scan.next();
            type = scan.next();
            scan.next();
            scan.next();
            scan.next();
            text = scan.next();
            SpellCard card = new SpellCard(name,text,effect,null,type);
            return card;
        }
        else if(temp.equals("Trap"))
        {
            scan.next();
            effect = scan.next();
            scan.next();
            type = scan.next();
            scan.next();
            scan.next();
            scan.next();
            text = scan.next();
            TrapCard card = new TrapCard(name,text,effect,null,type);
            return card;
        }
        else if(temp.equals("Normal Monster") || temp.equals("Effect Monster") || temp.equals("Union Monster") || temp.equals("Gemini Monster"))
        {
            scan.next();
            effect = scan.next();
            String attribute = scan.next();
            type = scan.next();
            int level = scan.nextInt();
            int attack = scan.nextInt();
            int defense = scan.nextInt();
            text = scan.next();
            MonsterCard card = new MonsterCard(name,text,effect,null,attribute,level,type,attack,defense);
            return card;
        }
        else if(temp.equals("Fusion Monster") || temp.equals("Fusion/Effect Monster"))
        {
            scan.next();
            effect = scan.next();
            String attribute = scan.next();
            type = scan.next();
            int level = scan.nextInt();
            int attack = scan.nextInt();
            int defense = scan.nextInt();
            String material = scan.next();
            text = scan.next();
            FusionMonsterCard card = new FusionMonsterCard(name,text,effect,null,attribute,level,type,attack,defense,material);
            return card;
        }
        else if(temp.equals("Synchro Monster"))
        {
            scan.next();
            effect = scan.next();
            String attribute = scan.next();
            type = scan.next();
            int level = scan.nextInt();
            int attack = scan.nextInt();
            int defense = scan.nextInt();
            String material = scan.next();
            text = scan.next();
            SynchroMonsterCard card = new SynchroMonsterCard(name,text,effect,null,attribute,level,type,attack,defense,material);
            return card;
        }
        else if(temp.equals("XYZ Monster"))
        {
            scan.next();
            effect = scan.next();
            String attribute = scan.next();
            type = scan.next();
            int rank = scan.nextInt();
            int attack = scan.nextInt();
            int defense = scan.nextInt();
            String material = scan.next();
            text = scan.next();
            XYZMonsterCard card = new XYZMonsterCard(name,text,effect,null,attribute,0,type,attack,defense,material,rank);
            return card;
        }
        else
        {
            System.out.print("ERROR: Card type missing");
        }
        return null;
    }
}
