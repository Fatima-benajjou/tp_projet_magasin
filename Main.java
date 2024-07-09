package org.example.tp_projet;

import org.example.tp_projet.controller.IHMGlobal;
import org.example.tp_projet.entity.Client;
import org.example.tp_projet.repository.ClientRepo;
import org.example.tp_projet.repository.NourritureRepo;

public class Main {

        public static void main(String[] args) {

            IHMGlobal ihmGlobal = new IHMGlobal ();
            ihmGlobal.start();

//            NourritureRepo nourritureRepo = new NourritureRepo();
//            System.out.println(nourritureRepo.getAll());

        }
    }





