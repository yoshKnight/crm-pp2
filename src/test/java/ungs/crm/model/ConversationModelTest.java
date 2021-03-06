package ungs.crm.model;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import ungs.crm.entity.Customer;

public class ConversationModelTest extends TestCase{
	
	@Test
	//Busca historial de contactos de un cliente que no existe
	//Para el mensaje por pantalla del sistema.
	public void testObtenerContactos()
	{		
//		assertNull(ClienteModelo.getInstance().buscarPorId(2));
	}
	
	@Test
	//La colección de historial de contactos devuelve 0 si se envía un cliente que no existe
	//o bien, ese cliente existe, pero no posee registro de conversaciones.
	public void testClientesSinRegistros()
	{
		Customer granix = new Customer("GR001","GRANIX SA");
		assertTrue(new ConversationModel().getDataConversations(granix).size() ==0);
	}
	
	@Test
	//Si el cliente es 1 (Google...), no puede retorna el idRegistro 2
	//Asumiendo que el idRegistro 2 corresponde al de Globant
	public void testRegistroHistorial()
	{
//		assertNull(new ContactoModelo().obtenerContacto(1,2));
	}
}
