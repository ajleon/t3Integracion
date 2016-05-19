/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;

/**
 *
 * @author alberto
 */
@WebService(serviceName = "AirportsCitiesAlberto")
public class AirportsCitiesAlberto {

    /**
     * This is a sample web service operation
     */
     @WebMethod(operationName = "obtenerCiudadesYAeropuertos")
  public String[] obtenerCiudades(@WebParam(name = "pais") String pais) {
    // se crea cliente para servicio global weather
    GlobalWeather gw = new GlobalWeather();
    Airport a = new Airport();

    // se obtiene cliente soap
    GlobalWeatherSoap gwSoap = gw.getGlobalWeatherSoap();
    AirportSoap aSoap = a.getAirportSoap();
    // se llama a servicio
    // llamada se produce de manera síncrona, por lo que el retorno
    // queda en variable cities
    String cities = gwSoap.getCitiesByCountry(pais);
    String airports = aSoap.getAirportInformationByCountry(pais);
   
    String[] citiesAirport = new String[2];
   
    citiesAirport[0] = cities;
    citiesAirport[1] = airports;
    return citiesAirport;
  }
}
