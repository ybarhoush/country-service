package com.example.countryservice;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import com.example.countryservice.entities.Countries;
import com.example.countryservice.entities.Country;
import com.example.countryservice.entities.GetResponse;
import com.example.countryservice.entities.PostResponse;
import com.example.countryservice.services.CountryWebService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = CountryServiceApplication.class)
@AutoConfigureMockMvc 
@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
public class CountryWebRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void givenCountries_whenGetCountries_thenStatus200() throws Exception {
        
		Countries country = new Countries("Afghanistan", "AF");
        //Countries country2 = new Countries("Albania", "AL");

        //List<Countries> listname = Arrays.asList(country, country2);

        mvc.perform(get("/countries")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			//.andExpect(jsonPath("$.capital", hasSize(0)))
            .andExpect(jsonPath("$.[0].name", is(country.getName())))
            .andExpect(jsonPath("$.[0].country_code", is(country.getCountryCode())));
    }

    @Test
    public void givenCountry_whenGetCountry_thenStatus200() throws Exception {

		Country country = new Country("Nigeria", "NG", "Abuja", 195874740, "https://upload.wikimedia.org/wikipedia/commons/7/79/Flag_of_Nigeria.svg");

        mvc.perform(get("/countries/Nigeria")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			//.andExpect(jsonPath("$.capital", hasSize(0)))
            .andExpect(jsonPath("$.name", is(country.getName())))
            .andExpect(jsonPath("$.country_code", is(country.getCountryCode())))
			.andExpect(jsonPath("$.capital", is(country.getCapital())))
            .andExpect(jsonPath("$.population", is(country.getPopulation())))
            .andExpect(jsonPath("$.flag_file_url", is(country.getFlagFileUrl())));
        //verify(service, VerificationModeFactory.times(1)).findByName("Nigiria");
        //reset(service);
    }

    @Test
    public void whenUsingAnnotations_whenConsumeNameAndCountryCode_thenOk() throws IOException {

        // POST Get Single Country and ISO2&3 Codes, https://countriesnow.space/api/v0.1/countries/iso, get single country with its ISO2&3 Code
        String jsonString = "{\"error\":false,\"msg\":\"country's ISO code retrieved\",\"data\":{\"name\":\"Nigeria\",\"Iso2\":\"NG\",\"Iso3\":\"NGA\"}}";
        PostResponse data = new ObjectMapper()
            .readerFor(PostResponse.class)
            .readValue(jsonString);
    
        assertEquals(data.getData().getCountry(), "Nigeria");
        assertEquals(data.getData().getIso2(), "NG");
    }

    @Test
    public void whenUsingAnnotations_whenConsumeCapital_thenOk() throws IOException {

        // POST Get a single country and capital, https://countriesnow.space/api/v0.1/countries/capital, Get a specific country and its capital
        String jsonString = "{\"error\":false,\"msg\":\"countryandcapitalsretrieved\",\"data\":{\"name\":\"Nigeria\",\"capital\":\"Abuja\",\"iso2\":\"NG\",\"iso3\":\"NGA\"}}";
        PostResponse data = new ObjectMapper()
            .readerFor(PostResponse.class)
            .readValue(jsonString);
    
        assertEquals(data.getData().getCapital(), "Abuja");
    }

    @Test
    public void whenUsingAnnotations_whenConsumePopulation_thenOk() throws IOException {

        // POST Get single country and population data, https://countriesnow.space/api/v0.1/countries/population, Get single country and population data
        String jsonString = "{\"error\":false,\"msg\":\"Nigeriawithpopulation\",\"data\":{\"country\":\"Nigeria\",\"code\":\"NGA\",\"iso3\":\"NGA\",\"populationCounts\":[{\"year\":1960,\"value\":45138458},{\"year\":1961,\"value\":46063563},{\"year\":1962,\"value\":47029822},{\"year\":1963,\"value\":48032934},{\"year\":1964,\"value\":49066760},{\"year\":1965,\"value\":50127921},{\"year\":1966,\"value\":51217973},{\"year\":1967,\"value\":52342233},{\"year\":1968,\"value\":53506196},{\"year\":1969,\"value\":54717039},{\"year\":1970,\"value\":55982144},{\"year\":1971,\"value\":57296983},{\"year\":1972,\"value\":58665808},{\"year\":1973,\"value\":60114625},{\"year\":1974,\"value\":61677177},{\"year\":1975,\"value\":63374298},{\"year\":1976,\"value\":65221378},{\"year\":1977,\"value\":67203128},{\"year\":1978,\"value\":69271917},{\"year\":1979,\"value\":71361131},{\"year\":1980,\"value\":73423633},{\"year\":1981,\"value\":75440502},{\"year\":1982,\"value\":77427546},{\"year\":1983,\"value\":79414840},{\"year\":1984,\"value\":81448755},{\"year\":1985,\"value\":83562785},{\"year\":1986,\"value\":85766399},{\"year\":1987,\"value\":88048032},{\"year\":1988,\"value\":90395271},{\"year\":1989,\"value\":92788027},{\"year\":1990,\"value\":95212450},{\"year\":1991,\"value\":97667632},{\"year\":1992,\"value\":100161710},{\"year\":1993,\"value\":102700753},{\"year\":1994,\"value\":105293700},{\"year\":1995,\"value\":107948335},{\"year\":1996,\"value\":110668794},{\"year\":1997,\"value\":113457663},{\"year\":1998,\"value\":116319759},{\"year\":1999,\"value\":119260063},{\"year\":2000,\"value\":122283850},{\"year\":2001,\"value\":125394046},{\"year\":2002,\"value\":128596076},{\"year\":2003,\"value\":131900631},{\"year\":2004,\"value\":135320422},{\"year\":2005,\"value\":138865016},{\"year\":2006,\"value\":142538308},{\"year\":2007,\"value\":146339977},{\"year\":2008,\"value\":150269623},{\"year\":2009,\"value\":154324933},{\"year\":2010,\"value\":158503197},{\"year\":2011,\"value\":162805071},{\"year\":2012,\"value\":167228767},{\"year\":2013,\"value\":171765769},{\"year\":2014,\"value\":176404902},{\"year\":2015,\"value\":181137448},{\"year\":2016,\"value\":185960289},{\"year\":2017,\"value\":190873311},{\"year\":2018,\"value\":195874740}]}}";
        PostResponse data = new ObjectMapper()
            .readerFor(PostResponse.class)
            .readValue(jsonString);
    
        assertEquals(data.getData().getPopulationCounts().size(), 59);
        assertEquals(data.getData().getPopulationCounts().get(58).getYear(), 2018);
        assertEquals(data.getData().getPopulationCounts().get(58).getValue(), 195874740);
    }

    @Test
    public void whenUsingAnnotations_whenConsumeFlag_thenOk() throws IOException {

        // POST Get single country and flag URL, https://countriesnow.space/api/v0.1/countries/flag/images, Get single country with flag image
        String jsonString = "{\"error\":false,\"msg\":\"Nigeriaandflagretrieved\",\"data\":{\"name\":\"Nigeria\",\"flag\":\"https://upload.wikimedia.org/wikipedia/commons/7/79/Flag_of_Nigeria.svg\",\"iso2\":\"NG\",\"iso3\":\"NGA\"}}";
        PostResponse data = new ObjectMapper()
            .readerFor(PostResponse.class)
            .readValue(jsonString);
    
        assertEquals(data.getData().getFlag(), "https://upload.wikimedia.org/wikipedia/commons/7/79/Flag_of_Nigeria.svg");
    }

    @Test
    public void whenUsingAnnotations_whenConsumeNamesAndCountriesCodes_thenOk() throws IOException {

        // GET Get countries and ISO2&3 Codes, https://countriesnow.space/api/v0.1/countries/iso, get all countries with their ISO2&3 Codes
        String jsonString = "{\"error\":false,\"msg\":\"countriesandISOcodesretrieved\",\"data\":[{\"name\":\"Afghanistan\",\"Iso2\":\"AF\",\"Iso3\":\"AFG\"},{\"name\":\"Albania\",\"Iso2\":\"AL\",\"Iso3\":\"ALB\"},{\"name\":\"Algeria\",\"Iso2\":\"DZ\",\"Iso3\":\"DZA\"},{\"name\":\"Andorra\",\"Iso2\":\"AD\",\"Iso3\":\"AND\"},{\"name\":\"Angola\",\"Iso2\":\"AO\",\"Iso3\":\"AGO\"},{\"name\":\"Anguilla\",\"Iso2\":\"AI\",\"Iso3\":\"AIA\"},{\"name\":\"AntiguaandBarbuda\",\"Iso2\":\"AG\",\"Iso3\":\"ATG\"},{\"name\":\"Argentina\",\"Iso2\":\"AR\",\"Iso3\":\"ARG\"},{\"name\":\"Armenia\",\"Iso2\":\"AM\",\"Iso3\":\"ARM\"},{\"name\":\"Aruba\",\"Iso2\":\"AW\",\"Iso3\":\"ABW\"},{\"name\":\"Australia\",\"Iso2\":\"AU\",\"Iso3\":\"AUS\"},{\"name\":\"Austria\",\"Iso2\":\"AT\",\"Iso3\":\"AUT\"},{\"name\":\"Azerbaijan\",\"Iso2\":\"AZ\",\"Iso3\":\"AZE\"},{\"name\":\"Bahamas\",\"Iso2\":\"BS\",\"Iso3\":\"BHS\"},{\"name\":\"Bahrain\",\"Iso2\":\"BH\",\"Iso3\":\"BHR\"},{\"name\":\"Bangladesh\",\"Iso2\":\"BD\",\"Iso3\":\"BGD\"},{\"name\":\"Barbados\",\"Iso2\":\"BB\",\"Iso3\":\"BRB\"},{\"name\":\"Belarus\",\"Iso2\":\"BY\",\"Iso3\":\"BLR\"},{\"name\":\"Belgium\",\"Iso2\":\"BE\",\"Iso3\":\"BEL\"},{\"name\":\"Belize\",\"Iso2\":\"BZ\",\"Iso3\":\"BLZ\"},{\"name\":\"Benin\",\"Iso2\":\"BJ\",\"Iso3\":\"BEN\"},{\"name\":\"Bermuda\",\"Iso2\":\"BM\",\"Iso3\":\"BMU\"},{\"name\":\"Bhutan\",\"Iso2\":\"BT\",\"Iso3\":\"BTN\"},{\"name\":\"BosniaandHerzegovina\",\"Iso2\":\"BA\",\"Iso3\":\"BIH\"},{\"name\":\"Botswana\",\"Iso2\":\"BW\",\"Iso3\":\"BWA\"},{\"name\":\"BouvetIsland\",\"Iso2\":\"BV\",\"Iso3\":\"BVT\"},{\"name\":\"Brazil\",\"Iso2\":\"BR\",\"Iso3\":\"BRA\"},{\"name\":\"BritishIndianOceanTerritory\",\"Iso2\":\"IO\",\"Iso3\":\"IOT\"},{\"name\":\"BruneiDarussalam\",\"Iso2\":null,\"Iso3\":null},{\"name\":\"Bulgaria\",\"Iso2\":\"BG\",\"Iso3\":\"BGR\"},{\"name\":\"BurkinaFaso\",\"Iso2\":\"BF\",\"Iso3\":\"BFA\"},{\"name\":\"Burundi\",\"Iso2\":\"BI\",\"Iso3\":\"BDI\"},{\"name\":\"Cambodia\",\"Iso2\":\"KH\",\"Iso3\":\"KHM\"},{\"name\":\"Cameroon\",\"Iso2\":\"CM\",\"Iso3\":\"CMR\"},{\"name\":\"Canada\",\"Iso2\":\"CA\",\"Iso3\":\"CAN\"},{\"name\":\"CapeVerde\",\"Iso2\":\"CV\",\"Iso3\":\"CPV\"},{\"name\":\"CaymanIslands\",\"Iso2\":\"KY\",\"Iso3\":\"CYM\"},{\"name\":\"CentralAfricanRepublic\",\"Iso2\":\"CF\",\"Iso3\":\"CAF\"},{\"name\":\"Chad\",\"Iso2\":\"TD\",\"Iso3\":\"TCD\"},{\"name\":\"Chile\",\"Iso2\":\"CL\",\"Iso3\":\"CHL\"},{\"name\":\"China\",\"Iso2\":\"CN\",\"Iso3\":\"CHN\"},{\"name\":\"ChristmasIsland\",\"Iso2\":\"CX\",\"Iso3\":\"CXR\"},{\"name\":\"Cocos(Keeling)Islands\",\"Iso2\":null,\"Iso3\":null},{\"name\":\"Colombia\",\"Iso2\":\"CO\",\"Iso3\":\"COL\"},{\"name\":\"Comoros\",\"Iso2\":\"KM\",\"Iso3\":\"COM\"},{\"name\":\"Congo\",\"Iso2\":null,\"Iso3\":null},{\"name\":\"CookIslands\",\"Iso2\":\"CK\",\"Iso3\":\"COK\"},{\"name\":\"CostaRica\",\"Iso2\":\"CR\",\"Iso3\":\"CRI\"},{\"name\":\"Croatia\",\"Iso2\":\"HR\",\"Iso3\":\"HRV\"},{\"name\":\"Cuba\",\"Iso2\":\"CU\",\"Iso3\":\"CUB\"},{\"name\":\"Cyprus\",\"Iso2\":\"CY\",\"Iso3\":\"CYP\"},{\"name\":\"CzechRepublic\",\"Iso2\":\"CZ\",\"Iso3\":\"CZE\"},{\"name\":\"Denmark\",\"Iso2\":\"DK\",\"Iso3\":\"DNK\"},{\"name\":\"Djibouti\",\"Iso2\":\"DJ\",\"Iso3\":\"DJI\"},{\"name\":\"Dominica\",\"Iso2\":\"DM\",\"Iso3\":\"DMA\"},{\"name\":\"DominicanRepublic\",\"Iso2\":\"DO\",\"Iso3\":\"DOM\"},{\"name\":\"Ecuador\",\"Iso2\":\"EC\",\"Iso3\":\"ECU\"},{\"name\":\"Egypt\",\"Iso2\":\"EG\",\"Iso3\":\"EGY\"},{\"name\":\"ElSalvador\",\"Iso2\":\"SV\",\"Iso3\":\"SLV\"},{\"name\":\"EquatorialGuinea\",\"Iso2\":\"GQ\",\"Iso3\":\"GNQ\"},{\"name\":\"Eritrea\",\"Iso2\":\"ER\",\"Iso3\":\"ERI\"},{\"name\":\"Estonia\",\"Iso2\":\"EE\",\"Iso3\":\"EST\"},{\"name\":\"Ethiopia\",\"Iso2\":\"ET\",\"Iso3\":\"ETH\"},{\"name\":\"FalklandIslands(Malvinas)\",\"Iso2\":null,\"Iso3\":null},{\"name\":\"FaroeIslands\",\"Iso2\":\"FO\",\"Iso3\":\"FRO\"},{\"name\":\"Fiji\",\"Iso2\":\"FJ\",\"Iso3\":\"FJI\"},{\"name\":\"Finland\",\"Iso2\":\"FI\",\"Iso3\":\"FIN\"},{\"name\":\"France\",\"Iso2\":\"FR\",\"Iso3\":\"FRA\"},{\"name\":\"FrenchGuiana\",\"Iso2\":\"GF\",\"Iso3\":\"GUF\"},{\"name\":\"FrenchPolynesia\",\"Iso2\":\"PF\",\"Iso3\":\"PYF\"},{\"name\":\"Gabon\",\"Iso2\":\"GA\",\"Iso3\":\"GAB\"},{\"name\":\"Gambia\",\"Iso2\":\"GM\",\"Iso3\":\"GMB\"},{\"name\":\"Georgia\",\"Iso2\":\"GE\",\"Iso3\":\"GEO\"},{\"name\":\"Germany\",\"Iso2\":\"DE\",\"Iso3\":\"DEU\"},{\"name\":\"Ghana\",\"Iso2\":\"GH\",\"Iso3\":\"GHA\"},{\"name\":\"Gibraltar\",\"Iso2\":\"GI\",\"Iso3\":\"GIB\"},{\"name\":\"Greece\",\"Iso2\":\"GR\",\"Iso3\":\"GRC\"},{\"name\":\"Greenland\",\"Iso2\":\"GL\",\"Iso3\":\"GRL\"},{\"name\":\"Grenada\",\"Iso2\":\"GD\",\"Iso3\":\"GRD\"},{\"name\":\"Guadeloupe\",\"Iso2\":\"GP\",\"Iso3\":\"GLP\"},{\"name\":\"Guam\",\"Iso2\":\"GU\",\"Iso3\":\"GUM\"},{\"name\":\"Guatemala\",\"Iso2\":\"GT\",\"Iso3\":\"GTM\"},{\"name\":\"Guernsey\",\"Iso2\":\"GG\",\"Iso3\":\"GGY\"},{\"name\":\"Guinea\",\"Iso2\":\"GN\",\"Iso3\":\"GIN\"},{\"name\":\"Guinea-Bissau\",\"Iso2\":\"GW\",\"Iso3\":\"GNB\"},{\"name\":\"Guyana\",\"Iso2\":\"GY\",\"Iso3\":\"GUY\"},{\"name\":\"Haiti\",\"Iso2\":\"HT\",\"Iso3\":\"HTI\"},{\"name\":\"HeardIslandandMcDonaldIslands\",\"Iso2\":\"HM\",\"Iso3\":\"HMD\"},{\"name\":\"HolySee(VaticanCityState)\",\"Iso2\":null,\"Iso3\":null},{\"name\":\"Honduras\",\"Iso2\":\"HN\",\"Iso3\":\"HND\"},{\"name\":\"HongKong\",\"Iso2\":\"HK\",\"Iso3\":\"HKG\"},{\"name\":\"Hungary\",\"Iso2\":\"HU\",\"Iso3\":\"HUN\"},{\"name\":\"Iceland\",\"Iso2\":\"IS\",\"Iso3\":\"ISL\"},{\"name\":\"India\",\"Iso2\":\"IN\",\"Iso3\":\"IND\"},{\"name\":\"Indonesia\",\"Iso2\":\"ID\",\"Iso3\":\"IDN\"},{\"name\":\"Iran\",\"Iso2\":\"IR\",\"Iso3\":\"IRN\"},{\"name\":\"Iraq\",\"Iso2\":\"IQ\",\"Iso3\":\"IRQ\"},{\"name\":\"Ireland\",\"Iso2\":\"IE\",\"Iso3\":\"IRL\"},{\"name\":\"IsleofMan\",\"Iso2\":\"IM\",\"Iso3\":\"IMN\"},{\"name\":\"Israel\",\"Iso2\":\"IL\",\"Iso3\":\"ISR\"},{\"name\":\"Italy\",\"Iso2\":\"IT\",\"Iso3\":\"ITA\"},{\"name\":\"Jamaica\",\"Iso2\":\"JM\",\"Iso3\":\"JAM\"},{\"name\":\"Japan\",\"Iso2\":\"JP\",\"Iso3\":\"JPN\"},{\"name\":\"Jersey\",\"Iso2\":\"JE\",\"Iso3\":\"JEY\"},{\"name\":\"Jordan\",\"Iso2\":\"JO\",\"Iso3\":\"JOR\"},{\"name\":\"Kazakhstan\",\"Iso2\":\"KZ\",\"Iso3\":\"KAZ\"},{\"name\":\"Kenya\",\"Iso2\":\"KE\",\"Iso3\":\"KEN\"},{\"name\":\"Kiribati\",\"Iso2\":\"KI\",\"Iso3\":\"KIR\"},{\"name\":\"Kuwait\",\"Iso2\":\"KW\",\"Iso3\":\"KWT\"},{\"name\":\"Kyrgyzstan\",\"Iso2\":\"KG\",\"Iso3\":\"KGZ\"},{\"name\":\"LaoPeople'sDemocraticRepublic\",\"Iso2\":null,\"Iso3\":null},{\"name\":\"Latvia\",\"Iso2\":\"LV\",\"Iso3\":\"LVA\"},{\"name\":\"Lebanon\",\"Iso2\":\"LB\",\"Iso3\":\"LBN\"},{\"name\":\"Lesotho\",\"Iso2\":\"LS\",\"Iso3\":\"LSO\"},{\"name\":\"Liberia\",\"Iso2\":\"LR\",\"Iso3\":\"LBR\"},{\"name\":\"Liechtenstein\",\"Iso2\":\"LI\",\"Iso3\":\"LIE\"},{\"name\":\"Lithuania\",\"Iso2\":\"LT\",\"Iso3\":\"LTU\"},{\"name\":\"Luxembourg\",\"Iso2\":\"LU\",\"Iso3\":\"LUX\"},{\"name\":\"Macao\",\"Iso2\":\"MO\",\"Iso3\":\"MAC\"},{\"name\":\"Madagascar\",\"Iso2\":\"MG\",\"Iso3\":\"MDG\"},{\"name\":\"Malawi\",\"Iso2\":\"MW\",\"Iso3\":\"MWI\"},{\"name\":\"Malaysia\",\"Iso2\":\"MY\",\"Iso3\":\"MYS\"},{\"name\":\"Maldives\",\"Iso2\":\"MV\",\"Iso3\":\"MDV\"},{\"name\":\"Mali\",\"Iso2\":\"ML\",\"Iso3\":\"MLI\"},{\"name\":\"Malta\",\"Iso2\":\"MT\",\"Iso3\":\"MLT\"},{\"name\":\"MarshallIslands\",\"Iso2\":\"MH\",\"Iso3\":\"MHL\"},{\"name\":\"Martinique\",\"Iso2\":\"MQ\",\"Iso3\":\"MTQ\"},{\"name\":\"Mauritania\",\"Iso2\":\"MR\",\"Iso3\":\"MRT\"},{\"name\":\"Mauritius\",\"Iso2\":\"MU\",\"Iso3\":\"MUS\"},{\"name\":\"Mayotte\",\"Iso2\":\"YT\",\"Iso3\":\"MYT\"},{\"name\":\"Mexico\",\"Iso2\":\"MX\",\"Iso3\":\"MEX\"},{\"name\":\"Monaco\",\"Iso2\":\"MC\",\"Iso3\":\"MCO\"},{\"name\":\"Mongolia\",\"Iso2\":\"MN\",\"Iso3\":\"MNG\"},{\"name\":\"Montenegro\",\"Iso2\":\"ME\",\"Iso3\":\"MNE\"},{\"name\":\"Montserrat\",\"Iso2\":\"MS\",\"Iso3\":\"MSR\"},{\"name\":\"Morocco\",\"Iso2\":\"MA\",\"Iso3\":\"MAR\"},{\"name\":\"Mozambique\",\"Iso2\":\"MZ\",\"Iso3\":\"MOZ\"},{\"name\":\"Myanmar\",\"Iso2\":\"MM\",\"Iso3\":\"MMR\"},{\"name\":\"Namibia\",\"Iso2\":\"NA\",\"Iso3\":\"NAM\"},{\"name\":\"Nauru\",\"Iso2\":\"NR\",\"Iso3\":\"NRU\"},{\"name\":\"Nepal\",\"Iso2\":\"NP\",\"Iso3\":\"NPL\"},{\"name\":\"Netherlands\",\"Iso2\":\"NL\",\"Iso3\":\"NLD\"},{\"name\":\"NewCaledonia\",\"Iso2\":\"NC\",\"Iso3\":\"NCL\"},{\"name\":\"NewZealand\",\"Iso2\":\"NZ\",\"Iso3\":\"NZL\"},{\"name\":\"Nicaragua\",\"Iso2\":\"NI\",\"Iso3\":\"NIC\"},{\"name\":\"Niger\",\"Iso2\":\"NE\",\"Iso3\":\"NER\"},{\"name\":\"Nigeria\",\"Iso2\":\"NG\",\"Iso3\":\"NGA\"},{\"name\":\"Niue\",\"Iso2\":\"NU\",\"Iso3\":\"NIU\"},{\"name\":\"NorfolkIsland\",\"Iso2\":\"NF\",\"Iso3\":\"NFK\"},{\"name\":\"NorthernMarianaIslands\",\"Iso2\":\"MP\",\"Iso3\":\"MNP\"},{\"name\":\"Norway\",\"Iso2\":\"NO\",\"Iso3\":\"NOR\"},{\"name\":\"Oman\",\"Iso2\":\"OM\",\"Iso3\":\"OMN\"},{\"name\":\"Pakistan\",\"Iso2\":\"PK\",\"Iso3\":\"PAK\"},{\"name\":\"Palau\",\"Iso2\":\"PW\",\"Iso3\":\"PLW\"},{\"name\":\"Panama\",\"Iso2\":\"PA\",\"Iso3\":\"PAN\"},{\"name\":\"PapuaNewGuinea\",\"Iso2\":\"PG\",\"Iso3\":\"PNG\"},{\"name\":\"Paraguay\",\"Iso2\":\"PY\",\"Iso3\":\"PRY\"},{\"name\":\"Peru\",\"Iso2\":\"PE\",\"Iso3\":\"PER\"},{\"name\":\"Philippines\",\"Iso2\":\"PH\",\"Iso3\":\"PHL\"},{\"name\":\"Pitcairn\",\"Iso2\":\"PN\",\"Iso3\":\"PCN\"},{\"name\":\"Poland\",\"Iso2\":\"PL\",\"Iso3\":\"POL\"},{\"name\":\"Portugal\",\"Iso2\":\"PT\",\"Iso3\":\"PRT\"},{\"name\":\"PuertoRico\",\"Iso2\":\"PR\",\"Iso3\":\"PRI\"},{\"name\":\"Qatar\",\"Iso2\":\"QA\",\"Iso3\":\"QAT\"},{\"name\":\"Réunion\",\"Iso2\":null,\"Iso3\":null},{\"name\":\"Romania\",\"Iso2\":\"RO\",\"Iso3\":\"ROU\"},{\"name\":\"Rwanda\",\"Iso2\":\"RW\",\"Iso3\":\"RWA\"},{\"name\":\"SaintKittsandNevis\",\"Iso2\":\"KN\",\"Iso3\":\"KNA\"},{\"name\":\"SaintLucia\",\"Iso2\":\"LC\",\"Iso3\":\"LCA\"},{\"name\":\"SaintPierreandMiquelon\",\"Iso2\":\"PM\",\"Iso3\":\"SPM\"},{\"name\":\"SaintVincentandtheGrenadines\",\"Iso2\":\"VC\",\"Iso3\":\"VCT\"},{\"name\":\"Samoa\",\"Iso2\":\"WS\",\"Iso3\":\"WSM\"},{\"name\":\"SanMarino\",\"Iso2\":\"SM\",\"Iso3\":\"SMR\"},{\"name\":\"SaoTomeandPrincipe\",\"Iso2\":\"ST\",\"Iso3\":\"STP\"},{\"name\":\"SaudiArabia\",\"Iso2\":\"SA\",\"Iso3\":\"SAU\"},{\"name\":\"Senegal\",\"Iso2\":\"SN\",\"Iso3\":\"SEN\"},{\"name\":\"Serbia\",\"Iso2\":\"RS\",\"Iso3\":\"SRB\"},{\"name\":\"Seychelles\",\"Iso2\":\"SC\",\"Iso3\":\"SYC\"},{\"name\":\"SierraLeone\",\"Iso2\":\"SL\",\"Iso3\":\"SLE\"},{\"name\":\"Singapore\",\"Iso2\":\"SG\",\"Iso3\":\"SGP\"},{\"name\":\"Slovakia\",\"Iso2\":\"SK\",\"Iso3\":\"SVK\"},{\"name\":\"Slovenia\",\"Iso2\":\"SI\",\"Iso3\":\"SVN\"},{\"name\":\"SolomonIslands\",\"Iso2\":\"SB\",\"Iso3\":\"SLB\"},{\"name\":\"Somalia\",\"Iso2\":\"SO\",\"Iso3\":\"SOM\"},{\"name\":\"SouthAfrica\",\"Iso2\":\"ZA\",\"Iso3\":\"ZAF\"},{\"name\":\"SouthGeorgiaandtheSouthSandwichIslands\",\"Iso2\":\"GS\",\"Iso3\":\"SGS\"},{\"name\":\"Spain\",\"Iso2\":\"ES\",\"Iso3\":\"ESP\"},{\"name\":\"SriLanka\",\"Iso2\":\"LK\",\"Iso3\":\"LKA\"},{\"name\":\"Sudan\",\"Iso2\":\"SD\",\"Iso3\":\"SDN\"},{\"name\":\"Suriname\",\"Iso2\":\"SR\",\"Iso3\":\"SUR\"},{\"name\":\"Swaziland\",\"Iso2\":\"SZ\",\"Iso3\":\"SWZ\"},{\"name\":\"Sweden\",\"Iso2\":\"SE\",\"Iso3\":\"SWE\"},{\"name\":\"Switzerland\",\"Iso2\":\"CH\",\"Iso3\":\"CHE\"},{\"name\":\"SyrianArabRepublic\",\"Iso2\":null,\"Iso3\":null},{\"name\":\"Taiwan\",\"Iso2\":\"TW\",\"Iso3\":\"TWN\"},{\"name\":\"Tajikistan\",\"Iso2\":\"TJ\",\"Iso3\":\"TJK\"},{\"name\":\"Thailand\",\"Iso2\":\"TH\",\"Iso3\":\"THA\"},{\"name\":\"Timor-Leste\",\"Iso2\":null,\"Iso3\":null},{\"name\":\"Togo\",\"Iso2\":\"TG\",\"Iso3\":\"TGO\"},{\"name\":\"Tokelau\",\"Iso2\":\"TK\",\"Iso3\":\"TKL\"},{\"name\":\"Tonga\",\"Iso2\":\"TO\",\"Iso3\":\"TON\"},{\"name\":\"TrinidadandTobago\",\"Iso2\":\"TT\",\"Iso3\":\"TTO\"},{\"name\":\"Tunisia\",\"Iso2\":\"TN\",\"Iso3\":\"TUN\"},{\"name\":\"Turkey\",\"Iso2\":\"TR\",\"Iso3\":\"TUR\"},{\"name\":\"Turkmenistan\",\"Iso2\":\"TM\",\"Iso3\":\"TKM\"},{\"name\":\"TurksandCaicosIslands\",\"Iso2\":\"TC\",\"Iso3\":\"TCA\"},{\"name\":\"Tuvalu\",\"Iso2\":\"TV\",\"Iso3\":\"TUV\"},{\"name\":\"Uganda\",\"Iso2\":\"UG\",\"Iso3\":\"UGA\"},{\"name\":\"Ukraine\",\"Iso2\":\"UA\",\"Iso3\":\"UKR\"},{\"name\":\"UnitedArabEmirates\",\"Iso2\":\"AE\",\"Iso3\":\"ARE\"},{\"name\":\"UnitedKingdom\",\"Iso2\":\"GB\",\"Iso3\":\"GBR\"},{\"name\":\"UnitedStates\",\"Iso2\":\"US\",\"Iso3\":\"USA\"},{\"name\":\"UnitedStatesMinorOutlyingIslands\",\"Iso2\":\"UM\",\"Iso3\":\"UMI\"},{\"name\":\"Uruguay\",\"Iso2\":\"UY\",\"Iso3\":\"URY\"},{\"name\":\"Uzbekistan\",\"Iso2\":\"UZ\",\"Iso3\":\"UZB\"},{\"name\":\"Vanuatu\",\"Iso2\":\"VU\",\"Iso3\":\"VUT\"},{\"name\":\"VietNam\",\"Iso2\":null,\"Iso3\":null},{\"name\":\"WallisandFutuna\",\"Iso2\":\"WF\",\"Iso3\":\"WLF\"},{\"name\":\"Yemen\",\"Iso2\":\"YE\",\"Iso3\":\"YEM\"},{\"name\":\"Zambia\",\"Iso2\":\"ZM\",\"Iso3\":\"ZMB\"},{\"name\":\"Zimbabwe\",\"Iso2\":\"ZW\",\"Iso3\":\"ZWE\"}]}";
        GetResponse datum = new ObjectMapper()
            .readerFor(GetResponse.class)
            .readValue(jsonString);
    
        assertEquals(datum.getData().size(), 221);
        assertEquals(datum.getData().get(0).getName(), "Afghanistan");
        assertEquals(datum.getData().get(0).getIso2(), "AF");
        assertEquals(datum.getData().get(1).getName(), "Albania");
        assertEquals(datum.getData().get(1).getIso2(), "AL");
    }
    
}