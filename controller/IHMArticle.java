import org.example.tp_projet.Service.ElectroniqueService;
import org.example.tp_projet.Service.VetementService;
import org.example.tp_projet.repository.ElectroniqueRepo;
import org.example.tp_projet.repository.VetementRepo;

public class IHMArticle {

    Scanner sc = new Scanner(System.in);

    public void start() {
        String entry;
        String entryChoix;

        do {
            System.out.println(" ---- Menu Article -----");

            System.out.println("Quel catégorie d'Article est concerné");
            System.out.println("1/ Nourriture");
            System.out.println("2/ Vetement");
            System.out.println("3/ Electronique");
            entry = sc.nextLine();

            switch (entry) {
                case "1":
                    System.out.println(" ---- Menu Article Catégorie Nourriture -----");
                    System.out.println("1/ crée un Article");
                    System.out.println("2/ update un Article");
                    System.out.println("3/ supprimer un Article");
                    System.out.println("4/ recuperer un Article par sont id");
                    System.out.println("5/ recuperer tout les Article");
                    entryChoix = sc.nextLine();
                    choixNourritureCRUD(entryChoix);
                    break;
                case "2": // Vetement
                    System.out.println(" ---- Menu Article Catégorie Vetement -----");
                    System.out.println("1/ crée un Article");
                    System.out.println("2/ update un Article");
                    System.out.println("3/ supprimer un Article");
                    System.out.println("4/ recuperer un Article par sont id");
                    System.out.println("5/ recuperer tout les Article");
                    entryChoix = sc.nextLine();
                    choixVetementCRUD(entryChoix);
                    break;
                case "3":// Electronique
                    System.out.println(" ---- Menu Article Catégorie Vetement -----");
                    System.out.println("1/ crée un Article");
                    System.out.println("2/ update un Article");
                    System.out.println("3/ supprimer un Article");
                    System.out.println("4/ recuperer un Article par sont id");
                    System.out.println("5/ recuperer tout les Article");
                    entryChoix = sc.nextLine();
                    choixElectroniqueCRUD(entryChoix);
                    break;
                default:
                    System.out.println("Saisie erroné, recommencez");
                    break;
            }


        } while (true);

        private void choixNourritureCRUD (String entry){
            switch (entry) {
                case "1" -> NourritureService.createNourriture();
                case "2" -> NourritureService.update();
                case "3" -> NourritureService.delete();
                case "4" -> NourritureRepo.findById();
                case "5" -> NourritureRepo.getAll();
                default -> System.out.println("Saisie erroné, recommencez");
            }

        }
        private void choixVetementCRUD (String entry){
            switch (entry) {
                case "1" -> VetementService.createNourriture();
                case "2" -> VetementService.update();
                case "3" -> VetementService.delete();
                case "4" -> VetementRepo.findById();
                case "5" -> VetementRepo.getAll();
                default -> System.out.println("Saisie erroné, recommencez");

            }
        }

        private void choixElectroniqueCRUD (String entry){
            switch (entry) {
                case "1" -> ElectroniqueService.createElectronique();
                case "2" -> ElectroniqueService.update();
                case "3" -> ElectroniqueService.delete();
                case "4" -> ElectroniqueRepo.findById();
                case "5" -> ElectroniqueRepo.getAll();
                default -> System.out.println("Saisie erroné, recommencez");

            }
        }


    }
}




