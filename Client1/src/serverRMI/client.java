package serverRMI;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

public class client {
    public static void main(String[] args){
        try {
            Interface stub= (Interface)Naming.lookup("rmi://localhost:1099/interfaceImp");
            stub.hello(" oussama"); 
            System.out.println("bienvenue sur le systeme de gestion des taches associés aux employés \n");
            Scanner sc = new Scanner(System.in);
            do {
            	System.out.println("selectionnez l'option \n");
            	System.out.println("1-créer un employé \n"
            			+"2-Lire tout les employés\n"
            			+"3-Lire un employé precis\n"
            			+"4-Modifier un employé \n"
            			+"5-Supprimer un employé \n"
            			+"6-créer une tache \n"
            			+"7-Lire les taches\n"
            			+"8-Lire une tache précise \n"
            			+"9-modifier une tache \n"
            			+"10-supprimer une tache \n");
            	System.out.println("entrer votre choix \n");
            	int n=sc.nextInt();
            	switch(n) {
            	case 1 :
            		employe emp=new employe();
            		System.out.println("entrer id");
            		int a=sc.nextInt();
            		System.out.println("entrer nom");
            		String b=sc.next();
            		System.out.println("entrer prenom");
            		String c=sc.next();
            		System.out.println("entrer grade");
            		String d=sc.next();
            		System.out.println("entrer adr");
            		String e1=sc.next();
            		System.out.println("entrer numero de compte");
            		int f=sc.nextInt();
            		System.out.println("entrer superier hierarchie");
            		int g=sc.nextInt();
            		emp.setId(a);
            		emp.setNom(b);
            		emp.setPrenom(c);
            		emp.setGrade(d);
            		emp.setAdr(e1);
            		emp.setNum_compte(f);
            		emp.setSup_hierarchie(g);
            		
            		stub.createEmploye(emp);
            		System.out.println("employé crée avec succés !!");
            		
            	break;
            	
            	case 2 : 
            		ArrayList<employe> employes;
            		employes=stub.readEmploye();
            		System.out.println("voilà tous les employés \n");
            		for (employe em : employes) 
				  	{ 
				  	    System.out.println(em.toString());
				  	    System.out.println("----------------------------------------");
				  	}
            	break;
            	case 3:
            		ArrayList<employe> employe1;
            		System.out.println("entrer le id de l'employé que vous desirez afficher \n");
            		int k=sc.nextInt();
            		employe1=stub.readOneEmploye(k);
            		System.out.println(employe1.toString());
			  	    System.out.println("----------------------------------------");

            	break;
            	case 4 :
            		System.out.println("entrer le id de l'employé que vous desirez changer la grade \n");
            		int idemp=sc.nextInt();
            		System.out.println("entrer le nouveau grade \n");
            		String gradeemp=sc.next();
            		stub.updateEmploye(idemp,gradeemp);
            		System.out.println("grade changé avec succés !! \n");
            		ArrayList<employe> employe2;
        			employe2=stub.readOneEmploye(idemp);
            		System.out.println(employe2.toString()+ "\n");
			  	    System.out.println("----------------------------------------");
            	
            		
            	break;
            	
            	case 5 : 
            		System.out.println("entrer le id de l'employé que vous desirez supprimer");
            		int w2=sc.nextInt();
            		stub.deleteEmploye(w2);
            		System.out.println("L'employé a été supprimé !!");
            		ArrayList<employe> employe3;
            		employe3=stub.readEmploye();
            		for (employe em : employe3) 
				  	{ 
				  	    System.out.println(em.toString());
				  	    System.out.println("----------------------------------------");
				  	}

            	break;
            	
            	case 6:
            		tache t=new tache();
            		System.out.println("entrer id");
            		int a1=sc.nextInt();
            		System.out.println("entrer description");
            		String b1=sc.next();
            		System.out.println("entrer le id de l'employé");
            		int c1=sc.nextInt();

            		t.setId(a1);
            		t.setDesc(b1);
            		t.setId_emp(c1);
            	
            		stub.createTache(t);
            		System.out.println("tache crée avec succés !!");
			  	    System.out.println("----------------------------------------");

            		break;
                case 7: 
                	ArrayList<tache> taches;
            		taches=stub.readTache();
            		for (tache ta : taches) 
				  	{ 
				  	    System.out.println(ta.toString());
				  	    System.out.println("----------------------------------------");

				  	}
            		break;
                case 8:
                	ArrayList<tache> tache2;

                	System.out.println("entrer le id de la tache que vous desirez afficher \n");
            		int k1=sc.nextInt();
            		tache2=stub.readOneTache(k1);
            		System.out.println(tache2.toString());
			  	    System.out.println("----------------------------------------");
			  	 break;
                case 9:
            		ArrayList<tache> tache3;

                	System.out.println("entrer le id de la tache que vous desirez changer la description \n");
            		int idTache=sc.nextInt();
            		System.out.println("entrer la nouvelle description \n");
            		String descTache=sc.next();
            		stub.updateTache(idTache,descTache);
            		System.out.println("La tache a été changée !! \n");
            		tache3=stub.readOneTache(idTache);
            		System.out.println(tache3.toString());
			  	    System.out.println("----------------------------------------");
			  	

                	break;
                case 10:
                	System.out.println("entrer le id de la tache que vous desirez supprimer");
            		int w1=sc.nextInt();
            		stub.deleteTache(w1);
            		System.out.println("La tache a été supprimée !! \n");
            		ArrayList<tache> taches1;
            		taches1=stub.readTache();
            		for (tache ta : taches1) 
				  	{ 
				  	    System.out.println(ta.toString());
				  	    System.out.println("----------------------------------------");

				  	}

                	
                	break;
            	case 11 : System.out.println("merci pour utiliser l'application");
            	System.exit(0);
            	
            	default : System.out.println("entrez un choix valable svp");
            	}
            }while (true);
              
          
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
