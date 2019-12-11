package com.deezboiz.blackjack.ui_manager;

import com.deezboiz.blackjack.engine.Action;
import com.deezboiz.blackjack.engine.Hand;

import javax.management.RuntimeErrorException;
import java.util.HashMap;
import java.util.Scanner;

public class TerminalUIHandler extends InputHandler {

    @Override
    public Action getPlayerChoice(Hand disHand) {
        Scanner in = new Scanner(System.in);
        System.out.println(disHand);
        System.out.println("What do you want to do? (Hit/Stay/Split):\n");
        String deal = in.nextLine();
        return stringToAction(deal);
    }

    @Override
    public void reportError(String errorMessage) {
//        System.out.println(errorMessage);
        throw new RuntimeErrorException(new Error(errorMessage));
    }

    private Action stringToAction(String string) {
        // @TODO make some robust string parsing thing here
        return poopers.get(string.toLowerCase().trim());
    }

    private static HashMap<String, Action> poopers = new HashMap<>();
    static {
        poopers.put("hit", Action.HIT);
        poopers.put("stay", Action.STAY);
        poopers.put("double", Action.DOUBLE);
        poopers.put("split", Action.SPLIT);

    }
}
