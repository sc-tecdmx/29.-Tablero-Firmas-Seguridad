package mx.gob.tecdmx.tablerofirmas.api.uadscripcionareas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.tecdmx.tablerofirmas.entity.inst.InstCatAreas;
import mx.gob.tecdmx.tablerofirmas.entity.inst.InstUAdscripcion;
import mx.gob.tecdmx.tablerofirmas.entity.tab.TabCatTipoDocumento;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstCatAreasRepository;
import mx.gob.tecdmx.tablerofirmas.repository.inst.InstUAdscripcionRepository;
import mx.gob.tecdmx.tablerofirmas.repository.tab.TabCatTipoDocumentoRepository;
import mx.gob.tecdmx.tablerofirmas.utils.DTOResponse;

@Service
public class ServiceUadcripcionAreas {

	@Autowired
	InstCatAreasRepository instCatAreasRepository;
	@Autowired
	InstUAdscripcionRepository instUAdscripcionRepository;
	
	@Autowired
	TabCatTipoDocumentoRepository tabCatTipoDocumentoRepository;

	public boolean createUadcripcionAreas(PayloadUadcripcionAreas payload, InstUAdscripcion uAdscripcionParent, InstCatAreas areaParent) {
		InstUAdscripcion uAdscripcion = new InstUAdscripcion();
		if(payload.isUnidadAdscripcion) {
			uAdscripcion.setDescripcionUnidad(payload.getArea());
			uAdscripcion.setAbreviacionUnidad(payload.getAbreviatura());
			uAdscripcionParent = instUAdscripcionRepository.save(uAdscripcion);
		}
		InstCatAreas catArea = new InstCatAreas();
		catArea.setIdUnAdscripcion(uAdscripcionParent);
		catArea.setDescArea(payload.getArea());
		catArea.setAbrevArea(payload.getAbreviatura());
		catArea.setIdCatAreaPadre(areaParent);
		InstCatAreas catAreaStored = instCatAreasRepository.save(catArea);
		
		List<PayloadUadcripcionAreas> areasPayload = payload.getAreas();
		for(PayloadUadcripcionAreas areaPayload: areasPayload) {
			createUadcripcionAreas(areaPayload, uAdscripcionParent, catAreaStored);
		}
		return true;
	}

	public DTOResponse createUadcripcionAreas(PayloadUadcripcionAreas payload, DTOResponse response) {
		InstUAdscripcion uAdscripcion = new InstUAdscripcion();
		try {
			createUadcripcionAreas(payload, null, null);
			response.setMessage("Se han creado las unidades de adscripción y áreas satisfactoriamente");
			response.setStatus("OK");
			response.setData(true);
		}catch(Exception e) {
			response.setMessage(e+"");
			response.setStatus("OK");
			response.setData(true);
		}
		return response;
	}
	
	public DTOResponse createTipoDocByArea(List<PayloadTipoDocByArea> payloadList, DTOResponse response) {
		for(PayloadTipoDocByArea payload: payloadList) {
			Optional<InstCatAreas> catArea = instCatAreasRepository.findByAbrevArea(payload.getCodigoArea());
			if(catArea.isPresent()) {
				TabCatTipoDocumento tipoDOc = new TabCatTipoDocumento();
				tipoDOc.setDescTipoDocumento(payload.getTipoDocumento());
				tipoDOc.setIdCatArea(catArea.get());
				tabCatTipoDocumentoRepository.save(tipoDOc);
			}else {
				System.out.println("No se pudo crear el tipo de documento");
			}
		}
		
		response.setData(true);
		response.setMessage("Se han creado los tipos de documentos satisfactoriamente");
		response.setStatus("OK");
		return response;
	}

	
}
