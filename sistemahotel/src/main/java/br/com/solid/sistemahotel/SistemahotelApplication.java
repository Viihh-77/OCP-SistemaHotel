package br.com.solid.sistemahotel;

import br.com.solid.sistemahotel.domain.Pagamento;
import br.com.solid.sistemahotel.service.HotelService;
import br.com.solid.sistemahotel.view.AppSistemaHotel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

public class SistemahotelApplication {

	public static void main(String[] args) {

		HotelService hotelService = new HotelService();

		String resultado = hotelService.gerenciamentoHotel();
		System.out.println(resultado);

	}

}
