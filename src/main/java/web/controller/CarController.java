package web.controller;

import Service.CarService;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {


	private final CarService carService;

	public CarController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping()
	public String getCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
		List<Car> cars = carService.getCars(count);
		model.addAttribute("cars", cars);
		return "cars";
	}
}