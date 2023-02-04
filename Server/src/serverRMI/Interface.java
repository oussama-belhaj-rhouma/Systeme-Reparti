package serverRMI;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Interface extends Remote{
	
	 void createEmploye(employe emp) throws RemoteException;
	 public ArrayList<employe> readEmploye() throws RemoteException;
	 public ArrayList<employe> readOneEmploye(int id) throws RemoteException;
	 void updateEmploye(int id, String grade) throws RemoteException;
     void deleteEmploye(int id) throws RemoteException;
     void createTache(tache t) throws RemoteException;
     public ArrayList<tache> readTache() throws RemoteException;
     public ArrayList<tache> readOneTache(int id) throws RemoteException;
	 void updateTache(int id, String desc) throws RemoteException;
     void deleteTache(int id) throws RemoteException;
     void hello(String h) throws RemoteException;
	}