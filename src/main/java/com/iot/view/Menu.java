package com.iot.view;

public class Menu {
public void displayMenu() {
    
    
    System.out.println("\r\n" + 
        "███╗░░██╗░█████╗░████████╗  ░██████╗██████╗░██████╗░██╗███╗░░██╗░██████╗░\r\n" + 
        "████╗░██║██╔══██╗╚══██╔══╝  ██╔════╝██╔══██╗██╔══██╗██║████╗░██║██╔════╝░\r\n" + 
        "██╔██╗██║██║░░██║░░░██║░░░  ╚█████╗░██████╔╝██████╔╝██║██╔██╗██║██║░░██╗░\r\n" + 
        "██║╚████║██║░░██║░░░██║░░░  ░╚═══██╗██╔═══╝░██╔══██╗██║██║╚████║██║░░╚██╗\r\n" + 
        "██║░╚███║╚█████╔╝░░░██║░░░  ██████╔╝██║░░░░░██║░░██║██║██║░╚███║╚██████╔╝\r\n" + 
        "╚═╝░░╚══╝░╚════╝░░░░╚═╝░░░  ╚═════╝░╚═╝░░░░░╚═╝░░╚═╝╚═╝╚═╝░░╚══╝░╚═════╝░");
    System.out.println("\r\n" + 
        "▄▀ █░█ █▄░█ █▀▀ █▀█ █▀█ ▀█▀ █░█ █▄░█ ▄▀█ ▀█▀ █▀▀ █░░ █░░ █▄█ ▀▄\r\n" + 
        "▀▄ █▄█ █░▀█ █▀░ █▄█ █▀▄ ░█░ █▄█ █░▀█ █▀█ ░█░ ██▄ █▄▄ █▄▄ ░█░ ▄▀");
    
    System.out.println(" _______________________________________________________________________");
    System.out.println("|                                                                       |");
    System.out.println("|       Enter any compination of existing entity and CRUD number :      |");
    System.out.println("|_______________________________________________________________________|");
    System.out.println("|                                  |                                    |");
    System.out.println("|        entity number:            |           CRUD number:             |");
    System.out.println("|__________________________________|____________________________________|");
    System.out.println("|   |                              |   |                                |");
    System.out.println("| 1 | credentials                  | 1 | GET ALL                        |");
    System.out.println("| 2 | genre                        | 2 | GET ONE                        |");
    System.out.println("| 3 | label                        | 3 | CREATE                         |");
    System.out.println("| 4 | user                         | 4 | UPDATE                         |");
    System.out.println("| 5 | playlist                     | 5 | DELETE                         |");
    System.out.println("|___|______________________________|___|________________________________|");
  }
}
