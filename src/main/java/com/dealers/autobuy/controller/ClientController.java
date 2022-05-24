package com.dealers.autobuy.controller;

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
import com.dealers.autobuy.model.Client;
import com.dealers.autobuy.service.IClientService;
import com.dealers.autobuy.uri.ApiEnum;
import com.dealers.autobuy.utils.RestUtils;

/**
 * Rest Controller for clients
 * @author Ali Golkar
 */
@RestController
@RequestMapping(path = ApiEnum.EndPoints.CLIENT)
public class ClientController extends RestUtils<IClientService> {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("{id}")
    public JsonResult findById(@PathVariable("id") Integer id) {
        logger.info("ClientController: findById");
        Client client = this.service.findById(id);
        if (client == null) {
            logger.info("Client does not exist for ID: " + id);
            return JsonResult.create(JsonResult.STATUS_ERROR, "Client does not exist for ID: " + id);
        }

        return JsonResult.create(JsonResult.STATUS_SUCCESS, client);
    }

    @PostMapping
    public @ResponseBody JsonResult save(@RequestBody Client client) {
        logger.info("ClientController: save");

        if (this.service.save(client) == null) {
            logger.info("Client was not saved successfully");
            return JsonResult.create(JsonResult.STATUS_ERROR, "Client was not saved successfully");
        }

        return JsonResult.create(JsonResult.STATUS_SUCCESS, client);
    }

    @PutMapping(path = "/{clientId}")
    public @ResponseBody
    JsonResult update(@PathVariable("clientId") int clientId, @RequestBody Client client) {
        logger.info("ClientController: update");
        jsonResult = JsonResult.create(JsonResult.STATUS_SUCCESS, client);
        if (this.service.update(client) == null) {
            logger.info("Client not found for ID: " + clientId);
            jsonResult = JsonResult.create(JsonResult.STATUS_ERROR, "Client not found for ID" + clientId);
            return jsonResult;
        }
        return jsonResult;
    }
}
