package com.dealers.autobuy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dealers.autobuy.json.JsonResult;
import com.dealers.autobuy.model.BidResult;
import com.dealers.autobuy.model.Client;
import com.dealers.autobuy.model.ClientVehicle;
import com.dealers.autobuy.model.Vehicle;
import com.dealers.autobuy.service.ClientService;
import com.dealers.autobuy.service.IClientVehicleService;
import com.dealers.autobuy.service.VehicleService;
import com.dealers.autobuy.uri.ApiEnum;
import com.dealers.autobuy.utils.RestUtils;

/**
 * Rest Controller for bidding
 * @author Ali Golkar
 */
@RestController
@RequestMapping(path = ApiEnum.EndPoints.BID)
public class BidController extends RestUtils<IClientVehicleService> {
    private static final Logger logger = LoggerFactory.getLogger(BidController.class);

    private final VehicleService vehicleService;
    private final ClientService clientService;

    public BidController(VehicleService vehicleService, ClientService clientService) {
        this.vehicleService = vehicleService;
        this.clientService = clientService;
    }

    @PostMapping
    public @ResponseBody
    JsonResult bidForVehicle(@RequestBody ClientVehicle clientVehicle) {
        logger.info("ClientController: save");

        ClientVehicle existingClientVehicle =
                this.service.findByClientIdAndVehicleId(
                        clientVehicle.getClient().getId(),
                        clientVehicle.getVehicle().getId());

        if (existingClientVehicle != null) {
            logger.info("ClientVehicle exists!");
            return JsonResult.create(JsonResult.STATUS_ERROR, "ClientVehicle already exists!");
        }

        Vehicle vehicle = vehicleService.findById(clientVehicle.getVehicle().getId());
        if (vehicle == null) {
            logger.info("Vehicle doe not exists!");
            return JsonResult.create(JsonResult.STATUS_ERROR, "Vehicle doe not exists!");
        }

        Client client = clientService.findById(clientVehicle.getClient().getId());
        if (client == null) {
            logger.info("Client doe not exists!");
            return JsonResult.create(JsonResult.STATUS_ERROR, "Client doe not exists!");
        }

        if (this.service.save(clientVehicle) == null) {
            logger.info("Client was not saved successfully");
            return JsonResult.create(JsonResult.STATUS_ERROR, "ClientVehicle was not saved successfully");
        }

        return JsonResult.create(JsonResult.STATUS_SUCCESS, clientVehicle);
    }

    @GetMapping("highestVehicleBid/{vehicleId}")
    public JsonResult findHighestVehicleBidClientById(@PathVariable("vehicleId") Integer vehicleId) {
        logger.info("ClientController: findHighestVehicleBidClientById");
        ClientVehicle clientVehicle = this.service.findTopByVehicleOrderByBidPriceDesc(vehicleId);
        if (clientVehicle == null) {
            logger.info("There is no bid yet for Vehicle ID: " + vehicleId);
            return JsonResult.create(JsonResult.STATUS_ERROR, "There is no bid yet for Vehicle ID: " + vehicleId);
        }

        BidResult bidResult = new BidResult();
        bidResult.setBidPrice(clientVehicle.getBidPrice().toString());
        bidResult.setClientId(clientVehicle.getClient().getId().toString());
        bidResult.setClientName(clientVehicle.getClient().getFirstName() + " " + clientVehicle.getClient().getLastName());
        bidResult.setVehicleId(clientVehicle.getVehicle().getId().toString());
        bidResult.setVehicleName(clientVehicle.getVehicle().getModel());
        bidResult.setDealerId(clientVehicle.getVehicle().getDealer().getId().toString());
        bidResult.setDealerName(clientVehicle.getVehicle().getDealer().getName());

        return JsonResult.create(JsonResult.STATUS_SUCCESS, bidResult);
    }
}
