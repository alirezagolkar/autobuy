package com.dealers.autobuy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.dealers.autobuy.service.DealerService;
import com.dealers.autobuy.service.IVehicleService;
import com.dealers.autobuy.uri.ApiEnum;
import com.dealers.autobuy.utils.RestUtils;

/**
 * Rest Controller for vehicles
 * @author Ali Golkar
 */
@RestController
@RequestMapping(path = ApiEnum.EndPoints.VEHICLE)
public class VehicleController extends RestUtils<IVehicleService> {
    private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

    private final DealerService dealerService;

    public VehicleController(DealerService dealerService) {
        this.dealerService = dealerService;
    }

    @GetMapping("{id}")
    public JsonResult findById(@PathVariable("id") Integer id) {
        logger.info("VehicleController: findById");
        Vehicle vehicle = this.service.findById(id);
        if (vehicle == null) {
            logger.info("Dealer does not exist for ID: " + id);
            return JsonResult.create(JsonResult.STATUS_ERROR, "Dealer does not exist for ID: " + id);
        }

        return JsonResult.create(JsonResult.STATUS_SUCCESS, vehicle);
    }

    @PostMapping
    public @ResponseBody JsonResult save(@RequestBody Vehicle vehicle) {
        logger.info("VehicleController: save");

        Dealer dealer = dealerService.findById(vehicle.getDealer().getId());

        if (dealer == null) {
            return JsonResult.create(JsonResult.STATUS_ERROR, "Dealer does not exist!");
        }

        if (this.service.save(vehicle) == null) {
            return JsonResult.create(JsonResult.STATUS_ERROR, "Vehicle was not saved successfully");
        }

        return JsonResult.create(JsonResult.STATUS_SUCCESS, vehicle);
    }

    @PutMapping(path = "/{vehicleId}")
    public @ResponseBody JsonResult update(@PathVariable("vehicleId") int vehicleId, @RequestBody Vehicle vehicle) {
        logger.info("VehicleController: update");
        jsonResult = JsonResult.create(JsonResult.STATUS_SUCCESS, vehicle);
        if (this.service.update(vehicle) == null) {
            jsonResult = JsonResult.create(JsonResult.STATUS_ERROR, "Vehicle not found for ID" + vehicleId);
            return jsonResult;
        }
        return jsonResult;
    }

    @DeleteMapping(path = "/{vehicleId}")
    public JsonResult delete(@PathVariable("vehicleId") int vehicleId) {
        logger.info("VehicleController: delete");
        jsonResult = JsonResult.create(JsonResult.STATUS_SUCCESS, "Vehicle successfully deleted for ID: " + vehicleId);
        if (this.service.delete(vehicleId) == null) {
            jsonResult = JsonResult.create(JsonResult.STATUS_ERROR, "Vehicle not found for ID: " + vehicleId);
            return jsonResult;
        }
        return jsonResult;
    }
}
