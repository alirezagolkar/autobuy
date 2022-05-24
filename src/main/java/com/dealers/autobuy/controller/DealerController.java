package com.dealers.autobuy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dealers.autobuy.json.JsonResult;
import com.dealers.autobuy.model.Dealer;
import com.dealers.autobuy.model.Vehicle;
import com.dealers.autobuy.service.IDealerService;
import com.dealers.autobuy.uri.ApiEnum;
import com.dealers.autobuy.utils.RestUtils;

/**
 * Rest Controller for dealers
 * @author Ali Golkar
 */
@RestController
@RequestMapping(path = ApiEnum.EndPoints.DEALER)
public class DealerController extends RestUtils<IDealerService> {
    private static final Logger logger = LoggerFactory.getLogger(DealerController.class);

    @GetMapping("{id}")
    public JsonResult findById(@PathVariable("id") Integer id) {
        logger.info("DealerController: findById");
        Dealer dealer = this.service.findById(id);
        if (dealer == null) {
            logger.info("Dealer does not exist for ID: " + id);
            return JsonResult.create(JsonResult.STATUS_ERROR, "Dealer does not exist for ID: " + id);
        }

        return JsonResult.create(JsonResult.STATUS_SUCCESS, dealer);
    }

    @GetMapping("dealerVehicles/{id}")
    public JsonResult findAllDealerVehicles(@PathVariable("id") Integer id) {
        logger.info("DealerController: findById");
        Dealer dealer = this.service.findById(id);
        if (dealer == null) {
            logger.info("Dealer does not exist for ID: " + id);
            return JsonResult.create(JsonResult.STATUS_ERROR, "Dealer does not exist for ID: " + id);
        }

        List<Vehicle> vehicleList = dealer.getVehicles();
        return JsonResult.create(JsonResult.STATUS_SUCCESS, vehicleList);
    }

    @PostMapping
    public @ResponseBody JsonResult save(@RequestBody Dealer dealer) {
        logger.info("DealerController: save");

        if (this.service.save(dealer) == null) {
            logger.info("Dealer was not saved successfully");
            jsonResult = JsonResult.create(JsonResult.STATUS_ERROR, "Dealer was not saved successfully");
            return jsonResult;
        }

        return JsonResult.create(JsonResult.STATUS_SUCCESS, dealer);
    }

    @PutMapping(path = "/{dealerId}")
    public @ResponseBody JsonResult update(@PathVariable("dealerId") int dealerId, @RequestBody Dealer dealer) {
        logger.info("DealerController: update");
        jsonResult = JsonResult.create(JsonResult.STATUS_SUCCESS, dealer);
        if (this.service.update(dealer) == null) {
            logger.info("Dealer not found for ID: " + dealerId);
            jsonResult = JsonResult.create(JsonResult.STATUS_ERROR, "Dealer not found for ID" + dealerId);
            return jsonResult;
        }
        return jsonResult;
    }
}
