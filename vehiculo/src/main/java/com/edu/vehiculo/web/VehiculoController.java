package com.edu.vehiculo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.vehiculo.model.Vehiculo;

@Controller
public class VehiculoController {
	
	@GetMapping("/evaluar")
	public String formulario(Model model) {
		model.addAttribute("automovil", new Vehiculo());
		return "formAutomovil";
	}
	
	@PostMapping("/evaluar")
	public String calculo(@ModelAttribute Vehiculo automovil) {
		
		String marca = automovil.getMarca(); 
		double consumo = 0.0;
		double recorrido = automovil.getRecorrido();
		
		switch (marca) {
		case "marca1":
			consumo = recorrido / 40;
			break;
		case "marca2":
			consumo = recorrido / 35;
			break;	
		default:
			consumo = recorrido / 45;
			break;
		}
				
		automovil.setConsumo(consumo);
		
		automovil.setMensaje("Estimado " + automovil.getNombre().toUpperCase() + 
				" el vehículo " + automovil.getMarca() + 
				" consume " + automovil.getConsumo() + 
				" galones por km.");
		
		return "calculoAutomovil";
	}
	
}
