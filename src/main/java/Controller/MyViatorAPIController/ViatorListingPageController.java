package Controller.MyViatorAPIController;

import Beans.ViatorAPIBeans.Taxonomy.TaxonomyDestinationsAPIJSON;
import DAOs.ViatorAPIDAOs.TaxonomyAPIDAO;
import DAOs.ViatorDBDAOs.*;
import Beans.ViatorDBBeans.ViatorCategoriesBean;
import Beans.ViatorDBBeans.ViatorDestinationsBean;
import Beans.ViatorDBBeans.ViatorProductDetailsBean;
import APIJSONs.MyViatorAPIJSONs.ListingPage.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by George on 07/07/2017.
 */
@RestController
public class ViatorListingPageController {



    @RequestMapping("/dest")
    public TaxonomyDestinationsAPIJSON dest(){

        return TaxonomyAPIDAO.retrieveDestinations();
    }

    /**
     * Retrieving attractions by seoId,title,city,destination id or
     * a combination of those attributes.Capability of sorting by REVIEW_AVG_RATING_D,
     * REVIEW_AVG_RATING_A,ALPHABETICAL.
     */
    @RequestMapping(value = "/getAttractions", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public AttractionsListingPageJSON getAttractions(@RequestBody GetAttractionsDAOParams params){

        AttractionsListingPageJSON attractionsListingPageJSON =new AttractionsListingPageJSON();

        /**
         * Get Attractions
         */
        attractionsListingPageJSON.setAttractions(ViatorAttractionsDAO.getAttractions(params));
        if(attractionsListingPageJSON.getAttractions()==null)
            attractionsListingPageJSON.setDBError(true);

        return attractionsListingPageJSON;
    }


    /**
     * Retrieving products by code,title,country,city,region,destination id,primary destination id or
     * a combination of those attributes.Capability of filtering by categories and sort by REVIEW_AVG_RATING_D,
     * REVIEW_AVG_RATING_A, POPULARITY, PRICE_D, PRICE_a, DURATION_D, DURATION_A.Also filtering by dates.Returns
     * all categories and how many products has each category for the specific search.
     */
    @RequestMapping(value = "/getProductsAndCategories", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public ProductsCategoriesListingPageJSON getProductsAndCategories(@RequestBody GetProductsDAOParams params){

        ProductsCategoriesListingPageJSON productsCategoriesListingPageJSON =new ProductsCategoriesListingPageJSON();
        List<Integer> catIds=new ArrayList<>();
        List <ViatorProductDetailsBean>  products;
        int i=0;

//        ZonedDateTime startDate;//todo remove dates
//        ZonedDateTime endDate;
//        endDate=ZonedDateTime.of ( LocalDate.of ( 2017 , 10 , 2 ) ,//todo remove this code
//                                   LocalTime.of ( 9 , 30 ) , ZoneId.of ( "America/New_York" ) );
//        startDate=ZonedDateTime.of (LocalDate.of ( 2017 , 9 , 30 ) ,
//                                    LocalTime.of ( 9 , 30 ) , ZoneId.of ( "America/New_York" ) );
//        params.setEndDate(endDate);
//        params.setStartDate(startDate);

        /**
         * Get products
         */
       // productsCategoriesListingPageJSON.setProducts(ViatorProductDetailsDAO.getProducts(params));

        /**
         * Get all categories/subcategories and Find products count for each category
         */
        CategoriesJson categoriesJson;
        categoriesJson =getAllViatorCategories();
        for(Category cat: categoriesJson.getCategories()){
            catIds.clear();
            catIds.add(cat.getCategory().getId());
           // params.setCategories(catIds);//todo remove //
            products=ViatorProductDetailsDAO.getProducts(params);
            if(products!=null)
               categoriesJson.getCategories().get(i).getCategory().setProductCount(products.size());
            i++;
        }
        productsCategoriesListingPageJSON.setCategories(categoriesJson);
        if(productsCategoriesListingPageJSON.getProducts()==null || productsCategoriesListingPageJSON.getCategories().isDBError())
            productsCategoriesListingPageJSON.setDBError(true);

        return productsCategoriesListingPageJSON;
    }

    @RequestMapping("/getAllViatorCategories")
    public CategoriesJson getAllViatorCategories(){
        CategoriesJson categoriesJson =new CategoriesJson();
        Category category;
        List<ViatorCategoriesBean> categories=ViatorCategoriesDAO.getAllCategories();
        if(categories!=null) {
            for (ViatorCategoriesBean cat : categories) {
                category = new Category();
                category.setCategory(cat);
                category.setSubcategories(ViatorSubcategoriesDAO.getSubcategoriesByCategoriId(cat.getId()));
                categoriesJson.getCategories().add(category);
            }
        }else
            categoriesJson.setDBError(true);
        return categoriesJson;
    }

    @RequestMapping("/getAllViatorCountries")
    public DestinationsJSON getAllCountries(){
        List<ViatorDestinationsBean> countries=new ArrayList<>();
        List<ViatorDestinationsBean> destinations;
        DestinationsJSON destinationsJSON=new DestinationsJSON();
        destinations=ViatorDestinationsDAO.getAllDestinations();
        if(destinations!=null) {
            for (ViatorDestinationsBean destination : destinations) {
                if (destination.getDestinationType().equals("COUNTRY"))
                    countries.add(destination);
            }
            destinationsJSON.setDestinations(countries);
        }else
            destinationsJSON.setDBError(true);
        return destinationsJSON;
    }

    @RequestMapping("/getRegionsOfCountry")
    public  DestinationsJSON getRegionsOfCountry(@RequestParam (value="countryId", defaultValue="0") int destId){
        List<ViatorDestinationsBean> regions=new ArrayList<>();
        List<ViatorDestinationsBean> destinations;
        DestinationsJSON destinationsJSON=new DestinationsJSON();
        String[] split;
        destinations=ViatorDestinationsDAO.getAllDestinations();
        if(destinations!=null) {
            for (ViatorDestinationsBean destination : destinations) {
                split = destination.getLookupId().split(Pattern.quote("."));
                if (split[1].equals(Integer.toString(destId)) && destination.getDestinationType().equals("REGION"))
                    regions.add(destination);
            }
            destinationsJSON.setDestinations(regions);
        }else
            destinationsJSON.setDBError(true);
        return destinationsJSON;
    }

    @RequestMapping("/getCitiesOfCountry")
    public  DestinationsJSON getCitiesOfCountry(@RequestParam (value="countryId", defaultValue="0") int destId){
        List<ViatorDestinationsBean> cities=new ArrayList<>();
        List<ViatorDestinationsBean> destinations;
        DestinationsJSON destinationsJSON=new DestinationsJSON();
        String[] split;
        destinations=ViatorDestinationsDAO.getAllDestinations();
        if(destinations!=null) {
            for (ViatorDestinationsBean destination : destinations) {
                split = destination.getLookupId().split(Pattern.quote("."));
                if (split[1].equals(Integer.toString(destId)) && destination.getDestinationType().equals("CITY"))
                    cities.add(destination);
            }
            destinationsJSON.setDestinations(cities);
        }else
            destinationsJSON.setDBError(true);
        return destinationsJSON;
    }

//    @RequestMapping(value = "/getLastDateWithAvailbilityInfo", method = RequestMethod.POST,consumes = "application/json")
//    @ResponseBody
//    public List<CustomDate>  getLastDateWithAvailbilityInfo(@RequestBody GetProductsDAOParams params){
//
//        List<CustomDate> dates;
//
//        params.setStartDate(null);
//        params.setEndDate(null);
//        ProductsAndCategoriesJSON productsCategoriesListingPageJSON=getProductsAndCategories( params);
//        System.out.print(productsCategoriesListingPageJSON.getProducts().get(0).getCode());
//        dates= ViatorNoneAvailableDatesDAO.getNoneAvailDatesOfProducts(productsCategoriesListingPageJSON.getProducts());
//        return dates;
//    }

}
