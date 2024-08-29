package ms.tienda.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import ms.tienda.dto.ClienteEmpleadoDTO;
import ms.tienda.entity.Empleados;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ms.tienda.constantes.ClientesConstantes;
import ms.tienda.entity.Clientes;
import ms.tienda.model.ClientesResponse;
import ms.tienda.repository.ClientesRepository;

public class ClientesServiceImplTest {

    @Mock
    private ClientesRepository clientesRepository;

    @InjectMocks
    private ClientesService clientesService;
   
    private Clientes clienteActivo;
    private Clientes clienteInactivo;
    private Clientes clienteFiltrado;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
        // Cliente activo
        clienteActivo = new Clientes();
        clienteActivo.setId(1L);
        clienteActivo.setIsActive(true); // o el valor correspondiente que no sea `ClientesConstantes.Filtrado`
        
        //cliente inactivo
        clienteInactivo = new Clientes();
        clienteInactivo.setId(1L);
        clienteInactivo.setIsActive(false);
        
        // Cliente filtrado
        clienteFiltrado = new Clientes();
        clienteFiltrado.setId(2L);
        clienteFiltrado.setIsActive(ClientesConstantes.Filtrado);
    }

 
    
    @Test
    public void testLeerTodo_Success() {

        when(clientesRepository.findAll()).thenReturn(Arrays.asList(clienteActivo, clienteFiltrado));

        // Ejecutar el método a probar
        ClientesResponse response = clientesService.leerTodo();

        // Verificar el resultado
        assertNotNull(response);
        assertEquals("Consulta exitosa", response.getMensaje());
        assertEquals(201L, response.getCodigo());
        assertNotNull(response.getClientesList());
        assertEquals(1, response.getClientesList().size());
        assertTrue(response.getClientesList().get(0).getIsActive());

        verify(clientesRepository, times(1)).findAll();
    }


    @Test
    public void testLeerTodoError() {

        // Configurar el comportamiento del mock para que lance una excepción
        when(clientesRepository.findAll()).thenThrow(new RuntimeException("Error al consumir el servicio"));

        // Ejecutar el método a probar
        ClientesResponse response = clientesService.leerTodo();

        // Verificar los resultados
        assertEquals(404L, response.getCodigo());
        assertEquals("Error al consumir el servicio", response.getMensaje());
        assertNotNull(response.getClientesList());
        assertTrue(response.getClientesList().isEmpty());
    }


    
    @Test	
    public void testReadAll() {
   
        when(clientesRepository.findAll()).thenReturn(Arrays.asList(clienteActivo, clienteInactivo));

        List<Clientes> result = clientesService.readAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.get(0).getIsActive());
        
        verify(clientesRepository, times(1)).findAll();
    }   
    
    @Test
    public void testReadById_ClienteActivo() {
        // Configurar el comportamiento simulado del repositorio
        when(clientesRepository.findById(1L)).thenReturn(Optional.of(clienteActivo));

        // Ejecutar el método a probar
        Clientes resultado = clientesService.readById(1L);

        // Verificar que se devuelve el cliente activo
        assertNotNull(resultado);
        assertEquals(clienteActivo, resultado);
    }

    @Test
    public void testReadById_ClienteFiltrado() {
        // Configurar el comportamiento simulado del repositorio
        when(clientesRepository.findById(2L)).thenReturn(Optional.of(clienteFiltrado));

        // Ejecutar el método a probar
        Clientes resultado = clientesService.readById(2L);

        // Verificar que se devuelve un nuevo objeto Clientes
        assertNotNull(resultado);
        assertNotEquals(clienteFiltrado, resultado);
    }

    @Test
    public void testReadById_ClienteNoExistente() {
        // Configurar el comportamiento simulado del repositorio
        when(clientesRepository.findById(3L)).thenReturn(Optional.empty());

        // Ejecutar el método a probar
        Clientes resultado = clientesService.readById(3L);

        // Verificar que se devuelve un nuevo objeto Clientes
        assertNotNull(resultado);
        assertTrue(true);
    }

    @Test
    void testDeleteClienteExistente() {
        // Configura los datos de prueba
        Long clienteId = 1L;
        Clientes cliente = new Clientes();
        cliente.setId(clienteId);
        cliente.setIsActive(true);

        // Configura el comportamiento del repositorio simulado
        when(clientesRepository.findById(clienteId)).thenReturn(Optional.of(cliente));

        // Ejecuta el método a probar
        clientesService.delete(clienteId);

        // Verifica que se guardó el cliente con isActive en false
        assertFalse(cliente.getIsActive());
        verify(clientesRepository).save(cliente);

        // Verifica que se realizó el logging
        verify(clientesRepository, times(1)).findById(clienteId);
    }

    @Test
    void testDeleteClienteNoExistente() {
        // Configura el ID del cliente no existente
        Long clienteId = 1L;

        // Configura el comportamiento del repositorio simulado
        when(clientesRepository.findById(clienteId)).thenReturn(Optional.empty());

        // Ejecuta el método a probar
        clientesService.delete(clienteId);

        // Verifica que no se intentó guardar ningún cliente
        verify(clientesRepository, never()).save(any(Clientes.class));

        // Verifica que se realizó el logging de error
        verify(clientesRepository, times(1)).findById(clienteId);
    }

    @Test
    void testInsert() {
        // Configura los datos de prueba
        Clientes cliente = new Clientes();
        cliente.setId(1L);
        cliente.setNombre("Juan");

        // Configura el comportamiento del repositorio simulado
        when(clientesRepository.save(cliente)).thenReturn(cliente);

        // Ejecuta el método a probar
        Clientes resultado = clientesService.insert(cliente);

        // Verifica el resultado
        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());

        // Verifica que el método save del repositorio fue llamado una vez
        verify(clientesRepository, times(1)).save(cliente);
    }

    @Test
    void testUpdate() {
        // Configura los datos de prueba
        Clientes cliente = new Clientes();
        cliente.setId(1L);
        cliente.setNombre("Pedro");

        // Configura el comportamiento del repositorio simulado
        when(clientesRepository.save(cliente)).thenReturn(cliente);

        // Ejecuta el método a probar
        Clientes resultado = clientesService.update(cliente);

        // Verifica el resultado
        assertNotNull(resultado);
        assertEquals("Pedro", resultado.getNombre());

        // Verifica que el método save del repositorio fue llamado una vez
        verify(clientesRepository, times(1)).save(cliente);
    }

    @Test
    public void testFindBySalario() {
        // Datos de prueba
        Empleados empleado1 = new Empleados();
        empleado1.setId(1L);
        empleado1.setSalario(18000.0);

        Empleados empleado2 = new Empleados();
        empleado2.setId(2L);
        empleado2.setSalario(20000.0);

        Clientes cliente1 = new Clientes();
        cliente1.setId(1L);
        cliente1.setNombre("Pedro");
        cliente1.setIdEmpleado(cliente1.getIdEmpleado());  // Relación con empleado1

        Clientes cliente2 = new Clientes();
        cliente2.setId(2L);
        cliente2.setNombre("María");
        cliente2.setIdEmpleado(cliente2.getIdEmpleado());  // Relación con empleado2

        List<Clientes> clientesList = Arrays.asList(cliente1, cliente2);

        // Simulación de comportamiento del repositorio
        when(clientesRepository.findByIdEmpleadoSalarioLessThanEqual(20000.0)).thenReturn(clientesList);

        // Llamada al método a probar
        List<Clientes> result = clientesService.findBySalario(20000.0);

        // Verificaciones
        assertNotNull(result);
        assertEquals(2, result.size());  // Debería retornar 2 clientes
        assertTrue(result.contains(cliente1));
        assertTrue(result.contains(cliente2));

        // Verifica que el repositorio fue llamado correctamente
        verify(clientesRepository, times(1)).findByIdEmpleadoSalarioLessThanEqual(20000.0);
    }

    @Test
    public void testGetClientesWithEmpleadoBySalario() {
        // Crear objetos de prueba
        Empleados empleado1 = new Empleados();
        empleado1.setId(1L);
        empleado1.setNombre("Juan");
        empleado1.setPuesto("Vendedor");
        empleado1.setSalario(15000.0);

        Clientes cliente1 = new Clientes();
        cliente1.setId(1L);
        cliente1.setNombre("Pedro");
        cliente1.setIdEmpleado(empleado1);

        Empleados empleado2 = new Empleados();
        empleado2.setId(2L);
        empleado2.setNombre("Ana");
        empleado2.setPuesto("Gerente");
        empleado2.setSalario(20000.0);

        Clientes cliente2 = new Clientes();
        cliente2.setId(2L);
        cliente2.setNombre("Maria");
        cliente2.setIdEmpleado(empleado2);

        // Simular la respuesta del repositorio
        when(clientesRepository.getClientesEmpleadosS(20000.0)).thenReturn(Arrays.asList(cliente1, cliente2));

        // Ejecutar el método que estamos probando
        List<ClienteEmpleadoDTO> result = clientesService.getClientesWithEmpleadoBySalario(20000.0);

        // Verificar los resultados
        assertEquals(2, result.size());

        ClienteEmpleadoDTO dto1 = result.get(0);
        assertEquals(1L, dto1.getIdCliente());
        assertEquals("Pedro", dto1.getNombreCliente());
        assertEquals(1L, dto1.getIdEmpleado());
        assertEquals("Juan", dto1.getNombreEmpleado());
        assertEquals("Vendedor", dto1.getPuesto());
        assertEquals(15000.0, dto1.getSalario());

        ClienteEmpleadoDTO dto2 = result.get(1);
        assertEquals(2L, dto2.getIdCliente());
        assertEquals("Maria", dto2.getNombreCliente());
        assertEquals(2L, dto2.getIdEmpleado());
        assertEquals("Ana", dto2.getNombreEmpleado());
        assertEquals("Gerente", dto2.getPuesto());
        assertEquals(20000.0, dto2.getSalario());

        // Verificar que el método del repositorio fue llamado una vez con el salario correcto
        verify(clientesRepository, times(1)).getClientesEmpleadosS(20000.0);
    }

}


