package clases;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conexion cn= new Conexion();
		Conexion.Select("select * from clientes");
		Conexion.Select("Select ciudad, codigocliente from clientes" );
	}

}
