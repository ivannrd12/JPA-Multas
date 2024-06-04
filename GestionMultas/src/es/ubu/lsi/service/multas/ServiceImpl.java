package es.ubu.lsi.service.multas;

import java.util.Date;
import java.util.List;

import es.ubu.lsi.model.multas.Vehiculo;
import es.ubu.lsi.service.PersistenceException;
import es.ubu.lsi.service.PersistenceService;

public class ServiceImpl extends PersistenceService implements Service {

	private VehiculoDAO vehiculoDao;
	
	private ConductorDAO conductorDAO;
	
	private TipoIncidenciaDAO tipoIncidenciaDAO;
	
	private IncidenciaDAO incidenciaDAO;
	

	@Override
	public void insertarIncidencia(Date fecha, String nif, long tipo) throws PersistenceException {
		// TODO Auto-generated method stub
		Conductor conductor = conductorDAO.findById(nif);
		
		TipoIncidencia tipoIncidencia = tipoIncidenciaDAO.findById(tipo);
		
		if(conductor == null ) {
			
			throw new IncidentException(IncidentError.NOT_EXIST_DRIVER);
			
		} else if (tipoIncidencia == null) {
			
			throw new IncidentException(IncidentError.NOT_EXIST_INCIDENT_TYPE);
		}
		
		int puntosRestantes = conductor.getPuntos() - tipoIncidencia.getValor();
		
		if (puntosRestantes < 0) {
			
			throw new IncidentException(IncidentError.NOT_AVAILABLE_POINTS);
		}
		
		conductor.setPuntos(puntosRestantes);
		
		Incidencia incidencia = new Incidencia();
		
		IncidenciaPK id = incidencia.new IncidenciaPK();
		
		id.setFecha(fecha);
		
		id.setNif(nif);
		
		incidencia.setId(id);
		
		incidencia.setConductor(conductor);
		
		incidencia.setTipoIncidencia(tipoIncidencia);
		
		incidencia.setAnotacion("");
		
		incidenciaDAO.persist(incidencia);
	}

	@Override
	public void indultar(String nif) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vehiculo> consultarVehiculos() throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

}
