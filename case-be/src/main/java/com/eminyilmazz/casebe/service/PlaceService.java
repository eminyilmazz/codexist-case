package com.eminyilmazz.casebe.service;

import com.eminyilmazz.casebe.entity.Location;
import com.eminyilmazz.casebe.entity.Place;
import com.eminyilmazz.casebe.repository.PlaceRepository;
import com.eminyilmazz.casebe.entity.dto.LocationDTO;
import com.eminyilmazz.casebe.entity.dto.PlaceDTO;
import com.eminyilmazz.casebe.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceService {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(PlaceService.class);
    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<PlaceDTO> getPlaces(LocationDTO dto) throws JsonProcessingException {
        //TODO: implement logic to get places from google nearby places api
        String resp = dummyPlaces();
        List<PlaceDTO> places = Util.parseResponse(resp);
        logger.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(places));
        return places;
    }

    private String dummyPlaces() {
        //return sample response until API is implemented
        return "{\"html_attributions\":[],\"results\":[{\"business_status\":\"OPERATIONAL\",\"geometry\":{\"location\":{\"lat\":-33.8712692,\"lng\":151.1898651},\"viewport\":{\"northeast\":{\"lat\":-33.86952792010727,\"lng\":151.1914560298927},\"southwest\":{\"lat\":-33.87222757989272,\"lng\":151.1887563701073}}},\"icon\":\"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\"icon_background_color\":\"#7B9EB0\",\"icon_mask_base_uri\":\"https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet\",\"name\":\"Glass Island\",\"opening_hours\":{\"open_now\":false},\"photos\":[{\"height\":4480,\"html_attributions\":[\"<a href=\\\"https://maps.google.com/maps/contrib/117745044320706972021\\\">A Google User</a>\"]}],\"place_id\":\"ChIJnScuboavEmsRyh-FGxhc3pw\",\"plus_code\":{\"compound_code\":\"45HQ+FW Pyrmont, New South Wales\",\"global_code\":\"4RRH45HQ+FW\"},\"rating\":4.1,\"reference\":\"ChIJnScuboavEmsRyh-FGxhc3pw\",\"scope\":\"GOOGLE\",\"types\":[\"bar\",\"restaurant\",\"food\",\"point_of_interest\",\"establishment\"],\"user_ratings_total\":90,\"vicinity\":\"37 Bank St, Pyrmont\"},{\"business_status\":\"OPERATIONAL\",\"geometry\":{\"location\":{\"lat\":-33.85876140000001,\"lng\":151.2100004},\"viewport\":{\"northeast\":{\"lat\":-33.85737742010728,\"lng\":151.2111319298927},\"southwest\":{\"lat\":-33.86007707989272,\"lng\":151.2084322701072}}},\"icon\":\"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png\",\"icon_background_color\":\"#FF9E67\",\"icon_mask_base_uri\":\"https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet\",\"name\":\"Junk Lounge\",\"opening_hours\":{\"open_now\":false},\"photos\":[{\"height\":608,\"html_attributions\":[\"<a href=\\\"https://maps.google.com/maps/contrib/104473997089847488714\\\">A Google User</a>\"]}],\"place_id\":\"ChIJq9W3HZOvEmsRYtKNTRmq34M\",\"plus_code\":{\"compound_code\":\"46R6+F2 The Rocks, New South Wales\",\"global_code\":\"4RRH46R6+F2\"},\"price_level\":2,\"rating\":4.1,\"reference\":\"ChIJq9W3HZOvEmsRYtKNTRmq34M\",\"scope\":\"GOOGLE\",\"types\":[\"restaurant\",\"food\",\"point_of_interest\",\"establishment\"],\"user_ratings_total\":63,\"vicinity\":\"Level 2, Overseas Passenger Terminal, Circular Quay W, The Rocks\"},{\"business_status\":\"OPERATIONAL\",\"geometry\":{\"location\":{\"lat\":-33.8677035,\"lng\":151.2017297},\"viewport\":{\"northeast\":{\"lat\":-33.86634597010728,\"lng\":151.2031781298927},\"southwest\":{\"lat\":-33.86904562989272,\"lng\":151.2004784701072}}},\"icon\":\"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\"icon_background_color\":\"#7B9EB0\",\"icon_mask_base_uri\":\"https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet\",\"name\":\"Sydney New Year's Eve Cruises\",\"opening_hours\":{\"open_now\":true},\"photos\":[{\"height\":1600,\"html_attributions\":[\"<a href=\\\"https://maps.google.com/maps/contrib/115281801304517408477\\\">A Google User</a>\"]}],\"place_id\":\"ChIJ__8_hziuEmsR27ucFXECfOg\",\"plus_code\":{\"compound_code\":\"46J2+WM Sydney, New South Wales\",\"global_code\":\"4RRH46J2+WM\"},\"rating\":5,\"reference\":\"ChIJ__8_hziuEmsR27ucFXECfOg\",\"scope\":\"GOOGLE\",\"types\":[\"travel_agency\",\"restaurant\",\"food\",\"point_of_interest\",\"establishment\"],\"user_ratings_total\":5,\"vicinity\":\"King Street Wharf 5, 32 The Promenade, Sydney\"},{\"business_status\":\"OPERATIONAL\",\"geometry\":{\"location\":{\"lat\":-33.8669866,\"lng\":151.2017231},\"viewport\":{\"northeast\":{\"lat\":-33.86563197010727,\"lng\":151.2031347298927},\"southwest\":{\"lat\":-33.86833162989272,\"lng\":151.2004350701073}}},\"icon\":\"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\"icon_background_color\":\"#13B5C7\",\"icon_mask_base_uri\":\"https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet\",\"name\":\"King Street Wharf Darling Harbour\",\"opening_hours\":{\"open_now\":true},\"photos\":[{\"height\":3024,\"html_attributions\":[\"<a href=\\\"https://maps.google.com/maps/contrib/101920674986627213698\\\">朱品貞</a>\"]}],\"place_id\":\"ChIJkfDzJ72vEmsR8xtYbk5f0p0\",\"plus_code\":{\"compound_code\":\"46M2+6M Sydney, New South Wales\",\"global_code\":\"4RRH46M2+6M\"},\"rating\":4.4,\"reference\":\"ChIJkfDzJ72vEmsR8xtYbk5f0p0\",\"scope\":\"GOOGLE\",\"types\":[\"tourist_attraction\",\"convenience_store\",\"bowling_alley\",\"travel_agency\",\"bar\",\"restaurant\",\"food\",\"point_of_interest\",\"store\",\"establishment\"],\"user_ratings_total\":3213,\"vicinity\":\"The Promenade, Lime St, Sydney\"},{\"business_status\":\"OPERATIONAL\",\"geometry\":{\"location\":{\"lat\":-33.870383,\"lng\":151.1979245},\"viewport\":{\"northeast\":{\"lat\":-33.86901092010727,\"lng\":151.1991702798927},\"southwest\":{\"lat\":-33.87171057989271,\"lng\":151.1964706201073}}},\"icon\":\"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/restaurant-71.png\",\"icon_background_color\":\"#FF9E67\",\"icon_mask_base_uri\":\"https://maps.gstatic.com/mapfiles/place_api/icons/v2/restaurant_pinlet\",\"name\":\"The Little Snail Restaurant\",\"opening_hours\":{\"open_now\":false},\"photos\":[{\"height\":900,\"html_attributions\":[\"<a href=\\\"https://maps.google.com/maps/contrib/114727320476039103791\\\">The Little Snail</a>\"]}],\"place_id\":\"ChIJtwapWjeuEmsRcxV5JARHpSk\",\"plus_code\":{\"compound_code\":\"45HX+R5 Pyrmont, New South Wales\",\"global_code\":\"4RRH45HX+R5\"},\"price_level\":2,\"rating\":4.5,\"reference\":\"ChIJtwapWjeuEmsRcxV5JARHpSk\",\"scope\":\"GOOGLE\",\"types\":[\"restaurant\",\"food\",\"point_of_interest\",\"establishment\"],\"user_ratings_total\":1916,\"vicinity\":\"3/50 Murray St, Pyrmont\"}],\"status\":\"OK\"}";

    }

    protected void save(List<PlaceDTO> dto, Location location) {
        List<Place> places = dto.stream()
                        .map(PlaceDTO::toEntity)
                        .toList();
        for (Place place : places) {
            place.setLocation(location);
        }
        placeRepository.saveAll(places);
    }
}
