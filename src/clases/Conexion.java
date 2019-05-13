package clases;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Conexion {
	static String servidor;
	static String bbdd;
	static String usuario;
	static String password;
	
	static Connection conector;
	
	public Conexion (){
		try {
			this.leerArchivo();
			conector= DriverManager.getConnection(servidor+bbdd,usuario,password);
		
		}catch(Exception e) {
			System.out.println("no Conecta");
			e.printStackTrace();
		}
	}	
	
	public static void Select (String sql) {
		try {
		Statement miStatement = conector.createStatement();
		ResultSet rs = miStatement.executeQuery(sql);
		
		//consulta de campos sin conocer el numero de columnas
		while(rs.next()) {
			for(int i=1; i<=rs.getMetaData().getColumnCount();i++) {
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println(" ");
		}
		}catch(Exception e) {
			System.out.println("no Conecta");
			e.printStackTrace();
		}
	}
	
	
	
	public static void leerArchivo(){
		try {
			//cargamos el archivo desde la ruta especificada
			//Tendre que asegurarme de que este el nombre y la ruta del archivo
			Properties propiedades = new Properties ();
			propiedades.load(new FileInputStream
					("C:/Users/IFC/eclipse-workspace/UD12PR_EJEM_BBDD/src/propiedades/configuration.properties"));
			
			servidor = propiedades.getProperty("dataBaseServer");
			bbdd = propiedades.getProperty("dataBaseCatalog");
			usuario = propiedades.getProperty("dataBaseUser");
			password=propiedades.getProperty("dataBasePassword");
			
			/*Imprimir los valores*/
			System.out.println("server: "+servidor+ "\n"+"bbdd: " +bbdd+ "\n"+"Usuario: "+usuario+ "\n"+"Password: "+password);
			
		}catch(FileNotFoundException e) {
			System.out.println("Error, el archivo no existe");
		}catch(IOException e) {
			System.out.println("Error, no se puede leer el archivo");
		}
		
	}	
	
	
	
	
	
}
