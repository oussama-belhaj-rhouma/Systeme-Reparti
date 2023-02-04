package serverRMI;
import java.rmi.Naming;

import java.rmi.registry.LocateRegistry;
import java.sql.Connection;
import java.util.Scanner;

public class server {

	public static void main(String[] args) {

        try {
        	//Connection conn;
        	
            LocateRegistry.createRegistry(1099);
            interfaceImp stub = new interfaceImp();
            
            Naming.rebind("rmi://localhost:1099/interfaceImp",stub);
            System.out.println("helloo  " +stub.toString());
        	
            
        } catch (Exception stub) {
            System.out.println(stub.toString());

        }

    }

}
