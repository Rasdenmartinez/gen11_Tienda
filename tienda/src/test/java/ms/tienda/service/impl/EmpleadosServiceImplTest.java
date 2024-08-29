package ms.tienda.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import ms.tienda.dto.EmpleadoProveedorDTO;
import ms.tienda.entity.Empleados;
import ms.tienda.entity.Proveedores;
import ms.tienda.repository.EmpleadosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EmpleadosServiceImplTest {

    @Mock
    private EmpleadosRepository empleadosRepository;

    @InjectMocks
    private EmpleadosService empleadosService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReadAll() {
        // Datos de prueba
        Empleados empleado1 = new Empleados();
        empleado1.setIsActive(true); // No filtrado

        Empleados empleado2 = new Empleados();
        empleado2.setIsActive(false); // Filtrado

        when(empleadosRepository.findAll()).thenReturn(Arrays.asList(empleado1, empleado2));

        // Ejecuta el método a probar
        List<Empleados> result = empleadosService.readAll();

        // Verifica los resultados
        assertEquals(1, result.size());
        assertTrue(result.contains(empleado1));
        assertFalse(result.contains(empleado2));

        // Verifica que findAll() fue llamado exactamente una vez
        verify(empleadosRepository, times(1)).findAll();
    }

    //LEER A LOS EMPLEADOS POR EL ID
    @Test
    public void testReadById_EmpleadoExisteYNoFiltrado() {
        // Datos de prueba
        Long id = 1L;
        Empleados empleado = new Empleados();
        empleado.setId(id);
        empleado.setIsActive(true); // No filtrado

        when(empleadosRepository.findById(id)).thenReturn(Optional.of(empleado));

        // Ejecuta el método a probar
        Empleados result = empleadosService.readById(id);

        // Verifica los resultados
        assertEquals(empleado, result);

        // Verifica que findById() fue llamado exactamente una vez
        verify(empleadosRepository, times(1)).findById(id);
    }

    @Test
    public void testReadById_EmpleadoExisteYFiltrado() {
        // Datos de prueba
        Long id = 1L;
        Empleados empleado = new Empleados();
        empleado.setId(id);
        empleado.setIsActive(false); // Filtrado

        when(empleadosRepository.findById(id)).thenReturn(Optional.of(empleado));

        // Ejecuta el método a probar
        Empleados result = empleadosService.readById(id);

        // Verifica los resultados
        assertNotEquals(empleado, result); // No debe ser el mismo empleado
        assertTrue(result instanceof Empleados); // Verifica que se devuelve un nuevo Empleados
        assertNull(result.getId()); // Verifica que es un nuevo objeto vacío

        // Verifica que findById() fue llamado exactamente una vez
        verify(empleadosRepository, times(1)).findById(id);
    }

    @Test
    public void testReadById_EmpleadoNoExiste() {
        // Datos de prueba
        Long id = 1L;

        when(empleadosRepository.findById(id)).thenReturn(Optional.empty());

        // Ejecuta el método a probar
        Empleados result = empleadosService.readById(id);

        // Verifica los resultados
        assertNotNull(result); // Verifica que se devuelve un objeto
        assertTrue(result instanceof Empleados); // Verifica que es una instancia de Empleados
        assertNull(result.getId()); // Verifica que es un nuevo objeto vacío

        // Verifica que findById() fue llamado exactamente una vez
        verify(empleadosRepository, times(1)).findById(id);
    }

    @Test
    public void testInsert() {
        // Datos de prueba
        Empleados empleado = new Empleados();
        empleado.setId(1L);
        empleado.setNombre("Juan Pérez");

        // Simulación del comportamiento del repositorio
        when(empleadosRepository.save(empleado)).thenReturn(empleado);

        // Ejecuta el método a probar
        Empleados result = empleadosService.insert(empleado);

        // Verifica los resultados
        assertNotNull(result); // Verifica que el resultado no es nulo
        assertEquals(empleado, result); // Verifica que se devuelve el empleado esperado

        // Verifica que save() fue llamado exactamente una vez
        verify(empleadosRepository, times(1)).save(empleado);
    }

    @Test
    public void testUpdate() {
        // Datos de prueba
        Empleados empleado = new Empleados();
        empleado.setId(1L);
        empleado.setNombre("Juan Pérez");

        // Simulación del comportamiento del repositorio
        when(empleadosRepository.save(empleado)).thenReturn(empleado);

        // Ejecuta el método a probar
        Empleados result = empleadosService.update(empleado);

        // Verifica los resultados
        assertNotNull(result); // Verifica que el resultado no es nulo
        assertEquals(empleado, result); // Verifica que se devuelve el empleado esperado

        // Verifica que save() fue llamado exactamente una vez
        verify(empleadosRepository, times(1)).save(empleado);
    }

    @Test
    public void testDelete_EmpleadoExists() {
        // Datos de prueba
        Long empleadoId = 1L;
        Empleados empleado = new Empleados();
        empleado.setId(empleadoId);
        empleado.setIsActive(true);

        // Simulación del comportamiento del repositorio
        when(empleadosRepository.findById(empleadoId)).thenReturn(Optional.of(empleado));
        when(empleadosRepository.save(any(Empleados.class))).thenReturn(empleado);

        // Ejecuta el método a probar
        empleadosService.delete(empleadoId);

        // Verificaciones
        verify(empleadosRepository, times(1)).findById(empleadoId);
        verify(empleadosRepository, times(1)).save(empleado);
        assertFalse(empleado.getIsActive()); // Verifica que el empleado se marcó como inactivo
    }

    @Test
    public void testDelete_EmpleadoDoesNotExist() {
        // Datos de prueba
        Long empleadoId = 1L;

        // Simulación del comportamiento del repositorio
        when(empleadosRepository.findById(empleadoId)).thenReturn(Optional.empty());

        // Ejecuta el método a probar
        empleadosService.delete(empleadoId);

        // Verificaciones
        verify(empleadosRepository, times(1)).findById(empleadoId);
        verify(empleadosRepository, never()).save(any(Empleados.class)); // Verifica que save() no fue llamado
    }

    @Test
    public void testFindByEmpleadosProveedores() {
        // Datos de prueba
        Proveedores proveedor = new Proveedores();
        proveedor.setId(1.0);  // Cambia 1L a 1.0
        proveedor.setNombreEmpresa("Empresa XYZ");
        proveedor.setContacto("Contacto XYZ");
        proveedor.setTelefono("1234567890");

        Empleados empleado = new Empleados();
        empleado.setId(1L);  // Cambia 1L a 1.0
        empleado.setNombre("John");
        empleado.setApellido("Doe");
        empleado.setPuesto("Gerente");
        empleado.setIdProveedor(proveedor);  // Asegúrate de que no es null

        List<Empleados> empleadosList = new ArrayList<>();
        empleadosList.add(empleado);

        // Simulación del comportamiento del repositorio
        when(empleadosRepository.findByEmpleadosProveedore()).thenReturn(empleadosList);

        // Ejecuta el método a probar
        List<EmpleadoProveedorDTO> result = empleadosService.findByEmpleadosProveedores();

        // Verificaciones
        assertNotNull(result);
        assertEquals(1, result.size());

        EmpleadoProveedorDTO dto = result.get(0);
        assertEquals(empleado.getId(), dto.getIdEmpleado());
        assertEquals(empleado.getNombre(), dto.getNombreEmpleado());
        assertEquals(empleado.getApellido(), dto.getApellidoEmpleado());
        assertEquals(empleado.getPuesto(), dto.getPuesto());
        assertEquals(proveedor.getId(), dto.getIdProveedor());
        assertEquals(proveedor.getNombreEmpresa(), dto.getNombreEmpresa());
        assertEquals(proveedor.getContacto(), dto.getContacto());
        assertEquals(proveedor.getTelefono(), dto.getTelefono());

        // Verifica que se llamó al repositorio para obtener la lista de empleados
        verify(empleadosRepository, times(1)).findByEmpleadosProveedore();
    }

}
