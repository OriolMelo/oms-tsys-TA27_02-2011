package oms.UD27.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oms.UD27.dao.ICientificoDAO;
import oms.UD27.dto.Cientifico;

@Service
public class CientificoServiceImpl implements ICientificoService{

	@Autowired
	ICientificoDAO iCientificoDAO;

	@Override
	public List<Cientifico> listarCientifico() {
		return iCientificoDAO.findAll();
	}

	@Override
	public Cientifico guardarCientifico(Cientifico cientifico) {
		return iCientificoDAO.save(cientifico);
	}

	@Override
	public Cientifico cientificoXID(String id) {
		return iCientificoDAO.findById(id).get();
	}

	@Override
	public Cientifico actualizarCientifico(Cientifico cientifico) {
		return iCientificoDAO.save(cientifico);
	}

	@Override
	public void eliminarCientifico(String id) {
		iCientificoDAO.deleteById(id);
	}
}
